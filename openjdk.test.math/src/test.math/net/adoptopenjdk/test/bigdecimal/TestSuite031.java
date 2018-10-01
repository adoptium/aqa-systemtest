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
public class TestSuite031 extends TestCase
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
  
  public TestSuite031() {
	
  }
  public void testItem_0000()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0001()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
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
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0003()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\1', '\234', '\uFFFF', '\234', '8', '8', '\0', '8', '\uFFFF', '\1', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\0', '\0', '\0', '\0', '8', '\0', '\234', '8', '\0', '\0', '\uFFFF', '8', '\0', '8', '\234', '\234', '\234', '\uFFFF', '\234', '8', '\0', '\234', '\0', '\0', '\1', '\234', '\234', '\0', '\0', '\0', '\1', '\234', '\234', '\0', '8', '\1', '8', '\1', '\0', '\uFFFF'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0004()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).round(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\1', '\0', '\1', '\0', '\234', '\0', '8', '\234', '\1', '\0', '\234', '\234', '\234', '\1', '\0', '\234', '\uFFFF', '\0', '\0', '\1', '\1', '8', '\uFFFF', '\1', '\0', '\0', '8', '8', '\0', '\0', '8', '\0', '\234', '\234', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\234', '\1', '8', '\0', '8', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\1', '8', '\234', '\0', '\1', '\1', '\1', '8', '8', '8', '\uFFFF', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).round(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0009()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).add(new BigDecimal("-2147483680"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483679.96875", rc_BigDecimal.toString());
  }
