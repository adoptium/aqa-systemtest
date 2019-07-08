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
public class TestSuite009 extends TestCase
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
  
  public TestSuite009() {
	
  }
  public void testItem_0000()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0001()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=2147483647 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0003()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0004()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0005()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0006()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0008()
  {
    rc_boolean = (new BigDecimal("0")).equals("X:92ILS>QE2JLGA5F>7FO8EFGG64L:;10T>UIHPYN1XTH=8:TPQ;SNQJ@E=JY<Q4=X:Y5NF54DNQL7V6GC<");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0009()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0012()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).add(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\1', '\0', '\0', '\234', '\234', '\uFFFF', '8', '\1', '\uFFFF', '8', '\234', '\0', '\234', '\1', '8', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\1', '\uFFFF', '\234', '\234', '\234', '\234', '8', '\0', '\0', '\1', '\1', '\234', '\uFFFF', '8', '\1', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\1', '8', '\0', '8', '\uFFFF', '8', '\0', '8', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '8', '\0', '\0', '\234', '\1', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\0', '\1'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0015()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0016()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0018()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-1"), 1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-32.0", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0025()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0026()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0027()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0028()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0031()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0034()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("0"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0035()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//    }
//  }
  public void testItem_0036()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0037()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0038()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
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
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0040()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0041()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0042()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0043()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0044()
  {
    rc_BigDecimal = (new BigDecimal("-32")).add(new BigDecimal("-32"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-64", rc_BigDecimal.toString());
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("-32")).movePointLeft(1);
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0047()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0048()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0049()
  {
    rc_boolean = (new BigDecimal("32")).equals("AY<V:BQVGT7BXT83OJWD62L<I=?;1BSU08V?0NKBEWA:IYHVCVKGT60B9QNAK08E:3>9W");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0050()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0051()
  {
    rc_long = (new BigDecimal("-3.2")).longValue();
    Assert.assertEquals(-3L, rc_long);
  }
  public void testItem_0052()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0055()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    rc_BigInteger = (new BigDecimal("-3E+1")).toBigInteger();
    Assert.assertEquals("-30", rc_BigInteger.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0058()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-3.2"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
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
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0060()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divideToIntegralValue(new BigDecimal("-3.2"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0061()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0062()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0063()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0064()
  {
    rc_int = (new BigDecimal("0E+2")).compareTo(new BigDecimal("0E+2"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+2")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0069()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).subtract(new BigDecimal("-3.2"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0070()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+1")).hashCode();
//    Assert.assertEquals(-1, rc_int);
//  }
  public void testItem_0071()
  {
    rc_String = (new BigDecimal("-3E+1")).toEngineeringString();
    Assert.assertEquals("-30", rc_String);
  }
  public void testItem_0072()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0076()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483647")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
  public void testItem_0077()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    rc_BigInteger = (new BigDecimal("0.0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0079()
  {
    rc_int = (new BigDecimal("0E-2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0080()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).plus();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0083()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).hashCode();
//    Assert.assertEquals(1240908815, rc_int);
//  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0087()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0088()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0089()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0090()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0091()
  {
    rc_boolean = (new BigDecimal("32")).equals("AR9VE3<QKUYLHIS;AW?7ADLUH86AWDBVC96<<WXKDUASWP<3@XW;UV4BORQLMF<7=4ORI<W9?VU;IQGT");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0092()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).stripTrailingZeros();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0093()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0094()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, 0, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0095()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0096()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E-2147483647"), java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//    }
//  }
//  public void testItem_0097()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.1")).hashCode();
//    Assert.assertEquals(32, rc_int);
//  }
  public void testItem_0098()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0099()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0104()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-31.9", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0106()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("9223372036854775807"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).remainder(new BigDecimal("-9E+18"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("-31.9")).stripTrailingZeros();
    Assert.assertEquals("-31.9", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_int = (new BigDecimal("-31.9")).compareTo(new BigDecimal("-9E+18"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0111()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9E+18")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).max(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("-31.9")).min(new BigDecimal("-31.9"));
    Assert.assertEquals("-31.9", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    rc_BigDecimal_array = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideAndRemainder(new BigDecimal("-31.9"), new MathContext("precision=0 roundingMode=CEILING"));
  }
  public void testItem_0116()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
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
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0118()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("320.0E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0121()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-9E+18")).divideAndRemainder(new BigDecimal("-31.9"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0123()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("5E-324")).min(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0124()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("-31.9"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0125()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0126()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-31.9")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0127()
  {
    rc_int = (new BigDecimal("-31.9")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0128()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0130()
  {
    rc_int = (new BigDecimal("-31.9")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0131()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0132()
  {
    rc_BigDecimal = (new BigDecimal("-31.9")).abs();
    Assert.assertEquals("31.9", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    rc_int = (new BigDecimal("31.9")).precision();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0134()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0135()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).multiply(new BigDecimal("-31.9"));
//    Assert.assertEquals("-1.0208E+2147483651", rc_BigDecimal.toString());
//  }
  public void testItem_0136()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).subtract(new BigDecimal("-9223372036854775808"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0137()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("31.9")).hashCode();
//    Assert.assertEquals(9890, rc_int);
//  }
  public void testItem_0138()
  {
    rc_BigDecimal = (new BigDecimal("31.9")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("31.9", rc_BigDecimal.toString());
  }
//  public void testItem_0139()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("-10208.0E+2147483647")).toString();
//    Assert.assertEquals("-1.0208E+2147483651", rc_String);
//  }
  public void testItem_0140()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("J");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0141()
  {
    rc_BigDecimal = (new BigDecimal("-31.9")).divideToIntegralValue(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\0', '\0', '\uFFFF', '8', '8', '\1', '\234', '\234', '\234', '\1', '\1', '8', '\0', '\234', '\234', '\0', '8', '\1', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\234', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '8', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '8', '\234', '\1', '\234', '\234', '8', '\234', '\1', '\0', '\0', '\uFFFF', '\0', '8', '\uFFFF', '8', '\234', '8', '\1', '8', '\uFFFF', '8', '\234', '\uFFFF', '8', '8', '\0', '8', '\0', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\0', '\1', '\234', '\0', '\uFFFF', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0143()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\0', '8', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '8', '8', '8', '8', '\234', '\1', '\234', '8', '\1', '8', '\234', '\uFFFF', '\0', '\234', '8', '8', '\1', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\234', '\1', '\0', '\uFFFF', '\1', '\0', '\1'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("31.9")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0145()
  {
    rc_boolean = (new BigDecimal("31.9")).equals("YBW=VEEGD@0R6TR3;R>6QP1X:MOKO:1HLTD:M=X<GB??MVBCGDVPJ>O;7D8=I9321CQGL96:GJR89MD7CEN18A8AU3PAYMDJ53E>");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0146()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '\1', '8', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\0', '\1'}, 2147483647, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0147()
  {
    rc_BigDecimal = (new BigDecimal("-31.9")).multiply(new BigDecimal("-31.9"));
    Assert.assertEquals("1017.61", rc_BigDecimal.toString());
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("-31.9")).plus(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-31.9", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-10208.0E+2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0150()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-10208.0E+2147483647")).ulp();
//    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
//  }
//  public void testItem_0151()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("1E+2147483647"), 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0152()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0153()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\uFFFF', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0155()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0156()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
//  public void testItem_0157()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("-10208.0E+2147483647")).toEngineeringString();
//    Assert.assertEquals("-102.08E+2147483649", rc_String);
//  }
  public void testItem_0158()
  {
    rc_int = (new BigDecimal("-3E+1")).compareTo(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0159()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs(new MathContext("precision=2147483647 roundingMode=CEILING"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0160()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0161()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).setScale(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0163()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-10208.0E+2147483647")).scale();
//    Assert.assertEquals(-2147483647, rc_int);
//  }
//  public void testItem_0164()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("-10208.0E+2147483647"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0165()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\1', '\0', '\234', '\0', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '8', '8', '\1', '\234', '\0', '8', '8', '\234', '\0', '\0', '\234', '\0', '8', '8', '\1', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '8'}, 0, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0166()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-10208.0E+2147483647")).ulp();
//    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
//  }
//  public void testItem_0167()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("1E+2147483647")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0168()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0169()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).movePointLeft(-2147483648);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0170()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0171()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("QQ8PV8RW;S59A49RVKCTM>RN8XB;SVHP8T3V27RGM5IEFNK1YY@7QHSER@H6DMRBI8VYV:O=CB5OEN:LY>73EI:C3P<HQTEGKL;N", new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0173()
  {
    rc_BigInteger = (new BigDecimal("-3E+1")).unscaledValue();
    Assert.assertEquals("-3", rc_BigInteger.toString());
  }
  public void testItem_0174()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0175()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("9DFM<PAU@HVO0KI34D5PPMECS8OW<A9U?1MOB=<O>A9LFSI@XPXJARMR>3H9T>3GMXO<H@0@CI;36K8=PQB>BIA;=N<=0T<OFYKV");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0176()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483647")).movePointRight(-1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0177()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0178()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-3E+1")).max(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0179()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483616, rc_int);
//  }
  public void testItem_0180()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0181()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).add(new BigDecimal("3.2E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0182()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3.2E-2147483646"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0183()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
//  public void testItem_0184()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("-3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0185()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0186()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("OYW4NY660:UQ<QISPU65I6TR76Q:G9JO;11F:7F5KMR=J2FL89R9:83UT3AR6?NHQDL<7?DAS<WG@HAJW7LDPX@R;RMMU?3EC<TE", new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0187()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0188()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0189()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("320.0E+2147483647")).toBigInteger();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
//  public void testItem_0190()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).subtract(new BigDecimal("3"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0191()
  {
    rc_BigDecimal = (new BigDecimal("3")).abs();
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0192()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_BigDecimal = (new BigDecimal("3")).subtract(new BigDecimal("3"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\uFFFF', '8', '\0', '8', '\0', '8', '\0', '\234', '\1', '\uFFFF', '8', '\234', '\1', '\0', '\1', '\uFFFF', '8', '\1', '\1', '8', '\1', '8', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0195()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3E-2147483647")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0196()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\1', '\1', '8', '\234', '\0', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\uFFFF', '8', '\234', '\1', '\1', '\234', '\1', '8', '\1', '\0', '\234', '\234', '\234', '\1', '\234', '\1', '\234', '\0', '\234', '\0', '8', '8', '\234', '8', '\uFFFF', '8', '\1', '8', '\uFFFF', '\0', '\234', '\234', '\0', '8', '\0', '\0', '\1', '\1', '\uFFFF', '\234', '8', '8', '\0', '\0', '\0', '8', '8', '\234', '\0', '\1', '8', '\1', '\234', '\uFFFF', '8', '\1', '\234', '\0', '8', '8', '\1', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\0', '\0', '\uFFFF', '8', '\1', '\234', '\1', '\234', '\1'}, new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0197()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//    }
//  }
  public void testItem_0198()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0201()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0202()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3.2"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0203()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=0 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).max(new BigDecimal("3E-2147483647"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(";J3S?YQYJ68U@SQ4:HK7Y3GVH7<B:NJ51RQP77KJBKH363T0PH8LNKSK02>Y>DA1?<6GMQ5FB?DDPIU6YPJC2K7>V:80M<2=:IYD");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0206()
  {
    rc_double = (new BigDecimal("3.2")).doubleValue();
    Assert.assertEquals(3.2, rc_double, 0);
  }
  public void testItem_0207()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3E-2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0208()
  {
    rc_boolean = (new BigDecimal("3E-2147483647")).equals("2JY393?5YG<FRAAC<JDC39QK:2?IVB:J49FQC=L@=7I3<83<DVK0L4S5L:A;0PWSBOY3@AV@BG");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0209()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0210()
  {
    rc_float = (new BigDecimal("3E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
//  public void testItem_0211()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("320.0E+2147483647")).longValue();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0212()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0213()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0214()
  {
    rc_String = (new BigDecimal("3E-2147483647")).toString();
    Assert.assertEquals("3E-2147483647", rc_String);
  }
//  public void testItem_0215()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("3E-2147483647")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//    }
//  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("3E-2147483647"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0219()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483647")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0220()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("@SHO4841043TWKJ<RFY@O<L0K=@F:=MGXQH52E7O3BR@TB8JMW@J@60NAK1I@;KNP?A2@>LPRFLVUT4MV2R7DJ0C=6PB5?<9HNT?");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0221()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigIntegerExact();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0224()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    rc_int = (new BigDecimal("3.2")).compareTo(new BigDecimal("3E-2147483647"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0226()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    rc_double = (new BigDecimal("3.2")).doubleValue();
    Assert.assertEquals(3.2, rc_double, 0);
  }
  public void testItem_0228()
  {
    rc_long = (new BigDecimal("3E+1")).longValueExact();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).add(new BigDecimal("3E-2147483647"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("6E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("3E-2147483647"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0232()
  {
    rc_String = (new BigDecimal("3E-2147483647")).toString();
    Assert.assertEquals("3E-2147483647", rc_String);
  }
  public void testItem_0233()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).plus();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    rc_float = (new BigDecimal("3E+1")).floatValue();
    Assert.assertEquals(30.0F, rc_float, 0);
  }
  public void testItem_0237()
  {
    rc_BigDecimal = (new BigDecimal("6E-2147483647")).negate();
    Assert.assertEquals("-6E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).movePointRight(1);
    Assert.assertEquals("10000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    rc_float = (new BigDecimal("1E+12")).floatValue();
    Assert.assertEquals(9.99999995904E11F, rc_float, 0);
  }
  public void testItem_0240()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0241()
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
//    Assert.assertEquals("91.2751677852349%", true, caught);
//    }
//  }
  public void testItem_0242()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_String = (new BigDecimal("10000000000000")).toPlainString();
    Assert.assertEquals("10000000000000", rc_String);
  }
  public void testItem_0244()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483647")).divide(new BigDecimal("2E+308"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0245()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).scaleByPowerOfTen(1);
    Assert.assertEquals("2E+309", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    rc_BigDecimal = (new BigDecimal("2E+309")).plus(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2E+309", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1.00000000000E+12", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    rc_BigDecimal = (new BigDecimal("1.00000000000E+12")).negate(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0250()
  {
    rc_int = (new BigDecimal("2E+308")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0251()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+309")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0252()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0253()
  {
    rc_BigDecimal = (new BigDecimal("-1E+12")).divide(new BigDecimal("-1E+12"), 0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0254()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0255()
  {
    rc_BigDecimal = (new BigDecimal("-1E+12")).divideToIntegralValue(new BigDecimal("-1E+12"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0256()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-6E-2147483647")).toBigInteger();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//    }
//  }
  public void testItem_0257()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).negate();
    Assert.assertEquals("-2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0259()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal_array = (new BigDecimal("2E+309")).divideAndRemainder(new BigDecimal("2E+309"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0263()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0264()
  {
    rc_BigDecimal = (new BigDecimal("2E+309")).ulp();
    Assert.assertEquals("1E+309", rc_BigDecimal.toString());
  }
  public void testItem_0265()
  {
    rc_BigDecimal = (new BigDecimal("2E+309")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0266()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-6E-2147483647")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0267()
  {
    rc_BigDecimal = (new BigDecimal("-2E+308")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-6E-2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("-6E-2147483647")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    rc_BigDecimal = (new BigDecimal("-6E-2147483647")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-6E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0272()
  {
    rc_BigDecimal = (new BigDecimal("-6E-2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("6E-2147483647")).movePointRight(2147483647);
    Assert.assertEquals("6", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    rc_long = (new BigDecimal("6")).longValueExact();
    Assert.assertEquals(6L, rc_long);
  }
  public void testItem_0275()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    rc_BigDecimal = (new BigDecimal("6E-2147483647")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0277()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-6E-2147483647")).divide(new BigDecimal("6"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0278()
  {
    rc_BigDecimal = (new BigDecimal("6")).divide(new BigDecimal("5E-324"), 0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
//  public void testItem_0279()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("-6E-2147483647")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//    }
//  }
  public void testItem_0280()
  {
    rc_BigDecimal = (new BigDecimal("6")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0281()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0282()
  {
    rc_boolean = (new BigDecimal("5E-324")).equals("C9I<EM9EU5WHIIHW@9N3E=J26JKNI91>INGG69KULXHXO:OYJ2KHND7UR8@AFPUJ@AWWS>F");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0283()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("O");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0285()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=0 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0286()
  {
    rc_int = (new BigDecimal("-2147483648")).intValueExact();
    Assert.assertEquals(-2147483648, rc_int);
  }
  public void testItem_0287()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '8', '8', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '8', '\1', '\234', '8', '8', '\0', '\0', '\0', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\1', '8', '8', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '8', '\234', '8', '\234', '\0', '8', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\234', '8', '\1', '\234', '\uFFFF', '8', '\1', '\234', '\0', '\uFFFF'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0289()
  {
    rc_boolean = (new BigDecimal("-2147483648")).equals("07KLUMK<QG2OE?R5=PDTB=M@2OFH0H@D<OFEM6?CACUV3JUBX35QLKBA<UXW68=ID7LCYJG1X:3597TE9GJ9013NC;=4C8>CEX@1");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0290()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
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
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0292()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    rc_BigDecimal = (new BigDecimal("1200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).divide(new BigDecimal("1200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0294()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("-6E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0297()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\0', '8', '\1', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\1', '\1', '\0', '\1', '\1', '\0', '\0', '\234', '\1', '\1', '8', '\0', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\uFFFF', '8', '8', '\1', '\0', '\0', '\0', '\1', '\1', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\0', '\1', '\0', '\0', '\234', '8', '\1', '8', '\uFFFF', '\234'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0300()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0301()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0302()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0303()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\1', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\234', '\1', '\0', '\234', '\234', '8', '\uFFFF', '\1', '\234', '\234', '\234', '\0', '\234', '\1', '\0', '\234', '8', '\0', '\uFFFF', '\234', '\0', '\234', '\1', '\1', '\1', '\0', '\uFFFF', '8', '\1', '\1', '\1', '\234', '\uFFFF', '\0', '\0', '\0', '8', '8', '\234', '\1', '\1', '\uFFFF', '8', '8', '\0', '\0', '8', '\uFFFF', '8', '\0', '8', '\234', '\1', '\0', '\234', '\uFFFF', '8', '8', '\0', '\uFFFF', '\0', '8', '8', '\uFFFF', '\234', '\234', '\234', '\1', '\1', '\1', '8', '\uFFFF', '\234', '\0', '\1', '8', '8', '8', '\1', '\0', '\uFFFF', '\0', '\234'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0311()
  {
    rc_BigInteger = (new BigDecimal("10")).unscaledValue();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.UP);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0314()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0317()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0320()
  {
    rc_long = (new BigDecimal("10")).longValueExact();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0321()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0323()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0325()
  {
    rc_int = (new BigDecimal("10")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0326()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0327()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0329()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0330()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("XCQ52>8TNPV?YI7GQ6V;0B6EFR4=L:WTQ<PXTF7OYW2Y40=L");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0331()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0333()
  {
    rc_int = (new BigDecimal("-2147483648")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0334()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0335()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0337()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0338()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\0', '\1', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\234', '8', '8', '\234', '\uFFFF', '8', '8', '8', '\234', '8', '\0', '8', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\0', '\1', '\1', '\1', '\1', '8', '\234', '\1', '\1', '\234', '\uFFFF', '\1', '\0', '\0', '\0', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '8', '8', '\1', '8', '\234', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\1', '\0', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\0', '8', '8', '\0', '\1', '\0', '8', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\uFFFF'}, 2147483647, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0339()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), 0, java.math.RoundingMode.UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_BigDecimal = (new BigDecimal("-2")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
//  public void testItem_0342()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(-2147483648, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//    }
//  }
  public void testItem_0343()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0345()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0346()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0347()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_String = (new BigDecimal("2")).toString();
    Assert.assertEquals("2", rc_String);
  }
  public void testItem_0349()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0351()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0352()
  {
    rc_int = (new BigDecimal("2")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_short = (new BigDecimal("2")).shortValueExact();
    Assert.assertEquals(2, rc_short);
  }
  public void testItem_0355()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -2147483648, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0356()
  {
    rc_BigDecimal_array = (new BigDecimal("2")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_BigDecimal_array = (new BigDecimal("2")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0359()
  {
    rc_String = (new BigDecimal("2")).toString();
    Assert.assertEquals("2", rc_String);
  }
  public void testItem_0360()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '8', '\0', '\0', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\234', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\0', '8', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\234', '\234', '\1', '\234', '\234', '\1', '8', '\234', '\1', '\234', '\uFFFF', '8', '8', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\234', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\1', '\234', '\1', '\1', '8', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\1', '\uFFFF', '\1', '8', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\234', '8', '\0'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0361()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("2"));
  }
  public void testItem_0362()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(":RN63H:<F?37W@AI:?GUGNEONH2AVS0:A@EUSFHLBUWRMLDXCP1>7:F7TYE<HLN:99G1L4B61YXTF@?5KWYA;SOMBFIHGVJC7O=9");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0365()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '8', '\234', '8', '8', '8', '\uFFFF', '8', '\0', '\uFFFF', '8', '\1', '\1', '\0', '8', '\0', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '8', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '8', '\234', '\1', '\uFFFF', '8', '\1', '\1', '\1', '8', '\uFFFF', '\234', '8', '\1', '\0', '\1', '\234', '\0', '\1', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\1', '8', '8', '\234', '\uFFFF', '8', '8', '\0', '\uFFFF', '\1'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0374()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0375()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0376()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0377()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0378()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0379()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0380()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("82WT64H8N4IU=BVIO8M6;;X52>O?63F@=RS;ON77KF<E5JIB4J8@EQ12VQ;T:43;AEMG1;:VG:@RTB@@IL<RI4>MB@2=J:R5?PQT");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0384()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("-3E+1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0386()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).movePointLeft(0);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0392()
  {
    rc_float = (new BigDecimal("3.2")).floatValue();
    Assert.assertEquals(3.200000047683716F, rc_float, 0);
  }
  public void testItem_0393()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("3.2"));
    Assert.assertEquals("6.4", rc_BigDecimal.toString());
  }
  public void testItem_0394()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0395()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("0RIWL64I6D;<U72QX79L3RORGDS4V@QMW5S>>S;>IO4J@U:OQ403O?:5Y88>5DRUHD>C20JYEKP@6IUVHWG9QS<P7T201RQOUN8F");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0396()
  {
    rc_int = (new BigDecimal("6.4")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0397()
  {
    rc_BigDecimal = (new BigDecimal("6.4")).movePointRight(1);
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0398()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0400()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0401()
  {
    rc_BigDecimal = (new BigDecimal("64")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0403()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).abs();
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("64")).add(new BigDecimal("1"));
    Assert.assertEquals("65", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_String = (new BigDecimal("3.2")).toPlainString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0406()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0407()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).plus();
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("65")).max(new BigDecimal("64"));
    Assert.assertEquals("65", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0412()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("65")).add(new BigDecimal("65"));
    Assert.assertEquals("130", rc_BigDecimal.toString());
  }
//  public void testItem_0414()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0415()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0417()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).abs();
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).movePointLeft(2147483647);
    Assert.assertEquals("9.223372036854775807E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_int = (new BigDecimal("130")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0420()
  {
    rc_float = (new BigDecimal("9223372036854775807")).floatValue();
    Assert.assertEquals(9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0421()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).ulp();
    Assert.assertEquals("1E+18", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).divideToIntegralValue(new BigDecimal("1E+18"));
    Assert.assertEquals("9", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    rc_int = (new BigDecimal("1E+18")).scale();
    Assert.assertEquals(-18, rc_int);
  }
  public void testItem_0425()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigInteger();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
//  public void testItem_0426()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9.223372036854775807E-2147483629")).remainder(new BigDecimal("9.223372036854775807E-2147483629"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//    }
//  }
  public void testItem_0427()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0429()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("-9223372036854775808"), -1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("9.223372036854775807E-2147483629")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointLeft(0);
    if (JavaSpecVersionChecker.isJDK13OrNewer()) {
    	Assert.assertEquals("0E+1", rc_BigDecimal.toString());
    } else {
    	Assert.assertEquals("0", rc_BigDecimal.toString());
    }
  }
  public void testItem_0433()
  {
    rc_BigInteger = (new BigDecimal("9")).toBigIntegerExact();
    Assert.assertEquals("9", rc_BigInteger.toString());
  }
  public void testItem_0434()
  {
    rc_BigDecimal = (new BigDecimal("9")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\0', '\0', '\0', '\234', '\234', '\234', '8', '\234', '\uFFFF', '\1', '\0', '\1', '\1', '\0', '\1', '8', '8', '\0', '\0', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\234', '\0', '8', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\234', '8', '8', '\0', '\1', '\234', '\0', '\1', '\uFFFF', '\0', '\0', '\0', '8', '8', '8', '8', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\234', '\234', '\0', '8', '\234', '\234', '\1', '\234', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\234', '\uFFFF', '8', '8', '\0', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\0', '8', '8', '\uFFFF'}, -1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0436()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1135879015891"), 2147483647, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0437()
  {
    rc_BigDecimal = (new BigDecimal("9E-2147483629")).negate();
    Assert.assertEquals("-9E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("9E-2147483629")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_float = (new BigDecimal("9")).floatValue();
    Assert.assertEquals(9.0F, rc_float, 0);
  }
  public void testItem_0440()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
//  public void testItem_0441()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1135879015891")).hashCode();
//    Assert.assertEquals(2107853717, rc_int);
//  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("-9E-2147483629")).subtract(new BigDecimal("9E-2147483629"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1.8E-2147483628", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    rc_BigDecimal_array = (new BigDecimal("-9E-2147483629")).divideAndRemainder(new BigDecimal("-9E-2147483629"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("B734:1O8OB9?=FDFPFN?5=TAM:746688E2QTERBSM2M1HGY81ESJS4S==R<SPFT4PCM>POCT77;F41EQE=V@PU:TQOQV;X?L7BRK");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0446()
  {
    rc_double = (new BigDecimal("9E-2147483629")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0447()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0448()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0450()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\234', '8', '\234', '\0', '\234', '\1', '\1', '\0', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\0', '\0', '\1', '8', '\1', '\0', '\1', '8', '\1', '8', '\0', '8', '\1', '8', '\0', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\1', '\234', '\234', '8', '\234', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\234', '\234', '\1', '\1', '\234', '\1', '\234', '\uFFFF', '\234', '\1', '\234', '\0', '\234', '\234', '\234', '\1', '\uFFFF', '\234', '8', '\1', '8', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\0', '\1', '\uFFFF', '\1', '\234', '\0', '8', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\1', '\0', '8', '\uFFFF', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0452()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\234', '8', '\0', '\1', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\0', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\1', '\0', '\0', '\uFFFF', '\234', '8', '\234', '\1', '\1', '\0', '8', '\234', '\1', '\1', '8', '8', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\234', '\0', '\1', '\1', '\1', '8', '\1', '\1', '\uFFFF', '\234', '8', '\0', '\1', '8', '\234', '\uFFFF', '\0', '\234', '\234', '\1', '\uFFFF', '\234', '\0', '8', '\1', '\1', '\1', '\0', '\0', '\1', '\1', '8', '\1', '\0', '8', '\1', '8', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\234', '\1', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0453()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).movePointRight(-1);
    Assert.assertEquals("100000000000", rc_BigDecimal.toString());
  }
  public void testItem_0454()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1E+12")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0455()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).negate();
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).pow(1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '\234', '\0', '\0', '8', '\0', '\0', '8', '\234', '8', '\0', '\234', '8', '\uFFFF', '\234', '8', '\234', '8', '\234', '\uFFFF', '\uFFFF', '8', '8', '\234', '8', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '8', '\234', '8', '\0', '\uFFFF', '8', '\uFFFF', '8', '\0', '\0', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\0', '\0', '\1', '8', '\234', '\0', '\234', '\1', '\234', '\234', '\1', '\uFFFF', '8', '8', '\uFFFF', '\1', '\0', '\234', '8', '8', '\234', '\0', '8', '\0', '\1', '\234', '8', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\1', '\uFFFF'}, 0, 1);
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0459()
  {
    rc_BigDecimal = (new BigDecimal("8")).min(new BigDecimal("3.2E+2"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    rc_int = (new BigDecimal("1E+12")).intValue();
    Assert.assertEquals(-727379968, rc_int);
  }
  public void testItem_0461()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus(new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).ulp();
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0465()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\0', '\0', '\0', '\0', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\1', '\1', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\0', '8', '\1', '\234', '\1', '8', '\0', '\234', '\1', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '8', '8', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\1', '8', '8', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '8', '\1', '\234', '\1', '\234', '8', '\1', '\0', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\1', '\0', '\1', '8', '8', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\234', '8', '8', '\uFFFF', '8', '8', '\0', '\1', '\uFFFF', '\0', '\1', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0466()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).multiply(new BigDecimal("1E+12"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+24", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    rc_byte = (new BigDecimal("8")).byteValueExact();
    Assert.assertEquals(8, rc_byte);
  }
  public void testItem_0469()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\1', '\0', '\0', '8', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\234', '\234', '\uFFFF', '\1', '\1', '\0', '\234', '\uFFFF', '8', '\1', '\0', '\0', '\1', '\uFFFF', '\1', '\234', '8', '\1', '\1', '\234', '8', '\1', '\1', '\234', '\uFFFF', '\1', '\0', '\234', '\1', '\0', '\0', '8', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\234', '8', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '8', '\234', '\uFFFF', '8', '\1', '8', '8', '\0', '\1', '\0', '\uFFFF', '\234', '8', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\234', '\uFFFF', '8', '8', '\0', '\234', '8', '\0', '\234', '\1', '\1', '\0'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0470()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0471()
  {
    rc_BigDecimal = (new BigDecimal("1E+24")).remainder(new BigDecimal("1E+24"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+24", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0473()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E+2")).divideAndRemainder(new BigDecimal("3.2E+2"));
  }
  public void testItem_0474()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3.2E+2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).setScale(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("9000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    rc_BigInteger = (new BigDecimal("9000000000000000000")).toBigIntegerExact();
    Assert.assertEquals("9000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0478()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000")).abs();
    Assert.assertEquals("9000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_String = (new BigDecimal("9E+18")).toString();
    Assert.assertEquals("9E+18", rc_String);
  }
  public void testItem_0481()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("8"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0482()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).negate();
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0484()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("8")).hashCode();
//    Assert.assertEquals(248, rc_int);
//  }
  public void testItem_0485()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).negate();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("8")).plus();
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("9E+18"), 0, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0489()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0490()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0491()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.1")).divide(new BigDecimal("9E+18"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0492()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\1', '8', '8', '8', '8', '\uFFFF', '\uFFFF', '8', '8', '\1', '\1', '\0', '\0', '8', '8', '\234', '8', '\uFFFF', '8', '\234', '8', '\1', '8', '8', '8', '\1', '8', '\1', '\0', '\1', '\1', '\1', '\234', '\234', '8', '\234', '\234', '8', '8', '\0', '8', '8', '\1', '8', '\0', '\0', '\234', '\1', '\1', '\uFFFF', '\1', '\234', '\1', '\1', '\0', '\1', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\0', '8', '\1', '8', '\234', '\0', '\234', '\1', '8', '8', '\234', '\1', '\234', '8', '\0', '\1', '\1', '\uFFFF', '\1', '\1', '\234', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("-0.1"), -1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.1")).divide(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).remainder(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).subtract(new BigDecimal("0.0"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0499()
  {
    rc_short = (new BigDecimal("0.0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0500()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0502()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0504()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0505()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).multiply(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0506()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).abs();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '8', '8', '\234', '\234', '8', '\1', '8', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\uFFFF', '8', '\234', '8', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\0', '8', '8', '\1', '\1', '8', '\1', '\234', '\0', '\0', '\1', '\uFFFF'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).plus();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\0', '\0', '\0', '\1', '8', '8', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\0', '8'}, -1, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0511()
  {
    rc_float = (new BigDecimal("320.0E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0512()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -1, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0513()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0514()
  {
    rc_int = (new BigDecimal("0.0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0515()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).multiply(new BigDecimal("0"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0516()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0517()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("V98QYUC4E>9;B=WLJNXHAF<7=MNVM1JP:5GGHNYMSSYGDKXNM0KR<J>RP30SSF@HF6P:3CHGPDM1CCEJH>3MW?C0X3UILWFW4@NR");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0518()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).min(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0520()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0522()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0523()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("S9TP;;4ARF75NYJY9LX89714DP0<1PP9JR7UXQQR7=H9@RRYPNO?QX@0KB>JB1G8AK8O6BTY07QIA=LH@6;W2BH<GAB7A2PJ<I", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0524()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
//  public void testItem_0525()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.1")).hashCode();
//    Assert.assertEquals(32, rc_int);
//  }
  public void testItem_0526()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0527()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0.1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0528()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0529()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("320.0E+2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0530()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).remainder(new BigDecimal("00.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0532()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(1);
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0533()
  {
    rc_BigInteger = (new BigDecimal("0.1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0534()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).add(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    rc_BigDecimal_array = (new BigDecimal("0.1")).divideAndRemainder(new BigDecimal("3"));
  }
  public void testItem_0536()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).max(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0539()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0540()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0541()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0544()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0546()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("0.1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0547()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0548()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0.1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0549()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("0.1")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0550()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0551()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0552()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0557()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0558()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-2147483648"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0560()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0561()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0563()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0564()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483647")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
  public void testItem_0565()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0567()
  {
    rc_byte = (new BigDecimal("0E-2147483647")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0568()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0569()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("-2147483648"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0570()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).min(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0571()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0572()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0573()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0576()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0577()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0578()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\uFFFF', '\1', '\1', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '8', '8', '\1', '\1', '\1', '\0', '\234', '\uFFFF', '\1', '\1', '\0', '\1', '\234', '\0', '\234', '\1', '\1', '\234', '\0', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0581()
  {
    rc_String = (new BigDecimal("3E+1")).toString();
    Assert.assertEquals("3E+1", rc_String);
  }
  public void testItem_0582()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).min(new BigDecimal("32"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0584()
  {
    rc_int = (new BigDecimal("0E-2147483647")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0585()
  {
    rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0586()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0590()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_short = (new BigDecimal("-3E+1")).shortValueExact();
    Assert.assertEquals(-30, rc_short);
  }
  public void testItem_0592()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0593()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0594()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0595()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0596()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0597()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0598()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("3E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0601()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0602()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0603()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("0"), java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0604()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("3E+1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("KF6W<S40:C0<OOVPA>X41<KFK>BK5KY@SRJFMVKKFQI6R3RC3SK=:CJJFR@YY5C2O");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0608()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0610()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0611()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).negate();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0614()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\1', '\0', '8', '\234', '8', '\uFFFF', '8', '\uFFFF', '8', '8', '8', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\1', '8', '\1', '\1', '\1', '\1', '\234', '8', '8', '8', '8', '\1', '\234', '\uFFFF', '\234', '\0', '\234', '\234', '\234', '\1', '8', '\234', '8', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\234', '8', '\0', '\uFFFF', '\1', '\1', '\0', '\0', '8', '\0', '\1', '8', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\234', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\234', '\1', '\1', '8', '8', '8', '\1', '8', '\uFFFF', '8', '\0', '8', '\234', '\234', '\234', '\1', '\1', '\234', '8'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0615()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).min(new BigDecimal("3E+1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0618()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '8', '\234', '\1', '\234', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\0', '\234', '\234', '\1', '\0', '8', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\0', '8', '\0', '\0', '\1', '8', '\0', '\uFFFF', '\1', '\0', '\234', '\0', '\234', '\1', '\1', '8', '\1', '\0', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\234', '8', '\0', '8', '8', '\234', '\0', '\234', '\1', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF'}, 0, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0619()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0620()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
//  public void testItem_0624()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("3E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0625()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).abs();
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0627()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0628()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0629()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2147483647")).divide(new BigDecimal("3E+2147483647"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0630()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0631()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0632()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0633()
  {
    rc_String = (new BigDecimal("1E+12")).toString();
    Assert.assertEquals("1E+12", rc_String);
  }
  public void testItem_0634()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0635()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2147483647")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0636()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(":J=7Q3=CS8GT><VDG91PP9:LN?1L2SBPWWAH48GRIYNR:V6PHJ7RH<?>TUOX3FC6PYNI4J8:=IGTV6C3J?X91JPMV=EM8NCQU0NJ");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0637()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("3E+2147483647")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0638()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1E+12"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0640()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("3E+2147483647"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
  }
  public void testItem_0641()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0642()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0643()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).movePointRight(-1);
    Assert.assertEquals("100000000000", rc_BigDecimal.toString());
  }
//  public void testItem_0644()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("3E+2147483647")).remainder(new BigDecimal("100000000000"));
//    Assert.assertEquals("3E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0645()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\0', '\0', '\1', '\0', '8', '\0', '\1', '\0', '\234', '\uFFFF', '\234', '8', '\234', '\0', '\1', '\0', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '8', '8', '8', '\234', '\234', '\234', '8'}, -1, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0646()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0647()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2147483647")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0648()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("3E+2147483647"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0649()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0650()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).multiply(new BigDecimal("1E+12"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+24", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("YSHBDU5<TX@<F0Q?PMQ9=QC4HQ0NM5G;VEE9?>TMFTY<FFTIJAXNBNY26GWWY?WW003Q8?=8854E?Q7:?U<PX:J57R99EK5VV:PO");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0656()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).divide(new BigDecimal("0"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0659()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0660()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0661()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0662()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0663()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
//  public void testItem_0664()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0665()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0667()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0668()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0669()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("WA>@I46Q1TK8<;=01EAXMJAYGJ90NDX71Q>2P7G8JIPEA41J?6@YRJUGBUR:54Q2J3@THXAFOSN><X9D0Q6N8Q?=SK3A:AILMOQH");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).pow(1);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0672()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0673()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0674()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).movePointRight(-1);
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0677()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).divide(new BigDecimal("1E+12"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0678()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+12")).divide(new BigDecimal("3E+1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0679()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E+12"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0682()
  {
    rc_int = (new BigDecimal("1E+12")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0683()
  {
    rc_int = (new BigDecimal("0E+12")).scale();
    Assert.assertEquals(-12, rc_int);
  }
//  public void testItem_0684()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0685()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0687()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+12")).divideAndRemainder(new BigDecimal("320.0E+2147483647"));
  }
  public void testItem_0688()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\234', '\uFFFF', '\234', '\0', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\0', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '8', '\1', '8', '\234', '\234', '\0', '\0', '8', '\uFFFF', '\1', '\1', '\1', '\0', '\1', '\234', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0689()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0690()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0691()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("0E+12"), 2147483647, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0692()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).plus();
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).subtract(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0697()
  {
    rc_boolean = (new BigDecimal("-1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0701()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0703()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3E+2147483647")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0704()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+12")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0705()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\uFFFF', '8', '\1', '\0', '\1', '\0', '\234', '8', '\0', '\0', '\0', '\234', '8', '\0', '\234', '\0', '\1', '\234', '\1', '\1', '\234', '\0', '8', '8', '\1', '\0', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\234', '8', '\1', '\234', '\1', '\0', '\234', '\0', '\1', '\1', '\1', '\1', '8', '8', '\1', '\1', '\234', '\234', '\234', '\234', '\0', '\uFFFF', '\234', '\0', '\1', '\234', '\1', '\uFFFF', '\0', '\1', '8', '8', '\uFFFF', '\0', '\234', '8', '8', '8', '\1', '\234', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\1', '\1', '8', '\1', '\1', '\1', '8', '\234', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0706()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0710()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0711()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0712()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0713()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3E+2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0714()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0717()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0721()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0722()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0723()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0725()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0726()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0727()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0730()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0734()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0735()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0736()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("68F8>1RAE;<F>Y01B>1:49HP<W27:EO=>7N;M?ON25ACV6;Y?3V12@@><3U869V6C225Y8UFGGRMWDQ10UX");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0737()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0738()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\1', '\234', '\1', '8', '\1', '8', '8', '\1', '8', '\234', '\1', '\0', '\1', '\0', '\1', '\1', '8', '\234', '\0', '8', '8', '8', '\234', '8', '\1', '\234', '\234', '\1', '\1', '\1', '8', '\0', '\0', '\uFFFF', '\1', '\1', '\1', '\234', '8', '\1', '\0', '\0', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '8', '\0', '\0', '8', '\1', '\1', '8', '\1', '\234', '\1', '\1', '\uFFFF', '\234', '\234', '\234', '8', '\234', '\234', '\1', '8', '\234', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\1', '\1', '\234', '\234'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0739()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-33", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0742()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0743()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0744()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0745()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0746()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0747()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("10"), 0, 1);
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0751()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\234', '\1', '\1', '\1', '\234', '\234', '\1', '\1', '8', '\234', '8', '\1', '\0', '\1', '8', '\234', '8', '\234', '\0', '8', '\234', '\234', '\uFFFF', '\1', '8', '\1', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\234', '8', '\0', '\1', '\234', '\0', '\234', '\1', '8', '\1', '8', '\uFFFF', '8', '\0', '8', '8', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\0', '\234', '\1', '8', '\0', '\234', '\1', '\uFFFF', '\234', '\234', '\0', '\234', '\234', '8', '\0', '\0', '8', '\uFFFF', '8', '\234', '8', '\0', '\uFFFF', '\0', '\1', '\1', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\0', '8', '\1', '\234'}, -2147483648, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0752()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0753()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0754()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("09:MEHB>6E9C4=83VYB7?SFFWE6UWF0A1AP2T1<H2?4A08BO70HG@P51B07WAQCYD<LQRBB3I8A::L6R?1YYSSSFHQ3HW9C8<3O8", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0755()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0756()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0757()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0761()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0762()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0764()
  {
    rc_float = (new BigDecimal("3")).floatValue();
    Assert.assertEquals(3.0F, rc_float, 0);
  }
//  public void testItem_0765()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0766()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("3"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_BigDecimal_array = (new BigDecimal("3E-2147483647")).divideAndRemainder(new BigDecimal("3"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("3"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0773()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0774()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("3"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0779()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0780()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0783()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0784()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0786()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0787()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0788()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0789()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0790()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0791()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("C2RKFICG:I;K4E4>4BIS@32PGM4FMFF53<");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0792()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("320.0E+2147483647"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0793()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0796()
  {
    rc_BigInteger = (new BigDecimal("-3E+2")).toBigIntegerExact();
    Assert.assertEquals("-300", rc_BigInteger.toString());
  }
//  public void testItem_0797()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0798()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0799()
  {
    rc_boolean = (new BigDecimal("1")).equals("AD4:38=NVSP?WEQ2QTT5SXXQB6BS?VGA6RM<G9GUSP3CVSLJ:>D@OBN2FPJ0OXTHEJ0URP9U79YV3PBLBS>W6UW6@HTMOP");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0800()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("3E-2147483647"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0801()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).multiply(new BigDecimal("3E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).stripTrailingZeros();
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_double = (new BigDecimal("-3E+2")).doubleValue();
    Assert.assertEquals(-300.0, rc_double, 0);
  }
  public void testItem_0805()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '8', '8', '8', '\0', '8', '\0', '\234', '\uFFFF', '8', '8', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\0', '\0', '\234', '\uFFFF', '\234', '\1', '\1', '8', '\1', '8', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '8', '8', '\1', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0808()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("10"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).movePointLeft(1);
    Assert.assertEquals("214748364.7", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    rc_short = (new BigDecimal("2")).shortValueExact();
    Assert.assertEquals(2, rc_short);
  }
  public void testItem_0815()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.5", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    rc_BigInteger = (new BigDecimal("2")).toBigIntegerExact();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0817()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\1', '\1', '8', '\1', '\uFFFF', '\uFFFF', '8', '8', '\1', '8', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\234', '\uFFFF', '8', '8', '\0', '8', '\234', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\1', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\234', '\1', '8', '\1', '\234', '\1', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\0', '8', '\234', '8', '\uFFFF', '\uFFFF', '8', '8', '\1', '\1', '\1', '8', '\uFFFF', '\0', '\0', '\234', '\1', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '8', '8', '\uFFFF', '8'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0818()
  {
    rc_long = (new BigDecimal("2")).longValue();
    Assert.assertEquals(2L, rc_long);
  }
//  public void testItem_0819()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("214748364.7")).setScale(-2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//    }
//  }
  public void testItem_0820()
  {
    rc_BigDecimal = (new BigDecimal("214748364.7")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0821()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '8', '\1', '\1', '\1', '\0', '\0', '\uFFFF', '\234', '\234', '8', '\0', '8', '8', '\0', '8', '\1', '\0', '\1', '\234', '\uFFFF', '8', '\1', '\234', '8', '\1', '\0', '\0', '\1', '\1', '\0', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '8', '8', '\234', '\uFFFF', '\1', '\234', '\234', '8', '\1', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\1', '8', '8', '\234', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\0', '\0', '\0', '\1', '\uFFFF', '\234', '8', '8', '\uFFFF', '\234', '\234', '\1', '\1', '\0', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0822()
  {
    rc_int = (new BigDecimal("2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0823()
  {
    rc_BigDecimal = (new BigDecimal("2")).abs();
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("JKL5ELBF9B4BFDS=L;H7JHX=1D?52>OLG=0A:EH=1OT7VJ>VK6DLA6:SXVA@WOGY?95XUGE?L26XBM2XY81CPX?=879YK", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0825()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate(new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    rc_int = (new BigDecimal("2")).intValue();
    Assert.assertEquals(2, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0827()
  {
    rc_boolean = (new BigDecimal("0.5")).equals("G5:>O=T0X;RB:63?Y=TOVV3Q@E3209U0T?C>MDDCD@:IDE;PUFMU");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0828()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).remainder(new BigDecimal("2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0829()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_BigDecimal_array = (new BigDecimal("-2147483647")).divideAndRemainder(new BigDecimal("2147483647"));
  }
  public void testItem_0831()
  {
    rc_BigDecimal = (new BigDecimal("2")).remainder(new BigDecimal("0.5"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0832()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("V3UQPC8??L4I6?65MBGC7@N3U2NF;V3KFLLOR64E9:<;9=815V9WF?7RAS>=@1HSKPSQ@5=S19M9XB4VVJHIKG09YPVU9DSP3NO;");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0834()
  {
    rc_int = (new BigDecimal("2")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0835()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(1);
    Assert.assertEquals("320.0", rc_BigDecimal.toString());
  }
  public void testItem_0838()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0839()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\1', '8', '\234', '\1', '\1', '\234', '\0', '\0', '\0', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\0', '8', '\1', '\234', '\234', '\234', '\0', '\0', '8', '8', '\0', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\234', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\1', '\0', '\1', '\uFFFF', '8', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\1', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\0', '\1', '\0', '\234', '\uFFFF', '\1', '\0', '\234', '\0', '\uFFFF', '\234', '8', '\1', '\234', '\234', '8', '\uFFFF', '\1', '\1', '\0', '\234', '\0', '\234', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '8', '8', '8', '\0'}, 2147483647, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0840()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0841()
  {
    rc_BigDecimal_array = (new BigDecimal("2E+308")).divideAndRemainder(new BigDecimal("3.2E+2"));
  }
  public void testItem_0842()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).subtract(new BigDecimal("2E+308"));
    Assert.assertEquals("0E+308", rc_BigDecimal.toString());
  }
  public void testItem_0843()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).plus();
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).scaleByPowerOfTen(0);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0845()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("FCVOP13E;W:7R=HN@BNUESUX4X<J78KK7;;SK6UCKJX6G??4O:F5PF=WFRR7F762WRXIN;KR1EFJYK");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0846()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).add(new BigDecimal("2147483647"));
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002147483647", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    rc_long = (new BigDecimal("2147483647")).longValueExact();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0848()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002147483647")).divideAndRemainder(new BigDecimal("0E+308"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0849()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=1 roundingMode=DOWN", rc_MathContext.toString());
  }
//  public void testItem_0850()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002147483647"), 2147483647, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0851()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0852()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("1135879015891"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0853()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("1135879015891"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0854()
  {
    rc_int = (new BigDecimal("2147483647")).intValue();
    Assert.assertEquals(2147483647, rc_int);
  }
//  public void testItem_0855()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1135879015891")).hashCode();
//    Assert.assertEquals(2107853717, rc_int);
//  }
  public void testItem_0856()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("7V9DV=0V:GOTUN3LDKSSA1L;B@ULTDY<0GVDFR:WJK;UQS6GXXLR<HG87M>5QPNU>IKO:>7E@KJ9JBE:9ED=JS2=6>?Y@TVUFILP");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0859()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0861()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0862()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(2147483647, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0863()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0864()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0866()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0867()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0868()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).divideToIntegralValue(new BigDecimal("1135879015891"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0869()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0870()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0871()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0872()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0873()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).scaleByPowerOfTen(0);
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0875()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0876()
  {
    rc_boolean = (new BigDecimal("-1")).equals("54IC2PQK8L;KFWG<@RW;WV:4CCXS:9O5:9S0N3GGF:DFVX9=:N:@KCL:A3;IN@W5PI=GA=0Q");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0877()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0878()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).movePointLeft(1);
    Assert.assertEquals("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0881()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0882()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '8', '\0', '8', '\uFFFF', '8', '\uFFFF', '\234', '8', '8', '\234', '\uFFFF', '\234', '\234', '8', '\234', '\0', '8', '\1', '\0', '8', '8', '\1', '\0', '\0', '\uFFFF', '\1', '\1', '8', '\234', '\1', '\1', '\234', '\0', '\234', '\1', '\1', '\0', '8', '\1', '\234', '\1', '\1', '\uFFFF', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0884()
  {
    rc_BigInteger = (new BigDecimal("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).unscaledValue();
    Assert.assertEquals("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0885()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    rc_BigInteger = (new BigDecimal("-1E+12")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0890()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0892()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0893()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0894()
  {
    rc_float = (new BigDecimal("320.0E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).movePointRight(1);
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
//  public void testItem_0896()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0897()
  {
    rc_BigDecimal = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).abs();
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0898()
  {
    rc_BigDecimal = (new BigDecimal("-1E+12")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0899()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '8', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0900()
  {
    rc_BigDecimal = (new BigDecimal("-1E+12")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0901()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0902()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0903()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\uFFFF', '8', '8', '\uFFFF', '8', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\1', '8', '8', '\1', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\1', '\0', '\0', '\234', '8', '\0', '\uFFFF', '8', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\234', '8', '\0', '\1', '\1', '\0', '8', '\0', '\1', '\1', '\234', '\1', '\1', '\0', '\1', '\1', '\0', '8', '\234', '\234', '\1', '\1', '\1', '\uFFFF', '\234', '8', '8', '\1', '\1', '8', '\0', '\0', '\0', '\0', '\1', '\1', '\uFFFF', '\0', '\234', '8', '\0', '\234', '\1', '\1', '8', '8', '\234'}, -2147483648, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0904()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1E+12"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0905()
  {
    rc_BigDecimal = (new BigDecimal("-1E+12")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0906()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).stripTrailingZeros();
	Assert.assertEquals(0E+12, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0907()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0908()
  {
    rc_boolean = (new BigDecimal("0E+12")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0909()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-1E+12")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0910()
  {
    rc_int = (new BigDecimal("0E+12")).compareTo(new BigDecimal("0E+12"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0911()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0912()
  {
    rc_int = (new BigDecimal("0E+12")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).subtract(new BigDecimal("0E+12"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0916()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0E+12"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0917()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).subtract(new BigDecimal("0E+12"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_BigInteger = (new BigDecimal("0E+12")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0921()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).subtract(new BigDecimal("0E+12"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0923()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0924()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 1, 0, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0925()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("YS@RH");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0926()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0927()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0928()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0E+12"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0929()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).max(new BigDecimal("0E+12"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0930()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0933()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("0E+12"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0934()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("320.0E+2147483647")).toBigInteger();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0935()
  {
    rc_int = (new BigDecimal("320.0E+2147483647")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0936()
  {
    rc_int = (new BigDecimal("0E+12")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0939()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("PWJ6KL1HKSG5MGN:WV0AJ<NA0HD><MVWE", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0940()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0941()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0942()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\0', '8', '\234', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0943()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(-1);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    rc_BigDecimal = (new BigDecimal("-10")).divide(new BigDecimal("-1"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("0"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("9223372036854775807")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0948()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0951()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0952()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3.2E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0953()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3.2E-2147483646")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0954()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\0'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0955()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("10")).hashCode();
//    Assert.assertEquals(310, rc_int);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0956()
  {
    rc_boolean = (new BigDecimal("0E+12")).equals("OU:@=T05435?0G<WOGX7N;IX597J??SOX>NUDS8OV2K:DO1EC2MKYK5B<B<RP;G3NEQNMWFV4BYX3S:8W;1474WQ>5:?VQ1HQ7G=");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0957()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
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
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0959()
  {
    rc_int = (new BigDecimal("0E+12")).compareTo(new BigDecimal("10"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0960()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("OR67V5ML3W7F0XHAAEO@IVY<BC8O4IF8YA?AW=JT61U5S?KWJTEDH<USC4FSBLYQ<5NUDBEGSP3C=09<BYR>WU6JS22B5<R2;DY6");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0961()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0964()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0965()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0966()
  {
    rc_int = (new BigDecimal("8")).intValue();
    Assert.assertEquals(8, rc_int);
  }
  public void testItem_0967()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=0 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0971()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0972()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3E+1"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0973()
  {
    rc_float = (new BigDecimal("8")).floatValue();
    Assert.assertEquals(8.0F, rc_float, 0);
  }
  public void testItem_0974()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).multiply(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0975()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0976()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).stripTrailingZeros();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0979()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0981()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).min(new BigDecimal("3E+1"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("-9E+18"));
    Assert.assertEquals("-8.99999999999999997E+18", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_BigDecimal_array = (new BigDecimal("8")).divideAndRemainder(new BigDecimal("-8.99999999999999997E+18"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
//  public void testItem_0984()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("8")).divideAndRemainder(new BigDecimal("1E-2147483644"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
//  public void testItem_0985()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("8")).hashCode();
//    Assert.assertEquals(248, rc_int);
//  }
  public void testItem_0986()
  {
    rc_String = (new BigDecimal("1E-2147483644")).toEngineeringString();
    Assert.assertEquals("100E-2147483646", rc_String);
  }
  public void testItem_0987()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).multiply(new BigDecimal("-8.99999999999999997E+18"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+20", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_int = (new BigDecimal("8")).intValueExact();
    Assert.assertEquals(8, rc_int);
  }
  public void testItem_0990()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0991()
  {
    rc_boolean = (new BigDecimal("8")).equals("F6>EE:4VF2DMRR5XTXT00M>7FA;6GMEFSGJB0MGV54VXDN1CU247VWOHA=LU07IX4CXNXL17WKMUK9:6XLNNOTPYU2@65;1EVABS");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0992()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0994()
  {
    rc_int = (new BigDecimal("3.2E+2")).intValue();
    Assert.assertEquals(320, rc_int);
  }
  public void testItem_0995()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\1', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '8', '8', '\0', '\uFFFF', '\uFFFF', '8', '\0', '8', '\uFFFF', '\234', '\234', '\0', '\1', '\uFFFF', '8', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\234', '\0', '\1', '8', '\234', '\1', '\1', '\234', '\uFFFF', '\1', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\234', '8', '8', '\0', '8', '\uFFFF', '\234', '8', '8', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\0', '8', '\0', '8', '\0', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\234', '8', '\234', '\1', '\1', '\234', '8', '8', '\234', '\1', '\0', '\1', '8', '8', '\0', '\1', '\0', '8', '\234', '\uFFFF', '\1', '\234', '\0', '\234', '8', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0996()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0998()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).min(new BigDecimal("3.2E+2"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
}
