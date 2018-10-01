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
public class TestSuite024 extends TestCase
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
  
  public TestSuite024() {

  }
  public void testItem_0000()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0001()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2147483648")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0002()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).setScale(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0004()
  {
    rc_boolean = (new BigDecimal("-2147483648")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0005()
  {
    rc_int = (new BigDecimal("-2147483648")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0007()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("3E-2147483646")).longValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0008()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("VN?0O;CNDH0?C@8C2SA7NUIEMO9XB3<AOSA6@:FQ0AMW:K2T8;AF<>AA:S;<K?52>97OLYB?1UU3XXEI?1IH27N3W4VAR8O?BCKU");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0009()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).multiply(new BigDecimal("3.2E+2"));
    Assert.assertEquals("9.6E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("-2147483648"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0011()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0013()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\234', '\234', '\234', '\1', '\uFFFF', '\234', '\0', '\1', '\0', '\234', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\0', '\0', '\234', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\0', '\0', '\1', '\0', '\uFFFF', '8', '\0', '\1', '\1', '\1', '\1', '\0', '\uFFFF', '8', '8', '\234', '\234', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\1', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '8', '8', '\uFFFF', '8', '\0', '\234', '\uFFFF', '8', '8', '\234', '\0', '8', '8', '\0', '\1', '\0', '\234', '\uFFFF', '\1', '\0', '\234', '8', '\1', '\0', '\1', '\1', '\234', '8', '\234', '\0', '\1', '\234'}, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0014()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0015()
  {
    rc_boolean = (new BigDecimal("3E-2147483646")).equals("I=X;5UVM9WW2PDD2>6R:TK7W<RC8CAP=IX=YA:KI>X5PXK1H5?J=6IKX1MIB=GJ7EE8@AI=IDIF:>J4?@3USAR");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0016()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("FD@80WY><EKE8VESXK0VHE3HM;>HELN<LCK@N1=H8BH1P6KV=MLFOR2WK6RJ8<;GRA2K3=PD;HJ6<CBQU7JG<H??CL5>2OM8HVJ4", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0018()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("3E+9", rc_BigDecimal.toString());
  }
//  public void testItem_0019()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("-2147483648"), new MathContext("precision=0 roundingMode=DOWN"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).divideToIntegralValue(new BigDecimal("3E+9"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0022()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+9")).divide(new BigDecimal("3E+9"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0023()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divideToIntegralValue(new BigDecimal("-2147483648"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("2147483647"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0027()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).round(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0028()
  {
    rc_float = (new BigDecimal("-2147483648")).floatValue();
    Assert.assertEquals(-2.147483648E9F, rc_float, 0);
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).multiply(new BigDecimal("3E+9"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0031()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0032()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0033()
  {
    rc_int = (new BigDecimal("3E+9")).scale();
    Assert.assertEquals(-9, rc_int);
  }
  public void testItem_0034()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).subtract(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0035()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0036()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0037()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0039()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("3E+9"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0040()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3.2E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0041()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0042()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("3E+9"));
    Assert.assertEquals("3000000032", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0043()
  {
    rc_boolean = (new BigDecimal("1")).equals("P6ESWTGKJ<;7RREMD<MAWEEI467>=QRI0MC05F:WVI:WT=8IYALQPNU=<ELDV<>JGB;1GI>QIS=CJKDGS:0YWB7J>:VDNQJ2=YSH");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0044()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).divide(new BigDecimal("3000000032"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("3E+9"));
    Assert.assertEquals("3000000001", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3E+9")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0047()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E+9"), -1, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0048()
  {
    rc_BigDecimal_array = (new BigDecimal("3000000032")).divideAndRemainder(new BigDecimal("3000000032"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
  }
  public void testItem_0049()
  {
    rc_BigDecimal_array = (new BigDecimal("-2147483648")).divideAndRemainder(new BigDecimal("-2147483648"));
  }
  public void testItem_0050()
  {
    rc_int = (new BigDecimal("3E+9")).compareTo(new BigDecimal("3E+9"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0051()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 0, 1, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0052()
  {
    rc_BigDecimal = (new BigDecimal("3000000032")).plus();
    Assert.assertEquals("3000000032", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    rc_long = (new BigDecimal("0E+9")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0054()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0055()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("3000000000", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '8', '\234', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\1', '\234', '8', '\0', '8', '\1', '\234', '8', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\1', '8', '\uFFFF', '\234', '8', '\uFFFF', '\234', '8', '8', '\234', '\234', '\uFFFF', '\1', '\1', '\0', '\0', '\uFFFF', '\234', '\234', '\1', '\0', '\0', '\234', '\1', '\234', '\0', '\234', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '8', '\0', '\uFFFF', '8', '\1', '\234', '8', '8', '\1', '\uFFFF', '8', '\1', '\234', '\234', '8', '8', '\0', '\234', '\1', '\0', '\0', '\uFFFF', '\234', '\1', '\234', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\234'}, 2147483647, 1, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0057()
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
  public void testItem_0058()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-2147483648"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-5E-10", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3000000001", rc_BigDecimal.toString());
  }
  public void testItem_0060()
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
  public void testItem_0061()
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
  public void testItem_0062()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("NXDCC=VJBEM7V@RG<;JQ=@E?UIU7?<HF;04=PU=V>K<32YY0>T2VN;SJTH922BRRVTJ>U8NRQ:HOM83XM:DESBN55WUV?SN19WB=");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0063()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3E+9")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
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
      rc_int = (new BigDecimal("3000000001")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0065()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("?ETO3SHO2R3XFR03GFJQ22J9T@U");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("3000000032")).divideToIntegralValue(new BigDecimal("3000000032"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_int = (new BigDecimal("3E+9")).intValue();
    Assert.assertEquals(-1294967296, rc_int);
  }
  public void testItem_0069()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0070()
  {
    rc_String = (new BigDecimal("3E+9")).toEngineeringString();
    Assert.assertEquals("3E+9", rc_String);
  }
  public void testItem_0071()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\1', '8', '\234', '\234', '\234', '\0', '\1', '\234', '8', '\uFFFF', '8'});
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
      rc_BigDecimal = (new BigDecimal("3E+9")).setScale(2147483647, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0073()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\uFFFF', '\0', '8', '\234', '\0', '\0', '\1', '\1', '\234', '8', '\1', '\0', '8', '\1', '8', '\uFFFF', '\234', '\0', '\0', '\234', '\0', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\1', '\0', '\1', '\uFFFF', '\0', '\0', '\0', '\234', '\234', '\234', '\234', '\uFFFF', '\0', '8', '8', '\1', '\uFFFF', '8', '\234', '\1', '\234', '8', '\uFFFF', '8', '\234', '8', '\1', '8', '8', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\234', '8', '\uFFFF', '\234', '8', '\234', '\234', '\234', '\0', '\1', '\uFFFF', '8', '\234', '\0', '\234', '8', '\1'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0074()
  {
    rc_int = (new BigDecimal("3000000032")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0075()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).setScale(-1, 1);
    Assert.assertEquals("3.00000000E+9", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3000000032")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0077()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\1', '\0', '\1', '\1', '8', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\0', '\1', '\234', '8', '\1', '\0', '8', '\1', '8', '8', '\234', '\0', '\234', '\1', '\0', '\1', '8', '\0', '\1', '\0', '\uFFFF', '8', '\1', '\0', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\1', '8', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\234', '\0', '\234', '8', '\1', '8', '\0', '\234', '8', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\1', '8', '\0', '\uFFFF', '\234', '8', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\234'}, -2147483648, -1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0078()
  {
    rc_int = (new BigDecimal("3E+9")).intValue();
    Assert.assertEquals(-1294967296, rc_int);
  }
  public void testItem_0079()
  {
    rc_BigInteger = (new BigDecimal("3.00000000E+9")).unscaledValue();
    Assert.assertEquals("300000000", rc_BigInteger.toString());
  }
  public void testItem_0080()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+9")).divide(new BigDecimal("3000000032"), new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0081()
  {
    rc_float = (new BigDecimal("3000000032")).floatValue();
    Assert.assertEquals(3.0E9F, rc_float, 0);
  }
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).max(new BigDecimal("3000000032"));
    Assert.assertEquals("3000000032", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("3000000032")).divide(new BigDecimal("3000000032"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_BigInteger = (new BigDecimal("1.0")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0085()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).round(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("3.00000000E+9"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("3000000001", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    rc_BigDecimal = (new BigDecimal("3.00000000E+9")).remainder(new BigDecimal("3000000001"));
    Assert.assertEquals("3.00000000E+9", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_BigDecimal_array = (new BigDecimal("3.00000000E+9")).divideAndRemainder(new BigDecimal("3.00000000E+9"));
  }
  public void testItem_0089()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3000000001")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0090()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1.0"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0092()
  {
    rc_BigInteger = (new BigDecimal("3000000001")).unscaledValue();
    Assert.assertEquals("3000000001", rc_BigInteger.toString());
  }
  public void testItem_0093()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("KONUXSOEN1J@FMCD0XVD7T61V7R<5OCIX?Q<9NJU;4IM13A8N3M5I4=9TEBQ;;>VXM90<C0L0L0=NI1MP1OW;65JDM5NWXJQO;NR");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("3000000001")).plus(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("3000000001", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("3000000001"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0096()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("1135879015891"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0097()
  {
    rc_BigDecimal_array = (new BigDecimal("3000000001")).divideAndRemainder(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
  }
  public void testItem_0098()
  {
    rc_BigDecimal = (new BigDecimal("3.00000000E+9")).add(new BigDecimal("1135879015891"));
    Assert.assertEquals("1138879015891", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    rc_BigDecimal = (new BigDecimal("1138879015891")).subtract(new BigDecimal("3.00000000E+9"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("1138879015891")).multiply(new BigDecimal("3.00000000E+9"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.41663704767300000000E+21", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0102()
  {
    rc_String = (new BigDecimal("3.00000000E+9")).toPlainString();
    Assert.assertEquals("3000000000", rc_String);
  }
  public void testItem_0103()
  {
    rc_int = (new BigDecimal("3.00000000E+9")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0104()
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
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("3.00000000E+9")).plus();
    Assert.assertEquals("3.00000000E+9", rc_BigDecimal.toString());
  }
  public void testItem_0106()
  {
    rc_BigDecimal = (new BigDecimal("3.00000000E+9")).divideToIntegralValue(new BigDecimal("3000000001"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1138879015891")).divide(new BigDecimal("3.00000000E+9"), -2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0108()
  {
    rc_long = (new BigDecimal("1138879015891")).longValue();
    Assert.assertEquals(1138879015891L, rc_long);
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("3.00000000E+9")).plus();
    Assert.assertEquals("3.00000000E+9", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3000000001")).divide(new BigDecimal("1E+12"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0112()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\1', '\uFFFF', '\1', '8', '8', '\1', '\1', '\234', '\234', '\234', '\1', '\0', '\1', '\uFFFF', '\1', '8', '\0', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\0', '8', '\234', '\0', '\1', '\1', '\1', '\uFFFF', '8'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0113()
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
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(-2147483648, 0);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    rc_String = (new BigDecimal("3000000001")).toPlainString();
    Assert.assertEquals("3000000001", rc_String);
  }
  public void testItem_0116()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3000000001")).pow(1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0117()
  {
    rc_BigDecimal = (new BigDecimal("3000000001")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3000000001", rc_BigDecimal.toString());
  }
  public void testItem_0118()
  {
    rc_BigDecimal = (new BigDecimal("3.00000000E+9")).stripTrailingZeros();
    Assert.assertEquals("3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1138879015891")).divide(new BigDecimal("3000000001"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0120()
  {
    rc_BigDecimal = (new BigDecimal("3000000001")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.000000001E+10", rc_BigDecimal.toString());
  }
  public void testItem_0121()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.00000000E+9")).divide(new BigDecimal("3E+9"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0124()
  {
    rc_long = (new BigDecimal("1138879015891")).longValue();
    Assert.assertEquals(1138879015891L, rc_long);
  }
  public void testItem_0125()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3.00000000E+9")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0126()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    rc_BigDecimal = new BigDecimal("1");
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigDecimal = (new BigDecimal("3.00000000E+9")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3000000001", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("3.00000000E+9"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0130()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("1138879015891"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0132()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    rc_BigDecimal = (new BigDecimal("3.00000000E+9")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("3.00000000E+9", rc_BigDecimal.toString());
  }
  public void testItem_0134()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.00000000E+9")).pow(1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0135()
  {
    rc_boolean = (new BigDecimal("3.00000000E+9")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0136()
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
  public void testItem_0137()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.00000000E+9")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0140()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    rc_long = (new BigDecimal("3.00000000E+9")).longValueExact();
    Assert.assertEquals(3000000000L, rc_long);
  }
  public void testItem_0143()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0144()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0145()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0146()
  {
    rc_BigDecimal = (new BigDecimal("3.00000000E+9")).max(new BigDecimal("3000000001"));
    Assert.assertEquals("3000000001", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    rc_BigDecimal = (new BigDecimal("3.00000000E+9")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("3000000001", rc_BigDecimal.toString());
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("3000000001")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0150()
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
  public void testItem_0151()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0153()
  {
    rc_int = (new BigDecimal("3.00000000E+9")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0154()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0156()
  {
    rc_BigDecimal = (new BigDecimal("3.00000000E+9")).divide(new BigDecimal("2147483647"), java.math.RoundingMode.UP);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0157()
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
  public void testItem_0158()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).remainder(new BigDecimal("1E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).abs(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0161()
  {
    rc_BigInteger = (new BigDecimal("3.00000000E+9")).toBigIntegerExact();
    Assert.assertEquals("3000000000", rc_BigInteger.toString());
  }
  public void testItem_0162()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).toBigIntegerExact();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
  public void testItem_0163()
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
  public void testItem_0164()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("2147483647"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0165()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '8', '\0', '\1', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '8', '8', '\uFFFF', '\234', '8', '\1', '\234', '\0', '\234', '\234', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\234', '\1', '8', '\1', '\0', '8', '\0', '\1', '\uFFFF', '8', '\234', '\uFFFF', '8', '\0', '8', '8', '\234', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\0', '\234', '\0', '\1', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '8', '8', '8', '\0', '\234'}, -1, 2147483647, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\0', '\234', '8', '\234', '\234', '\1', '\234', '8', '\234', '8', '8', '\uFFFF', '\0', '8', '8', '\0', '\0', '\1', '\234', '8', '\1', '\234', '\1', '8', '\uFFFF', '8', '\0', '\1', '\234', '\0', '\1', '\0', '\234', '\1', '\1', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\234', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\234', '\0', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\234', '\1', '\1', '\1', '\1', '\234', '\0', '\234', '8', '\1', '\uFFFF', '\1', '\1', '\1', '\234', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\234', '8'}, 1, -2147483648, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0168()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0169()
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
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2147483647"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0171()
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
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("2147483647"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0174()
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
  public void testItem_0175()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).pow(1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0177()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0178()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("2147483647"));
    Assert.assertEquals("2147483679", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0182()
  {
    rc_int = (new BigDecimal("2147483647")).compareTo(new BigDecimal("2147483679"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0183()
  {
    rc_BigDecimal = (new BigDecimal("2147483679")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0184()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0186()
  {
    rc_String = (new BigDecimal("2147483647")).toEngineeringString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0187()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0189()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    rc_double = (new BigDecimal("2147483647")).doubleValue();
    Assert.assertEquals(2.147483647E9, rc_double, 0);
  }
  public void testItem_0192()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).movePointLeft(0);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0194()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("9223372036854775807")).divideAndRemainder(new BigDecimal("9223372036854775807"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0195()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toPlainString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_float = (new BigDecimal("9223372036854775807")).floatValue();
    Assert.assertEquals(9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0198()
  {
    rc_long = (new BigDecimal("9223372036854775807")).longValue();
    Assert.assertEquals(9223372036854775807L, rc_long);
  }
  public void testItem_0199()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), 1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\uFFFF', '\234', '8', '\0', '\1', '\234', '\1', '\234', '\0', '\uFFFF', '\0', '\1', '\234', '\1', '8', '\0'}, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0201()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("2147483647"));
    Assert.assertEquals("4294967294", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("4294967294")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0204()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=1 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0205()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("320.0E+2147483647"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0208()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("4294967294")).setScale(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("4294967294.0", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    rc_long = (new BigDecimal("4294967294.0")).longValueExact();
    Assert.assertEquals(4294967294L, rc_long);
  }
  public void testItem_0211()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0213()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0214()
  {
    rc_String = (new BigDecimal("4294967294.0")).toPlainString();
    Assert.assertEquals("4294967294.0", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0215()
  {
    rc_boolean = (new BigDecimal("4294967294.0")).equals("VFS;;H76AH57C8576K7;3ATBB42=7?;FXE@G?<WOS56FR5S0TUN78DX69C;?WKROWO58XABO2VIL5FY688SSOSC>9SNWQF?1NHY5");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0216()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("4294967294.0"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0219()
  {
    rc_BigDecimal = (new BigDecimal("4294967294.0")).movePointRight(1);
    Assert.assertEquals("42949672940", rc_BigDecimal.toString());
  }
  public void testItem_0220()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("4294967294.0")).add(new BigDecimal("-1"));
    Assert.assertEquals("4294967293.0", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0224()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("4294967293.0"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0225()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("4294967293.0"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-4E+9", rc_BigDecimal.toString());
  }
  public void testItem_0226()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1E+308", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0229()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).unscaledValue();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0230()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-4E+9")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0231()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).max(new BigDecimal("4294967293.0"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0234()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0235()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0236()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0237()
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
  public void testItem_0238()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\0', '8', '\234', '\uFFFF', '\234', '\234', '\234', '\uFFFF'}, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0240()
  {
    rc_BigInteger = (new BigDecimal("4294967293.0")).toBigIntegerExact();
    Assert.assertEquals("4294967293", rc_BigInteger.toString());
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(">>O>M>Q?IM5;5AIV;PD9N4ASI4C50K<3E;DHS?99>;NJ;U4RB9:R<COW2YG0IB?JHCI1RIWAOGUNB=<VK1=2QCI>V24<C:W293WF");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0244()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0245()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0248()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0249()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
//  public void testItem_0250()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).hashCode();
//    Assert.assertEquals(2706431, rc_int);
//  }
  public void testItem_0251()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0252()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0253()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '8', '\1', '\1', '\0', '8', '8', '\234', '8', '\234', '8', '\234', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\1', '\1', '8', '8', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\0', '8', '\1', '\0', '\uFFFF', '8', '\234', '\234', '\234', '\234', '8', '\234', '\1', '\1', '\uFFFF', '\1', '\1', '\1', '\234', '8', '8', '\234', '8', '\234', '\0', '\0', '\1', '8', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\0', '\1', '8', '\234', '\0', '\234', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '8', '8', '\0', '8', '\uFFFF', '\0', '\1', '8', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0254()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
//  public void testItem_0255()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0256()
  {
    rc_boolean = (new BigDecimal("3E-2147483647")).equals("J<128>T8RWCCW;43T@IS77<LOT:=MWA8TE:B=RA8Y>;<S8XF4>:1HKVJYNPNR9;CQPNO?IN62HT5>SO=P4KWSYQJDCW7Q38VFMK>");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0257()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858336", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).movePointRight(2147483647);
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0259()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858336")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0260()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858336"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858336")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858336")).add(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    rc_BigDecimal = (new BigDecimal("3")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
//  public void testItem_0265()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483647")).divideToIntegralValue(new BigDecimal("3E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0266()
  {
    rc_String = (new BigDecimal("3E-2147483647")).toString();
    Assert.assertEquals("3E-2147483647", rc_String);
  }
  public void testItem_0267()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).min(new BigDecimal("1"));
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0268()
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
//  public void testItem_0269()
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
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).plus();
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0272()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0273()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0274()
  {
    rc_String = (new BigDecimal("3E-2147483647")).toEngineeringString();
    Assert.assertEquals("300E-2147483649", rc_String);
  }
  public void testItem_0275()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).stripTrailingZeros();
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0277()
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
  public void testItem_0278()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0279()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0280()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0281()
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
  public void testItem_0282()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).movePointRight(0);
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0285()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0286()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate();
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).remainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0288()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0289()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("343QYB<LA?A=U7?XEVR4=XV?>>@SBN8=");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0290()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0291()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).stripTrailingZeros();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).unscaledValue();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0293()
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
  public void testItem_0294()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).remainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0297()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointRight(1);
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).negate();
    Assert.assertEquals("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0300()
  {
    rc_String = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).toEngineeringString();
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_String);
  }
  public void testItem_0301()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0302()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0303()
  {
    rc_BigInteger = (new BigDecimal("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).toBigInteger();
    Assert.assertEquals("-1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigInteger.toString());
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680"), 1, 0);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).round(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigDecimal.toString());
  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0308()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).plus();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_long = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0313()
  {
    rc_int = (new BigDecimal("0.1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0314()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0315()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("LS77G2>5Q1X937IVD6");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0317()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\1', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\234', '\234', '\1', '\234', '\uFFFF', '\234', '8', '\uFFFF', '8', '8', '\234', '8', '\1', '8', '\0', '\0', '\0', '\uFFFF', '8', '\uFFFF', '8', '8', '\0', '\0', '\0', '\0', '\uFFFF', '\0', '\1', '8', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\234', '\uFFFF', '\0', '\234', '8', '\0', '8', '8', '\234', '8', '8', '\234', '8', '8', '8', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\0', '\234', '\0', '\234', '8', '\234', '8', '8', '\0', '8', '8', '\0', '\234', '\uFFFF', '\234', '\0', '8', '\234', '8', '\234', '\0', '8', '\0', '\1', '\1', '\uFFFF'}, 1, -2147483648, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).min(new BigDecimal("2"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0320()
  {
    rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).setScale(1);
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680.0", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    rc_BigDecimal = (new BigDecimal("2")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0322()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0323()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).pow(0, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0327()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("JHRJL:M37>UJ<;75>J1<=@0Q2NEMUIJCUEQ7B??A;=B8A5K9?O0IYY4OSCA92R45P9BXKCJ0C:L?37SPLSTI@KYM5GST@3XE?81Y", new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0329()
  {
    rc_boolean = (new BigDecimal("1")).equals(";9GCL69GYXN4I:Y>MBR3KIE:?O5:V5:0C=:09JV1QRX4=CY:AJGRSCJY1K9AEBFCJ88F@B6NGGX@=3G16CF@2MW@=K><LKU2H=KF");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("2")).setScale(1);
    Assert.assertEquals("2.0", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    rc_int = (new BigDecimal("0E+1")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0332()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).divide(new BigDecimal("0E+1"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).plus();
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_long = (new BigDecimal("2.0")).longValue();
    Assert.assertEquals(2L, rc_long);
  }
  public void testItem_0335()
  {
    rc_String = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).toPlainString();
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_String);
  }
  public void testItem_0336()
  {
    rc_int = (new BigDecimal("2")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0337()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0338()
  {
    rc_boolean = (new BigDecimal("0E+1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0339()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).divideToIntegralValue(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0344()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_BigDecimal = (new BigDecimal("2")).divide(new BigDecimal("2"), 1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
//  public void testItem_0346()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).hashCode();
//    Assert.assertEquals(-1806665450, rc_int);
//  }
  public void testItem_0347()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("F0CU>V5V7O52HW@:DFLLUEA9S07I3W:S4R8NK582<LMVSAA7RUHQ?W?J2@VLCERB8BVFW5OI0P9W>LNYJ8QC4X5T:VKTQI510KEG", new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0348()
  {
    rc_int = (new BigDecimal("2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0349()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(-2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0350()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0351()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    rc_long = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).divide(new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0356()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).scaleByPowerOfTen(0);
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(-1, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).divide(new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0362()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("DN03QDT4I3MD:U:H=HDFBUA<MBTU9SY2C2W2::4CEYPGXB3@44U;YSWS36<5:IGND7BKOGXBM8A0KXH3N64RTYE=OKW373IDCY?I", new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0363()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0364()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0365()
  {
    rc_short = (new BigDecimal("3E+1")).shortValueExact();
    Assert.assertEquals(30, rc_short);
  }
  public void testItem_0366()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0367()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0368()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).movePointRight(1);
    Assert.assertEquals("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836800", rc_BigDecimal.toString());
  }
  public void testItem_0371()
  {
    rc_BigInteger = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836800")).unscaledValue();
    Assert.assertEquals("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836800", rc_BigInteger.toString());
  }
  public void testItem_0372()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("2E+308")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0373()
  {
    rc_BigDecimal = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).add(new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836800"));
    Assert.assertEquals("19774624483485472789598016610487479247787762427842949625880922448347298685803139263664851449604356598869450484886582071065775345957841060104531430137389126868465490163420641028387003909942826183848345535930064733653504156059354524298238941526533568310227760882455919548561199489901122986937544442880253734420480", rc_BigDecimal.toString());
  }
  public void testItem_0374()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0375()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '8', '\1', '8', '\0', '\1', '8', '\1', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\1', '8', '\234', '\234', '\0', '8', '\234', '\234', '8', '\234', '\0', '8', '\0', '\1', '\0', '\uFFFF', '\234', '\0', '\1', '8', '\uFFFF', '\uFFFF', '8', '\1', '\234', '8', '\234', '8', '\0', '8', '8', '\1', '\1', '\1', '\1', '8', '\234', '8', '\0', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\1', '8', '\uFFFF', '\0', '\234', '8', '\234', '8', '\uFFFF', '\1'}, 0, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("19774624483485472789598016610487479247787762427842949625880922448347298685803139263664851449604356598869450484886582071065775345957841060104531430137389126868465490163420641028387003909942826183848345535930064733653504156059354524298238941526533568310227760882455919548561199489901122986937544442880253734420480"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0377()
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
  public void testItem_0378()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    rc_BigDecimal = (new BigDecimal("19774624483485472789598016610487479247787762427842949625880922448347298685803139263664851449604356598869450484886582071065775345957841060104531430137389126868465490163420641028387003909942826183848345535930064733653504156059354524298238941526533568310227760882455919548561199489901122986937544442880253734420480")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0380()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_int = (new BigDecimal("2")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0384()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -1, 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0386()
  {
    rc_BigDecimal = (new BigDecimal("2")).divide(new BigDecimal("-1"), -1, 0);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_int = (new BigDecimal("-1E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0389()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("-1E+1"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0390()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0392()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0397()
  {
    rc_boolean = (new BigDecimal("2")).equals("<EC0?V95@=QIV5KFW67YNE0A<AOO04GA2E7>@JU637DHY0SQ091J55XILR@FHM3A;8C<D@0>VM6IF<H7WR5G6AT5101GQXWF;EO6");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0398()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0399()
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
  public void testItem_0400()
  {
    rc_int = (new BigDecimal("3.2")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0401()
  {
    rc_String = (new BigDecimal("2")).toEngineeringString();
    Assert.assertEquals("2", rc_String);
  }
  public void testItem_0402()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0403()
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
  public void testItem_0404()
  {
    rc_byte = (new BigDecimal("2")).byteValueExact();
    Assert.assertEquals(2, rc_byte);
  }
  public void testItem_0405()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0406()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("10.24", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    rc_BigDecimal = (new BigDecimal("10.24")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("10.3", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(-1, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0412()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0415()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0416()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0417()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0418()
  {
    rc_float = (new BigDecimal("9223372036854775807")).floatValue();
    Assert.assertEquals(9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0419()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0421()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
//  public void testItem_0423()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("0.1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0424()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0427()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1, 0);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0429()
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
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '8', '\0', '\1', '\uFFFF', '\1', '\1', '\1', '\1', '8', '\1', '8', '8', '8', '\0', '\234', '8', '\1', '8', '8', '8', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\234', '\0', '\234', '\0', '\uFFFF', '8', '\1', '8', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\234', '8', '\1', '\234', '\1', '8', '8', '\234', '\uFFFF', '\0', '8', '\0', '8', '\234', '8', '8', '\1', '\234', '8', '\uFFFF', '8', '\234', '8', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\234', '\234', '8', '\234', '\1', '\234', '\1', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\1', '8', '8', '\1', '\1', '\uFFFF', '\0', '8', '\1', '\234', '\0', '8', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0432()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0434()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0437()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0438()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("?N56RQUGA>D4CH?OLQO=UVW;0?AS0J@YME=X<WUPN?WXX69DUDQ<MCTM8DKM6JYVEACS61PXA=QU;JQGPFLAS>UP542OWF3BV<R4");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0439()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0440()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0442()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0443()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).pow(1);
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0444()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("CKP:L81VOWLUGA<0A5INPP9?H?JQ4A7VM@IVOMI;L5M=I>T@1B=PJ3X1>43M>U01G7@BG;AO2RD9FVV");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0445()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).negate();
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0446()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-301", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_String = (new BigDecimal("3E+2")).toPlainString();
    Assert.assertEquals("300", rc_String);
  }
  public void testItem_0448()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0449()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0450()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\1', '\234', '\234', '\1', '\234', '\0', '\uFFFF', '\1', '\234', '\1', '\1', '\1', '\1', '8', '\1', '8', '\1', '\1', '\234', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\0', '\234', '8', '\1', '8', '\0', '8', '8', '\234', '\1', '\uFFFF', '8', '\234', '8', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '\234', '\0', '\uFFFF'}, -1, -2147483648, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0451()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0454()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\1', '8', '\234', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '8', '\uFFFF', '\234', '\1', '\0', '8', '8', '\1', '\1', '8', '\234', '\1', '8', '\0', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\234', '\0', '\1', '8', '\uFFFF', '\234', '8', '\uFFFF', '\234', '8', '\1', '8', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\0', '8', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0458()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0459()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("9W0UV9BBT6T2OJ47Y6?FOT5U3=ILY53R876JDOU9A1AB:MMHSAU?T5EATYJF0T17OFE;@M4:I20:XFJUP7M2T=BPIJ", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0461()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\234', '\234', '\234', '\uFFFF', '8', '\1', '\0', '\0', '\uFFFF', '\234', '8', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\0', '\0', '\1', '8', '8', '8', '\234', '\uFFFF', '\0', '\0', '8', '\1', '8', '\uFFFF', '8', '8', '8', '\0', '\234', '8', '\234', '\234', '8', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '8', '\0', '\0', '\234', '\1', '\0', '8', '\uFFFF', '8', '\0', '\1', '\0', '8', '\1', '\1', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\234', '\0', '8', '\234', '\1', '\1', '\1', '\0', '\1', '\uFFFF', '\1', '8', '\234', '\0', '\uFFFF', '\1', '8', '\0', '8', '8', '8', '8', '\0', '\0', '\1', '\0', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0463()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0464()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0465()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\1', '\0', '8', '\uFFFF', '\234', '\1', '8', '8', '\0', '8', '\1', '\uFFFF', '\1', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '8', '8', '8', '\1', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\0'}, -2147483648, -1, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0469()
  {
    rc_short = (new BigDecimal("-3E+2")).shortValueExact();
    Assert.assertEquals(-300, rc_short);
  }
  public void testItem_0470()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0471()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0473()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\1', '\uFFFF', '\1', '\234', '8', '\234', '\234', '\234', '\0', '\1', '\234', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '8', '\1', '\234', '8', '\234', '8', '\uFFFF', '\0', '8', '\234', '8', '\1', '8', '8', '8', '\1', '\1', '8', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\1', '\1', '\1', '\234', '\234', '\234', '\0', '\uFFFF', '\234', '8', '\0', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '8', '8', '8', '\234', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\1'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0474()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0476()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0477()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0478()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0479()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("6BL;QA9PL=EAP7S7COK47KRJ0?BO06473UWXX6JI?U@B2R6<L<T>S4L9=BB<QMPOY6UXL:EYV==2BWXHOD52GC0IE5FGNIR@18D@");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0480()
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
  public void testItem_0481()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0482()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0485()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
  }
  public void testItem_0489()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0491()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0492()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0494()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0495()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0498()
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
  public void testItem_0499()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0500()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0501()
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
  public void testItem_0502()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0504()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0505()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0506()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0507()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).subtract(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0512()
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
  public void testItem_0513()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0514()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0516()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0518()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0520()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0521()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0522()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("3E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("3E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0524()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3E-2147483646"), -2147483648, java.math.RoundingMode.DOWN);
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0525()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0527()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0528()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0529()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("3E-2147483646"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0532()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0533()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0534()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).min(new BigDecimal("0.1"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0536()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divideToIntegralValue(new BigDecimal("3E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).stripTrailingZeros();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0538()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0539()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
//  public void testItem_0540()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("0.1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-3E-2147483646")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0543()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-3E-2147483646")).divideAndRemainder(new BigDecimal("-3E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0544()
  {
    rc_float = (new BigDecimal("-3E-2147483646")).floatValue();
    Assert.assertEquals(-0.0F, rc_float, 0);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0545()
  {
    rc_boolean = (new BigDecimal("0.1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0546()
  {
    rc_String = (new BigDecimal("0.1")).toEngineeringString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0547()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
//  public void testItem_0548()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E-2147483646")).setScale(-2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0549()
  {
    rc_String = (new BigDecimal("-3E-2147483646")).toEngineeringString();
    Assert.assertEquals("-3E-2147483646", rc_String);
  }
//  public void testItem_0550()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("3.2E-2147483646"), -1, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0551()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0552()
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
  public void testItem_0553()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-3E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0554()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0555()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).max(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toEngineeringString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
//  public void testItem_0560()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E-2147483646")).divideToIntegralValue(new BigDecimal("-3E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483646")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0563()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-3E-2147483646"), java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("0E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0566()
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
//  public void testItem_0567()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("-3E-2147483646")).longValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0568()
  {
    rc_int = (new BigDecimal("-3E-2147483646")).scale();
    Assert.assertEquals(2147483646, rc_int);
  }
  public void testItem_0569()
  {
    rc_int = (new BigDecimal("0E-2147483646")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0570()
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
  public void testItem_0571()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0572()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0573()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).compareTo(new BigDecimal("0E-2147483646"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0574()
  {
    rc_double = (new BigDecimal("3.2E-2147483646")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0575()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).round(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0576()
  {
    rc_BigInteger = (new BigDecimal("3.2")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0577()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0578()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0579()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("0E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0580()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0581()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).add(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0582()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E-2147483646")).hashCode();
//    Assert.assertEquals(-2147482657, rc_int);
//  }
  public void testItem_0583()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0584()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0585()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0587()
  {
    rc_boolean = (new BigDecimal("0E-2147483646")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0589()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).setScale(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0590()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0591()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0592()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
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
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0594()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0595()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0596()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
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
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0598()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0601()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("0E-2147483646"), 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0602()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\234', '\234', '\234', '8', '8', '\0', '\0', '8', '\234', '\234', '\0', '\1', '8', '8', '\0', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '\0', '\234', '\234', '\1', '\1', '\1', '\0', '8', '\234', '\0', '\1', '\uFFFF', '\1', '\1', '\234', '\234', '\0', '\0', '\234', '\0', '\234', '\234', '\uFFFF', '8', '\0', '\uFFFF', '8', '\234', '\234', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\234', '\0', '8', '8', '\uFFFF', '\1', '\0', '8', '8', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '8', '\0'}, -1, 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0603()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\uFFFF', '\234', '8', '8', '\0', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\0', '\1', '\uFFFF', '8', '8', '\1', '8', '8', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\234', '8', '\234', '\0', '\0', '\1', '\0', '\0', '\1', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\234', '\0', '\1', '8', '8', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\0', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '8'}, 0, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0604()
  {
    rc_int = (new BigDecimal("0E-2147483646")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0608()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483646")).divideAndRemainder(new BigDecimal("0E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0610()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("0E-2147483646"), java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0611()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0612()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\1', '8', '\0', '8', '8', '\1', '\uFFFF', '\234', '\1', '\1', '\234', '\1', '8', '\0', '\0', '\1', '\234', '\uFFFF', '8', '\234', '8', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '8', '8', '\1', '8', '\uFFFF', '\1', '\1', '\1', '\0', '\uFFFF', '\0', '\0', '8', '\0', '\1', '8', '\0', '\uFFFF', '\0', '\234', '\1', '\1', '\1', '\234', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\0', '\234', '\uFFFF', '\0', '\234', '\0', '8', '\uFFFF', '\1', '8', '8', '\0', '8', '\1', '\234', '\234', '\0', '\234', '\1', '\uFFFF', '\0', '8', '\1', '8', '8', '\234', '\0', '\0', '\1', '8', '\234', '\uFFFF', '\1', '\1'}, -1, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0613()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0E-2147483646"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0616()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0E-2147483646"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).movePointRight(0);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0619()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("0E-2147483646"), java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0620()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0621()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).add(new BigDecimal("0"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0622()
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
  public void testItem_0623()
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
  public void testItem_0624()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0626()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0627()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0628()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0629()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).add(new BigDecimal("0E-2147483646"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0631()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0632()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).ulp();
    Assert.assertEquals("1E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0633()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\1', '\1', '\0', '\234', '8', '8', '\uFFFF', '\234', '8', '8', '\uFFFF', '8', '\1', '\0', '\234', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\234', '\234', '\234', '\1', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '8', '8', '\234', '8', '\1', '\234', '\uFFFF', '\234', '\1', '\0', '8', '8', '\0', '\0', '\uFFFF', '\1', '8', '\1', '\234', '\234', '\1', '8', '\1', '8', '\uFFFF', '\234', '\1', '\0', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\234', '\0', '\234', '\1', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\0', '\0', '\234', '\1', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0634()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0635()
  {
    rc_BigInteger = (new BigDecimal("1E-2147483646")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
//  public void testItem_0636()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), -2147483648, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0637()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).subtract(new BigDecimal("1E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0638()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0640()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0641()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0642()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483646")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0645()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483646")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0646()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0647()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0648()
  {
    rc_boolean = (new BigDecimal("0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0649()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).scale();
    Assert.assertEquals(1074, rc_int);
  }
  public void testItem_0650()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("0E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0653()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483646")).subtract(new BigDecimal("1E-2147483646"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0654()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483646")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
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
      rc_BigDecimal = (new BigDecimal("1E-2147483646")).divide(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
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
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0658()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483646")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0659()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0660()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0661()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0662()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1E-2147483646")).divideAndRemainder(new BigDecimal("1E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0663()
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
  public void testItem_0664()
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
  public void testItem_0665()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0667()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0668()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483646")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0670()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483646")).divide(new BigDecimal("0"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0672()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_int = (new BigDecimal("9223372036854775807")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0674()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0675()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-9E+18"), -2147483648, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0676()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 0, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0677()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0678()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0680()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("1E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_String = (new BigDecimal("1E-2147483646")).toEngineeringString();
    Assert.assertEquals("1E-2147483646", rc_String);
  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0684()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0687()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\234', '\0', '8', '8', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\0', '\234', '\0', '\0', '\0', '\234', '8', '\1', '8', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\1', '8', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\234', '\0', '\234', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\1', '8', '\uFFFF', '\0', '\1', '\0', '8', '\234', '\0', '\234'}, 1, 2147483647, new MathContext("precision=0 roundingMode=FLOOR"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0688()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0691()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0692()
  {
    rc_String = (new BigDecimal("0E+1")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0693()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0695()
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
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, java.math.RoundingMode.UP);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0699()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+1")).hashCode();
//    Assert.assertEquals(-1, rc_int);
//  }
  public void testItem_0700()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0701()
  {
    rc_int = (new BigDecimal("0E-2147483646")).compareTo(new BigDecimal("0E-2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0702()
  {
    rc_short = (new BigDecimal("0E-2147483646")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0703()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0704()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).stripTrailingZeros();
	Assert.assertEquals(0E+1, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0705()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E+1"), java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0706()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0707()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("0E-2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0711()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).min(new BigDecimal("0"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_double = (new BigDecimal("0E-2147483647")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0714()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).remainder(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0715()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).remainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0716()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+1")).hashCode();
//    Assert.assertEquals(-1, rc_int);
//  }
  public void testItem_0717()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0718()
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
  public void testItem_0719()
  {
    rc_double = (new BigDecimal("00.0E+2147483647")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0720()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0721()
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
  public void testItem_0722()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0723()
  {
    rc_boolean = (new BigDecimal("0E+1")).equals("JBYM16F@<N:U9E7RKHUF>6QCSJ=:EVPH?U@ROTXTLIQRO@7T47>S22>N6SSOUI:1TUT2?WRA@YKW<");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0724()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointLeft(-2147483648);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    rc_String = (new BigDecimal("0E+1")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0729()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0733()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0734()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\234', '8', '\0', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\1', '8', '\0', '8', '\1', '8', '\0', '\uFFFF', '\1', '8', '\1', '\0', '8', '\234', '\0', '8', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\1', '\234', '8', '\234', '\uFFFF', '\1', '\234', '\234', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\1', '\0', '\0', '\1', '\234', '8', '\234', '\0', '\1', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0735()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '8', '\1', '8', '\uFFFF', '\1', '\0', '\234', '8', '\1', '\uFFFF', '\234', '\1', '\0', '\1', '\1', '\0', '\234', '\234', '\234', '\234', '\uFFFF', '\1', '\0', '8', '8', '\uFFFF', '\0', '\234', '\1', '8', '\234', '8', '\0', '\1', '\1', '\0', '\1', '\1', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\234', '\234', '\0', '8', '\uFFFF', '8', '8', '\1', '8', '8', '8', '\1', '\234', '\1', '\1', '8', '\1', '\0', '\uFFFF', '8', '\0', '8', '8', '\uFFFF', '8', '8', '\234', '\234', '\0', '8', '\uFFFF', '\1', '\234', '\1', '8', '\uFFFF', '8', '8', '\0', '\uFFFF', '8', '\uFFFF', '8', '8', '8', '\234', '\1', '\234', '\1', '\234', '\0'}, 0, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0736()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0737()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0738()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0739()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).add(new BigDecimal("32"));
    Assert.assertEquals("-8999999999999999968", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-9E+18"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("-8999999999999999968")).divide(new BigDecimal("32"), -1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("-2.8124999999999999E+17", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("32"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("-2.8124999999999999E+17")).setScale(-1);
    Assert.assertEquals("-2.8124999999999999E+17", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0747()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-2.8124999999999999E+17"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("-2.8124999999999999E+17")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0753()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-2.8124999999999999E+17"));
    Assert.assertEquals("281249999999999991", rc_BigDecimal.toString());
  }
  public void testItem_0754()
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
  public void testItem_0755()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=0 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0760()
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
  public void testItem_0761()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0762()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-1, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0767()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("4M9K0IL50VSRBO00SR@TGEN7M5DTY:63CJ?6RR;RI2HPN1:YSLU9L6UT;ADU=YVBD0L?484JHJ2?QRK:Y;W;>X9G;QQ6@1A61NYC", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0768()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0769()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0770()
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
  public void testItem_0771()
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
  public void testItem_0772()
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
  public void testItem_0773()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0774()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("9223372036854775807")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0775()
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
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0778()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0781()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).toBigIntegerExact();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  public void testItem_0782()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0783()
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
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0786()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0787()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0788()
  {
    rc_boolean = (new BigDecimal("1")).equals("YSUPU9WXPE46VEY;UC=3EXLLWVDJFYRWQQMXS9DN6UAGB?NLUV2@F@S72G9:PY91@LB;C@8CAKQ@M3RT=C0FE:7>N2CV1YMU;;BQ");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0790()
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
  public void testItem_0791()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0792()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0795()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("HXA1;HQ2E5LUE4CLHB9RJX;;6LKIVTBBW60AP@QDB9W9R0KOV;UXDSRRT5D4CVUYNVRGGC1TMK72ANK6T<9O5;");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0796()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0799()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0800()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("=1W68<JPU1H2JA?UPF=LDIG>XCJYGA:O=?76I07NLECPU?T=FB6ST@84B38");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).negate();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0804()
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
  public void testItem_0805()
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
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_BigInteger = (new BigDecimal("0.1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0810()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    rc_BigInteger = (new BigDecimal("0.1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0812()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\234', '8', '\uFFFF', '8', '\0', '8', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\234', '\1', '\0', '8', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\0', '8', '\0', '8', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\234', '8', '8', '\0', '8', '\234', '8', '\234', '8', '8', '8', '\1', '8', '\234', '\1', '\0', '\1', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\1', '8', '\0', '8', '\uFFFF', '8', '8', '\234', '\uFFFF', '\234', '\1', '\234', '8', '\234', '\0', '\234', '\uFFFF', '8', '\1', '8', '\234', '\1', '8', '\0', '8', '8'}, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0813()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("0.1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0.1"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0818()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0821()
  {
    rc_float = (new BigDecimal("0.1")).floatValue();
    Assert.assertEquals(0.10000000149011612F, rc_float, 0);
  }
  public void testItem_0822()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0825()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0827()
  {
    rc_int = (new BigDecimal("3E+1")).compareTo(new BigDecimal("0.0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0828()
  {
    rc_int = (new BigDecimal("0.0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("3E+1"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).stripTrailingZeros();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0831()
  {
    rc_int = (new BigDecimal("3E+1")).compareTo(new BigDecimal("0.0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0832()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0833()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.0")).hashCode();
//    Assert.assertEquals(1, rc_int);
//  }
  public void testItem_0834()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
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
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0836()
  {
    rc_String = (new BigDecimal("3E+1")).toPlainString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0837()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0838()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0839()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("3E+1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0840()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.1")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0841()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0842()
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
  public void testItem_0843()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0845()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\234', '\234', '\0', '\234', '8', '8', '\1', '8', '\1', '\0', '\0', '\1', '\234', '\1', '\0', '\234', '\0', '\0', '8', '\0', '8', '\1', '\1', '\1', '\uFFFF', '8', '\uFFFF', '8', '\0', '\0', '\0', '8', '8', '\uFFFF', '\1', '8', '\0', '8', '\uFFFF', '\1', '\uFFFF', '8', '8', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\234', '\1', '\uFFFF', '8', '\1', '\0', '8', '\1', '\0', '8', '\234', '\234', '\1', '8', '\0', '\1', '8', '\uFFFF', '\234', '\234', '\1', '\0', '\0', '\0', '\234', '\uFFFF', '\0', '\234', '8', '\1', '8', '8', '8', '\234', '\0', '\234', '\1', '\1', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0848()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_long = (new BigDecimal("3.2E+2")).longValue();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0851()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0852()
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
//  public void testItem_0853()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs(new MathContext("precision=0 roundingMode=FLOOR"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0856()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0857()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0858()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0859()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0861()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0862()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0863()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0864()
  {
    rc_BigDecimal = (new BigDecimal("10")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0866()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0867()
  {
    rc_BigDecimal = (new BigDecimal("10")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0868()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0870()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0871()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0872()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0873()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    rc_int = (new BigDecimal("2147483647")).intValueExact();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0875()
  {
    rc_BigInteger = (new BigDecimal("10")).toBigInteger();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  public void testItem_0876()
  {
    rc_BigDecimal = (new BigDecimal("-2")).divideToIntegralValue(new BigDecimal("-2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0877()
  {
    rc_long = (new BigDecimal("-2")).longValueExact();
    Assert.assertEquals(-2L, rc_long);
  }
  public void testItem_0878()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0879()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0881()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0882()
  {
    rc_byte = (new BigDecimal("10")).byteValueExact();
    Assert.assertEquals(10, rc_byte);
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("10")).max(new BigDecimal("0"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("10")).subtract(new BigDecimal("2147483647"));
    Assert.assertEquals("-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-2147483637")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0886()
  {
    rc_BigInteger = (new BigDecimal("-2147483637")).toBigIntegerExact();
    Assert.assertEquals("-2147483637", rc_BigInteger.toString());
  }
  public void testItem_0887()
  {
    rc_BigDecimal = (new BigDecimal("10")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("-2147483637")).plus();
    Assert.assertEquals("-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    rc_BigDecimal = (new BigDecimal("10")).plus(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0890()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483637")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0891()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("-2147483637"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0892()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_BigDecimal = (new BigDecimal("10")).divide(new BigDecimal("10"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_BigDecimal = (new BigDecimal("10")).plus(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("-2147483637")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    rc_BigInteger = (new BigDecimal("-2147483637")).toBigIntegerExact();
    Assert.assertEquals("-2147483637", rc_BigInteger.toString());
  }
  public void testItem_0897()
  {
    rc_BigDecimal = (new BigDecimal("-2147483637")).add(new BigDecimal("1"));
    Assert.assertEquals("-2147483636", rc_BigDecimal.toString());
  }
  public void testItem_0898()
  {
    rc_String = (new BigDecimal("-2")).toPlainString();
    Assert.assertEquals("-2", rc_String);
  }
  public void testItem_0899()
  {
    rc_int = (new BigDecimal("-2")).intValue();
    Assert.assertEquals(-2, rc_int);
  }
  public void testItem_0900()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0901()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2")).divideToIntegralValue(new BigDecimal("-2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0902()
  {
    rc_BigDecimal = (new BigDecimal("-2147483636")).abs();
    Assert.assertEquals("2147483636", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    rc_int = (new BigDecimal("2E+9")).intValueExact();
    Assert.assertEquals(2000000000, rc_int);
  }
  public void testItem_0904()
  {
    rc_BigDecimal = (new BigDecimal("2147483636")).abs();
    Assert.assertEquals("2147483636", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0906()
  {
    rc_BigDecimal = (new BigDecimal("2147483636")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0907()
  {
    rc_int = (new BigDecimal("2147483636")).intValueExact();
    Assert.assertEquals(2147483636, rc_int);
  }
  public void testItem_0908()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).remainder(new BigDecimal("-2147483636"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0911()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).negate();
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("32=3OC9S<HA8GC:;J>B>:8MWLTW8ON:FN>3");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0915()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0916()
  {
    rc_BigDecimal = (new BigDecimal("-2147483636")).movePointLeft(1);
    Assert.assertEquals("-214748363.6", rc_BigDecimal.toString());
  }
  public void testItem_0917()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("-2147483636")).setScale(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("-2147483636", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0921()
  {
    rc_BigDecimal = (new BigDecimal("-2147483636")).min(new BigDecimal("32"));
    Assert.assertEquals("-2147483636", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0923()
  {
    rc_int = (new BigDecimal("1135879015891")).precision();
    Assert.assertEquals(13, rc_int);
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("-214748363.6")).divideToIntegralValue(new BigDecimal("-2147483636"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    rc_int = (new BigDecimal("1135879015891")).precision();
    Assert.assertEquals(13, rc_int);
  }
  public void testItem_0927()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0928()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0929()
  {
    rc_BigDecimal = (new BigDecimal("-2147483636")).max(new BigDecimal("1135879015891"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0930()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0931()
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
  public void testItem_0932()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0933()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1135879015891"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0934()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\1', '8', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\0', '\234', '8', '\0', '\1', '\uFFFF', '\234', '\234', '\0', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\0', '8', '8', '\0', '\234', '\1', '\0', '\0', '\0', '\0', '8', '\0', '\1', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\0', '8', '8', '\uFFFF', '8', '\0', '\0', '8', '\0', '\234', '\234', '\234', '\234', '\1', '\1', '\uFFFF', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("1135879015891"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0937()
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
  public void testItem_0938()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0939()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1135879015891")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0940()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0941()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\234', '\uFFFF', '8', '\0', '\234', '\234', '\uFFFF', '\0', '8', '\0', '8', '\0', '\uFFFF', '8', '8', '\1', '\1', '8', '\234', '\0', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\0', '\0', '\234', '\234', '8', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\0', '\0', '8', '\1', '\1', '8', '\234', '\234', '\1', '8', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\1', '\234', '\0', '\0', '\1', '\234', '8', '\0', '\0', '\1', '\0'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0942()
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
//  public void testItem_0943()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2147483636")).hashCode();
//    Assert.assertEquals(-2147483276, rc_int);
//  }
  public void testItem_0944()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '8', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '8', '8', '8', '\234', '\234', '\1', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '8', '\1', '\1', '8', '\0', '8', '\1', '8', '\uFFFF', '\0', '\0', '\1', '\0', '\1', '\234', '\234', '\234', '\uFFFF', '\0', '8', '\1', '8', '\234', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\0', '\1', '\0', '\1', '\1', '\1', '\234', '\234', '\234', '8', '\234', '\uFFFF', '8', '\1', '\234', '8', '\0', '\0', '\0', '\0', '\0', '\234', '\0', '\234', '\1', '\234', '\0', '8', '\uFFFF', '8', '\0', '8', '8', '\uFFFF', '\234', '8', '8', '\uFFFF', '8', '\uFFFF', '8', '8', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0945()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015891")).min(new BigDecimal("32"));
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("FF50OH?BNAVJ7<=YTYF");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0951()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("-1135879015891"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0954()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("X2K70;F64XUYN2OWSFQ5MEWOIS12H4VWB?0CI2Y17G4:CV7BA6W8L21CUH35XH<O4AYU0;0DB957G@83NSUVSCHD1VAS67BJ6W2K", new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0955()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(2147483647);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0957()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0958()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0959()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0960()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0961()
  {
    rc_double = (new BigDecimal("0.0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0962()
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
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("1135879015892", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_BigInteger = (new BigDecimal("1135879015892")).unscaledValue();
    Assert.assertEquals("1135879015892", rc_BigInteger.toString());
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0967()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("PXC76@BNP88>GEI:N?>LO35K5K@WG0??<WA340RVOOP19U1S>UTFHFULC7N5<C");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0970()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1135879015892"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0971()
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
  public void testItem_0972()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("0.0"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0974()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0975()
  {
    rc_BigDecimal = (new BigDecimal("1135879015892")).subtract(new BigDecimal("1135879015892"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0976()
  {
    rc_BigDecimal = (new BigDecimal("1135879015892")).movePointLeft(0);
    Assert.assertEquals("1135879015892", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    rc_BigDecimal = (new BigDecimal("1135879015892")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-1135879015892", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0979()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0980()
  {
    rc_int = (new BigDecimal("1135879015892")).compareTo(new BigDecimal("1135879015892"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0981()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015892")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015892", rc_BigDecimal.toString());
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("1135879015892")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_BigInteger = (new BigDecimal("-1135879015892")).toBigInteger();
    Assert.assertEquals("-1135879015892", rc_BigInteger.toString());
  }
  public void testItem_0984()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0985()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0986()
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
  public void testItem_0987()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0990()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0991()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0992()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0994()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0995()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0997()
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
  public void testItem_0998()
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
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
}