//  public void testItem_0010()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483679.96875")).divide(new BigDecimal("-2147483680"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), 1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1E+2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0013()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_int = (new BigDecimal("1E+2147483647")).scale();
    Assert.assertEquals(-2147483647, rc_int);
  }
  public void testItem_0015()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0016()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    rc_BigDecimal = (new BigDecimal("-2147483680")).movePointLeft(2147483647);
    Assert.assertEquals("-2.147483680E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0018()
  {
    rc_BigDecimal = (new BigDecimal("-2147483680")).setScale(1, 0);
    Assert.assertEquals("-2147483680.0", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("-2.147483680E-2147483638")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483680")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0022()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-2.147483680E-2147483638")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0027()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0028()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("-2147483680.0")).movePointLeft(0);
    Assert.assertEquals("-2147483680.0", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0034()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0035()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0036()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-2147483680.0"), 0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("-2")).remainder(new BigDecimal("3.2"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("WF=3E;C:908KEUEA4TR9;VY5QFJH;@2Y8K8SVH<>HW>:QNLYG6?");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0040()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0042()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0043()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0044()
  {
    rc_long = (new BigDecimal("-2")).longValueExact();
    Assert.assertEquals(-2L, rc_long);
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0047()
  {
    rc_String = (new BigDecimal("3.2")).toString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0048()
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
  public void testItem_0049()
  {
    rc_int = (new BigDecimal("3.2")).intValue();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0050()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0051()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0052()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0055()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0058()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0059()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2147483647")).hashCode();
//    Assert.assertEquals(2147483617, rc_int);
//  }
  public void testItem_0060()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0061()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-2"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
//  public void testItem_0064()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0069()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0070()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    rc_BigDecimal = (new BigDecimal("-2")).movePointLeft(1);
    Assert.assertEquals("-0.2", rc_BigDecimal.toString());
  }
  public void testItem_0072()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), java.math.RoundingMode.UP);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0077()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0079()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0080()
  {
    rc_BigDecimal = (new BigDecimal("-0.2")).negate();
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\234', '\234', '\234', '\0', '8', '\uFFFF', '\0', '\0', '\0', '\0', '\1', '\0', '8', '\0', '\1', '\0', '\0', '\0', '\234', '\1', '8', '\234', '\234', '8', '\1', '\0', '8', '\234', '\234', '8', '\1', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '8'}, -2147483648, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("-0.2")).round(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-0.2", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0086()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0088()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0089()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("0.1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("0.2")).subtract(new BigDecimal("0.1"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("3.2"));
  }
  public void testItem_0092()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0093()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\1', '\1', '\234', '\1', '\1', '\0', '\uFFFF', '8', '\234', '\234', '\234', '\1', '\0', '\0', '\234', '8', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\1', '8', '\234', '\1', '\1', '\234', '\234', '\234', '\234', '8', '8', '8', '8', '\1', '\1', '8', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\234', '\0', '8', '\0', '\0', '\234', '\0', '8', '\234', '\0', '\1', '\0', '\234', '\234', '8', '\uFFFF', '\0', '8', '\234', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\1', '8', '8', '\uFFFF', '\234'}, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0096()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0097()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0098()
  {
    rc_int = (new BigDecimal("0.1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0099()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0100()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0101()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0103()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0104()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    rc_int = (new BigDecimal("0.1")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0106()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0108()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0111()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0112()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0113()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0116()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).abs(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0118()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0119()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0120()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0121()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).pow(-1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0124()
  {
    rc_long = (new BigDecimal("-2147483648")).longValue();
    Assert.assertEquals(-2147483648L, rc_long);
  }
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0126()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("-2147483648"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0128()
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
  public void testItem_0129()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0130()
  {
    rc_String = (new BigDecimal("-2147483648")).toPlainString();
    Assert.assertEquals("-2147483648", rc_String);
  }
  public void testItem_0131()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0132()
  {
    rc_BigDecimal = (new BigDecimal("-31")).min(new BigDecimal("0"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, -1, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0134()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0135()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=2147483647 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0136()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0137()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    rc_int = (new BigDecimal("-2147483648")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0142()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0143()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("-2147483648"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).toBigIntegerExact();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0146()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0148()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0149()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0151()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0152()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0153()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0154()
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
  public void testItem_0155()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0156()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0157()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0158()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0159()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0160()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0161()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0163()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '\0', '\234', '\0', '\234', '\234', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\234', '8', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\1', '\1', '\uFFFF', '\1', '\234', '8', '\234', '\234', '\1', '\1', '\0', '\234', '8', '\0', '\234', '8', '\234', '\234', '\234', '\0', '8', '8', '\0', '\uFFFF', '8', '\uFFFF', '8', '\234', '\uFFFF', '\234', '8', '\234', '\234', '\234', '\234', '\0', '\uFFFF', '\1'}, 1, 0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0164()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0165()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).max(new BigDecimal("0"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0167()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0168()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("PR8M7T5B6@W:0G7QPL=8?OKCR7NI0UPE@N0O1TJRYTG:IEENJ7VMME@=FE6O9ETBH1LH;6GFF4PG:ELHXWR0WU6<T?A?MD5BVM61");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0170()
  {
    rc_int = (new BigDecimal("-3.2E-2147483646")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0171()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).setScale(1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0172()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0173()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0174()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).divide(new BigDecimal("1"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0175()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0177()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0178()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 0, -1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0179()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0183()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0184()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0185()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0186()
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
  public void testItem_0187()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("L:I4N9Y=FB?");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0191()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0192()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0193()
  {
    rc_boolean = (new BigDecimal("32")).equals("Q2NRS:=O9TPB:E=6:>RGWSXOGS:=CLQRB49EQTJA4O>:9P:WE?Q3LYJ78GD4O<F9J3GF4P;0KV967C6;B@>XLPYXK>=JPYQFPA0W");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0194()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0195()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
//  public void testItem_0196()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0197()
  {
    rc_boolean = (new BigDecimal("0")).equals("TV=SG7DJXE:1Q:M1NKY3;C9TREH?L2EG<JG>4YV07>P8TM2>AX;9<H1NHU>E74A2RK<;CXVWOEG");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0198()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0199()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 1, 1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0.0"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0202()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("32"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal_array = (new BigDecimal("5E-324")).divideAndRemainder(new BigDecimal("5E-324"));
  }
  public void testItem_0205()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0206()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0207()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0208()
  {
    rc_String = (new BigDecimal("5E-324")).toString();
    Assert.assertEquals("5E-324", rc_String);
  }
  public void testItem_0209()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("5E-324")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0210()
  {
    rc_BigDecimal = (new BigDecimal("5E-324")).subtract(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0213()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0214()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).add(new BigDecimal("0.0"));
    Assert.assertEquals("-30.0", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).multiply(new BigDecimal("-3E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+2", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_int = (new BigDecimal("-30.0")).precision();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("9E+2")).abs();
    Assert.assertEquals("9E+2", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0220()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("HTYSD;:VYY3S25X4S2U7KAWS=F9M@6OK9B9L;ETG@5SV9>=WEJRJ8");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0221()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("1GRM7LCG@J7OJT1:XR6;FL");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0222()
  {
    rc_BigDecimal = (new BigDecimal("9E+2")).divideToIntegralValue(new BigDecimal("-30.0"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).add(new BigDecimal("0.0"));
    Assert.assertEquals("-30.0", rc_BigDecimal.toString());
  }
  public void testItem_0224()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).multiply(new BigDecimal("0.0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\0', '\234', '\234', '\234', '\234', '\0', '\1', '\234', '\1', '8', '\234', '8', '\uFFFF', '\1', '8', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\1', '8', '\1', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0226()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("32"), 2147483647, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0227()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0228()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0229()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0.0"), java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0230()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).round(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0232()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("3.2E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1.024E+5", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    rc_BigDecimal = (new BigDecimal("1.024E+5")).setScale(0);
    Assert.assertEquals("102400", rc_BigDecimal.toString());
  }
  public void testItem_0237()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0238()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0239()
  {
    rc_int = (new BigDecimal("3.2E+2")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0240()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(2147483647, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0241()
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
  public void testItem_0242()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0244()
  {
    rc_boolean = (new BigDecimal("3.2E+2")).equals("R=PFMMFP>7D<?");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("102400")).setScale(1);
    Assert.assertEquals("102400.0", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0247()
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
  public void testItem_0248()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0249()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E+2")).hashCode();
//    Assert.assertEquals(991, rc_int);
//  }
//  public void testItem_0250()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0251()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0252()
  {
    rc_BigDecimal_array = (new BigDecimal("102400.0")).divideAndRemainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
  }
  public void testItem_0253()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0254()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\234', '\1', '\0', '\0', '8', '8', '\uFFFF', '\1', '8', '\234', '\1', '\0', '\234', '\0', '\0', '\1', '8', '\0', '\234', '\1', '\1', '\0', '\uFFFF', '8', '8', '8', '\uFFFF', '\0', '\234', '\234', '\0', '\0', '\uFFFF', '8', '8', '\uFFFF', '8', '\0', '8', '\1', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\1', '\234', '8', '8', '\0', '\1', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\uFFFF'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0255()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("3E-2147483647"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1E-2147483644", rc_BigDecimal.toString());
  }
//  public void testItem_0256()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideAndRemainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0257()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointLeft(-1);
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(1);
    Assert.assertEquals("320.0", rc_BigDecimal.toString());
  }
  public void testItem_0259()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).negate(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).negate();
    Assert.assertEquals("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    rc_int = (new BigDecimal("3.2E+2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0265()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '8', '8', '\234', '\0', '\1', '\234', '\1', '8', '\234', '\0', '\0', '\0', '\1', '\1', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\0', '\1', '\1', '\uFFFF', '\0', '\0', '\1', '\234', '\234', '\234', '\0', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\234', '8', '\0', '\1', '\0', '\0', '\234', '\1', '\0', '\uFFFF', '\0', '\1', '8', '\0', '8', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF'}, -1, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0266()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0267()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_int = (new BigDecimal("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).precision();
    Assert.assertEquals(310, rc_int);
  }
  public void testItem_0269()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Y;BCTT9:38H1GB9;8KD=7YIHM?K@V?3?L6R<EI6P5KGO");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0270()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0271()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\0', '\234', '\1', '\1', '8', '\1', '\234', '\uFFFF', '\0', '8', '\1', '8', '8', '\234', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\234', '8', '\234', '\234', '\1', '8', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\0', '\1', '8', '\234', '\0', '8', '\1', '\234', '\234', '\0', '8', '\uFFFF', '8', '8', '\234', '\1', '\1', '8', '\uFFFF', '8', '\1', '\1', '\234', '\234', '8', '\1', '\234', '\234'}, 2147483647, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0272()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointLeft(1);
    Assert.assertEquals("-17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8", rc_BigDecimal.toString());
  }
  public void testItem_0273()
  {
    rc_BigDecimal_array = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).divideAndRemainder(new BigDecimal("-17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8"));
  }
  public void testItem_0274()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).divide(new BigDecimal("-17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0275()
  {
    rc_BigInteger = (new BigDecimal("-17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).unscaledValue();
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0276()
  {
    rc_String = (new BigDecimal("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).toString();
    Assert.assertEquals("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_String);
  }
  public void testItem_0277()
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
  public void testItem_0278()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0279()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0280()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 2147483647, 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0281()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    rc_int = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0283()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\234', '\0', '\1', '\0', '\234', '\234', '8', '\1', '8', '8', '\0', '\234', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '8', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\234', '8', '\1', '\1', '\1', '\1', '\0', '8', '\0', '\0', '\234', '\234', '\1', '8', '\1', '\1', '\1', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '8', '\0', '8', '8', '\1', '\234', '\234', '\0', '\0', '8', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\234', '\234', '\1', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\1', '\0', '8', '\1', '\234', '\0', '\0', '\0', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0285()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).divide(new BigDecimal("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0286()
  {
    rc_BigDecimal = (new BigDecimal("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).divide(new BigDecimal("32"));
    Assert.assertEquals("-56177910464447365879539819916157611499397052351826561437161711500986643993758918362684237072739649428606393422973244520073225414652957557115146108344855474058140597055172275648826715653246665295023708908892229356970182261532257171301815174791288546335874320688795225990230680369037281212890751258182539018240", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-56177910464447365879539819916157611499397052351826561437161711500986643993758918362684237072739649428606393422973244520073225414652957557115146108344855474058140597055172275648826715653246665295023708908892229356970182261532257171301815174791288546335874320688795225990230680369037281212890751258182539018240")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0290()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@C<FQNR2CA1:368;9U2=RLCVKRL4");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0291()
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
  public void testItem_0292()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0294()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0297()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0299()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0300()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0301()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0302()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0303()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).max(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0304()
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
  public void testItem_0305()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '8', '\234', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\0', '\234', '\1', '\1', '\0', '\1', '\234', '\234', '8', '8', '8', '\0', '\uFFFF', '8', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\234', '\0', '8', '\234', '\234', '\1', '\1', '\0', '8', '\234', '\0', '\0', '8', '\0', '\uFFFF', '\234', '\0', '\234', '\1', '\234', '\1', '\234', '8', '\uFFFF', '\1', '\1'}, -1, -2147483648, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\1', '\234', '\uFFFF', '\0', '8', '\0', '\1', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\234', '\234', '\0', '\1', '\uFFFF', '\1', '8', '\0', '\1', '\234', '\uFFFF', '8', '\0', '\0', '8', '\1', '\1', '\234', '\1', '\uFFFF', '\234', '8', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '8', '8', '\1', '\0', '\uFFFF', '\1', '8', '\0', '\0', '8', '8', '\0', '\uFFFF', '\0', '8', '\234', '\234', '\0', '\1', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\1', '8', '\234', '\234', '8', '\0', '\1', '\1', '\234', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\1', '\0', '\1', '8', '\234', '\234', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0308()
  {
    rc_int = (new BigDecimal("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).precision();
    Assert.assertEquals(310, rc_int);
  }
  public void testItem_0309()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0314()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0315()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0316()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2E+2147483322", rc_BigDecimal.toString());
  }
  public void testItem_0317()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3GJC", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0319()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0320()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0321()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    rc_BigDecimal = (new BigDecimal("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).negate();
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigInteger = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).unscaledValue();
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigInteger.toString());
  }
  public void testItem_0324()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).divide(new BigDecimal("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0326()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0327()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    rc_int = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0329()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0330()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0331()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0332()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0333()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0334()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647", rc_BigDecimal.toString());
  }
  public void testItem_0335()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("94GF00=8CK?L@AH7<43U9VUU6A757=6<E60T9X<W<9A0@8MBX5779:LCAGNF:TE7AR=7109D5K0@24V093:=H>DUR9KK:1RW?;OP");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0337()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).movePointRight(0);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-31.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0342()
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
  public void testItem_0343()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_BigDecimal = (new BigDecimal("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647")).ulp();
    Assert.assertEquals("1E-2148", rc_BigDecimal.toString());
  }
  public void testItem_0346()
  {
    rc_BigInteger = (new BigDecimal("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0347()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = (new BigDecimal("-2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647")).negate();
    Assert.assertEquals("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    rc_BigDecimal = (new BigDecimal("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647")).divideToIntegralValue(new BigDecimal("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0351()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(-1);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_BigDecimal = (new BigDecimal("1E-2148")).stripTrailingZeros();
    Assert.assertEquals("1E-2148", rc_BigDecimal.toString());
  }
  public void testItem_0356()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2148")).pow(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0357()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0358()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1E-2148"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    rc_float = (new BigDecimal("9223372036854775807")).floatValue();
    Assert.assertEquals(9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0360()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("1E-2148"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0361()
  {
    rc_long = (new BigDecimal("1E-2148")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0362()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toPlainString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
//  public void testItem_0363()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0364()
  {
    rc_BigDecimal = (new BigDecimal("1E-2148")).subtract(new BigDecimal("1E-2148"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2148", rc_BigDecimal.toString());
  }
  public void testItem_0365()
  {
    rc_long = (new BigDecimal("9223372036854775807")).longValueExact();
    Assert.assertEquals(9223372036854775807L, rc_long);
  }
  public void testItem_0366()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '\1', '\234', '\0', '\234', '\0', '\234', '\uFFFF', '\1', '8', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '8', '\1', '\1', '8', '\234', '8', '\0', '\0', '\1', '\234', '\0', '8', '\uFFFF', '8', '8', '\1', '\0', '\234', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\1'}, -2147483648, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("0E-2148")).divideToIntegralValue(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("0E-2148", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("UJ;UJRJIV56@0@:=@T:W5M6XN07VPLC@TLJRY;GH@0JC9XA1WLNCJ5:H?CMTK9>WVTU?YTSJVQS00LI09A", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0369()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("9223372036854775807"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0370()
  {
    rc_String = (new BigDecimal("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).toPlainString();
    Assert.assertEquals("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_String);
  }
  public void testItem_0371()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0372()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -2147483648, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0373()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(0);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0374()
  {
    rc_BigDecimal = (new BigDecimal("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).abs(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1E+2148", rc_BigDecimal.toString());
  }
  public void testItem_0375()
  {
    rc_long = (new BigDecimal("9223372036854775807")).longValue();
    Assert.assertEquals(9223372036854775807L, rc_long);
  }
  public void testItem_0376()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\234', '\0', '\1', '8', '\1', '8'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0377()
  {
    rc_float = (new BigDecimal("9223372036854775807")).floatValue();
    Assert.assertEquals(9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0378()
  {
    rc_BigInteger = (new BigDecimal("0E-2148")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0379()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0380()
  {
    rc_double = (new BigDecimal("0E-2148")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("0E-2148")).multiply(new BigDecimal("9223372036854775807"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2148", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigDecimal = (new BigDecimal("0E-2148")).multiply(new BigDecimal("0E-2148"));
    Assert.assertEquals("0E-4296", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_int = (new BigDecimal("9223372036854775807")).precision();
    Assert.assertEquals(19, rc_int);
  }
  public void testItem_0384()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(0);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2148")).remainder(new BigDecimal("0E-4296"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0386()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    rc_BigDecimal = (new BigDecimal("0E-2148")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '8', '8', '\1', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\1', '\0', '8', '\234', '\uFFFF', '\0', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0389()
  {
    rc_BigInteger = (new BigDecimal("0E-4296")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0390()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0E-2148"), 0, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0391()
  {
    rc_String = (new BigDecimal("0E-2148")).toEngineeringString();
    Assert.assertEquals("0E-2148", rc_String);
  }
  public void testItem_0392()
  {
    rc_BigDecimal = (new BigDecimal("0E-2148")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0E+2147481499", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0394()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E-2148"), java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0395()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("?W82WUHGID7B7@8UD2NG?9V0G3NLQRYLB2T5P0<;M04FEPIJPNL@>3J1;FIC>DJ5X?GL7IBTL5O8R94YM5Q5KXX0M>OWP1Q5I0XI");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0396()
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
  public void testItem_0397()
  {
    rc_BigDecimal = (new BigDecimal("0E-2148")).divide(new BigDecimal("32"), 1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0398()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    rc_int = (new BigDecimal("2147483647")).intValue();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0401()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\1', '\0', '\uFFFF', '\234', '\0', '\0', '8', '\0', '8', '\234', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\0', '\1', '8', '\234', '\1', '\234', '\1', '\1', '8', '\uFFFF', '8', '\234', '\1', '\1', '8', '\0', '\1', '\1', '\234', '\1', '\1', '8', '\234', '\0', '8', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '8', '\234', '\0', '\uFFFF', '\1', '\1', '8', '\234', '8', '8', '\1', '\1', '\0', '8', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\1', '\0', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0402()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2148")).divideAndRemainder(new BigDecimal("2147483647"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
  }
  public void testItem_0403()
  {
    rc_BigDecimal = (new BigDecimal("0E-4296")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("0E-2148")).movePointLeft(0);
    Assert.assertEquals("0E-2148", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0406()
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
  public void testItem_0407()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("32"));
    Assert.assertEquals("2147483615", rc_BigDecimal.toString());
  }
//  public void testItem_0408()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+2147481499")).hashCode();
//    Assert.assertEquals(-2147481499, rc_int);
//  }
  public void testItem_0409()
  {
    rc_BigDecimal = (new BigDecimal("0E-2148")).ulp();
    Assert.assertEquals("1E-2148", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).movePointRight(0);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0412()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).max(new BigDecimal("0E-4296"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0415()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0417()
  {
    rc_double = (new BigDecimal("2147483647")).doubleValue();
    Assert.assertEquals(2.147483647E9, rc_double, 0);
  }
  public void testItem_0418()
  {
    rc_String = (new BigDecimal("-32")).toEngineeringString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0419()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("0E-4296"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0420()
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
  public void testItem_0421()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("-32"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0422()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("9223372036854775807")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0423()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("-32"));
    Assert.assertEquals("2147483615", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("XHB8F@B<YXR8Y6EO3?L>5TS2TQYU2YA8G=PQCS?5>5GQCVW?5X7V:R2H8UU6R7:48DX4?E8UR09XM6P@", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0427()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0428()
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
//  public void testItem_0429()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2147483647")).hashCode();
//    Assert.assertEquals(2147483617, rc_int);
//  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("9223372039002259454", rc_BigDecimal.toString());
  }
//  public void testItem_0434()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2147483615")).hashCode();
//    Assert.assertEquals(2147482625, rc_int);
//  }
  public void testItem_0435()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '8', '\0', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\234', '\0', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\1', '8', '8', '\234', '\0', '\0', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\1', '\1', '\234', '\234', '8', '\0', '8', '\234'}, 2147483647, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).abs(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0437()
  {
    rc_BigDecimal = (new BigDecimal("9223372039002259454")).min(new BigDecimal("9E+18"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0438()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    rc_BigDecimal = (new BigDecimal("-32")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_BigInteger = (new BigDecimal("-3E+1")).unscaledValue();
    Assert.assertEquals("-3", rc_BigInteger.toString());
  }
  public void testItem_0442()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).multiply(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2.7670116110564327421E+20", rc_BigDecimal.toString());
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).max(new BigDecimal("3E+1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0445()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("9223372036854775807")).divideAndRemainder(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0446()
  {
    rc_int = (new BigDecimal("-3E+1")).intValueExact();
    Assert.assertEquals(-30, rc_int);
  }
  public void testItem_0447()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0448()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).negate();
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\1', '8', '\234', '\1', '\0', '\1', '8', '\234', '\uFFFF', '\234', '\234', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\1', '\1', '\0', '\1', '\1', '\0', '\1', '\0', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\0', '8', '\1', '8', '\0', '\1', '\uFFFF', '\0', '\0', '\0', '\234', '\234', '\234', '8', '\0', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '8', '\1', '\1', '\uFFFF', '\0', '\234', '\1'}, 2147483647, 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0450()
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
  public void testItem_0451()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2.7670116110564327421E+20")).setScale(-2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0454()
  {
    rc_BigDecimal = (new BigDecimal("2.7670116110564327421E+20")).subtract(new BigDecimal("1"));
    Assert.assertEquals("276701161105643274209", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_long = (new BigDecimal("-3E+1")).longValue();
    Assert.assertEquals(-30L, rc_long);
  }
  public void testItem_0457()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-9223372036854775807")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0458()
  {
    rc_float = (new BigDecimal("-9223372036854775807")).floatValue();
    Assert.assertEquals(-9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0459()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0460()
  {
    rc_boolean = (new BigDecimal("2.7670116110564327421E+20")).equals("WJHQ6DR;VGAKAQ>OV:O27PXYXKG>R::<QLMK7IJEM@AQPGEI");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0461()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("2.7670116110564327421E+20")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0462()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).negate();
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("32"));
  }
//  public void testItem_0464()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-9223372036854775807"), 2147483647, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0465()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0467()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).movePointRight(-1);
    Assert.assertEquals("922337203685477580.7", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("922337203685477580.7")).plus();
    Assert.assertEquals("922337203685477580.7", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_BigDecimal = (new BigDecimal("922337203685477580.7")).multiply(new BigDecimal("-9223372036854775807"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-8507059173023461584739690778423250124.9", rc_BigDecimal.toString());
  }
  public void testItem_0470()
  {
    rc_int = (new BigDecimal("2.7670116110564327421E+20")).intValue();
    Assert.assertEquals(-30, rc_int);
  }
  public void testItem_0471()
  {
    rc_float = (new BigDecimal("922337203685477580.7")).floatValue();
    Assert.assertEquals(9.2233721742937293E17F, rc_float, 0);
  }
  public void testItem_0472()
  {
    rc_String = (new BigDecimal("-8507059173023461584739690778423250124.9")).toString();
    Assert.assertEquals("-8507059173023461584739690778423250124.9", rc_String);
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("-8507059173023461584739690778423250124.9")).movePointRight(-1);
    Assert.assertEquals("-850705917302346158473969077842325012.49", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_int = (new BigDecimal("922337203685477580.7")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-850705917302346158473969077842325012.49"), java.math.RoundingMode.UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0477()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-850705917302346158473969077842325012.49")).hashCode();
//    Assert.assertEquals(-1072788541, rc_int);
//  }
  public void testItem_0478()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0479()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-850705917302346158473969077842325012.49")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    rc_float = (new BigDecimal("2.7670116110564327421E+20")).floatValue();
    Assert.assertEquals(2.7670116110564327E20F, rc_float, 0);
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
      rc_long = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0484()
  {
    rc_BigDecimal = (new BigDecimal("-850705917302346158473969077842325012.49")).remainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-850705917302346158473969077842325012.49", rc_BigDecimal.toString());
  }
  public void testItem_0485()
  {
    rc_int = (new BigDecimal("9223372036854775807")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("2.7670116110564327421E+20")).divide(new BigDecimal("2.7670116110564327421E+20"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0488()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0489()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("2.7670116110564327421E+20")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0490()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0491()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("2.7670116110564327421E+20"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0492()
  {
    rc_BigDecimal = (new BigDecimal("-850705917302346158473969077842325012.49")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-850705917302346158473969077842325012.49", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_long = (new BigDecimal("-850705917302346158473969077842325012.49")).longValue();
    Assert.assertEquals(-553402322211286548L, rc_long);
  }
  public void testItem_0494()
  {
    rc_BigDecimal = (new BigDecimal("-850705917302346158473969077842325012.49")).plus();
    Assert.assertEquals("-850705917302346158473969077842325012.49", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("2.7670116110564327421E+20"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("276701161105643274210.0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0497()
  {
    rc_boolean = (new BigDecimal("8")).equals("R?DN3591W89@JWBWD@FT6GDMU03XNP>0WODEID7@WF@J3CHQ3H0TFFBE9KNDG;?IN=XT3ID<7EFAJ6J5>IAE4RLTY::6WY?4DJ5S");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0498()
  {
    rc_BigDecimal = (new BigDecimal("2.7670116110564327421E+20")).negate();
    Assert.assertEquals("-2.7670116110564327421E+20", rc_BigDecimal.toString());
  }
  public void testItem_0499()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0500()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("2.7670116110564327421E+20")).remainder(new BigDecimal("8"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    rc_BigDecimal = (new BigDecimal("2.7670116110564327421E+20")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("276701161105643274210", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0505()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0506()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    rc_BigDecimal = (new BigDecimal("276701161105643274210")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0508()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\0', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\1', '\1', '\0', '\0', '\234', '\1', '\1', '8', '\uFFFF', '8', '\234', '\234', '\234', '\234', '\0', '\uFFFF', '\0', '\0', '8', '8', '\234', '\234', '\234', '\1', '\uFFFF', '\1', '\234', '8', '8', '\1', '\uFFFF', '\1', '\234', '\1', '\1', '\1', '\234', '\0', '\234', '\234', '\uFFFF', '\1', '\1', '\0', '\234', '\uFFFF', '\0', '8', '\0', '\234', '\1', '8', '\1', '\0', '\uFFFF', '8', '8', '\234', '\1', '\1', '\uFFFF', '\1', '8', '8', '\0', '\234', '\234', '\0', '8', '\uFFFF', '\1', '8', '8', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0509()
  {
    rc_boolean = (new BigDecimal("276701161105643274210")).equals("=MIK<C=6I8@C0SLC6MXQIUE=KVT?C2QCSL1W1<TYQ>F?6AJV:M@@CQ@45M5RH:9>QBN73MH82Q@HJ4LUUEPK?ORA8M@T1@6H=4Q3");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0510()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0511()
  {
    rc_String = (new BigDecimal("276701161105643274210")).toEngineeringString();
    Assert.assertEquals("276701161105643274210", rc_String);
  }
  public void testItem_0512()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0513()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '8', '8', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\234', '\234', '\1', '\234', '\0', '\0', '8', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\0', '8', '\0', '\uFFFF', '\1', '8', '\1', '\0', '\234', '8', '8', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\234', '\0', '\uFFFF', '\234', '\234', '8', '8', '\0', '\0', '\1', '8', '\0', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '8', '\1', '8', '8', '\uFFFF', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '8', '8', '\234', '\234', '\0', '\0', '\234', '8', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\0', '8', '\234'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0514()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2.7670116110564327421E+20")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0515()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0516()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0519()
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
  public void testItem_0520()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0523()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("9223372036854775807")).byteValueExact();
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
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0528()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0529()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0530()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0531()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0532()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0533()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0535()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0536()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0540()
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
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0544()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0547()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("32"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0548()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0550()
  {
    rc_boolean = (new BigDecimal("9223372036854775807")).equals("CFNF31NOQIW59CWT:=L=59L37WF7OND71CAXV@9@8T6JYR<FCBPLW:@<52>T7:TB7JW5>K81B6GV1T?QBW?@?H9Y2Q5767NT1Y3I");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0551()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0552()
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
  public void testItem_0553()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0554()
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
  public void testItem_0555()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0557()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0558()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0559()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0560()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0561()
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
  public void testItem_0562()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0567()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0568()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0571()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0572()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0573()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    rc_BigInteger = (new BigDecimal("8")).toBigInteger();
    Assert.assertEquals("8", rc_BigInteger.toString());
  }
  public void testItem_0576()
  {
    rc_BigDecimal = (new BigDecimal("8")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0577()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '\234', '\uFFFF', '\0', '\0', '\1', '8', '8', '8', '\1', '\uFFFF', '\1', '8', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\234', '\0', '\234', '\uFFFF', '\234', '8', '\0', '8', '\uFFFF', '8', '\1', '\234', '\1', '\1', '8', '\234', '\1', '\1', '8', '\uFFFF', '\0', '\234', '\234', '8', '\0', '8', '8', '\0', '\234', '\234', '\0', '\1', '\1', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\1', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\234', '8', '\0'}, -2147483648, 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0578()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).multiply(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2.4E+2", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\uFFFF', '\uFFFF', '8', '8', '\1', '\uFFFF', '\1', '\1', '8', '\uFFFF', '8', '\0', '\0', '\234', '\1', '\uFFFF', '\1', '\0', '\1', '\1', '\234', '\0', '\1', '\uFFFF', '\234', '8', '\1', '\1', '\234', '8', '\uFFFF', '8', '\234', '\234', '8', '\1', '\1', '\1', '\234', '\0', '\1', '8', '\0', '8', '\1', '\0', '\0', '8', '\uFFFF', '\234', '\1', '\0', '\0', '\1', '\234', '\234', '\1', '\1', '\234', '8', '8', '\0', '\0', '\234', '\1', '8', '\1', '\0', '\0', '\1', '\1', '\0', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '8', '\1', '\uFFFF', '8', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\1', '8', '\234', '8', '\uFFFF', '\0', '8', '\0', '\0', '\234', '8', '\0'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0582()
  {
    rc_BigDecimal = (new BigDecimal("8")).remainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
//  public void testItem_0584()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("8")).setScale(-2147483648, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0585()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0586()
  {
    rc_BigInteger = (new BigDecimal("0E-1074")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0587()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0590()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).movePointRight(-1);
    Assert.assertEquals("0E-1075", rc_BigDecimal.toString());
  }
  public void testItem_0591()
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
  public void testItem_0592()
  {
    rc_float = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0593()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0594()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0595()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '8', '8', '\234', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\234', '\1', '\0', '\234', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\1', '8', '\1', '\0', '8', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\0', '8', '8', '\uFFFF', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0596()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0597()
  {
    rc_BigInteger = (new BigDecimal("0E-1074")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0598()
  {
    rc_BigDecimal = (new BigDecimal("3")).add(new BigDecimal("0"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).remainder(new BigDecimal("0E-1075"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0601()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).plus();
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    rc_BigDecimal = (new BigDecimal("0E-1075")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-1075", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).remainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).abs();
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-1075")).divide(new BigDecimal("0E-1074"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0607()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\234', '8', '\0', '8', '8', '\1', '\uFFFF', '8', '\0', '\0', '\1', '\234', '\234', '\0', '\1', '8', '8', '\1', '\234', '\234', '\0', '\0', '\0', '\1', '\0', '\uFFFF', '\1', '\0', '\0', '\0', '\uFFFF', '\234', '8', '8', '\234', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\1', '8', '\uFFFF', '\234', '\1', '8', '8', '\uFFFF', '8', '\0', '\234', '\1', '\1', '\234', '\234', '\1', '\0', '8', '8', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '8', '\1', '\1', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0608()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-1074")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0609()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-1074")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0610()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0611()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E-1073", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).multiply(new BigDecimal("3"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toEngineeringString();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_String);
  }
  public void testItem_0614()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0615()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0616()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\uFFFF', '8', '8', '\234', '\uFFFF', '\1', '\234', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\234', '\234', '\234', '\0', '\0', '\uFFFF', '\0', '8', '\1', '\234', '\1', '\1', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\1', '8', '\234', '\234', '\234', '\234', '8', '8', '\234'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).divide(new BigDecimal("3"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("0E-1073")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).remainder(new BigDecimal("3"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_BigInteger = (new BigDecimal("0E-1074")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0623()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@W0Y<7W?8EY16NT;G3R34@J5HJ3@UQH5R?<3?LNRD<EH1OJ=XW:MTM9F5WV34");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0624()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0626()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    rc_int = (new BigDecimal("-2147483648")).intValue();
    Assert.assertEquals(-2147483648, rc_int);
  }
  public void testItem_0628()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-1074")).divideAndRemainder(new BigDecimal("0E-1074"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0629()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0631()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3")).remainder(new BigDecimal("0E-1074"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0632()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0633()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0634()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\0', '\234', '\1', '\234', '8', '\0', '\234', '\uFFFF', '\0', '8', '\1', '\1', '8', '\1', '\uFFFF', '\234', '\1', '\1', '8', '\1', '8', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '8', '\0', '8', '\uFFFF', '8', '8', '\0', '\234', '\uFFFF', '\234', '\234', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\0', '8', '\234', '\1', '\0', '\0', '\0', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '8', '8', '8', '\0', '\0', '\0', '\234', '\1', '\0', '8', '\234', '\0', '\234', '\234', '\0', '8', '\1', '\0', '8', '8', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\234', '\234', '\0', '\0', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0635()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-1074")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0636()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    rc_long = (new BigDecimal("0E-1073")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0638()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0639()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigInteger = (new BigDecimal("-3E+1")).unscaledValue();
    Assert.assertEquals("-3", rc_BigInteger.toString());
  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).stripTrailingZeros();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_short = (new BigDecimal("2")).shortValueExact();
    Assert.assertEquals(2, rc_short);
  }
  public void testItem_0645()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0646()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("J792E>YIS?:", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0647()
  {
    rc_double = (new BigDecimal("-3E+1")).doubleValue();
    Assert.assertEquals(-30.0, rc_double, 0);
  }
  public void testItem_0648()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0649()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0650()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0654()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0655()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0656()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0657()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0658()
  {
    rc_int = (new BigDecimal("-3E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0659()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("2"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0660()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0661()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).pow(1);
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0662()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("2"), 0, 1);
    Assert.assertEquals("-15", rc_BigDecimal.toString());
  }
  public void testItem_0663()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0664()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0667()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0668()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("5E-324"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0669()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-15")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("5E-324")).stripTrailingZeros();
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\0', '\0', '\1', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '8', '8', '\0', '\0', '\234', '\uFFFF', '\234', '\0', '\0', '\0', '\0', '\uFFFF', '\1', '\234', '\234', '\234', '\1', '\234', '\234', '\0', '\234', '\0', '\0', '\234', '\234', '\1', '\234', '\0', '\234', '\uFFFF', '\1', '\234', '8', '\234', '\0', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\0', '\0', '\234', '\1', '\234', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\234', '\0', '8', '8', '8', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '8', '\uFFFF', '8', '\0', '\0', '\234', '8', '8', '8', '\0', '\0'}, -2147483648, 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0672()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_BigDecimal = (new BigDecimal("5E-324")).subtract(new BigDecimal("-15"));
    Assert.assertEquals("15.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0674()
  {
    rc_boolean = (new BigDecimal("5E-324")).equals("HERHT32;;RQKJ95T4PCOL5G;9J9LRCOO4N5A@UG<<KU7B:6B8");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0675()
  {
    rc_long = (new BigDecimal("-15")).longValueExact();
    Assert.assertEquals(-15L, rc_long);
  }
  public void testItem_0676()
  {
    rc_int = (new BigDecimal("15.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005")).intValue();
    Assert.assertEquals(15, rc_int);
  }
  public void testItem_0677()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0678()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate();
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_int = (new BigDecimal("-15")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0681()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).movePointLeft(1);
    Assert.assertEquals("214748364.7", rc_BigDecimal.toString());
  }
  public void testItem_0682()
  {
    rc_long = (new BigDecimal("-15")).longValue();
    Assert.assertEquals(-15L, rc_long);
  }
  public void testItem_0683()
  {
    rc_BigDecimal = (new BigDecimal("5E-324")).movePointLeft(0);
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0684()
  {
    rc_int = (new BigDecimal("-2147483647")).compareTo(new BigDecimal("2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0685()
  {
    rc_BigDecimal = (new BigDecimal("-15")).add(new BigDecimal("5E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).subtract(new BigDecimal("-15"));
    Assert.assertEquals("-2147483632", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_int = (new BigDecimal("-15")).compareTo(new BigDecimal("15.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("15.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005")).abs();
    Assert.assertEquals("15.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_int = (new BigDecimal("15.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005")).scale();
    Assert.assertEquals(324, rc_int);
  }
  public void testItem_0690()
  {
    rc_int = (new BigDecimal("-2147483632")).intValue();
    Assert.assertEquals(-2147483632, rc_int);
  }
  public void testItem_0691()
  {
    rc_BigInteger = (new BigDecimal("-2147483647")).toBigInteger();
    Assert.assertEquals("-2147483647", rc_BigInteger.toString());
  }
  public void testItem_0692()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).max(new BigDecimal("-2147483647"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).scaleByPowerOfTen(1);
    Assert.assertEquals("2.147483647E+10", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-2147483632")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0697()
  {
    rc_BigDecimal = (new BigDecimal("-2147483632")).remainder(new BigDecimal("-2147483632"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0701()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF'}, -1, 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0702()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("2.147483647E+10"));
    Assert.assertEquals("2.147483647E+10", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0704()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0705()
  {
    rc_float = (new BigDecimal("2.147483647E+10")).floatValue();
    Assert.assertEquals(2.147483648E10F, rc_float, 0);
  }
  public void testItem_0706()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0707()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), 1, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0708()
  {
    rc_BigInteger = (new BigDecimal("-3.2E-2147483646")).unscaledValue();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0709()
  {
    rc_BigInteger = (new BigDecimal("2.147483647E+10")).toBigIntegerExact();
    Assert.assertEquals("21474836470", rc_BigInteger.toString());
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\234', '\234', '\234', '8', '8', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\1', '\234', '\234', '8', '\1', '\234', '8', '8', '\0', '8', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '8', '\1', '\0', '8', '\1', '\0', '\1', '8', '\0', '\0', '\0', '\234', '\1', '\uFFFF', '\0', '\1', '\0', '\1', '\uFFFF', '8', '\uFFFF', '8', '\234', '\0', '8', '\234', '\0', '\234', '8', '\uFFFF', '\234', '\234', '\0', '\234', '\1', '\1', '8', '\1', '8', '\234', '\1', '\1', '8', '8', '\234', '\0', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0712()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0714()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0715()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0717()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
//  public void testItem_0718()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("-3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0719()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0720()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("-3.2E-2147483646")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0721()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).subtract(new BigDecimal("-1"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0722()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0723()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).negate();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_int = (new BigDecimal("320")).compareTo(new BigDecimal("320"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0727()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0728()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("1H81CUV?UM@CHS?9KP=VLJNR2VJ@O1NME87");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0729()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0730()
  {
    rc_BigDecimal = (new BigDecimal("320")).stripTrailingZeros();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
  }
  public void testItem_0732()
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
  public void testItem_0733()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\234', '\0', '8', '\0', '\uFFFF', '\0', '\234', '8', '\1', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\234', '\0', '8', '\234', '\234', '8', '\1', '\1', '\uFFFF', '8', '\234', '\234', '\0', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '8'}, -1, 2147483647, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0734()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3.2E+2"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0735()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0736()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0737()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0738()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0739()
  {
    rc_String = (new BigDecimal("320")).toEngineeringString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0740()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0741()
  {
    rc_boolean = (new BigDecimal("32")).equals("NER9A?9CD4AQPL?J1L@:WT@LFPFK@5MMRYN11WP>IV=HXL6IVV1@O5CI<5X8L6R6G6:36VB9Y837QQJ@BGT26571EG6HEG2<N?PW");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0742()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0744()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("EOC52CVP7>Y>Q:V:<BLM=E48Q2K=68LNLE@K<LYI0?=CELAVU3A:CR9WDX", new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0747()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0748()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0749()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0750()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\1', '\1', '\0', '\234', '\1', '\234', '\1', '\1', '8', '8', '\1', '\uFFFF', '\1', '\234', '8', '8', '\1', '8', '\0', '8', '\1', '\0', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '8', '8', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0752()
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
  public void testItem_0753()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0754()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("32"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("35496219246", rc_BigDecimal.toString());
  }
  public void testItem_0755()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1135879015891")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("64")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0761()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\0', '\1', '\234', '\234', '\uFFFF', '\234', '\0', '\0', '\1', '8', '\uFFFF'}, -2147483648, 1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0762()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0765()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3B3CR=57YCNIH0CBF=PDKL<M;V>T>J@FJA:TJ:9:;I?TIU;I>?V=5PPP48M1W9O6G?@FB;B3EP1??XYN6SYD4M8CBB97OVI<C4LC", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0766()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0767()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0768()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).pow(-1);
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
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0770()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0771()
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
  public void testItem_0772()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0773()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(-2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0774()
  {
    rc_int = (new BigDecimal("3E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0775()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3.2E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).stripTrailingZeros();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0778()
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
  public void testItem_0779()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toEngineeringString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0781()
  {
    rc_String = (new BigDecimal("3E+1")).toString();
    Assert.assertEquals("3E+1", rc_String);
  }
  public void testItem_0782()
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
//  public void testItem_0783()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0784()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("40V7=:@8?C7WB;KU<FP?N9LVT6E6N05O2>T1YB2PXXC88@O3FXTDAKYMU6I:EYXDM3V6IWBRQ1:AT>47THMJ1D=F@UJNFYE1JR;D", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0786()
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
  public void testItem_0787()
  {
    rc_String = (new BigDecimal("3E+1")).toString();
    Assert.assertEquals("3E+1", rc_String);
  }
  public void testItem_0788()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0790()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0791()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigIntegerExact();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0792()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0794()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.1")).setScale(2147483647, 0);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0796()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).multiply(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2E+307", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    rc_double = (new BigDecimal("2E+307")).doubleValue();
    Assert.assertEquals(2.0E307, rc_double, 0);
  }
  public void testItem_0799()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+308")).divide(new BigDecimal("0.1"), 2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0800()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2")).hashCode();
//    Assert.assertEquals(993, rc_int);
//  }
  public void testItem_0801()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("2E+307"), -1, 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).abs();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("-2E+308")).negate();
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\234', '\uFFFF', '\234', '8', '8', '\234', '\0', '\0', '8', '8', '\0', '\1', '\0', '\234', '\234', '\0', '\1', '\0', '\0', '\234', '\0', '\0', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\234', '\234', '\234', '\234', '\0', '\0', '\1', '8', '8', '\0', '\0', '\234', '\0', '\1', '\0', '\234', '\0', '8', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\0', '\0', '\1', '\1', '\234', '8', '\234', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\1', '\234', '8', '\0', '\1'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_BigDecimal = (new BigDecimal("-2E+308")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-2E+307", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("7C74VCM?1:UAOIHN85;FQL@?HJRDXESM7?PSUG0Y64W?F>28YJH03>KYW6SRA3LO48QB=6OFEFMRLC31JVVFDB?NT>TRYLMFPC><");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0812()
  {
    rc_int = (new BigDecimal("-2E+308")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0813()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-2E+308")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"), java.math.RoundingMode.UP);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("-2E+307"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0816()
  {
    rc_BigDecimal = (new BigDecimal("2E+307")).divide(new BigDecimal("-2E+307"), 0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0817()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("2E+307")).divide(new BigDecimal("1E+1"));
    Assert.assertEquals("2E+306", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).remainder(new BigDecimal("-2E+308"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("1E+1"));
  }
//  public void testItem_0821()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483647")).add(new BigDecimal("-1"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0822()
  {
    rc_String = (new BigDecimal("1E+1")).toEngineeringString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0823()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).subtract(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("AMXWCGTHD1CW=GY=OUCXYV09EL2OYKGGMLLL2FC2PYI8U<YL4=YY51J3CF@AEOPX8SNHMU0H4W");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0825()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).remainder(new BigDecimal("3E-2147483647"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0826()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0827()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0828()
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
  public void testItem_0829()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0831()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '\234', '8', '\0', '8', '\234', '\234', '\uFFFF', '\234', '8', '\0', '\1', '\0', '\0', '\234', '\234', '8', '\234', '\1', '\0', '8', '\uFFFF', '\0', '\0', '8', '8', '\uFFFF', '\234', '8', '\0', '\234', '\uFFFF', '\0', '8', '\0', '\0', '\234', '\uFFFF', '\1', '\234', '\234', '\1', '\1', '\1', '\1', '8', '\234', '8', '\uFFFF', '\uFFFF', '8', '\234', '\1', '8', '8', '\uFFFF', '\1', '8', '\234', '\0', '\1', '\234', '\234', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '8', '\0', '\1', '\uFFFF', '8', '8', '\234', '\0', '\234', '\234', '\234', '8', '\0', '\234', '\234', '\234', '8', '8', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0832()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2E+308")).hashCode();
//    Assert.assertEquals(-370, rc_int);
//  }
  public void testItem_0833()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\234', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\0', '8', '\uFFFF', '\234', '\234', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\0', '\234', '\234', '\1', '\1', '\234', '\234', '\0', '\1', '\1', '\uFFFF', '8', '8', '\0', '\234', '8', '\0', '\234', '8', '\234', '\0', '\uFFFF', '8', '\1', '\234', '\uFFFF', '8', '\1', '\1', '\0', '8', '\uFFFF', '\0', '\234', '\1', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\0', '\1', '8', '8', '8', '\1', '\0', '\0', '\234', '\0', '8', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '8', '\1', '\234', '\uFFFF', '\1', '8', '\1', '\0', '\234', '\0', '\1', '\0', '\234', '\1', '8', '\uFFFF', '\234', '8', '\uFFFF'}, 0, 2147483647, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0834()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0835()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).movePointRight(0);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483647")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0837()
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
  public void testItem_0838()
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
  public void testItem_0839()
  {
    rc_int = (new BigDecimal("1E+1")).intValue();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0840()
  {
    rc_double = (new BigDecimal("-2E+308")).doubleValue();
    Assert.assertEquals(java.lang.Double.NEGATIVE_INFINITY, rc_double, 0);
  }
//  public void testItem_0841()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483647")).add(new BigDecimal("-1"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0842()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0843()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("3E-2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0845()
  {
    rc_int = (new BigDecimal("3E-2147483647")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0846()
  {
    rc_float = (new BigDecimal("3E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0847()
  {
    rc_BigDecimal = (new BigDecimal("-2E+308")).stripTrailingZeros();
    Assert.assertEquals("-2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    rc_BigDecimal = (new BigDecimal("-2E+308")).negate();
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    rc_String = (new BigDecimal("-2E+308")).toEngineeringString();
    Assert.assertEquals("-200E+306", rc_String);
  }
  public void testItem_0850()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+308")).divide(new BigDecimal("2E+308"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0851()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0852()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("2E+308"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0853()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("-2E+308")).divide(new BigDecimal("-2E+308"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+308", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_BigInteger = (new BigDecimal("9E+18")).toBigInteger();
    Assert.assertEquals("9000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0856()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_String = (new BigDecimal("2E+308")).toString();
    Assert.assertEquals("2E+308", rc_String);
  }
  public void testItem_0859()
  {
    rc_BigDecimal = (new BigDecimal("-2E+308")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0860()
  {
    rc_int = (new BigDecimal("9E+18")).intValue();
    Assert.assertEquals(-494665728, rc_int);
  }
  public void testItem_0861()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0862()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9E+18")).hashCode();
//    Assert.assertEquals(261, rc_int);
//  }
  public void testItem_0863()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).movePointLeft(-1);
    Assert.assertEquals("2000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
//  public void testItem_0864()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2E+308")).setScale(-2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0865()
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
  public void testItem_0866()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0867()
  {
    rc_int = (new BigDecimal("2E+308")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0868()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9E+18")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0869()
  {
    rc_int = (new BigDecimal("-2E+308")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0870()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0871()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0872()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("2000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), java.math.RoundingMode.UP);
    Assert.assertEquals("1E+308", rc_BigDecimal.toString());
  }
  public void testItem_0873()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("-2147483648"), java.math.RoundingMode.UP);
    Assert.assertEquals("-1E+308", rc_BigDecimal.toString());
  }
  public void testItem_0875()
  {
    rc_String = (new BigDecimal("2E+308")).toPlainString();
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_String);
  }
  public void testItem_0876()
  {
    rc_BigDecimal = (new BigDecimal("-1E+308")).divide(new BigDecimal("-1E+308"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+308", rc_BigDecimal.toString());
  }
  public void testItem_0877()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '8', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '8', '\234', '\1', '\234', '\0', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0879()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0E+308")).divide(new BigDecimal("2E+308"), 2147483647, java.math.RoundingMode.UP);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0880()
  {
    rc_boolean = (new BigDecimal("1E+308")).equals("JRPSQ16?FKQ6AO5WU=T;T65NJEQERJS=L0N89493HAPK5EM6A>WD96E9@9GX8A5>X9DV==1:PJS@IAS32MVEV00N1MTMF6<H2;TK");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0881()
  {
    rc_float = (new BigDecimal("2E+308")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0882()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0886()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).abs();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0890()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("1E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0892()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0893()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).stripTrailingZeros();
	Assert.assertEquals(0E-2147483647, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0894()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0895()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0896()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0897()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0898()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0899()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0901()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0902()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0903()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0904()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-9223372036854775808"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("32"), 2147483647, 1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0906()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0907()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).compareTo(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0908()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0909()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-9223372036854775808")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0910()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).remainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0911()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_long = (new BigDecimal("-9223372036854775808")).longValueExact();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  public void testItem_0914()
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
  public void testItem_0915()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0916()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0917()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0918()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0921()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0922()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0923()
  {
    rc_long = (new BigDecimal("-9223372036854775808")).longValue();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  public void testItem_0924()
  {
    rc_long = (new BigDecimal("-9223372036854775808")).longValue();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  public void testItem_0925()
  {
    rc_double = (new BigDecimal("-9223372036854775808")).doubleValue();
    Assert.assertEquals(-9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0926()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigIntegerExact();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0927()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0928()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0929()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0930()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_int = (new BigDecimal("3E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0933()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).movePointLeft(0);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0935()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0937()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 1, 0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0938()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-18446744073709551616", rc_BigDecimal.toString());
  }
  public void testItem_0939()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0940()
  {
    rc_BigInteger = (new BigDecimal("-18446744073709551616")).toBigInteger();
    Assert.assertEquals("-18446744073709551616", rc_BigInteger.toString());
  }
  public void testItem_0941()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("8M;<U3GNJ<W4@4YW4XXR0146:0RXQPBN<>J65O;SAAND1DWT");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0942()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).negate(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0943()
  {
    rc_BigDecimal = (new BigDecimal("-18446744073709551616")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2E+19", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-2147483648"));
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("2E+9"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("-2E+19")).subtract(new BigDecimal("-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-19999999997852516353", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-2147483648"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0951()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(-2147483648, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_BigDecimal = (new BigDecimal("-19999999997852516353")).plus(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2E+19", rc_BigDecimal.toString());
  }
  public void testItem_0954()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("YPQIYR857;PDD:;T3GRS2AO9EY2UKFCJU138<J4XJ;O5A6<CHAP3EO2", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0955()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-19999999997852516353")).divide(new BigDecimal("-19999999997852516353"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0956()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0957()
  {
    rc_long = (new BigDecimal("-19999999997852516353")).longValue();
    Assert.assertEquals(-1553255924142964737L, rc_long);
  }
  public void testItem_0958()
  {
    rc_BigDecimal = (new BigDecimal("-19999999997852516353")).multiply(new BigDecimal("-2E+19"));
    Assert.assertEquals("3.9999999995705032706E+38", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0960()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).divide(new BigDecimal("-19999999997852516353"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0961()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.9999999995705032706E+38")).hashCode();
//    Assert.assertEquals(-1567968070, rc_int);
//  }
  public void testItem_0962()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0965()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '8', '\0', '8', '\234', '\234', '\0', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\0', '\234', '8', '8', '8', '\0', '\1', '\0', '\0', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\0', '\234', '\234', '8', '\234', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\234', '8', '8', '\uFFFF', '8', '\234', '\0', '\1', '\1', '8', '\0', '\1', '\0', '\1', '\234', '8', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\uFFFF', '8', '8', '\0', '\234', '\234', '\234', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '8', '8', '\234', '\1', '\1', '\0'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0967()
  {
    rc_float = (new BigDecimal("3.9999999995705032706E+38")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0968()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_BigInteger = (new BigDecimal("-2E+19")).toBigIntegerExact();
    Assert.assertEquals("-20000000000000000000", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0970()
  {
    rc_boolean = (new BigDecimal("3.9999999995705032706E+38")).equals("=CQM0CCV5SO8O:1XA=8?0VC85>KW35FD63FJ;:OJ?>B21=C>6E9VL2?GS3I5PKHNYG<OYYAXFY0L@PQ3EGK49H6PWC83?4UC3?JD");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0971()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("3.9999999995705032706E+38")).add(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("399999999957050327060000000000000000000.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-2E+19")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0975()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0976()
  {
    rc_String = (new BigDecimal("3.9999999995705032706E+38")).toString();
    Assert.assertEquals("3.9999999995705032706E+38", rc_String);
  }
  public void testItem_0977()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).abs(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0979()
  {
    rc_BigDecimal = (new BigDecimal("3.9999999995705032706E+38")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.9999999995705032706E+38", rc_BigDecimal.toString());
  }
//  public void testItem_0980()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0981()
  {
    rc_BigInteger = (new BigDecimal("1E+12")).toBigIntegerExact();
    Assert.assertEquals("1000000000000", rc_BigInteger.toString());
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1E+12"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
  }
  public void testItem_0984()
  {
    rc_BigDecimal = (new BigDecimal("3.9999999995705032706E+38")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("3.9999999995705032706E+38", rc_BigDecimal.toString());
  }
  public void testItem_0985()
  {
    rc_int = (new BigDecimal("1E+12")).scale();
    Assert.assertEquals(-12, rc_int);
  }
  public void testItem_0986()
  {
    rc_BigDecimal = (new BigDecimal("3.9999999995705032706E+38")).remainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0E-1055", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0988()
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
  public void testItem_0989()
  {
    rc_BigDecimal_array = (new BigDecimal("1E+12")).divideAndRemainder(new BigDecimal("1E+12"));
  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("0E-1055")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0992()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\0', '\234', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\1', '8', '\234', '8', '\234', '\0', '\0', '8', '\0', '\234', '\1', '\234', '8', '\1', '\1', '\uFFFF', '\234', '\234', '\0', '\0', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\1', '8', '8', '\0', '8', '\uFFFF', '\234', '\1', '\0', '\0', '8', '8', '8', '8', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\1', '8', '8', '\0', '8', '\1', '\uFFFF', '\0', '\0', '\234', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\234', '8', '8', '\234', '\1', '\1', '8', '\uFFFF', '\0', '8', '\234', '\1'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0993()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).setScale(1);
    Assert.assertEquals("1000000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0994()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.9999999995705032706E+38")).divide(new BigDecimal("3.9999999995705032706E+38"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0995()
  {
    rc_String = (new BigDecimal("3.9999999995705032706E+38")).toPlainString();
    Assert.assertEquals("399999999957050327060000000000000000000", rc_String);
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).divide(new BigDecimal("-2"));
    Assert.assertEquals("-5E+11", rc_BigDecimal.toString());
  }
  public void testItem_0998()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1E+12")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("3.9999999995705032706E+38")).remainder(new BigDecimal("3.9999999995705032706E+38"));
    Assert.assertEquals("0E+19", rc_BigDecimal.toString());
  }
}
