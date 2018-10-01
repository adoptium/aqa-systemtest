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
public class TestSuite052 extends TestCase
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
  
  public TestSuite052() {
	
  }
  public void testItem_0000()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0001()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0002()
  {
    rc_int = (new BigDecimal("0.00")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0003()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\uFFFF', '\1', '\234', '8', '\1', '8', '\0', '\0', '\1', '8', '\uFFFF', '\234', '\234', '\0', '\1', '8', '\234', '\1', '8', '\0', '\234', '8', '\uFFFF', '8', '\234', '\234', '\0'}, 0, -2147483648, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0004()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0005()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483645")).negate();
    Assert.assertEquals("0E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483645")).negate();
    Assert.assertEquals("0E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0009()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+2147483645")).divideToIntegralValue(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0010()
  {
    rc_BigInteger = (new BigDecimal("0E+2147483645")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0011()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E-2147483647"), java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0012()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0E+2147483645"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0013()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_BigInteger = (new BigDecimal("0E+2147483645")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0015()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0016()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+2147483645")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0017()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(">5UQ<SY=FMEC9");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0018()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).min(new BigDecimal("0E+2147483645"));
    Assert.assertEquals("0E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483645")).setScale(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0022()
  {
    rc_boolean = (new BigDecimal("3.2")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0023()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).remainder(new BigDecimal("0E+2147483645"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0024()
  {
    rc_int = (new BigDecimal("0E+2147483645")).compareTo(new BigDecimal("0E+2147483645"));
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0025()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E+2147483645"), java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0026()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0027()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0028()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483645")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0E+2147483645", rc_BigDecimal.toString());
  }
//  public void testItem_0029()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("0E+2147483645")).intValueExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0030()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0031()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483645")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483645")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E+2147483645"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0034()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '8', '\1', '\uFFFF', '\234', '8', '\uFFFF', '8', '\0', '\1', '8', '\uFFFF', '\0', '\uFFFF', '8', '8', '\uFFFF', '\0', '\1', '8', '\1', '\1', '\0', '\1', '\uFFFF', '\1', '\0', '\234', '8', '\0', '\234', '\0', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\0', '\234', '\0', '\234', '8', '\uFFFF', '\0', '\1', '\1', '\1', '8', '\0', '\0', '\1', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\0', '8', '\1', '\234', '8', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\1', '\0', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '8', '8', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\234', '8'}, 1, 2147483647, new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0035()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0036()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+2147483645")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483646")).plus();
    Assert.assertEquals("0E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483645")).max(new BigDecimal("0E+2147483646"));
    Assert.assertEquals("0E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0039()
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
  public void testItem_0040()
  {
    rc_String = (new BigDecimal("0E+2147483645")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0041()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0042()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_byte = (new BigDecimal("0E+2147483645")).byteValueExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0043()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0044()
  {
    rc_String = (new BigDecimal("0E+2147483645")).toString();
    Assert.assertEquals("0E+2147483645", rc_String);
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0046()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("0E+2147483645")).intValueExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0047()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483645")).negate();
    Assert.assertEquals("0E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\234', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\0', '8', '\1', '\0', '\1', '\0', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\234', '\0', '\1', '\234', '\234', '\1', '\uFFFF', '\234', '\234', '\0', '\0', '\234', '\234', '8', '\0', '\234', '8', '\0', '\1', '8', '8', '\0', '\uFFFF', '\0', '8', '\234', '\234', '8', '\234', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '8', '\1', '8', '8', '\1', '\1', '\234', '8', '\uFFFF', '8', '\1', '\0', '8', '\0', '\1', '\234', '\234', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0050()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0E+2147483645"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0051()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0052()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0053()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0054()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).plus();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0055()
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
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0058()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0059()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0060()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0061()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0062()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\234', '\0', '\234', '\1', '8', '\234', '\0', '\1', '\uFFFF', '8', '\0', '\1', '8', '\0', '\1', '\1', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\1', '\0', '\0', '8', '\1', '\0', '\1', '\1', '\1', '\0', '\234', '8', '\0', '\uFFFF', '\234', '\1', '\0', '\1', '\0', '8', '\1', '8', '\uFFFF', '8', '8', '8', '\0', '\234', '\0', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\0', '\0', '\234', '\1', '\0', '\0', '\234', '8', '8', '8', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\234', '8', '\234', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\uFFFF', '8', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0064()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483645")).plus(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0065()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0066()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0067()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_short = (new BigDecimal("0E+2147483645")).shortValueExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0068()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0069()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("8@O1DL283");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0070()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0071()
  {
    rc_String = (new BigDecimal("3.2E+2")).toString();
    Assert.assertEquals("3.2E+2", rc_String);
  }
  public void testItem_0072()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).add(new BigDecimal("0E+2147483645"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("TII6M@UI81KI398=@DC:LUB=T9J3JHN?Y6KAR;P;LX8GFW:QQCB4H>E8=63LDLU<;1BH<@<DTI0O<WV5VOK3T=GCD=BYI;=FXSSF", new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(-1, 1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    rc_int = (new BigDecimal("1135879015891")).precision();
    Assert.assertEquals(13, rc_int);
  }
  public void testItem_0078()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '8', '\234', '\0', '\0', '\234', '\0', '8', '\uFFFF', '\234', '\0', '\0', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '8', '8', '8', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\1', '\234', '\234', '8', '\0', '\234', '\234', '\1', '\1', '\234', '\1', '\uFFFF', '8', '8', '\1', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '8', '8', '\234', '\1', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '8', '\1', '8', '\uFFFF', '\1', '\0', '\0', '\234', '\uFFFF', '\0', '\234', '\1', '\0', '\234', '\0', '\uFFFF', '\0', '8', '8', '\0', '8', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0079()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+2147483645")).divideAndRemainder(new BigDecimal("1135879015891"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
  }
  public void testItem_0080()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("AJMFUY2PEJ<UNR6@BIOT3URB6CDGLC5>LTH?RCOE05YHQ@=FD7TS>PE@:<LCYY1HI?@NHAEEUNQYA<V>V25FIJERF9VBO6");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0081()
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
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(1);
    Assert.assertEquals("320.0", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("IHW3TKH5V7S<D>7DUFQEMB6IRS2;N?HTU?J320MBWR8FF2SU3F8VU364EYTWTRTD4", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0084()
  {
    rc_int = (new BigDecimal("1135879015891")).intValue();
    Assert.assertEquals(2007649747, rc_int);
  }
  public void testItem_0085()
  {
    rc_int = (new BigDecimal("3.2E+2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0086()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).round(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0089()
  {
    rc_String = (new BigDecimal("3.2E+2")).toPlainString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0090()
  {
    rc_BigInteger = (new BigDecimal("1135879015891")).toBigInteger();
    Assert.assertEquals("1135879015891", rc_BigInteger.toString());
  }
  public void testItem_0091()
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
  public void testItem_0092()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0093()
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
  public void testItem_0094()
  {
    rc_String = (new BigDecimal("5E-324")).toEngineeringString();
    Assert.assertEquals("5E-324", rc_String);
  }
//  public void testItem_0095()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E-2147483646")).hashCode();
//    Assert.assertEquals(-2147482657, rc_int);
//  }
  public void testItem_0096()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).add(new BigDecimal("3.2E+2"));
    Assert.assertEquals("6.4E+2", rc_BigDecimal.toString());
  }
  public void testItem_0097()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("1135879015891"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0098()
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
  public void testItem_0099()
  {
    rc_int = (new BigDecimal("5E-324")).scale();
    Assert.assertEquals(324, rc_int);
  }
  public void testItem_0100()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '8', '\0', '8', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\234', '\0', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\1', '\234', '8', '8', '\uFFFF', '\0', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\1', '\1', '\234', '8', '\0', '\1', '\0', '\234', '8', '\0', '\234', '\234', '\uFFFF', '8', '\234', '\234', '8', '\1', '\234', '\234', '8', '\0', '\uFFFF', '8', '\0', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '8', '8', '8', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\0', '\234', '\0', '8', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\0', '\1', '\234', '\0', '\234', '\0', '\1', '8', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0101()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    rc_String = (new BigDecimal("1135879015891")).toPlainString();
    Assert.assertEquals("1135879015891", rc_String);
  }
  public void testItem_0103()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("I>12W6J<TQBM106B62YXGVFMNXNGY58Q=N;PBF8EP9D@V@A;R<RU0Y==G@@BMN?8EWPLA>=C;Q5G0E<?H");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0104()
  {
    rc_String = (new BigDecimal("5E-324")).toPlainString();
    Assert.assertEquals("0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005", rc_String);
  }
  public void testItem_0105()
  {
    rc_String = (new BigDecimal("1135879015891")).toString();
    Assert.assertEquals("1135879015891", rc_String);
  }
  public void testItem_0106()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    rc_String = (new BigDecimal("5E-324")).toString();
    Assert.assertEquals("5E-324", rc_String);
  }
  public void testItem_0108()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).movePointLeft(2147483647);
    Assert.assertEquals("3.2E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483645")).movePointLeft(-2147483648);
    Assert.assertEquals("3200", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483645")).divide(new BigDecimal("5E-324"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("5E-324")).add(new BigDecimal("1135879015891"));
    Assert.assertEquals("1135879015891.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("5E-324")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0116()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483645")).negate();
    Assert.assertEquals("0E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\0', '\234', '\1', '\1', '\1', '8', '\1', '8', '\0', '\uFFFF', '\234', '\1', '8', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\0', '\1', '8', '\0', '\0', '\0', '\1', '\234', '\uFFFF', '\1', '8', '\uFFFF', '8', '8', '\234', '\234', '\1', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\0', '8', '8', '\0', '\234', '\1', '\0', '\uFFFF', '\1', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\1', '8', '8', '\0', '8', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\0', '8', '\1', '\1', '\1', '\0', '8', '\0', '8', '\1', '\0', '\1', '\234', '\0', '\uFFFF', '\1', '\234', '8', '8'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0118()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+2147483645")).divideToIntegralValue(new BigDecimal("0E+2147483645"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0119()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("1HNFXFR6FDS5O=Q;FY4C:MCFHKTJAP@YH6OV<CED;24QJYBL3TEOOQ29EH:9TY;48LH9QS3G>;L4MTK<636USQO4H??1XXE0M2@D");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0120()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("0E+2147483645"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0121()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("VQ1Q@U3NY5L?LUE3XD");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483645")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483645")).plus(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483645")).add(new BigDecimal("0E+2147483645"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0125()
  {
    rc_int = (new BigDecimal("1135879015891")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0126()
  {
    rc_String = (new BigDecimal("1135879015891")).toEngineeringString();
    Assert.assertEquals("1135879015891", rc_String);
  }
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).abs();
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("1135879015891"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483645")).ulp();
    Assert.assertEquals("1E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).movePointLeft(2147483647);
    Assert.assertEquals("1.135879015891E-2147483635", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0132()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0134()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0135()
  {
    rc_double = (new BigDecimal("1135879015891")).doubleValue();
    Assert.assertEquals(1.135879015891E12, rc_double, 0);
  }
  public void testItem_0136()
  {
    rc_int = (new BigDecimal("1135879015891")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0137()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).max(new BigDecimal("1.135879015891E-2147483635"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).negate();
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("1.135879015891E-2147483635", rc_BigDecimal.toString());
  }
//  public void testItem_0141()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("1.135879015891E-2147483635")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0142()
  {
    rc_int = (new BigDecimal("1.135879015891E-2147483635")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0143()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9223372036854775807")).hashCode();
//    Assert.assertEquals(2147482656, rc_int);
//  }
  public void testItem_0144()
  {
    rc_BigDecimal_array = (new BigDecimal("1.135879015891E-2147483635")).divideAndRemainder(new BigDecimal("1E+2147483645"));
  }
  public void testItem_0145()
  {
    rc_int = (new BigDecimal("1E+2147483645")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0146()
  {
    rc_float = (new BigDecimal("9223372036854775807")).floatValue();
    Assert.assertEquals(9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0147()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1E+2147483645")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483645")).scaleByPowerOfTen(-1);
    Assert.assertEquals("1E+2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("1E+2147483645")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0150()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("1E+2147483644"), java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0151()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("DFG=VIR14ANBA");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0153()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483645")).abs();
    Assert.assertEquals("1E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).remainder(new BigDecimal("1"));
    Assert.assertEquals("1.135879015891E-2147483635", rc_BigDecimal.toString());
  }
//  public void testItem_0155()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0156()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483644")).abs();
    Assert.assertEquals("1E+2147483644", rc_BigDecimal.toString());
  }
//  public void testItem_0157()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483644")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0158()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483644")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0159()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\1', '\234', '\234', '\0', '\234', '\234', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\1', '\1', '\1', '8', '\0', '\234', '\0', '8', '\234', '\uFFFF', '\234', '\0', '\234', '\1', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\234', '\0', '\0', '8', '\1', '\234', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\234'}, 0, -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0161()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1.135879015891E-2147483635"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).stripTrailingZeros();
    Assert.assertEquals("1.135879015891E-2147483635", rc_BigDecimal.toString());
  }
//  public void testItem_0163()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1E+2147483644")).hashCode();
//    Assert.assertEquals(-2147483613, rc_int);
//  }
//  public void testItem_0164()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1.135879015891E-2147483635")).hashCode();
//    Assert.assertEquals(-39629932, rc_int);
//  }
  public void testItem_0165()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).divide(new BigDecimal("1E+2147483644"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483645")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1E+2147483645", rc_BigDecimal.toString());
  }
//  public void testItem_0167()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483644")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0168()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).divide(new BigDecimal("1.135879015891E-2147483635"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0170()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0171()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483645")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1E+2147483645"));
    Assert.assertEquals("1E+2147483645", rc_BigDecimal.toString());
  }
//  public void testItem_0173()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("1.135879015891E-2147483635"), -2147483648, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0174()
  {
    rc_float = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0175()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("SU0U@>3IX3XK7WLYTG4KLE3=@X;:Q8V=:5K3I7IRDOJ7@KI5");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0178()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0181()
  {
    rc_BigDecimal_array = (new BigDecimal("1E+2147483645")).divideAndRemainder(new BigDecimal("1E+2147483645"));
  }
  public void testItem_0182()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0183()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0184()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\uFFFF', '\1', '\uFFFF', '8', '8', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\1', '8', '\1', '\234', '8', '\uFFFF', '\234', '\0', '\234', '\1', '\0', '8', '\234', '8', '\0', '\uFFFF', '\1', '\1', '\234', '\234', '\234', '\1', '\234', '\234', '8', '\1', '\1', '8', '\1', '8', '\0', '\234', '\0', '\234', '8', '\uFFFF', '\1', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '8', '8', '\0', '\uFFFF', '\1', '8', '\0', '\0', '\0', '8', '\234', '\uFFFF', '\234', '8', '8', '\1', '\0', '\234', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\0'}, 0, -1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0185()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0186()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0187()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).scale();
    Assert.assertEquals(1074, rc_int);
  }
  public void testItem_0188()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).plus();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("1"), 0, 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0192()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0193()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0195()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0198()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0201()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0202()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0206()
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
  public void testItem_0207()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1, 1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    rc_int = (new BigDecimal("2")).intValue();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0211()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1E+2147483645"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0213()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0214()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2"), 1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0.5", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("0.5")).plus();
    Assert.assertEquals("0.5", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0219()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0220()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0221()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0222()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.5")).divide(new BigDecimal("0.5"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0223()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0224()
  {
    rc_BigDecimal = (new BigDecimal("0.5")).add(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.5", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0226()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0227()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0228()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("32"));
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0232()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0233()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("PB<VBRSDV:9PK<S06CISHWX8XRS40@?2W=?0=6@R2CRW>7LHI@IA@JOD9Q0>O1MEIU8AI1X5EA0;");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0234()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0235()
  {
    rc_float = (new BigDecimal("32.0")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0236()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32.0")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0237()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0240()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0242()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0249()
  {
    rc_String = (new BigDecimal("32.0")).toString();
    Assert.assertEquals("32.0", rc_String);
  }
  public void testItem_0250()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).divide(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0251()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
//  public void testItem_0252()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("1"), -2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0253()
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
  public void testItem_0254()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0255()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("2147483647"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0257()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0259()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0260()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
  }
  public void testItem_0261()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0264()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).ulp();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0265()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0266()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0267()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1E+2147483647"), 1, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0268()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '\0', '\0', '8', '\0', '\0', '\uFFFF', '\234', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '8', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0269()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0270()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0271()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0272()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("5E-324")).negate();
    Assert.assertEquals("-5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("5E-324")).divide(new BigDecimal("5E-324"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0277()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("5E-324"));
    Assert.assertEquals("6.4E+323", rc_BigDecimal.toString());
  }
  public void testItem_0278()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0279()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0280()
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
  public void testItem_0281()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\1', '\1', '\uFFFF', '\0', '\234', '8', '\0', '\234', '\uFFFF', '\234', '\1', '\1', '\234', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\1', '\234', '\234', '\uFFFF', '\0', '8', '8', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '8'}, -2147483648, 1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0282()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).abs();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("5E-324"));
    Assert.assertEquals("6.4E+323", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("6.4E+323"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E-324", rc_BigDecimal.toString());
  }
  public void testItem_0285()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0286()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    rc_int = (new BigDecimal("3E+1")).compareTo(new BigDecimal("2E-324"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).max(new BigDecimal("1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("J0N>G1W:KS5IKQITQ9L;:8ED>1BVY?PSMJ6LIC=5GT?;;XW7HMCK3QH=ECLSWGE=7O@H5AMQ1;AI@N3NFNP?6=E?9GM28WQ?=;BQ");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0290()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E-324")).divide(new BigDecimal("2E-324"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0291()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_String = (new BigDecimal("1E+2147483647")).toPlainString();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0292()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483647")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0293()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0294()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0297()
  {
    rc_BigDecimal = (new BigDecimal("2E-324")).movePointRight(0);
    Assert.assertEquals("2E-324", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_int = (new BigDecimal("2E-324")).scale();
    Assert.assertEquals(324, rc_int);
  }
  public void testItem_0300()
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
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0303()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("2E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0304()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("2E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0305()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2E-324")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0306()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0307()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0308()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0310()
  {
    rc_boolean = (new BigDecimal("3E+1")).equals("P<?SJ?IC6>3K518F;BDM37P@");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("2E-324"));
    Assert.assertEquals("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_String = (new BigDecimal("2E-324")).toString();
    Assert.assertEquals("2E-324", rc_String);
  }
  public void testItem_0313()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0314()
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
  public void testItem_0315()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).min(new BigDecimal("32"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("3.2"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0317()
  {
    rc_String = (new BigDecimal("2E-324")).toString();
    Assert.assertEquals("2E-324", rc_String);
  }
  public void testItem_0318()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\uFFFF', '\1', '\1', '8', '\1', '\234', '\234', '\1', '\0', '\234', '8', '8', '\0', '\uFFFF', '8', '\1', '8', '\0', '\uFFFF', '8', '8', '\234', '\uFFFF', '\234', '\234', '8', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '\uFFFF', '\234', '\234', '8', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\234', '8', '8', '8', '\uFFFF', '8', '\1', '\1', '\234', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\1', '\234', '8', '\0', '8', '8', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0319()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0320()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0322()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).stripTrailingZeros();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).stripTrailingZeros();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0325()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0327()
  {
    rc_double = (new BigDecimal("3.2")).doubleValue();
    Assert.assertEquals(3.2, rc_double, 0);
  }
  public void testItem_0328()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3.2")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0329()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).min(new BigDecimal("3.2"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    rc_int = (new BigDecimal("3.2")).intValue();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).pow(1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0335()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("3.2"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0337()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0338()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).remainder(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0339()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("32"));
    Assert.assertEquals("35.2", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0341()
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
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    rc_long = (new BigDecimal("3")).longValueExact();
    Assert.assertEquals(3L, rc_long);
  }
  public void testItem_0344()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0345()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).movePointRight(-1);
    Assert.assertEquals("0.32", rc_BigDecimal.toString());
  }
//  public void testItem_0346()
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
  public void testItem_0347()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("32"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0351()
  {
    rc_int = (new BigDecimal("3.2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0352()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    rc_BigInteger = (new BigDecimal("3")).toBigInteger();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0355()
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
  public void testItem_0356()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0358()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    rc_BigDecimal = (new BigDecimal("3")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-29", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigInteger = (new BigDecimal("-29")).toBigIntegerExact();
    Assert.assertEquals("-29", rc_BigInteger.toString());
  }
  public void testItem_0361()
  {
    rc_BigDecimal = (new BigDecimal("3")).stripTrailingZeros();
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '8', '8', '\0', '\uFFFF', '\0', '\0', '8', '\1', '8', '8', '\234', '\234', '\234', '\234', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\0', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\234', '8', '\1', '\1'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0363()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0364()
  {
    rc_BigDecimal = (new BigDecimal("-29")).stripTrailingZeros();
    Assert.assertEquals("-29", rc_BigDecimal.toString());
  }
  public void testItem_0365()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).remainder(new BigDecimal("3"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0367()
  {
    rc_BigInteger = (new BigDecimal("3.2")).toBigInteger();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
//  public void testItem_0368()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0369()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_String = (new BigDecimal("3")).toString();
    Assert.assertEquals("3", rc_String);
  }
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_String = (new BigDecimal("5E-324")).toString();
    Assert.assertEquals("5E-324", rc_String);
  }
  public void testItem_0374()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369")).setScale(-1, 0);
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308", rc_BigDecimal.toString());
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).divide(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+307", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("3")).setScale(-1, 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).max(new BigDecimal("3"));
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).divide(new BigDecimal("-1"), -1, 0);
    Assert.assertEquals("-1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    rc_BigDecimal_array = (new BigDecimal("6E+307")).divideAndRemainder(new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0382()
  {
    rc_boolean = (new BigDecimal("-1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0383()
  {
    rc_String = (new BigDecimal("3")).toEngineeringString();
    Assert.assertEquals("3", rc_String);
  }
  public void testItem_0384()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("4.2", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    rc_long = (new BigDecimal("4.2")).longValue();
    Assert.assertEquals(4L, rc_long);
  }
  public void testItem_0386()
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
  public void testItem_0387()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_BigDecimal_array = (new BigDecimal("31")).divideAndRemainder(new BigDecimal("31"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0391()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0392()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("31")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0393()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\234', '\1', '\234', '\1', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0396()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0397()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0398()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("-2"));
    Assert.assertEquals("34", rc_BigDecimal.toString());
  }
  public void testItem_0399()
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
  public void testItem_0400()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0401()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).pow(-1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0402()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0403()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0404()
  {
    rc_int = (new BigDecimal("31")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0405()
  {
    rc_BigInteger = (new BigDecimal("-2")).toBigInteger();
    Assert.assertEquals("-2", rc_BigInteger.toString());
  }
  public void testItem_0406()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).setScale(-1, 2147483647);
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
      rc_BigDecimal = (new BigDecimal("-3E+1")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0410()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0411()
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
  public void testItem_0412()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0413()
  {
    rc_boolean = (new BigDecimal("0E+1")).equals("D>TTLL43=F1H=T<GATO=S6I=78S@DRQ1AFSSMO81:SN34L<L76J6:");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0414()
  {
    rc_String = (new BigDecimal("-2")).toString();
    Assert.assertEquals("-2", rc_String);
  }
  public void testItem_0415()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("EQ<BE4Y=T@@M::LLX6IO6TUNKN8SPPNXI5E1F>R=7WNL3:P?A;55ETSTIT@NHSE5=5XYXTH<D=TE@H0IA1ERW0V;HG9><T<3XJBG");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0417()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("31"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("31")).min(new BigDecimal("-3E+1"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_BigDecimal = (new BigDecimal("31")).divideToIntegralValue(new BigDecimal("-2"));
    Assert.assertEquals("-15", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divideToIntegralValue(new BigDecimal("-3E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0421()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).stripTrailingZeros();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("-15")).add(new BigDecimal("-15"));
    Assert.assertEquals("-30", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_BigInteger = (new BigDecimal("-15")).toBigIntegerExact();
    Assert.assertEquals("-15", rc_BigInteger.toString());
  }
  public void testItem_0424()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).pow(1);
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).setScale(2147483647, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0427()
  {
    rc_float = (new BigDecimal("-3E+1")).floatValue();
    Assert.assertEquals(-30.0F, rc_float, 0);
  }
  public void testItem_0428()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0429()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0430()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3FMCH8G7LXJ96K7;VJWP:JS@8K>DH1G586P8BN<?DSW=S1J8H;7OW>F7QG0MN@1B4VO2CKGU:5S1SF430WYEK:4BT36NNV>BTNHJ", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0431()
  {
    rc_BigDecimal = (new BigDecimal("-30")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("30", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0433()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0434()
  {
    rc_boolean = (new BigDecimal("-3E+1")).equals("FQR2DK;86QMEI?W3@1>423XB>FPF4ANJ>=43@O;:R:B=MXGOCSJ76=H9SU@L3CRXBNKDPVBC7<VD1M;WL71BBO404Y@4<23PVD=P");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0435()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-30")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0436()
  {
    rc_short = (new BigDecimal("-30")).shortValueExact();
    Assert.assertEquals(-30, rc_short);
  }
//  public void testItem_0437()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-30")).hashCode();
//    Assert.assertEquals(-930, rc_int);
//  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("0"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0440()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0444()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0445()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0446()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-30")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0447()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).abs();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0448()
  {
    rc_BigInteger = (new BigDecimal("-30")).toBigIntegerExact();
    Assert.assertEquals("-30", rc_BigInteger.toString());
  }
  public void testItem_0449()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).scaleByPowerOfTen(1);
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0450()
  {
    rc_String = (new BigDecimal("-3E+1")).toPlainString();
    Assert.assertEquals("-30", rc_String);
  }
  public void testItem_0451()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).setScale(2147483647, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0452()
  {
    rc_boolean = (new BigDecimal("-3E+1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0453()
  {
    rc_String = (new BigDecimal("-3E+1")).toPlainString();
    Assert.assertEquals("-30", rc_String);
  }
  public void testItem_0454()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).subtract(new BigDecimal("-3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0457()
  {
    rc_boolean = (new BigDecimal("1")).equals("?F05CPB46US8OUDJ60D19@1BDK6T9D2G>FJ<OO4>?5GYM2<6JWL2@=LS4@U19QN0DYI5ADF:GUPYGT:S13KIH@WVB8?:");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0458()
  {
    rc_int = (new BigDecimal("-3E+1")).intValue();
    Assert.assertEquals(-30, rc_int);
  }
  public void testItem_0459()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("ILVE3F@8X?R@=IH@1A1P:KMKU0HC?:DR:1P<3VREW489SG0CRXUP695I6OJQ<S4KB7G5I15KK?=V407FUX5:AF15SHCHAC2NWMB?");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0462()
  {
    rc_int = (new BigDecimal("1E+1")).intValue();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-29", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).multiply(new BigDecimal("-3E+1"));
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0465()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+2")).divide(new BigDecimal("0E+1"), 0, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0466()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0467()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=2147483647 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0468()
  {
    rc_double = (new BigDecimal("3E+1")).doubleValue();
    Assert.assertEquals(30.0, rc_double, 0);
  }
  public void testItem_0469()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0470()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).divide(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0471()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0473()
  {
    rc_float = (new BigDecimal("3E+1")).floatValue();
    Assert.assertEquals(30.0F, rc_float, 0);
  }
  public void testItem_0474()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(":;1HT>?D4TIPVJ81XS966EL7ET0M@VJ6H:8WFF2AJ4GG8C;WBQG2OF9H5B?UDM551YBDS>;DPI1H6");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).movePointRight(-1);
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_String = (new BigDecimal("3E+1")).toPlainString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0477()
  {
    rc_String = (new BigDecimal("3E+1")).toPlainString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0478()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0479()
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
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).multiply(new BigDecimal("3E+1"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    rc_BigDecimal = (new BigDecimal("-3")).divideToIntegralValue(new BigDecimal("-3E+2"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0482()
  {
    rc_BigInteger = (new BigDecimal("3E+2")).toBigIntegerExact();
    Assert.assertEquals("300", rc_BigInteger.toString());
  }
  public void testItem_0483()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0484()
  {
    rc_short = (new BigDecimal("0.00")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0485()
  {
    rc_String = (new BigDecimal("0.00")).toString();
    Assert.assertEquals("0.00", rc_String);
  }
  public void testItem_0486()
  {
    rc_float = (new BigDecimal("3E+2")).floatValue();
    Assert.assertEquals(300.0F, rc_float, 0);
  }
  public void testItem_0487()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\uFFFF', '\0', '\uFFFF', '8', '8', '8', '\0', '8', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\uFFFF', '8', '8', '\1', '\1', '\0', '\234', '\0', '8', '\1', '\234', '\234', '\234', '\0', '\234', '\234', '\uFFFF', '\234', '8', '\234', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\234', '8', '\234', '\1', '\0', '\uFFFF', '\0', '\234', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\1', '\234', '8', '\uFFFF', '8', '\234', '\1', '\234', '\0'}, 0, -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0489()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\0', '\uFFFF', '\234', '\1', '8', '\1', '\1', '8', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0490()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("3E+2"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0491()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647", rc_BigDecimal.toString());
  }
  public void testItem_0492()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+2")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0493()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\uFFFF', '\1', '\1', '\1', '\1', '\1', '\234', '\1', '\0', '\1', '\uFFFF', '8', '8', '\234', '\1', '\1', '\uFFFF', '\1', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\1', '8', '\1', '\0', '\0', '8', '\uFFFF', '\0', '\1', '\0', '\234', '\0', '\234', '8', '\1', '\0', '\1', '\uFFFF', '\0', '8', '8', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\1', '\0', '8', '\1', '8', '\234', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\1', '8', '\234', '8', '\0', '8', '\1', '\234', '8', '\1', '8', '\0', '8', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0494()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).divide(new BigDecimal("3E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0000", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    rc_String = (new BigDecimal("3E+2")).toPlainString();
    Assert.assertEquals("300", rc_String);
  }
  public void testItem_0496()
  {
    rc_float = (new BigDecimal("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0499()
  {
    rc_int = (new BigDecimal("0E-1074")).compareTo(new BigDecimal("-3E+2"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0500()
  {
    rc_int = (new BigDecimal("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).add(new BigDecimal("0E-1074"));
    Assert.assertEquals("300.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    rc_BigDecimal = (new BigDecimal("300.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).abs();
    Assert.assertEquals("300.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0505()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigIntegerExact();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0506()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0507()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2148", rc_BigDecimal.toString());
  }
  public void testItem_0508()
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
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("300.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), 0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0512()
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
  public void testItem_0513()
  {
    rc_float = (new BigDecimal("2147483647")).floatValue();
    Assert.assertEquals(2.147483648E9F, rc_float, 0);
  }
  public void testItem_0514()
  {
    rc_BigDecimal = (new BigDecimal("300.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0515()
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
  public void testItem_0516()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigInteger();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0518()
  {
    rc_String = (new BigDecimal("-2E+308")).toString();
    Assert.assertEquals("-2E+308", rc_String);
  }
  public void testItem_0519()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(-1, 1);
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836E+308", rc_BigDecimal.toString());
  }
  public void testItem_0520()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0521()
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
  public void testItem_0522()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836E+308")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0523()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-2E+308")).longValueExact();
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
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0525()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+308")).divide(new BigDecimal("32"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0526()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0527()
  {
    rc_float = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836E+308")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0528()
  {
    rc_BigInteger = (new BigDecimal("300.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).unscaledValue();
    Assert.assertEquals("300000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0529()
  {
    rc_String = (new BigDecimal("-2E+308")).toEngineeringString();
    Assert.assertEquals("-200E+306", rc_String);
  }
  public void testItem_0530()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '8', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0531()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointLeft(2147483647);
    Assert.assertEquals("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0532()
  {
    rc_BigDecimal = (new BigDecimal("300.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0533()
  {
    rc_boolean = (new BigDecimal("-2E+308")).equals("VPQ>KXX>54OKTGT3H=@LU05PW0UH0LM3G5WUN1XP5XE5PSSQL3CTR5ALQ5?KD>U4YA1Q9HA20D3K6CRV6<GDLOMS6Q?MOLXVQWSL");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0534()
  {
    rc_BigDecimal = (new BigDecimal("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).divide(new BigDecimal("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\1', '\0', '\0', '8', '\234', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\234', '8', '8', '\1', '8', '8', '\234', '\234', '\uFFFF'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0536()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0537()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836E+308")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0538()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0540()
  {
    rc_int = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836E+308")).intValue();
    Assert.assertEquals(-8, rc_int);
  }
  public void testItem_0541()
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
  public void testItem_0542()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0543()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\uFFFF', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0544()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).remainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_String = (new BigDecimal("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).toEngineeringString();
    Assert.assertEquals("17.9769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483340", rc_String);
  }
  public void testItem_0547()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836E+308")).add(new BigDecimal("1"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361", rc_BigDecimal.toString());
  }
  public void testItem_0549()
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
  public void testItem_0550()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0551()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("IWAP5GQ46B<2A6@CSTWC35SKE1R=2P5K74SNC9HK<DPNHF8E;PAVW@W@?QKDW", new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0552()
  {
    rc_BigInteger = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836E+308")).toBigInteger();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858360", rc_BigInteger.toString());
  }
  public void testItem_0553()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361")).min(new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836E+308"));
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836E+308", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0555()
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
  public void testItem_0556()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0557()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0558()
  {
    rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836E+308")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0560()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0561()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361")).precision();
    Assert.assertEquals(309, rc_int);
  }
  public void testItem_0562()
  {
    rc_BigInteger = (new BigDecimal("2E+308")).toBigInteger();
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("2E-2147483340", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    rc_float = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0565()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0566()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0567()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("-1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0568()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361")).movePointLeft(2147483647);
    Assert.assertEquals("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-2E+308")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0571()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0572()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2E+308")).divide(new BigDecimal("-2E+308"), 2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0573()
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
  public void testItem_0574()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).scaleByPowerOfTen(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0576()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0577()
  {
    rc_int = (new BigDecimal("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361E-2147483339")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0578()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).setScale(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0", rc_BigDecimal.toString());
  }
//  public void testItem_0579()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=CEILING"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0580()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).add(new BigDecimal("-1"));
    Assert.assertEquals("199999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0582()
  {
    rc_int = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0")).precision();
    Assert.assertEquals(310, rc_int);
  }
  public void testItem_0583()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0584()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0585()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361E-2147483339")).movePointLeft(0);
    Assert.assertEquals("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_double = (new BigDecimal("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361E-2147483339")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0588()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361E-2147483339")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0589()
  {
    rc_int = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0")).compareTo(new BigDecimal("2E+308"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0590()
  {
    rc_int = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0")).compareTo(new BigDecimal("2E+308"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0591()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("O6G45E6PG8VWBS7P>@KPH", new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0592()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361E-2147483339"), 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0593()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0594()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0595()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361E-2147483339"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0596()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("GH2UO3;LC3T<<3OTWHH0I84;U>0HNOM:QUQ0?TXQO187AMRQ:06;ETYQ6OT8AM@3O@YTSF;7BOV75Y;03LP6?", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0597()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0")).divide(new BigDecimal("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858361E-2147483339"), -1, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0598()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0599()
  {
    rc_BigDecimal = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0601()
  {
    rc_BigDecimal = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0")).movePointLeft(1);
    Assert.assertEquals("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.00", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("29", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("29")).add(new BigDecimal("29"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).divideToIntegralValue(new BigDecimal("29"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    rc_BigDecimal = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0608()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).movePointLeft(1);
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    rc_int = (new BigDecimal("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.00")).compareTo(new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0610()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0611()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.01")).divide(new BigDecimal("0.1"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0612()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("0.1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0613()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_BigDecimal = (new BigDecimal("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.00")).ulp();
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\0', '8', '8', '8', '\1', '\0', '\234', '\1', '\0', '\0', '8', '8', '\0', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '8', '8', '8', '\1', '\1', '\234', '8', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '8', '\0', '\1', '\0', '\0', '\234', '\234', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\0', '\1', '\1', '\0', '\uFFFF', '\234', '\1', '\1', '\234', '\234', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '8', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '8', '8', '8', '\uFFFF', '\uFFFF', '8', '8', '\0', '\1', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '8', '8', '8', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\234', '\1', '\1', '\uFFFF'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0617()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0618()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0620()
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
  public void testItem_0621()
  {
    rc_int = (new BigDecimal("0.01")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0622()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).setScale(2147483647, 0);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0623()
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
  public void testItem_0624()
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
  public void testItem_0625()
  {
    rc_BigDecimal = (new BigDecimal("0.01")).divideToIntegralValue(new BigDecimal("-0.1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.1")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0628()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).max(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0630()
  {
    rc_String = (new BigDecimal("-0.1")).toEngineeringString();
    Assert.assertEquals("-0.1", rc_String);
  }
  public void testItem_0631()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0632()
  {
    rc_int = (new BigDecimal("1135879015891")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0633()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0634()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0635()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("-0.1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0638()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("0.0"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
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
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0641()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).stripTrailingZeros();
	Assert.assertEquals(0.0, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0643()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0646()
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
  public void testItem_0647()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("3.2E-2147483646"), java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0648()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0649()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0650()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).round(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0654()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_String = (new BigDecimal("0E+1")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
//  public void testItem_0658()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0659()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toEngineeringString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
//  public void testItem_0660()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("320.0E+2147483647"), -1, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0661()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0662()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("320.0E+2147483647"), 1, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0663()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\0', '\1', '\0', '\1', '\uFFFF', '8', '\0', '\234', '\234', '8', '8', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\1', '\0', '\234', '\234', '\uFFFF', '\234', '8', '8', '\uFFFF', '8', '\234', '\1', '\1', '\uFFFF', '\234', '\1', '8', '\0', '\234', '8', '\1', '8', '\0', '\1', '\uFFFF', '\234', '\234', '\1', '\234', '\1', '\234', '\0', '8', '\0', '8', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\1', '8', '\1', '8', '\uFFFF', '\uFFFF', '8', '8', '8', '\uFFFF', '8', '8', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '\0', '\1', '\234', '\uFFFF', '8', '\0', '8', '\uFFFF', '8', '\0', '\1', '\234', '\0', '\0', '\0', '\234'}, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0664()
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
  public void testItem_0665()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\234', '\234', '\234', '\234', '8', '8', '\234', '8', '\0', '\1', '\234', '8', '\234', '\1', '8', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\234', '8', '8', '8', '\234', '\1', '\0', '\234', '\0', '\uFFFF', '8', '8', '\1', '\234', '\uFFFF', '\234', '\234', '\1', '8', '\234', '\1', '\uFFFF', '\0', '\1', '\0', '\0', '8', '\0', '\1', '\234', '\1', '8', '\234', '8', '\0', '\234', '\1', '\0', '\0', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0666()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("0E+1"), 2147483647, 1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0667()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147482656, rc_int);
//  }
  public void testItem_0668()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("0E+1"), -2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0669()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointLeft(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0672()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_int = (new BigDecimal("-2147483648")).intValueExact();
    Assert.assertEquals(-2147483648, rc_int);
  }
  public void testItem_0674()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("-1"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0675()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("320.0E+2147483647"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0676()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0677()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0678()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigInteger();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
//  public void testItem_0682()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(1);
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0683()
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
//  public void testItem_0684()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).min(new BigDecimal("32"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0685()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).negate(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\234', '8', '\uFFFF', '8', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\0', '8', '\234', '\0', '\234', '\1', '\1', '8', '8', '\234', '8', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '8', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\1', '\1', '8', '8', '8', '8', '\1', '\1', '\234', '\1', '\uFFFF', '\234', '\0', '\0', '\1', '8', '\234', '8', '\1', '\1', '\234', '\0', '8', '\234', '\0', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\0', '8', '8', '\uFFFF', '\1', '\234', '\234', '\234', '\0', '\234', '\1', '\1', '\234', '\1', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0687()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
//  public void testItem_0688()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0689()
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
  public void testItem_0690()
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
  public void testItem_0691()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).negate();
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0692()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).movePointLeft(0);
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).add(new BigDecimal("2147483648"));
    Assert.assertEquals("4294967296", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigInteger = (new BigDecimal("2147483648")).toBigInteger();
    Assert.assertEquals("2147483648", rc_BigInteger.toString());
  }
//  public void testItem_0697()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4294967296")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0698()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\0', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\1', '8', '\1', '\uFFFF', '8', '\1', '\234', '\0', '8', '\1', '8', '\1', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\234', '\234', '8', '\0', '\0', '\0', '8', '\234', '\1', '\0', '\234', '\1', '\1', '\234', '\0', '\0', '\234', '\0', '\0', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\234', '8', '\234', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '8'}, new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0699()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).subtract(new BigDecimal("2147483648"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0700()
  {
    rc_BigDecimal = (new BigDecimal("4294967296")).add(new BigDecimal("2147483648"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("6442450944", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=1 roundingMode=CEILING", rc_MathContext.toString());
  }
//  public void testItem_0702()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("320.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("32", rc_BigInteger.toString());
//  }
//  public void testItem_0703()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("4294967296"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0704()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("320.0E+2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0705()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0706()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("6442450944")).subtract(new BigDecimal("6442450944"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("2147483648"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0709()
  {
    rc_BigDecimal = (new BigDecimal("6442450944")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("6442450944", rc_BigDecimal.toString());
  }
//  public void testItem_0710()
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
  public void testItem_0711()
  {
    rc_BigInteger = (new BigDecimal("6442450944")).unscaledValue();
    Assert.assertEquals("6442450944", rc_BigInteger.toString());
  }
//  public void testItem_0712()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_int = (new BigDecimal("320.0E+2147483647")).compareTo(new BigDecimal("2147483648"));
//    Assert.assertEquals(-1, rc_int);
//    }
//  }
  public void testItem_0713()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0714()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).scaleByPowerOfTen(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(0, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0717()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("4294967296"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0720()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4294967296")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0721()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("6442450944")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0722()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("6442450944")).divide(new BigDecimal("4294967296"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0723()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("6442450944")).multiply(new BigDecimal("6442450944"));
    Assert.assertEquals("41505174165846491136", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("6442450944")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("6442450943", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
//  public void testItem_0728()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0729()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("6442450944"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0731()
  {
    rc_BigInteger = (new BigDecimal("4294967296")).toBigInteger();
    Assert.assertEquals("4294967296", rc_BigInteger.toString());
  }
//  public void testItem_0732()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("4294967296")).min(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0733()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("4294967296"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-4294967296", rc_BigDecimal.toString());
  }
  public void testItem_0734()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("320.0E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0735()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("MYP<9>QVX@XAN4VV3;QQ5=TVTQ;R492L40F<I=GHL7B25P0FCMOQDX0M39S<AUI><0@M6G3KOHTM:U@2PJH@9VCS1PO3<>E:D=5>");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0736()
  {
    rc_BigDecimal = (new BigDecimal("-4294967296")).plus(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-4294967296", rc_BigDecimal.toString());
  }
  public void testItem_0737()
  {
    rc_BigDecimal = (new BigDecimal("4294967296")).min(new BigDecimal("6442450944"));
    Assert.assertEquals("4294967296", rc_BigDecimal.toString());
  }
  public void testItem_0738()
  {
    rc_int = (new BigDecimal("320.0E+2147483647")).compareTo(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0739()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("9NJ6IUS<K1SCXY94A5O4E?HYT@AMI0>H;R");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0740()
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
//  public void testItem_0741()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("6442450944")).divide(new BigDecimal("320.0E+2147483647"), 0, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("-4294967296")).max(new BigDecimal("4294967296"));
    Assert.assertEquals("4294967296", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\234', '\234', '\1', '\uFFFF', '\0', '\0', '\0', '8', '8', '\234', '\0', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '8', '\1', '\234', '\234', '\0', '\0', '\234', '\234', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\234', '\234', '\0', '\1', '8', '8', '\234', '\234', '8', '\0', '\0', '8', '\uFFFF', '8', '\1', '8', '\234', '\1', '8', '\0', '\234', '\1', '\1', '8', '\1', '\1', '\1', '8', '\0', '\0', '\234', '\uFFFF', '8', '8', '\0', '\234', '\0', '\234', '\uFFFF', '8', '8', '\1', '\1', '\1', '\uFFFF', '\234', '\1', '\234', '8', '8', '\234', '\234', '\1', '\1', '\234'}, 0, 1, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("4294967296")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("4294967297", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0747()
  {
    rc_int = (new BigDecimal("6442450944")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0748()
  {
    rc_long = (new BigDecimal("6442450944")).longValue();
    Assert.assertEquals(6442450944L, rc_long);
  }
  public void testItem_0749()
  {
    rc_BigDecimal = (new BigDecimal("6442450944")).abs();
    Assert.assertEquals("6442450944", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    rc_BigInteger = (new BigDecimal("8")).toBigIntegerExact();
    Assert.assertEquals("8", rc_BigInteger.toString());
  }
  public void testItem_0751()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0752()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0753()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("8")).setScale(2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0754()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0755()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0756()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0757()
  {
    rc_int = (new BigDecimal("8")).intValueExact();
    Assert.assertEquals(8, rc_int);
  }
  public void testItem_0758()
  {
    rc_float = (new BigDecimal("4294967296")).floatValue();
    Assert.assertEquals(4.294967296E9F, rc_float, 0);
  }
  public void testItem_0759()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\1', '\uFFFF', '\1', '\0', '\234', '\0', '\1', '\1', '8', '\234', '\0', '\234', '\1', '\234', '\0', '\uFFFF', '\234', '8', '\0', '8', '\uFFFF', '\uFFFF', '\0', '8', '8', '8', '\0', '8', '\1', '\0', '\234', '8', '\1', '\0', '\234', '\0', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\1', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0760()
  {
    rc_BigDecimal = (new BigDecimal("8")).pow(0, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0761()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("8"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0762()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0764()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0765()
  {
    rc_long = (new BigDecimal("4294967296")).longValue();
    Assert.assertEquals(4294967296L, rc_long);
  }
  public void testItem_0766()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(-2147483648);
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
      rc_BigDecimal = new BigDecimal(new char[]{'\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0770()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("4294967296")).subtract(new BigDecimal("32"));
    Assert.assertEquals("4294967264", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0773()
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
  public void testItem_0774()
  {
    rc_BigDecimal = (new BigDecimal("4294967296")).min(new BigDecimal("1024"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("1024")).movePointLeft(-1);
    Assert.assertEquals("10240", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0777()
  {
    rc_BigDecimal = (new BigDecimal("4294967264")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4294967264")).divide(new BigDecimal("1"), -2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0780()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("1024")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\0', '\1', '\0', '\0', '\234', '8', '\234', '8', '8', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '8', '8', '\0', '\234', '\234', '8', '\234', '8', '\234', '8', '8', '\234', '\0', '8', '8', '8', '\uFFFF', '\1', '\1', '\0', '\234', '8', '8', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '8', '\0', '8', '8', '\1', '\uFFFF', '\234', '\234', '\1', '8', '8', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '8', '\1', '8', '\0', '\0', '\234', '\234', '\234', '\uFFFF', '\234', '\0', '8', '\1', '\uFFFF', '\1', '8', '8', '\234', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("10240"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-10239", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("10240")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("327680", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_short = (new BigDecimal("1024")).shortValueExact();
    Assert.assertEquals(1024, rc_short);
  }
  public void testItem_0786()
  {
    rc_int = (new BigDecimal("1024")).compareTo(new BigDecimal("327680"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0787()
  {
    rc_BigDecimal = (new BigDecimal("1024")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    rc_BigInteger = (new BigDecimal("1024")).toBigInteger();
    Assert.assertEquals("1024", rc_BigInteger.toString());
  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("1024")).plus();
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    rc_BigDecimal = (new BigDecimal("1024")).divide(new BigDecimal("327680"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0791()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\1', '\234', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\234', '\234', '\234', '\0', '\1', '\234', '8', '8', '8', '\0', '8', '8', '\uFFFF', '\1', '\0', '\234', '\234', '\234', '\1', '\0', '\0', '\1', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\0', '8', '8', '\0', '\uFFFF', '\234', '\1', '\234', '\0', '\0', '\234', '\uFFFF', '\1', '\234', '\234', '\0', '\0', '8', '\0', '\1', '\234', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\234', '\1', '8', '\1', '\0', '8', '\1', '\234', '\1', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\0', '\1', '8', '\234', '\1', '\1', '\234', '\1', '\234', '\1', '\0', '\234', '\0', '\uFFFF', '8', '\234', '8', '8', '\uFFFF', '\uFFFF', '\234', '8'}, 1, 2147483647, new MathContext("precision=2147483647 roundingMode=CEILING"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0792()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -2147483648, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0793()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\uFFFF', '\234', '\0', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0794()
  {
    rc_BigDecimal = (new BigDecimal("4294967264")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4294967264", rc_BigDecimal.toString());
  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("1024")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0796()
  {
    rc_BigDecimal = (new BigDecimal("-10239")).divideToIntegralValue(new BigDecimal("4294967264"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("1024")).negate(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-1024", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1024")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0799()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\uFFFF', '\0', '\0', '\0', '\1', '\234', '\0', '8', '\0', '\234', '\0', '\0', '8', '\1', '8', '\234', '\234', '8', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '8', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '8', '8', '\234', '\1', '\234', '\1', '\1', '8', '8', '\0', '\uFFFF', '\234', '8', '8', '\0', '\234', '8', '8', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\234', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\234', '\234', '8', '\uFFFF', '8', '8', '\uFFFF', '\234', '\1', '\0', '\234', '\uFFFF', '8', '\0', '8', '\234', '\0', '\234'}, -1, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0800()
  {
    rc_boolean = (new BigDecimal("327680")).equals("IRMHG06LG4BWOTKBP=;YGCL63J0727<LEPSD@1L>5?KC8DCML=<UB4M30;");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0801()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0802()
  {
    rc_BigInteger = (new BigDecimal("1024")).toBigIntegerExact();
    Assert.assertEquals("1024", rc_BigInteger.toString());
  }
  public void testItem_0803()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1024")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0804()
  {
    rc_int = (new BigDecimal("1024")).intValue();
    Assert.assertEquals(1024, rc_int);
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("1024")).abs();
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("1024")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("32"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0816()
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
  public void testItem_0817()
  {
    rc_String = (new BigDecimal("1024")).toString();
    Assert.assertEquals("1024", rc_String);
  }
  public void testItem_0818()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0821()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0822()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0823()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0824()
  {
    rc_boolean = (new BigDecimal("-32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0825()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0827()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0828()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-35496219246", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0830()
  {
    rc_boolean = (new BigDecimal("-35496219246")).equals("F8<IJS=KJFS8?ENB0D<3E;>;GSTGLK;JMIIPR=JD82SUVWUUI7TXXC;Q@10B7UOB990<UDP6C=G<?2IAFVBBG;F1XL>48XJCKG@O");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0831()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\1', '\1', '\1', '\234', '8', '\234', '\0', '8', '\1', '8', '\0', '\0'}, 0, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0832()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("FQ:RQNKFIRMFLLCSJY<QFB7NNQ9UP1@184PSBGA@UP93R>3R:@XS:YJ3N6K2?:B33W@V:F<6201DS@P@42V2NP?A4YKUWTHSMIWN", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0833()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\1', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0834()
  {
    rc_boolean = (new BigDecimal("-35496219246")).equals("U6@@MO9GD4H6IQJ7U1NVSR4BKX9S<E2G93@LW1QXFQJ95LL=VTXSB7AO5R>VC00L4SLEUY=RWD:IS5AD33Y>>69@V8INQBJ70UX?");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0835()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-35496219246")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0836()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-35496219246"));
  }
  public void testItem_0837()
  {
    rc_BigDecimal = (new BigDecimal("33")).add(new BigDecimal("33"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("66", rc_BigDecimal.toString());
  }
  public void testItem_0838()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).subtract(new BigDecimal("-35496219246"));
    Assert.assertEquals("1171375235137", rc_BigDecimal.toString());
  }
  public void testItem_0839()
  {
    rc_int = (new BigDecimal("-35496219246")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0840()
  {
    rc_BigInteger = (new BigDecimal("-35496219246")).unscaledValue();
    Assert.assertEquals("-35496219246", rc_BigInteger.toString());
  }
  public void testItem_0841()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\1', '\0', '\1', '8', '\1', '\1', '8', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF'}, -1, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0842()
  {
    rc_BigDecimal = (new BigDecimal("66")).stripTrailingZeros();
    Assert.assertEquals("66", rc_BigDecimal.toString());
  }
//  public void testItem_0843()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-35496219246")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0844()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0845()
  {
    rc_BigInteger = (new BigDecimal("1135879015891")).unscaledValue();
    Assert.assertEquals("1135879015891", rc_BigInteger.toString());
  }
//  public void testItem_0846()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-35496219246")).divide(new BigDecimal("32"), 2147483647, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0847()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0848()
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
  public void testItem_0849()
  {
    rc_String = (new BigDecimal("1135879015891")).toEngineeringString();
    Assert.assertEquals("1135879015891", rc_String);
  }
  public void testItem_0850()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3.2E-2147483646"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0851()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0852()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0853()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("1"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0856()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_long = (new BigDecimal("-9223372036854775808")).longValue();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0859()
  {
    rc_boolean = (new BigDecimal("-35496219246")).equals("N4DYJB9H6BVMYT?JKK0BSOCJ5@F0OCX=8CM@AK6<9QFTX3VMO1YIVMK7:R98GE6T72O:WVQ;CGHQ@0?;5A24@XE8@TJ=4?:D8;WS");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-295147905179352825856", rc_BigDecimal.toString());
  }
  public void testItem_0861()
  {
    rc_BigInteger = (new BigDecimal("-35496219246")).unscaledValue();
    Assert.assertEquals("-35496219246", rc_BigInteger.toString());
  }
  public void testItem_0862()
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
  public void testItem_0863()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015891")).negate();
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0864()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1135879015891")).pow(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0865()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015891")).stripTrailingZeros();
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0866()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).multiply(new BigDecimal("32"));
    Assert.assertEquals("36348128508512", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_int = (new BigDecimal("1135879015891")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0868()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015891")).divide(new BigDecimal("-1135879015891"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0870()
  {
    rc_BigDecimal = (new BigDecimal("36348128508512")).movePointRight(0);
    Assert.assertEquals("36348128508512", rc_BigDecimal.toString());
  }
//  public void testItem_0871()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1135879015891")).divideAndRemainder(new BigDecimal("-1135879015891"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0872()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0873()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0874()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("36348128508512")).divide(new BigDecimal("0"), -2147483648, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0875()
  {
    rc_float = (new BigDecimal("36348128508512")).floatValue();
    Assert.assertEquals(3.6348127870976E13F, rc_float, 0);
  }
//  public void testItem_0876()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("36348128508512")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0877()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0878()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0880()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0881()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0882()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0886()
  {
    rc_int = (new BigDecimal("1135879015891")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0887()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toEngineeringString();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_String);
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("36348128508512")).plus();
    Assert.assertEquals("36348128508512", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    rc_BigDecimal = (new BigDecimal("36348128508512")).multiply(new BigDecimal("1"));
    Assert.assertEquals("36348128508512", rc_BigDecimal.toString());
  }
  public void testItem_0890()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '8', '8', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\234', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0891()
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
  public void testItem_0892()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0893()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("GWGS4183DE>4JB:EQ<BCE?W>D>?WN=OJWXXM89M:<E8?03K=4CJT9X4<76YHM?13JC8>CY:A62<1UFBOPMM2Q?XCFTCD0IEHVJD@", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0895()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).scale();
    Assert.assertEquals(1074, rc_int);
  }
  public void testItem_0896()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideToIntegralValue(new BigDecimal("36348128508512"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0897()
  {
    rc_BigDecimal = (new BigDecimal("36348128508512")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.6348128508512E+2147483660", rc_BigDecimal.toString());
  }
  public void testItem_0898()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideAndRemainder(new BigDecimal("0E-1074"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0899()
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
  public void testItem_0900()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("32"));
    Assert.assertEquals("1.5439551432538954505517774777131917886408118831697648888299552578146109602194023495790619886301124761868642646732678679091458022198623118637461712375336933691446897287197231391495181786495280690740272457376781210335095312699606536048905762103514793664786550473125991105793689816444955174724094583079896461505844986259707029123289737234139229040795517012535233754053437485685374669033763017603891398660870906710211879979851206610941712610202921000605594587834710911572913208889854174127601349800288696542057400187831285956780655478369819616619778899703070389783676174772649608300264931886670217811042646931164617867453517689222497285952784692034493321056772659236991842917496855202531066138142820740907122633648576766340898558382832561619579792022705078125E-325", rc_BigDecimal.toString());
  }
  public void testItem_0901()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("36348128508512")).divide(new BigDecimal("36348128508512.0E+2147483647"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0902()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    rc_BigDecimal = (new BigDecimal("36348128508512")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_BigDecimal_array = (new BigDecimal("36348128508512")).divideAndRemainder(new BigDecimal("9223372036854775807"));
  }
//  public void testItem_0905()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\234', '\234', '\0', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\0', '\1', '8', '\1', '\234', '\0', '\1', '\0', '\1', '8', '\1', '8', '8', '8', '\234', '\0', '\0', '\0', '8', '8', '8', '\0', '\1', '\1', '8', '\1', '\uFFFF', '\1', '\1', '\1'}, 1, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0906()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0E-1074"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0907()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '8', '\0', '8', '8', '\1', '\uFFFF', '\1', '\1', '\1', '8', '\0', '\0', '\uFFFF', '\0', '\234', '8', '\0', '\234'}, 0, -1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0908()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '8', '8', '\0', '\234', '8', '\0', '\uFFFF', '\0', '\234', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\234', '\0', '\uFFFF', '8', '\1', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\1', '\1', '\0', '\0', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '8', '\0', '\234', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '8', '8', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\234', '\1', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\234', '8', '\234', '8', '8', '\uFFFF', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0909()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).movePointLeft(1);
    Assert.assertEquals("0E-1075", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    rc_BigInteger = (new BigDecimal("0E-1074")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0911()
  {
    rc_String = (new BigDecimal("0E-1075")).toString();
    Assert.assertEquals("0E-1075", rc_String);
  }
  public void testItem_0912()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("36348128508512")).divide(new BigDecimal("0E-1074"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0913()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("36348128508512")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).pow(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0916()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0917()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0918()
  {
    rc_int = (new BigDecimal("0E-1074")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0919()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).movePointLeft(-1);
    Assert.assertEquals("92233720368547758070", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-1074")).divide(new BigDecimal("0E-1075"), 1, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0923()
  {
    rc_double = (new BigDecimal("0E-1075")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("0E-1075")).negate();
    Assert.assertEquals("0E-1075", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("0E-1075")).add(new BigDecimal("0E-1075"));
    Assert.assertEquals("0E-1075", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    rc_BigDecimal = (new BigDecimal("0E-1075")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-1075", rc_BigDecimal.toString());
  }
  public void testItem_0927()
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
  public void testItem_0928()
  {
    rc_int = (new BigDecimal("0E-1075")).scale();
    Assert.assertEquals(1075, rc_int);
  }
  public void testItem_0929()
  {
    rc_BigDecimal = (new BigDecimal("0E-1075")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0930()
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
  public void testItem_0931()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0933()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '8', '\0', '\234', '\1', '\1', '\uFFFF', '\234', '\1', '\234', '\0', '\1', '\uFFFF', '\0', '\0', '\1', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '8', '\234', '\1', '\0', '\234', '8', '\1', '\1', '\1'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0935()
  {
    rc_BigInteger = (new BigDecimal("0E-1075")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0936()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0937()
  {
    rc_boolean = (new BigDecimal("32")).equals("I6X;GD0CE9VA<MRY5O?RX50V<MYQ:HF=P3@7>K3?WYC85C8A1T2A>UEEAW>P;FE;03B:RP7KH;CS4ID3H04V87:T:BBVJUT90LGV");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0938()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0939()
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
  public void testItem_0940()
  {
    rc_boolean = (new BigDecimal("0E-1075")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0941()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0942()
  {
    rc_double = (new BigDecimal("0E-1075")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0943()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    rc_float = (new BigDecimal("0E-1075")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\1', '\1', '\0', '\1', '8', '8', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\1', '\0', '\1', '\234', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\234', '\234', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '8', '8', '8', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\234', '8', '\234', '8', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\1', '8', '\0', '8', '\0', '\uFFFF', '\0', '\1', '\0', '\234', '\0', '8', '8', '\0', '8', '8', '8', '\0', '\1', '8', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\0', '\234', '8', '\234', '\uFFFF', '\234', '\234', '\1', '\1', '\uFFFF', '8', '\uFFFF'}, 0, -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0950()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E-1075"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0951()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0954()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0955()
  {
    rc_int = (new BigDecimal("3.2")).compareTo(new BigDecimal("3.2"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0956()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0957()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0958()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("3.2"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0959()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.2E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0960()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0961()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0962()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-9223372036854775808"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0964()
  {
    rc_double = (new BigDecimal("-9223372036854775808")).doubleValue();
    Assert.assertEquals(-9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0967()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0968()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0970()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0971()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\1', '\1', '8', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\0', '\234', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '8', '\0', '\1', '\1', '8', '\1', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '8', '\0', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\0', '\uFFFF', '\1', '\0', '\234', '\234', '\1', '\0', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\1', '\1', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF'}, 0, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0972()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9223372036854775804.8", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775804.8")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0975()
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
  public void testItem_0976()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("-9223372036854775804.8"), -2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0978()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0979()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0980()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775804.8")).stripTrailingZeros();
    Assert.assertEquals("-9223372036854775804.8", rc_BigDecimal.toString());
  }
  public void testItem_0981()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3C2M6P:61O8T@?F>HPKU5SM2>2FU>N<BDMGT1Q8:B:00WMWX2:?8Q;@");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0984()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775804.8")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0985()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0986()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775804.8")).setScale(0, 0);
    Assert.assertEquals("-9223372036854775805", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775804.8")).pow(1);
    Assert.assertEquals("-9223372036854775804.8", rc_BigDecimal.toString());
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0990()
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
  public void testItem_0991()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0992()
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
  public void testItem_0993()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0994()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("TBRB6IEOLSI>7JN6I@JJ<3<L>DDI:?XV4IF:VAIP?GN@<F@E7BD:TPHQG=181<BB4=COJ?1OMJB3FGA4PF547T:0<TUYIO<IFDV0");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0995()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0996()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0997()
  {
    rc_int = (new BigDecimal("3.2E+2")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0998()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
}
