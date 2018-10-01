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
public class TestSuite048 extends TestCase
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
    rc_long = (new BigDecimal("-2147483647.0")).longValue();
    Assert.assertEquals(-2147483647L, rc_long);
  }
  public void testItem_0001()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647.0")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("-434655529093401218461441838722470022434200723968601606155384175955998831653927052022577199770681555252117379919336038406884427305993709021691184070102606719159605922059487066340485291248802875642445572795599373969936804876146151126282676454412395216535664755093436311010677518577878301323462229481803549562312878503053589946719797248.0", rc_BigDecimal.toString());
  }
  public void testItem_0004()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647.0")).divide(new BigDecimal("1"));
    Assert.assertEquals("-2147483647.0", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    rc_int = (new BigDecimal("-434655529093401218461441838722470022434200723968601606155384175955998831653927052022577199770681555252117379919336038406884427305993709021691184070102606719159605922059487066340485291248802875642445572795599373969936804876146151126282676454412395216535664755093436311010677518577878301323462229481803549562312878503053589946719797248.0")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0006()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
//  public void testItem_0007()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2E+9")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0008()
  {
    rc_BigDecimal_array = (new BigDecimal("-2147483647.0")).divideAndRemainder(new BigDecimal("-2147483647.0"));
  }
  public void testItem_0009()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0011()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0012()
  {
    rc_BigInteger = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-325")).unscaledValue();
    Assert.assertEquals("4940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigInteger.toString());
  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0015()
  {
    rc_boolean = (new BigDecimal("2E+9")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0016()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).add(new BigDecimal("2E+9"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4E+9", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0018()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-325")).stripTrailingZeros();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-325", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("4E+9")).divide(new BigDecimal("32"), 0);
    Assert.assertEquals("1E+9", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).subtract(new BigDecimal("2E+9"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_int = (new BigDecimal("4E+9")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0022()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0025()
  {
    rc_int = (new BigDecimal("3E+1")).compareTo(new BigDecimal("3E+1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0026()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0027()
  {
    rc_String = (new BigDecimal("4E+9")).toEngineeringString();
    Assert.assertEquals("4E+9", rc_String);
  }
  public void testItem_0028()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("4E+9")).remainder(new BigDecimal("3E+1"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).stripTrailingZeros();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_short = (new BigDecimal("1E+1")).shortValueExact();
    Assert.assertEquals(10, rc_short);
  }
  public void testItem_0033()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).plus(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0034()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("3E+1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0035()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0036()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).setScale(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("30.0", rc_BigDecimal.toString());
  }
  public void testItem_0037()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("30.0"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    rc_BigDecimal = (new BigDecimal("30.0")).stripTrailingZeros();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    rc_int = (new BigDecimal("3E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0042()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0043()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).stripTrailingZeros();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0044()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("30.0")).multiply(new BigDecimal("30.0"));
    Assert.assertEquals("900.00", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '8', '\0', '\234', '8', '\uFFFF', '8', '\uFFFF', '\0', '\1', '8', '\1', '\234', '\1', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\234', '\1', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\1'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0047()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0048()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("900.00")).divide(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
////    }
////    catch (java.lang.OutOfMemoryError e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0049()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).setScale(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0050()
  {
    rc_BigDecimal = (new BigDecimal("900.00")).divide(new BigDecimal("3E+1"), -1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0051()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("900.00")).setScale(2147483647, 0);
////    }
////    catch (java.lang.OutOfMemoryError e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0052()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).multiply(new BigDecimal("900.00"));
    Assert.assertEquals("27000.0", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("27000.0")).setScale(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("27000", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("27000"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
  }
  public void testItem_0055()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("27000.0"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).min(new BigDecimal("900.00"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = (new BigDecimal("27000.0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("27000.0", rc_BigDecimal.toString());
  }
  public void testItem_0058()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("900.00")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0059()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '8', '\0', '\234', '8', '\uFFFF', '\1', '\234', '\1', '\0', '\234', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\234', '\1', '8', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\1', '\234', '\234', '8', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\0', '8', '\1', '8', '\0', '8', '\uFFFF', '\234', '8', '8', '\234', '\234', '\1', '\0', '\1', '\1', '8', '\0', '\uFFFF', '8', '8', '\234', '\1', '\1', '\234', '\0'}, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0060()
  {
    rc_short = (new BigDecimal("3E+1")).shortValueExact();
    Assert.assertEquals(30, rc_short);
  }
  public void testItem_0061()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).max(new BigDecimal("27000"));
    Assert.assertEquals("27000", rc_BigDecimal.toString());
  }
  public void testItem_0062()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("900.00"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0063()
  {
    rc_int = (new BigDecimal("27000.0")).intValueExact();
    Assert.assertEquals(27000, rc_int);
  }
  public void testItem_0064()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("@:SAS8?5D0S183");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0065()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("27000.0")).multiply(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("810000", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("27000")).divide(new BigDecimal("3E+2"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0068()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0069()
  {
    rc_BigDecimal = (new BigDecimal("27000")).pow(0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0070()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0072()
  {
    rc_BigInteger = (new BigDecimal("6E+1")).unscaledValue();
    Assert.assertEquals("6", rc_BigInteger.toString());
  }
  public void testItem_0073()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2147483647"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_double = (new BigDecimal("810000")).doubleValue();
    Assert.assertEquals(810000.0, rc_double, 0);
  }
  public void testItem_0076()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).add(new BigDecimal("6E+1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0079()
  {
    rc_int = (new BigDecimal("-9E+18")).compareTo(new BigDecimal("-9E+18"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0080()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("6E+1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0081()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).movePointLeft(1);
    Assert.assertEquals("6", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).scaleByPowerOfTen(1);
    Assert.assertEquals("-9.223372036854775808E+19", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("810000")).abs();
    Assert.assertEquals("810000", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    rc_BigDecimal = (new BigDecimal("6")).multiply(new BigDecimal("6E+1"));
    Assert.assertEquals("3.6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_BigDecimal = (new BigDecimal("3.6E+2")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0089()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0090()
  {
    rc_String = (new BigDecimal("810000")).toString();
    Assert.assertEquals("810000", rc_String);
  }
  public void testItem_0091()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0092()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("0")).hashCode();
////    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0093()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("810000")).divide(new BigDecimal("1E+1"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0096()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("1E+1"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0097()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("320.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0098()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0099()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("0"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0102()
//  {
////    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
////    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0103()
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
  public void testItem_0104()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0106()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0109()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("1135879015891"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0111()
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
//  public void testItem_0112()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate();
////    Assert.assertEquals("-3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0113()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).movePointLeft(0);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
//  public void testItem_0114()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).remainder(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
////    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0115()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("1135879015891"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0116()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).ulp();
////    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0117()
  {
    rc_float = (new BigDecimal("320")).floatValue();
    Assert.assertEquals(320.0F, rc_float, 0);
  }
//  public void testItem_0118()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("320.0E+2147483647")).precision();
////    Assert.assertEquals(2, rc_int);
//  }
//  public void testItem_0119()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("320.0E+2147483647")).hashCode();
////    Assert.assertEquals(-2147482656, rc_int);
//  }
  public void testItem_0120()
  {
    rc_BigDecimal = (new BigDecimal("320")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0121()
  {
    rc_int = (new BigDecimal("3.2E+2")).compareTo(new BigDecimal("1135879015891"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).scaleByPowerOfTen(-1);
    Assert.assertEquals("113587901589.1", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    rc_double = (new BigDecimal("113587901589.1")).doubleValue();
    Assert.assertEquals(1.135879015891E11, rc_double, 0);
  }
//  public void testItem_0124()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs();
////    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0125()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\234', '8', '\234', '8', '\234', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0126()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("320")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("320")).divideToIntegralValue(new BigDecimal("1135879015891"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_float = (new BigDecimal("113587901589.1")).floatValue();
    Assert.assertEquals(1.13587904512E11F, rc_float, 0);
  }
  public void testItem_0130()
  {
    rc_int = (new BigDecimal("113587901589.1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0131()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '8', '8', '\1', '8', '8', '\234', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\1', '8', '\234', '\0', '\1', '\1', '\uFFFF', '8', '\234', '\0', '\0', '8', '\234', '\234', '\234', '\1', '\234', '\0', '\234', '8', '8', '\uFFFF', '\234', '\0', '\234', '\1', '\0', '\uFFFF', '\234', '\234', '\1', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\1', '\1', '\0', '\234', '\234', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0132()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    rc_String = (new BigDecimal("320")).toString();
    Assert.assertEquals("320", rc_String);
  }
//  public void testItem_0134()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0135()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0136()
  {
    rc_short = (new BigDecimal("320")).shortValueExact();
    Assert.assertEquals(320, rc_short);
  }
  public void testItem_0137()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\234', '\234', '\0', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\234', '\1', '\1', '\1', '\0', '8', '8', '\1', '\234', '\234', '\234', '8', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\234', '8', '8', '8', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\uFFFF', '\0', '8', '\0', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0138()
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
  public void testItem_0139()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    rc_String = (new BigDecimal("320")).toString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0141()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@AG;7I:X9B>5E>@NWU:0WXX=Q6K@AD<XDMTQOXY2VF0D1FQPL4E=D5B5I5KL@C5");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0142()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toEngineeringString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0143()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0144()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("320.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0145()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0146()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("0"));
////    }
////    catch (java.lang.ArithmeticException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0147()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).subtract(new BigDecimal("0"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0149()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0150()
  {
    rc_double = (new BigDecimal("3.2")).doubleValue();
    Assert.assertEquals(3.2, rc_double, 0);
  }
  public void testItem_0151()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).stripTrailingZeros();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0153()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Q;F=T<ML1?LKG<KSBPS>;T<74P;7=<I8?WXXFS029RB3U<?EHP0SF");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0154()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0156()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\1', '\1', '\234', '8', '8', '8', '\0', '\uFFFF', '\1', '8', '\0', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\234', '\uFFFF', '\234', '\0', '\234', '\1', '\1', '\uFFFF', '\234', '8', '\0', '\234', '\234', '\0', '\0', '8', '8', '\0', '\0', '\1', '\234', '\234', '8', '\234', '\1', '\1', '\0', '8', '\1', '\uFFFF', '\234', '\234', '\234', '\0', '8', '\0', '\234', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '8'}, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0157()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0158()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).movePointLeft(0);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0159()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0160()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0161()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0163()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0164()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("VEEF8PJQOHRIAUPRWAJ19ARQINHLB3H6B7A@PTB1X>C0PEG5R:C<2QFN:98<E<S");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0165()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("3.2"));
    Assert.assertEquals("6.4", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("0E+1"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0169()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0171()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("3.2"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0172()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("VQHKYNAX16:YEQKEFS2KAJE26HTYR3G=EU0X:0LSQ3WQLRJN8PM6BK6?8VS:<SRGN<3Y7?>82JA>97CXSP");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0173()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0174()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0175()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=0 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0176()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("0E+1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0178()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("3.2"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0182()
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
  public void testItem_0183()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0184()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
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
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0186()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\0', '\uFFFF', '\0', '8', '\234', '8', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\0', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\234', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '8', '\1', '\234', '8', '8', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\1', '8', '\1', '8', '8', '\uFFFF', '8', '\234', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '8', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\0', '\1', '\0', '\1', '\0', '\0', '\234', '8', '\1', '\1', '\0', '\1', '\234', '\234', '\0', '\234', '\uFFFF', '8', '8', '\234', '\234', '\234', '\1', '\234', '\0', '\uFFFF', '\1', '8', '\234', '\0', '\0', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0187()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0188()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0189()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0190()
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
  public void testItem_0191()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0192()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0195()
  {
    rc_boolean = (new BigDecimal("-1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0196()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0198()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0200()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).max(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0203()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).divide(new BigDecimal("3E+2"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).max(new BigDecimal("1135879015891"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).movePointLeft(0);
    Assert.assertEquals("-300", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).subtract(new BigDecimal("1135879015891"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0208()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("-300")).divideToIntegralValue(new BigDecimal("3E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    rc_BigDecimal = (new BigDecimal("-300")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-30.0", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).divideToIntegralValue(new BigDecimal("3E+2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    rc_String = (new BigDecimal("-300")).toEngineeringString();
    Assert.assertEquals("-300", rc_String);
  }
  public void testItem_0213()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-300")).divide(new BigDecimal("-3E+2"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0214()
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
  public void testItem_0215()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).plus(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).divideToIntegralValue(new BigDecimal("-30.0"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_long = (new BigDecimal("-300")).longValueExact();
    Assert.assertEquals(-300L, rc_long);
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).negate(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    rc_int = (new BigDecimal("-1E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0220()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).multiply(new BigDecimal("3E+2"));
    Assert.assertEquals("-9E+4", rc_BigDecimal.toString());
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("-9E+4")).negate(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("9E+4", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    rc_String = (new BigDecimal("-9E+4")).toEngineeringString();
    Assert.assertEquals("-90E+3", rc_String);
  }
  public void testItem_0224()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).ulp();
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0226()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("-3E+2"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0228()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0229()
  {
    rc_int = (new BigDecimal("-3E+2")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0230()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E+2")).remainder(new BigDecimal("3E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0231()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '8', '\1', '\234', '\uFFFF', '8', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '8', '\234', '\0', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\1', '\234', '\1', '\234', '\0', '\uFFFF', '\234', '8', '\234', '\1', '\0', '\0', '\uFFFF', '8', '8', '\234', '\1', '\uFFFF', '8', '\0', '\1', '8', '\uFFFF', '\0', '\0', '\1', '\0', '\0', '\234', '\234', '\0', '8', '\uFFFF', '8', '8', '\1', '\234', '8', '8', '\0', '\1', '\234', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '8', '\234', '\0', '\1', '8', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '8'}, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("-9E+4")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+4", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).ulp();
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0235()
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
  public void testItem_0236()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=0 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0237()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).multiply(new BigDecimal("1"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9E+4")).divide(new BigDecimal("1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0239()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0240()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@3?5FS32>3D@FX?<952<<>U1WF93UL9@6TCMK0SQBQKADTRVQ@NE093B19G@17AD@OX8AE3?OVQ7E=48=4B;L?DE=00:P<>VHUB3");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).movePointLeft(-1);
    Assert.assertEquals("-3000", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_String = (new BigDecimal("3E+2")).toPlainString();
    Assert.assertEquals("300", rc_String);
  }
  public void testItem_0243()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).max(new BigDecimal("-3E+2"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0247()
  {
    rc_int = (new BigDecimal("3E+2")).scale();
    Assert.assertEquals(-2, rc_int);
  }
  public void testItem_0248()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).ulp();
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0250()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0251()
  {
    rc_int = (new BigDecimal("3E+2")).compareTo(new BigDecimal("1E+2"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0252()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("SXBXIV2QV9PRN?<3C7KGW;SQ87BI?=<WJ3C@KN;SFQR2G@FYIS<Y4F:UI8M1WT7A<OE6V3:;T@NLW1L", new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0253()
  {
    rc_long = (new BigDecimal("1E+2")).longValue();
    Assert.assertEquals(100L, rc_long);
  }
  public void testItem_0254()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0255()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).pow(1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0256()
  {
    rc_BigInteger = (new BigDecimal("-3E+2")).unscaledValue();
    Assert.assertEquals("-3", rc_BigInteger.toString());
  }
  public void testItem_0257()
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
  public void testItem_0258()
  {
    rc_float = (new BigDecimal("1E+2")).floatValue();
    Assert.assertEquals(100.0F, rc_float, 0);
  }
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).movePointLeft(-1);
    Assert.assertEquals("-92233720368547758080", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_String = (new BigDecimal("-3E+2")).toPlainString();
    Assert.assertEquals("-300", rc_String);
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).negate(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).plus();
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_BigInteger = (new BigDecimal("-3E+2")).toBigInteger();
    Assert.assertEquals("-300", rc_BigInteger.toString());
  }
  public void testItem_0264()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).scaleByPowerOfTen(1);
    Assert.assertEquals("3E+3", rc_BigDecimal.toString());
  }
  public void testItem_0265()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0266()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0267()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("3E+3"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).subtract(new BigDecimal("-3E+2"));
    Assert.assertEquals("-9223372036854775508", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0270()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0271()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).add(new BigDecimal("-3E+2"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("-6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0272()
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
  public void testItem_0273()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0274()
  {
    rc_BigDecimal_array = (new BigDecimal("-6E+2")).divideAndRemainder(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
  }
  public void testItem_0275()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+2")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0276()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0277()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0278()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0279()
  {
    rc_BigDecimal = (new BigDecimal("-6E+2")).min(new BigDecimal("32"));
    Assert.assertEquals("-6E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0280()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("3E+3")).hashCode();
////    Assert.assertEquals(90, rc_int);
//  }
  public void testItem_0281()
  {
    rc_BigDecimal = (new BigDecimal("3E+3")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("3.00E+3", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).negate();
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("3E+3"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.000", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_BigDecimal = (new BigDecimal("3E+3")).setScale(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("3000", rc_BigDecimal.toString());
  }
  public void testItem_0285()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0286()
  {
    rc_BigInteger = (new BigDecimal("3E+2")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0287()
  {
    rc_int = (new BigDecimal("3000")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0288()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3000")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0289()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).divideToIntegralValue(new BigDecimal("3E+3"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    rc_int = (new BigDecimal("3E+3")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0291()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).negate();
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0292()
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
  public void testItem_0293()
  {
    rc_BigInteger = (new BigDecimal("3E+2")).toBigInteger();
    Assert.assertEquals("300", rc_BigInteger.toString());
  }
  public void testItem_0294()
  {
    rc_float = (new BigDecimal("3000")).floatValue();
    Assert.assertEquals(3000.0F, rc_float, 0);
  }
  public void testItem_0295()
  {
    rc_int = (new BigDecimal("3E+2")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0296()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.00E+3")).divide(new BigDecimal("3000"), -2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0297()
  {
    rc_long = (new BigDecimal("3E+3")).longValue();
    Assert.assertEquals(3000L, rc_long);
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("3.00E+3")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+3", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0300()
  {
    rc_BigInteger = (new BigDecimal("3E+3")).toBigInteger();
    Assert.assertEquals("3000", rc_BigInteger.toString());
  }
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("0.0"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0303()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3E+3")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("3E+3")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("3000.0", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    rc_BigDecimal = (new BigDecimal("3E+3")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+3", rc_BigDecimal.toString());
  }
  public void testItem_0306()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+3")).divide(new BigDecimal("2147483647"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0307()
  {
    rc_int = (new BigDecimal("0.0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0308()
  {
    rc_BigDecimal = (new BigDecimal("3E+3")).negate();
    Assert.assertEquals("-3E+3", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0310()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+3")).setScale(2147483647, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0311()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+3")).divide(new BigDecimal("3E+3"), 2147483647, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0312()
  {
    rc_BigInteger = (new BigDecimal("0.00")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0313()
  {
    rc_BigInteger = (new BigDecimal("3E+3")).toBigInteger();
    Assert.assertEquals("3000", rc_BigInteger.toString());
  }
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).negate();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_String = (new BigDecimal("-3E+3")).toPlainString();
    Assert.assertEquals("-3000", rc_String);
  }
  public void testItem_0316()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0317()
  {
    rc_BigDecimal = (new BigDecimal("3E+3")).plus(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3E+3", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("-3E+3")).add(new BigDecimal("3E+3"));
    Assert.assertEquals("0E+3", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_double = (new BigDecimal("8")).doubleValue();
    Assert.assertEquals(8.0, rc_double, 0);
  }
  public void testItem_0320()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\1', '\1', '\0', '\uFFFF', '\0', '\234', '\0', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\0', '8', '\1', '8', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '8', '\1', '\234', '\0', '\234', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\234', '8', '\0', '\1', '\234', '\1', '8', '\uFFFF', '\0', '\0', '\1', '\1', '\1', '\234', '\234', '\234', '8', '8', '\0', '\uFFFF', '\0', '\1', '\0', '\1', '\uFFFF', '\0', '\0', '8', '\234', '\uFFFF', '8', '\0', '\1', '\uFFFF', '8', '8', '\0', '\0', '8', '8', '8', '8', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '8', '\0', '8', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0321()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+3")).divideAndRemainder(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
  }
  public void testItem_0322()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).divideToIntegralValue(new BigDecimal("0E+3"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0324()
  {
    rc_byte = (new BigDecimal("0.00")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0325()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    rc_BigDecimal = (new BigDecimal("3E+3")).divideToIntegralValue(new BigDecimal("3E+3"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
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
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0328()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    rc_long = (new BigDecimal("3E+3")).longValueExact();
    Assert.assertEquals(3000L, rc_long);
  }
  public void testItem_0330()
  {
    rc_long = (new BigDecimal("-3E+3")).longValueExact();
    Assert.assertEquals(-3000L, rc_long);
  }
  public void testItem_0331()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    rc_long = (new BigDecimal("3E+3")).longValueExact();
    Assert.assertEquals(3000L, rc_long);
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("0E+3")).plus();
    Assert.assertEquals("0E+3", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0335()
  {
    rc_String = (new BigDecimal("3E+1")).toString();
    Assert.assertEquals("3E+1", rc_String);
  }
  public void testItem_0336()
  {
    rc_BigDecimal = (new BigDecimal("0E+3")).add(new BigDecimal("-3E+3"));
    Assert.assertEquals("-3E+3", rc_BigDecimal.toString());
  }
  public void testItem_0337()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0338()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+3")).divideAndRemainder(new BigDecimal("3E+1"));
  }
  public void testItem_0339()
  {
    rc_BigDecimal = (new BigDecimal("-3E+3")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-3032", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_String = (new BigDecimal("-3032")).toPlainString();
    Assert.assertEquals("-3032", rc_String);
  }
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("32"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    rc_float = (new BigDecimal("3E+1")).floatValue();
    Assert.assertEquals(30.0F, rc_float, 0);
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
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0346()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0347()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = (new BigDecimal("3E+3")).subtract(new BigDecimal("32"));
    Assert.assertEquals("2968", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0350()
  {
    rc_BigInteger = (new BigDecimal("3E+3")).toBigIntegerExact();
    Assert.assertEquals("3000", rc_BigInteger.toString());
  }
  public void testItem_0351()
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
  public void testItem_0352()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("2968"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2967", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigInteger = (new BigDecimal("-2967")).unscaledValue();
    Assert.assertEquals("-2967", rc_BigInteger.toString());
  }
  public void testItem_0355()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0356()
  {
    rc_BigDecimal = (new BigDecimal("3E+3")).subtract(new BigDecimal("-2967"));
    Assert.assertEquals("5967", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_BigInteger = (new BigDecimal("2968")).toBigIntegerExact();
    Assert.assertEquals("2968", rc_BigInteger.toString());
  }
  public void testItem_0358()
  {
    rc_long = (new BigDecimal("5967")).longValueExact();
    Assert.assertEquals(5967L, rc_long);
  }
  public void testItem_0359()
  {
    rc_float = (new BigDecimal("2968")).floatValue();
    Assert.assertEquals(2968.0F, rc_float, 0);
  }
  public void testItem_0360()
  {
    rc_BigInteger = (new BigDecimal("-2967")).toBigIntegerExact();
    Assert.assertEquals("-2967", rc_BigInteger.toString());
  }
  public void testItem_0361()
  {
    rc_BigDecimal = (new BigDecimal("2968")).multiply(new BigDecimal("5967"));
    Assert.assertEquals("17710056", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    rc_BigDecimal = (new BigDecimal("2968")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0363()
  {
    rc_boolean = (new BigDecimal("5967")).equals("DLMSSB;0F@JJS;GG2SEM<6WC:E5@TKDIP=D=KJ7:;HOQGJ>;0LSD;3QH4M?2<AY18>TKUYE:58AB2:0N;58BB8QG8?NE>LI8:R79");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0364()
  {
    rc_short = (new BigDecimal("-2967")).shortValueExact();
    Assert.assertEquals(-2967, rc_short);
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("3E+3")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+3", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_BigDecimal = (new BigDecimal("-2967")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("-2967")).plus();
    Assert.assertEquals("-2967", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2967")).pow(-2147483648, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0369()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '8', '\0', '\0', '\234', '\1', '\1', '\234', '\1', '\1', '\234', '\1', '\0', '8', '8', '\1', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\234', '\234', '\0', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\234', '\1', '\0', '\0', '\0', '\234', '\0', '\uFFFF', '\0', '\0', '\234', '\0', '8', '\0'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0370()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0371()
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
  public void testItem_0372()
  {
    rc_BigDecimal_array = (new BigDecimal("3E+3")).divideAndRemainder(new BigDecimal("-2967"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0373()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0374()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("AT?PYI");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0375()
  {
    rc_long = (new BigDecimal("2968")).longValueExact();
    Assert.assertEquals(2968L, rc_long);
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("2968")).stripTrailingZeros();
    Assert.assertEquals("2968", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    rc_int = (new BigDecimal("3E+3")).compareTo(new BigDecimal("2968"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0384()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0385()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0386()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0387()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0388()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).movePointLeft(-1);
    Assert.assertEquals("21474836470", rc_BigDecimal.toString());
  }
  public void testItem_0389()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0390()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0391()
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
  public void testItem_0392()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0397()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0398()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("21474836470"));
    Assert.assertEquals("-21474836438", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0401()
  {
    rc_BigDecimal = (new BigDecimal("21474836470")).negate();
    Assert.assertEquals("-21474836470", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0403()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0404()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate(new MathContext("precision=0 roundingMode=DOWN"));
////    Assert.assertEquals("-3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0405()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0406()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0407()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
//  public void testItem_0408()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
////    Assert.assertEquals("-3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0409()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
////    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0410()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0411()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("-1"));
////    }
////    catch (java.lang.ArithmeticException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0412()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0415()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), 0, 1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0417()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\234', '\0', '\1', '\1', '\234', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\1', '\234', '8', '\234', '8', '\0', '\0', '\uFFFF', '\234', '\234', '8', '\234', '\uFFFF', '\1', '\1', '\1', '\234', '\234', '8', '\uFFFF', '\1', '\0', '\234', '\234', '\1', '\1', '8', '\uFFFF', '8', '\234', '\0', '\1', '\0', '\1', '\uFFFF', '\1', '\1', '\234', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '8', '8', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\1', '8', '8', '\234', '\0', '\uFFFF', '\234', '\1', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0418()
//  {
//    boolean caught;
////    rc_BigInteger = (new BigDecimal("-320.0E+2147483647")).unscaledValue();
////    Assert.assertEquals("-32", rc_BigInteger.toString());
//  }
  public void testItem_0419()
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
//  public void testItem_0420()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9223372036854775807")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0421()
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
  public void testItem_0422()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0423()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).ulp();
////    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0424()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("1E+2147483647")).divide(new BigDecimal("9223372036854775807"), -1, java.math.RoundingMode.HALF_EVEN);
////    }
////    catch (java.lang.NegativeArraySizeException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0425()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("-320.0E+2147483647")).hashCode();
////    Assert.assertEquals(2147482656, rc_int);
//  }
  public void testItem_0426()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("E:F63JDT9?Q:0V6QFOXDI21S=QW5U?9HLU0=");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0427()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).negate();
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("9223372036854775807"), -1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0429()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-9223372036854775807"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0430()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0431()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0433()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).movePointRight(-1);
    Assert.assertEquals("113587901589.1", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0437()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0438()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("1135879015891")).hashCode();
////    Assert.assertEquals(2107853717, rc_int);
//  }
  public void testItem_0439()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\1', '\0', '\0', '\0', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '8', '8', '\234', '\0', '\234', '\1', '8', '\0', '\0', '8', '\1', '\1', '\0', '\234', '8', '\0', '\0', '\234', '\1', '\1', '\234', '\0', '\0', '\0', '\1', '\0', '\1', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '8', '8', '\uFFFF', '\234', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '8', '8', '\0', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '8', '8', '\234', '8', '8', '\uFFFF', '\234', '\0', '\1', '\0', '\0', '8', '\1', '8', '\0', '\234', '\1', '\0', '8', '\1', '\1', '8', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0441()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";8LPNX8ORLJF2>@33S6UH9:P6UNJMJ>BEH0AWNY05B@7X=FX36KCW>PTW0L9IP7<R21NCF@MTK29@WD>HR3X9:WE>E=9:F8QEED@");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).subtract(new BigDecimal("1"));
    Assert.assertEquals("1135879015890", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("1135879015891"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1135879015890")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0446()
  {
    rc_int = (new BigDecimal("0E+1")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0447()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).remainder(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0448()
  {
    rc_BigDecimal = (new BigDecimal("1135879015890")).divideToIntegralValue(new BigDecimal("3.2E+2"));
    Assert.assertEquals("3549621924.0", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    rc_int = (new BigDecimal("3.2E+2")).intValueExact();
    Assert.assertEquals(320, rc_int);
  }
  public void testItem_0450()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0452()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).max(new BigDecimal("3.2E+2"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("=838:IX?LP216@6DVS<O;8R34IVWWDPIDQI?2FHW41RSFQ@T1KPR62@LKXVU43X@@HE8PVK9PKRI;0Q83C11@=K0B2R=A>PH1QKU", new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0454()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("1135879015890")).plus(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1135879015890", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).stripTrailingZeros();
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(-2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("32"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0465()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).stripTrailingZeros();
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_BigDecimal = (new BigDecimal("-32")).remainder(new BigDecimal("3E+2"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0470()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3E+2")).divideAndRemainder(new BigDecimal("3E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0471()
  {
    rc_String = (new BigDecimal("3.2E+2")).toEngineeringString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0472()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    rc_BigDecimal = (new BigDecimal("-32")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("-32")).negate();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("-32"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    rc_BigDecimal = (new BigDecimal("-32")).add(new BigDecimal("-32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-64", rc_BigDecimal.toString());
  }
  public void testItem_0478()
  {
    rc_BigDecimal = (new BigDecimal("-32")).add(new BigDecimal("-64"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-96", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-64")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).subtract(new BigDecimal("-96"));
    Assert.assertEquals("396", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    rc_short = (new BigDecimal("-64")).shortValueExact();
    Assert.assertEquals(-64, rc_short);
  }
  public void testItem_0482()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0485()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(1);
////    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0486()
  {
    rc_String = (new BigDecimal("-32")).toPlainString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0487()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\0', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '8', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0488()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0489()
  {
    rc_BigDecimal = (new BigDecimal("-32")).negate();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    rc_float = (new BigDecimal("-32")).floatValue();
    Assert.assertEquals(-32.0F, rc_float, 0);
  }
  public void testItem_0491()
  {
    rc_int = (new BigDecimal("320.0E+2147483647")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0492()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("0E+1")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
////    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0495()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0496()
  {
    rc_boolean = (new BigDecimal("320.0E+2147483647")).equals("XPCFU17T7X2D2=7U6LA721QN;G;FD");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    rc_String = (new BigDecimal("-32")).toEngineeringString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0499()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0500()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_int = (new BigDecimal("320.0E+2147483647")).intValue();
////    }
////    catch (java.lang.ArithmeticException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0501()
  {
    rc_int = (new BigDecimal("0E-2147483647")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0502()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0503()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).max(new BigDecimal("32"));
//    Assert.assertEquals("32", rc_BigDecimal.toString());
//    }
//  }
//  public void testItem_0504()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("3.2E+2")).add(new BigDecimal("320.0E+2147483647"));
////    }
////    catch (java.lang.NegativeArraySizeException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0505()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0506()
  {
    rc_double = (new BigDecimal("3.2E+2")).doubleValue();
    Assert.assertEquals(320.0, rc_double, 0);
  }
//  public void testItem_0507()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_int = (new BigDecimal("320.0E+2147483647")).intValue();
////    }
////    catch (java.lang.ArithmeticException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0508()
  {
    rc_int = (new BigDecimal("-32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("-32"), 0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0510()
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
  public void testItem_0511()
  {
    rc_BigDecimal = (new BigDecimal("-32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0513()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0514()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).max(new BigDecimal("-32"));
////    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0515()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("3.2E+2"));
////    }
////    catch (java.lang.NegativeArraySizeException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0516()
  {
    rc_int = (new BigDecimal("-32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0517()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2E+2")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0518()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("3.2E+2"), java.math.RoundingMode.UP);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1.024E+4", rc_BigDecimal.toString());
  }
  public void testItem_0520()
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
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).multiply(new BigDecimal("3.2E+2"));
    Assert.assertEquals("3.2E+3", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0523()
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
  public void testItem_0524()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("1.024E+4")).divideToIntegralValue(new BigDecimal("1.024E+4"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0528()
  {
    rc_int = (new BigDecimal("1E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0529()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("1.024E+4")).stripTrailingZeros();
    Assert.assertEquals("1.024E+4", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.024E+4")).divide(new BigDecimal("1"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0532()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+3")).plus();
    Assert.assertEquals("3.2E+3", rc_BigDecimal.toString());
  }
  public void testItem_0533()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3.2E+3"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0534()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '8', '\uFFFF', '\0', '8', '\1', '\0', '\234', '\1', '8', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\0', '\1', '\0', '\234', '\0', '\0', '\1', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\234', '8', '\234', '\0', '\234', '\1', '\0', '8', '\uFFFF', '8', '\234', '8', '\0', '8', '\uFFFF', '\234', '\1', '\1', '\1', '\uFFFF', '8', '\234', '\234', '\1', '\uFFFF', '8', '8', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0536()
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
  public void testItem_0537()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.024E+4")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0539()
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
  public void testItem_0540()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("1.024E+4")).stripTrailingZeros();
    Assert.assertEquals("1.024E+4", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("1.024E+4")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0543()
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
  public void testItem_0544()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\234', '\uFFFF', '8', '8', '\0', '\1', '\0', '\1', '\0', '\1', '\uFFFF', '\234', '8', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\234', '8', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\234', '\0', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\234', '\234', '\uFFFF', '\1', '8', '\1', '8', '\234', '8', '\1', '\uFFFF', '\234', '\1', '\234', '\234', '\234', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\0', '\234', '8', '8', '8', '\0', '\uFFFF', '8', '\234', '8', '\234', '\1', '\234', '\0', '\234', '\uFFFF', '\234', '\1', '\234', '\234', '\234', '\0', '\uFFFF', '\1', '\234', '\0', '\0', '\1', '\uFFFF', '\234', '\1', '8', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_BigDecimal_array = (new BigDecimal("1E+1")).divideAndRemainder(new BigDecimal("1E+1"));
  }
  public void testItem_0547()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).stripTrailingZeros();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0550()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).movePointRight(-2147483648);
    Assert.assertEquals("-1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0551()
  {
    rc_BigDecimal = (new BigDecimal("-1E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0552()
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
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0553()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).divide(new BigDecimal("1E+1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0555()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("1.024E+4"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).setScale(-1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.024E+4")).divide(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0559()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0560()
  {
    rc_double = (new BigDecimal("1.024E+4")).doubleValue();
    Assert.assertEquals(10240.0, rc_double, 0);
  }
  public void testItem_0561()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_int = (new BigDecimal("0E+1")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0563()
  {
    rc_float = (new BigDecimal("1.024E+4")).floatValue();
    Assert.assertEquals(10240.0F, rc_float, 0);
  }
  public void testItem_0564()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, 0, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0566()
  {
    rc_long = (new BigDecimal("1E+1")).longValue();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0567()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("1E-2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0568()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\234', '\234', '\1', '\234', '8', '\234', '\234', '\uFFFF', '\234', '\0', '8', '\1', '\1', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '8', '\234', '8', '\0', '\uFFFF', '\0', '\1', '\1', '\234', '\uFFFF', '\1', '\0', '8', '\234', '\234', '\234', '\1', '\234', '\0', '\234', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\0', '\0', '8', '8', '\234', '\234', '8', '\1', '\234', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0570()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0571()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("J?CYOUO08CTM0Y;H806XW?1I=LVMM;J08XTA9N><DX2<TS:EPQOF;W>3;HXTS4C=?504T12TQ8:M9DI?U8F24:H<9TPJJ:9U68C8");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0572()
  {
    rc_BigDecimal = (new BigDecimal("1.024E+4")).setScale(-1);
    Assert.assertEquals("1.024E+4", rc_BigDecimal.toString());
  }
//  public void testItem_0573()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("1.024E+4")).divide(new BigDecimal("320.0E+2147483647"), java.math.RoundingMode.HALF_DOWN);
////    }
////    catch (java.lang.ArithmeticException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0574()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0575()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).setScale(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0576()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0577()
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
  public void testItem_0578()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-9223372036854775807")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0579()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1.024E+4")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0580()
  {
    rc_int = (new BigDecimal("-9223372036854775807")).precision();
    Assert.assertEquals(19, rc_int);
  }
  public void testItem_0581()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0582()
  {
    rc_BigDecimal = (new BigDecimal("1.024E+4")).multiply(new BigDecimal("1.024E+4"));
    Assert.assertEquals("1.048576E+8", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("-9223372036854775807"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
//  public void testItem_0584()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-9223372036854775807")).divideAndRemainder(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0585()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("O2YWQR@AVA:Q?R=>4XECSKYRC9L");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).divide(new BigDecimal("9223372036854775807"), -1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0590()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0592()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).scaleByPowerOfTen(0);
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0593()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-922337203685477580.7", rc_BigDecimal.toString());
  }
  public void testItem_0594()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0595()
  {
    rc_int = (new BigDecimal("3.2E+2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0596()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775807")).unscaledValue();
    Assert.assertEquals("-9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0597()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0598()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0599()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0600()
  {
    rc_String = (new BigDecimal("-9223372036854775807")).toString();
    Assert.assertEquals("-9223372036854775807", rc_String);
  }
  public void testItem_0601()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0603()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0605()
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
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0608()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0609()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775807")).toBigIntegerExact();
    Assert.assertEquals("-9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0610()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0611()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\1', '\234', '\234', '\0', '\234', '\uFFFF', '\1', '\0', '\1', '\234', '\234', '\1', '8', '8', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\1', '\0', '\1', '\1', '8', '\1', '\uFFFF', '8', '\1', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\1', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\0', '8', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\0', '\234', '8', '\0', '\1', '\1', '8', '8', '\1', '\uFFFF', '\1', '\uFFFF', '8', '8', '\234', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0612()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0614()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0615()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0616()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-9223372036854775807")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0617()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("-9223372036854775807")).hashCode();
////    Assert.assertEquals(-2147482656, rc_int);
//  }
  public void testItem_0618()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0623()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0624()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\1', '\0', '\234', '\0', '8', '8', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\1', '8', '\0', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\1', '\0', '\234', '\234', '\uFFFF', '8', '\0', '8', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\1', '8', '\234', '8', '\0', '\234', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\234', '\1', '8', '\uFFFF', '8', '8', '8', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\0', '8', '\1', '\1', '\0', '\uFFFF', '\0', '8', '\234', '\234', '\234', '\0', '\0', '\0', '8', '\1', '\0', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0625()
  {
    rc_BigDecimal = (new BigDecimal("33")).movePointLeft(1);
    Assert.assertEquals("3.3", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).plus(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0629()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '8', '8', '\1', '\1', '\234', '\0', '8', '8', '8', '\0', '\1', '\0', '\0', '\0', '8', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\1', '\0', '\uFFFF', '8', '\1', '\uFFFF', '8', '\1', '8', '\1', '\uFFFF', '8', '\0', '\234', '\1', '8', '\0', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\1', '\1', '\0', '\234', '8', '\uFFFF', '8', '8', '8', '\1', '\0', '\1', '\0', '\234', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '8', '\0', '\0', '\234', '\uFFFF', '\234', '\1', '8', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\0'});
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
      rc_BigDecimal = new BigDecimal("C9UT8:B0J;R3CH::69EMSDKUVXUMEYM>;;DLT94E5SUX@BCDE0R8<FH:R>VU8U4UQEP85<UAXYAEGBR<PK6PPDHS<64GG<T32>6>", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0631()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0632()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0633()
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
//  public void testItem_0634()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0635()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0638()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0639()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("1135879015891")).hashCode();
////    Assert.assertEquals(2107853717, rc_int);
//  }
  public void testItem_0640()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0641()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1135879015891"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0643()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0644()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("K9SUQC:00J2YPGA9@6Q;N3<AM=QLK1JB91=53TDMD00CAX?IOJSDVHJ7EGR3D:C69<B=UB0WIRJYUWV<QWD07@BFS3MFOG407;0>");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0645()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0646()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0647()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0648()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0649()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\234', '\234', '\1', '\234', '\234'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0650()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0651()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0654()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0655()
  {
    rc_BigInteger = (new BigDecimal("-32")).toBigIntegerExact();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0657()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0658()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0659()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("1")).hashCode();
////    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0660()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0661()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0662()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0663()
  {
    rc_float = (new BigDecimal("-32")).floatValue();
    Assert.assertEquals(-32.0F, rc_float, 0);
  }
  public void testItem_0664()
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
  public void testItem_0665()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
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
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0668()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\uFFFF', '8', '\1', '\234', '\1', '\234', '\0', '\0', '\0', '\1', '\1', '\0', '\1', '8', '\234', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\234', '\234', '\1', '\234', '\1', '8', '8', '\0', '\1', '\1', '\234', '8', '\234', '\0', '8', '\0', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0669()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0672()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).movePointRight(1);
    Assert.assertEquals("300", rc_BigDecimal.toString());
  }
  public void testItem_0678()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-32"), -2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0679()
  {
    rc_BigDecimal = (new BigDecimal("-32")).movePointRight(0);
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = (new BigDecimal("-32")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-32"), -1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0683()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("-1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
////    }
////    catch (java.lang.OutOfMemoryError e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0684()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\0', '\1', '\0', '\234', '\234', '\0', '\0', '8', '\0', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\1', '8', '8', '\1', '\0', '\234', '\uFFFF', '8', '8', '8', '8', '\1', '8', '8', '\234', '\1', '\0', '\1', '\uFFFF', '\234', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\0', '\1', '\0', '\uFFFF', '8', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\1', '\0', '\0', '\1', '\0', '\0', '\234', '\1', '\0', '\0', '\uFFFF', '\0', '\234', '\234', '8', '\1', '\1', '\uFFFF', '8'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0685()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0686()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("32"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0687()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0688()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0689()
  {
    rc_BigDecimal = (new BigDecimal("-32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0691()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-1E+1"), 1);
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0692()
  {
    rc_BigDecimal = (new BigDecimal("-32")).multiply(new BigDecimal("3E+1"));
    Assert.assertEquals("-9.6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("-3")).multiply(new BigDecimal("-3"));
    Assert.assertEquals("9", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_byte = (new BigDecimal("9")).byteValueExact();
    Assert.assertEquals(9, rc_byte);
  }
//  public void testItem_0696()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9.6E+2")).setScale(-2147483648, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0697()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1E+1")).remainder(new BigDecimal("9"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("-32")).movePointRight(1);
    Assert.assertEquals("-320", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0700()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_BigInteger = (new BigDecimal("9")).toBigInteger();
    Assert.assertEquals("9", rc_BigInteger.toString());
  }
  public void testItem_0702()
  {
    rc_BigInteger = (new BigDecimal("-32")).toBigIntegerExact();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0703()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0704()
  {
    rc_BigDecimal = (new BigDecimal("-320")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0705()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0706()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("-320")).negate();
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_BigDecimal = (new BigDecimal("320")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    rc_int = (new BigDecimal("320")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0711()
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
  public void testItem_0712()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0713()
  {
    rc_String = (new BigDecimal("320")).toString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0714()
  {
    rc_short = (new BigDecimal("9")).shortValueExact();
    Assert.assertEquals(9, rc_short);
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("320")).stripTrailingZeros();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0716()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("32")).hashCode();
////    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0717()
  {
    rc_double = (new BigDecimal("-320")).doubleValue();
    Assert.assertEquals(-320.0, rc_double, 0);
  }
  public void testItem_0718()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0719()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E+2")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0720()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0721()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).stripTrailingZeros();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0722()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0723()
  {
    rc_BigDecimal = (new BigDecimal("-320")).multiply(new BigDecimal("320"));
    Assert.assertEquals("-102400", rc_BigDecimal.toString());
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("320")).negate();
    Assert.assertEquals("-320", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-320")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0726()
  {
    rc_boolean = (new BigDecimal("320")).equals("R<W8>N2DD@VL8XV5M8<:U@D9GQ86L;PV>W:H04M;J4JROMTOLRVS@4ROTIGQP2TYFJ25L2VXPU6AH3J6TP6?SF3;I<EQ2=PK1RNN");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("-320")).divideToIntegralValue(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0728()
  {
    rc_boolean = (new BigDecimal("-1")).equals("TXSN>O>0=3?AYT;6DGGAU8>5RW4@;N=2XLH329GR");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0729()
  {
    rc_BigDecimal = (new BigDecimal("-320")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '8', '\234', '\1', '\uFFFF', '8', '8', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '8', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\1', '\1', '8', '\uFFFF', '\234', '\0', '\234', '\0', '\1', '\0', '\1', '8', '\234', '\0', '\uFFFF', '\1', '8', '8', '\uFFFF', '\234', '\0', '8', '8', '\uFFFF', '8', '\0', '\0', '8', '8', '\234', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\1', '\234', '8', '\uFFFF', '\1', '\234', '\0', '8', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\234', '\1', '\1', '\1', '\234', '\1', '\0', '\234'}, 0, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0731()
  {
    rc_String = (new BigDecimal("-320")).toEngineeringString();
    Assert.assertEquals("-320", rc_String);
  }
  public void testItem_0732()
  {
    rc_BigDecimal = (new BigDecimal("-320")).divideToIntegralValue(new BigDecimal("-320"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0734()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0735()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0736()
  {
    rc_BigDecimal = (new BigDecimal("-320")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-321", rc_BigDecimal.toString());
  }
  public void testItem_0737()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-321")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0738()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0739()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("-320"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("-1"), java.math.RoundingMode.UP);
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0743()
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
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).setScale(1);
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0747()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3.2"), 0, 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0749()
  {
    rc_double = (new BigDecimal("-3.2")).doubleValue();
    Assert.assertEquals(-3.2, rc_double, 0);
  }
//  public void testItem_0750()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
////    }
////    catch (java.lang.OutOfMemoryError e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0751()
  {
    rc_long = (new BigDecimal("0.0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0752()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-1, 0);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0754()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0755()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    rc_BigInteger = (new BigDecimal("-2E+9")).toBigIntegerExact();
    Assert.assertEquals("-2000000000", rc_BigInteger.toString());
  }
  public void testItem_0758()
  {
    rc_int = (new BigDecimal("3.2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0759()
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
  public void testItem_0760()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).max(new BigDecimal("1"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0761()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0762()
  {
    rc_int = (new BigDecimal("3.2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0763()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0764()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-3.2")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0765()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("1")).hashCode();
////    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0766()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0768()
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
  public void testItem_0769()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    rc_int = (new BigDecimal("8")).intValueExact();
    Assert.assertEquals(8, rc_int);
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).setScale(-1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0773()
  {
    rc_int = (new BigDecimal("8")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0774()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0775()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("-3.2")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0777()
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
  public void testItem_0778()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    rc_int = (new BigDecimal("8")).intValueExact();
    Assert.assertEquals(8, rc_int);
  }
  public void testItem_0781()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0782()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0783()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, 0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0786()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("579LI955LTY8BH:=KOWYIM?5RFE=DS4YBV:?2GPS2OR199NNC?2@:VMN4JQG8C1W6UU9Y9@552>LSHBQ:;JX9:YOP65S85B0:UK0");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0787()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0788()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0789()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0790()
  {
    rc_BigInteger = (new BigDecimal("8")).toBigIntegerExact();
    Assert.assertEquals("8", rc_BigInteger.toString());
  }
  public void testItem_0791()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0792()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\uFFFF', '\1', '\0', '\234', '\0', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\1', '8', '\0', '8', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '8', '\0', '\0', '\1', '8', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\234', '8', '\234', '8', '\uFFFF', '\0', '\234', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0793()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_BigDecimal = (new BigDecimal("8")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0796()
  {
    rc_boolean = (new BigDecimal("0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0797()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(-1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0799()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0800()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("0E-2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0801()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0802()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0805()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0810()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("GT=9VG00W6SB=@<KTHHV<LPMRGC1");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0812()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0816()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\1', '8', '\1', '\234', '\234', '\uFFFF', '\1', '8', '\1', '\uFFFF', '8', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\0', '\uFFFF', '\234', '8', '\0', '8', '\1', '\1', '8', '\uFFFF', '8', '\0', '\1', '\234', '8', '\0', '\uFFFF', '\234', '8', '8', '8', '\234', '\1', '\0', '\234', '\234', '\0', '8', '\1', '\234', '\1', '\234', '\0', '8', '\1', '\1', '\0', '8', '\uFFFF', '\0', '\0', '\234', '\234', '\uFFFF', '\0', '\1', '8', '8', '\1', '8', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\234', '\1', '\0', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\234', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0820()
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
  public void testItem_0821()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0822()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0823()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0824()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_BigDecimal = (new BigDecimal("-32")).min(new BigDecimal("32"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("3.2"));
    Assert.assertEquals("10.24", rc_BigDecimal.toString());
  }
  public void testItem_0828()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0830()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).plus();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0831()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\234', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\1', '\uFFFF', '8', '\0', '\0', '8', '\uFFFF', '8', '\1', '\0', '\0', '\0', '\234', '8', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\0', '\234', '\234', '\1', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\1', '\0', '\234', '\0', '\1', '\0', '8', '\uFFFF', '\234', '\1', '\1', '8', '8', '\0', '\234', '\0', '\uFFFF', '\234', '8', '\1', '\1', '\1', '\234', '8', '\1', '\234', '\0', '\234', '\234', '\234', '\0', '\234', '\0', '\1', '\0', '\uFFFF', '8', '\234', '\234', '\0', '\234', '\uFFFF', '\1', '\1', '\234', '\0', '8', '\0', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\1'}, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0832()
  {
    rc_BigDecimal = (new BigDecimal("-32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_int = (new BigDecimal("3.2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0834()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3.2"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0835()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0836()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("320.0E+2147483647"));
////    }
////    catch (java.lang.ArithmeticException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0837()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).remainder(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
////    Assert.assertEquals("3.20E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0838()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0839()
  {
    rc_BigDecimal = (new BigDecimal("-32")).min(new BigDecimal("1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0840()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0841()
  {
    rc_int = (new BigDecimal("320.0E+2147483647")).compareTo(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0842()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0843()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0845()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
//  public void testItem_0848()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
////    Assert.assertEquals("-3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0849()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0851()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).scaleByPowerOfTen(0);
////    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0852()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0853()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\uFFFF', '\uFFFF', '8', '\234', '8', '\0', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '8', '\0', '\234', '\0', '\1', '\234', '8', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\234', '8', '\234', '\uFFFF', '8', '\uFFFF', '\0', '8', '\1', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '8', '8', '\uFFFF', '\1', '8', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '8', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\234', '8', '\1', '\0', '\1', '8', '8', '8', '8', '\234', '\1', '8', '\0'}, -2147483648, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0854()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).add(new BigDecimal("3.2E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0856()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("64")).divide(new BigDecimal("-320.0E+2147483647"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0857()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("320.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0859()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0860()
  {
    rc_boolean = (new BigDecimal("320.0E+2147483647")).equals("=@6YJEL@JWC0DTL=><8I0O8R<142SHW13547=R25M>Y;QSDKTNEIFYH4QX8NDDTOVLID>WCOXHYTC>6AAIFEE6>1G35JBHE8Q>L7");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0861()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("320.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0862()
  {
    rc_BigDecimal = (new BigDecimal("64")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0863()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).subtract(new BigDecimal("320.0E+2147483647"));
////    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0864()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("320.0E+2147483647"), 1);
////    }
////    catch (java.lang.ArithmeticException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0865()
  {
    rc_double = (new BigDecimal("3.2E-2147483646")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0866()
  {
    rc_BigDecimal = (new BigDecimal("64")).add(new BigDecimal("64"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("128", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '\0', '8', '\234', '\234', '\1', '\0', '\1', '\0', '\1', '\1', '8', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\1', '8', '\0', '\234', '8', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\1', '\1', '\0', '\1', '\0', '\1', '8', '\234', '\0', '\234', '\0', '\234', '\uFFFF', '8', '\0', '\0', '\0', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\1', '8', '\1', '\234', '8', '8', '\1', '\uFFFF', '\234', '\0', '8', '\234', '\1', '\234', '8', '\0', '\234', '\uFFFF', '\0', '\234', '\0', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\234', '8', '\uFFFF', '\1', '\0', '\1', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\0'}, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0868()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0869()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).ulp();
////    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0870()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).multiply(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0871()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0872()
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
  public void testItem_0873()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0875()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("-0.1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
////    }
////    catch (java.lang.OutOfMemoryError e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0876()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("1135879015891"));
////    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0877()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0879()
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
  public void testItem_0880()
  {
    rc_String = (new BigDecimal("00.0E+2147483647")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0881()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '8', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\234', '8', '8', '\234', '\0', '\uFFFF', '\234', '\0', '8', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\1', '\234', '\234', '\1', '\234', '\234', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '8', '8', '\1', '\234', '8', '\uFFFF', '\234', '\0', '\1', '\1', '\1', '\234', '\1', '\0', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '8', '\0', '\234', '\234', '\1', '\1', '\0', '\234', '8', '\0', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '8'}, 0, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0882()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("1135879015891")).subtract(new BigDecimal("1E+2147483647"), new MathContext("precision=2147483647 roundingMode=DOWN"));
////    }
////    catch (java.lang.ArithmeticException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0883()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("MBW=5MO<PE>S8A4GGILA42O2?0T3?HIGHJ5:@J<2H842QR>8WWXFUH=87<HE94XQE2>5ED?UG1X2J17=D4D6>VH496RDYL9JL>7R", new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0884()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("WE<5;C=86XW?GWK?<Q<19:@?AY0MN8PMD1:AT1QKK99XC4VX:6SVIEGNSNJ@RBU47XBDW59DXUB5OH93");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0885()
  {
    rc_float = (new BigDecimal("1135879015891")).floatValue();
    Assert.assertEquals(1.135878995968E12F, rc_float, 0);
  }
  public void testItem_0886()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
//  public void testItem_0887()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1135879015891")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0888()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).compareTo(new BigDecimal("1135879015891"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0889()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("1E+2147483647")).multiply(new BigDecimal("1135879015891"));
////    Assert.assertEquals("1.135879015891E+2147483660", rc_BigDecimal.toString());
//  }
  public void testItem_0890()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).subtract(new BigDecimal("1135879015891"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0891()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("11358790158910.0E+2147483647")).remainder(new BigDecimal("1E+2147483647"), new MathContext("precision=0 roundingMode=DOWN"));
////    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0892()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_double = (new BigDecimal("11358790158910.0E+2147483647")).doubleValue();
    Assert.assertEquals(java.lang.Double.POSITIVE_INFINITY, rc_double, 0);
  }
//  public void testItem_0894()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigInteger = (new BigDecimal("11358790158910.0E+2147483647")).toBigIntegerExact();
////    }
////    catch (java.lang.ArithmeticException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0895()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0896()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("1135879015891")).hashCode();
////    Assert.assertEquals(2107853717, rc_int);
//  }
  public void testItem_0897()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0898()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0899()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0900()
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
  public void testItem_0901()
  {
    rc_BigInteger = (new BigDecimal("1135879015891")).unscaledValue();
    Assert.assertEquals("1135879015891", rc_BigInteger.toString());
  }
//  public void testItem_0902()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("11358790158910.0E+2147483647")).abs();
////    Assert.assertEquals("1.135879015891E+2147483660", rc_BigDecimal.toString());
//  }
  public void testItem_0903()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).add(new BigDecimal("00.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("11358790158910.0E+2147483647")).divideToIntegralValue(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0905()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("00.0E+2147483647"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0906()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("1135879015891")).subtract(new BigDecimal("11358790158910.0E+2147483647"));
////    }
////    catch (java.lang.ArithmeticException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0907()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("11358790158910.0E+2147483647")).remainder(new BigDecimal("11358790158910.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=DOWN"));
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
////    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
////    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0909()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("11358790158910.0E+2147483647")).ulp();
////    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0910()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("1135879015891")).hashCode();
////    Assert.assertEquals(2107853717, rc_int);
//  }
  public void testItem_0911()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("11358790158910.0E+2147483647")).multiply(new BigDecimal("11358790158910.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0912()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_BigDecimal = (new BigDecimal("11358790158910.0E+2147483647")).add(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_UP"));
////    }
////    catch (java.lang.ArithmeticException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).subtract(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0915()
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
//  public void testItem_0916()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).remainder(new BigDecimal("-1E+12"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
////    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0917()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("1E+2147483647")).abs();
////    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0918()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
//  public void testItem_0919()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("1E+2147483647")).stripTrailingZeros();
////    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0920()
  {
    rc_boolean = (new BigDecimal("00.0E+2147483647")).equals("Y6YGU15YAR>F<1J@KQIUX<M2KRG<FTS@M9NHIRFDQBBMBFFG>HB@:7I=QT6P0JUCB005?X3MIUG=I?4Y>42");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0921()
//  {
//    boolean caught;
////    rc_String = (new BigDecimal("1E+2147483647")).toString();
////    Assert.assertEquals("1E+2147483648", rc_String);
//  }
  public void testItem_0922()
  {
    rc_BigDecimal = (new BigDecimal("-1E+12")).divide(new BigDecimal("-1E+12"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0923()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0924()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("-1E+12"), new MathContext("precision=1 roundingMode=HALF_UP"));
////    Assert.assertEquals("0E+2147483636", rc_BigDecimal.toString());
//  }
//  public void testItem_0925()
//  {
//    boolean caught;
////    caught = false;
////    try {
////      rc_String = (new BigDecimal("1E+2147483647")).toPlainString();
////    }
////    catch (java.lang.ArithmeticException e) {
////      caught = true;
////    }
////    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0926()
  {
    rc_int = (new BigDecimal("-1E+12")).compareTo(new BigDecimal("0E+2147483636"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0927()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0928()
  {
    rc_String = (new BigDecimal("0E+2147483636")).toString();
    Assert.assertEquals("0E+2147483636", rc_String);
  }
  public void testItem_0929()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+12")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0930()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).remainder(new BigDecimal("-1E+12"), new MathContext("precision=1 roundingMode=HALF_UP"));
////    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0931()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0932()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+2147483636")).divideToIntegralValue(new BigDecimal("00.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0933()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0937()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0"), java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0938()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("-1E+12")).stripTrailingZeros();
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0941()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("00.0E+2147483647")).scale();
////    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0942()
  {
    rc_int = (new BigDecimal("0E+2147483636")).intValue();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0943()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("0")).hashCode();
////    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0944()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E+2147483636"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0945()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483636")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-12", rc_BigDecimal.toString());
  }
  public void testItem_0946()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0E-12"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0947()
  {
    rc_BigDecimal = (new BigDecimal("0E-12")).max(new BigDecimal("-1E+12"));
    Assert.assertEquals("0E-12", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0949()
  {
    rc_BigDecimal = (new BigDecimal("0E-12")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).add(new BigDecimal("0E+2147483636"));
    Assert.assertEquals("0E+2147483636", rc_BigDecimal.toString());
  }
  public void testItem_0951()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    rc_BigInteger = (new BigDecimal("0E+2147483636")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0953()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\234', '8', '8', '\uFFFF', '\1', '\0', '\234', '\0', '8', '8', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\234', '\234', '\1', '\234', '\234', '\234', '\uFFFF', '\234', '\234', '\0', '8', '8', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\234', '\1', '\0', '\1', '\234', '8', '\234', '8', '8', '\1', '\uFFFF', '\234', '8', '\0', '8', '\0', '\1', '8', '\234', '\0', '\1', '\0', '\0', '\uFFFF', '\1', '\1', '8', '\234', '8', '\234', '\0', '\1', '\234', '\0', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0954()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0955()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0956()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("0E+2147483636"));
    Assert.assertEquals("0E+2147483635", rc_BigDecimal.toString());
  }
  public void testItem_0957()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0958()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("3.2"), 2147483647, 1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0959()
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
  public void testItem_0960()
  {
    rc_byte = (new BigDecimal("0E-2147483647")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0961()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '8', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\0', '8', '\0', '\0', '\0', '\1', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\1', '\1', '\0', '\0', '\234', '\234', '8', '\0', '\0', '8', '\uFFFF', '8', '\1', '\234', '\uFFFF', '8', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\1', '\1', '8', '\uFFFF', '\1', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '8', '\1', '\234', '8', '\uFFFF', '\uFFFF', '8', '8', '8', '\0', '\234', '8', '\uFFFF', '\0', '\1', '8', '\234', '\uFFFF', '\1', '\234', '\234', '\0', '8', '\0', '8', '8', '\uFFFF', '8', '\234'}, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0962()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+2147483635")).divideAndRemainder(new BigDecimal("3.2"));
  }
  public void testItem_0963()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, 1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0964()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).pow(-1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.3", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    rc_BigDecimal = (new BigDecimal("0.3")).abs();
    Assert.assertEquals("0.3", rc_BigDecimal.toString());
  }
//  public void testItem_0967()
//  {
//    boolean caught;
////    rc_byte = (new BigDecimal("00.0E+2147483647")).byteValueExact();
////    Assert.assertEquals(0, rc_byte);
//  }
  public void testItem_0968()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0969()
//  {
////    boolean caught;
////    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
////    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0970()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0971()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0972()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("00.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0973()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("1")).hashCode();
////    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0974()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0975()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0976()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toString();
    Assert.assertEquals("0E-2147483647", rc_String);
  }
  public void testItem_0977()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '8', '\0', '\0', '\0', '\234', '\0', '8', '8', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\0', '\234', '8', '8', '\1', '\1', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\234', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '8', '\1', '\1', '8', '\234', '\1', '\234', '\234', '\1', '\234', '\uFFFF', '\0', '\234', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\234', '\0', '\0', '\234', '\1', '\1', '\1', '\234', '\uFFFF', '\1', '8', '\0', '\1', '\1', '8', '\0', '8', '8', '\0', '8', '\1', '\0', '\0', '\234', '\1', '8', '\uFFFF', '\0'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0979()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0981()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483635")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0982()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+2147483635")).remainder(new BigDecimal("0E+2147483635"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0983()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("00.0E+2147483647"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0984()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).remainder(new BigDecimal("1"));
////    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0985()
//  {
//    boolean caught;
////    rc_byte = (new BigDecimal("00.0E+2147483647")).byteValueExact();
////    Assert.assertEquals(0, rc_byte);
//  }
  public void testItem_0986()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0987()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
////    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0988()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).negate();
////    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0989()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0990()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0991()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0992()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
////    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0993()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 0, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0994()
  {
    rc_BigInteger = (new BigDecimal("00.0E+2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0995()
  {
    rc_BigInteger = (new BigDecimal("00.0E+2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0996()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
////    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0997()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).multiply(new BigDecimal("00.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0998()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).subtract(new BigDecimal("00.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
////    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).setScale(-1, 0);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
}
