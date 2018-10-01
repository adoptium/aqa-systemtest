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
public class TestSuite011 extends TestCase
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
  
  public TestSuite011() {
	
  }
  public void testItem_0000()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483646")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0001()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0004()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).multiply(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+12", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '8', '\1', '8', '\uFFFF', '\0', '\1', '8', '\0', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\0', '\1', '8', '8', '\0', '8', '\234', '\234', '\1', '\uFFFF', '8', '8', '\234', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '8', '8', '\uFFFF', '8', '\234', '8', '\234', '8', '\uFFFF', '\234', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\0', '\234', '\234', '\234', '\uFFFF', '\0', '8', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '8', '\234', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\234', '\234', '\uFFFF', '\0', '\1'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483646")).remainder(new BigDecimal("3E+12"));
    Assert.assertEquals("0E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0009()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("3E+12"));
  }
  public void testItem_0010()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+12")).divide(new BigDecimal("1"), 1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483646")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("0E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0013()
  {
    rc_int = (new BigDecimal("3.2")).compareTo(new BigDecimal("3E+12"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0014()
  {
    rc_BigDecimal = (new BigDecimal("3E+12")).remainder(new BigDecimal("3E+12"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0015()
  {
    rc_double = (new BigDecimal("3.2")).doubleValue();
    Assert.assertEquals(3.2, rc_double, 0);
  }
  public void testItem_0016()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+12")).divideAndRemainder(new BigDecimal("0E+2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0017()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0E+2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0018()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483646")).multiply(new BigDecimal("0E+12"));
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigInteger = (new BigDecimal("0E+2147483646")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0021()
  {
    rc_double = (new BigDecimal("0E+12")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
//  public void testItem_0022()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).max(new BigDecimal("0"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0023()
  {
    rc_int = (new BigDecimal("0E+2147483646")).scale();
    Assert.assertEquals(-2147483646, rc_int);
  }
  public void testItem_0024()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    rc_BigDecimal_array = (new BigDecimal("3")).divideAndRemainder(new BigDecimal("3"));
  }
  public void testItem_0027()
  {
    rc_BigInteger = (new BigDecimal("00.0E+2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0028()
  {
    rc_BigDecimal_array = (new BigDecimal("00.0E+2147483647")).divideAndRemainder(new BigDecimal("3"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("3.2"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0030()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0031()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\234', '\0', '8', '8', '\1', '8', '8', '\uFFFF', '\uFFFF', '8', '\1', '\0', '8', '8', '\234', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\234', '\234', '\234', '\0', '\1', '\uFFFF', '\1', '\0', '\0', '\0', '\0', '\1', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '8', '8', '\uFFFF', '\234', '8', '\234', '\uFFFF', '8', '\234', '\234', '\1', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\1', '8', '\uFFFF', '\0', '\1', '8', '\uFFFF', '8', '\0', '\1', '\234', '\uFFFF', '8', '\1', '\234', '\1', '\234', '8', '\1', '\0', '\0', '\uFFFF', '\1', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0034()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0035()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("-3.2"), -1, java.math.RoundingMode.HALF_DOWN);
//    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
//  }
  public void testItem_0036()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("-3.2"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0037()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3")).hashCode();
//    Assert.assertEquals(93, rc_int);
//  }
//  public void testItem_0038()
//  {
//    boolean caught;
//    rc_long = (new BigDecimal("00.0E+2147483647")).longValueExact();
//    Assert.assertEquals(0L, rc_long);
//  }
  public void testItem_0039()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    rc_int = (new BigDecimal("3")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0042()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0043()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0044()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("0E+1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("3")).plus();
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("3"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0047()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0050()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0051()
  {
    rc_String = (new BigDecimal("-3.2")).toPlainString();
    Assert.assertEquals("-3.2", rc_String);
  }
  public void testItem_0052()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0055()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0058()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0061()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0062()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0063()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0064()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("TDBCVWK;QG@TV4;AM7RP9BJTLQJI@BY<=JB9D43FCNIJG2<<E>RMI18W8RPBL07EFF");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0068()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0069()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0070()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0072()
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
  public void testItem_0073()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0074()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0075()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0078()
  {
    rc_BigInteger = (new BigDecimal("-3.2E-2147483646")).unscaledValue();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0079()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0080()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-3E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0084()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0085()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483646")).multiply(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0086()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0088()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("-3E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0089()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483646")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0092()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483646")).pow(-2147483648, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0093()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483646")).divide(new BigDecimal("-3E-2147483646"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0094()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0095()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0096()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3.2E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\uFFFF', '\0', '8', '\0', '\0', '\234', '\uFFFF', '\234', '8', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\0', '\0', '\0', '8', '\uFFFF', '8', '\1', '\1', '\234', '8', '\1', '\1', '\234', '\234', '\234', '\234', '8', '\uFFFF', '8', '\234', '\234', '\234', '8', '\0', '\1', '8', '\1', '8', '\234', '\234', '8', '8', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\234', '\1', '8', '\0', '\0', '\234', '\1', '8', '\uFFFF', '\1', '\uFFFF'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0100()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0101()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigIntegerExact();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0103()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), -2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0104()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    rc_long = (new BigDecimal("3E+1")).longValueExact();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0106()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3E+1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).scaleByPowerOfTen(1);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0109()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0112()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0114()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0115()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0116()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0117()
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
  public void testItem_0118()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("3.2E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0119()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).plus();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("3.2E-2147483646"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0124()
  {
    rc_boolean = (new BigDecimal("3.2E-2147483646")).equals("CWRYRM4;>6QUORJ1;ITH4GF9G>E<0U9HSS5XT>7I0N0DLV>YR2B58QKJPC1OO@V:IWL:C;E1?P>HQJTV=7J=0HFHQI@7R6QY<@BE");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0125()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0126()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0129()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("32"));
  }
//  public void testItem_0132()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0133()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.2E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0134()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0135()
  {
    rc_float = (new BigDecimal("3.2E-2147483646")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
//  public void testItem_0136()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0137()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("-1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_long = (new BigDecimal("2147483647")).longValueExact();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0139()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0142()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0143()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0146()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0147()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointRight(0);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0151()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0152()
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
  public void testItem_0153()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
//  public void testItem_0155()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0156()
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
  public void testItem_0157()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0158()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0159()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0160()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointRight(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0161()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).setScale(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("3.2E-2147483646"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0163()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0164()
  {
    rc_BigInteger = (new BigDecimal("3.2E-2147483646")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0165()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0166()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0169()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0170()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0171()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0174()
  {
    rc_BigDecimal = (new BigDecimal("31")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("31")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0176()
  {
    rc_BigDecimal = (new BigDecimal("31")).plus(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    rc_BigInteger = (new BigDecimal("3.2E-2147483646")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
//  public void testItem_0178()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
//  public void testItem_0179()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("8E8BN26:A4;5@QH0141:0PGKFKITH8WDLF@;EU1AG2T;=HWRN:V:HM0", new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0183()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0184()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("31"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_BigInteger = (new BigDecimal("1E-2147483647")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0186()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0187()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).add(new BigDecimal("0"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).multiply(new BigDecimal("1E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0191()
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
  public void testItem_0192()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
//  public void testItem_0193()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("1E-2147483647")).toBigInteger();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
//  public void testItem_0194()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("1E-2147483647")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0195()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).divide(new BigDecimal("1E-2147483647"), 2147483647, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("DHQIK?TEU>8;63FFX9LMOS83W43O603WCJRHT9SYLRQM2WC9>3A@K89SI7U?QT0MA3GK9B>8J0IS1Y7LV9NN4>=641RJ;3:3R?7I");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0198()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0202()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1E-2147483647"), -1, 0);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0203()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("1E-2147483647"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0207()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
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
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0214()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0215()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), -1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0218()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0219()
  {
    rc_int = (new BigDecimal("1E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0220()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '8', '\uFFFF', '8', '\uFFFF', '\234', '8', '8', '\1', '\0', '\234', '\1', '\234', '8', '\234', '\0', '8', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\234', '8', '8', '\0', '\234', '\234', '\0', '\1', '\234', '\234', '\0', '\uFFFF', '\0', '\1', '8', '\0', '\234', '\0', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\234', '\1', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\0', '\0', '\uFFFF', '\0', '\234', '\0', '\1', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '8', '\234', '\uFFFF', '8', '8', '8', '\0', '\234', '\0', '\uFFFF', '\1', '\234', '8', '\234', '\0', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF'}, 0, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0221()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\uFFFF', '\234', '\1', '\234', '\0', '\0', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\0', '\234', '8', '\234', '\uFFFF', '\0', '\0', '\0', '\0', '8', '8', '\1', '\234', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\0', '\234', '8', '\1', '\234', '\uFFFF', '\234', '\1', '\uFFFF'}, 2147483647, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0224()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("BBN5<E316WNW7IY>P3N>1KB2J2TESO>@<=LKY3L3T6PYGL;LPH46G?B3B4XEGJRCBQEDS?<?A9:KPUB9=XC3G6<VS1DE3KFE:S>E");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0226()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\1', '\0', '\1', '\1', '8', '\1', '\0', '\1', '\1', '\234', '\234', '\234', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\1', '8', '\1', '\234', '\0', '\uFFFF', '\234', '\234', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\0', '\uFFFF', '\234', '\0', '\1', '\0', '8', '\234', '\0', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\uFFFF', '8', '\0', '8', '\1', '\0', '\0', '\234', '\uFFFF', '\234', '\234', '\0', '\234', '8', '\1', '\1', '\1', '\1', '\234', '8', '\0', '8', '\0', '\uFFFF', '\234', '\234', '\1', '\0', '\uFFFF', '\0'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0227()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_float = (new BigDecimal("0.1")).floatValue();
    Assert.assertEquals(0.10000000149011612F, rc_float, 0);
  }
  public void testItem_0229()
  {
    rc_int = (new BigDecimal("0.1")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0230()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0231()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.1")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(1, 0);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0237()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\234', '\1', '8', '\1', '\0', '\0', '\1', '8', '\1', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\234', '8', '8', '\0', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\1', '\1', '\0', '\1', '8', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\234', '\234', '\0', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '8', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '8', '8', '\1', '\uFFFF', '8', '\0', '\0', '8', '\234', '\234', '\1', '\1', '\234', '\uFFFF', '\1', '8', '\234', '\0', '\1', '\uFFFF', '8', '8', '\1', '\0', '\234', '8', '8', '\0', '\1', '\234', '\0', '8', '\uFFFF', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0238()
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
  public void testItem_0239()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).remainder(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0240()
  {
    rc_int = (new BigDecimal("0.1")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0243()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("64")).divide(new BigDecimal("00.0E+2147483647"), java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0244()
  {
    rc_String = (new BigDecimal("64")).toEngineeringString();
    Assert.assertEquals("64", rc_String);
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
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0246()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("64")).setScale(2147483647, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0247()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).add(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0248()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0249()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0250()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0251()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("1"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0252()
  {
    rc_BigInteger = (new BigDecimal("1.0")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0253()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0254()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E-2147483647"), java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
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
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0256()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0257()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-9223372036854775809", rc_BigDecimal.toString());
  }
  public void testItem_0259()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\234', '\uFFFF', '\234', '8', '\1', '\1', '8', '8', '8', '\234', '\1', '\1', '\0', '\0', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '8', '\234', '\1', '\uFFFF', '\1', '\1', '\234', '\234', '8', '\234', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\1', '\1', '\1', '\uFFFF', '\1', '8', '\0', '\1', '\1', '\234', '\234', '\0', '8'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0260()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).stripTrailingZeros();
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0261()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0262()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigInteger();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0263()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(":5UXX@7444YWKX:AQ@9B:FL4BH0W9SQQY6F32KMPS3HQG0907P@2@XHW=:4;76U8UKR?RR67F:7TEBA?PD?Q?I53J<8>YLDN9");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0265()
  {
    rc_BigDecimal_array = (new BigDecimal("-9223372036854775808")).divideAndRemainder(new BigDecimal("-9223372036854775808"));
  }
//  public void testItem_0266()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).plus();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0267()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0268()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0269()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0270()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0272()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).plus();
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0273()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("-2147483648"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("32"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("-67108864", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    rc_BigDecimal = (new BigDecimal("-67108864")).divide(new BigDecimal("-67108864"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0277()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("97SONGXRUV5ROL3LTID;VWBKY1YCA0HEDIAXFRVFA7:D77;5QVV?2F3>01UWP1NI08?7Y41932BA4?R3Y?MV>RAAJ;T0S4MWO");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0278()
  {
    rc_int = (new BigDecimal("-67108864")).intValueExact();
    Assert.assertEquals(-67108864, rc_int);
  }
  public void testItem_0279()
  {
    rc_long = (new BigDecimal("9223372036854775807")).longValue();
    Assert.assertEquals(9223372036854775807L, rc_long);
  }
  public void testItem_0280()
  {
    rc_int = (new BigDecimal("9223372036854775807")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0281()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0284()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0285()
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
  public void testItem_0286()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0287()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3.2E-2147483646")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0288()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3.2E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0289()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '\uFFFF', '8', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\234', '8', '8', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '8', '\1', '\234', '\234', '\234', '\234', '\0', '\234', '\234', '8', '8', '\0', '8', '\234', '\234', '8', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\0', '\234', '\0', '\1', '\234', '\1', '\uFFFF', '8', '8', '\1', '8', '\1', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '8', '8', '\234', '8', '\1', '\234', '\1', '\234', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '8'}, 0, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0290()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0291()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("1"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
//  public void testItem_0293()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
//  public void testItem_0294()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3.2E+2")).divideAndRemainder(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0295()
  {
    rc_String = (new BigDecimal("3.2E+2")).toString();
    Assert.assertEquals("3.2E+2", rc_String);
  }
  public void testItem_0296()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\1', '\0', '\1', '\1', '\1', '\0', '\234', '\0', '\234', '8', '\0', '\0', '\234', '8', '\uFFFF', '\uFFFF'}, -2147483648, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0297()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("31")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0300()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0301()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0302()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0303()
  {
    rc_String = (new BigDecimal("31")).toEngineeringString();
    Assert.assertEquals("31", rc_String);
  }
//  public void testItem_0304()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("31"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0305()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3.2E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '\0', '\0', '\0', '\uFFFF', '\0', '8', '\234', '\234', '\234', '8', '\0', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '8', '\1', '\234', '\234', '\uFFFF', '\234', '8', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '8', '8', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\0', '8', '\1', '\234', '\234', '\1', '\uFFFF', '\1', '8', '\234', '\234', '\0', '\0', '\1', '8', '\234', '\1', '\234', '\0', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\1', '\234', '8', '\0', '8', '\uFFFF', '\234', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\1', '\234', '8', '\0', '\0', '\uFFFF', '8', '\0', '\1', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0309()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0310()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).min(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("31"), 1);
    Assert.assertEquals("1.59376014787498885218247997699426249150019291165911214330834091129250163635551210279128979471495481412837601514659908945460211842050303160128637030971219960685903455867842388557369618441241607130222167301953870558297758066576583597924188512036281741055861166174203779156580023911689859868119686018889253796189367600100201590950087610158856557840469853032621767783777419207074835293251747278491782179725119037008638761082335035983914452750481765167541621551842177151720394414346881797446207481809431706240592518067935855037735798486398137978010620900160726604218592771846705634067250909797886119339795065095892829599520182598425778435641648433904447185102169385672173862374161085961611005296958149583557394927985308555777017376855045797363404304750504E-325", rc_BigDecimal.toString());
  }
  public void testItem_0312()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0313()
  {
    rc_boolean = (new BigDecimal("1.59376014787498885218247997699426249150019291165911214330834091129250163635551210279128979471495481412837601514659908945460211842050303160128637030971219960685903455867842388557369618441241607130222167301953870558297758066576583597924188512036281741055861166174203779156580023911689859868119686018889253796189367600100201590950087610158856557840469853032621767783777419207074835293251747278491782179725119037008638761082335035983914452750481765167541621551842177151720394414346881797446207481809431706240592518067935855037735798486398137978010620900160726604218592771846705634067250909797886119339795065095892829599520182598425778435641648433904447185102169385672173862374161085961611005296958149583557394927985308555777017376855045797363404304750504E-325")).equals("88VC@I0<;L8<EAQQ31SRA;I?VQKYR4@KBNQ@;K?VH3ML4G9?>H56<EOMG7YL1UJ2MVT@ORE2XU>2<C8FS2?O?<>PJM@@MQS@?K=O");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0314()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("31")).divideToIntegralValue(new BigDecimal("1.59376014787498885218247997699426249150019291165911214330834091129250163635551210279128979471495481412837601514659908945460211842050303160128637030971219960685903455867842388557369618441241607130222167301953870558297758066576583597924188512036281741055861166174203779156580023911689859868119686018889253796189367600100201590950087610158856557840469853032621767783777419207074835293251747278491782179725119037008638761082335035983914452750481765167541621551842177151720394414346881797446207481809431706240592518067935855037735798486398137978010620900160726604218592771846705634067250909797886119339795065095892829599520182598425778435641648433904447185102169385672173862374161085961611005296958149583557394927985308555777017376855045797363404304750504E-325"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0315()
  {
    rc_BigInteger = (new BigDecimal("1.59376014787498885218247997699426249150019291165911214330834091129250163635551210279128979471495481412837601514659908945460211842050303160128637030971219960685903455867842388557369618441241607130222167301953870558297758066576583597924188512036281741055861166174203779156580023911689859868119686018889253796189367600100201590950087610158856557840469853032621767783777419207074835293251747278491782179725119037008638761082335035983914452750481765167541621551842177151720394414346881797446207481809431706240592518067935855037735798486398137978010620900160726604218592771846705634067250909797886119339795065095892829599520182598425778435641648433904447185102169385672173862374161085961611005296958149583557394927985308555777017376855045797363404304750504E-325")).unscaledValue();
    Assert.assertEquals("159376014787498885218247997699426249150019291165911214330834091129250163635551210279128979471495481412837601514659908945460211842050303160128637030971219960685903455867842388557369618441241607130222167301953870558297758066576583597924188512036281741055861166174203779156580023911689859868119686018889253796189367600100201590950087610158856557840469853032621767783777419207074835293251747278491782179725119037008638761082335035983914452750481765167541621551842177151720394414346881797446207481809431706240592518067935855037735798486398137978010620900160726604218592771846705634067250909797886119339795065095892829599520182598425778435641648433904447185102169385672173862374161085961611005296958149583557394927985308555777017376855045797363404304750504", rc_BigInteger.toString());
  }
  public void testItem_0316()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("GRRK>I:HX;GKT9U:M;LO@MU1EO4D3IW4KVYI>>P9HT@W:IY0O0B=DFUOT5SKJLIGDMR4LNQL428U:;QNQ6BPWM;LSLL=?:3?=72D");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0317()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0318()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("9AGJ;XDKU5PC322EGJD0S>S:PMJ>DTVIS<ME1LIO;4PD;Y;L<LP8<BVN:48O5T6CR=CMALC??>EHTK?VU?VV7:QR8OEKD2F;D3V1");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0320()
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
  public void testItem_0321()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).remainder(new BigDecimal("31"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).plus();
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).remainder(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0327()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    rc_int = (new BigDecimal("9223372036854775807")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\0', '\234', '8', '8', '\0', '\234', '\234', '\0', '\234', '\234', '\234', '\0', '8', '\1', '8', '\1', '\0', '8', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\0', '\234', '\234', '\0', '8', '8', '\0', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\234'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0332()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).abs();
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0333()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0334()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0335()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0336()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0337()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).scale();
    Assert.assertEquals(1074, rc_int);
  }
  public void testItem_0338()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0339()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("3E+1"), 0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 0, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0344()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0345()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0346()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\1', '8', '\234', '8', '8', '\234', '\0', '\1', '\234', '\1', '\1', '\0', '\uFFFF', '8', '8', '\1', '\234', '\uFFFF', '\0', '\1', '\234', '\1', '\0', '\234', '8', '8', '\uFFFF', '8', '8', '8', '\1', '\234', '\0', '\0', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\234', '\0', '\0', '\1', '\0', '\1', '\234', '\uFFFF', '\234', '8', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '8', '8', '\0', '\234', '8', '\0', '\0', '8', '\0', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '8', '\1', '\uFFFF', '8', '\234', '\234', '8', '\uFFFF', '\1', '\0', '\234', '\1'}, 0, 1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0347()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0348()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0349()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0351()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0352()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), -2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0353()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0354()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0355()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0356()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0358()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0360()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\0', '8', '\0', '\0', '\uFFFF', '\0', '\0', '\234', '\0', '8', '\0', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\0', '\0', '\1', '\uFFFF', '\234', '8', '\234', '\1', '\1', '\234', '\1', '8', '\uFFFF', '\uFFFF', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0361()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).multiply(new BigDecimal("1"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0365()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toPlainString();
    Assert.assertEquals("0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_String);
  }
  public void testItem_0366()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("BAM=V;5VE6:AFA1:V5N1;K<?2VB1YLID:SP<YW237V8S2M;EJL<:BVMB?AXG1KG6LFQOT6J=PI60?A362YAPS<VKST;92?ST;:KG");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0367()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).hashCode();
//    Assert.assertEquals(1240908815, rc_int);
//  }
  public void testItem_0368()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("3.2E+2"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0369()
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
  public void testItem_0370()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("4E-324", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("4E-324")).remainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("4E-324", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0374()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0375()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("4E-324")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.8", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("4E-324")).max(new BigDecimal("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647"));
    Assert.assertEquals("4E-324", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).max(new BigDecimal("4E-324"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_String = (new BigDecimal("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647")).toEngineeringString();
    Assert.assertEquals("24.410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-648", rc_String);
  }
  public void testItem_0383()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0384()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0385()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toEngineeringString();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_String);
  }
  public void testItem_0386()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_float = (new BigDecimal("0E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_short = (new BigDecimal("0E-2147483647")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0391()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0392()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483647")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
  public void testItem_0393()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0394()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0397()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0398()
  {
    rc_String = (new BigDecimal("-2147483648")).toEngineeringString();
    Assert.assertEquals("-2147483648", rc_String);
  }
//  public void testItem_0399()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2147483648")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0400()
  {
    rc_long = (new BigDecimal("3E+1")).longValue();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0401()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(2147483647, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    rc_BigDecimal = (new BigDecimal("4E-324")).divide(new BigDecimal("3E+1"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E-324", rc_BigDecimal.toString());
  }
  public void testItem_0403()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Q>H0O?LNR<76LQ0AWI3A6E<D06FPBU>QKFCWL:S4@7MQJV3679AOUBFGWXT@U@Y18TR=H?AG7M54EHL1E>R6TOW2>X64W4;R5TKP");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0404()
  {
    rc_boolean = (new BigDecimal("3E+1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0405()
  {
    rc_boolean = (new BigDecimal("0E-2147483647")).equals("PG9T0HF3P8E7?BPPT5OX40:7:O7<SS<XLX7CNF<BQLOEJ<O0>8<VB9?I6N>HOJX<32S7;S<?:15VQA>FO@:=85C0V6:");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0406()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), 2147483647, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0407()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0409()
  {
    rc_int = (new BigDecimal("1135879015891")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0410()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0411()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0412()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0414()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E-324")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0415()
  {
    rc_BigDecimal = (new BigDecimal("4E-324")).multiply(new BigDecimal("-2147483648"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-8.589934592E-315", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0417()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0418()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0421()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0424()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0426()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigInteger();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0427()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).abs();
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0429()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\0', '\234', '\uFFFF', '\234', '\0', '\0', '8', '\1', '\uFFFF', '8', '8', '\1', '\1', '\234', '\1', '\234', '\uFFFF', '\234', '\0', '\234', '\234', '\1', '\234', '8', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '8', '8', '\1', '8', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '8', '8', '\0', '\0', '\0', '\uFFFF', '\1', '\0', '\234', '\0', '\1', '\1', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\0', '\234', '\234', '\uFFFF', '\0', '\0', '\234', '\234', '8', '\0', '8', '\1', '\1', '8', '8', '\0', '8', '\1'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divideToIntegralValue(new BigDecimal("-2147483648"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0433()
  {
    rc_int = (new BigDecimal("-2147483648")).intValueExact();
    Assert.assertEquals(-2147483648, rc_int);
  }
  public void testItem_0434()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-2147483648")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0435()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0436()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-2147483648")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0437()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("SY05BK7NW1?5;>Y7KY1>EGG");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0438()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3.2E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0439()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308", rc_BigDecimal.toString());
  }
  public void testItem_0442()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0443()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\234', '8', '\0', '\uFFFF', '\234', '\234', '\0', '\234', '\1', '\234', '\0', '\0', '\1', '\1', '\1', '8', '\234', '\1', '\0', '\1', '8', '\0', '8', '\0', '\1', '8', '\0', '\1', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\234', '8', '\1', '8', '\234', '\0', '\1', '\uFFFF', '\0', '\234', '8', '8', '\0', '\1', '\1', '8', '8', '\0', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '8', '\uFFFF', '8', '\234', '\234', '\234', '\0', '\234', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\1', '\1', '8', '\234', '8', '\1', '\1', '\234', '8', '\uFFFF', '\1', '8', '8', '8', '8', '\0'}, 2147483647, 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-2147483648"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0445()
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
  public void testItem_0446()
  {
    rc_float = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0447()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0448()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0449()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0450()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\234', '\1', '\234', '\0', '\1', '\0', '8', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\234', '8', '\1', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\1', '8', '\1', '8', '\1', '\234', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\234', '\1', '\234', '\234', '\1', '\uFFFF', '\0', '\1', '\0', '\234', '\234', '\uFFFF', '8', '\1', '\0', '8', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\234', '8', '\1', '\0', '\0', '\1', '\1', '\234', '8', '\0', '\0', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0452()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308"));
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0453()
  {
    rc_boolean = (new BigDecimal("0")).equals("EESPR13@:TH0Q7KK;JNHGU:N7VP:23L6W7OQB;2I4BPDX;R1K8O9ON?LSTEAHS8?I4PQK0W84M?CJLQAHGJD0ASBJS5>P6XQHF@O");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0454()
  {
    rc_int = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0455()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
//  public void testItem_0457()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0458()
  {
    rc_int = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).intValue();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0459()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("-1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0462()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("3.2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("65E?CKPQ7GI>61TWJ1L>Q0H=Q=1BJGCO1QIRO8P26A?WIMWEUS3TGJO9NPKELTWHAICP;?RA0>BB7UR<>B");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0464()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308"));
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308", rc_BigDecimal.toString());
  }
  public void testItem_0465()
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
  public void testItem_0466()
  {
    rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).plus();
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).movePointRight(-1);
    Assert.assertEquals("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0469()
  {
    rc_float = (new BigDecimal("3.2")).floatValue();
    Assert.assertEquals(3.200000047683716F, rc_float, 0);
  }
//  public void testItem_0470()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).abs();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0471()
  {
    rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).setScale(-1);
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_int = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).compareTo(new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0473()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    rc_int = (new BigDecimal("3.2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837")).movePointLeft(-1);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858370", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858370"), 1, 1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0478()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0481()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0482()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).divide(new BigDecimal("3.2"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("5.617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824E+307", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    rc_BigDecimal = (new BigDecimal("5.617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824E+307")).divide(new BigDecimal("3"), 1);
    Assert.assertEquals("1.872597015481578862651327330538587049979901745060885381238723716699554799791963945422807902424654980953546447432441484002440847155098585237171536944828515801938019901839075854960890521774888843167456963629740978565672742051075239043393839159709618211195810689626507533007689345634576040429691708606084633941E+307", rc_BigDecimal.toString());
  }
  public void testItem_0485()
  {
    rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).min(new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308"));
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\0', '\0', '\234', '\1', '\0', '\0', '\0', '\1', '\234', '\1', '\1', '\234', '\0', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\0', '\1', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\1', '\uFFFF', '8', '\1', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\0', '8', '\1', '\1', '\1', '\234', '\234', '8', '8', '\0', '\uFFFF', '\1', '\1', '8', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\1', '8', '\1', '8', '\0', '8', '\0', '\uFFFF', '8', '8', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\0', '\234', '\1', '8', '\0', '\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("5.617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824E+307")).add(new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("2.3594722395067893669406724364786196829746761987767155803607918830414390477378745712327379570550652760014685237648762698430754674154242173988361365504839299104419050763172355772507220574363599423909957741734736329927476549843548011946762373412341189461067214689293994915896885754995658109414115528436666387661E+308", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).divide(new BigDecimal("5.617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824E+307"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0489()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).divide(new BigDecimal("5.617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824E+307"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0490()
  {
    rc_BigDecimal = (new BigDecimal("2.3594722395067893669406724364786196829746761987767155803607918830414390477378745712327379570550652760014685237648762698430754674154242173988361365504839299104419050763172355772507220574363599423909957741734736329927476549843548011946762373412341189461067214689293994915896885754995658109414115528436666387661E+308")).multiply(new BigDecimal("32"));
    Assert.assertEquals("7.55031116642172597421015179673158298551896383608548985715453402573260495276119862794476146257620888320469927604760406349784149572935749567627563696154857571341409624421515384720231058379635181565118647735511562557679249594993536382296395949194918062754150870057407837308700344159861059501251696909973324405152E+309", rc_BigDecimal.toString());
  }
  public void testItem_0491()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0492()
  {
    rc_BigDecimal = (new BigDecimal("5.617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824E+307")).divide(new BigDecimal("5.617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824E+307"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0495()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308"));
    Assert.assertEquals("-1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308", rc_BigDecimal.toString());
  }
  public void testItem_0496()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\234', '\0', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\234', '\234', '8', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\1', '8', '\234', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '8', '8', '\0', '\1', '\0', '\234', '\234', '\0', '\0', '\234', '\0', '\1', '\1', '\1', '\0', '\1', '\0', '\0', '\234', '8', '\234', '\1', '\1', '\1', '\234', '\1', '8', '\234', '\234', '\1', '8', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\234', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\0', '8', '\0', '\234', '\0', '\234', '\234', '8', '\0', '\234', '\0', '8', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '8'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0497()
  {
    rc_String = (new BigDecimal("2.3594722395067893669406724364786196829746761987767155803607918830414390477378745712327379570550652760014685237648762698430754674154242173988361365504839299104419050763172355772507220574363599423909957741734736329927476549843548011946762373412341189461067214689293994915896885754995658109414115528436666387661E+308")).toEngineeringString();
    Assert.assertEquals("235.94722395067893669406724364786196829746761987767155803607918830414390477378745712327379570550652760014685237648762698430754674154242173988361365504839299104419050763172355772507220574363599423909957741734736329927476549843548011946762373412341189461067214689293994915896885754995658109414115528436666387661E+306", rc_String);
  }
  public void testItem_0498()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0499()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0500()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("2.3594722395067893669406724364786196829746761987767155803607918830414390477378745712327379570550652760014685237648762698430754674154242173988361365504839299104419050763172355772507220574363599423909957741734736329927476549843548011946762373412341189461067214689293994915896885754995658109414115528436666387661E+308"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("4G29YO0LXE1J28:QW?CN@CG4<QOWQ;>T8UP6AEN958B<R0O;ANX8NM?7?GU1?XJT092ODMD2@BW@K6<CSQKGW<:0BONP?RD6DVSA", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0502()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\0', '8', '8', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\1', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\0', '\1', '\0', '\234', '\234', '\uFFFF', '\1', '\1', '\0', '\234', '\0', '\0', '\0', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '8', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '8', '8', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\234', '8', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0505()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0506()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    rc_BigDecimal = (new BigDecimal("2.3594722395067893669406724364786196829746761987767155803607918830414390477378745712327379570550652760014685237648762698430754674154242173988361365504839299104419050763172355772507220574363599423909957741734736329927476549843548011946762373412341189461067214689293994915896885754995658109414115528436666387661E+308")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0508()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).max(new BigDecimal("0"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("32"));
    Assert.assertEquals("62", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0512()
  {
    rc_int = (new BigDecimal("3E+1")).intValueExact();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0513()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0514()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0516()
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
  public void testItem_0517()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("320.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0520()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0528()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0529()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1.0"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0532()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0533()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0534()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0535()
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
  public void testItem_0536()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).add(new BigDecimal("1.0"));
    Assert.assertEquals("2.0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0537()
  {
    rc_boolean = (new BigDecimal("1.0")).equals("P7CIG?PBV1WYB8M1G:DUO?J<:QCNED4>3JLEORWH9MIXJV7NFF9IA882EW7S>N4RDIL:0:PX>SMRLM:KT@BL0VNEBJBMO8<4@:LV");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0538()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0539()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0540()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2.0")).hashCode();
//    Assert.assertEquals(621, rc_int);
//  }
  public void testItem_0541()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("2.0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0542()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0543()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0544()
  {
    rc_boolean = (new BigDecimal("0.0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0545()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("1.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0546()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).movePointRight(1);
    Assert.assertEquals("-21474836480", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("2.0"));
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0549()
  {
    rc_boolean = (new BigDecimal("-2147483648")).equals("?B80:1J1@QBK>4CL3U3F@1O5JAIN5?X5@Q:KC7UMS3C:OMIW>HDSOH?L?K3<R9EQ2LA5SUAST<;QN1KD?V870CHW4OF?BOFPRW");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0550()
  {
    rc_BigDecimal = (new BigDecimal("2.0")).divideToIntegralValue(new BigDecimal("-2147483648"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0551()
  {
    rc_String = (new BigDecimal("-21474836480")).toPlainString();
    Assert.assertEquals("-21474836480", rc_String);
  }
  public void testItem_0552()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '8', '\0', '8', '\234', '8', '\0', '\234', '\234', '\1', '8', '\1', '\1', '\234', '\234', '8', '8', '8', '\0', '\0', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\1', '\234', '\0', '\0', '\1', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\0', '\234', '\234', '8', '\234', '\0', '\0', '\234', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\0', '\0', '\1', '\1', '\0', '8', '\1', '\234', '\234', '8', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\1', '\234', '\234', '8', '8', '\0', '\234', '\234'}, -2147483648, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0555()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_int = (new BigDecimal("-2147483648")).intValueExact();
    Assert.assertEquals(-2147483648, rc_int);
  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).abs();
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate();
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("L>Y17S21Y9RR2R<:X8:XGR4N=3NIC6ED=M1JNDR;AQKVO6W::;2S00Y=KXUIYQQGW7C=NAXY5FC@VTDDYPM=E3UCV1J?7AOWI5M8");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0560()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0561()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("320.0E+2147483647")).divideAndRemainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0562()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\0', '\234', '\234', '\0', '\0', '8', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\1', '\0', '\1', '\234', '\uFFFF', '\0', '8', '8', '\uFFFF', '8', '8', '\1', '\234', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\234', '8', '\1', '8', '\0', '8', '8', '\234', '\uFFFF', '8', '\0', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\1', '\0', '\0', '\1', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).min(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).scaleByPowerOfTen(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0566()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-3.2E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0567()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("-3.2E-2147483646"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0568()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0569()
  {
    rc_String = (new BigDecimal("-2147483648")).toString();
    Assert.assertEquals("-2147483648", rc_String);
  }
  public void testItem_0570()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0571()
  {
    rc_String = (new BigDecimal("-2147483648")).toPlainString();
    Assert.assertEquals("-2147483648", rc_String);
  }
  public void testItem_0572()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).min(new BigDecimal("0.0"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0573()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0574()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).scale();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0575()
  {
    rc_String = (new BigDecimal("-2147483648")).toEngineeringString();
    Assert.assertEquals("-2147483648", rc_String);
  }
  public void testItem_0576()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).subtract(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0577()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.0")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.IllegalArgumentException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
//  public void testItem_0578()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("3.2E-2147483646"), java.math.RoundingMode.DOWN);
//    Assert.assertEquals("0.0", rc_BigDecimal.toString());
//  }
  public void testItem_0579()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0581()
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
  public void testItem_0582()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).scaleByPowerOfTen(0);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0584()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0585()
  {
    rc_boolean = (new BigDecimal("0.0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0586()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"), 1, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0587()
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
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0588()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0589()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2E-2147483646")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0590()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0591()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("3.2E-2147483646"), 1, 1);
//    Assert.assertEquals("0.0", rc_BigDecimal.toString());
//  }
  public void testItem_0592()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0593()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).min(new BigDecimal("3.2"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0594()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0595()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0597()
  {
    rc_int = (new BigDecimal("0.0")).compareTo(new BigDecimal("0.0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0598()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\1', '\1', '\1', '\234', '\234', '\0', '\1', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\0', '8', '\0', '\1', '\1', '\234', '\1', '\234', '\1', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\234', '8', '\0', '\0', '8', '\uFFFF', '\0', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\1', '8', '\234', '\234', '\1', '\234', '8', '\uFFFF', '\234', '\0', '\234', '8', '\0', '\0', '\uFFFF', '\0', '\0', '\1', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '8', '8', '8', '8', '\0', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0599()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
//  public void testItem_0600()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(-1, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0601()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0602()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("C?=D=318<9HI5=UX3=A01AY6>@YY?Y@VSS>CO9P?6V@S1=N<OBE9A=Y6F@JO;BRCW", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0603()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
//  public void testItem_0604()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("320.0E+2147483647")).intValue();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0605()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0606()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\234', '\1', '\1', '8', '8', '\0', '\uFFFF', '\234', '8', '\1', '\0', '\1', '\0', '\234', '8', '\1', '\234', '\234', '8', '\1', '\1', '\uFFFF', '8', '\1', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '8', '\uFFFF', '\234', '8', '\1'}, 1, 2147483647, new MathContext("precision=1 roundingMode=DOWN"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0607()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).stripTrailingZeros();
	Assert.assertEquals(0.0, rc_BigDecimal.doubleValue(), 0);
  }
//  public void testItem_0608()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0.0"), -2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0609()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0611()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("3.2"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0614()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0.0")).subtract(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=DOWN"));
//    Assert.assertEquals("-3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0615()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("OPY6:9S3R<Y9C>=0CC=D<S69OJHXN?0?7?AW2VM=JO1M5O6>8AVS;7EB>1G486YBDIOW8?8N@FKMLYAPWH7?SDTQNV3WJGV@R7G>");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0616()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0617()
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
  public void testItem_0618()
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
  public void testItem_0619()
  {
    rc_int = (new BigDecimal("-3E-2147483647")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0620()
  {
    rc_double = (new BigDecimal("-3E-2147483647")).doubleValue();
    Assert.assertEquals(-0.0, rc_double, 0);
  }
  public void testItem_0621()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0622()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0623()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
//  public void testItem_0624()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0625()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    rc_BigDecimal = (new BigDecimal("3")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("3"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0628()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0629()
  {
    rc_long = (new BigDecimal("3")).longValueExact();
    Assert.assertEquals(3L, rc_long);
  }
  public void testItem_0630()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).stripTrailingZeros();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0631()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0632()
  {
    rc_int = (new BigDecimal("3")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0633()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\1', '\uFFFF', '\1', '\1', '\0', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\0', '\1', '8', '\1', '\0', '\1', '\0', '8', '8', '\uFFFF', '8', '\234', '\uFFFF', '8', '\234', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '8', '\1', '8', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '8', '8', '\234', '\0', '\0', '\0', '\0', '\234', '\1', '\1', '8', '\234', '8', '\0', '\234', '8', '\234', '\uFFFF', '\uFFFF', '8'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0634()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("1"));
  }
//  public void testItem_0635()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus();
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0636()
  {
    rc_BigDecimal = (new BigDecimal("3")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0638()
  {
    rc_BigDecimal = (new BigDecimal("3")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0640()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0641()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0645()
  {
    rc_String = (new BigDecimal("3.2")).toEngineeringString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0646()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\234', '8', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '8', '8', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\1', '\234', '\0', '\uFFFF', '\1', '8'}, -1, -1, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0647()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0648()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0649()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0650()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0653()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0654()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0656()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).setScale(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("300", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_double = (new BigDecimal("3.2")).doubleValue();
    Assert.assertEquals(3.2, rc_double, 0);
  }
  public void testItem_0659()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0660()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0661()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0662()
  {
    rc_int = (new BigDecimal("3E+2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0663()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0664()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).subtract(new BigDecimal("3E+2"));
    Assert.assertEquals("-2.0000003E+9", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    rc_int = (new BigDecimal("3E+2")).intValue();
    Assert.assertEquals(300, rc_int);
  }
  public void testItem_0667()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("-2147483648"), java.math.RoundingMode.UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0668()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0669()
  {
    rc_long = (new BigDecimal("-2E+9")).longValueExact();
    Assert.assertEquals(-2000000000L, rc_long);
  }
  public void testItem_0670()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0671()
  {
    rc_int = (new BigDecimal("-2.0000003E+9")).intValueExact();
    Assert.assertEquals(-2000000300, rc_int);
  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E+9")).plus();
    Assert.assertEquals("-2.0000003E+9", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3E+2")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0674()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0675()
  {
    rc_BigInteger = (new BigDecimal("-2.0000003E+9")).toBigInteger();
    Assert.assertEquals("-2000000300", rc_BigInteger.toString());
  }
  public void testItem_0676()
  {
    rc_BigInteger = (new BigDecimal("3E+2")).toBigIntegerExact();
    Assert.assertEquals("300", rc_BigInteger.toString());
  }
  public void testItem_0677()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0678()
  {
    rc_int = (new BigDecimal("-2E+9")).scale();
    Assert.assertEquals(-9, rc_int);
  }
  public void testItem_0679()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0681()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("-2E+9"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    rc_long = (new BigDecimal("-2E+9")).longValue();
    Assert.assertEquals(-2000000000L, rc_long);
  }
  public void testItem_0684()
  {
    rc_long = (new BigDecimal("-2.0000003E+9")).longValueExact();
    Assert.assertEquals(-2000000300L, rc_long);
  }
//  public void testItem_0685()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2E+9")).hashCode();
//    Assert.assertEquals(-71, rc_int);
//  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("2")).abs();
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_BigDecimal = (new BigDecimal("2")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal_array = (new BigDecimal("-2E+9")).divideAndRemainder(new BigDecimal("-2.0000003E+9"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0690()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0691()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+9")).divide(new BigDecimal("0"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0692()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("SWP1FNI4C4XOPBK780P7D6WJD7@@XV5?JLR?FONHHOH580BLF0U03:N?2<WBVO66FQN>4;SBQM4379:@E:L2BREBXUS5XK46VM6T");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0694()
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
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("S5:FS:9C;4BQIG?=1VYKGM=<=<R;RBS3O8IHYARO1ST2SHL;6L;S5312X;O4:9:FOMG<DOTQT?6X5NE1T6OB3VCGIQ04J4M4812?");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0698()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0699()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("H:9X8JN1O0P35;B>CPIT=MRXW@R:>P4Y8O@20M3A:H1GRDYWO6A?T=3PBU00IMN:Q244BUKLK6JYOWV===9DR1>EKC442MVDOX@2");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0704()
  {
    rc_BigInteger = (new BigDecimal("0E+9")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0705()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0706()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).multiply(new BigDecimal("-9E+18"));
    Assert.assertEquals("0E+27", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E+9")).divide(new BigDecimal("-2.0000003E+9"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).divide(new BigDecimal("1"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E+9")).max(new BigDecimal("3.2"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0714()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E+9")).plus();
    Assert.assertEquals("-2.0000003E+9", rc_BigDecimal.toString());
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E+9")).multiply(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("-6.40000096E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0717()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0718()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0719()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E+9")).movePointRight(-2147483648);
    Assert.assertEquals("-2.0000003E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("TTVROWAXD<?8EIFXP4II6");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0721()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("32"), 0);
    Assert.assertEquals("35496219247", rc_BigDecimal.toString());
  }
//  public void testItem_0722()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).setScale(0, 1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0723()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0724()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("PMLGHV<27KP0U@SCT53L;CG6YLVX@");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).max(new BigDecimal("-2.0000003E-2147483639"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("-2.0000003E+9"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0730()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("U3X=MXI2?05QG=PLVIEUVM4B2BL2PX>6719MG;5D5TEF>?C:15FNR=HKRAVEVLBJPLXVOWOD9T3AXNE5=J", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0731()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0733()
  {
    rc_int = (new BigDecimal("0E-2147483647")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0734()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E+9")).multiply(new BigDecimal("-2.0000003E+9"));
    Assert.assertEquals("4.00000120000009E+18", rc_BigDecimal.toString());
  }
  public void testItem_0735()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0736()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0737()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0738()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2.0000003E+9")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0739()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-2.0000003E+9"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1, 0);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0742()
  {
    rc_long = (new BigDecimal("0.00")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0743()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.00")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0744()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).remainder(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0745()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0747()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\234', '8', '\234', '8', '\1', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\234', '8', '\234', '\234', '\0', '\234', '\1', '\0', '8', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\234', '\1', '\234', '\0', '\uFFFF', '\1', '\1', '8', '\1', '8', '\0', '\234', '\234', '\0', '\0', '8', '8', '\1', '\0', '8', '\1', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\234', '8', '\0', '\234', '\234', '\234', '\0', '\0', '\234', '\234'}, 1, 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0748()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).remainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0749()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '8', '8', '\uFFFF', '\0', '\234', '\1', '\1', '\0', '8', '\234', '8', '8', '\0', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\234', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\uFFFF', '8', '8', '\1', '\234', '8', '8', '8', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '8', '8', '\234', '\uFFFF', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0750()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("-2.0000003E-2147483639")).intValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0751()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).pow(1);
    Assert.assertEquals("-2.0000003E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0754()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0755()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).movePointLeft(-1);
    Assert.assertEquals("-2.0000003E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).subtract(new BigDecimal("-2.0000003E-2147483639"));
    Assert.assertEquals("2.0000003E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("2.0000003E-2147483639")).negate();
    Assert.assertEquals("-2.0000003E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).divideToIntegralValue(new BigDecimal("-2.0000003E-2147483638"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0760()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("2.0000003E-2147483639")).divideAndRemainder(new BigDecimal("-2.0000003E-2147483639"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
//  public void testItem_0761()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).divide(new BigDecimal("-2.0000003E-2147483639"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0762()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).divide(new BigDecimal("-2.0000003E-2147483639"), 2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0763()
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
  public void testItem_0764()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-2.0000003E-2147483638")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).min(new BigDecimal("-2.0000003E-2147483639"));
    Assert.assertEquals("-2.0000003E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    rc_int = (new BigDecimal("-2.0000003E-2147483638")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0768()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).stripTrailingZeros();
    Assert.assertEquals("-2.0000003E-2147483639", rc_BigDecimal.toString());
  }
//  public void testItem_0769()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("-2.0000003E-2147483639")).intValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0770()
  {
    rc_int = (new BigDecimal("-2.0000003E-2147483639")).compareTo(new BigDecimal("-2.0000003E-2147483638"));
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0771()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483638")).divideToIntegralValue(new BigDecimal("-2.0000003E-2147483638"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0772()
  {
    rc_double = (new BigDecimal("-2.0000003E-2147483639")).doubleValue();
    Assert.assertEquals(-0.0, rc_double, 0);
  }
  public void testItem_0773()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).plus();
    Assert.assertEquals("-2.0000003E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0774()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '\1', '\0', '\uFFFF', '\234', '\0', '\234', '8', '\234', '8', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '\234', '\0', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\0', '8', '\1', '\0', '\0', '8', '\0', '\234', '\1', '\0', '8', '8', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\uFFFF', '8', '\234', '\0', '\234', '\uFFFF', '8', '\234', '\1', '8', '\uFFFF', '\1', '8', '\234'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0775()
  {
    rc_int = (new BigDecimal("-2.0000003E-2147483639")).compareTo(new BigDecimal("2.0000003E-2147483639"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0777()
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
  public void testItem_0778()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=0 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0779()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).multiply(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("2.0000003E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_int = (new BigDecimal("-2.0000003E-2147483639")).compareTo(new BigDecimal("-2.0000003E-2147483639"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0782()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("-2.0000003E-2147483639"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0783()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).stripTrailingZeros();
    Assert.assertEquals("-2.0000003E-2147483639", rc_BigDecimal.toString());
  }
//  public void testItem_0785()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2.0000003E-2147483639")).setScale(0);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0786()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0787()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).subtract(new BigDecimal("3E+2"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0788()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("-2.0000003E-2147483639")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).divide(new BigDecimal("2.0000003E-2147483639"), 0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    rc_BigDecimal = (new BigDecimal("2.0000003E-2147483639")).abs();
    Assert.assertEquals("2.0000003E-2147483639", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0791()
  {
    rc_boolean = (new BigDecimal("3E+2")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0792()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).subtract(new BigDecimal("3E+2"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0794()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0795()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
//  public void testItem_0796()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("-2.0000003E-2147483639")).longValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).divide(new BigDecimal("1E+12"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0798()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("-1E-2147483646")).longValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0799()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000003E-2147483639")).negate();
    Assert.assertEquals("2.0000003E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0800()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("23AE4GRI>=7QUHI;TS:2U:F80DFC962151N7AESG156?OJ;KSWUFQEFHRA>RG=?V63=6:FF<QHBVQO2518U");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0802()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E-2147483646")).add(new BigDecimal("1E+12"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0803()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).add(new BigDecimal("-1E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0804()
  {
    rc_float = (new BigDecimal("1E+12")).floatValue();
    Assert.assertEquals(9.99999995904E11F, rc_float, 0);
  }
  public void testItem_0805()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0806()
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
  public void testItem_0807()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0809()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '8', '\234', '\1', '8', '\234', '\234', '8', '\234', '8', '\234', '8', '\uFFFF', '\234', '\234', '\234', '\0', '\uFFFF', '8', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\0', '\1', '\234'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0810()
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
  public void testItem_0811()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("3.2"));
  }
  public void testItem_0816()
  {
    rc_BigInteger = (new BigDecimal("3.2")).toBigInteger();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0817()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate();
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_BigInteger = (new BigDecimal("3.2")).toBigInteger();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0819()
  {
    rc_int = (new BigDecimal("3E+1")).intValue();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0820()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0821()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0822()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("2.0000003E-2147483639"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
//  public void testItem_0823()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("2.0000003E-2147483639"), java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0824()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\1', '8', '\0', '\0', '\uFFFF', '\234', '\1', '\1', '\1', '8', '\0', '\234', '\0', '\1', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '8', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\234', '\0', '8', '\0', '\uFFFF', '8', '\1', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\0', '\0', '\1', '8', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '8', '8', '\234', '\234', '8', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\0', '\234'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0825()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).add(new BigDecimal("3E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775837", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("3"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("6.2", rc_BigDecimal.toString());
  }
  public void testItem_0828()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '8', '\1', '8', '\0', '\234', '\1', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\234', '8', '\1', '\0', '\0', '\0', '\234', '\234', '\1', '\1', '\234', '\1', '\uFFFF', '\1', '8', '8', '\234', '\uFFFF', '\1', '8', '\1', '\234', '\0', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\0', '8', '\0', '\1', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("9223372036854775807"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("2H1BTOL2O8CLRL<JL2YB:FHETGB9OX62K2UMD8DK@XVRG96<A>0B9:<:0FMXPNPI0W?93JPKLT1JFQHSE>KH=5L=W8A64FRLJ86B", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0831()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("3.2"));
    Assert.assertEquals("10.24", rc_BigDecimal.toString());
  }
  public void testItem_0832()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10.24")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0834()
  {
    rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("6.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.5", rc_BigDecimal.toString());
  }
  public void testItem_0835()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0836()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-2147483648")).divideAndRemainder(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0837()
  {
    rc_BigDecimal_array = (new BigDecimal("3")).divideAndRemainder(new BigDecimal("3"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0838()
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
  public void testItem_0839()
  {
    rc_long = (new BigDecimal("-2147483648")).longValue();
    Assert.assertEquals(-2147483648L, rc_long);
  }
  public void testItem_0840()
  {
    rc_BigInteger = (new BigDecimal("3.2")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0841()
  {
    rc_short = (new BigDecimal("0.0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0842()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\234', '8', '8', '\0', '\234', '\234', '8', '\1', '\uFFFF', '\0', '\1', '\234', '8', '\uFFFF', '\234', '8', '\0', '8', '\0', '8', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '8', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\0', '\234', '\0', '8', '\234', '\1', '8', '\0', '\234', '\0', '8', '\1', '\0', '\uFFFF', '8', '8', '\0', '\uFFFF', '\234', '\234', '8', '\1', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\234', '\234', '\234', '\1', '8', '8', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\0', '\0', '8', '\0', '\1', '\0', '\0', '\1', '\234', '\0', '8', '8', '\uFFFF', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0843()
  {
    rc_int = (new BigDecimal("3")).compareTo(new BigDecimal("-2147483648"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0844()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).add(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483644.8", rc_BigDecimal.toString());
  }
  public void testItem_0845()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("10.24")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0847()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("10.24"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0850()
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
  public void testItem_0851()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0852()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0853()
  {
    rc_boolean = (new BigDecimal("0")).equals("97YKELFGFAWRIGTC6XV<0W70?W;N9WD6ISQAUGJ0PH=E;8N20<IJBGKLWR4YVO<DA1?=W6>7@:06GOD:11KJR9SV;<V9X?0;2A?G");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("3")).remainder(new BigDecimal("3"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_int = (new BigDecimal("3")).intValueExact();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0856()
  {
    rc_BigDecimal = (new BigDecimal("10.24")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-2147483644.8")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0858()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0859()
  {
    rc_BigDecimal = (new BigDecimal("10.24")).ulp();
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0860()
  {
    rc_BigDecimal_array = (new BigDecimal("0.01")).divideAndRemainder(new BigDecimal("-2147483644.8"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0861()
  {
    rc_BigDecimal = (new BigDecimal("10.24")).ulp();
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0862()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0863()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-2147483644.8")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0864()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0866()
  {
    rc_int = (new BigDecimal("0.01")).scale();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0867()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).max(new BigDecimal("-2147483644.8"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0868()
  {
    rc_BigInteger = (new BigDecimal("-2147483644.8")).toBigInteger();
    Assert.assertEquals("-2147483644", rc_BigInteger.toString());
  }
  public void testItem_0869()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("3.2"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0870()
  {
    rc_int = (new BigDecimal("-3.2")).intValue();
    Assert.assertEquals(-3, rc_int);
  }
  public void testItem_0871()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0872()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\234', '\234', '\0', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '\1', '8', '\0', '\0', '\1', '\1', '\1', '\234', '\234', '\0', '\0', '\1', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\0', '8', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\234', '\234', '\0', '8', '\234', '\234', '\0', '\0', '\0', '8', '\1', '\234', '8', '\1', '\uFFFF', '\1', '\0', '\234', '8', '\0', '\234', '8', '8', '\0', '\uFFFF', '\0', '\234', '\1', '8', '\1', '\1', '\0', '\0', '\0', '\1', '\234', '\0', '8', '\0', '\1', '\uFFFF', '\234', '\1', '8', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0873()
  {
    rc_BigDecimal = (new BigDecimal("0.01")).min(new BigDecimal("-2147483644.8"));
    Assert.assertEquals("-2147483644.8", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0875()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0876()
  {
    rc_int = (new BigDecimal("-2147483644.8")).compareTo(new BigDecimal("0.01"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0877()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.01")).divide(new BigDecimal("0.01"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0878()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
//  public void testItem_0879()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2")).divideToIntegralValue(new BigDecimal("0.01"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0880()
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
  public void testItem_0881()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0882()
  {
    rc_int = (new BigDecimal("-2147483644.8")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0883()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0885()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(-2147483648, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("-3.2"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0888()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0889()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2E+2")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0890()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\0', '\1', '\1', '8', '8', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '8', '\1', '\1', '\uFFFF', '8', '8', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\0', '8', '\1', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\1', '\234', '\1', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\234', '8', '\0', '\0', '\uFFFF', '\1', '\234', '8', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\0', '\1', '\uFFFF', '\234', '\0', '\1', '\1', '\0', '\234', '8', '\uFFFF', '8', '\234', '8', '\1'}, 1, -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0891()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0892()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("0"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0893()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2")).divide(new BigDecimal("3.2E-2147483646"), -2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0894()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).subtract(new BigDecimal("3.2E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0897()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '8', '\1', '\234', '\234', '\0', '\0', '\1', '\234', '\0', '\234', '\234', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '8', '8', '8', '\234', '\234', '\1', '\0', '\uFFFF', '\0', '\0', '\1', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\0', '8', '\1', '\0', '\1', '\1', '\234', '\0', '\0', '\0', '\1', '\234', '\1', '8', '\0', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\234', '\234', '\1', '8', '\0', '\1', '\1', '\0', '\234', '\234', '\0', '8', '8', '\uFFFF', '8', '8', '\234', '\234', '\1', '\uFFFF', '\234', '\0', '8', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\1', '8', '8', '\uFFFF'}, 0, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0898()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).add(new BigDecimal("3.2E+2"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("316.8", rc_BigDecimal.toString());
  }
  public void testItem_0899()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).multiply(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-10.24", rc_BigDecimal.toString());
  }
//  public void testItem_0900()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-10.24")).divideAndRemainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0901()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).max(new BigDecimal("-10.24"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0902()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).divide(new BigDecimal("316.8"), 0);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_float = (new BigDecimal("3.2E-2147483646")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0905()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0906()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\234', '8', '\0', '\1', '\234', '8', '\1', '\1', '8', '\1', '\uFFFF', '\0', '\1', '\0', '\1', '\234', '\0', '\234', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '8', '\0', '\1', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\0', '\1', '\1', '\0', '\1', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\234', '\234', '\1', '8', '8', '\1', '\0', '\0', '\1', '\0', '\1', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\1', '\1', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\1', '\1', '\1', '\234', '\1', '\uFFFF', '\234'}, -1, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0907()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0908()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0909()
  {
    rc_boolean = (new BigDecimal("-1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0910()
  {
    rc_double = (new BigDecimal("316.8")).doubleValue();
    Assert.assertEquals(316.8, rc_double, 0);
  }
//  public void testItem_0911()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0912()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("316.8")).setScale(1);
    Assert.assertEquals("316.8", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0, 0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_BigInteger = (new BigDecimal("-10.24")).unscaledValue();
    Assert.assertEquals("-1024", rc_BigInteger.toString());
  }
  public void testItem_0916()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0917()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).max(new BigDecimal("316.8"));
    Assert.assertEquals("316.8", rc_BigDecimal.toString());
  }
//  public void testItem_0919()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("-10.24"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("316.8"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    rc_BigInteger = (new BigDecimal("316.8")).toBigInteger();
    Assert.assertEquals("316", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0923()
  {
    rc_boolean = (new BigDecimal("-1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0924()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0925()
  {
    rc_int = (new BigDecimal("316.8")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0926()
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
//  public void testItem_0927()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("316.8")).divideAndRemainder(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0928()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@;70MYH7IHCU?T5=M37=QQABOYFT=H47C<;X=RFNWR6ICXAJK0ITS7W@L4UCI21T=VW<T=9YDB6=?7=@C:PH4I6?QM88GG5;5?KD", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0929()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0930()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("316.8"));
  }
  public void testItem_0931()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0932()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0933()
  {
    rc_int = (new BigDecimal("-10.24")).compareTo(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0934()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("316.8"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("320"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, 0, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).scaleByPowerOfTen(1);
    Assert.assertEquals("-3E+3", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+2")).divide(new BigDecimal("316.8"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0941()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("316.8")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0942()
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
  public void testItem_0943()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).subtract(new BigDecimal("-3E+2"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    rc_BigDecimal = (new BigDecimal("-2")).divide(new BigDecimal("-2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '8', '\1', '8', '\1', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\0', '\234', '\234', '\0', '\1', '\1', '8', '\234', '\0', '\1', '8', '\uFFFF', '\0', '\234', '\234', '\1', '\234'}, 0, 1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0950()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\0', '\uFFFF', '\0', '8', '\234', '\0', '8', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0951()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0952()
  {
    rc_boolean = (new BigDecimal("-1")).equals("UJYAYLW4?8B;TTP810NU>Y;T?@IY@Y>O;D3U;0=7<AK03PBV155M>;215A>L10MD@U08:YYLEYYPK1X2CBYUH468OM4FOB0F74GA");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0953()
  {
    rc_int = (new BigDecimal("0E+2")).scale();
    Assert.assertEquals(-2, rc_int);
  }
  public void testItem_0954()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-3E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0955()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0E+2"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0956()
  {
    rc_int = (new BigDecimal("0E+2")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0957()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-3E+2")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0958()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\0', '\1', '\0', '8', '\234', '8', '\uFFFF', '\0', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0959()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0960()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0961()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).negate();
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    rc_int = (new BigDecimal("3.2E+2")).compareTo(new BigDecimal("-3E+2"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0964()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).add(new BigDecimal("-3E+2"));
    Assert.assertEquals("-6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("-6E+2")).scaleByPowerOfTen(0);
    Assert.assertEquals("-6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    rc_BigDecimal = (new BigDecimal("-6E+2")).plus();
    Assert.assertEquals("-6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0967()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
//  public void testItem_0969()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(-2147483648);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0970()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0971()
  {
    rc_BigDecimal = (new BigDecimal("-6E+2")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-632", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigIntegerExact();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0974()
  {
    rc_BigDecimal = (new BigDecimal("-6E+2")).add(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-5.7E+2", rc_BigDecimal.toString());
  }
  public void testItem_0975()
  {
    rc_short = (new BigDecimal("-632")).shortValueExact();
    Assert.assertEquals(-632, rc_short);
  }
  public void testItem_0976()
  {
    rc_int = (new BigDecimal("3.2E+2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0977()
  {
    rc_BigInteger = (new BigDecimal("-632")).toBigIntegerExact();
    Assert.assertEquals("-632", rc_BigInteger.toString());
  }
  public void testItem_0978()
  {
    rc_short = (new BigDecimal("-5.7E+2")).shortValueExact();
    Assert.assertEquals(-570, rc_short);
  }
  public void testItem_0979()
  {
    rc_int = (new BigDecimal("-632")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0980()
  {
    rc_BigDecimal = (new BigDecimal("-5.7E+2")).setScale(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-570", rc_BigDecimal.toString());
  }
  public void testItem_0981()
  {
    rc_int = (new BigDecimal("3.2E+2")).intValueExact();
    Assert.assertEquals(320, rc_int);
  }
//  public void testItem_0982()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-632")).remainder(new BigDecimal("3.2E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
//  public void testItem_0983()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-570")).hashCode();
//    Assert.assertEquals(-17670, rc_int);
//  }
  public void testItem_0984()
  {
    rc_BigDecimal = (new BigDecimal("-632")).subtract(new BigDecimal("-6E+2"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0985()
  {
    rc_int = (new BigDecimal("-570")).intValueExact();
    Assert.assertEquals(-570, rc_int);
  }
//  public void testItem_0986()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-6E+2")).divideToIntegralValue(new BigDecimal("-6E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0987()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("-570")).min(new BigDecimal("32"));
    Assert.assertEquals("-570", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0991()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E+1")).hashCode();
//    Assert.assertEquals(92, rc_int);
//  }
  public void testItem_0992()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\1', '\1', '\0', '\1', '8', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\234', '\0', '8', '\uFFFF', '8', '8', '\1', '8', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\234', '\0', '\234', '\1', '\1', '\1', '8', '\0', '\234', '\234', '8', '\1', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\1', '\0', '\0', '\1', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\0', '8', '\1', '\1', '\0', '\234', '\234', '\1', '8', '\0', '8', '8', '\234', '\1', '\0', '\0', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\234', '\234'}, -2147483648, 0, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0994()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0995()
  {
    rc_BigDecimal = (new BigDecimal("-32")).add(new BigDecimal("-32"));
    Assert.assertEquals("-64", rc_BigDecimal.toString());
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divideToIntegralValue(new BigDecimal("1E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    rc_byte = (new BigDecimal("-64")).byteValueExact();
    Assert.assertEquals(-64, rc_byte);
  }
  public void testItem_0998()
  {
    rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("-32"));
  }
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("-32")).remainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
}
