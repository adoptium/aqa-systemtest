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
public class TestSuite038 extends TestCase
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
  
  public TestSuite038() {
  
  }
  public void testItem_0000()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0001()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\1', '8', '\uFFFF', '\234', '\0', '\234', '\0'}, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0002()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0004()
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
  public void testItem_0005()
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
  public void testItem_0006()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E-8"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0007()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("3.2"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0009()
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
  public void testItem_0010()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("RPN?LMAY543", new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0011()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0012()
  {
    rc_long = (new BigDecimal("3.2")).longValue();
    Assert.assertEquals(3L, rc_long);
  }
  public void testItem_0013()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0014()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).setScale(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0015()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("9223372036854775807"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0016()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3.2")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0017()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0018()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(2147483647);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1E-2147483647"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0021()
  {
    rc_BigDecimal_array = (new BigDecimal("1E-2147483647")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
  }
  public void testItem_0022()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("-9223372036854775806", rc_BigDecimal.toString());
  }
  public void testItem_0023()
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
  public void testItem_0024()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("9223372036854775807"));
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).abs();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775806")).divide(new BigDecimal("9223372036854775807"), new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0027()
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
  public void testItem_0028()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_int = (new BigDecimal("1E-2147483647")).compareTo(new BigDecimal("9223372036854775807"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0031()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-2147483647")).divide(new BigDecimal("1"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\0', '\234', '\uFFFF', '\1', '\234', '8', '\1', '\0', '\234', '\234', '\234', '\uFFFF', '\0', '\0', '\234', '\1', '\0', '8', '\0', '\0', '\234', '8', '8', '\uFFFF', '\1', '\0', '\234', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\234', '\1', '\1', '\234', '\1', '\uFFFF', '\0', '\1', '8', '\0', '\1', '\uFFFF', '\234', '\1', '\234', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\1', '\234', '\0', '8', '\0', '\0', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\234', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\1', '\234', '8', '\1', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0034()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0035()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775808")).unscaledValue();
    Assert.assertEquals("9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0036()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775808")).divide(new BigDecimal("9223372036854775808"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0037()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("9223372036854775808"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0039()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-2147483647")).subtract(new BigDecimal("9223372036854775807"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0040()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0041()
  {
    rc_boolean = (new BigDecimal("9223372036854775808")).equals("FE2@O?SE9EUIX1E65DWRK1EVBKEF20<YX>WM2PXP46MGKWU1XKWLYYB2GN4G9O>DLAFU44K?JRCT8O5=QW>MS;E2RY3JTCYC1I;5");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0042()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).abs();
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0043()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775807")).toBigInteger();
    Assert.assertEquals("9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0044()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775808")).movePointLeft(0);
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0045()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).round(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0047()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).subtract(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0049()
  {
    rc_boolean = (new BigDecimal("1E-2147483647")).equals("ILSR7DJ3=YLG5<AYXOGVJI");
    Assert.assertEquals(false, rc_boolean);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0050()
  {
    rc_boolean = (new BigDecimal("9223372036854775808")).equals("AMMDXMIL7LF9FF8CKSD1:LK@4DB>VCU6DHY5?@S<QW@34N52FMW2?XD34KK15BVDG78QET5LLL1XPU>3:1N1XWQ4Q:X0;LI<NKQC");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0051()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(">B7OC73072IYMJC6ASXHLB=GRL1YCLXS=GQAC;7SRNSEJ968KSYV5F>6::<>L5M5OA8PI;6R>ST;AD?IQP03MT8HJ:ND2=L<GNV2", new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0052()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).pow(2147483647, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0053()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775808")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0054()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0055()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '8', '\1', '\1', '\1', '\0', '8', '\234', '\1', '8', '\1', '\1', '\234', '\234', '\1', '\0', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '8', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\1', '8', '\0', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\1', '\0', '\1', '\234', '\0', '8', '\uFFFF', '\1', '\uFFFF', '8', '\0', '8', '\1', '\0', '\234', '\234', '\1', '\0', '\1', '\234', '\uFFFF', '8', '8', '\0', '8', '\0', '8', '8', '\uFFFF', '\1', '8', '8', '8', '\1', '\1', '\uFFFF', '\234', '8', '\1', '\234', '\1', '8', '\1', '\uFFFF', '\234', '\234', '\234', '8', '8', '8'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0056()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0058()
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
  public void testItem_0059()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0060()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("FF0OKIW9:JT>WQVYPNU64=MWYV2@K9VPBW?@YT>C=>0Y2I3JBP1>7MM<:LU8RH=B>FL8W>OO8T41R:3A7>L4K9TL1?N?AXRCUB7S");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0061()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.1")).add(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0063()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.1")).subtract(new BigDecimal("9223372036854775808"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0064()
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
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).stripTrailingZeros();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_long = (new BigDecimal("0.1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0068()
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
  public void testItem_0069()
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
  public void testItem_0070()
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
//  public void testItem_0071()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).movePointRight(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0072()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0073()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("0.1"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0074()
  {
    rc_float = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0075()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LQJ;UAF2DQOA>BLSWTG9A:867RX5H3GPO2B8943:SK;><5?K@60B<FXQPVBMJBU?FYL:62GN5>EFCNTGKQ88K6HT1MU;568C<9;B", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775808")).divide(new BigDecimal("9223372036854775808"), java.math.RoundingMode.UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("FOVFG6=P@BS0<VO5U5SPPNK<R8ES019M>E@52W2C5KU<YAR?IAC>O07D8MNVG42::MD;@3DKSGI<8:A;0O=A3IE58RRK3=WD@KCN", new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0078()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("9223372036854775808"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0079()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0080()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\0', '\1', '8', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\1', '8', '\1', '\234', '\1', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '8', '\234', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\0', '\0', '\234', '\234', '\uFFFF', '8', '8', '8', '\0', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\0'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0081()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("QO?0BS1M;C0?@@;<T?WHT9OSG2T;A5BX3QU?C:BWN7:R5N186HQ<PHTDPKJ3VD>KK:?QT=XSR5X:RYNDAXGKW;39VDWF<>O<9YQX");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).min(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).scaleByPowerOfTen(0);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0089()
  {
    rc_BigDecimal = (new BigDecimal("-5E-324")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-2.4703282292062327208828439643411068618252990130716238221279284125033775363510437593264991818081799618989828234772285886546332835517796989819938739800539093906315035659515570226392290858392449105184435931802849936536152500319370457678249219365623669863658480757001585769269903706311928279558551332927834338409351978015531246597263579574622766465272827220056374006485499977096599470454020828166226237857393450736339007967761930577506740176324673600968951340535537458516661134223766678604162159680461914467291840300530057530849048765391711386591646239524912623653881879636239373280423891018672348497668235089863388587925628302755995657524455507255189313690836254779186948667994968324049705821028513185451396213837722826145437693412532098591327667236328125E-647", rc_BigDecimal.toString());
  }
  public void testItem_0090()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0092()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0093()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).max(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0094()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";0Y=BB5O8E@J3X3K07HA52WQP<PK1HI@W2J7IR1G04RA163CY6MK?<UC7N=8IVX9LF:R@NM:>A3RQPPQJ1N1EYEEI2;HUY?S?QVG", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0095()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).pow(1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0096()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E+1")).hashCode();
//    Assert.assertEquals(92, rc_int);
//  }
  public void testItem_0097()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("3E+1"));
  }
  public void testItem_0099()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0103()
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
  public void testItem_0104()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\234', '\234', '8', '\1', '\uFFFF', '\1', '\1', '\234', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\234', '\0', '\234', '\0', '\0', '\234', '\0', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\234', '8', '\234', '\uFFFF', '\1', '\0', '\0', '\234', '\0', '\0', '\234', '\234', '8', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '8', '\234', '\0', '8', '8', '\1', '\1', '\234', '\uFFFF', '\0', '\0', '\0', '\0', '\1', '8', '\uFFFF', '8', '8', '\234', '\0', '\234', '\0', '\234', '\0', '\234', '\0', '\1', '\uFFFF', '\1', '\1', '\1', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0105()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigIntegerExact();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0106()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<32HT18ANPX48CME?LF3@UKV301;1BVXR3FBV@U28543=1SKBH<L<;UB>:55ABVVAKFELY97DSCXL7QMTA41OAW<", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0107()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0108()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0109()
  {
    rc_BigDecimal_array = (new BigDecimal("-2.4703282292062327208828439643411068618252990130716238221279284125033775363510437593264991818081799618989828234772285886546332835517796989819938739800539093906315035659515570226392290858392449105184435931802849936536152500319370457678249219365623669863658480757001585769269903706311928279558551332927834338409351978015531246597263579574622766465272827220056374006485499977096599470454020828166226237857393450736339007967761930577506740176324673600968951340535537458516661134223766678604162159680461914467291840300530057530849048765391711386591646239524912623653881879636239373280423891018672348497668235089863388587925628302755995657524455507255189313690836254779186948667994968324049705821028513185451396213837722826145437693412532098591327667236328125E-647")).divideAndRemainder(new BigDecimal("-2.4703282292062327208828439643411068618252990130716238221279284125033775363510437593264991818081799618989828234772285886546332835517796989819938739800539093906315035659515570226392290858392449105184435931802849936536152500319370457678249219365623669863658480757001585769269903706311928279558551332927834338409351978015531246597263579574622766465272827220056374006485499977096599470454020828166226237857393450736339007967761930577506740176324673600968951340535537458516661134223766678604162159680461914467291840300530057530849048765391711386591646239524912623653881879636239373280423891018672348497668235089863388587925628302755995657524455507255189313690836254779186948667994968324049705821028513185451396213837722826145437693412532098591327667236328125E-647"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0110()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).compareTo(new BigDecimal("-2.4703282292062327208828439643411068618252990130716238221279284125033775363510437593264991818081799618989828234772285886546332835517796989819938739800539093906315035659515570226392290858392449105184435931802849936536152500319370457678249219365623669863658480757001585769269903706311928279558551332927834338409351978015531246597263579574622766465272827220056374006485499977096599470454020828166226237857393450736339007967761930577506740176324673600968951340535537458516661134223766678604162159680461914467291840300530057530849048765391711386591646239524912623653881879636239373280423891018672348497668235089863388587925628302755995657524455507255189313690836254779186948667994968324049705821028513185451396213837722826145437693412532098591327667236328125E-647"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0111()
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
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("-2.4703282292062327208828439643411068618252990130716238221279284125033775363510437593264991818081799618989828234772285886546332835517796989819938739800539093906315035659515570226392290858392449105184435931802849936536152500319370457678249219365623669863658480757001585769269903706311928279558551332927834338409351978015531246597263579574622766465272827220056374006485499977096599470454020828166226237857393450736339007967761930577506740176324673600968951340535537458516661134223766678604162159680461914467291840300530057530849048765391711386591646239524912623653881879636239373280423891018672348497668235089863388587925628302755995657524455507255189313690836254779186948667994968324049705821028513185451396213837722826145437693412532098591327667236328125E-647")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0E-324", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).stripTrailingZeros();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    rc_double = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).doubleValue();
    Assert.assertEquals(1.7976931348623157E308, rc_double, 0);
  }
  public void testItem_0115()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("I1K3U8A5GO=7;FICW92:FF8HV;LR@>QBPHA:>P4WXD@EBDEE>0TNB84FWREDT3D0JQ3MXE:?58==IBLHH6X=PIT3OQ;C2A:", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0116()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0117()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0118()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-1074")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    rc_long = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0121()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).precision();
    Assert.assertEquals(751, rc_int);
  }
  public void testItem_0122()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2.4703282292062327208828439643411068618252990130716238221279284125033775363510437593264991818081799618989828234772285886546332835517796989819938739800539093906315035659515570226392290858392449105184435931802849936536152500319370457678249219365623669863658480757001585769269903706311928279558551332927834338409351978015531246597263579574622766465272827220056374006485499977096599470454020828166226237857393450736339007967761930577506740176324673600968951340535537458516661134223766678604162159680461914467291840300530057530849048765391711386591646239524912623653881879636239373280423891018672348497668235089863388587925628302755995657524455507255189313690836254779186948667994968324049705821028513185451396213837722826145437693412532098591327667236328125E-647")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).max(new BigDecimal("0"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0126()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 0, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0128()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0129()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), 0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0130()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0132()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0133()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0134()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0135()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0136()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0137()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\1', '\234', '\0', '\0', '\1', '\1', '\uFFFF', '\0', '\1', '8', '8'}, 2147483647, -2147483648, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0138()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).ulp();
    Assert.assertEquals("1E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(-1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0143()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0144()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0145()
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
  public void testItem_0146()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0147()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0148()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("8PIO@PP?46P02X3IE1CFN7NBR<E1;H31M5UBP3HIP5FJ?QHS6I96PTJ?VR;8>XDG8TO9<7RJN<FY1E:E8MM6JSJ?84:T>?UIQDV?", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0151()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0153()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0154()
  {
    rc_BigDecimal = (new BigDecimal("64")).setScale(0);
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0156()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0157()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0158()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("64")).setScale(2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0159()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0160()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0161()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0163()
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
  public void testItem_0164()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0165()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).negate();
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0168()
  {
    rc_boolean = (new BigDecimal("-1135879015891")).equals("KGAYDN7JD1:8N0P8VDLG;IJBEP9Y5R?RO6IJPVO:O2R:04A;5<9=TQ6K2BI09DQ;2=R5G3MAAUPQXWJHNQ@U1SXP<:QW7ONMLANP");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0169()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0170()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0171()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1135879015891")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0172()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("=78?NG@UATSE:ELCJETU<MX=Y8OS>?K=F8GDK:WIHSRH9G9J33DJQ5WO@IK@JOM;W;QQVFGF0?");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0173()
  {
    rc_BigInteger = (new BigDecimal("1135879015891")).unscaledValue();
    Assert.assertEquals("1135879015891", rc_BigInteger.toString());
  }
  public void testItem_0174()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0175()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1135879015891"));
  }
  public void testItem_0176()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0177()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0178()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("2147483647"), 2147483647, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0179()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0180()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\1', '\1', '\234', '\234', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\1', '\0', '\1', '\1', '8', '\234', '\0', '\234', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\1', '8', '\uFFFF', '8', '\1', '\234', '\1', '\1', '8', '\1', '\234', '\0', '\1', '\1', '\234', '\234', '\1', '\1', '\0', '\0', '\234', '\uFFFF', '\1', '\1', '\0', '\234', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '\0', '8', '\0', '\uFFFF', '8', '\0', '\234', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '8', '\1', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\1', '\0', '\234'}, -1, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0181()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0183()
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
  public void testItem_0184()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0186()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0187()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0188()
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
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("2.147483647E+2147483656", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0192()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0195()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).subtract(new BigDecimal("0.1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0198()
  {
    rc_long = (new BigDecimal("0E+1")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0199()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0201()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("0.1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    rc_double = (new BigDecimal("0E+1")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0203()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0204()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0207()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.0")).hashCode();
//    Assert.assertEquals(1, rc_int);
//  }
  public void testItem_0208()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\1', '\0', '\1', '8', '\0', '\0', '\1', '8', '8', '8', '\uFFFF', '\234', '8', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '8', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\1', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\0', '\234', '\234', '\0', '\0', '\uFFFF', '\1', '\234', '\1', '\0', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '8', '\234', '\234', '\0', '\234', '\0', '\1', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\1', '\1', '\1', '\234', '\1'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0213()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("-1"), 2147483647, java.math.RoundingMode.HALF_EVEN);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0214()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0215()
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
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-2.14748365E+9", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0220()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("-2147483648"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026181977374720", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0223()
  {
    rc_boolean = (new BigDecimal("0E+1")).equals("IPQV:LGRKL@XJIYLOF3UX5YI3UCRH>M6<X4U?;14E>DLF<5BEVJSS@2AXARSWRTWQB4X:UO5HUA?5451P7E4NEI9N:QH<;LOBH1F");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0224()
  {
    rc_String = (new BigDecimal("-2147483648")).toString();
    Assert.assertEquals("-2147483648", rc_String);
  }
  public void testItem_0225()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0226()
  {
    rc_long = (new BigDecimal("0E+1")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toPlainString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("9223372036854775807")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0231()
  {
    rc_short = (new BigDecimal("0.0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).subtract(new BigDecimal("00.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
//  public void testItem_0233()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).ulp();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0234()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9E+18")).add(new BigDecimal("1E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).abs();
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0237()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("9223372036854775807"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0238()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0240()
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
  public void testItem_0241()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\1', '\234', '\1', '\234', '8', '\234', '\1', '\0', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\0', '8', '\0', '\1', '8', '8', '\1', '\uFFFF', '\234', '\1', '8', '\1', '8', '\0', '\0', '\1', '\uFFFF', '\1', '\234', '\1', '8', '\234', '\1', '8', '\234', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\0', '8', '\0', '\1', '\uFFFF', '\0', '8', '\1', '8', '\234', '8', '\1', '\0', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\1', '\0', '\0', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\234', '8', '8', '\1', '8', '\uFFFF', '\234', '8', '\1', '8', '\0', '\1', '8', '\0', '\1', '\uFFFF', '\0', '\1', '\234', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\1'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0242()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).round(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0243()
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
  public void testItem_0244()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).movePointRight(-1);
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0246()
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
  public void testItem_0247()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).compareTo(new BigDecimal("9E+18"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0248()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).min(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0250()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("9223372036854775807"), -2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0251()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("1E+2147483647")).intValue();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0252()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).round(new MathContext("precision=2147483647 roundingMode=DOWN"));
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0253()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
//  public void testItem_0254()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1E+2147483647"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0255()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).hashCode();
//    Assert.assertEquals(1240908815, rc_int);
//  }
  public void testItem_0256()
  {
    rc_BigInteger = (new BigDecimal("1E+2147483647")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0257()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9E+18")).divide(new BigDecimal("1E+2147483647"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0259()
  {
    rc_boolean = (new BigDecimal("32")).equals("S98TBFW>A8=5V9=5?WM3V>REY>A03B1GC;?R;2<0:II:Y65BM:OPCL2BMNB:D68RN0B75NGMMQ8;<653KL:E<W3AIY=<ATE6LFUQ");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0260()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0261()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("=K");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0262()
  {
    rc_double = (new BigDecimal("9223372036854775807")).doubleValue();
    Assert.assertEquals(9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0263()
  {
    rc_int = (new BigDecimal("9E+18")).scale();
    Assert.assertEquals(-18, rc_int);
  }
  public void testItem_0264()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\0', '\uFFFF', '\234', '\234', '\0', '\0', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\1', '\234', '8', '8', '\uFFFF', '\1', '8', '\1', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '8', '\1', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\1', '\0', '\234', '8', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '8', '8', '\0', '\1', '\234', '8', '\1', '\0', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\0', '\1', '\0', '\uFFFF', '\1', '8', '\234', '\1', '8', '8', '8', '\uFFFF', '8', '8', '8', '\0', '\0', '8', '\234', '8', '\1', '8', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\1', '8', '\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0265()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divideToIntegralValue(new BigDecimal("3.2"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0266()
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
  public void testItem_0267()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).max(new BigDecimal("0.1"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0269()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).divide(new BigDecimal("0.1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+19", rc_BigDecimal.toString());
  }
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).max(new BigDecimal("0.1"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).abs();
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
//  public void testItem_0272()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).add(new BigDecimal("1E+2147483647"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    Assert.assertEquals("2E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0273()
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
  public void testItem_0274()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0276()
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
  public void testItem_0277()
  {
    rc_String = (new BigDecimal("3.2")).toString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0278()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).plus();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0279()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0280()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).stripTrailingZeros();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0281()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).plus();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0282()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(">5YG5;S?F5X2E81IB13MXDF;BR@3:WBF60:TN>I>P9=W6?KWIWPYS434UP=KW:W97M1UWN3P=XDPDDGE?CSTQAH37AUKVF5JXC=V");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1E+2147483647"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0284()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9E+18")).add(new BigDecimal("1E+2147483647"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0285()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("1E+2147483647")).toString();
//    Assert.assertEquals("1E+2147483648", rc_String);
//  }
  public void testItem_0286()
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
  public void testItem_0287()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0288()
  {
    rc_int = (new BigDecimal("2E+2147483647")).compareTo(new BigDecimal("2E+2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0289()
  {
    rc_float = (new BigDecimal("1E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0290()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0291()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    rc_BigDecimal_array = (new BigDecimal("1E+2147483647")).divideAndRemainder(new BigDecimal("1E+2147483647"));
  }
//  public void testItem_0293()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483647")).movePointRight(-1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0294()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(1);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 2147483647, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0296()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\0', '\0', '\1', '\0', '\234', '8', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '8', '\0', '8', '8', '\1', '\1', '\0', '\234', '\uFFFF', '\234', '8', '\0', '8', '\1', '\1', '\uFFFF', '\0', '8', '\1', '\1', '\1', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\234', '\234', '\1', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '8', '8', '8', '\234', '8', '\234', '\uFFFF', '\234', '\0', '8', '\234', '\1', '8', '\234', '\234', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '8', '\0', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\234', '\0', '\234', '\1', '8', '\uFFFF', '\0'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0297()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).divide(new BigDecimal("0"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, 0);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0299()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("2E+2147483647")).remainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
//    Assert.assertEquals("2E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0300()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0301()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
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
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0304()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).max(new BigDecimal("2E+2147483647"));
//    Assert.assertEquals("2E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0305()
  {
    rc_int = (new BigDecimal("1E+2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0307()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).add(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0308()
  {
    rc_BigInteger = (new BigDecimal("2E+2147483647")).unscaledValue();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
//  public void testItem_0309()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("1E+2147483647")).toString();
//    Assert.assertEquals("1E+2147483648", rc_String);
//  }
  public void testItem_0310()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0312()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2E+2147483647")).movePointLeft(1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0313()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toPlainString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
//  public void testItem_0314()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1E+2147483647")).scale();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
//  public void testItem_0315()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("2E+2147483647"), 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0316()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("2E+2147483647")).remainder(new BigDecimal("2E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0317()
  {
    rc_int = (new BigDecimal("2E+2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0318()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("02YQ3:95PLKFVQW8I=2D=S<SP4G4RR3N:US72Q2BJEJCAT:G?OS93YWNSTELV7TIW?YMG2T;<XK0QNT0GLXQ;W>=<>3QNVGOG::G");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0322()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0327()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0328()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0329()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0330()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0331()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("32"));
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0333()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0335()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).divide(new BigDecimal("-1.0"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0337()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0339()
  {
    rc_int = (new BigDecimal("1.0")).intValue();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0340()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0341()
  {
    rc_int = (new BigDecimal("1E+2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0342()
  {
    rc_boolean = (new BigDecimal("-1")).equals("A58;CU6447ENWJQ812;XB5MSWR?BR5OY186;=UBG1:<M756@TU:>EV7WEGF=<5<SJ3FY?TVO5F2<R=GR=5<S1BR;DW9WU<7A0WUE");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0343()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0344()
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
  public void testItem_0345()
  {
    rc_long = (new BigDecimal("-1.0")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
//  public void testItem_0346()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483647")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0347()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0349()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.0")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0350()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0351()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).setScale(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0356()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_int = (new BigDecimal("1.0")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0358()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0359()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0360()
  {
    rc_boolean = (new BigDecimal("-1")).equals("C1DYJYGX<?CVC>NTHI<FRUKDA=NR7O9HGR26D90XENS10HQ2VE36@YABEWS<5QE709X@QXU>MRAAUL5RHHOUJ;N0YXWBDG6W6GQM");
    Assert.assertEquals(false, rc_boolean);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0361()
  {
    rc_boolean = (new BigDecimal("0E+1")).equals("0W=WLMHYEME?KRG5X0MSFT4XXEQGD;P1FM3@<SCV65;5M;WWUI1=4KK75NO08NE3?8AMQOB5U>YXWVQEBF1X7UAQ36<Q=7L0R0R2");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0362()
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
  public void testItem_0363()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0364()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0370()
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
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0372()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0373()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0374()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 1, 0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0377()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0380()
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
  public void testItem_0381()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0382()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0384()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E+1"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0385()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0386()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0387()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0391()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0392()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0395()
  {
    rc_boolean = (new BigDecimal("0E-2147483647")).equals("HTBG2PE1P32RVOUW7;NN812WGAX1?I784ODDC?TC6KL2CA?I:A5P:KG<2<N9VYH2QYW8:V94XETQRVVX2CMFNV=@JL7PUJ1P:3V1");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0396()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0397()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0398()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0399()
  {
    rc_String = (new BigDecimal("10")).toString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0400()
  {
    rc_int = (new BigDecimal("10")).compareTo(new BigDecimal("10"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0401()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("WBNW7W8;QHCJ=2U=5IK8RNDVC:7VR9HR?=N2I6ONTXCFXPNWEDI1;OWLSP3DA815?D735PWFNQACX7C6SNF>:O56JGO@96LP8P<?", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0403()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0406()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0407()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0408()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0'}, -2147483648, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0409()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toString();
    Assert.assertEquals("0E-2147483647", rc_String);
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("10")).plus();
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0412()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0413()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0414()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0415()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toEngineeringString();
    Assert.assertEquals("0.0E-2147483646", rc_String);
  }
  public void testItem_0416()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0417()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("10")).stripTrailingZeros();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_BigDecimal = (new BigDecimal("10")).subtract(new BigDecimal("10"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toEngineeringString();
    Assert.assertEquals("0.0E-2147483646", rc_String);
  }
  public void testItem_0421()
  {
    rc_long = (new BigDecimal("1E+1")).longValueExact();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0423()
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
  public void testItem_0424()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0425()
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
  public void testItem_0426()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0427()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10")).divideToIntegralValue(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0428()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0429()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0430()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\1', '\1', '\1', '8', '\234', '\234', '\234', '8', '\1', '\234', '8', '\uFFFF', '\1', '\1', '\1', '\234', '\234', '8', '\234', '\uFFFF', '8', '8', '8', '\0', '\1', '\uFFFF', '8', '8', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\0', '\1', '\1', '\0', '\1', '\0', '\uFFFF', '\1', '8', '\234', '\0', '\uFFFF', '\0', '\1', '\0', '\234', '\1', '\1', '\1', '\234', '8', '\uFFFF', '\1', '\1', '\0', '\1', '\0', '\0', '8', '8', '\1', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0432()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\0', '8', '\uFFFF', '8', '\1', '\uFFFF', '\234', '8', '\0', '8', '\1', '\234', '\234', '\1', '\234', '\1', '\1', '8', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\1', '\0', '8', '\234', '8', '\1', '8', '\0', '\234', '\1', '\0', '8', '\0', '\234', '\1', '\234', '\uFFFF', '8', '\uFFFF', '8', '\0', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\1', '8', '8', '\0', '\0', '\234', '8', '\1', '\1', '8', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0433()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0434()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\0', '\1', '8', '\uFFFF', '8', '\uFFFF', '\1', '\1', '8', '8', '\0', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\234', '\234', '\234', '8', '8', '\1', '8', '\0', '\0', '\1', '\234', '8', '\0', '8', '8', '8', '\uFFFF', '\234', '\1', '8', '\1', '\1', '8', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '8', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '8', '8', '\1', '8', '8', '\234', '\234', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\234', '8', '\uFFFF', '\234', '\234', '\234', '8', '\0', '\1'}, 0, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0437()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0440()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("-9223372036854775808"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_String = (new BigDecimal("8")).toPlainString();
    Assert.assertEquals("8", rc_String);
  }
  public void testItem_0442()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("Y1000W>UPD89R;8UB9>4CYKVE>8LEC6XPJQCG6CF@P2?:;VO??TL@EWOJA073Q85WY2ADAR6E4JV;@DTB<2M:?PLMDVOK19BLI<3");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0443()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0444()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0445()
  {
    rc_BigDecimal = (new BigDecimal("8")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
//  public void testItem_0446()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("1"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0447()
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
  public void testItem_0448()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).min(new BigDecimal("8"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    rc_long = (new BigDecimal("-9223372036854775808")).longValue();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  public void testItem_0450()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0451()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0454()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-9223372036854775808")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0455()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\234', '8', '\1', '\0', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\0', '8', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\234', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\0', '8', '\0', '\0', '\1', '\uFFFF', '8', '\234', '\234', '\1', '\0', '\0', '\uFFFF', '\1', '8', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\234', '8', '\0', '8', '\1', '\1', '8', '8', '\uFFFF', '\0', '8', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\0', '\1', '\uFFFF', '\0', '\1'}, -1, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0456()
  {
    rc_int = (new BigDecimal("-8")).intValue();
    Assert.assertEquals(-8, rc_int);
  }
  public void testItem_0457()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-3.4694469519536141888238489627838134765625E-18", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0463()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0464()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0465()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigIntegerExact();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0466()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).multiply(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-295147905179352825856", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0469()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0470()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-295147905179352825856")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0471()
  {
    rc_BigDecimal = (new BigDecimal("-295147905179352825856")).divide(new BigDecimal("32"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-295147905179352825856"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_float = (new BigDecimal("-9223372036854775808")).floatValue();
    Assert.assertEquals(-9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0477()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\234', '\1', '\0', '\1', '\234', '\0', '\0', '\1', '8', '\uFFFF', '\234', '\0', '\234', '8', '\0', '\uFFFF', '\0', '\1', '\1', '\0', '8', '8', '8', '\0', '8', '\0', '\0', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '8', '8', '\234', '8', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\0', '8', '8', '\uFFFF', '\1', '\234', '8', '\0', '\0', '\1', '8', '\234', '\234', '\234', '\234', '8', '\1', '\234', '\234', '\234', '\1', '8'}, -2147483648, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0478()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("0.1")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0479()
  {
    rc_String = (new BigDecimal("0.1")).toEngineeringString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0480()
  {
    rc_double = (new BigDecimal("-9223372036854775808")).doubleValue();
    Assert.assertEquals(-9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0481()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0482()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divideToIntegralValue(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0483()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).setScale(0, 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0485()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0489()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0490()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
//  public void testItem_0491()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).setScale(2147483647, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0492()
  {
    rc_double = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).doubleValue();
    Assert.assertEquals(4.9E-324, rc_double, 0);
  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0495()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0496()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toPlainString();
    Assert.assertEquals("0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_String);
  }
  public void testItem_0497()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    rc_int = (new BigDecimal("9223372036854775807")).precision();
    Assert.assertEquals(19, rc_int);
  }
  public void testItem_0499()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), -2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0500()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("7;B0QK14SUR6=6=SJWYO717TUUT6QNT6E;BKSHGD71VYH9=1W1OP6UHMP>>9K47UOBLS5G6YJ?TOXK1YQX8T4E=W93QXT");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0504()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0505()
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
  public void testItem_0506()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0507()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(2147483647);
    Assert.assertEquals("-1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toEngineeringString();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_String);
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=2147483647 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0512()
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
  public void testItem_0513()
  {
    rc_int = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).precision();
    Assert.assertEquals(324, rc_int);
  }
  public void testItem_0514()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0515()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("-1E-2147483647"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0516()
  {
    rc_BigDecimal = (new BigDecimal("-1E-2147483647")).negate();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_BigDecimal = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).pow(1);
    Assert.assertEquals("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    rc_long = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0519()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0520()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\uFFFF', '8', '\uFFFF', '8', '\234', '\uFFFF', '8', '\234', '\0', '\234', '\uFFFF', '8', '\0', '8', '\0', '8', '\0', '\234', '\234', '\234', '\0', '\234', '\1', '\0', '\234', '\0', '\1', '\234', '\1', '\0', '8', '\1', '\0', '\0', '\uFFFF', '\234', '\234', '\1', '8', '\234', '\0', '\1', '8', '\0', '\1', '\234', '8', '\uFFFF', '\uFFFF', '8', '8', '8', '8', '\1', '8', '\1', '\uFFFF', '\234', '\0', '8', '8', '\1', '8', '\0', '\234', '\234', '\uFFFF', '8', '8', '8', '\234', '\234', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\234', '\0', '8', '\uFFFF', '8'}, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0521()
  {
    rc_boolean = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0522()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-1E-2147483647")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0523()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0524()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-1E-2147483647")).toBigInteger();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0525()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideAndRemainder(new BigDecimal("-1E-2147483647"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).negate();
    Assert.assertEquals("-202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_BigDecimal = (new BigDecimal("-1E-2147483647")).divide(new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0528()
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
  public void testItem_0529()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E-2147483647")).divide(new BigDecimal("-1E-2147483647"), -2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0531()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(1);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0532()
  {
    rc_BigDecimal = (new BigDecimal("-1E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0533()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).negate();
    Assert.assertEquals("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    rc_String = (new BigDecimal("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toString();
    Assert.assertEquals("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_String);
  }
  public void testItem_0535()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0536()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
//  public void testItem_0537()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1E-2147483647")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0538()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-1E-2147483647"), new MathContext("precision=2147483647 roundingMode=CEILING"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0539()
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
  public void testItem_0540()
  {
    rc_int = (new BigDecimal("-1E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0541()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0542()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\1', '\1', '8', '\1', '\1', '\234', '8', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\234', '\234', '\1', '\1', '\uFFFF', '8', '\0', '8', '\234', '\uFFFF', '\1', '\234', '\1', '\1', '\1', '8', '\0', '\0', '\234', '\234', '\uFFFF', '\1', '8', '8', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\234'}, -1, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0543()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0544()
  {
    rc_boolean = (new BigDecimal("0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0545()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0546()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("HAX6T2?TM:4K66N1J7Y>DB8LUCYU6;M6;L63GYNWICJ47KQPN=7A5MBBTEF1J=EJF=3=442M=:8C9LBRYQ>:;D?376TOXEV<UOD0", new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0547()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '8', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\234', '\1', '\1', '8', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\0', '\0', '\234', '8', '\234', '\1', '8', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\234', '\0', '8', '8', '\uFFFF', '\1', '\0', '\1', '\234', '\uFFFF', '\0', '8', '8', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\0', '8', '\0', '\uFFFF', '8', '\1', '\1', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\0', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\1', '\1', '\234', '8', '\uFFFF', '\1', '\1', '\234', '8', '\1', '\1', '\1', '8', '8', '8', '\0', '\1', '\1', '8', '\1', '\1'}, 1, 1);
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0549()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0550()
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
//  public void testItem_0551()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1E-2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0552()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0553()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E-2147483647")).movePointRight(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0555()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).compareTo(new BigDecimal("-1E-2147483647"));
    Assert.assertEquals(1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0556()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("LE70S09C;:GEELTS;0DU>4OAW>6BUNL:7HX?RM5NN2V:WRR;@:6XHH9OFSS1MV@4<MFK?3IK4WJF?H196RC4UOK5<UQBUA8;8HS2");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_String = (new BigDecimal("-1E-2147483647")).toEngineeringString();
    Assert.assertEquals("-100E-2147483649", rc_String);
  }
//  public void testItem_0560()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1E-2147483647"), java.math.RoundingMode.DOWN);
//    Assert.assertEquals("0", rc_BigDecimal.toString());
//  }
  public void testItem_0561()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\234', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\234', '\0', '8', '8', '\234', '\0', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '8', '8', '\234', '\0', '\0', '\0', '\1', '\0', '\0', '8', '\234', '\0', '\1', '8', '8', '\1', '\0', '\1', '\1', '\1', '8', '8', '\uFFFF', '\234'}, -1, 2147483647, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0562()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0565()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0566()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0567()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0568()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0569()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toPlainString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0571()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0572()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0576()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0577()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0578()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0581()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0582()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0583()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=0 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0584()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0585()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=1 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0587()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("0E-1074"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0590()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0592()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("AHMU0OW?HCIPJ9OHL>Q34:XBV5PDY8V;");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0593()
  {
    rc_BigDecimal = (new BigDecimal("-32")).stripTrailingZeros();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0594()
  {
    rc_BigInteger = (new BigDecimal("-32")).toBigInteger();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0595()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).divide(new BigDecimal("-32"), 0, 0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    rc_BigDecimal = (new BigDecimal("-32")).remainder(new BigDecimal("-32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0598()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-32")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0599()
  {
    rc_String = (new BigDecimal("-32")).toPlainString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0600()
  {
    rc_short = (new BigDecimal("-32")).shortValueExact();
    Assert.assertEquals(-32, rc_short);
  }
  public void testItem_0601()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0604()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divideToIntegralValue(new BigDecimal("-32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0608()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0609()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0610()
  {
    rc_double = (new BigDecimal("-32")).doubleValue();
    Assert.assertEquals(-32.0, rc_double, 0);
  }
  public void testItem_0611()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("-32")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_int = (new BigDecimal("-32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0615()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LM=EBF1>M?>SOWIHUIN4M3PIGBNDVV4FRI8>3XLD125P8AXWNF:H41VIAX:8F9I?K7137PD4WH7FP20AW:7GIIQE2T8@1WXA<N4F");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0616()
  {
    rc_short = (new BigDecimal("-32")).shortValueExact();
    Assert.assertEquals(-32, rc_short);
  }
  public void testItem_0617()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("-32"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_String = (new BigDecimal("-32")).toPlainString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-102.4", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=UP"));
  }
  public void testItem_0624()
  {
    rc_short = (new BigDecimal("-32")).shortValueExact();
    Assert.assertEquals(-32, rc_short);
  }
  public void testItem_0625()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0626()
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
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
//  public void testItem_0629()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\234', '\234', '8', '\0', '\234', '\0', '\1', '\1', '\0', '\234', '\0', '\0', '\1', '\1', '\1', '\1', '\0', '\0', '\uFFFF', '8', '\uFFFF', '8', '8', '\0', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '8', '8', '8', '8', '\234', '8', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\0', '\1', '\1', '\1', '\0', '\234', '8', '\0', '\0', '8', '\1', '\1', '\1', '8', '8', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\0', '\1', '\1', '8', '\1', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF'}, 1, 2147483647, new MathContext("precision=1 roundingMode=FLOOR"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0630()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0631()
  {
    rc_BigDecimal = (new BigDecimal("-32")).negate();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0632()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0633()
  {
    rc_BigDecimal = (new BigDecimal("-32")).subtract(new BigDecimal("3.2"));
    Assert.assertEquals("-35.2", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0634()
  {
    rc_boolean = (new BigDecimal("-32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0635()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-102.4")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0636()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0638()
  {
    rc_int = (new BigDecimal("-32")).intValueExact();
    Assert.assertEquals(-32, rc_int);
  }
  public void testItem_0639()
  {
    rc_BigInteger = (new BigDecimal("-32")).toBigInteger();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("-35.2")).remainder(new BigDecimal("-35.2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("-35.2")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("-35.0", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-0.03125")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0644()
  {
    rc_float = (new BigDecimal("-35.0")).floatValue();
    Assert.assertEquals(-35.0F, rc_float, 0);
  }
  public void testItem_0645()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0646()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0647()
  {
    rc_BigDecimal = (new BigDecimal("-35.0")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-1.1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0648()
  {
    rc_boolean = (new BigDecimal("3.2E+2")).equals("PH75BENWFKMJEWOYXIRFJ3@QWKN?@PM83<BJ?SURUP<=:C1>8A9Y2FJN5M1UWRNFEN5J:;5:@20SQ7:");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0649()
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
  public void testItem_0650()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.1")).divide(new BigDecimal("-1.1"), -2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0651()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0653()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0654()
  {
    rc_String = (new BigDecimal("-1.1")).toPlainString();
    Assert.assertEquals("-1.1", rc_String);
  }
  public void testItem_0655()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("-35.0"), -1, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("-1.1")).negate();
    Assert.assertEquals("1.1", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("-35.0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0659()
  {
    rc_long = (new BigDecimal("-4E+1")).longValue();
    Assert.assertEquals(-40L, rc_long);
  }
  public void testItem_0660()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0661()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0662()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-35.0")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0663()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\0', '\234', '8', '\1', '\0', '8', '8', '8', '\1', '\0', '\0', '8', '\0', '\uFFFF', '\0', '\1', '\1', '8', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '8', '\0', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\1', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\1', '\0', '\1', '\0', '\0', '\234', '\1', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\234', '\0', '\1', '8', '\1', '\234', '\1', '\234', '\0', '\1', '8', '\234', '8'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0664()
  {
    rc_String = (new BigDecimal("-35.0")).toPlainString();
    Assert.assertEquals("-35.0", rc_String);
  }
  public void testItem_0665()
  {
    rc_BigDecimal = (new BigDecimal("-35.0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("35.0", rc_BigDecimal.toString());
  }
  public void testItem_0666()
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
  public void testItem_0667()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\234', '\234', '\0', '\1', '\uFFFF', '\1', '\0', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '8', '8', '\234', '\uFFFF', '8', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\1', '\0', '\234', '\1', '\1', '\234', '\0', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0668()
  {
    rc_BigDecimal = (new BigDecimal("-35.0")).min(new BigDecimal("-4E+1"));
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    rc_BigDecimal = (new BigDecimal("-35.0")).scaleByPowerOfTen(1);
    Assert.assertEquals("-350", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-350"), -1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_BigDecimal = (new BigDecimal("-35.0")).stripTrailingZeros();
    Assert.assertEquals("-35", rc_BigDecimal.toString());
  }
  public void testItem_0675()
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
  public void testItem_0676()
  {
    rc_float = (new BigDecimal("-35")).floatValue();
    Assert.assertEquals(-35.0F, rc_float, 0);
  }
  public void testItem_0677()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0678()
  {
    rc_boolean = (new BigDecimal("35.0")).equals("5J9O>0RY8@3DE0SVBC95OGHBA97OKJY@E;:KK?FM:=3");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0679()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(-2147483648);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = (new BigDecimal("-35")).add(new BigDecimal("-35"));
    Assert.assertEquals("-70", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-70"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    rc_int = (new BigDecimal("0E-2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0684()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
//  public void testItem_0687()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483647")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    rc_int = (new BigDecimal("0E+1")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0691()
  {
    rc_BigDecimal = (new BigDecimal("-35")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0692()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("-4E+1"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0693()
  {
    rc_BigInteger = (new BigDecimal("-4E+1")).toBigInteger();
    Assert.assertEquals("-40", rc_BigInteger.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0696()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("-70"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0697()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-70")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0698()
  {
    rc_long = (new BigDecimal("-70")).longValueExact();
    Assert.assertEquals(-70L, rc_long);
  }
  public void testItem_0699()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_BigDecimal = (new BigDecimal("-4E+1")).subtract(new BigDecimal("0E+1"));
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_String = (new BigDecimal("-4E+1")).toString();
    Assert.assertEquals("-4E+1", rc_String);
  }
  public void testItem_0702()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-4E+1")).divide(new BigDecimal("0E+1"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0703()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("-70"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0704()
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
  public void testItem_0705()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0706()
  {
    rc_double = (new BigDecimal("-4E+1")).doubleValue();
    Assert.assertEquals(-40.0, rc_double, 0);
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("-4E+1")).min(new BigDecimal("-4E+1"));
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).pow(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\uFFFF', '\0', '\0', '8', '8', '\1', '\234', '\uFFFF', '\234', '\234', '\1', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '8', '8', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '8', '\0', '\uFFFF', '\0', '\1', '\0', '8', '\234', '\uFFFF', '\234', '\234', '\0', '8', '\1', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '8', '\1', '8', '\234', '\0', '\234', '\234', '\0', '\234', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0712()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), 2147483647, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0713()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0714()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0717()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0"), java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0718()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '8', '8', '\0', '8', '8', '\234', '\1', '\0', '\1', '\uFFFF', '8', '8', '8', '8', '8', '\1', '8', '\234', '\1', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\1', '\1', '8', '\0', '\1', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\uFFFF', '8', '8', '\234', '\234', '\234', '\0', '8', '8', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\234', '\0', '\0', '\uFFFF', '\0', '\234', '\234', '\234', '\1', '\0', '\0', '\234', '8', '8', '\1', '\0', '\1', '8', '\234', '\1', '\1', '\234', '\1', '\1', '\uFFFF', '\1', '\234', '\234', '\234', '\1', '8', '\1', '\1', '\234', '\uFFFF', '\0', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\0', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0721()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("E9EPIG");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0722()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '\0', '\1', '\234', '\234', '\234', '\234', '\234', '\0', '8', '\0', '\234', '\uFFFF', '8', '8', '\uFFFF', '8', '8', '8', '8', '\234', '\0', '8', '8', '\1', '\1', '8', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\234', '\234', '\1', '\234', '\0', '\1', '8', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0723()
  {
    rc_int = (new BigDecimal("0E+1")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).stripTrailingZeros();
	Assert.assertEquals(0E+1, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0727()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0728()
  {
    rc_boolean = (new BigDecimal("3.2E+2")).equals("?QUNCCO;LNKOJCUX7U7ANM7Y85TLD86U5T5");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0729()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("=A9LT?MT?5G0");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0734()
  {
    rc_int = (new BigDecimal("0E+1")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0735()
  {
    rc_String = (new BigDecimal("0E+1")).toString();
    Assert.assertEquals("0E+1", rc_String);
  }
  public void testItem_0736()
  {
    rc_int = (new BigDecimal("3.2E+2")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0737()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0738()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0739()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).max(new BigDecimal("0E+1"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0743()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+1")).hashCode();
//    Assert.assertEquals(-1, rc_int);
//  }
  public void testItem_0744()
  {
    rc_BigInteger = (new BigDecimal("0E+2")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("34B>4EYM>HPBJ?I;F1=KPW>O:XURHYNKME0GSAD49NGSWN>7JDE=1N1?UUWXO4YSSS?4=8PHNTM=81K>554<PEB", new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0747()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    rc_short = (new BigDecimal("0E+1")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0750()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0754()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E+1"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0755()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0756()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '8', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\1', '\0', '\234', '\234', '\0', '\234', '\1', '\1', '\uFFFF', '\234', '\1', '\1', '\234', '\234', '8', '8', '\uFFFF', '8', '\0', '\0', '\234', '\234', '\1', '\0', '\0', '\234', '\0', '\234', '\uFFFF', '\0', '\1', '\1', '8', '\uFFFF', '\1', '\234', '\1', '8', '\0', '\0', '\234', '\234', '\1', '\0', '\234', '\1', '\uFFFF', '\1', '8', '\0', '\234', '\0', '\uFFFF', '\234', '8', '\1', '8', '\234', '\1', '8', '\234', '\uFFFF', '\234', '8', '\1', '\0', '8', '8', '\234', '8', '\0', '\uFFFF', '\234', '\0', '\234', '\234', '\234', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\1', '\234', '\234', '\234', '\uFFFF', '\0', '\0'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0E+1"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E+1"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0760()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("IUY:90A<;TMJXHQ2QWSK705P90:8K<HUTKOFF4A3=F=FDBV17>:W=M41?;7RY7ESVM@K0GX>SU@JV3S9S2X>1W>W3=0DXEI?RU:W");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0761()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0762()
  {
    rc_long = (new BigDecimal("0E-2147483646")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0763()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0764()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).multiply(new BigDecimal("0E+1"));
    Assert.assertEquals("0E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0767()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_float = (new BigDecimal("1E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0769()
  {
    rc_int = (new BigDecimal("0E+1")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0770()
  {
    rc_String = (new BigDecimal("1E-2147483647")).toString();
    Assert.assertEquals("1E-2147483647", rc_String);
  }
  public void testItem_0771()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0772()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0773()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("32"), java.math.RoundingMode.UP);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0774()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("3.2E+2"), 2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).setScale(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0777()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("0E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0779()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).plus(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("1E-2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0782()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0784()
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
  public void testItem_0785()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0786()
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
  public void testItem_0787()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0789()
  {
    rc_String = (new BigDecimal("1E-2147483647")).toString();
    Assert.assertEquals("1E-2147483647", rc_String);
  }
  public void testItem_0790()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0791()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0792()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).plus();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0794()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-2147483647")).multiply(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0795()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0796()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0799()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).plus();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0800()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0801()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).max(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("C=BIBX>SJBR6F:<T?6:VNXO04:<@U05OMXC0VPJ?BX;6EUY1:>81?JRWHQ7?8?:DK5=WGQ81<4I6ON=;<Y736>=PDS3S8F;R7<X5");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0808()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0809()
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
  public void testItem_0810()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0811()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("2E+9")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0812()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).plus();
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).abs(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).divideToIntegralValue(new BigDecimal("3"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("2E+9"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0819()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0820()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0821()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("2E+9"));
  }
  public void testItem_0822()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0823()
  {
    rc_boolean = (new BigDecimal("2E+9")).equals("8FF0W:X<P74<R6NUPI90:8S7TNIVJ>4VJM:WLB?92J55=FGM9H@W?UUITX6?:CYA=IRFKJ15D2WU<2:F3VTQ2TMSRR<B62MJKH7U");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0824()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-10", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0828()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0831()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("1E-2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0832()
  {
    rc_long = (new BigDecimal("3.2")).longValue();
    Assert.assertEquals(3L, rc_long);
  }
  public void testItem_0833()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0834()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0835()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0837()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0838()
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
  public void testItem_0839()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0840()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483647")).add(new BigDecimal("320.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0841()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).min(new BigDecimal("3E-2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0842()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0843()
  {
    rc_int = (new BigDecimal("1E-2147483647")).compareTo(new BigDecimal("1E-2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0844()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\234', '\0', '\234', '\234', '\234', '\uFFFF', '8'}, 1, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0845()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("=J6YS<JTL99STQM0QU05R1HR5=PS<27Q@@31Y8FM=QOU9V13<DE7ONKH8B?JS9K=C720W;?SJVFH98=W>TESXHI7OB>:OE4Y3HI0");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0846()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0847()
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
  public void testItem_0848()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3E-2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0849()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0850()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).movePointRight(2147483647);
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0852()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483647")).divide(new BigDecimal("3E-2147483647"), java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0853()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\0', '\234', '\234', '\0', '8', '8', '\1', '\234', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\0', '8', '\0', '\0', '8', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\0', '\1', '\1', '\1', '\234', '\1', '\234', '\0', '8', '8', '8', '8', '\234', '\1', '\234', '8', '\0', '\1', '\1', '\1', '8', '\1', '\1', '8', '\234', '\1', '\1', '\uFFFF', '\234', '\1', '\234', '\234', '\0', '\234', '\0', '8', '\0', '\234', '\234', '\1', '\1', '\1', '\uFFFF', '\0', '\0', '\234', '8', '\0', '\0', '8', '\uFFFF', '\234', '8', '8', '\uFFFF', '\1', '\234', '\1'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0854()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0855()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483647")).divide(new BigDecimal("3E-2147483647"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0856()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
//  public void testItem_0857()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("3E-2147483647"), -1, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0858()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0859()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).scaleByPowerOfTen(0);
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0860()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483647")).divide(new BigDecimal("3E-2147483647"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0861()
  {
    rc_BigInteger = (new BigDecimal("3E-2147483647")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0862()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).negate();
    Assert.assertEquals("-3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0863()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0864()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    rc_BigInteger = (new BigDecimal("3E-2147483647")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0866()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).movePointLeft(0);
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0868()
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
  public void testItem_0869()
  {
    rc_BigInteger = (new BigDecimal("3E-2147483647")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0870()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0871()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("A9N7");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0872()
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
  public void testItem_0873()
  {
    rc_BigDecimal_array = (new BigDecimal("2E+9")).divideAndRemainder(new BigDecimal("2E+9"));
  }
  public void testItem_0874()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0875()
  {
    rc_float = (new BigDecimal("2E+9")).floatValue();
    Assert.assertEquals(2.0E9F, rc_float, 0);
  }
  public void testItem_0876()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0877()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0878()
  {
    rc_int = (new BigDecimal("2E+9")).intValue();
    Assert.assertEquals(2000000000, rc_int);
  }
  public void testItem_0879()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0881()
  {
    rc_int = (new BigDecimal("0.0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0882()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.003", rc_BigDecimal.toString());
  }
//  public void testItem_0884()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).scaleByPowerOfTen(0);
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0885()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
//  public void testItem_0886()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0887()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0889()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("0.003"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0890()
  {
    rc_BigDecimal_array = (new BigDecimal("320.0E+2147483647")).divideAndRemainder(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0891()
  {
    rc_BigInteger = (new BigDecimal("2E+9")).unscaledValue();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0892()
  {
    rc_BigInteger = (new BigDecimal("00.0E+2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0893()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).ulp();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0894()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\1', '\1', '\234', '\234', '\1', '\0', '8', '8', '\uFFFF', '\uFFFF', '8', '\0', '8', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\0', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '8', '\234', '\uFFFF', '8', '8', '\uFFFF', '8', '\1', '\234', '\0', '\0', '\1', '\234', '\234', '\234', '\1', '\1', '8', '\1', '8', '\234', '\uFFFF', '8', '\uFFFF', '8', '\0', '\234', '8', '\1', '\0', '\1', '\0', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\0', '\1', '\1', '8', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\0', '\uFFFF', '8'}, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0897()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0898()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0899()
  {
    rc_int = (new BigDecimal("2E+9")).intValueExact();
    Assert.assertEquals(2000000000, rc_int);
  }
  public void testItem_0900()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1E+12"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0901()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0902()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).min(new BigDecimal("1"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0903()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("9YS>C7A>DIIRKRIE2@FX<3<TI5M0>XG8NJ;36JY50O2LJU>3KH=1=7LKIGN8P?@");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0904()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1E+12")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0905()
  {
    rc_long = (new BigDecimal("1E+12")).longValueExact();
    Assert.assertEquals(1000000000000L, rc_long);
  }
  public void testItem_0906()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0907()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0908()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("320.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("32", rc_BigInteger.toString());
//  }
//  public void testItem_0909()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("320.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("32", rc_BigInteger.toString());
//  }
  public void testItem_0910()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), 2147483647, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0911()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '8', '8', '\1', '\1'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0912()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).remainder(new BigDecimal("1"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1E+12"));
    Assert.assertEquals("1E-12", rc_BigDecimal.toString());
  }
//  public void testItem_0914()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+12")).remainder(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0915()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).scaleByPowerOfTen(1);
    Assert.assertEquals("1E+13", rc_BigDecimal.toString());
  }
  public void testItem_0916()
  {
    rc_int = (new BigDecimal("1E+13")).intValue();
    Assert.assertEquals(1316134912, rc_int);
  }
  public void testItem_0917()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0918()
//  {
//    boolean caught;
//    rc_BigDecimal_array = (new BigDecimal("320.0E+2147483647")).divideAndRemainder(new BigDecimal("1E+13"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3PV0GF=6OPOAPFO95OS=M@PI>=I");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0921()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0922()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0923()
  {
    rc_boolean = (new BigDecimal("1E+13")).equals("M3HJ<=K?;N3MR5SEDVEU7<C1::LWJHH2O717S6E<7T:GNONQY;KKH@ROEF?X=4<C>8PFMP;E6ELAND4:NL6=?@SX?<1A?3E;KQFH");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0924()
  {
    rc_BigDecimal_array = (new BigDecimal("3E-2147483647")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0925()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0927()
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
  public void testItem_0928()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0929()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0930()
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
  public void testItem_0931()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1E+13"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+13", rc_BigDecimal.toString());
  }
  public void testItem_0933()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    rc_int = (new BigDecimal("1E+13")).intValue();
    Assert.assertEquals(1316134912, rc_int);
  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("E;87MUCIPVRQ<EDGIE;GIQE5J;G=0SB=HKD=M0HE=X8R0QYU9NJYTI2=BXSFTFXB<MOKVD26R?;A0X4N99=MALGSXK9GB?V?7G45");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("3E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0939()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0940()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_int = (new BigDecimal("320.0E+2147483647")).compareTo(new BigDecimal("1"));
//    Assert.assertEquals(-1, rc_int);
//    }
//  }
  public void testItem_0941()
  {
    rc_float = (new BigDecimal("320.0E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
//  public void testItem_0942()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).multiply(new BigDecimal("1"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0943()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0944()
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
  public void testItem_0945()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0946()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0947()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0949()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3E-2147483647")).toBigInteger();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0950()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483647")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0951()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
//  public void testItem_0952()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), -2147483648, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0953()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '\0', '8', '\0', '\1', '\234', '\1', '\0', '8', '\0', '\0', '\0', '\234', '\234', '\1', '8', '\1', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\234', '\1', '\0', '8', '\0', '\uFFFF', '\0', '8', '\234', '\0', '\uFFFF', '8', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF'}, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0954()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0955()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0956()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";E>;8P:L:W210R6BCR@B75DPUR:XN43PMR6WK9A76FL?M7HT8P;XT7AO78G>OYT5J6UAY97OH1YTY;", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0957()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0958()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0959()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0960()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0961()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0962()
  {
    rc_boolean = (new BigDecimal("1135879015891")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0963()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3E-2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0964()
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
  public void testItem_0965()
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
  public void testItem_0966()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("1135879015891"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0967()
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
  public void testItem_0968()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=0 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0969()
  {
    rc_int = (new BigDecimal("9223372036854775807")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0970()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0971()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
//  public void testItem_0973()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("9223372036854775807"), 2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0974()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("9223372036854775807"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0975()
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
  public void testItem_0976()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    rc_int = (new BigDecimal("-9E+18")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0978()
  {
    rc_BigInteger = (new BigDecimal("-9E+18")).unscaledValue();
    Assert.assertEquals("-9", rc_BigInteger.toString());
  }
  public void testItem_0979()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0981()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0982()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0983()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).add(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0985()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-9E+18"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0986()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).add(new BigDecimal("-9E+18"));
    Assert.assertEquals("-1.8E+19", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1.8E+19"), 1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0989()
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
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).multiply(new BigDecimal("-1.8E+19"));
    Assert.assertEquals("1.62E+38", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divideToIntegralValue(new BigDecimal("1135879015891"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0992()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0994()
  {
    rc_int = (new BigDecimal("0.0")).compareTo(new BigDecimal("0.0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0995()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9E+18")).divide(new BigDecimal("0.0"), 0, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0996()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.8E+19")).setScale(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0997()
  {
    rc_BigDecimal = (new BigDecimal("-1.8E+19")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+19", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0998()
  {
    rc_boolean = (new BigDecimal("-2E+19")).equals("W=XGW7SUW1DAK=DDR9N6BDI;F=S06NKU9LG:XLQ:IU2HBNY>2=Y4GB9DU");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0999()
  {
    rc_long = (new BigDecimal("-2E+19")).longValue();
    Assert.assertEquals(-1553255926290448384L, rc_long);
  }
}
