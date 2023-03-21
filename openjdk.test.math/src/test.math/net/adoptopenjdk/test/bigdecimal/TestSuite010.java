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
public class TestSuite010 extends TestCase
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
  
  public TestSuite010() {
	  
  }
  public void testItem_0000()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0001()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("KW@@5QST5;>3PO6DNUE@9902DH2");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0002()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0004()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0005()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0006()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_int = (new BigDecimal("3.2E+2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0008()
  {
    rc_int = (new BigDecimal("3.2E+2")).intValue();
    Assert.assertEquals(320, rc_int);
  }
  public void testItem_0009()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("3.2E+2"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0012()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0013()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
//  public void testItem_0014()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E+2")).remainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
//  public void testItem_0015()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E+2")).hashCode();
//    Assert.assertEquals(991, rc_int);
//  }
  public void testItem_0016()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0017()
  {
    rc_short = (new BigDecimal("3.2E+2")).shortValueExact();
    Assert.assertEquals(320, rc_short);
  }
  public void testItem_0018()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("3.2E+2"));
    Assert.assertEquals("1.024E+4", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).min(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0021()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E+2")).hashCode();
//    Assert.assertEquals(991, rc_int);
//  }
  public void testItem_0022()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0023()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("3.2E+2"));
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    rc_short = (new BigDecimal("1.024E+4")).shortValueExact();
    Assert.assertEquals(10240, rc_short);
  }
  public void testItem_0027()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0028()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0029()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E+2")).hashCode();
//    Assert.assertEquals(991, rc_int);
//  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("1.024E+4")).movePointLeft(2147483647);
    Assert.assertEquals("1.024E-2147483643", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.024E+4")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("1.024E-2147483643")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).abs();
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0034()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.024E+4")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0035()
  {
    rc_int = (new BigDecimal("1.024E+4")).compareTo(new BigDecimal("3E-2147483645"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0036()
  {
    rc_BigDecimal = (new BigDecimal("1.024E+4")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+4", rc_BigDecimal.toString());
  }
  public void testItem_0037()
  {
    rc_BigInteger = (new BigDecimal("3E+2")).toBigIntegerExact();
    Assert.assertEquals("300", rc_BigInteger.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483645")).add(new BigDecimal("3E-2147483645"));
    Assert.assertEquals("6E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    rc_int = (new BigDecimal("1E+4")).intValue();
    Assert.assertEquals(10000, rc_int);
  }
  public void testItem_0040()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0041()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0042()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0043()
  {
    rc_String = (new BigDecimal("1E+4")).toEngineeringString();
    Assert.assertEquals("10E+3", rc_String);
  }
  public void testItem_0044()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("6E-2147483645")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0045()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("3E-2147483645"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0046()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).multiply(new BigDecimal("6E-2147483645"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1.8E-2147483642", rc_BigDecimal.toString());
  }
  public void testItem_0047()
  {
    rc_BigDecimal = (new BigDecimal("1E+4")).abs(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1E+4", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483645")).setScale(2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("3.00E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483645")).ulp();
    Assert.assertEquals("1E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0050()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).scaleByPowerOfTen(1);
    Assert.assertEquals("3E+3", rc_BigDecimal.toString());
  }
  public void testItem_0051()
  {
    rc_short = (new BigDecimal("3E+2")).shortValueExact();
    Assert.assertEquals(300, rc_short);
  }
  public void testItem_0052()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+2"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0055()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.00E-2147483645")).divideToIntegralValue(new BigDecimal("3.00E-2147483645"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//    }
//  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("3.00E-2147483645")).multiply(new BigDecimal("3E+1"));
    Assert.assertEquals("9.00E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).stripTrailingZeros();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0058()
  {
    rc_BigDecimal = (new BigDecimal("3E+3")).abs();
    Assert.assertEquals("3E+3", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).abs();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0061()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("F25VF1GC9H>N=Q7DQFMQOF0HV<>;STQ5XMY::7KT8MI3WOV", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("3E+3")).multiply(new BigDecimal("3E+3"));
    Assert.assertEquals("9E+6", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    rc_BigDecimal = (new BigDecimal("8")).remainder(new BigDecimal("3E+3"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0064()
  {
    rc_BigDecimal = (new BigDecimal("9E+6")).add(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9000008", rc_BigDecimal.toString());
  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("9000008")).negate();
    Assert.assertEquals("-9000008", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_long = (new BigDecimal("-9000008")).longValueExact();
    Assert.assertEquals(-9000008L, rc_long);
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("-9000008")).setScale(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("-9000008", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("8FV:E4<ST713901LOTHNQ86194V;EFEK6:LA=L3F6GLAESKO:OOW;JURY2O8KVC53LPJA2:PRD");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0069()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("SMKV3VN:OUX31OAGJXC>@8VVLLW8L");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0070()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0071()
  {
    rc_BigDecimal = (new BigDecimal("-9000008")).divideToIntegralValue(new BigDecimal("9000008"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0072()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    rc_BigDecimal = (new BigDecimal("9000008")).movePointRight(-1);
    Assert.assertEquals("900000.8", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).negate();
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0075()
  {
    rc_boolean = (new BigDecimal("-3E+2")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).subtract(new BigDecimal("8"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0077()
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
  public void testItem_0078()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("5=P3H7BXV@KCA5OS:5I7<6H3P;ARMAM5G6@CDUP>=OO0<;D>0A1HDOYDLMLFB7MCV<>7M4JJ:=PXATP:ULPJJ@K0XGVXQP7E?;<C");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0079()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\uFFFF', '\234', '\0', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0080()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).add(new BigDecimal("9000008"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+6", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_String = (new BigDecimal("-3E+2")).toEngineeringString();
    Assert.assertEquals("-300", rc_String);
  }
  public void testItem_0082()
  {
    rc_String = (new BigDecimal("-3E+2")).toEngineeringString();
    Assert.assertEquals("-300", rc_String);
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("9E+6")).subtract(new BigDecimal("-3E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+6", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("8")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    rc_BigDecimal = (new BigDecimal("9E+6")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+6", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    rc_float = (new BigDecimal("9E+6")).floatValue();
    Assert.assertEquals(9000000.0F, rc_float, 0);
  }
  public void testItem_0087()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("-9E+6"), java.math.RoundingMode.UP);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0088()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9E+6")).setScale(-2147483648);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
//  public void testItem_0089()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9E+6")).setScale(-2147483648, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0090()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9E+6")).divide(new BigDecimal("8"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0091()
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
  public void testItem_0092()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0093()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0094()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0095()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0096()
  {
    rc_String = (new BigDecimal("-9E+6")).toPlainString();
    Assert.assertEquals("-9000000", rc_String);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("9E+6")).negate();
    Assert.assertEquals("-9E+6", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_BigDecimal = (new BigDecimal("9E+6")).divide(new BigDecimal("-3E+2"), 1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("-30000.0", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    rc_long = (new BigDecimal("-3E+2")).longValueExact();
    Assert.assertEquals(-300L, rc_long);
  }
  public void testItem_0100()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\234', '\0', '\1', '\1', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '8', '8', '\234', '\1', '\1', '\1', '\1', '\234', '\uFFFF', '\1', '\0', '\0', '\234', '\1', '\234', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\234', '\234', '\1', '\234', '\uFFFF', '8', '\0', '8', '\234', '\1', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\0'}, -2147483648, 1, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0101()
  {
    rc_BigDecimal = (new BigDecimal("-30000.0")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+4", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    rc_String = (new BigDecimal("-9E+6")).toPlainString();
    Assert.assertEquals("-9000000", rc_String);
  }
  public void testItem_0103()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0104()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(-1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0106()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 1, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0107()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).stripTrailingZeros();
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).negate(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0111()
  {
    rc_boolean = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).equals("2GCEA>MD847QT30N2I9WW<K1G>5DP<W==22QWUFD>4HT053BE3M;2SBHYB7=0V7>OKHMLLMFFPO8YETWAUVL>2FS67?I8D<ADY70");
    Assert.assertEquals(false, rc_boolean);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0112()
  {
    rc_boolean = (new BigDecimal("2147483648")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0113()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483648")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1, 1);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0115()
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
  public void testItem_0116()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1.0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0117()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483648")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0118()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).plus();
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).plus();
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(1);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0123()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("-2147483648"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-10"), -2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0126()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0127()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0128()
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
  public void testItem_0129()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0130()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-10")).divide(new BigDecimal("0"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0131()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("DEOGAP219>68WRTK>9XS=:LSRQ7LNLSEPEX");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0132()
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
  public void testItem_0133()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0134()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\1', '\234', '\1', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0135()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-10"));
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0136()
  {
    rc_long = (new BigDecimal("-10")).longValue();
    Assert.assertEquals(-10L, rc_long);
  }
  public void testItem_0137()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("?N8SAD8JRG?UERS?IEDL<PMTLA@PWJR5JCIHYT<?UH577<W=VH;KG4KE<>YMRTD?GLNYA?<CBH=TM6L", new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0139()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0142()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), -2147483648, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0143()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0146()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0148()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("RQ85Y@DPQH5>=QHOIL<W32PX5?<?PD05K@;>DAX6C2K7M<HM9R33CSK<407<7WCM6O<8<7;Y96?BF7@FS:>DRL:PYV4OK9572BSC");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0149()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '\234', '\uFFFF', '\0', '\234', '\1', '\1', '\uFFFF', '\1', '\1', '\1', '\234', '\1', '\uFFFF', '\234', '\0', '8', '\234', '\1', '\1', '8', '\234', '\234', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '8', '8', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\234', '8', '8', '\0', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\234', '8', '\0', '8', '\0', '8', '\234', '\0', '\1', '\234', '\234', '\1', '\0', '\1', '8', '\1', '\1', '\0', '\0', '\1', '\234', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\0', '\234', '\uFFFF', '\1', '\1', '\1', '8', '\1', '\234', '\0', '\uFFFF', '8', '\1', '\234', '\1', '8', '\1', '\0', '\1', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0151()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0152()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0153()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("3E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0156()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0157()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0158()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0159()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483648")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0160()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0161()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0163()
  {
    rc_int = (new BigDecimal("-2147483648")).intValue();
    Assert.assertEquals(-2147483648, rc_int);
  }
  public void testItem_0164()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0165()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).abs(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    rc_float = (new BigDecimal("3.2E-2147483646")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0169()
  {
    rc_int = (new BigDecimal("0.00")).signum();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0170()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E-2147483646")).hashCode();
//    Assert.assertEquals(-2147482657, rc_int);
//  }
  public void testItem_0171()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).max(new BigDecimal("0.00"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    rc_int = (new BigDecimal("0E+1")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0174()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("0E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0175()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483646")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0176()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483646")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0177()
  {
    rc_String = (new BigDecimal("0.00")).toPlainString();
    Assert.assertEquals("0.00", rc_String);
  }
  public void testItem_0178()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("-2147483648"));
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).subtract(new BigDecimal("0.00"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0181()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0E-2147483646"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0182()
  {
    rc_short = (new BigDecimal("0E+1")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0183()
  {
    rc_int = (new BigDecimal("-2147483648")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0184()
  {
    rc_long = (new BigDecimal("-2147483648")).longValueExact();
    Assert.assertEquals(-2147483648L, rc_long);
  }
  public void testItem_0185()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3.2E-2147483646")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0186()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0187()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0189()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("0"), java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0190()
  {
    rc_long = (new BigDecimal("0E-2147483646")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0191()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0192()
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
  public void testItem_0193()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E-2147483646"), 2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0198()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0199()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3.2E-2147483646"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0200()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0201()
  {
    rc_String = (new BigDecimal("0E+1")).toString();
    Assert.assertEquals("0E+1", rc_String);
  }
  public void testItem_0202()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0203()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LUJ:>X2336K0LLPW>40DE;<AYUM4F?>3BYC2N;Q<PO0QTTRSPDVQ:9GC:Q@40F2>@FRP<GT6VRL@8=8KR9:5NCJEVH:GR8=:79:H", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0206()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0208()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '8', '\0', '\234', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\234', '\234', '\uFFFF', '\234', '8', '\1', '\234', '\1', '\234', '\0', '\1', '\1', '\uFFFF', '\1', '8', '\234', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\234', '\234', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\234', '8', '\234', '\0', '8', '\0', '\0', '8', '\1', '8', '8', '\uFFFF', '\0', '\0', '\1', '\0', '\0', '\1', '\uFFFF', '8', '\1', '\1', '\0', '\234', '8', '\uFFFF', '\234', '\0', '8'}, -2147483648, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0209()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0210()
  {
    rc_int = (new BigDecimal("0E-2147483646")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0211()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("NF6U1AKJ9WCN:XB65VCA:GVW9F5T?TGI2X34N80@F531P05");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0213()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0214()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0215()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, 0);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0218()
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
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
//  public void testItem_0219()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).plus(new MathContext("precision=2147483647 roundingMode=DOWN"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0220()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '\234', '\uFFFF', '8', '\234', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '8', '\1', '8', '\234', '\0', '8', '8', '\1', '\uFFFF', '8', '\234', '\1', '\234', '\0', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0221()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
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
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0223()
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
  public void testItem_0224()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    rc_BigInteger = (new BigDecimal("00.0E+2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0226()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0227()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("09AKQ;;YT2S>EBB;15J5S82W9WX@QK?=;M7AIG2JNIFUA1RFH4JPJT2GOQ96023S2DJO1P4@:Y2N8GAX86C95GVHS7NE5W8SG2CL");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0228()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0229()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0230()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0231()
  {
    rc_float = (new BigDecimal("0E+1")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("0E+1"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0235()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0236()
  {
    rc_BigInteger = (new BigDecimal("3.2E-2147483646")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0237()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).stripTrailingZeros();
	Assert.assertEquals(0E-2147483646, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0239()
  {
    rc_BigInteger = (new BigDecimal("3.2E-2147483646")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
//  public void testItem_0240()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0E-2147483646"), java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).pow(1);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("0E-2147483646"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0243()
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
  public void testItem_0244()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0245()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("00.0E+2147483647")).intValueExact();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0246()
  {
    rc_int = (new BigDecimal("0E-2147483646")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0247()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("00.0E+2147483647")).divideAndRemainder(new BigDecimal("0E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0248()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0249()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("0E-2147483646"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0250()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("0"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0251()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0252()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), java.math.RoundingMode.DOWN);
//    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
//  }
  public void testItem_0253()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0254()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0255()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483646")).multiply(new BigDecimal("3.2E-2147483646"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
//  public void testItem_0256()
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
  public void testItem_0257()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).add(new BigDecimal("1135879015891"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2271758031782", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0261()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("G4G8=;RKR0OLX3:IV:4I8OCA0?>FH;VG5PDN=1:?BJ5H<ETDCAVU:G;DVRNHXW?GYJA5WD3HSO=N9;V;53X1WE29QD:DYRXEQ5DX", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0262()
  {
    rc_int = (new BigDecimal("1135879015891")).intValue();
    Assert.assertEquals(2007649747, rc_int);
  }
  public void testItem_0263()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0264()
  {
    rc_float = (new BigDecimal("3.2E-2147483646")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0265()
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
  public void testItem_0266()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0267()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointLeft(-2147483648);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    rc_float = (new BigDecimal("3.2E-2147483646")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0270()
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
//  public void testItem_0271()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("0"), -2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
//  public void testItem_0272()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320")).remainder(new BigDecimal("320"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0273()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0274()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1135879015891")).setScale(-2147483648, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0275()
  {
    rc_long = (new BigDecimal("3E+1")).longValueExact();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0276()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0277()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0278()
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
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0279()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointLeft(-2147483648);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0280()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0281()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\0', '\1', '8', '\1', '\234', '8', '\234', '\uFFFF', '8', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\234', '\1', '\1', '8', '\1', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\1', '\0', '\0', '\234', '\0', '\234', '\0', '8', '8', '\0', '\1', '\234', '8', '\0', '\1', '8', '\uFFFF', '8', '\234', '\234', '\234', '\234', '\0', '8', '\0', '\1', '\234', '\234', '\234', '\1', '\234', '\0', '8', '8', '\234', '\0', '\234', '8', '\234', '\234', '8', '8', '8', '8', '\0', '\uFFFF', '\0', '8', '\234', '\234', '\234', '\234', '\234', '8', '\234', '\234', '8', '\234', '\0', '\1', '8', '8', '\1', '\1', '\234', '8', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0282()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0283()
  {
    rc_int = (new BigDecimal("3.2")).compareTo(new BigDecimal("320"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0284()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0285()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0286()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).movePointLeft(2147483647);
    Assert.assertEquals("1.135879015891E-2147483635", rc_BigDecimal.toString());
  }
//  public void testItem_0287()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).add(new BigDecimal("1135879015891"));
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
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\234', '\1', '\uFFFF', '\234', '\234', '\0', '\234', '\uFFFF', '\1', '\234', '8', '\0', '\0', '\234', '\uFFFF', '\1', '\1', '\0', '\0', '\234', '\uFFFF', '\234', '\0', '\234', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\0', '\1', '\0', '\234', '\0', '\1', '\0', '\0', '\0', '8', '\uFFFF', '\1', '\234', '\1', '\0', '\uFFFF', '\234', '\0', '\0', '\1', '8', '\0', '\1', '\234', '8', '\0', '\uFFFF', '\234', '\1', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0289()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1.135879015891E-2147483635"), 1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0290()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0291()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0294()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("1.135879015891E-2147483635"));
    Assert.assertEquals("1.135879015891E-2147483635", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0297()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0299()
  {
    rc_String = (new BigDecimal("0.0")).toPlainString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0300()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0301()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\1', '8', '\234', '\1', '\234', '\234', '\0', '\234', '\234', '\234', '\0', '\1', '8', '\0', '8', '\1', '\234', '\uFFFF', '\0', '\234', '8', '8', '\0', '\1', '\0', '\uFFFF', '\234', '\234', '\0', '\1', '\1', '8', '\0', '8', '8', '8', '\0', '\uFFFF', '\234', '\234', '\0', '8', '8', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\234', '\1', '\0', '\0', '\1', '\234', '8', '\1', '\1', '8', '\1', '\234', '\234', '8', '8', '\0', '\1', '\1', '\0', '\0', '\0', '\0', '\234', '\0', '8', '\uFFFF', '\234', '8', '\234', '8', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0302()
  {
    rc_int = (new BigDecimal("0.0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0303()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).min(new BigDecimal("0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0305()
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
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0308()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0309()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0314()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\0', '\1', '\1', '\0', '\1', '\234', '\234', '\1', '8', '\0', '8', '\234', '\234', '\1', '\234', '\234', '\0', '\0', '\234', '8', '\0', '\0', '\0', '\1', '\1', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\1', '\234', '8', '\uFFFF', '\1', '\1', '8', '\1', '8', '\0', '\0', '\234', '\1', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '8', '8', '\234', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\0', '\0', '\1', '\uFFFF', '\234', '\1', '\1', '\1', '8', '\1', '\1', '\uFFFF', '\1', '8', '\0', '\0'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0315()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(">IM>P0IX:XKQX3<N>8=HPOQXDL7EQDQFFPXB9B8<AVGFG:WJ28PWNBVKC07:Y4TF432@H@XF6:O5QP@8P5G2D?@TCN5OC2UAO?;7");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0316()
  {
    rc_int = (new BigDecimal("3E+1")).intValueExact();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0317()
  {
    rc_float = (new BigDecimal("3E+1")).floatValue();
    Assert.assertEquals(30.0F, rc_float, 0);
  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0.0"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_String = (new BigDecimal("3E+1")).toPlainString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0320()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\0', '\0', '\234', '\uFFFF', '8', '8', '\234', '\uFFFF', '\0', '\0', '\1', '\234', '\234', '8', '\234', '\0', '\1'}, 1, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0321()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).setScale(1);
    Assert.assertEquals("30.0", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("1.0"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0323()
  {
    rc_int = (new BigDecimal("1.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("30.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\1', '8', '\1', '\0', '\1', '\0', '\0', '8', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '8', '8', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\0', '\234', '8', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\1', '\0', '\0', '\uFFFF', '\234', '\234', '\0', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\uFFFF', '8', '\1', '\0', '8', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\234', '8', '8', '\uFFFF', '\234', '\1', '\1', '8', '\1', '\234', '\234', '8', '\0', '\234', '8', '\234', '\1', '\234', '\0', '\234', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '\1', '\234'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0326()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divideToIntegralValue(new BigDecimal("30.0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0327()
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
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).abs(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0"), 0, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("T9A8X6EBY688P6>6N;IS@P9HLEAYYP2RSBKBG016AXOX4W@HM2I2KBVFSYHGH:18D7W=H", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0333()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0334()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0335()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("RVER<M=V48K@RF3?CFFQ6W");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0336()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0337()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0339()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0341()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0342()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("30.0"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0343()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0344()
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
  public void testItem_0345()
  {
    rc_int = (new BigDecimal("30.0")).intValueExact();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0346()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0347()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0348()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0349()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LJVQ:PQU2:9S2V3XT;EAATXV?OIFO?H>5M=LS?1BI3?:9Q9TIR>0I2KSE6=5=4IP1Y>KFTR;2HCLP99=<5YN?RWYEH2DE48WDXBB");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0350()
  {
    rc_BigDecimal = (new BigDecimal("30.0")).stripTrailingZeros();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0351()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    rc_BigDecimal_array = (new BigDecimal("30.0")).divideAndRemainder(new BigDecimal("30.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E+1"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0355()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0356()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus();
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0357()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0358()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\1', '8', '\1', '8', '\0', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\234', '\1', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\0', '\234', '8', '8', '\234', '\1', '\0', '\1', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\0', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '8', '\234', '8', '\0', '\234', '\234', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\1', '\1', '\uFFFF', '8', '\234', '\1', '\234', '\0', '8', '\1', '\234', '\1', '\1', '8', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\0', '\0', '8', '\234', '8', '\1', '8', '\0', '\234', '8', '8', '\234', '\1', '\234', '8', '\0', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0359()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0360()
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
  public void testItem_0361()
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
  public void testItem_0362()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("2E+9"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0369()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '8', '\1', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\234', '\234', '\0', '\uFFFF', '\234', '8', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\1', '\0', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\0', '\0', '8', '\1', '\1', '8', '8', '\0', '\1', '\0', '\234', '\234', '\234', '\uFFFF', '\1', '\234', '\1', '8', '8', '\0', '8', '\0', '\1', '\0', '\uFFFF', '8', '\0', '\234', '\0', '\0', '\0', '\0', '8', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\234', '8', '\234', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0370()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\234', '8', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\0', '\1', '8', '\0', '\1', '\1', '8', '\234', '\1', '\1', '\234', '\234', '\234', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\234', '\234', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\1', '8', '\uFFFF', '8', '\0', '\1', '\234', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '8', '8', '\0', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\234', '8', '\1', '\1', '\0', '8', '\1', '\uFFFF', '\0', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\1', '\uFFFF', '\1', '\0', '\1', '\0', '8', '\uFFFF', '8'}, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0373()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0374()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("3E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0379()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("L:2GHWG4O;QD;0MBTJ6:H1I7J8ROA7697SNM96M0C1<OQT?5I2G:R1?27@GDQBHXPQFX:PKFYLS0G>48?KSVGU=BTFM31BMCJCIJ", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0384()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("G7G4QOD40YE03NEV4XTY;F:LV9=3RCLF;EDA6RR6LOF2VVBI25BQ?2RUAK2MB;R56FNWX<XUBXRJ6G=M76L", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0386()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0388()
  {
    rc_double = (new BigDecimal("0E+1")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).setScale(2147483647, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0391()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("0E+1"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0392()
  {
    rc_float = (new BigDecimal("0E+1")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0393()
  {
    rc_int = (new BigDecimal("3E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0397()
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
  public void testItem_0398()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).multiply(new BigDecimal("32"));
    Assert.assertEquals("9.6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0401()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("=I9HS5AL2T?JWN0S:4J55N1<8R7?7@U11?U?VL30HOWNCS=5X71SBOH", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0402()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0403()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("<C523R8<I2N;C10XMMV3T7UV>V1E41MYP5U3;9<0QJTT");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0406()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("NCNJ?G9>MJJCKO::DAFV?T@?1UQ<S:407PQ>K", new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0407()
  {
    rc_boolean = (new BigDecimal("0E+1")).equals("8YD?D7RPEDAE7IHMKUV<THND28R=80@P1RQ8:@T8LIYV23PT72E<X4:8@3==FUK4DYV@OACPJLJ<YO:FBT5C74T>21WL70BQT?5U");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0408()
  {
    rc_BigDecimal = (new BigDecimal("9.6E+2")).plus();
    Assert.assertEquals("9.6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\234', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\234', '\0', '\1', '\1', '\uFFFF', '\1', '\234', '8', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '8', '8', '8', '\1', '\234', '\0', '\234', '\234', '\1', '\1', '\1', '\0', '\0', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\0', '\uFFFF', '\0', '\234', '8', '8', '8', '\0', '\uFFFF', '\0', '\0', '8', '8', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '8', '\234', '\1', '\234', '\1', '\234', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0410()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\234', '8', '\234', '8', '\234', '\1', '\0', '\234', '8', '\uFFFF', '8', '\1', '8', '\0', '\234', '8', '8', '\1', '\234', '\0', '\234', '8', '\234', '\uFFFF', '\234', '\1', '8', '\0', '\uFFFF', '8', '\1', '8', '\uFFFF', '\0', '8', '\1', '\1', '\uFFFF', '\234', '\1', '\234', '8', '8', '8', '8', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\0', '\0', '\uFFFF', '8', '8', '\uFFFF', '\0', '\234', '\1', '\1', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\1', '\1', '8', '8', '\uFFFF', '\0', '8', '\1', '\234', '8', '\234', '\uFFFF', '\0', '8', '\0', '\1', '\234', '\234', '8', '\1', '8', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\1', '\1', '\1', '\1'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0411()
  {
    rc_double = (new BigDecimal("9.6E+2")).doubleValue();
    Assert.assertEquals(960.0, rc_double, 0);
  }
  public void testItem_0412()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0413()
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
  public void testItem_0414()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("9.6E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0415()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1E+3"));
    Assert.assertEquals("1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1E+3"));
    Assert.assertEquals("0.000", rc_BigDecimal.toString());
  }
  public void testItem_0417()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0420()
  {
    rc_int = (new BigDecimal("31")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0421()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("31")).movePointRight(0);
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_BigDecimal = (new BigDecimal("31")).multiply(new BigDecimal("1E+3"));
    Assert.assertEquals("3.1E+4", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0425()
  {
    rc_float = (new BigDecimal("1E+3")).floatValue();
    Assert.assertEquals(1000.0F, rc_float, 0);
  }
  public void testItem_0426()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0427()
  {
    rc_BigDecimal = (new BigDecimal("31")).multiply(new BigDecimal("32"));
    Assert.assertEquals("992", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0429()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=0 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("31"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0432()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0433()
  {
    rc_BigDecimal = (new BigDecimal("992")).setScale(-1, 1);
    Assert.assertEquals("9.9E+2", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0436()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0437()
  {
    rc_BigDecimal = (new BigDecimal("992")).negate();
    Assert.assertEquals("-992", rc_BigDecimal.toString());
  }
  public void testItem_0438()
  {
    rc_int = (new BigDecimal("3.1E+4")).intValueExact();
    Assert.assertEquals(31000, rc_int);
  }
  public void testItem_0439()
  {
    rc_BigDecimal = (new BigDecimal("31")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    rc_BigDecimal = (new BigDecimal("3.1E+4")).remainder(new BigDecimal("3.1E+4"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+3", rc_BigDecimal.toString());
  }
  public void testItem_0444()
  {
    rc_String = (new BigDecimal("0E+3")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0445()
  {
    rc_BigDecimal = (new BigDecimal("3.1E+4")).setScale(1);
    Assert.assertEquals("31000.0", rc_BigDecimal.toString());
  }
  public void testItem_0446()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0448()
  {
    rc_BigDecimal = (new BigDecimal("0E+3")).setScale(1, java.math.RoundingMode.UP);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    rc_String = (new BigDecimal("0E+3")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0450()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+3")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0451()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0452()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0453()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0454()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0456()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("0E+3")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_BigDecimal = (new BigDecimal("0E+3")).multiply(new BigDecimal("0E+3"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+6", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("0E+3")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";6KQVAVVW79=GARX9CHU6X:3@9Y5?JEWSQ@?G6GV;<SSXU><B3XK8X9V97FEKFTTWOIR4F7NO7@WOB6DB32NHL6DX7", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0462()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toEngineeringString();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_String);
  }
  public void testItem_0463()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0464()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0465()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("0E+6")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0470()
  {
    rc_BigDecimal = (new BigDecimal("-5E-324")).multiply(new BigDecimal("0E+6"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-318", rc_BigDecimal.toString());
  }
  public void testItem_0471()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("0E+6")).abs(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0E+6", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_BigInteger = (new BigDecimal("-5E-324")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).plus(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("1O:8RDS2S:G?HI=KW0U=M14QH=WFQX68PLODM=97ARRM:Y?38U64>U26IQM?VMFE", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0478()
  {
    rc_BigDecimal = (new BigDecimal("0E+6")).min(new BigDecimal("0E+6"));
    Assert.assertEquals("0E+6", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_String = (new BigDecimal("0E-318")).toString();
    Assert.assertEquals("0E-318", rc_String);
  }
  public void testItem_0480()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-5E-324")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0481()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).max(new BigDecimal("-2147483648"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0482()
  {
    rc_int = (new BigDecimal("-2147483648")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0483()
  {
    rc_BigDecimal = (new BigDecimal("-5E-324")).subtract(new BigDecimal("-2147483648"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).unscaledValue();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0485()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    rc_float = (new BigDecimal("3E+1")).floatValue();
    Assert.assertEquals(30.0F, rc_float, 0);
  }
  public void testItem_0488()
  {
    rc_byte = (new BigDecimal("3E+1")).byteValueExact();
    Assert.assertEquals(30, rc_byte);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0489()
  {
    rc_boolean = (new BigDecimal("-3E+1")).equals("<IU776OUNH06XYQ5L@72KTSA@TET=V3T>1X>?F1KCX263JTQKP");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0490()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0491()
  {
    rc_int = (new BigDecimal("-3E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0492()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0493()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).toBigInteger();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
//  public void testItem_0494()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("2147483647.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995")).divideAndRemainder(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0495()
  {
    rc_long = (new BigDecimal("-3E+1")).longValue();
    Assert.assertEquals(-30L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0496()
  {
    rc_boolean = (new BigDecimal("-3E+1")).equals("OE>@A?7SN;4LJCD:EQ3G142EUD50H;=F?7H1CXU7NTYS9>M6K8Y@K7S>455@H804FM7XYI2DLSV:@IQCN0172R");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0497()
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
  public void testItem_0498()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"), -1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0499()
  {
    rc_long = (new BigDecimal("2147483647.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995")).longValue();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0500()
  {
    rc_int = (new BigDecimal("3E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0501()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0502()
  {
    rc_int = (new BigDecimal("0E+1")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0503()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    rc_float = (new BigDecimal("-3E+1")).floatValue();
    Assert.assertEquals(-30.0F, rc_float, 0);
  }
  public void testItem_0505()
  {
    rc_int = (new BigDecimal("0E+1")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0506()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("0E+1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_String = (new BigDecimal("0E+1")).toEngineeringString();
    Assert.assertEquals("0.00E+3", rc_String);
  }
  public void testItem_0510()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0511()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("G=COX1:LL=C:", new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0512()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0513()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).setScale(0);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0514()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("21SH4K<I9=5AVVTA9YOR:73L:61PTOHQ2YCE2QPYY=RET0E5>2S:CTDB7L1VUV6:TO2DJ6E<9Q3NLC;9WOK4EU=P32G649U=AJFD", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0515()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0516()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0517()
  {
    rc_String = (new BigDecimal("3E+1")).toEngineeringString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0518()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    rc_int = (new BigDecimal("-3E+1")).intValueExact();
    Assert.assertEquals(-30, rc_int);
  }
  public void testItem_0520()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("3E+1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    rc_long = (new BigDecimal("0E+1")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '\234', '\uFFFF', '\234', '8', '8', '8', '8', '8', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\0', '\1', '\234', '\0', '\0', '\uFFFF', '\1', '8', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("-3E+1"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("QAEJNX0IBAD1?988RRKVS7X@48PO06HE?3XSINSEXBJ1?HDXC", new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0528()
  {
    rc_int = (new BigDecimal("-2147483648")).intValue();
    Assert.assertEquals(-2147483648, rc_int);
  }
  public void testItem_0529()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0530()
  {
    rc_String = (new BigDecimal("-3E+1")).toPlainString();
    Assert.assertEquals("-30", rc_String);
  }
  public void testItem_0531()
  {
    rc_String = (new BigDecimal("-2147483648")).toPlainString();
    Assert.assertEquals("-2147483648", rc_String);
  }
//  public void testItem_0532()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483648")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0533()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0534()
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
  public void testItem_0535()
  {
    rc_short = (new BigDecimal("-3E+1")).shortValueExact();
    Assert.assertEquals(-30, rc_short);
  }
  public void testItem_0536()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).add(new BigDecimal("-3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("00.0E+2147483647"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0539()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2147483648")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
//  public void testItem_0540()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-3E+1"), java.math.RoundingMode.UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("-2147483648"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0544()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).stripTrailingZeros();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-3E+1"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0547()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483648")).divide(new BigDecimal("0"), 2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0548()
  {
    rc_String = (new BigDecimal("-3E+1")).toEngineeringString();
    Assert.assertEquals("-30", rc_String);
  }
  public void testItem_0549()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0550()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).divide(new BigDecimal("2147483648"), 1, 1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0551()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).min(new BigDecimal("-2147483648"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0552()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("2147483648"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0557()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0558()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0560()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0561()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0564()
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
  public void testItem_0565()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    rc_double = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).doubleValue();
    Assert.assertEquals(1.7976931348623157E308, rc_double, 0);
  }
  public void testItem_0567()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0571()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0572()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0573()
  {
    rc_boolean = (new BigDecimal("-32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0574()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0575()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0576()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0577()
  {
    rc_String = (new BigDecimal("-32")).toEngineeringString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0578()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0581()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0582()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("-32")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0584()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -1, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0585()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divideToIntegralValue(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0590()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0591()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0592()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0593()
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
  public void testItem_0594()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("R3A2C42FYXCRG?YR7T;2NY9I=SH42G7UKR>;:O:=1@JXV;7MIIF95F:HTVAQLVQI3EAKC;5T3U:9=7BTJ3T=JU7W;1", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0595()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0598()
  {
    rc_boolean = (new BigDecimal("0")).equals("RSDLSM4R1X8?1RP;@4?>FB1KD@FVKXOC3MU8L:8740F:IK1S@AHB>>LI:G@PYSJWS6V0P=9LY<H6<5IF:Y8X;0=P4=LCK=42U>5V");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0599()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-32")).hashCode();
//    Assert.assertEquals(-992, rc_int);
//  }
  public void testItem_0600()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0601()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).pow(1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0602()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0603()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).add(new BigDecimal("0"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0608()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0610()
  {
    rc_BigDecimal = (new BigDecimal("-32")).add(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-64", rc_BigDecimal.toString());
  }
  public void testItem_0611()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0618()
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
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0619()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0622()
  {
    rc_int = (new BigDecimal("-64")).compareTo(new BigDecimal("-64"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0623()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0624()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0626()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0627()
  {
    rc_int = (new BigDecimal("-64")).intValue();
    Assert.assertEquals(-64, rc_int);
  }
  public void testItem_0628()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-64")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0630()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).add(new BigDecimal("0"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0631()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("0.03125")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0632()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0633()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).divide(new BigDecimal("0.03125"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1.00000", rc_BigDecimal.toString());
  }
  public void testItem_0634()
  {
    rc_BigDecimal = (new BigDecimal("-64")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0635()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0636()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.03125")).setScale(-2147483648, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0637()
  {
    rc_BigDecimal = (new BigDecimal("1.00000")).divideToIntegralValue(new BigDecimal("-32"));
    Assert.assertEquals("0.00000", rc_BigDecimal.toString());
  }
  public void testItem_0638()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("=VP@XSKFG0?KGQL8I;URRMQH12W@MX:NNAOLHLJ273F25KA89?UDX35H>R1UV4G==?U03:04UO6;G4", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0639()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("-32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigDecimal = (new BigDecimal("1.00000")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1.00000", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("7U@GE?3AT5O5L?X9@;K56TSY8W5ES2UGQTJU7LFKDE=10L?1JFU7FT3K6HW;DLY>8E>T;1@IARACU;P>6IR4FQIN@1YH00SJQ==L");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0643()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("-32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    rc_BigInteger = (new BigDecimal("6E+1")).unscaledValue();
    Assert.assertEquals("6", rc_BigInteger.toString());
  }
  public void testItem_0646()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\0', '\1', '\234', '\uFFFF', '8', '\0', '\0', '\1', '\234', '\uFFFF', '8', '\0', '8', '8', '\1', '\0', '8', '8', '\0', '8', '\234', '\uFFFF', '\234', '\1', '\1', '8', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\234', '\1', '\0', '\1', '\234', '\0', '\234', '\1', '8', '\1', '8', '\0', '8', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '8', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\1', '8', '\uFFFF', '8', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0647()
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
//  public void testItem_0648()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1.00000")).hashCode();
//    Assert.assertEquals(-3099995, rc_int);
//  }
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
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("-1.00000")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-0.100000", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_int = (new BigDecimal("-32")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0653()
  {
    rc_long = (new BigDecimal("-32")).longValueExact();
    Assert.assertEquals(-32L, rc_long);
  }
  public void testItem_0654()
  {
    rc_String = (new BigDecimal("-0.100000")).toString();
    Assert.assertEquals("-0.100000", rc_String);
  }
  public void testItem_0655()
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
  public void testItem_0656()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("-0.100000")).add(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).multiply(new BigDecimal("3E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1.8E+3", rc_BigDecimal.toString());
  }
  public void testItem_0659()
  {
    rc_BigDecimal = (new BigDecimal("1.8E+3")).movePointLeft(0);
    if (JavaSpecVersionChecker.isJDKWithin13And19()) {
    	Assert.assertEquals("1.8E+3", rc_BigDecimal.toString());
    } else {
    	Assert.assertEquals("1800", rc_BigDecimal.toString());
    }
  }
  public void testItem_0660()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("-0.100000"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0661()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '8', '\1', '8', '\uFFFF', '\1', '8', '\1', '\234', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\0', '\1', '8', '\234', '\1', '\0', '8', '\uFFFF', '8', '\0', '\uFFFF', '8', '\0', '\0', '8', '\0', '\1', '\0', '\1', '8', '\1', '\0', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\234', '\1', '8', '\0', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\0', '8', '\1', '\0', '8', '\1', '\234', '8', '\1', '\234', '\0', '\0', '8', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0662()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0663()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("0.00000"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0664()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0665()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("1.8E+3"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0667()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0668()
  {
    rc_BigDecimal = (new BigDecimal("1.8E+3")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+3", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).stripTrailingZeros();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_int = (new BigDecimal("3E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("3E+1"));
    Assert.assertEquals("9.6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_int = (new BigDecimal("3E+1")).intValue();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0675()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\234', '\1', '\234', '\uFFFF', '\234', '\234', '\0', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '8', '\0', '\0', '\1', '\1', '\uFFFF', '8', '\234', '\0', '\234', '8', '8', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\0', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\1', '\0', '\1', '\1', '8', '\0', '\234', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\234', '\234', '\234', '\0', '\1', '\234', '8', '\0', '\1', '\1', '8', '\234', '\1', '\234', '\234', '8', '\234', '\0', '8', '8', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\234', '\0', '\1', '\1', '8', '\uFFFF', '\234', '\1', '8', '\0', '\0'}, 1, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0676()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\1', '\1', '\1', '\234', '\0', '\0', '\1', '\1', '\uFFFF', '\234', '\234', '8', '\0', '\0', '\uFFFF', '\0', '8', '\0', '\0', '\234', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\1', '\1', '\0', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '8', '\1', '\234'}, -2147483648, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0677()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0678()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0681()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0682()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0683()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("9.6E+2"), java.math.RoundingMode.UP);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0684()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("UU4BN2?@99YHAFG1U>BJB464RVC:=H7J9H:AUP7F:72C02BC3B45RN@<JRP:Y@3OIW:HPJALC37DRJ9K9EQX4R;DN?7429KBGTNM");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0685()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0686()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("9.6E+2"), 2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0687()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("KJL5E?2K;L2NJ>RW33PB?");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0688()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("1E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0690()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("1E+1"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0691()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0692()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0693()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9.6E+2")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0694()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).max(new BigDecimal("1E+1"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("9.6E+2"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0698()
  {
    rc_BigDecimal_array = (new BigDecimal("9.6E+2")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0699()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0700()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).negate();
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0704()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0705()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0706()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@3?07?YOQG=NVE1P;>:GRYNLC5S@F@OFQOG2475AYAMANQ=8I2F?6GF59EUHQOX@BN948=AN9M0?IS1O;4AVA>OA?QH");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("QBKKT5U06<FDRR97D7VG30<E9U>A9PQXLQ7NY;D8Q2JVLE6I@LTLK1VBJII>58LQEF=1UH::T9IPB7LGXH<ACD>A;UE8FITQYJ;?");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0711()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0714()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("5E-324"));
    Assert.assertEquals("2E+324", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3.2"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0717()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).remainder(new BigDecimal("2E+324"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("5E-324")).ulp();
    Assert.assertEquals("1E-324", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("5E-324")).setScale(0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0720()
  {
    rc_BigDecimal = (new BigDecimal("5E-324")).ulp();
    Assert.assertEquals("1E-324", rc_BigDecimal.toString());
  }
  public void testItem_0721()
  {
    rc_BigDecimal = (new BigDecimal("1E-324")).plus();
    Assert.assertEquals("1E-324", rc_BigDecimal.toString());
  }
  public void testItem_0722()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0723()
  {
    rc_String = (new BigDecimal("1E+1")).toPlainString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0724()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '8', '\1', '\1', '\1', '\uFFFF', '\1', '\0', '8', '\0', '8', '\uFFFF', '\234', '8', '\0', '\0', '\234', '\0', '8', '8', '\234', '\0', '\1', '\1', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\1', '\0', '\1', '\0', '\234', '\uFFFF', '8', '\234', '\0', '\1', '\1', '8', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\0', '\0', '\1', '\234', '8', '\1', '\uFFFF', '8', '\1', '\1', '8', '\0', '\1', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0725()
  {
    rc_BigDecimal_array = (new BigDecimal("1E-324")).divideAndRemainder(new BigDecimal("1E+1"));
  }
  public void testItem_0726()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+324")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0727()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\1', '\0', '\234', '\1', '\1', '\0', '\0', '\234', '8', '\uFFFF', '\0', '\234', '\0', '\0', '\uFFFF', '\1', '\1', '8', '8', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\0', '\1', '8', '8', '\234', '\uFFFF', '\1', '\0', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '8', '8', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\1', '\0', '\uFFFF', '\234', '\234', '\1', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\0', '\234', '\1', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("3"), 0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    rc_BigInteger = (new BigDecimal("3")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0731()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0732()
  {
    rc_String = (new BigDecimal("-3.2")).toEngineeringString();
    Assert.assertEquals("-3.2", rc_String);
  }
  public void testItem_0733()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0734()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("-3.2"));
    Assert.assertEquals("-3.125", rc_BigDecimal.toString());
  }
  public void testItem_0735()
  {
    rc_int = (new BigDecimal("1E-324")).intValue();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0736()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2")).divideToIntegralValue(new BigDecimal("-3.125"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0737()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0738()
  {
    rc_BigDecimal = (new BigDecimal("-3.125")).add(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("-3.124999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375", rc_BigDecimal.toString());
  }
  public void testItem_0739()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\1', '\234', '\1', '\1', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\0', '\0', '\1', '\uFFFF', '\1', '\1', '\234', '\234', '\0', '\0', '\uFFFF', '8', '\uFFFF', '8', '8', '8', '\234', '8', '\234', '\0', '8', '\234', '\0', '\234', '\0', '\0', '\0', '\1', '\0', '\1', '8', '\0', '\234', '\uFFFF', '8', '\0', '\1', '\234', '\1', '\1', '\0', '\1', '\1', '8', '\1', '\1', '\uFFFF', '8', '\234', '\1', '8', '8', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0741()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), 1);
    Assert.assertEquals("-647687210583393978727985109500535382558581279245254778742084345687777086617585110054273227844598798384598649165813798116447387959634539125974442879810363231748855757685012356366294104774698292291967256571112784219398423946959016635577930738077310580290592180839548062567466926768737608102996248027667220042584664771499183308.8", rc_BigDecimal.toString());
  }
  public void testItem_0742()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.124999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).divide(new BigDecimal("-647687210583393978727985109500535382558581279245254778742084345687777086617585110054273227844598798384598649165813798116447387959634539125974442879810363231748855757685012356366294104774698292291967256571112784219398423946959016635577930738077310580290592180839548062567466926768737608102996248027667220042584664771499183308.8"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0744()
  {
    rc_float = (new BigDecimal("1E+1")).floatValue();
    Assert.assertEquals(10.0F, rc_float, 0);
  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("-3.124999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).divideToIntegralValue(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-1075", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    rc_BigInteger = (new BigDecimal("-3.124999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).toBigInteger();
    Assert.assertEquals("-3", rc_BigInteger.toString());
  }
  public void testItem_0747()
  {
    rc_BigDecimal = (new BigDecimal("-647687210583393978727985109500535382558581279245254778742084345687777086617585110054273227844598798384598649165813798116447387959634539125974442879810363231748855757685012356366294104774698292291967256571112784219398423946959016635577930738077310580290592180839548062567466926768737608102996248027667220042584664771499183308.8")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-6E+323", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-647687210583393978727985109500535382558581279245254778742084345687777086617585110054273227844598798384598649165813798116447387959634539125974442879810363231748855757685012356366294104774698292291967256571112784219398423946959016635577930738077310580290592180839548062567466926768737608102996248027667220042584664771499183308.8")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0749()
  {
    rc_BigDecimal = (new BigDecimal("-6E+323")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-647687210583393978727985109500535382558581279245254778742084345687777086617585110054273227844598798384598649165813798116447387959634539125974442879810363231748855757685012356366294104774698292291967256571112784219398423946959016635577930738077310580290592180839548062567466926768737608102996248027667220042584664771499183308.8")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.124999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0753()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=1 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0754()
  {
    rc_BigDecimal = (new BigDecimal("-647687210583393978727985109500535382558581279245254778742084345687777086617585110054273227844598798384598649165813798116447387959634539125974442879810363231748855757685012356366294104774698292291967256571112784219398423946959016635577930738077310580290592180839548062567466926768737608102996248027667220042584664771499183308.8")).divide(new BigDecimal("-647687210583393978727985109500535382558581279245254778742084345687777086617585110054273227844598798384598649165813798116447387959634539125974442879810363231748855757685012356366294104774698292291967256571112784219398423946959016635577930738077310580290592180839548062567466926768737608102996248027667220042584664771499183308.8"), -1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0755()
  {
    rc_BigDecimal_array = (new BigDecimal("1E+1")).divideAndRemainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
  }
  public void testItem_0756()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    rc_BigInteger = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0758()
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
  public void testItem_0759()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0760()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0761()
  {
    rc_int = (new BigDecimal("1E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0762()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).negate();
    Assert.assertEquals("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\0', '\0', '\0', '8', '\1', '\1', '8', '\234', '8', '\0', '\1', '\1', '\uFFFF', '\0', '8', '8', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\1', '8', '\0', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\1', '\234', '\234', '\1', '8', '8', '\0', '\234', '\234', '\0', '\234', '\234', '\uFFFF', '8', '8', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\1', '8', '\1', '\1', '\1', '\1', '\234', '\1', '\1', '\0', '\1', '8', '\1', '\1', '\uFFFF', '8', '\234', '\1', '\1', '8', '\234', '\uFFFF', '\234', '8', '\0', '\0', '\1', '\1', '\234'}, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+323", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0767()
  {
    rc_BigInteger = (new BigDecimal("-647687210583393978727985109500535382558581279245254778742084345687777086617585110054273227844598798384598649165813798116447387959634539125974442879810363231748855757685012356366294104774698292291967256571112784219398423946959016635577930738077310580290592180839548062567466926768737608102996248027667220042584664771499183308.8")).unscaledValue();
    Assert.assertEquals("-6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088", rc_BigInteger.toString());
  }
  public void testItem_0768()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toEngineeringString();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_String);
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).negate();
    Assert.assertEquals("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).ulp();
    Assert.assertEquals("1E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0771()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-1074")).divide(new BigDecimal("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), -2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0772()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0773()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-1074")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0774()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0775()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).subtract(new BigDecimal("2E+323"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+323", rc_BigDecimal.toString());
  }
//  public void testItem_0777()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("2E+323")).divideAndRemainder(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0778()
  {
    rc_double = (new BigDecimal("-2E+323")).doubleValue();
    Assert.assertEquals(java.lang.Double.NEGATIVE_INFINITY, rc_double, 0);
  }
  public void testItem_0779()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("1E-1074"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0780()
  {
    rc_String = (new BigDecimal("2E+323")).toPlainString();
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_String);
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).add(new BigDecimal("-2E+323"));
    Assert.assertEquals("-200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0783()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0786()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0787()
  {
    rc_String = (new BigDecimal("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toPlainString();
    Assert.assertEquals("-0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_String);
  }
  public void testItem_0788()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0789()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0790()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("I;MFCV5X0G91WI9HE7Y7>?6E=P40A2U9;WIYDN3WAC<T>E1F?7A39<C3E0GUIC1O?VJGC?");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0791()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+323", rc_BigDecimal.toString());
  }
  public void testItem_0792()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("2E+323")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0793()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_int = (new BigDecimal("2E+323")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0796()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("2E+323")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0E+323", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2E+323")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0799()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0800()
  {
    rc_String = (new BigDecimal("2E+323")).toString();
    Assert.assertEquals("2E+323", rc_String);
  }
  public void testItem_0801()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0802()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("2E+323"));
  }
  public void testItem_0803()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("2E+323")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0804()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0805()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\uFFFF', '8', '8', '\1', '8', '\1', '\uFFFF', '\uFFFF', '8', '8', '8', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\234', '\uFFFF', '\1', '\1', '\234', '\1', '8', '\234', '\0', '\234', '\1', '8', '8', '\1', '8', '8', '\uFFFF', '\0', '\0', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '\234', '\1', '\0', '\0', '\1', '\0', '\234', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\0', '\234', '\0', '8', '\1', '\1', '\uFFFF', '\0', '\1', '\234', '\1', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\0', '\1', '\0', '\uFFFF', '\234', '\0', '\1', '\1', '\0', '\234', '8', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\234', '8', '\0', '\234', '\1', '\234', '\0'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("2E+323")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+323", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_BigDecimal = (new BigDecimal("-2E+323")).movePointRight(-1);
    Assert.assertEquals("-20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("2E+323")).abs();
    Assert.assertEquals("2E+323", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_BigInteger = (new BigDecimal("2E+323")).toBigIntegerExact();
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0811()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0812()
  {
    rc_BigDecimal = (new BigDecimal("-2E+323")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("-200000000000000179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    rc_BigDecimal = (new BigDecimal("-200000000000000179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("-20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("-2E+323")).abs();
    Assert.assertEquals("2E+323", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_int = (new BigDecimal("10")).intValueExact();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0816()
  {
    rc_BigDecimal = (new BigDecimal("10")).divideToIntegralValue(new BigDecimal("-2E+323"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-323", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    rc_BigDecimal = (new BigDecimal("-20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).remainder(new BigDecimal("10"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(2147483647);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0819()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0820()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+323")).pow(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0821()
  {
    rc_long = (new BigDecimal("-20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0822()
  {
    rc_double = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).doubleValue();
    Assert.assertEquals(1.7976931348623157E308, rc_double, 0);
  }
  public void testItem_0823()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, 0);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    rc_BigDecimal = (new BigDecimal("-2E+323")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+323", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0826()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0E-323"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0827()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0828()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0829()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0831()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0E-323"));
    Assert.assertEquals("0E-323", rc_BigDecimal.toString());
  }
  public void testItem_0832()
  {
    rc_BigDecimal = (new BigDecimal("0E-323")).plus();
    Assert.assertEquals("0E-323", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0834()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0835()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-323")).divide(new BigDecimal("0E-323"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("-2E+323")).pow(1);
    Assert.assertEquals("-2E+323", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_int = (new BigDecimal("-2E+323")).compareTo(new BigDecimal("0E-323"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0838()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+323")).divide(new BigDecimal("0"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0839()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0840()
  {
    rc_BigDecimal = (new BigDecimal("0E-323")).negate();
    Assert.assertEquals("0E-323", rc_BigDecimal.toString());
  }
  public void testItem_0841()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-2E+323"));
  }
  public void testItem_0842()
  {
    rc_BigDecimal = (new BigDecimal("-2E+323")).multiply(new BigDecimal("0E-323"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0843()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0845()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-2E+323")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0847()
  {
    rc_String = (new BigDecimal("-2E+323")).toEngineeringString();
    Assert.assertEquals("-200E+321", rc_String);
  }
  public void testItem_0848()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-2E+323"), new MathContext("precision=1 roundingMode=DOWN"));
  }
  public void testItem_0849()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointRight(-1);
    Assert.assertEquals("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0852()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0853()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0854()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0855()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).plus();
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0856()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_String = (new BigDecimal("3.2")).toEngineeringString();
    Assert.assertEquals("3.2", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0859()
  {
    rc_boolean = (new BigDecimal("3.2")).equals("1@0FS<0;9?3=G3;:C<@X@EEI1O@GNGNE<?JQJTU2KDY0XBHQ@6Q0O5VGYY897G3I9UWLU8G5JA4JP2>JNK7S4O39N0P0WD?=4AD<");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0860()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3.2"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0861()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, 1);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0862()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0863()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+9")).divideToIntegralValue(new BigDecimal("00.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0864()
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
  public void testItem_0865()
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
  public void testItem_0866()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate();
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0868()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).abs();
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    rc_int = (new BigDecimal("-3.2")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0870()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '8', '8', '\1', '\1', '\uFFFF', '\1', '\0', '\0', '8', '\uFFFF', '\1', '\uFFFF', '8', '\1', '8', '\234', '8', '\0', '8', '\uFFFF', '8', '\1', '\1', '8', '8', '\uFFFF', '8', '8', '\234', '\1', '8', '8', '\1', '\234', '\234', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\234', '\234', '\0', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '8', '8', '\1', '\234', '8', '\1', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '8', '\uFFFF', '\1', '\234', '8'}, 1, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0871()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\1', '8', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\0', '\0', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\234', '\1', '\1', '8', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\1', '8', '\234', '\0', '8', '8', '8', '\1', '8', '\0', '\uFFFF', '\0', '\234', '8', '\234', '\1', '8', '\uFFFF', '8', '\1', '\234', '8', '\234', '8', '\234', '\1', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '8', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\0', '\0', '\0', '\1', '8', '\0', '\1', '8', '\1', '8'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0872()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+9")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0873()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0875()
  {
    rc_float = (new BigDecimal("-3.2")).floatValue();
    Assert.assertEquals(-3.200000047683716F, rc_float, 0);
  }
  public void testItem_0876()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0877()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("2E+9"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1999999999", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).plus();
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2E+9")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0880()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0881()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0882()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0883()
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
  public void testItem_0884()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0886()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+9")).pow(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0887()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\1', '\0', '8', '8', '\1', '\1', '\0', '\1', '\1', '\0', '\1', '\0', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\0', '\1', '\0', '\0', '8', '\1', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '8', '8', '\0', '\234', '\234', '\1', '8', '\1', '\1', '8', '\1', '\234', '\1', '\1', '\0', '8', '\234', '\0', '\uFFFF', '\1', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0890()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0892()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0897()
  {
    rc_BigDecimal = (new BigDecimal("2")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0898()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0899()
  {
    rc_BigDecimal = (new BigDecimal("2")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0901()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\234', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\0', '8', '\uFFFF', '\1', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '8', '\1', '\234', '\234', '\0', '\0', '\1', '\0', '\1', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\0', '\0', '8', '8', '\1', '\1', '\234', '\234', '\1', '\0', '\0', '\234', '\0', '\234', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\234', '\0', '\1', '\234', '\0', '\234', '\0', '\1', '\234', '\1', '\uFFFF', '\234', '\234', '8', '\1', '\0', '\0', '\234', '8', '\1', '\1', '\0', '\1', '8', '\0', '\0', '\234'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0902()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0903()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\234', '\1', '\1', '\0', '\1', '\uFFFF', '8', '8'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0904()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\1', '\0', '8', '\234', '\1', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\1', '\0', '8', '8', '\uFFFF', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0906()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0907()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0908()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("NFGC9OGL0XFGW@8Q055KJ78X63K@V=BJ>BQ;YWYMYA8UO;ANQ><2DLY9P;7V4=2S?3<6<NAFFQ=KV@UUYXRICUFU7ALNR3DFT=9M", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0910()
  {
    rc_int = (new BigDecimal("9223372036854775808")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775808")).multiply(new BigDecimal("9223372036854775807"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("85070591730234615856620279821087277056", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_BigDecimal = (new BigDecimal("85070591730234615856620279821087277056")).multiply(new BigDecimal("1"));
    Assert.assertEquals("85070591730234615856620279821087277056", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("85070591730234615856620279821087277056"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-8E+37", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775808")).abs(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0916()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-8E+37")).scaleByPowerOfTen(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0917()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("C2<?<?13P@GDO11HFWRU?93MYLJ?4IHO;U;7P3@;BQXPDD@DP89@Q>M6A7J=Y?CEPP9CL;SW15?>SL1");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0918()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("-8E+37")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0E+37", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0923()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("0E+37")).movePointRight(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0E+37"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+37", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("X4UL0DI04MACD;6;RMYGD>?U=D?>YX:8O55VL@USRFR2V2BFTP>M>VFSS5", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0927()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0928()
  {
    rc_BigDecimal = (new BigDecimal("0E+37")).divide(new BigDecimal("32"), 0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0929()
  {
    rc_BigDecimal = (new BigDecimal("0E+37")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0930()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0933()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+37")).divide(new BigDecimal("0E+37"), 1, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0935()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0936()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("0E+37")).longValueExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0937()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0938()
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
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("0E+37")).round(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E+37", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    rc_BigDecimal = (new BigDecimal("0E+37")).plus();
    Assert.assertEquals("0E+37", rc_BigDecimal.toString());
  }
  public void testItem_0942()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '\1', '\234', '8', '\0', '\0', '\1', '\0', '8', '\0', '\234', '\1', '\1', '8', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\234', '\1', '\234', '\234', '\0', '\1', '\234', '\234', '8', '8', '8', '\0', '8', '\1', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\234', '\234', '8', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\1', '\0', '\0', '\1', '\1', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0943()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E+37"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0945()
  {
    rc_int = (new BigDecimal("0E+37")).signum();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0946()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0947()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+37")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0948()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0951()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0952()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0953()
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
  public void testItem_0954()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).round(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0955()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, 0);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0957()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0958()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0960()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0961()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0965()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0967()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("3E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("3E-2147483646"), 1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).negate();
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0971()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).negate();
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483646")).divide(new BigDecimal("0"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0973()
  {
    rc_int = (new BigDecimal("1.0")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0974()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0975()
  {
    rc_int = (new BigDecimal("3E-2147483646")).scale();
    Assert.assertEquals(2147483646, rc_int);
  }
  public void testItem_0976()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).min(new BigDecimal("1.0"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("3E-2147483646"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0979()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1.0E+2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0980()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.0")).divideToIntegralValue(new BigDecimal("-3E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0981()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1.0E+2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0982()
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
  public void testItem_0983()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("1.0E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0984()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0E+2147483647")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0985()
  {
    rc_BigDecimal = (new BigDecimal("1.0E+2147483647")).divideToIntegralValue(new BigDecimal("1.0E+2147483647"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0986()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("1OYJ3VJ7YELYIMC5W?CLIHELBNFW@EYS8<=GN4F9B=TF01M1HELL;TED1?P:E1OHOV=8", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0987()
  {
    rc_BigInteger = (new BigDecimal("-3E-2147483646")).unscaledValue();
    Assert.assertEquals("-3", rc_BigInteger.toString());
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0989()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-3E-2147483646")).divideAndRemainder(new BigDecimal("1.0E+2147483647"), new MathContext("precision=1 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("1.0E+2147483647")).remainder(new BigDecimal("1.0E+2147483647"));
    Assert.assertEquals("0E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\uFFFF', '\1', '\234', '\1', '\0', '8', '\0', '\0', '\0', '8', '8', '\1', '\234', '\0', '\uFFFF', '\1', '8', '\0', '\uFFFF', '8', '\1', '\0', '\234', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '8', '8', '8', '\0', '\0', '\1', '8', '\0', '\1', '8', '\0', '8', '\uFFFF', '\234', '\1', '8', '\0', '\1', '\uFFFF', '8', '\0', '\uFFFF', '8', '\0', '\1', '\0', '\0', '\234', '\0', '\0', '\0', '\234', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\0', '\1', '\0', '\1', '\234', '\234', '\1', '\234', '8', '8', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\234', '\0', '\1', '\234', '\234', '8', '8', '\1', '\1', '\0', '\uFFFF', '\1'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0992()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0993()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483646")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0994()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483646")).divide(new BigDecimal("1"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0995()
  {
    rc_long = (new BigDecimal("0E+2147483646")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-3E-2147483646"));
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0998()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("0E+2147483646")).longValueExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0999()
  {
    rc_int = (new BigDecimal("-3E-2147483646")).signum();
    Assert.assertEquals(-1, rc_int);
  }
}
