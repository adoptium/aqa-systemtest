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
public class TestSuite014 extends TestCase
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
  
  public TestSuite014() {
	
  }
  public void testItem_0000()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).negate();
    Assert.assertEquals("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0001()
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
  public void testItem_0002()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0003()
  {
    rc_int = (new BigDecimal("0E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0004()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0006()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3.2E+2"), 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0009()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).negate(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0013()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0014()
  {
    rc_String = (new BigDecimal("-3.2E+2")).toPlainString();
    Assert.assertEquals("-320", rc_String);
  }
  public void testItem_0015()
  {
    rc_String = (new BigDecimal("-3.2E+2")).toPlainString();
    Assert.assertEquals("-320", rc_String);
  }
  public void testItem_0016()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("3.2E+2"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0017()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0018()
  {
    rc_BigDecimal_array = (new BigDecimal("-3.2E+2")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("8")).divideToIntegralValue(new BigDecimal("3.2E+2"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigInteger = (new BigDecimal("3.2E+2")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0021()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\234', '\234', '\1', '\1', '8', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\0', '\234', '\234', '\0', '\234', '\0', '\0', '\uFFFF', '\234', '\0', '\234', '\0', '\234', '8', '\uFFFF', '\234', '8', '\234', '8', '8', '\1', '8'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0022()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E+2")).setScale(-1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3.2E+2")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("8"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    rc_BigDecimal_array = (new BigDecimal("8")).divideAndRemainder(new BigDecimal("-3.2E+2"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
  }
//  public void testItem_0026()
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
  public void testItem_0027()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0028()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E+2")).abs();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("8")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toEngineeringString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0033()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0034()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0035()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0036()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-2147483648, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("320.0", rc_BigDecimal.toString());
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
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0040()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    rc_long = (new BigDecimal("0.0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0042()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0043()
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
  public void testItem_0044()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).stripTrailingZeros();
	Assert.assertEquals(0.0, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0046()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0047()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0048()
  {
    rc_BigDecimal_array = (new BigDecimal("00.0E+2147483647")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=UP"));
  }
  public void testItem_0049()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0050()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0051()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0052()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0053()
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
  public void testItem_0054()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0055()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0056()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0057()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("00.0E+2147483647")).divideAndRemainder(new BigDecimal("00.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0058()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0061()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0062()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\0', '8', '\uFFFF', '8', '\234', '8', '\0', '\1', '8', '\234', '\234', '\1', '\234', '\234', '\uFFFF', '8', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\234', '8', '8', '8', '\234', '8', '8', '8', '\0', '8', '\1', '\1', '\0', '\234', '8', '\1', '\234', '8', '\234', '8', '8', '\0', '\1', '8', '\uFFFF', '\0', '\1', '8', '\0', '\234', '8', '\uFFFF', '\0', '8', '\0', '\234', '\1', '\1', '\0', '\1', '\uFFFF', '8', '\0', '8', '\234', '\1', '\234', '\0', '\1', '\1', '\1', '\0', '\1', '\1', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\1'}, 0, 2147483647, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0063()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0064()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0068()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0069()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0070()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0072()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0076()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0077()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0079()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0080()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0081()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.2E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0082()
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
  public void testItem_0083()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0086()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("32.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0087()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32.0E+2147483647")).scaleByPowerOfTen(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0089()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("32.0E+2147483647")).toString();
//    Assert.assertEquals("3.2E+2147483648", rc_String);
//  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("4E+1"), 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0092()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0093()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).remainder(new BigDecimal("32"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0094()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\0', '\234', '\234', '\1', '\uFFFF', '8', '\1', '8', '\1', '8', '\uFFFF', '8', '\1', '\0', '\0', '\1', '8', '\1', '\1', '\1', '\234', '\1', '\1', '\1', '\1', '\uFFFF', '\1', '8', '\0', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\1', '8', '\234', '\1', '\1', '\0', '\1', '\1', '\0', '\0', '\234', '\234', '\234', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\1', '8', '\234', '\234', '\1', '8', '8', '\1', '\234', '8', '\0', '8', '\1', '\0', '\1', '\0', '\0', '\1', '8', '\0', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0096()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-4", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\234', '\1', '8', '\uFFFF', '\234', '\1', '\0', '\234', '\234', '\uFFFF', '\1', '\1', '\1', '\0', '\0', '\0', '\0', '\1', '8', '\1', '\234', '\uFFFF', '8', '8', '\0', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\234', '\0', '\234', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '8', '8', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '\0', '\1', '\234', '\uFFFF', '8', '\0', '\1', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\1', '\0', '\1', '\uFFFF', '\1', '\1', '\1', '\234', '\234', '\uFFFF', '\1', '\234', '\234', '\1', '\234', '8', '8', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '8', '\1', '\234'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0099()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-4")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("-4")).min(new BigDecimal("-4"));
    Assert.assertEquals("-4", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\1', '\234', '\uFFFF', '8', '\234', '8', '8', '8', '\1', '8', '\234', '\0', '\234', '\234', '8', '\0', '\234', '\0', '\uFFFF', '\234', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\1', '\1', '\1', '\234', '\0', '8', '\0', '\1', '\0', '\0', '\1', '\uFFFF', '8', '8', '\1', '8', '\234', '\0', '\234', '\234', '\0', '\uFFFF', '\234', '\1', '8', '\1', '8', '\0', '\0', '\0', '\0', '\234', '\0', '\1', '\0', '\uFFFF', '8', '\234', '\234', '8', '8', '8', '\1', '8', '\1', '\1', '\0', '\1', '\234', '\0', '\1', '\234', '\234', '8', '\0', '8', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\1', '8', '\234', '\1', '\1', '8'}, -2147483648, -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0102()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0103()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0104()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0105()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0106()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0107()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("-32")).stripTrailingZeros();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0110()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0111()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '8', '\234', '\1', '8', '\uFFFF', '\234', '8', '\234', '\1', '\0', '\0', '\1', '\234', '\234', '\234', '\0', '8', '8', '8', '\234', '\1', '\uFFFF', '\1', '\0', '8', '\234', '8', '8', '\0', '\0', '\0', '\0', '\0', '\uFFFF', '\1', '\234', '8', '\1', '\234', '8', '8', '\234', '8', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\1', '\0', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '8', '\0', '\1', '\0', '8', '\uFFFF', '\0', '\1', '8', '\0', '\0', '\1', '8', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '\0', '\234', '\234', '\1', '\0', '\0', '\uFFFF', '\234', '\234', '\234', '\0', '\uFFFF', '\0', '\0', '\1', '8', '\uFFFF', '8', '\0', '\1', '\234'}, 1, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-4", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("3.2"));
  }
  public void testItem_0116()
  {
    rc_String = (new BigDecimal("-32")).toEngineeringString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0117()
  {
    rc_BigDecimal_array = (new BigDecimal("1135879015891")).divideAndRemainder(new BigDecimal("0.1"));
  }
  public void testItem_0118()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3.2"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), java.math.RoundingMode.UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0120()
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
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("3.2"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).subtract(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0.0"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0124()
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
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0126()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0128()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0129()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0130()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0131()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0132()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0134()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0135()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0136()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0137()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_int = (new BigDecimal("4E+1")).intValueExact();
    Assert.assertEquals(40, rc_int);
  }
  public void testItem_0139()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("V0VI75FEXCC4KV5:93YB0UW=E<:R?WGI8VFLV8?8?JT5:04T1@XL70=L@CRYGCY8L2HN2J2T0UW:8SG2P?3GJJV2AAQ>CLL8M<KB");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0142()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0143()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0144()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(":D>978=2>54J9>@E?75LI;Y=<42C2OV=?>ET10>6<ULY4OR0SDT04P:IIYWJOX=:5>R@;>");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0145()
  {
    rc_String = (new BigDecimal("0.0")).toPlainString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0146()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0147()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).round(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0151()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0153()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0154()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0155()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1135879015891")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0156()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
//  public void testItem_0157()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0158()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0159()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0160()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0161()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\234', '\1', '\uFFFF', '\234', '\0', '\1', '8', '8', '\234', '8', '\234', '\1', '\0', '8', '\uFFFF', '\0', '\0', '\0', '\1', '\uFFFF', '\234', '8', '8', '\234', '\0', '\0', '\234', '\234', '\uFFFF', '\0', '\0', '\0', '8', '8', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\234', '\0', '\0', '\1', '8', '\0', '\0', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '8', '8', '8', '\234', '\0', '\234', '\uFFFF', '\234', '8', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\0', '\234', '\234', '8', '\1', '\uFFFF', '\1', '\234', '\0', '8', '\0', '\234', '\1', '\uFFFF', '8', '8', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\1', '\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1135879015891"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0163()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0164()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0165()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("?B2<7VQFVVVNVC2VOVE56CW4T25>2HI;@:5CYO@WQ;MQRAJG=LGS1?F>4?E1:WAFVKLQBYJY:5MRUFMRD?<63:T9W?V29:JKQ>Q6");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0168()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("0"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0170()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0171()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0172()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0173()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0174()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\0', '\234', '\234', '8', '\0', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\234', '8', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\234', '\234', '8', '\234', '\1', '\234', '8', '8', '\0', '\234', '\1', '\234', '\0', '\0', '8', '\234', '\uFFFF', '\0', '8', '\1', '\234', '\1', '\234', '\234', '8', '\1', '\1', '\0', '8', '\234', '\1', '8', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '8', '8', '\1', '8', '\0', '\234', '\0', '\1', '\234', '\1', '8', '\234', '\0', '\0', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '8', '\0', '\uFFFF', '8', '8'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0176()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0178()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '8', '\234', '\0', '\234', '\0', '\uFFFF', '8', '\234', '\0', '8', '\1', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\234', '\0', '8', '8', '\uFFFF', '8', '\0', '\234', '\234', '\1', '8', '\0', '\234', '8', '\1', '\0', '8', '\1', '8', '8', '\0', '\0', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\1', '\1', '\1', '\1', '\0', '\uFFFF', '\1', '\1', '8'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0183()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '8', '8', '\234', '\0', '8', '\0', '8', '\234', '8', '\234', '\1', '\1', '\uFFFF', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0184()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\0', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '8', '\0', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\234', '\1', '\1', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '8', '\0', '\0', '\1', '8', '\uFFFF', '8', '\0', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\0', '\0', '\1', '\1', '\1', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\1', '\1', '\uFFFF', '8', '8'}, 1, -1, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0185()
  {
    rc_short = (new BigDecimal("0E+1")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0186()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0187()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0188()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0189()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0190()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0191()
  {
    rc_String = (new BigDecimal("0E+1")).toEngineeringString();
    Assert.assertEquals("0.00E+3", rc_String);
  }
  public void testItem_0192()
  {
    rc_String = (new BigDecimal("0E+1")).toEngineeringString();
    Assert.assertEquals("0.00E+3", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0193()
  {
    rc_boolean = (new BigDecimal("0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0194()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0195()
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
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0198()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0200()
  {
    rc_boolean = (new BigDecimal("0E+1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0201()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0202()
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
  public void testItem_0203()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("2Q2GYK>AABB2TSO=TD6<K2YNV4WU;4L8@FNHW1;=Q>T7D7?>?MIY9>2TS=U3CJWAHK?8SV;560U0SR>420RJ?S7U:XKY<;AL4NA3", new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0204()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0206()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0207()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0208()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0209()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("320.0E+2147483647")).toString();
//    Assert.assertEquals("3.2E+2147483649", rc_String);
//  }
  public void testItem_0210()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0211()
  {
    rc_int = (new BigDecimal("0E+1")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0212()
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
  public void testItem_0213()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0214()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divideToIntegralValue(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0215()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0218()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("LW<RUV5W<UC<7UAV;H4CMR?SHM4G<AS06?N");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0219()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0220()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0221()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0224()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0225()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("XBTPE3D;MRX:LI");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0226()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0228()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("U1T7CW558NCQW9Y2V2X:AXIUC>I7H=S;AAON4KGA:1?VAF=48;0U?S6IDI3GE6R2R7HOI>7NY5GQFFF@EH7>CT=6Q=@99<KFKUQV");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0231()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0232()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0233()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\1', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '8', '\234', '8', '\234', '\1', '8', '8', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\1', '\0', '8', '\1', '\0', '\1', '\uFFFF', '8', '\0', '\1', '\234', '\1', '\234', '\1', '\234', '\0', '8', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\234', '\1', '\234', '\234', '8', '\234', '\0', '\0', '8', '\1', '\234', '\0', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\234', '\0', '8', '\0', '\0', '\234', '\234', '\1', '8', '8', '\234', '\1', '\1', '\uFFFF', '\0', '\234', '\0', '8', '\234'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0234()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2147483647")).hashCode();
//    Assert.assertEquals(2147483617, rc_int);
//  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("-1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("320.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0237()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("320.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0240()
  {
    rc_float = (new BigDecimal("2147483647")).floatValue();
    Assert.assertEquals(2.147483648E9F, rc_float, 0);
  }
  public void testItem_0241()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+2147483647")).setScale(1, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0242()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0243()
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
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0244()
  {
    rc_BigDecimal = (new BigDecimal("-1E+2147483647")).min(new BigDecimal("1"));
    Assert.assertEquals("-1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).max(new BigDecimal("1"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0247()
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
//  public void testItem_0248()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
//  public void testItem_0249()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0250()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
//  public void testItem_0251()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-1E+2147483647")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0252()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0253()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("4XQCM3?AI6HU5@VG8B=DOE@Q?L;WL7SV?TPAE=M=H6GUUKW4K3FW00A73LRX>NPEWKTK>V59EPP59YMMW8G7O5YOXYV3=O25A?M3");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0254()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0255()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("-1E+2147483647")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
//  public void testItem_0256()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("-1E+2147483647"), java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0257()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\1', '\1', '\234', '8', '\uFFFF', '\234', '\1', '\uFFFF'}, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("-1E+2147483647")).abs();
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).setScale(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("2147483647.0", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_int = (new BigDecimal("1E+2147483647")).scale();
    Assert.assertEquals(-2147483647, rc_int);
  }
  public void testItem_0264()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("WR@A6@DR6P?K>TBMS<YM6TF3K?GTG?<3A832TMU8HTRG23KHF?8T;OBYQ=9SPNBCXDQBQ3B@JF4WY475L4@<7:G??AAB4ICS>SA:");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0265()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("1E-2147483647")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0266()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).divide(new BigDecimal("1E+2147483647"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0267()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("1135879015891"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0269()
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
//  public void testItem_0270()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1E+2147483647"), java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0271()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("SFJII134HWVBHN2TX:A0JVYFX0PYH0QSUE6NNELF38=28TJ4K;LIXSKB>AM2R1");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0272()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1135879015891")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0275()
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
  public void testItem_0276()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0277()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0.1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
  }
  public void testItem_0278()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0279()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).divide(new BigDecimal("1"), 2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0280()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0281()
  {
    rc_BigInteger = (new BigDecimal("1135879015891")).toBigInteger();
    Assert.assertEquals("1135879015891", rc_BigInteger.toString());
  }
  public void testItem_0282()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  // Excluded temporarily because performance of remainder with large exponents is very slow (many minutes).
  // At MAXINT exponent IBM Java returns 1E+2147483647.
  //public void testItem_0284()
  //{
  //  rc_BigDecimal = (new BigDecimal("1E+2147483647")).remainder(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
  //  Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  //}
  public void testItem_0285()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).multiply(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0286()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0287()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).subtract(new BigDecimal("1E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0.1"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0291()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0E+2147483647")).divide(new BigDecimal("3.2E+2"), 1, java.math.RoundingMode.HALF_UP);
//    Assert.assertEquals("0.0", rc_BigDecimal.toString());
//  }
  public void testItem_0292()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).multiply(new BigDecimal("32"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0296()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0297()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0300()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '8', '8', '8', '\0', '\0', '\uFFFF', '\234', '8', '\uFFFF', '8', '8', '\234', '\uFFFF', '8', '\234', '\1', '8', '\1', '8', '\uFFFF', '\234', '\234', '\234', '8', '\uFFFF', '\0', '\0', '8', '\234', '\0', '8', '\1', '8', '8', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\234', '8', '8', '8', '8', '\uFFFF', '\234', '\234', '8', '\uFFFF', '8', '\0', '8', '\1', '\uFFFF', '8', '\1', '\234', '8', '\0', '8', '\uFFFF', '8', '\0', '\1', '8'}, -1, 0, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0301()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0302()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+2147483647")).divideToIntegralValue(new BigDecimal("0E+2147483647"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0303()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '\234', '8', '\0', '\234', '\uFFFF', '\234', '\1', '\1', '\234', '\0', '8', '\1', '\0', '\1', '\0', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\1'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).round(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\234', '\0', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\0', '8', '8', '\1', '\234', '8', '\1', '\234', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '8', '\234', '8', '\234', '\1', '\uFFFF', '\1', '\234', '\234', '\0', '\uFFFF', '\0', '\234', '8', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\234', '\234', '\234', '\234', '\uFFFF', '\1', '8', '\1', '\0', '\0', '8', '\0', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '8', '\234', '\uFFFF', '\234', '\1', '\0', '\234'}, 0, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0309()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\234', '\0', '\234', '8', '\1', '\234', '\234', '\uFFFF', '8', '8', '\1', '\234', '\0', '\uFFFF', '8', '8', '\234', '\234', '\0', '\uFFFF', '8', '\234', '\1', '\234', '\234', '\234', '8', '\234', '\uFFFF', '\1', '\0', '\1', '8', '\0', '\0', '\uFFFF', '\0', '8', '8', '\234', '8', '\1', '\uFFFF', '\234', '\1', '\1', '\0', '\1', '\1', '8', '8', '\uFFFF', '8', '\1', '\uFFFF', '8', '\234', '\1', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\234'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0310()
  {
    rc_BigInteger = (new BigDecimal("0E+2147483647")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0311()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\1', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\1', '\1', '8', '\234', '\0', '\0', '\1', '8', '\234', '\234', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '8', '8', '\234', '\1', '8', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\1', '\0', '\234', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\0', '8', '\1', '8', '\234', '\234', '8', '\1', '\0', '8', '\1', '\1', '\0', '8', '8', '\1', '\0', '\0', '\1', '\1', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '8', '8', '8', '\0', '8', '8', '\234', '\234', '\0', '8', '\1', '\uFFFF', '8', '\1', '\234', '\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0312()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("-1"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_double = (new BigDecimal("0E+1")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0317()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0.0"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0318()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0319()
  {
    rc_long = (new BigDecimal("0.0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0320()
  {
    rc_int = (new BigDecimal("0E+2147483647")).compareTo(new BigDecimal("0.0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0321()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0322()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("RK0UVA<I6M=F7NI7RG:8=4VQ?2G828JPQG:0V4U1=V051R>JU<JXX96RMDELPX@505CFVU85LT4YLPL?K2KGYY<JX0MI4:S1@<@?", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0323()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_double = (new BigDecimal("0.0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0326()
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
  public void testItem_0327()
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
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0333()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0334()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("DYQI30M1U6RU@Q9D@<S=I2:WU=@SU7@Y:7SEJ8TEA7E9R8IVR4M4QFEUYDXWH8F");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0335()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0337()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).toBigInteger();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
//  public void testItem_0338()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0339()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0342()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0343()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0345()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0346()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0347()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("2147483647"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("HXWQL22USH9LBMVL>0Y2UN21@;M7H2R>:03T9=SR<X8S6LPWITS@E:DFDI2?0YB=F48HA7TLC9AL;AP9XBAAGT=;AKDNYOW>KJ6:");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0350()
  {
    rc_String = (new BigDecimal("2147483647")).toPlainString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0351()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    rc_long = (new BigDecimal("0E+1")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0353()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0354()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_BigDecimal_array = (new BigDecimal("2147483647")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0356()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("1"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).max(new BigDecimal("0E+1"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
//  public void testItem_0359()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2147483647")).hashCode();
//    Assert.assertEquals(2147483617, rc_int);
//  }
  public void testItem_0360()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\1', '\1', '8', '\0', '\uFFFF', '\0', '\1', '\1', '\234', '\0', '\0', '\234', '\0', '\1', '\0', '8', '\0', '8', '8', '\uFFFF', '\0', '8', '\234', '8', '\1', '\1', '\1', '8', '8', '\1', '8', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0362()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).stripTrailingZeros();
	Assert.assertEquals(0E+1, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0363()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("32"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0364()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("1"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
//  public void testItem_0368()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0369()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("0E+1"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0370()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0372()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0373()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0374()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0375()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0379()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '8', '\1', '8', '\1', '\234', '\234', '\234', '\0', '\1', '8', '\0', '\1', '\1', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\1', '8', '8', '8', '\234', '\234', '\234', '\234', '\1', '8', '\1', '\uFFFF', '\1', '8', '8', '\234', '8', '\0', '\0', '\1', '8', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\1', '\0', '\234', '\234', '\uFFFF', '8'}, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0380()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("C233?JSSC024IU;526H1UPNR:6Q:>:D33IGNFMB7QAX29AT6FQ4A3;2B?LE=>HOU;;6C1EOWP5CR>DA55:O8:PKR>?MJCOCG5F<X");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0381()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0382()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0384()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("10"), 1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0385()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0386()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10")).divide(new BigDecimal("2147483647"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0387()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0388()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_String = (new BigDecimal("2147483647")).toEngineeringString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0392()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '8', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '8', '\1', '\234', '\uFFFF', '8', '\1', '\1', '8', '\1', '\1', '\1', '8', '\234', '\234', '\1'}, -2147483648, -2147483648, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0393()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).negate(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\234', '\234', '8', '8', '8', '\0', '\uFFFF', '8', '\0', '\0', '8', '\234', '\234', '\234', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '8', '\0', '8', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\0', '8', '8', '\uFFFF', '\234'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0396()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0397()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0398()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0401()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0402()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0403()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0404()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0405()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-32"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0406()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("-32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0411()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0412()
  {
    rc_BigDecimal = (new BigDecimal("-32")).remainder(new BigDecimal("3.2E+2"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0415()
  {
    rc_BigDecimal = (new BigDecimal("-32")).multiply(new BigDecimal("3.2E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1.024E+4", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0417()
  {
    rc_int = (new BigDecimal("3.2E+2")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0418()
  {
    rc_BigDecimal_array = (new BigDecimal("-1.024E+4")).divideAndRemainder(new BigDecimal("3.2E+2"));
  }
  public void testItem_0419()
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
  public void testItem_0420()
  {
    rc_BigDecimal = (new BigDecimal("-1.024E+4")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1.024E+4", rc_BigDecimal.toString());
  }
  public void testItem_0421()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0422()
  {
    rc_boolean = (new BigDecimal("-1.024E+4")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0423()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0424()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0426()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0427()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0428()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(2147483647, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0429()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0430()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0432()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0433()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0434()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0435()
  {
    rc_boolean = (new BigDecimal("32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0436()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\234', '8', '\0', '\1', '8', '\uFFFF', '\234', '\0', '8', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\0', '\0', '\0', '8', '\234', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\234', '\1', '8', '\0', '\0', '\1', '\uFFFF', '\0', '\234', '\0', '\0', '\1', '\uFFFF', '8', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\0', '8', '\1', '8', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\0', '\0', '8', '\0', '\1', '\uFFFF', '\0', '8', '\234', '\0', '\234', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0437()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0440()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\0', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\0', '\0', '8', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\234', '\0', '8', '8', '\uFFFF', '\1', '\1', '8', '\0', '\0', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\0', '\0', '8', '8', '\234', '\234', '\234', '8', '\234', '\uFFFF', '8', '\0', '\234', '8', '8', '\234', '\234', '\0', '\0', '\1', '\0', '\uFFFF', '\0', '8', '\uFFFF', '8', '\0', '\0', '\1', '\234', '8', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\1', '8', '\234', '\0', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\234'}, 1, 2147483647);
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0441()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0442()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0443()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0446()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=1 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0447()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0448()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0449()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0450()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0452()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0453()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0454()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0455()
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
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(-2147483648);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0457()
  {
    rc_boolean = (new BigDecimal("-1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0458()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0459()
  {
    rc_boolean = (new BigDecimal("-1")).equals("8D66L8Q1TQX?CT:;1@C>XI:I>R=W5OG@3O88YJU507I2E06699M:1CELTLT26EBP:BVH<9TTF@;UD>6TP?MG@X=B;X66AOISTCAD");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0462()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("0E-2147483647")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    catch (java.lang.OutOfMemoryError e) {
    	if (e.getMessage().contains("too large")) {
    		caught = true;
    	}
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0464()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0465()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0466()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8', '\234', '\234', '\uFFFF', '\1', '\1', '8', '8', '\0', '\uFFFF', '\0', '\0', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0470()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("1E-2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0471()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1E-2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0472()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).stripTrailingZeros();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1E-2147483647")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0475()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("X>MON<HF<V@3IT4P4?406<E?LEEWRBMI2SVT@KE581UGEIHCLDW95X3AT6VS8KOO7XA477AEYP2QT=2P32YA1KN2UM0855GVSC>T");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0477()
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
//  public void testItem_0478()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1E-2147483647")).hashCode();
//    Assert.assertEquals(-2147483618, rc_int);
//  }
  public void testItem_0479()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("?Y6<GL4");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(1);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0482()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1135879015891")).hashCode();
//    Assert.assertEquals(2107853717, rc_int);
//  }
  public void testItem_0483()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("EO>3WJ7COWS68KWP18CNYY420@Y4WG24N1X1OCU0J113UIR;PEJRIC<EC?E1BM322BUJ<32GTOM3EDOBEM9:;07@B", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0484()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0485()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1E-2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0486()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-2147483647")).divide(new BigDecimal("-1"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("-1"), 0);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1E-2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0489()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0491()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0492()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("1E-2147483647"), 2147483647, 1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).scaleByPowerOfTen(1);
    Assert.assertEquals("-2.147483648E+10", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    rc_double = (new BigDecimal("-2.147483648E+10")).doubleValue();
    Assert.assertEquals(-2.147483648E10, rc_double, 0);
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("-2.147483648E+10")).max(new BigDecimal("1E-2147483647"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0499()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-2147483647")).subtract(new BigDecimal("-2147483648"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0500()
  {
    rc_int = (new BigDecimal("0E-2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0501()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("X1>JE58MRTNP6==N1E3MJF71OXXAVMWV<MUT>;@67TFV9U31O85U927XW207T164U1VTH7IG><DT>3>EVWPN>GT3YY9GUE81");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0502()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("1E-2147483647")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    catch (java.lang.OutOfMemoryError e) {
    	if (e.getMessage().contains("too large")) {
    		caught = true;
    	}
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0503()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0504()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0505()
  {
    rc_BigInteger = (new BigDecimal("1E-2147483647")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0506()
  {
    rc_BigDecimal = (new BigDecimal("-2.147483648E+10")).movePointRight(0);
    if (JavaSpecVersionChecker.isJDKWithin13And19()) {
    	Assert.assertEquals("-2.147483648E+10", rc_BigDecimal.toString());
    } else {
    	Assert.assertEquals("-21474836480", rc_BigDecimal.toString());
    }
  }
  public void testItem_0507()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1E-2147483647")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0508()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-21474836480")).divide(new BigDecimal("-21474836480"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("-21474836480")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-2147483648.0", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).stripTrailingZeros();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0513()
  {
    rc_BigDecimal = (new BigDecimal("-2.147483648E+10")).multiply(new BigDecimal("1E-2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2.147483648E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0514()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0515()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0516()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1E-2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0518()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).plus();
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toEngineeringString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0520()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).divideToIntegralValue(new BigDecimal("-2.147483648E-2147483637"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    rc_int = (new BigDecimal("1E-2147483647")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0523()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0524()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).max(new BigDecimal("1E-2147483647"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("1E-2147483647")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    catch (java.lang.OutOfMemoryError e) {
    	if (e.getMessage().contains("too large")) {
    		caught = true;
    	}
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0527()
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
  public void testItem_0528()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("1E-2147483647"), 2147483647, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0529()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).max(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_int = (new BigDecimal("1E-2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0531()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
//  public void testItem_0532()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-2147483647")).divide(new BigDecimal("1E-2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0533()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0534()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).stripTrailingZeros();
	Assert.assertEquals(0.0, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0536()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0537()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("320.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("32", rc_BigInteger.toString());
//  }
  public void testItem_0538()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("320.0E+2147483647")).divideAndRemainder(new BigDecimal("1E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0539()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus(new MathContext("precision=0 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0540()
  {
    rc_int = (new BigDecimal("1E-2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).round(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0543()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("320.0E+2147483647"), java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
//  public void testItem_0544()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("1E-2147483647"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0545()
  {
    rc_short = (new BigDecimal("0E-2147483647")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0546()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).add(new BigDecimal("1E-2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0548()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483647")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
//  public void testItem_0549()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("1"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
//  public void testItem_0550()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("2E-2147483647")).toBigInteger();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0551()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0552()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).remainder(new BigDecimal("2E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0555()
  {
    rc_int = (new BigDecimal("2E-2147483647")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0556()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\0', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\uFFFF', '\0', '8', '8', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\1', '\1', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\234', '\1', '\1', '\234', '\1', '\uFFFF', '\0', '\1', '\234', '\0', '\uFFFF', '\1', '\0', '8', '\234', '\1', '\1', '\234', '8', '\1', '8', '8', '\0', '8', '\0', '\234', '\uFFFF', '\1', '\0', '\0', '8', '\234', '\234', '\0', '8', '8', '8', '\uFFFF', '8', '\uFFFF', '8', '\1', '8', '\234', '\234', '\uFFFF', '\234', '\1', '\234', '\234', '\1', '\234', '\234', '\0', '\uFFFF', '\234', '8', '\234', '8', '\uFFFF', '\0', '\1', '8', '8', '\0', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0560()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("1E-2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).plus();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0567()
  {
    rc_int = (new BigDecimal("1E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0568()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 2147483647, 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0569()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0570()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).remainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0571()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("0E-2147483647")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    catch (java.lang.OutOfMemoryError e) {
    	if (e.getMessage().contains("too large")) {
    		caught = true;
    	}
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0572()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).plus(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
//  public void testItem_0575()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0576()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0577()
  {
    rc_float = (new BigDecimal("0E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
//  public void testItem_0578()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1E-2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("1E-2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0580()
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
  public void testItem_0581()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0582()
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
  public void testItem_0583()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0584()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).min(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0585()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\234', '8', '\1', '\uFFFF', '\234', '\0', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\1', '\1', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\0', '8', '\0', '\1', '\uFFFF', '\1', '\0', '\234', '\234', '8', '\1', '\0', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\234', '\234', '\234', '8', '\0', '\0', '\uFFFF', '\0', '8', '\1', '\0', '\234', '8', '\uFFFF', '\234', '\uFFFF', '8', '8', '8', '\0', '\0', '\0', '\0', '8', '\0', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0588()
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
  public void testItem_0589()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0590()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\1', '\0', '8', '\0', '\234', '\uFFFF', '8', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\0', '\234', '\0', '8', '8', '\1', '\0', '8', '8', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\234', '\1', '\234', '\0', '\0', '\234', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\234', '8', '\0', '\234', '\0', '\0', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0591()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9223372036854775807")).hashCode();
//    Assert.assertEquals(2147482656, rc_int);
//  }
  public void testItem_0592()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0593()
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
  public void testItem_0594()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("9223372036854775807"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0595()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0598()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=FLOOR"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0599()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("7U@80WVHJ43SV45910HQBIRY6FKGMGXM@PV46?J5??VOI7XY3GU?");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0600()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0601()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0602()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0603()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0604()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(1);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0607()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-2147483647")).setScale(-2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0608()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).remainder(new BigDecimal("1E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0611()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).movePointRight(2147483647);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0614()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).abs(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).scaleByPowerOfTen(0);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).stripTrailingZeros();
    Assert.assertEquals(0E-2147483646, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0617()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    rc_long = (new BigDecimal("0E-2147483646")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0619()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("0E-2147483646"), new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0620()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483646")).divideAndRemainder(new BigDecimal("1E-2147483647"), new MathContext("precision=1 roundingMode=FLOOR"));
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).subtract(new BigDecimal("0E-2147483646"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0624()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0625()
  {
    rc_boolean = (new BigDecimal("0")).equals("L58F3G0@O@NAIU");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0626()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toEngineeringString();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_String);
  }
  public void testItem_0630()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+1074", rc_BigDecimal.toString());
  }
  public void testItem_0631()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0632()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0633()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0634()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0635()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1074", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0637()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0638()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).precision();
    Assert.assertEquals(751, rc_int);
  }
  public void testItem_0639()
  {
    rc_BigDecimal = (new BigDecimal("0E+1074")).setScale(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("0E+1074")).multiply(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+1074", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigDecimal = (new BigDecimal("0E+1074")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\1', '\1', '8', '8', '\1', '\0', '\234', '\1', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\234', '8', '\234', '8', '\234', '8', '\234', '\234', '\234', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\234', '\0', '\234', '8', '\0', '\234', '\uFFFF', '\234', '\0', '\0', '\1', '8', '8', '\234', '\1', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\234', '\1', '8', '8', '\234', '8', '8', '\1', '\234', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '8', '8', '\0', '\1', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\234', '8'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0646()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0647()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0648()
  {
    rc_int = (new BigDecimal("3.2")).intValue();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0649()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0650()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0651()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\234', '\0', '\234', '\0', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\0', '\1', '\0', '\0', '\1', '\1', '\234', '8', '8', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\0', '8', '\234', '\0', '\1', '\234', '\234', '8', '\234', '\1', '8', '8', '8', '8', '\234', '\1', '8', '\0', '\1', '8', '\1', '\234', '\1', '\1', '\234', '\uFFFF', '8', '\1', '\1', '8', '8', '8', '\uFFFF', '\uFFFF', '\1', '\1', '8', '8', '\0', '\0', '\234', '\0', '\1', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\1', '\1', '\234', '\uFFFF', '8', '\1', '\0', '8', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF'}, 0, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0652()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0653()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("3.2"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("0"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0659()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"), java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0660()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0661()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0662()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0, 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0663()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0664()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0666()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("3.2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0667()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0668()
  {
    rc_float = (new BigDecimal("3.2")).floatValue();
    Assert.assertEquals(3.200000047683716F, rc_float, 0);
  }
  public void testItem_0669()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("0"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigIntegerExact();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0672()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0673()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("6.4", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("3.2"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0675()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("6.4"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0676()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    rc_BigDecimal = (new BigDecimal("6.4")).max(new BigDecimal("0"));
    Assert.assertEquals("6.4", rc_BigDecimal.toString());
  }
  public void testItem_0678()
  {
    rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("3.2"));
  }
  public void testItem_0679()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0680()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).remainder(new BigDecimal("3.2"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0681()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(2147483647, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0684()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointLeft(0);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("M?", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0691()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0692()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointLeft(1);
    Assert.assertEquals("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0694()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0698()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0699()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\0', '\234', '8', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0700()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0701()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0703()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0704()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0705()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0706()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0707()
  {
    rc_int = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).precision();
    Assert.assertEquals(309, rc_int);
  }
  public void testItem_0708()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0709()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0711()
  {
    rc_BigInteger = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).toBigInteger();
    Assert.assertEquals("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836", rc_BigInteger.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
//  public void testItem_0714()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\0', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '\234', '8', '\1', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\234', '8', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '8', '\234', '\0', '\0', '\uFFFF', '\234', '\1', '\0', '\234', '\234', '\uFFFF', '\1', '\234', '8', '8', '\1', '\uFFFF', '\0', '\0', '\234', '\234', '\0', '8', '\234', '8', '\234', '\0', '\234', '8', '\234', '\0', '\234', '\uFFFF', '\1', '\1', '\234', '\0', '8', '\234', '\uFFFF', '\1', '\1', '8', '\234', '\1', '\1', '\1', '\1', '\1', '8', '\0', '\0', '\234', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\0', '8', '8', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\1'}, 1, 2147483647);
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0717()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0721()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0722()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0723()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0724()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("0"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_int = (new BigDecimal("2147483647")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0727()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0729()
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
  public void testItem_0730()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).setScale(1, 1);
    Assert.assertEquals("2147483647.0", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0733()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("QV4=KN4Y=NIP0FQKX9U?KQM4LNSLF>4S?O4=QK=P2WB:A:ORG99@AOSER@FFTTPV71V9VN3A5@7AJ8WXH>FLBBTC@ILMF?SC7TSP");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0734()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0735()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0736()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0737()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0738()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0739()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0741()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("-32")).plus();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0746()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0747()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0751()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0752()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0753()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0754()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0755()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0756()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0757()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).movePointLeft(0);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0760()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0761()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0762()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0763()
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
  public void testItem_0764()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).min(new BigDecimal("32"));
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0769()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0770()
  {
    rc_long = (new BigDecimal("32.0")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0771()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0772()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
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
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).subtract(new BigDecimal("3.2E+2"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0777()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<218N6EC13732D;AD0P35B;;HI6R8JXOQKJ<C:72=7E1S=1UGOF5C>9MDDENU", new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0779()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32.0")).divide(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0780()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 2147483647, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0.0"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    rc_double = (new BigDecimal("32.0")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0783()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0786()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0787()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).min(new BigDecimal("1.0"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    rc_BigInteger = (new BigDecimal("0.0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0791()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"), 1, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0792()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0793()
  {
    rc_boolean = (new BigDecimal("1")).equals("6V31;F20T9SRETNCJ@SL2H><:4UHKYQ1@2");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0794()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).subtract(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("64")).add(new BigDecimal("32"));
    Assert.assertEquals("96", rc_BigDecimal.toString());
  }
  public void testItem_0796()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\0', '\234', '\234', '8', '\234', '\uFFFF', '8', '\0', '\234', '\1', '\1', '\0', '8', '\1', '\1', '\1', '\1', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\0', '8', '\1', '\0', '8', '\uFFFF', '8', '\0', '\0', '\234', '\uFFFF', '\1', '\234', '\0', '8', '\234', '\234', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0798()
  {
    rc_BigDecimal = (new BigDecimal("96")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("96", rc_BigDecimal.toString());
  }
  public void testItem_0799()
  {
    rc_BigDecimal = (new BigDecimal("64")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0800()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("96"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0801()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=0 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0802()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LB;IV@<<QK>RTSBX<ANS:M871GV8H2O");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0803()
  {
    rc_int = (new BigDecimal("0.0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0804()
  {
    rc_BigDecimal = (new BigDecimal("64")).subtract(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("64.0", rc_BigDecimal.toString());
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("64.0")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("64.0", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0807()
  {
    rc_boolean = (new BigDecimal("0.0")).equals("FHETO@XUAO87NN1;51N0@P5@TD;AGB:CT;=K??TKTY2X2JDPHTWO:>>=");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0808()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0.0"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
//  public void testItem_0810()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("64.0")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0811()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divideToIntegralValue(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0813()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("96"));
    Assert.assertEquals("96", rc_BigDecimal.toString());
  }
  public void testItem_0814()
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
  public void testItem_0815()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0817()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).plus();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    rc_BigDecimal = (new BigDecimal("96")).max(new BigDecimal("64.0"));
    Assert.assertEquals("96", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divideToIntegralValue(new BigDecimal("0.1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0821()
  {
    rc_BigDecimal = (new BigDecimal("96")).divide(new BigDecimal("96"), 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0822()
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
  public void testItem_0823()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("96")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0824()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
//  public void testItem_0826()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("64.0")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
//    Assert.assertEquals("-6E+1", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0827()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -1, 0, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0828()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("96")).negate();
    Assert.assertEquals("-96", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_BigDecimal_array = (new BigDecimal("-96")).divideAndRemainder(new BigDecimal("-96"), new MathContext("precision=1 roundingMode=FLOOR"));
  }
  public void testItem_0831()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0832()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_BigDecimal_array = (new BigDecimal("0.1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0834()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0835()
  {
    rc_String = (new BigDecimal("-6E+1")).toString();
    Assert.assertEquals("-6E+1", rc_String);
  }
  public void testItem_0836()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("NRVRGPAV4=E2QLHVW7>SJ42XTHMT7UU;W0O<GK9<02MBC?=:D6O6T6JKS@JLCBNMYCD=;T1HTWFNV1NMY:K<8YT39RP2KY8NE7O4", new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0837()
  {
    rc_BigDecimal = (new BigDecimal("-6E+1")).divideToIntegralValue(new BigDecimal("-6E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0838()
  {
    rc_BigInteger = (new BigDecimal("-6E+1")).toBigInteger();
    Assert.assertEquals("-60", rc_BigInteger.toString());
  }
  public void testItem_0839()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0840()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("MUES07RBX52F@ASCQO6OA86HH4OF?2FNI:DH<VK94SVM@?D1H21=DBOX7TH3?VUQNRI4V:23<KBTU3M2>9W70JSO<0;D0I>1=MW>");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0841()
  {
    rc_float = (new BigDecimal("320.0E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0842()
  {
    rc_double = (new BigDecimal("-96")).doubleValue();
    Assert.assertEquals(-96.0, rc_double, 0);
  }
  public void testItem_0843()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0844()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0845()
  {
    rc_float = (new BigDecimal("320.0E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0846()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0851()
  {
    rc_String = (new BigDecimal("8")).toPlainString();
    Assert.assertEquals("8", rc_String);
  }
  public void testItem_0852()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("8"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0853()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("SY1?LJWPT2757;14VS=8Q5G3J5W>L2?6F2T6JKTOXM8K>3U4Y67V>86CT;7KB74WP1L9T4:72OG0@?K15T002N5WTL1S;938KE04", new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("-96")).divide(new BigDecimal("8"), 1);
    Assert.assertEquals("-12", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_BigDecimal = (new BigDecimal("-96")).max(new BigDecimal("-12"));
    Assert.assertEquals("-12", rc_BigDecimal.toString());
  }
  public void testItem_0856()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-96")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0857()
  {
    rc_double = (new BigDecimal("8")).doubleValue();
    Assert.assertEquals(8.0, rc_double, 0);
  }
//  public void testItem_0858()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("-12"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
//  public void testItem_0859()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("-12"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0860()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("00.0E+2147483647"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0861()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0862()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-12")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0863()
  {
    rc_byte = (new BigDecimal("8")).byteValueExact();
    Assert.assertEquals(8, rc_byte);
  }
  public void testItem_0864()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0866()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("1"), java.math.RoundingMode.DOWN);
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0867()
  {
    rc_BigInteger = (new BigDecimal("8")).toBigInteger();
    Assert.assertEquals("8", rc_BigInteger.toString());
  }
  public void testItem_0868()
  {
    rc_String = (new BigDecimal("8")).toEngineeringString();
    Assert.assertEquals("8", rc_String);
  }
  public void testItem_0869()
  {
    rc_int = (new BigDecimal("8")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0870()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("8")).remainder(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=FLOOR"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0871()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0872()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0873()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0874()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).multiply(new BigDecimal("00.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
//  public void testItem_0875()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).subtract(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=FLOOR"));
//    Assert.assertEquals("-4E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0876()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0877()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("320.0E+2147483647")).longValue();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0878()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0879()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("00.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0880()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("320.0E+2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0881()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0882()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0885()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0886()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointLeft(-1);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    rc_String = (new BigDecimal("2147483647")).toEngineeringString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0890()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0891()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("T@I9<EN7>YN;C3>V2=PI9H");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0892()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0893()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0894()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("0E-2147483647"), java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0895()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("2147483647"));
  }
  public void testItem_0896()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0897()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2147483647"), -1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0898()
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
  public void testItem_0899()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("0E-2147483647"), 1, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0900()
  {
    rc_int = (new BigDecimal("2147483647")).intValue();
    Assert.assertEquals(2147483647, rc_int);
  }
//  public void testItem_0901()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("0E-2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0902()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).plus();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_long = (new BigDecimal("2147483647")).longValueExact();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0905()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0906()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0907()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0908()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).min(new BigDecimal("2147483647"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    rc_long = (new BigDecimal("2147483647")).longValueExact();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0910()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("3.2E-2147483646"));
  }
  public void testItem_0911()
  {
    rc_double = (new BigDecimal("0E-2147483647")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0912()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("6.710886396875E+2147483654", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("2147483647"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_int = (new BigDecimal("2147483647")).intValue();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0915()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate();
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0916()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("3.2E-2147483646"), 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0917()
  {
    rc_String = (new BigDecimal("2147483647")).toPlainString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0918()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(2147483647);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0921()
  {
    rc_long = (new BigDecimal("2147483647")).longValue();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0922()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0923()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-2147483647")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).max(new BigDecimal("2147483647"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-2147483647"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0926()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483647")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0927()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0928()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0929()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0930()
  {
    rc_BigInteger = (new BigDecimal("3.2E+2")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0931()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_int = (new BigDecimal("2147483647")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0933()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483647")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0935()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\0', '\0', '8', '\1', '\234', '8', '8', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\1', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\0', '\234', '8', '8', '\1', '\1', '\1', '\234', '\uFFFF', '\0', '8', '\0', '\1', '\0', '\234', '\0', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '8', '8', '\234', '8', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\0', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '8', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0936()
  {
    rc_int = (new BigDecimal("2147483647")).intValueExact();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0937()
  {
    rc_String = (new BigDecimal("2147483647")).toPlainString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0938()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0942()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0943()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-2147483647")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0944()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483647")).setScale(2147483647, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0945()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0946()
  {
    rc_long = (new BigDecimal("2147483647")).longValue();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0947()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0948()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("MXXT4U6I70PH:43<TX:V>V@>O:3L6PU@P97SOXIHL<;@96IWE?N4>N@XFL8<M8KNV5H=JCSY<ADRNW?V?K;LVC1;GUNJQY0:>500");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0949()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).movePointLeft(2147483647);
    Assert.assertEquals("1.135879015891E-2147483635", rc_BigDecimal.toString());
  }
  public void testItem_0951()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1.135879015891E-2147483635")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-2147483647"), 0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).add(new BigDecimal("-2147483647"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-4294967294", rc_BigDecimal.toString());
  }
  public void testItem_0954()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0955()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1.135879015891E-2147483635")).hashCode();
//    Assert.assertEquals(-39629932, rc_int);
//  }
//  public void testItem_0956()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("-2147483647")).abs(new MathContext("precision=1 roundingMode=FLOOR"));
//    Assert.assertEquals("3E+9", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0957()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0958()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0960()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0961()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0962()
  {
    rc_boolean = (new BigDecimal("32")).equals("QSPI>M:;P;NDAC5ESRTJ5K?AK359JO@XO3R6?UL5UC@8<@@@LRF;J6ID=ISI7RWTOB3JEC595I8ES@30;U427<G87G");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0965()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).divide(new BigDecimal("0"), -2147483648, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0966()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0967()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0970()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0971()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0972()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0974()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0975()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0976()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("1"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0978()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0979()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0981()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0982()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0983()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0984()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0985()
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
  public void testItem_0986()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1.135879015891E-2147483635"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0987()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0988()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("1.135879015891E-2147483635")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    catch (java.lang.OutOfMemoryError e) {
    	if (e.getMessage().contains("too large")) {
    		caught = true;
    	}
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0989()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0990()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0991()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0992()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0993()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0994()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0995()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("?CVJPFB30K?:?Q?VAQMC0I04@79NO<?X=B4:J5K:5SW7MDU;ET5@4J;VS8ENN?C", new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0998()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("3.2E+2"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
}
