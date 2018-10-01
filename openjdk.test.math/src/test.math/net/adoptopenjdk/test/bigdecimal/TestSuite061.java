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
public class TestSuite061 extends TestCase
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
  
  public TestSuite061() {
	
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0000()
  {
    rc_boolean = (new BigDecimal("3.2")).equals("3:JNN:IA>QXSC@4O78BAWP18?AXG85Y0J=0:NC;GB1U9YSHATHGFF89CUUTB<2M@ECF6H@@1A?7T?EB3Y94HOQ5F@=B9RYK?IAJQ");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0001()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_float = (new BigDecimal("1E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0003()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0004()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("5L<9>D135=3O>C4TY?D==YEFUMC3TS944J7M7?6IYMKR", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0005()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate();
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0009()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0010()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("0.0"));
    Assert.assertEquals("30.0", rc_BigDecimal.toString());
  }
  public void testItem_0015()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0016()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("3E+1"));
    Assert.assertEquals("-29", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0018()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0.0"));
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0.0"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
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
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0021()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    rc_int = (new BigDecimal("3E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("1"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0026()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0027()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0028()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).stripTrailingZeros();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_short = (new BigDecimal("0.0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0032()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    rc_long = (new BigDecimal("0.0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0034()
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
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0035()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0036()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("3E+1"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0037()
  {
    rc_int = (new BigDecimal("0.0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0038()
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
  public void testItem_0039()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0.0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0042()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0043()
  {
    rc_long = (new BigDecimal("0.0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0044()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("3E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0045()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\1', '8', '8', '8', '8', '\1', '\0', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '8', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '8', '8', '8', '8', '\uFFFF', '\234', '\0', '\1', '\1', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\234', '\1', '\234', '8', '\uFFFF', '\1', '\1'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0046()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0047()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("2")).stripTrailingZeros();
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0050()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0.0"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0051()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).abs();
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0052()
  {
    rc_BigInteger = (new BigDecimal("0.0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0053()
  {
    rc_BigInteger = (new BigDecimal("1.0")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0054()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\1', '8', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\0', '8', '\234', '8', '\234', '\234', '\0', '\1', '\234', '\uFFFF', '\1', '\0', '8', '8', '\0'}, 1, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0055()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).stripTrailingZeros();
	Assert.assertEquals(0.0, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0057()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("9223372036854775807")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0058()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("3E+1"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0061()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).scaleByPowerOfTen(0);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("3E+1"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).remainder(new BigDecimal("6E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0064()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0065()
  {
    rc_long = (new BigDecimal("0E+1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0066()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).pow(-2147483648, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0067()
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
  public void testItem_0068()
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
//  public void testItem_0069()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9223372036854775807")).hashCode();
//    Assert.assertEquals(2147482656, rc_int);
//  }
  public void testItem_0070()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\0', '\1', '8', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0072()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0073()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0074()
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
  public void testItem_0075()
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
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("0E+1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("3E+1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    rc_int = (new BigDecimal("0E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0079()
  {
    rc_int = (new BigDecimal("0E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0080()
  {
    rc_int = (new BigDecimal("3E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0081()
  {
    rc_double = (new BigDecimal("0E+1")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).movePointRight(0);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divideToIntegralValue(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0085()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("0.0"), -2147483648, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0086()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).stripTrailingZeros();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0088()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\0', '\1', '\uFFFF', '\1', '\0', '\1', '\1', '\1', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '8', '8', '\uFFFF', '\234', '\234', '\1', '\234', '\0', '\234', '8', '\1', '8', '\1', '\234', '\0', '\0', '\234', '\uFFFF', '\0', '\1', '8', '\234', '8', '8', '8', '\0', '\234', '\234', '8', '\234', '8', '\234', '\1', '\234', '\1', '\0', '\234', '\1', '\1', '\0', '\0', '\234', '8', '8', '8', '\uFFFF', '\234', '8', '\1', '\0', '8', '\1', '\0', '\1', '\234', '\1', '\234', '\0', '8', '\1', '\0', '\1', '8', '8', '\1', '\uFFFF', '8', '8', '\1', '8', '8', '8', '8', '\0', '\uFFFF', '\uFFFF', '8', '8', '\234', '\1', '\1', '\0'}, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0089()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).setScale(0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0090()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigIntegerExact();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0091()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0092()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).pow(1);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0093()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).stripTrailingZeros();
	Assert.assertEquals(0.0, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    rc_String = (new BigDecimal("3E+1")).toEngineeringString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0096()
  {
    rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("1E+1"));
  }
//  public void testItem_0097()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0098()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0099()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).abs();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("1E+1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0102()
  {
    rc_String = (new BigDecimal("0E+1")).toString();
    Assert.assertEquals("0E+1", rc_String);
  }
  public void testItem_0103()
  {
    rc_String = (new BigDecimal("1E+1")).toEngineeringString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0104()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("1E+1"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0106()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0E+2"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointLeft(2147483647);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).add(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divideToIntegralValue(new BigDecimal("1135879015891"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0112()
  {
    rc_int = (new BigDecimal("0E-2147483646")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0113()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0114()
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
  public void testItem_0115()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0116()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).abs(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    rc_String = (new BigDecimal("1135879015891")).toPlainString();
    Assert.assertEquals("1135879015891", rc_String);
  }
  public void testItem_0118()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("@JK>O;0PHJ74S");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0120()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).setScale(1, 0);
    Assert.assertEquals("1135879015891.0", rc_BigDecimal.toString());
  }
  public void testItem_0121()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\234', '8', '\234', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\0', '\0', '\1', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\234', '\0', '\1', '\1', '\0', '\uFFFF', '\0', '\1', '\0', '\234', '8', '\0', '\234', '8', '8', '8', '\234', '\234', '\234', '\1', '\0', '\0', '\1', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\234', '8', '\234', '\0', '\1', '8', '\uFFFF', '\234', '\1', '\234', '\234', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '8', '\234', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\1', '\0', '\0', '\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0122()
  {
    rc_BigInteger = (new BigDecimal("1135879015891.0")).toBigIntegerExact();
    Assert.assertEquals("1135879015891", rc_BigInteger.toString());
  }
  public void testItem_0123()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1135879015891.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0125()
  {
    rc_int = (new BigDecimal("1135879015891")).precision();
    Assert.assertEquals(13, rc_int);
  }
  public void testItem_0126()
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
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_int = (new BigDecimal("1135879015891")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0130()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
//  public void testItem_0132()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("0E-2147483646"), 2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0133()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\1', '\1', '\1', '\234', '8', '\uFFFF', '8', '\uFFFF', '\1', '8', '8', '\1', '\0', '8', '8', '\1', '\0', '\0', '\1', '8', '\234', '\234', '\uFFFF', '8', '\uFFFF', '8', '8', '\234', '\uFFFF', '8', '8', '8', '\0', '8', '8', '\234', '8', '\0', '\uFFFF', '\0', '8', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\1', '\1', '\1', '\1', '\234', '\1', '8', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\234', '\234', '\234', '\1', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\234', '\0', '\1', '\234', '8', '8', '\234', '\uFFFF', '8', '\uFFFF', '8', '8', '8', '\1', '\234'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0134()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(1, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0135()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '\234', '\0', '\uFFFF', '\0', '\0', '\0', '8', '\0', '8', '\uFFFF', '\uFFFF', '\0', '8', '8', '\234', '\0', '\234', '\234', '8', '\uFFFF', '\1', '\234', '\1', '\234', '\0', '\0', '\234', '\uFFFF', '\234', '\234', '\234', '\0', '8', '8', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\234', '\234', '\0', '\uFFFF', '\234', '\234', '8', '8', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\1', '8', '\234', '\1', '\0', '8', '\0', '\0', '8', '\0', '\uFFFF', '\0', '8', '8', '\0', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\234', '\uFFFF', '\0', '\234', '\1', '\0', '\uFFFF', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0136()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1.135879015891E+2147483659", rc_BigDecimal.toString());
  }
  public void testItem_0137()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\1', '\uFFFF', '\234', '\234', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\0', '8', '8', '8', '\234', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0138()
  {
    rc_long = (new BigDecimal("1135879015891")).longValue();
    Assert.assertEquals(1135879015891L, rc_long);
  }
  public void testItem_0139()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1135879015891.0E+2147483647")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891.0")).scaleByPowerOfTen(0);
    Assert.assertEquals("1135879015891.0", rc_BigDecimal.toString());
  }
//  public void testItem_0141()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("1135879015891.0E+2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0142()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1135879015891.0")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0143()
  {
    rc_int = (new BigDecimal("1135879015891.0")).precision();
    Assert.assertEquals(14, rc_int);
  }
//  public void testItem_0144()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1135879015891.0E+2147483647")).divide(new BigDecimal("-1"), java.math.RoundingMode.HALF_UP);
//    Assert.assertEquals("-1.135879015891E+2147483659", rc_BigDecimal.toString());
//  }
  public void testItem_0145()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0146()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-1135879015891.0E+2147483647")).scaleByPowerOfTen(1);
//    Assert.assertEquals("-1.135879015891E+2147483660", rc_BigDecimal.toString());
//  }
  public void testItem_0147()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0148()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("-1135879015891.0E+2147483647")).toString();
//    Assert.assertEquals("-1.135879015891E+2147483659", rc_String);
//  }
  public void testItem_0149()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891.0")).movePointRight(0);
    Assert.assertEquals("1135879015891.0", rc_BigDecimal.toString());
  }
//  public void testItem_0151()
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
  public void testItem_0152()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0153()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-1135879015891.0E+2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0154()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891.0")).setScale(0);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1135879015891.0E+2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0156()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891.0")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0157()
  {
    rc_int = (new BigDecimal("1135879015891.0")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0158()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891.0")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891.0", rc_BigDecimal.toString());
  }
  public void testItem_0159()
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
//  public void testItem_0160()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-1135879015891.0E+2147483647")).plus();
//    Assert.assertEquals("-1.135879015891E+2147483659", rc_BigDecimal.toString());
//  }
  public void testItem_0161()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0162()
  {
    rc_boolean = (new BigDecimal("1135879015891.0")).equals("MEH2A4<V9NS:>E1D3P:A:DIL7QS2XOU6HVVIW19BWN>2O<Q6P<V7M2MU8:M8A3J<;JPL736SDF?0Q");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0163()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0164()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1135879015891.0E+2147483647")).divide(new BigDecimal("1135879015891.0"), 2147483647, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0165()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("1135879015891.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("158264490294521296321429926856523792693632841025607058375932394340608094976159697903065202592140310525891212344428523723847919392137874828485691387231752398350768478318984146294868046084698465780362652001412325597938968111968863480061343679808598391586041106060034129311956492095213208445809200287", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("158264490294521296321429926856523792693632841025607058375932394340608094976159697903065202592140310525891212344428523723847919392137874828485691387231752398350768478318984146294868046084698465780362652001412325597938968111968863480061343679808598391586041106060034129311956492095213208445809200287")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0168()
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
//  public void testItem_0169()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-1135879015891.0E+2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0170()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0171()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\234', '\234', '\0', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\234', '\234', '\1', '\1', '\234', '\234', '\0', '\1', '\0', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\0', '8', '8', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\0', '\234', '\234', '\0', '8', '\234', '8', '8', '\1', '\0', '\234', '\0', '8', '\uFFFF', '\234', '\0', '\234', '\1', '\234', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\234', '\1', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\234', '\234', '\234', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891.0")).subtract(new BigDecimal("1"));
    Assert.assertEquals("1135879015890.0", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891.0")).remainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891.0", rc_BigDecimal.toString());
  }
  public void testItem_0174()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '8', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '8', '\0', '\0', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '8', '8', '\1', '8', '8', '\1', '\234', '\234', '\234', '\1', '\uFFFF', '8', '8', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\0', '\0', '\1', '8', '\1', '8', '\234', '\uFFFF', '\234', '\1', '\0', '\0', '8', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\1', '8', '\234', '\0', '8', '\uFFFF', '\234', '8', '\0', '\1', '\0', '\0', '\1', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0175()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("-1135879015891.0E+2147483647")).toString();
//    Assert.assertEquals("-1.135879015891E+2147483659", rc_String);
//  }
  public void testItem_0176()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).stripTrailingZeros();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0178()
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
//  public void testItem_0179()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-1135879015891.0E+2147483647")).abs();
//    Assert.assertEquals("1.135879015891E+2147483659", rc_BigDecimal.toString());
//  }
//  public void testItem_0180()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("1135879015891.0E+2147483647")).toString();
//    Assert.assertEquals("1.135879015891E+2147483659", rc_String);
//  }
//  public void testItem_0181()
//  {
//    boolean caught;
//    rc_BigDecimal_array = (new BigDecimal("1135879015891.0E+2147483647")).divideAndRemainder(new BigDecimal("1135879015891.0"));
//  }
  public void testItem_0182()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
//  public void testItem_0183()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1135879015891.0E+2147483647")).negate();
//    Assert.assertEquals("-1.135879015891E+2147483659", rc_BigDecimal.toString());
//  }
//  public void testItem_0184()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1135879015891.0E+2147483647")).setScale(1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0185()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-1135879015891.0E+2147483647")).plus();
//    Assert.assertEquals("-1.135879015891E+2147483659", rc_BigDecimal.toString());
//  }
  public void testItem_0186()
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
  public void testItem_0187()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1135879015891.0E+2147483647")).setScale(2147483647, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0188()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891.0E+2147483647")).divide(new BigDecimal("-1135879015891.0E+2147483647"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0190()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-1135879015891.0E+2147483647")).remainder(new BigDecimal("1"));
//    Assert.assertEquals("-1.135879015891E+2147483659", rc_BigDecimal.toString());
//  }
  public void testItem_0191()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0192()
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
  public void testItem_0193()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0196()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1135879015891.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0197()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0198()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '8', '\0', '8', '\0', '\234', '\234', '\234', '\1', '\0', '\1', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '8', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\234', '\uFFFF', '\234', '\0', '\1'}, -2147483648, -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0199()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0200()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("-1135879015891.0E+2147483647"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0201()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0204()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0205()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0207()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0208()
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
  public void testItem_0209()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0210()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0211()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369")).toBigInteger();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369", rc_BigInteger.toString());
  }
  public void testItem_0212()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0213()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0214()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    rc_BigInteger = (new BigDecimal("32.0")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0217()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0219()
  {
    rc_boolean = (new BigDecimal("1")).equals("HR05O:@XK=K98NLB:F9Q>D=@IITW57AQNO?:?;GT?QHJ759MDYSS0>B9UH5");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0220()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0221()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0222()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0224()
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
  public void testItem_0225()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0226()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0229()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0230()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0232()
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
  public void testItem_0233()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    rc_BigDecimal = (new BigDecimal("33")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\1', '8', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\1', '\0', '\1', '\234', '\234', '\1', '\uFFFF', '\234', '\1', '\0', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\1', '8', '\0', '8', '\234', '\234', '\0', '\1', '\234', '8', '\1', '\234', '\0', '\1', '8', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\234', '8', '8', '\1', '\uFFFF', '\0'}, -2147483648, -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0236()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0237()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0238()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("J117KKI3JT2JV7E0B1:PK76OQ>X3INIEG8GDTSKYCR9198QN5R>2EG<J");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0239()
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
  public void testItem_0240()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    rc_BigDecimal_array = (new BigDecimal("1024")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("1024")).movePointLeft(1);
    Assert.assertEquals("102.4", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0248()
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
  public void testItem_0249()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0250()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1024")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0251()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0252()
  {
    rc_String = (new BigDecimal("1024")).toPlainString();
    Assert.assertEquals("1024", rc_String);
  }
  public void testItem_0253()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0254()
  {
    rc_String = (new BigDecimal("1024")).toPlainString();
    Assert.assertEquals("1024", rc_String);
  }
  public void testItem_0255()
  {
    rc_BigDecimal = (new BigDecimal("1024")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("1024")).add(new BigDecimal("1E+3"));
    Assert.assertEquals("2024", rc_BigDecimal.toString());
  }
  public void testItem_0257()
  {
    rc_BigDecimal = (new BigDecimal("2024")).negate();
    Assert.assertEquals("-2024", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+3")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0259()
  {
    rc_int = (new BigDecimal("1E+3")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0260()
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
  public void testItem_0261()
  {
    rc_BigInteger = (new BigDecimal("1024")).toBigInteger();
    Assert.assertEquals("1024", rc_BigInteger.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1024")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0264()
  {
    rc_String = (new BigDecimal("1024")).toString();
    Assert.assertEquals("1024", rc_String);
  }
  public void testItem_0265()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0266()
  {
    rc_int = (new BigDecimal("1024")).intValueExact();
    Assert.assertEquals(1024, rc_int);
  }
  public void testItem_0267()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_BigDecimal = (new BigDecimal("2024")).divide(new BigDecimal("1024"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1.9765625", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("5@0<AY;XN>CXDXF:ER8?R9=7Q>57C<9LJ5OHKJ:M4A?DVGETHGM?95VLJTOQ:LXGI4J?4:VG>CVMV0GQL<<3QOICV=?HHJW@YAKV");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("1024")).stripTrailingZeros();
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    rc_short = (new BigDecimal("1E+3")).shortValueExact();
    Assert.assertEquals(1000, rc_short);
  }
  public void testItem_0272()
  {
    rc_BigDecimal = (new BigDecimal("2024")).abs();
    Assert.assertEquals("2024", rc_BigDecimal.toString());
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("1024")).min(new BigDecimal("2024"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    rc_long = (new BigDecimal("1024")).longValue();
    Assert.assertEquals(1024L, rc_long);
  }
  public void testItem_0276()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0277()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0278()
  {
    rc_BigInteger = (new BigDecimal("2024")).toBigInteger();
    Assert.assertEquals("2024", rc_BigInteger.toString());
  }
  public void testItem_0279()
  {
    rc_BigDecimal = (new BigDecimal("1E+3")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0280()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0281()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("3E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("3E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0283()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E+1")).hashCode();
//    Assert.assertEquals(92, rc_int);
//  }
  public void testItem_0284()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0285()
  {
    rc_long = (new BigDecimal("1E+3")).longValue();
    Assert.assertEquals(1000L, rc_long);
  }
  public void testItem_0286()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).abs();
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    rc_BigDecimal = (new BigDecimal("2024")).min(new BigDecimal("9223372036854775808"));
    Assert.assertEquals("2024", rc_BigDecimal.toString());
  }
  public void testItem_0288()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\1', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\234', '\234', '\uFFFF', '\0', '8', '\0', '\1', '\1', '\0', '8', '\1', '\0', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\234', '8', '8', '8', '\uFFFF', '\0', '\234', '\1', '\1', '\0', '8', '\uFFFF', '\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0289()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).subtract(new BigDecimal("2024"));
    Assert.assertEquals("-9223372036854777832", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    rc_int = (new BigDecimal("1E+3")).compareTo(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0291()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).negate();
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("-9223372036854775808"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854777832")).multiply(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_int = (new BigDecimal("320.0E+2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0296()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0297()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-9223372036854777832")).divideAndRemainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).negate();
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0300()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854777832")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("-9.223372036854777832E+2147483665", rc_BigDecimal.toString());
  }
  public void testItem_0301()
  {
    rc_int = (new BigDecimal("-9223372036854777832.0E+2147483647")).compareTo(new BigDecimal("3E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0302()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("-9223372036854777832"));
    Assert.assertEquals("9223372036854777832", rc_BigDecimal.toString());
  }
  public void testItem_0303()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775808")).multiply(new BigDecimal("9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+37", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775808")).multiply(new BigDecimal("9223372036854775808"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("85070591730234615865843651857942052864", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    rc_BigDecimal = (new BigDecimal("9E+37")).abs();
    Assert.assertEquals("9E+37", rc_BigDecimal.toString());
  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854777832")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
//  public void testItem_0307()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9223372036854777832")).hashCode();
//    Assert.assertEquals(-2147420904, rc_int);
//  }
  public void testItem_0308()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\0', '\1', '\234', '\234', '\0', '\234', '\0', '\1', '\1', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\1', '\234', '\0', '\1', '8', '8', '8', '8', '\uFFFF', '8', '\1', '\1', '\234', '\0', '\0', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\1', '8', '8', '\1', '\0', '\uFFFF', '\0', '\1', '\0', '8', '\1', '\234', '\234', '8', '\1', '8', '\234', '\0', '\0', '8', '\1', '\234', '\234', '\1', '\1', '\234', '\234', '\234', '\uFFFF', '\0', '8', '\0', '\234', '\uFFFF', '\uFFFF', '8', '8', '\0', '\0', '\234', '\1', '8', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\1', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0309()
  {
    rc_BigDecimal = (new BigDecimal("9E+37")).stripTrailingZeros();
    Assert.assertEquals("9E+37", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("9E+37")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("9E+37")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+37", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854777832")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854777832")).add(new BigDecimal("9E+37"));
    Assert.assertEquals("90000000000000000009223372036854777832", rc_BigDecimal.toString());
  }
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854777832")).subtract(new BigDecimal("9223372036854777832"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\234', '\0', '\234', '\0', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\1', '\234', '8', '\1', '\0', '\234', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\234', '8', '\1', '\uFFFF', '\1', '\234', '\234', '8', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\1', '\0', '\0', '\234', '\uFFFF', '\0', '\1', '\1', '8', '8', '8', '\uFFFF', '\234', '\0', '\234', '\1', '8', '8', '8', '\uFFFF', '8', '\234', '\234', '8', '\0', '8'}, 0, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0316()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("U8KMS494TG49GM6F0K1I25R5P3YX62B7<ODSIVF8DC:4V;OT>:TC70;A?7OV744=6<CACHMF8HXLC1BN17>VJVNVEU6HJM:C056J");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0317()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("9E+37")).remainder(new BigDecimal("90000000000000000009223372036854777832"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+37", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854777832")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854777832")).divideToIntegralValue(new BigDecimal("9223372036854777832"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    rc_BigDecimal = (new BigDecimal("9E+37")).multiply(new BigDecimal("9E+37"));
    Assert.assertEquals("8.1E+75", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0324()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854777832")).divide(new BigDecimal("32"), -2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0326()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("8.1E+75"), -2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0327()
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
//  public void testItem_0328()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("8.1E+75")).hashCode();
//    Assert.assertEquals(2437, rc_int);
//  }
  public void testItem_0329()
  {
    rc_BigDecimal = (new BigDecimal("8.1E+75")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("8.1E+75", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    rc_BigDecimal = (new BigDecimal("8.1E+75")).scaleByPowerOfTen(0);
    Assert.assertEquals("8.1E+75", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    rc_BigDecimal = (new BigDecimal("9E+37")).max(new BigDecimal("9223372036854777832"));
    Assert.assertEquals("9E+37", rc_BigDecimal.toString());
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854777832")).subtract(new BigDecimal("8.1E+75"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-8099999999999999999999999999999999999999999999999999999990776627963145222168", rc_BigDecimal.toString());
  }
//  public void testItem_0334()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0335()
  {
    rc_int = (new BigDecimal("9223372036854777832")).compareTo(new BigDecimal("9223372036854777832"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0336()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0337()
  {
    rc_BigDecimal = (new BigDecimal("8.1E+75")).multiply(new BigDecimal("-8099999999999999999999999999999999999999999999999999999990776627963145222168"));
    Assert.assertEquals("-6.56099999999999999999999999999999999999999999999999999999252906865014762995608E+151", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854777832")).abs();
    Assert.assertEquals("9223372036854777832", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    rc_BigDecimal = (new BigDecimal("-6.56099999999999999999999999999999999999999999999999999999252906865014762995608E+151")).min(new BigDecimal("9223372036854777832"));
    Assert.assertEquals("-6.56099999999999999999999999999999999999999999999999999999252906865014762995608E+151", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("9223372036854777832"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+20", rc_BigDecimal.toString());
  }
//  public void testItem_0343()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_BigDecimal = (new BigDecimal("8.1E+75")).min(new BigDecimal("-6.56099999999999999999999999999999999999999999999999999999252906865014762995608E+151"));
    Assert.assertEquals("-6.56099999999999999999999999999999999999999999999999999999252906865014762995608E+151", rc_BigDecimal.toString());
  }
  public void testItem_0346()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0347()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0351()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0352()
  {
    rc_BigDecimal_array = (new BigDecimal("8.1E+75")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0353()
  {
    rc_String = (new BigDecimal("-6.56099999999999999999999999999999999999999999999999999999252906865014762995608E+151")).toPlainString();
    Assert.assertEquals("-65609999999999999999999999999999999999999999999999999999925290686501476299560800000000000000000000000000000000000000000000000000000000000000000000000000", rc_String);
  }
  public void testItem_0354()
  {
    rc_int = (new BigDecimal("8.1E+75")).scale();
    Assert.assertEquals(-74, rc_int);
  }
  public void testItem_0355()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0356()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0357()
  {
    rc_double = (new BigDecimal("8.1E+75")).doubleValue();
    Assert.assertEquals(8.1E75, rc_double, 0);
  }
  public void testItem_0358()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8.1E+75")).divide(new BigDecimal("-6.56099999999999999999999999999999999999999999999999999999252906865014762995608E+151"), -2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0359()
  {
    rc_BigDecimal = (new BigDecimal("-6.56099999999999999999999999999999999999999999999999999999252906865014762995608E+151")).remainder(new BigDecimal("8.1E+75"));
    Assert.assertEquals("0E+74", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
//  public void testItem_0361()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("8.1E+75")).setScale(-2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0362()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("-6.56099999999999999999999999999999999999999999999999999999252906865014762995608E+151")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    rc_BigInteger = (new BigDecimal("8.1E+75")).toBigInteger();
    Assert.assertEquals("8100000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0365()
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
  public void testItem_0366()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+74")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0367()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0368()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("8.1E+75"));
    Assert.assertEquals("-8099999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    rc_BigDecimal = (new BigDecimal("-6.56099999999999999999999999999999999999999999999999999999252906865014762995608E+151")).ulp();
    Assert.assertEquals("1E+74", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\234', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\1', '8', '\234', '\uFFFF', '8', '\1', '\234', '\1', '8', '\uFFFF', '8', '8', '\234', '\0', '8', '\1', '\0', '8', '\1', '8', '\234', '8', '\1', '\1', '\0', '\234', '\234', '\234', '\1', '8', '\1', '\0', '\0', '\0', '\234', '\234', '\234', '\1', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\0', '\234', '\0', '\1', '\1', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\234', '8', '\1', '\234', '\uFFFF', '8', '8', '8', '\1', '8', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\1'}, 1, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0371()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '8', '\234', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\234', '8', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\1', '\0', '8', '\1', '8', '8', '\1', '8', '\1', '8', '\234', '\234', '\1', '\0', '\234', '\0', '\234', '8', '\1', '8', '\1', '\0', '\234', '\0', '8', '\234', '8', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\0', '\0', '8', '\1', '8', '\1', '\0', '\1', '\0', '\0', '\1', '8', '\234', '\0', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\0', '8', '\0', '\234', '\234', '8', '\0', '\uFFFF', '\uFFFF'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0372()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1E+74")).hashCode();
//    Assert.assertEquals(-43, rc_int);
//  }
  public void testItem_0373()
  {
    rc_float = (new BigDecimal("-8099999999999999999999999999999999999999999999999999999999999999999999999999")).floatValue();
    Assert.assertEquals(java.lang.Float.NEGATIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0374()
  {
    rc_float = (new BigDecimal("-8099999999999999999999999999999999999999999999999999999999999999999999999999")).floatValue();
    Assert.assertEquals(java.lang.Float.NEGATIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("-6.56099999999999999999999999999999999999999999999999999999252906865014762995608E+151")).subtract(new BigDecimal("-8099999999999999999999999999999999999999999999999999999999999999999999999999"));
    Assert.assertEquals("-65609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000001", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_int = (new BigDecimal("8.1E+75")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0377()
  {
    rc_BigInteger = (new BigDecimal("-8099999999999999999999999999999999999999999999999999999999999999999999999999")).unscaledValue();
    Assert.assertEquals("-8099999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigInteger.toString());
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("-65609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000001")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("-2050312499999999999999999999999999999999999999999999999997665333953171134361021875000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("U=:FEHN9781N1<4O3U;7D7?SN@S664W7TVL;1CUL92DSASS3K;GI?LPHDXHX508<IX@6M731=LX=1X;JBCJ2@=MYH:AB<6HEO:BR", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0380()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("1E+74")).setScale(-1);
    Assert.assertEquals("1.0000000000000000000000000000000000000000000000000000000000000000000000000E+74", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0384()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    rc_BigDecimal = (new BigDecimal("1E+74")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+74", rc_BigDecimal.toString());
  }
  public void testItem_0386()
  {
    rc_String = (new BigDecimal("1.0000000000000000000000000000000000000000000000000000000000000000000000000E+74")).toPlainString();
    Assert.assertEquals("100000000000000000000000000000000000000000000000000000000000000000000000000", rc_String);
  }
  public void testItem_0387()
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
  public void testItem_0388()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0389()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0000000000000000000000000000000000000000000000000000000000000000000000000E+74")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0390()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 2147483647, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0391()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(-1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0392()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("T6L?Y9@MKSCG6UEM59;O?X:PVNH1T19@F09GKSTGW<EBQYBYNQ;28C0?FN04?836?H0YCPFJ>HSIH0OMKT7:4A21UBGS>MFRD57N");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0393()
  {
    rc_BigDecimal = (new BigDecimal("1E+74")).add(new BigDecimal("3E+1"));
    Assert.assertEquals("1.0000000000000000000000000000000000000000000000000000000000000000000000003E+74", rc_BigDecimal.toString());
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("1.0000000000000000000000000000000000000000000000000000000000000000000000000E+74")).divideToIntegralValue(new BigDecimal("1.0000000000000000000000000000000000000000000000000000000000000000000000000E+74"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    rc_BigDecimal = (new BigDecimal("-65609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000001")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-65609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000033", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1.0000000000000000000000000000000000000000000000000000000000000000000000000E+74")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0397()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\0', '8', '\0', '\uFFFF', '8', '\0', '\234', '\234', '8', '\0', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\234', '8', '\234', '\uFFFF', '\0', '\234', '\234', '\0', '\0', '\uFFFF', '8', '8', '\uFFFF', '\0', '\234', '\1', '8', '8', '\uFFFF', '\0', '8', '\234', '\234', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\1', '\0', '\1', '8', '\1', '8', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\234', '\234', '\0', '\234', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\234', '\234', '\234', '\1', '\234', '\234', '\0', '\1', '\uFFFF', '8', '\0', '8', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0398()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1.0000000000000000000000000000000000000000000000000000000000000000000000000E+74")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0400()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-65609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000033"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0401()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("1.0000000000000000000000000000000000000000000000000000000000000000000000000E+74")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0402()
  {
    rc_BigDecimal = (new BigDecimal("-65609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000033")).max(new BigDecimal("-65609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000033"));
    Assert.assertEquals("-65609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000033", rc_BigDecimal.toString());
  }
  public void testItem_0403()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-65609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000033"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("1A28X<RNME<9PSS;:;4;:TMY:6HPIPC4X53WQ0B;BXWX?TI?<OT<F77J?3=QMKU92;JO?AW630>JWWDW1V0GN1C@U53CD30LM14Y", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0405()
  {
    rc_BigDecimal = (new BigDecimal("-65609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000033")).negate();
    Assert.assertEquals("65609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000033", rc_BigDecimal.toString());
  }
  public void testItem_0406()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0407()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    rc_BigDecimal = (new BigDecimal("-65609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000033")).movePointLeft(2147483647);
    Assert.assertEquals("-6.5609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000033E-2147483496", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-6.5609999999999999999999999999999999999999999999999999999925290686501476299552700000000000000000000000000000000000000000000000000000000000000000000000033E-2147483496")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0412()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).divide(new BigDecimal("0.03125"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).setScale(1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0415()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=2147483647 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0416()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("0.03125")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0417()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0418()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\0', '\uFFFF', '\0', '\0', '\234', '\1', '\1', '\0', '\234', '\234', '\1', '\1', '\0', '8', '\uFFFF', '\1', '\234', '\1', '\0', '\1', '\1', '\0', '\1', '8', '\234', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\0', '\234', '8', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\1', '\0', '\1', '\234', '\1', '\234', '\1', '8', '\1', '\1', '8', '\0', '\0', '\0', '\uFFFF', '\0', '\1', '\0', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\234', '\uFFFF', '\0', '\0', '\0', '\1', '\0', '\0', '\1', '\0', '8', '\234', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\0', '\0', '8', '8', '\234', '\uFFFF', '\0', '\234', '8'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0419()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '\234', '\uFFFF', '\1', '\1', '\234', '8', '\0', '\0', '\1', '8', '\uFFFF', '\234', '\0', '\0', '\1', '\0', '\uFFFF', '\1', '\234', '\234', '\0', '\0', '8', '\1', '8', '\1', '\0', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\0', '8', '\0', '8', '\uFFFF', '\234', '\0', '8', '8', '\234', '\0', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\234', '\234', '\234', '\1', '\234', '8', '8', '8', '\1', '\1', '8', '\0', '\1', '\1', '\1', '\uFFFF', '\1', '\234'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0420()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '8', '\uFFFF', '\0', '8', '8', '8', '8', '\234', '\1', '\1', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '\0', '\uFFFF', '\0', '\0', '\234', '\234', '8', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\1', '\234', '8', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\234', '\1', '\1', '\0', '\uFFFF', '\0', '8', '\1', '\234', '\uFFFF', '8', '\0', '\234', '8', '\234', '8', '8', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\234', '8', '\1', '8', '\0', '8', '\0', '\uFFFF', '\1', '\234', '\0', '\1', '\0', '\uFFFF', '\234', '8', '\1', '\1', '\1', '\234', '\uFFFF', '\0', '\uFFFF'}, 0, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0421()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.03125")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.03", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).setScale(-1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).multiply(new BigDecimal("0.03125"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.03", rc_BigDecimal.toString());
  }
  public void testItem_0427()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
//  public void testItem_0428()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0429()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1.0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0432()
  {
    rc_BigDecimal = (new BigDecimal("0.03")).multiply(new BigDecimal("1.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.030", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    rc_BigDecimal = (new BigDecimal("0.030")).remainder(new BigDecimal("1.0"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0.030", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).remainder(new BigDecimal("0.030"));
    Assert.assertEquals("0.010", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("0.010")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0437()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1.0")).hashCode();
//    Assert.assertEquals(311, rc_int);
//  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("0.010")).plus();
    Assert.assertEquals("0.010", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_BigDecimal = (new BigDecimal("0.030")).divideToIntegralValue(new BigDecimal("0.030"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).min(new BigDecimal("1.0"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1.0"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0442()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0443()
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
  public void testItem_0444()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("DH5L2?2KJ4O8=I;>391D", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0445()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0446()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0448()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '\1', '\0', '\234', '\234', '\234', '8', '\0', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\1', '\0', '\0', '\1', '\1', '\234', '\1', '8', '\1', '\0', '\234', '\234', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\234', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '8', '\234', '8', '\1', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\0', '\234'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0449()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '8', '\uFFFF', '\0', '\1', '\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0450()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("1.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).movePointLeft(1);
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0453()
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
  public void testItem_0454()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0460()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
//  public void testItem_0461()
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
  public void testItem_0462()
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
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0465()
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
  public void testItem_0466()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0467()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0470()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\0', '\uFFFF', '\0', '8', '\1', '\1', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\1', '8', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '8', '\uFFFF', '\1', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0471()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0476()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0477()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0478()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0482()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("BC=UFENUE<:XLNQ0TEHO7?JOR><6661UU7H@GT0QVWYNGA?3WH8I:KJ06BA?=AX;H7CYQ0BTWTXAL?>MUQ6VC@XI8@8F8A:48K7F");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0484()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0485()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("8AKJT9<V");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0486()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '8', '\0', '\1', '\234', '\0', '8', '\234', '\234', '\uFFFF', '\1', '\0', '8', '8', '\0', '\234', '8', '\1', '\0', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '8', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\0', '8', '\uFFFF', '\1', '\uFFFF', '8', '\1', '8', '\0', '8', '\1', '\0', '\1', '8', '\0', '\0', '\234', '8', '\1', '\1', '8', '\0', '8', '\1', '\1', '\234', '\1', '\234', '\1', '\1', '\1', '\234', '\234', '8', '\1', '\1', '\uFFFF', '\234', '\234', '\1', '\234', '\1', '\1', '\uFFFF', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.9", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0489()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0490()
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
  public void testItem_0491()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("PWI>GDLSXRU4>5UO:==7XRFXFL8I98LA@3<X5WHHB<NOG64V32WOP0JVIOCDEB3EDI<IA?3OW0DH9HDF>>FSP5H2IA80PCENQ=WP", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0492()
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
  public void testItem_0493()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -2147483648, -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0494()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-0.9"));
    Assert.assertEquals("1.9", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("8SQLMGVCC3AJY4SKL;PWADKJSQVB7Y:M34;?QH3@:YQG:J3W<;ETJKM0V02KMDFQN3NEW:WEBY79JF=@X8DC?:KN5?QU:R0N");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0496()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\1', '\1', '8', '\0', '8', '\uFFFF', '\0', '\0', '\234', '8', '8', '\0', '\0', '\0', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\0', '\234', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\0', '\234', '\0', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '8', '\1', '\uFFFF', '\1', '\234', '8', '\1', '\1', '\1', '\1', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\1', '\0', '8', '\1', '8', '\1', '\uFFFF', '\1', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0497()
  {
    rc_String = (new BigDecimal("-0.9")).toPlainString();
    Assert.assertEquals("-0.9", rc_String);
  }
  public void testItem_0498()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0499()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-0.9")).remainder(new BigDecimal("-0.9"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0500()
  {
    rc_BigDecimal = (new BigDecimal("-0.9")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0503()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0504()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0505()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0506()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0508()
  {
    rc_int = (new BigDecimal("0.0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("-0.9")).negate();
    Assert.assertEquals("0.9", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_int = (new BigDecimal("0.0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0511()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '8', '\234', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\1', '8', '8', '\1', '\0', '\1', '\234', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\1', '\0', '\0', '\234', '8', '8', '\234', '\234', '\1', '\1', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\234', '\1', '\234', '\0', '\uFFFF', '8', '8', '\1', '\0', '8', '\234', '\0', '\234', '\uFFFF', '\1', '8', '\0', '8', '\1', '\234', '8', '\uFFFF', '\uFFFF', '8', '8', '\1', '8', '\234', '\1', '\1', '\234', '\1', '\1', '\1', '\0', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\0', '\0', '\0', '\0', '\1', '\uFFFF'}, -2147483648, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0512()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0513()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0514()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0516()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_BigDecimal = (new BigDecimal("0.9")).pow(1);
    Assert.assertEquals("0.9", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0519()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0520()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0522()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0523()
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
  public void testItem_0524()
  {
    rc_double = (new BigDecimal("0.0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0525()
  {
    rc_int = (new BigDecimal("0E+2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("0.9"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.9", rc_BigDecimal.toString());
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
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0528()
  {
    rc_String = (new BigDecimal("0.0")).toPlainString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0529()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.9")).divide(new BigDecimal("0.9"), 2147483647, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0530()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.9")).divideToIntegralValue(new BigDecimal("0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0531()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0532()
  {
    rc_BigDecimal = (new BigDecimal("0.9")).multiply(new BigDecimal("0.9"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.81", rc_BigDecimal.toString());
  }
  public void testItem_0533()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.9")).remainder(new BigDecimal("0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0534()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
//  public void testItem_0535()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483647, rc_int);
//  }
  public void testItem_0536()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).remainder(new BigDecimal("0.9"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0537()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+2147483647")).divideAndRemainder(new BigDecimal("0.81"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0538()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    rc_BigDecimal_array = (new BigDecimal("0.81")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0540()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0.81"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32.81", rc_BigDecimal.toString());
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("32.81")).abs();
    Assert.assertEquals("32.81", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("0.81")).divideToIntegralValue(new BigDecimal("8"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    rc_long = (new BigDecimal("0.00")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0544()
  {
    rc_int = (new BigDecimal("0.00")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("0.81")).multiply(new BigDecimal("0.00"));
    Assert.assertEquals("0.0000", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).divideToIntegralValue(new BigDecimal("0.00"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0547()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("0.81")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).scaleByPowerOfTen(0);
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_BigInteger = (new BigDecimal("0.00")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0550()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0551()
  {
    rc_BigDecimal = (new BigDecimal("0.9")).plus();
    Assert.assertEquals("0.9", rc_BigDecimal.toString());
  }
  public void testItem_0552()
  {
    rc_int = (new BigDecimal("0.00")).scale();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0553()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0554()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("0.00"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0555()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.00")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.IllegalArgumentException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0556()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\1', '\1', '\234', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '8', '\0', '8', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\0', '\1', '8', '\0', '\234', '8', '\234', '\1', '\uFFFF', '8', '\1', '\234', '\1', '\1', '\uFFFF', '\0', '8', '\0', '\234', '\0', '\234', '\0', '\0', '\uFFFF', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0559()
  {
    rc_String = (new BigDecimal("1E-2147483647")).toEngineeringString();
    Assert.assertEquals("100E-2147483649", rc_String);
  }
//  public void testItem_0560()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.9")).remainder(new BigDecimal("1E-2147483647"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("0.9")).divideToIntegralValue(new BigDecimal("0.9"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_BigInteger = (new BigDecimal("0.00")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0563()
  {
    rc_boolean = (new BigDecimal("0.00")).equals("Y:OUYNYH=95DD9D1Q1A>WBVIQRBK0UY5<3:174HG::9<AH=?H3YEPAA;4KNWIN?G:2A9QF33Y0Q1P@8R@G@TTH:O9?>UP4=8J5B:");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0567()
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
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0568()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).ulp();
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_String = (new BigDecimal("1E-2147483647")).toEngineeringString();
    Assert.assertEquals("100E-2147483649", rc_String);
  }
  public void testItem_0570()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.01")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0571()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0.00")).multiply(new BigDecimal("1E-2147483647"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0572()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0573()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1E-2147483647")).divideAndRemainder(new BigDecimal("0.00"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0574()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("0.00"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0576()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).movePointLeft(0);
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0577()
  {
    rc_long = (new BigDecimal("0.01")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0578()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("0.00"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0579()
  {
    rc_BigInteger = (new BigDecimal("0.00")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).negate();
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0582()
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
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).subtract(new BigDecimal("0.0"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0584()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).remainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0585()
  {
    rc_String = (new BigDecimal("0.00")).toPlainString();
    Assert.assertEquals("0.00", rc_String);
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).max(new BigDecimal("0.00"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_String = (new BigDecimal("0.00")).toEngineeringString();
    Assert.assertEquals("0.00", rc_String);
  }
  public void testItem_0588()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).remainder(new BigDecimal("0.00"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0589()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).divide(new BigDecimal("0.0"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0590()
  {
    rc_String = (new BigDecimal("0.00")).toString();
    Assert.assertEquals("0.00", rc_String);
  }
  public void testItem_0591()
  {
    rc_long = (new BigDecimal("0.00")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0592()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("0.00"), new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0593()
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
  public void testItem_0594()
  {
    rc_int = (new BigDecimal("0.00")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0595()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).negate(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    rc_String = (new BigDecimal("0.00")).toEngineeringString();
    Assert.assertEquals("0.00", rc_String);
  }
  public void testItem_0597()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("0.00"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0598()
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
  public void testItem_0599()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0601()
  {
    rc_int = (new BigDecimal("3.2E+2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0602()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0603()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).min(new BigDecimal("3.2E+2"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).movePointRight(-1);
    Assert.assertEquals("0.000", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("DGAJVBMR2=>0H;?Y7EPCC453O2F5Y333<Q@RO6@@2M?M@MH>RC=GMIO9J>U=:7EGCH47>UKAN=G@7>6;JUKL<0?KH9@F<7AS6DD8");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0608()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.000")).divide(new BigDecimal("0.0"), -2147483648, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0609()
  {
    rc_String = (new BigDecimal("0.00")).toPlainString();
    Assert.assertEquals("0.00", rc_String);
  }
  public void testItem_0610()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\234', '\234', '\1', '\0', '8', '\uFFFF', '\234', '8', '8', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\1', '8', '\0', '8', '\uFFFF', '\1', '8', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\1', '\0', '\uFFFF', '\234', '\1', '\0', '\0', '8', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '8', '8', '\uFFFF', '8', '\234', '\0', '\0', '\1', '8', '\0', '8', '\uFFFF', '\1', '8', '8', '\uFFFF', '8', '\0', '8', '\0', '8', '\234', '\uFFFF', '\1', '\0', '\1', '\234', '8', '8', '\uFFFF', '\1', '\1', '\0', '\0', '8', '\uFFFF', '\0', '\uFFFF'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0611()
  {
    rc_boolean = (new BigDecimal("0.0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("0.00"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).movePointRight(0);
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0615()
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
  public void testItem_0616()
  {
    rc_int = (new BigDecimal("3.2E+2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0617()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("0.00"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.00"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).subtract(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    rc_String = (new BigDecimal("0.0")).toString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0621()
  {
    rc_long = (new BigDecimal("3.2E+2")).longValue();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0622()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).divide(new BigDecimal("0.0"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0623()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.000")).remainder(new BigDecimal("0.00"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0624()
  {
    rc_BigInteger = (new BigDecimal("0.0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0625()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).ulp();
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).remainder(new BigDecimal("0.01"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).divide(new BigDecimal("0.00"), 1, java.math.RoundingMode.CEILING);
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
      rc_BigDecimal = new BigDecimal("5C2RCN0?C79248H4K4HW3N2:O;HS;W<A9F<P:84F4UUI1K6OO6RFYIL94I0<1=9J3VGHD;<0AUUTF8EAG53F>7AQX0XJ3STU4;CH");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0630()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("H");
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
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\uFFFF', '\0', '\1', '8', '\234', '8', '\0', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\234', '\0', '\0', '8', '\234', '\1', '\234', '\1', '\0', '8', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\234', '8', '\1', '8', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0632()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).add(new BigDecimal("0.000"));
    Assert.assertEquals("0.000", rc_BigDecimal.toString());
  }
  public void testItem_0633()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0634()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\1', '\234', '\0', '\0', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\0', '8', '\1', '\uFFFF', '8', '8', '8', '\234', '8', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\234', '\0', '\1', '\0', '\uFFFF', '8', '8', '\234', '8', '\1', '8', '\234', '\0', '\0', '\1', '\uFFFF', '\234', '\0', '\0', '\1', '\0', '\1', '\0', '\0', '\1', '8', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\0', '\0', '8', '8', '8', '\uFFFF', '\0', '\1', '\234', '8', '\234', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\234', '8', '\234', '8', '\uFFFF', '\234', '\1', '8', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0635()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).divide(new BigDecimal("0.01"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).movePointRight(-1);
    Assert.assertEquals("0.000", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0637()
  {
    rc_boolean = (new BigDecimal("0.000")).equals("VT2QTMHVN68>T9E<WUNFWL?G4?MYM47=@N?P2NP2N;PGOKF2DW8UE@5JTJ:5DILGN52R@<KCI1>UC54?@OFD=T5GR=OQB=1JUC?7");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0638()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8'}, -1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0639()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).negate();
    Assert.assertEquals("0.000", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0642()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.000")).hashCode();
//    Assert.assertEquals(3, rc_int);
//  }
  public void testItem_0643()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0.000"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0644()
  {
    rc_int = (new BigDecimal("0.000")).scale();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0645()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0646()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).max(new BigDecimal("0.000"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0647()
  {
    rc_String = (new BigDecimal("0.000")).toEngineeringString();
    Assert.assertEquals("0.000", rc_String);
  }
  public void testItem_0648()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).movePointRight(0);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0649()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).round(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0650()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+1071", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.000")).divide(new BigDecimal("0.000"), 0, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0652()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.000")).divide(new BigDecimal("0.000"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0653()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).hashCode();
//    Assert.assertEquals(1240908815, rc_int);
//  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).negate();
    Assert.assertEquals("0.000", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.000", rc_BigDecimal.toString());
  }
  public void testItem_0656()
  {
    rc_byte = (new BigDecimal("0.000")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).abs();
    Assert.assertEquals("0.000", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0659()
  {
    rc_int = (new BigDecimal("0.000")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0660()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0661()
  {
    rc_int = (new BigDecimal("0.000")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0662()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).stripTrailingZeros();
	Assert.assertEquals(0.000, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0663()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).stripTrailingZeros();
	Assert.assertEquals(0.000, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0664()
  {
    rc_BigInteger = (new BigDecimal("0.000")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0665()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).subtract(new BigDecimal("0.000"));
    Assert.assertEquals("0.000", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0667()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0668()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.000")).divideAndRemainder(new BigDecimal("0.000"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0669()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.000")).divideAndRemainder(new BigDecimal("0.000"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0671()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).setScale(0, 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("D:75RRU17QQ8Y0:QKL794I4AD6BH1U102=R9G;FI3CI=F@E778BD8NQWEEY=N9@7KU5K@TM2?<XS1NBCA40XK7V55FBP0JPMU6T1");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0674()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0675()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0678()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0679()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0680()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0684()
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
  public void testItem_0685()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0686()
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
  public void testItem_0687()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
  }
//  public void testItem_0691()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0692()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0704()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0705()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("0"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0706()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0707()
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
  public void testItem_0708()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 0, 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0709()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0710()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0714()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), 2147483647, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0715()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0716()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0717()
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
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0720()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0721()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0722()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0723()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0724()
  {
    rc_BigInteger = (new BigDecimal("10")).unscaledValue();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0725()
  {
    rc_boolean = (new BigDecimal("10")).equals("7RQAN8NYH");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("10")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("9", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_short = (new BigDecimal("10")).shortValueExact();
    Assert.assertEquals(10, rc_short);
  }
  public void testItem_0732()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toPlainString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0734()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0735()
  {
    rc_boolean = (new BigDecimal("1")).equals("FLV@POA3R8BUMDV");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0736()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0737()
  {
    rc_double = (new BigDecimal("10")).doubleValue();
    Assert.assertEquals(10.0, rc_double, 0);
  }
  public void testItem_0738()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10")).divide(new BigDecimal("1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0739()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("10"));
    Assert.assertEquals("-9", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("10")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_BigDecimal = (new BigDecimal("-9")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9", rc_BigDecimal.toString());
  }
  public void testItem_0742()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("-9")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0746()
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
  public void testItem_0747()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("-9"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0750()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-9"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0753()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0754()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0755()
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
  public void testItem_0756()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(">LFJ170;T:KTG868Q9DN5FPCRAKO9F8FDM<SKINMTQN:6<TN244U5;Y@VH=L=6?=5T43881:=3:IKEK:SDT7=TLBU8O6@CGD=O;1");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0757()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("10")).divide(new BigDecimal("1"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0760()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0761()
  {
    rc_BigDecimal = (new BigDecimal("10")).stripTrailingZeros();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0762()
  {
    rc_BigDecimal = (new BigDecimal("10")).stripTrailingZeros();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0764()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0765()
  {
    rc_int = (new BigDecimal("10")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0766()
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
  public void testItem_0767()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0769()
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
  public void testItem_0770()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0772()
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
  public void testItem_0773()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0774()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=0 roundingMode=CEILING", rc_MathContext.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0775()
  {
    rc_boolean = (new BigDecimal("0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0776()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LD<H@D;4SAACOY>AUEIGAFV3E977KI16Q=8IL=KIT51T=WXJAF>NKCJRLM?C7OTYABFPVUWEI9LS2WEHP0D:;O@2;YN==YVM@S9F", new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0777()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("10")).subtract(new BigDecimal("1"));
    Assert.assertEquals("9", rc_BigDecimal.toString());
  }
//  public void testItem_0782()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9")).divide(new BigDecimal("0"), 2147483647, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0783()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0784()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 0, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0785()
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
  public void testItem_0786()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0787()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("9"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate();
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0791()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0792()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("0"), -2147483648, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(0);
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0795()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0796()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0797()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toPlainString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0798()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0799()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0800()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0801()
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
  public void testItem_0802()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).subtract(new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881241180654147270082560", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0807()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1135879015891"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("1135879015891"), new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0811()
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
  public void testItem_0812()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0813()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).movePointLeft(0);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).subtract(new BigDecimal("1135879015891"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223373172733791699", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\0', '\0', '\234', '8', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\234', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\1', '\1', '\234', '\0', '\0', '\234', '\234', '\uFFFF', '\1', '\1', '\0', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\0', '\uFFFF', '\234', '\234', '\0', '\234', '\234', '\234', '\uFFFF', '8', '\1', '8', '\0', '\0', '\uFFFF', '\0', '\0', '\0', '8', '\234', '\1', '8', '\1', '\1', '\0', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\0'}, 0, -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0817()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1135879015891"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0819()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1, 1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0821()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0822()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0824()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("9223372036854775808"), -1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0828()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).compareTo(new BigDecimal("9223372036854775808"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0829()
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
  public void testItem_0830()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0831()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0832()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0834()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("9223372036854775808"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0835()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775808")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0838()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).negate();
    Assert.assertEquals("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0839()
  {
    rc_boolean = (new BigDecimal("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).equals(";HOCW1166EAO06UWW<3VI<R4SACG6@5Y9Q8J3;L:VBH@=E:==FH=W9@38C0K212Q");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0840()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigIntegerExact();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0841()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\0', '\1', '\234', '\1', '\uFFFF', '\0', '\0', '\1', '\234', '\0', '\0', '\uFFFF', '8', '8', '8', '8', '\0', '\234', '\0', '\1', '\0', '\0', '8', '\234', '\1', '8', '\uFFFF', '\0', '\1', '\234', '\234', '\0', '\1', '\uFFFF', '\234', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '8', '\0', '\1', '\0', '\234', '\0', '\1', '8', '\0', '8', '8', '\1', '8', '\0', '\0', '\234', '8', '\0', '\0', '\0', '\uFFFF', '\1', '\0', '\0', '\0', '\0', '8', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\0', '\234', '8', '8', '8', '8', '\uFFFF', '\0', '\234', '\0', '\1', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '8', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0842()
  {
    rc_long = (new BigDecimal("9223372036854775808")).longValue();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  public void testItem_0843()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("9223372036854775808"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_int = (new BigDecimal("9223372036854775808")).precision();
    Assert.assertEquals(19, rc_int);
  }
  public void testItem_0845()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";WJK0H");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0848()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toEngineeringString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0849()
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
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_double = (new BigDecimal("-9223372036854775808")).doubleValue();
    Assert.assertEquals(-9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0852()
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
//  public void testItem_0853()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0856()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("9223372036854775809", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).subtract(new BigDecimal("9223372036854775809"));
    Assert.assertEquals("-18446744073709551617", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_int = (new BigDecimal("9223372036854775809")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0859()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
//  public void testItem_0860()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9223372036854775809")).hashCode();
//    Assert.assertEquals(-2147483617, rc_int);
//  }
  public void testItem_0861()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0862()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0863()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0864()
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
  public void testItem_0865()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0866()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).stripTrailingZeros();
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0868()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 2147483647, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0870()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-1.08420217248550443400745280086994171142578125E-19", rc_BigDecimal.toString());
  }
  public void testItem_0871()
  {
    rc_BigInteger = (new BigDecimal("-1.08420217248550443400745280086994171142578125E-19")).unscaledValue();
    Assert.assertEquals("-108420217248550443400745280086994171142578125", rc_BigInteger.toString());
  }
  public void testItem_0872()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divideToIntegralValue(new BigDecimal("-1.08420217248550443400745280086994171142578125E-19"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("85070591730234615865843651857942052864", rc_BigDecimal.toString());
  }
  public void testItem_0873()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    rc_double = (new BigDecimal("-9223372036854775808")).doubleValue();
    Assert.assertEquals(-9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0875()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0876()
  {
    rc_BigInteger = (new BigDecimal("-1.08420217248550443400745280086994171142578125E-19")).unscaledValue();
    Assert.assertEquals("-108420217248550443400745280086994171142578125", rc_BigInteger.toString());
  }
//  public void testItem_0877()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0878()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\uFFFF', '\234', '8', '\234', '\234', '\0', '\234', '8', '\1', '\234', '\uFFFF', '\0', '\1', '\234', '\234', '\0', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\0', '\0', '\1', '\uFFFF', '8', '\0', '\1', '\1', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\234', '8', '\234', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\1', '8', '\0', '\0', '\uFFFF', '\0', '\uFFFF'}, 1, 0, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0879()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).remainder(new BigDecimal("-1.08420217248550443400745280086994171142578125E-19"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0880()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=CEILING"));
  }
  public void testItem_0881()
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
  public void testItem_0882()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-288230376151711744", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.08420217248550443400745280086994171142578125E-19")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0886()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0888()
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
  public void testItem_0889()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("1E-2147483647"));
  }
  public void testItem_0890()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).movePointRight(0);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0892()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-1.08420217248550443400745280086994171142578125E-19"));
    Assert.assertEquals("0E-63", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0896()
  {
    rc_BigDecimal = (new BigDecimal("-1.08420217248550443400745280086994171142578125E-19")).setScale(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0897()
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
  public void testItem_0898()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.08420217248550443400745280086994171142578125E-19")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0899()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigInteger();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0900()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("VGMSPS", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0901()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("7BB4FWXVBIRV;>RCAMAC;>O?C3");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0902()
  {
    rc_BigDecimal = (new BigDecimal("0E-63")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("0E-63"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0904()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    rc_BigDecimal = (new BigDecimal("0E-63")).movePointLeft(-2147483648);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0906()
  {
    rc_int = (new BigDecimal("2147483647")).intValueExact();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0907()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.08420217248550443400745280086994171142578125E-19")).divide(new BigDecimal("0"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0908()
  {
    rc_BigDecimal = (new BigDecimal("-1.08420217248550443400745280086994171142578125E-19")).stripTrailingZeros();
    Assert.assertEquals("-1.08420217248550443400745280086994171142578125E-19", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("2147483647"), new MathContext("precision=0 roundingMode=CEILING"));
  }
  public void testItem_0915()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0916()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0917()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\0', '8', '\0', '\234', '\234', '\0', '8', '\0', '\0', '\uFFFF', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0918()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("2147483647"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\1', '8', '\234', '\234', '8', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\0', '\234', '\1', '\1', '\1', '\uFFFF', '8', '\234', '8', '\uFFFF', '\0', '\0', '\234', '\0', '\234', '\1', '\uFFFF', '\1', '\0', '\0', '\234', '\0', '\1', '\1', '\uFFFF', '\1', '\234', '\234', '\1', '8', '8', '\1', '\1', '\1', '\uFFFF', '\0', '\0', '\1', '\1', '\0', '8', '\1', '\0', '\0', '\uFFFF', '\0', '8', '\234', '\0', '\234', '\1', '\1', '\1', '\234', '\1', '8', '\uFFFF', '\1', '\0', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\234', '\1', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0921()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\1', '\1', '\0', '\1', '\1', '\0', '\0', '8', '8', '\1', '\uFFFF', '\1', '\0', '\1', '\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0922()
  {
    rc_String = (new BigDecimal("-0.1")).toEngineeringString();
    Assert.assertEquals("-0.1", rc_String);
  }
  public void testItem_0923()
  {
    rc_int = (new BigDecimal("2147483647")).intValueExact();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0924()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483615", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0927()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0928()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).multiply(new BigDecimal("-0.1"));
    Assert.assertEquals("-214748364.7", rc_BigDecimal.toString());
  }
  public void testItem_0929()
  {
    rc_double = (new BigDecimal("-2147483615")).doubleValue();
    Assert.assertEquals(-2.147483615E9, rc_double, 0);
  }
  public void testItem_0930()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_int = (new BigDecimal("-2147483615")).intValueExact();
    Assert.assertEquals(-2147483615, rc_int);
  }
  public void testItem_0933()
  {
    rc_int = (new BigDecimal("-2147483615")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0934()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0935()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0936()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0937()
  {
    rc_int = (new BigDecimal("-0.1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0938()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).remainder(new BigDecimal("32"));
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-0.1")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0941()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0942()
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
  public void testItem_0943()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).abs();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0946()
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
  public void testItem_0947()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).min(new BigDecimal("1024"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\1', '\0', '\1', '\234', '\1', '\234', '8', '\234', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\1', '\uFFFF', '\234', '\234', '\234', '\1', '\234', '\234', '\uFFFF', '\1', '\1', '\0', '\0', '\0', '8', '\uFFFF', '\1', '\234', '8', '8', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '8', '\1', '\234', '\uFFFF', '\1', '\0', '\1', '8', '\uFFFF', '8', '\1', '8', '\1', '\234', '8', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF'}, 0, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0949()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1024")).divide(new BigDecimal("1024"), 2147483647, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0950()
  {
    rc_int = (new BigDecimal("1024")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0951()
  {
    rc_BigInteger = (new BigDecimal("-0.1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0952()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("O1RS4E34AANOY45KQKNU1@;E5IU=PAABYH9BM99CUCGI");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0954()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("UGFE@V?5@V7PD;UT4I3Y<7O=589MD>D@;7LY9IF23BW@U0Y8UNFO:KBCVLB;AK>?FAHI06>VOGCHEOJ=1TSRJ2@>W");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0955()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).abs();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).stripTrailingZeros();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0957()
  {
    rc_int = (new BigDecimal("-0.1")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0958()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("320.0E+2147483647"), -1, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0959()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("0.1"), -1, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0960()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.1")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0961()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).add(new BigDecimal("-0.1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0963()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.0")).hashCode();
//    Assert.assertEquals(1, rc_int);
//  }
  public void testItem_0964()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).negate();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0965()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("320.0E+2147483647")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0966()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).subtract(new BigDecimal("-0.1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0967()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("0.2")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.02", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).scaleByPowerOfTen(0);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_BigDecimal = (new BigDecimal("0.2")).subtract(new BigDecimal("0.2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0971()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0972()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).pow(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0973()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).movePointRight(0);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0975()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("0.2"));
    Assert.assertEquals("16", rc_BigDecimal.toString());
  }
  public void testItem_0976()
  {
    rc_float = (new BigDecimal("16")).floatValue();
    Assert.assertEquals(16.0F, rc_float, 0);
  }
  public void testItem_0977()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\uFFFF', '8', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\1', '\234', '\1', '\234', '\1', '\1', '\0', '\0', '\1', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '8', '8', '\234', '\0', '\0', '\0', '\0', '8', '8', '\uFFFF', '8', '\1', '\1', '\1', '8', '\234', '\234', '\0', '8', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\0', '8', '\234', '8', '\uFFFF', '8', '\uFFFF', '8', '\234', '8', '8', '\uFFFF', '\1', '\234', '8', '8', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\0', '\234', '\1', '\0', '\0', '\234', '\uFFFF', '8', '\234', '\0', '\234', '\234', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0979()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("-0.1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0981()
  {
    rc_int = (new BigDecimal("16")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("16"));
    Assert.assertEquals("16", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("=LHULJ<BX4V3T6C2C:ID37BSMU2:KWOOWCSIN;UXF=EPBLK1XMIBPDJ?VF:2EH=TM286IRNF2;XLW6HPYW1V@>UR<?31");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0985()
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
  public void testItem_0986()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0987()
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
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0989()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("16")).divideToIntegralValue(new BigDecimal("3.2"));
    Assert.assertEquals("5", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0992()
  {
    rc_String = (new BigDecimal("16")).toString();
    Assert.assertEquals("16", rc_String);
  }
  public void testItem_0993()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\1', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\0', '\0', '\0', '8', '\0', '\1', '\234', '\1', '\1', '\0', '\1', '\0', '\234', '8', '\0', '\uFFFF', '8', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '8', '\0', '\0', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '8', '8', '\uFFFF', '8', '\1', '\234', '\1', '\234', '\234', '\uFFFF'}, -1, 1, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0994()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0995()
  {
    rc_BigInteger = (new BigDecimal("16")).toBigIntegerExact();
    Assert.assertEquals("16", rc_BigInteger.toString());
  }
  public void testItem_0996()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("16")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0997()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0998()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("16")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("16")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
}
