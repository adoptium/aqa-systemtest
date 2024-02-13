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
public class TestSuite020 extends TestCase
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
  
  public TestSuite020() {
	
  }
//  public void testItem_0000()
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
//  public void testItem_0001()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E+2147483647")).divide(new BigDecimal("0E+2147483647"), 2147483647, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0002()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.0")).hashCode();
//    Assert.assertEquals(1, rc_int);
//  }
  public void testItem_0003()
  {
    rc_String = (new BigDecimal("0E+2147483647")).toEngineeringString();
    Assert.assertEquals("0.00E+2147483649", rc_String);
  }
  public void testItem_0004()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0005()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0006()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("6.4")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0007()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0008()
  {
    rc_int = (new BigDecimal("0E+2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0009()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    rc_short = (new BigDecimal("0.0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0012()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0013()
  {
    rc_BigInteger = (new BigDecimal("0.0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0014()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0015()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0016()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("5KA4XOMC9LEGLV30NPP1:30U:G=H2<NY5663G<=QU;OX<D6;EHIP5;O8;GH?CE;XEW<2?IYT5RPP=21B=R6YV70=CF7QK7P5GTIQ", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0017()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0018()
  {
    rc_boolean = (new BigDecimal("0.0")).equals("W0W:J?YEB1FVM9VCHMIO2:5S8YX1?=BNKKEM2<58ICHOM4?I3V>HUMTD>0N;7:NR?U4E3LV5S8:OVIVIBGJ4RU4O1GG4F<ACD;RE");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0019()
  {
    rc_String = (new BigDecimal("0E+1")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0021()
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
  public void testItem_0022()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0023()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    rc_BigInteger = (new BigDecimal("3.2E-2147483646")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0027()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toString();
    Assert.assertEquals("0E-2147483647", rc_String);
  }
  public void testItem_0028()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("V9=9RE78RQC7DRHJS96WHW@S@9?2@=0B<@IIVF3;FD7:EYEAU>G@X;53BJ:G5T0S:DQ:MOEGL:K5HVUUADIWNNQF2HK:;;PUM;AN");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0034()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3.2E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    catch (java.lang.OutOfMemoryError e) {
    	if (e.getMessage().contains("too large")) {
    		caught = true;
    	}
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0035()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0036()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("W2YV2E1=AB:1@FSTPOICKTP:2BJE;S=Y35C=QW1I><T@1OP3PIJ;=0DK3QM:9D0:X7A0KFWTV9?UY4HJ@8BES5YWGH5103UC86Q?");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate();
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3.2E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    catch (java.lang.OutOfMemoryError e) {
    	if (e.getMessage().contains("too large")) {
    		caught = true;
    	}
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0040()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).divide(new BigDecimal("32"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0041()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0042()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0043()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0044()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0047()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0050()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0051()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0052()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("-1"), 0);
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
//  public void testItem_0054()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(-2147483648, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0055()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0058()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\uFFFF', '8', '\234', '\0', '8', '\1', '\234', '8', '\234', '8', '\0', '\0', '8', '8', '\234', '\1', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '\1', '\1', '\0', '\uFFFF', '\1', '\234', '\0', '\1', '8', '\234', '\0', '\1', '\uFFFF', '8', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\1', '\1', '\0', '\1', '8', '\234', '\1', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '8', '\1', '\0', '\1', '\234', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\0', '8', '\0', '8', '\1', '\1', '8', '\1', '\1', '\234', '\uFFFF', '\1', '\234', '\234', '\0', '\0', '\0', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0060()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0061()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
//  public void testItem_0062()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0063()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0064()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0065()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0069()
  {
    rc_double = (new BigDecimal("320.0E+2147483647")).doubleValue();
    Assert.assertEquals(java.lang.Double.POSITIVE_INFINITY, rc_double, 0);
  }
  public void testItem_0070()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    rc_int = (new BigDecimal("1135879015891")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0072()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0073()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("320.0E+2147483647")).toBigInteger();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0074()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0075()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0076()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).remainder(new BigDecimal("1135879015891"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0077()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("NU5<MIU0O7QR54F;6UAJV>RFSA@?B=WO9C0XJYM?R0=PP?9HQ1OVCY3TVBOIF3TSGS7RIDIG;00DVS9=>3@N16E?9GS>JRACPY8H");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0078()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0079()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0080()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0081()
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
  public void testItem_0082()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '\0', '8', '\0', '\234', '\uFFFF', '\0', '8', '\234', '\0', '8', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\1', '\0', '\0', '\uFFFF', '8', '8', '8', '\234', '\234', '8', '8', '8', '8', '8', '8', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\0', '\1', '\0', '\0', '\1', '\234', '\1', '\0', '\0', '8', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\1', '8', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '8', '8', '\1', '\uFFFF', '\0', '\1', '8', '8', '\234', '\234', '\0', '8', '8', '8', '\234', '\0', '\234', '\1', '\1', '\234', '\1', '\0', '\1', '8', '\1', '\234', '8', '\uFFFF', '\234'}, -2147483648, 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("VE55?VC2NS=UH2AAE?=D9>0XIR?VXV1Q2X;8ITR5EW:YQ@QN3TMH6>015XWD2VGFJSA2GXC55J4QLMDN0NMAGOXK6<D0HD8:C@DG");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0086()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0089()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0092()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0093()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0094()
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
//  public void testItem_0095()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("320.0E+2147483647")).longValue();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0096()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("DMY1:1::CC4CN=:8V>IO3JVUJ>0?1TTFYJEP:GMEKWBT");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0100()
  {
    rc_long = (new BigDecimal("1135879015891")).longValueExact();
    Assert.assertEquals(1135879015891L, rc_long);
  }
//  public void testItem_0101()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).multiply(new BigDecimal("1"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0102()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1135879015891")).divideAndRemainder(new BigDecimal("320.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0103()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0104()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).negate(new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0105()
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
  public void testItem_0106()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0107()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0108()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0109()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-1);
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
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0112()
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
  public void testItem_0113()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
//  public void testItem_0114()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("32"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0115()
//  {
//    boolean caught;
//    rc_BigDecimal_array = (new BigDecimal("320.0E+2147483647")).divideAndRemainder(new BigDecimal("32"));
//  }
//  public void testItem_0116()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).pow(1);
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0117()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0118()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\234', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\234', '\uFFFF', '\0', '\234', '\1', '\234', '\0', '8', '\1', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\0', '8', '8', '\0', '8', '8', '\uFFFF', '8', '8', '8', '8', '8', '\0', '8', '\0', '\234', '\1', '\uFFFF', '\234', '8', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\1', '\234', '\1', '\1', '\234', '\uFFFF', '\234', '\234', '8', '\0', '\0', '\1', '\uFFFF', '8', '\0', '8', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '8', '8', '\uFFFF', '\uFFFF'}, -2147483648, 1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0123()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("3.2E+2"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0124()
//  {
//    boolean caught;
//    rc_short = (new BigDecimal("00.0E+2147483647")).shortValueExact();
//    Assert.assertEquals(0, rc_short);
//  }
  public void testItem_0125()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0126()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("NNO9G0YYMT>PM8E;YP9FU6S20H94R6=7:2LW>QA8J?5L968VS>PL?@UH<YM=8OV8CM0TD;UKDQP7PUPLJQC5DNIH5SG6E<E@=UGU");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0128()
  {
    rc_boolean = (new BigDecimal("0")).equals("3<PI:ARH07<6W8<7LLHTEH@71V37Y>UWL=OF1J2AW7I:I8HMD<2;E>GU=T9PND@<6X<RYUY8J6=H;TIRA;:WOJEHM3=YH;2T9HQO");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0129()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0130()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0131()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0132()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).plus();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0133()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0134()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0135()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0136()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0137()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0139()
  {
    rc_short = (new BigDecimal("0.0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0140()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-1, 0);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    rc_int = (new BigDecimal("0.0")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0143()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).pow(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0144()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0146()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0147()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("64"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0148()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0149()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).precision();
    Assert.assertEquals(751, rc_int);
  }
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("64")).plus();
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0151()
  {
    rc_double = (new BigDecimal("64")).doubleValue();
    Assert.assertEquals(64.0, rc_double, 0);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0152()
  {
    rc_boolean = (new BigDecimal("-1")).equals("7VC4CTGIVGMIGE@N=L1F;OR2U14ARNW2GFY0QNQ85RF5I><7YB09DQ;RHN80YAOA?SX91==P43>X77KIHIGKCEJBCI2OX7IW4U5W");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0153()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).hashCode();
//    Assert.assertEquals(1240908815, rc_int);
//  }
  public void testItem_0154()
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
  public void testItem_0155()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0156()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("64"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0157()
  {
    rc_boolean = (new BigDecimal("0E+1")).equals("TH;16NLNQ7LESK8IJLSTL7LDNS726<<;U;@R0J0>6:GPFV8T<AB852J5OG:<9IMSLB1UCRK");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0158()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0159()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0160()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0161()
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
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("64")).max(new BigDecimal("-1"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0163()
  {
    rc_int = (new BigDecimal("64")).intValue();
    Assert.assertEquals(64, rc_int);
  }
  public void testItem_0164()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0165()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0166()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0170()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("HYQQW;DOHF;QO>1SXDRFPJ7D>237NBUM?;XN><;5>2MSJYNYFE<WFQ8LQCR0@<I;2<O@HDWFBK<U2=@R<Y>?JTGCPF>>23:PEQ71");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0171()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0173()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0174()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0175()
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
  public void testItem_0176()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("2147483647"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0178()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0181()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("1"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0182()
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
  public void testItem_0183()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("9223372036854775807"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0184()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).add(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775806", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_short = (new BigDecimal("1.0")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0186()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775806")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0187()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("9223372036854775806", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0189()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-19", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    rc_int = (new BigDecimal("1E-19")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0192()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\234', '\0', '\0', '\uFFFF', '\0', '\234', '\1', '\0', '\0', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '8', '\1', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\1', '\0', '8', '\0', '8', '\234', '\0', '\234', '\1', '\uFFFF', '8', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0193()
  {
    rc_BigDecimal = (new BigDecimal("1E-19")).max(new BigDecimal("9223372036854775806"));
    Assert.assertEquals("9223372036854775806", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\1', '\0', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '8', '\0', '\234', '\uFFFF', '8', '\234', '8', '\234', '\234', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\0', '\0', '\1', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\1', '8', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\234', '\0', '\1', '\uFFFF', '\1', '8', '8', '8', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\0', '\234', '\1', '\0', '\0', '8', '8', '\1', '8', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '8', '8', '\234', '8', '\234', '\0', '\234', '\234'}, new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_BigDecimal_array = (new BigDecimal("9223372036854775807")).divideAndRemainder(new BigDecimal("9223372036854775807"));
  }
  public void testItem_0198()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775806")).subtract(new BigDecimal("9223372036854775807"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("9223372036854775806")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0200()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).movePointLeft(-1);
    Assert.assertEquals("92233720368547758070", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
//  public void testItem_0202()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("9223372036854775806"), 2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0203()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\uFFFF', '\1', '\0', '\1', '\0', '\0', '\0', '\uFFFF', '\1', '\0', '\234', '\1', '\0', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\1', '8', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\234', '\0', '8', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\0', '\0', '8', '\0', '\0', '\234', '\1', '\uFFFF', '\0', '8', '\0', '\234', '\1', '\1', '\234', '\234', '\234', '\234', '\234', '\1', '\234', '8', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '8', '8', '\0', '\1', '\0', '\234', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-0.1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    rc_long = (new BigDecimal("2147483647")).longValueExact();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0208()
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
  public void testItem_0209()
  {
    rc_BigDecimal_array = (new BigDecimal("9223372036854775806")).divideAndRemainder(new BigDecimal("9223372036854775806"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0210()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).remainder(new BigDecimal("-2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0213()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("TCO<>3XW5OY6QO8UOUUDP6I;=:6GKRIAUTOCT1AUK:::JYU8D8JT1S<6;8<4=WE3C>XTKHWW<CBF6JD9K3TYQJYLLQRMU5MY4XD2");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0214()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3E+1"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-0.1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0217()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-0.1")).movePointLeft(-2147483648);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0219()
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
  public void testItem_0220()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0221()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0222()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0223()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0224()
  {
    rc_int = (new BigDecimal("3E+1")).intValue();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0225()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divideToIntegralValue(new BigDecimal("1E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0226()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_BigInteger = (new BigDecimal("-10")).toBigIntegerExact();
    Assert.assertEquals("-10", rc_BigInteger.toString());
  }
  public void testItem_0231()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("-10")).multiply(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_BigInteger = (new BigDecimal("-10")).toBigIntegerExact();
    Assert.assertEquals("-10", rc_BigInteger.toString());
  }
  public void testItem_0234()
  {
    rc_BigDecimal = (new BigDecimal("-10")).setScale(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0237()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1E+1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0238()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0239()
  {
    rc_int = (new BigDecimal("3E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0240()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0241()
  {
    rc_boolean = (new BigDecimal("0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0242()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).setScale(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("30.0", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("1E+1"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0247()
  {
    rc_long = (new BigDecimal("1E+1")).longValue();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0248()
  {
    rc_BigDecimal = (new BigDecimal("30.0")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0250()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@@V?YX6BG8D41R?MCTN=LP;J63WUXW;GC1=2:97IC3M>MO5CBK", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0251()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0252()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("<L2UV:NBK>DKXFEN:A4DIVQES:AI333?>4FVIFK4B12?7RAV6J2=OB>6");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0253()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0254()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0255()
  {
    rc_short = (new BigDecimal("0E+1")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0256()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0257()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0258()
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
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0261()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0263()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0264()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0265()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_int = (new BigDecimal("320.0E+2147483647")).compareTo(new BigDecimal("32"));
//    Assert.assertEquals(-1, rc_int);
//    }
//  }
  public void testItem_0266()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
//  public void testItem_0267()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0268()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0269()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0270()
  {
    rc_String = (new BigDecimal("1E+1")).toPlainString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0271()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0272()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).subtract(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0274()
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
  public void testItem_0275()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).add(new BigDecimal("1"));
    Assert.assertEquals("-19", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0277()
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
  public void testItem_0278()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0279()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0280()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0281()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-19"));
    Assert.assertEquals("20", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    rc_BigDecimal = (new BigDecimal("20")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("19", rc_BigDecimal.toString());
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("-19")).abs();
    Assert.assertEquals("19", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_String = (new BigDecimal("-19")).toEngineeringString();
    Assert.assertEquals("-19", rc_String);
  }
  public void testItem_0285()
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
  public void testItem_0286()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("20")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0287()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("-19")).max(new BigDecimal("-19"));
    Assert.assertEquals("-19", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    rc_int = (new BigDecimal("-19")).intValueExact();
    Assert.assertEquals(-19, rc_int);
  }
  public void testItem_0290()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0291()
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
  public void testItem_0292()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0293()
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
  public void testItem_0294()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0295()
  {
    rc_BigInteger = (new BigDecimal("-0.1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0296()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.1")).divide(new BigDecimal("0"), 1, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0297()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0299()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0300()
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
  public void testItem_0301()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    rc_BigDecimal_array = (new BigDecimal("-0.1")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0303()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("T?UVB<IXFA<KRT5PG7NX=;B4GMQ2I55JS28I=:WMBW70JCSC3<;2HP79O2Q7KTT03=60V79MGPJP:GLB5RDSJ0CVSYWRFY<Q51T>", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0305()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0.1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0306()
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
  public void testItem_0307()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
//  public void testItem_0308()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0309()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, -2147483648, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0310()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).remainder(new BigDecimal("-0.1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("-0.1"));
  }
  public void testItem_0313()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).divide(new BigDecimal("0.1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0314()
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
  public void testItem_0315()
  {
    rc_String = (new BigDecimal("0.1")).toString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0316()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).plus();
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0317()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '\234', '\0', '8', '8', '\0', '8', '\234', '\0', '\1', '\1', '\234', '\234', '\uFFFF', '8', '8', '\1', '\234', '\1', '\uFFFF', '\0', '\0', '\1', '\1', '8', '\234', '8', '\234', '\1', '\234', '\234', '\uFFFF', '\1', '\234', '\1', '\0', '\234', '\0', '8', '\uFFFF', '\1', '\234', '8', '\0', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\0', '\1', '\0', '\0', '\0', '\uFFFF', '\0', '\234', '\1', '\234', '8', '8', '\uFFFF', '8', '\1', '8', '\1', '\234', '8', '\1', '\234', '\uFFFF', '\1', '8', '\0', '\0', '\uFFFF', '\1', '\1', '8', '\1', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\1', '8', '\0', '\1', '8', '\1'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0319()
  {
    rc_int = (new BigDecimal("-0.1")).compareTo(new BigDecimal("0.1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0320()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("OF0J;U0=K1;K247:KD486IL=V0W6SHTG=>18;AQVXIB4QHD6L>W<:9A<L8I>UY=JF=U;V27;>J3HED4>CPAE");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0322()
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
  public void testItem_0323()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.0")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).stripTrailingZeros();
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("32"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0326()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-32.1", rc_BigDecimal.toString());
  }
  public void testItem_0327()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.1")).divide(new BigDecimal("0.1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0328()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0.1"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("-32.1"));
    Assert.assertEquals("-32.1", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("IKWN=NA:H=L;TDAFD<5MCM1UB3DAL8TS40A9EM;0>APGPJK61WQFA?<7C=HJ>PQUSSEI3DVJV9IESSYTJLFWAX6E<G=8GBOV594>");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divideToIntegralValue(new BigDecimal("9223372036854775807"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0335()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).add(new BigDecimal("-32.1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775774.9", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0337()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775774.9")).divide(new BigDecimal("-32.1"), 0);
    Assert.assertEquals("-287332462207313887.1", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_int = (new BigDecimal("9223372036854775807")).precision();
    Assert.assertEquals(19, rc_int);
  }
  public void testItem_0342()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0343()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("9223372036854775807"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775807")).divide(new BigDecimal("9223372036854775807"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0345()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '8', '\0', '8', '8', '\1', '\0', '\1', '\0', '8', '\0', '\0', '8', '8', '8', '8', '\1', '\234', '\234', '8', '\234', '\uFFFF', '8', '\1', '8', '\1', '\0', '8', '\1', '\1', '\0', '8', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '8', '8', '8', '\1', '\uFFFF', '\0', '8', '8', '\234', '\0', '\234', '\234', '\234', '8', '\234', '\uFFFF', '\1', '8', '\1', '\0', '8', '8', '\0', '\0', '8', '\234', '8', '\0', '\0', '\234', '\1', '8'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0346()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0347()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).precision();
    Assert.assertEquals(309, rc_int);
  }
  public void testItem_0349()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0350()
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
  public void testItem_0351()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\uFFFF', '8', '\1', '8', '\234', '8', '\uFFFF', '\1', '\1', '\234', '\0', '\uFFFF', '\0', '\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0352()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\1', '\1', '8', '\0', '8', '8', '\uFFFF', '\1', '\1', '\234', '8', '\uFFFF', '\1', '\0', '8', '\234', '\234', '\0', '\0', '\uFFFF', '\1', '\0', '\1', '\234', '\0', '\uFFFF', '\234', '\0', '\1', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\1', '8', '\234', '\1', '8', '\0', '8', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\0', '\0', '8', '\234', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '8', '\0', '8', '\234', '8', '\1', '\234', '\1', '\uFFFF', '\1', '\1', '8', '8', '\0', '8', '\0', '\234', '\234', '\uFFFF', '\0', '\234', '\0', '\234', '\uFFFF', '\234', '\234', '8', '\1', '\234', '\uFFFF', '\234', '\0', '\234'}, 2147483647, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0354()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0355()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0356()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("9223372036854775807"), 1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0361()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0362()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0363()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0364()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0365()
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
  public void testItem_0366()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\0', '8', '\234', '\1', '\1', '\uFFFF', '\0', '8', '8', '8', '\1', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\0', '\0', '\0', '\1', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '8', '8', '\uFFFF', '\uFFFF', '\234', '8', '\0', '8', '\1', '8', '\234', '8', '\0', '\234', '\1', '8', '8', '\234', '\1', '8', '\0', '\1', '\234', '\234', '8', '8', '\234', '\234', '\uFFFF', '8', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\234', '\234', '\1', '8', '\234', '\0', '\0', '\1', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0367()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
//  public void testItem_0368()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0369()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0371()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("33"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0374()
  {
    rc_String = (new BigDecimal("-2")).toString();
    Assert.assertEquals("-2", rc_String);
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("-2")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).max(new BigDecimal("-2147483648"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
//  public void testItem_0379()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483648")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0380()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("33")).movePointRight(0);
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0384()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0385()
  {
    rc_double = (new BigDecimal("33")).doubleValue();
    Assert.assertEquals(33.0, rc_double, 0);
  }
  public void testItem_0386()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0387()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-2147483648")).divideAndRemainder(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0388()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\1', '8', '\234', '\1', '\234', '\1', '\234', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0389()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointRight(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0390()
  {
    rc_BigDecimal = (new BigDecimal("33")).multiply(new BigDecimal("2"));
    Assert.assertEquals("66", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).max(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0392()
  {
    rc_BigDecimal = (new BigDecimal("2")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-30", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    rc_BigDecimal_array = (new BigDecimal("2")).divideAndRemainder(new BigDecimal("2"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0394()
  {
    rc_int = (new BigDecimal("66")).compareTo(new BigDecimal("2"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0395()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("66"));
  }
  public void testItem_0397()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0398()
  {
    rc_BigDecimal = (new BigDecimal("66")).stripTrailingZeros();
    Assert.assertEquals("66", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    rc_BigDecimal = (new BigDecimal("66")).add(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    rc_BigDecimal = (new BigDecimal("66")).subtract(new BigDecimal("66"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0401()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0402()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0403()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\1', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).max(new BigDecimal("0"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0406()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("0"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).signum();
    Assert.assertEquals(1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0409()
  {
    rc_boolean = (new BigDecimal("2")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("66"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0411()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("66"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0412()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("CB6Q4");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0413()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0414()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0415()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\uFFFF', '\0', '\234', '8', '8', '\234', '\1', '\1', '8', '\1', '\uFFFF', '8', '\0', '\0', '\0', '\1', '\uFFFF', '\1', '\0', '\0', '\1', '\234', '\234', '8', '\0', '\234', '\0', '\234', '8', '8', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\0', '\0', '\234', '8', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0416()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0417()
  {
    rc_String = (new BigDecimal("66")).toString();
    Assert.assertEquals("66", rc_String);
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_float = (new BigDecimal("3.2E-2147483646")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0420()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0421()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0424()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0427()
  {
    rc_BigDecimal = (new BigDecimal("-2")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_int = (new BigDecimal("-3E-2147483646")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0429()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0430()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0431()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0432()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0433()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3.2E-2147483646")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0434()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-3E-2147483646"), 1, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0435()
  {
    rc_BigDecimal = (new BigDecimal("-2")).negate();
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0437()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("3.2E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0438()
  {
    rc_double = (new BigDecimal("3.2E-2147483646")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0439()
  {
    rc_BigDecimal = (new BigDecimal("-2")).min(new BigDecimal("1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
//  public void testItem_0440()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3.2E-2147483646")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0441()
  {
    rc_long = (new BigDecimal("-2")).longValueExact();
    Assert.assertEquals(-2L, rc_long);
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).max(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0444()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0445()
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
  public void testItem_0446()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0447()
  {
    rc_float = (new BigDecimal("3E-2147483646")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0448()
  {
    rc_String = (new BigDecimal("-3E-2147483646")).toEngineeringString();
    Assert.assertEquals("-3E-2147483646", rc_String);
  }
  public void testItem_0449()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '8', '\uFFFF', '\0', '\234', '\234', '\234', '\uFFFF', '\1', '\234', '\0', '\1', '\234', '\1', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\1', '\1', '\1', '\234', '\0', '\0', '\234', '\1', '\0', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\0', '\0', '\uFFFF', '8', '\0', '\1', '\0', '\uFFFF', '8', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\234', '8', '\1', '\0', '\0', '\234', '8', '\234', '8', '\234', '8', '\0', '\uFFFF', '\1', '\0', '\234', '\1', '8', '\234', '\1', '\uFFFF', '8', '8', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\1', '8', '8', '8', '\1', '\0', '\234', '\1', '\uFFFF', '\234', '8', '\234', '\1', '\1'}, -1, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0450()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0451()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-3E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0452()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).plus();
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0454()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("V=<3CYW50>BT3;U89JOL@M=0EC7C56K9M;=HOS5W7EG<;1GKI=GAXOSSHK9M");
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
      rc_int = (new BigDecimal("3E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0459()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0462()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("1"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0463()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0464()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0465()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=0 roundingMode=CEILING", rc_MathContext.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0466()
  {
    rc_boolean = (new BigDecimal("3.2E-2147483646")).equals(">H5YTB;4KGV:2;7NLYUXC=");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0467()
  {
    rc_double = (new BigDecimal("3E-2147483646")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).negate();
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0470()
  {
    rc_BigInteger = (new BigDecimal("3.2E-2147483646")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0471()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_double = (new BigDecimal("3.2E-2147483646")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0473()
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
  public void testItem_0474()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).plus();
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_int = (new BigDecimal("3E-2147483646")).compareTo(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0477()
  {
    rc_int = (new BigDecimal("3E-2147483646")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0478()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0479()
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
  public void testItem_0480()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0482()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0483()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0484()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).multiply(new BigDecimal("1135879015891"));
    Assert.assertEquals("1290221138741506630523881", rc_BigDecimal.toString());
  }
//  public void testItem_0485()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0486()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("1XKK4Q>IN3W:07");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0487()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0488()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0489()
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
  public void testItem_0490()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0491()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0492()
  {
    rc_BigDecimal = (new BigDecimal("1290221138741506630523881")).movePointRight(-1);
    Assert.assertEquals("129022113874150663052388.1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0493()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0494()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0495()
  {
    rc_BigDecimal = (new BigDecimal("129022113874150663052388.1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-129022113874150663052388.1", rc_BigDecimal.toString());
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("129022113874150663052388.1")).divide(new BigDecimal("1"), java.math.RoundingMode.UP);
    Assert.assertEquals("129022113874150663052388.1", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0499()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0500()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '8', '\0', '8', '\uFFFF', '\234', '\0', '8', '\0', '8', '\234', '\uFFFF', '\0', '\0', '8', '\234', '8', '\1', '\234', '\1', '8', '\0', '8', '\uFFFF', '\1', '\0', '8', '8', '\1', '\uFFFF', '8', '\0', '\1', '\1', '\0', '8', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\0', '\0', '\234', '8', '\uFFFF', '\234', '8', '\1', '\1', '\234', '8', '8', '\234', '8', '\0'}, -2147483648, 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0501()
  {
    rc_boolean = (new BigDecimal("-129022113874150663052388.1")).equals("RQ1H1DOMXN94DOHS?MJY<BTTV?=Q1PCPC:O;RK?GI9NG>UH?BOIN2C9O;5@>0MVN5H7YUF7=4;VKV36R<=@IQIKPR<68FK");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0502()
  {
    rc_BigDecimal = (new BigDecimal("-129022113874150663052388.1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-129022113874150663052388.1", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '8', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\234', '\234', '8', '8', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '8', '8', '\0', '\uFFFF', '\uFFFF', '8', '8', '\234', '\1', '8', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\1', '\0', '\234', '\1', '\0', '\234', '8', '\234', '\234', '\1', '\1', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '8', '8', '\0', '8', '\234', '\1', '\0', '\1', '\234', '\0', '\0', '8', '\1', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0505()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0506()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0507()
  {
    rc_boolean = (new BigDecimal("1")).equals("BL930@43JUP9D7BBMY;;E8W<AR6VGKEWRV@>3<37OH>QKKV7;DEC;B7TV62R;>=R;X?BP7QYKK4O4V2=LYDP;J2?I7XD4@IP>E7E");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("-1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0513()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0514()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0515()
  {
    rc_boolean = (new BigDecimal("32")).equals("RQUJNVIJMAL6P356ABV>Q8SCK38URLW9Y5Q?550G8JJKD34EAIKPLLPC788BLRGGTJ@4>Y2IAKYIR3RFQ3CBQ=H6BMB1<:UY;EAI");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0516()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0518()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-0.03125")).setScale(-2147483648, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0519()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0520()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0522()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).plus();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0526()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0527()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0528()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0529()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0531()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).setScale(2147483647, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0532()
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
  public void testItem_0533()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0534()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0536()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("-3.0", rc_BigDecimal.toString());
  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("-3.0")).min(new BigDecimal("3.2E+2"));
    Assert.assertEquals("-3.0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0538()
  {
    rc_boolean = (new BigDecimal("-1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0539()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).negate();
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0540()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-3.2E+2")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E+2")).round(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_int = (new BigDecimal("-3.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0543()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E+2")).add(new BigDecimal("0"));
    Assert.assertEquals("-320", rc_BigDecimal.toString());
  }
  public void testItem_0544()
  {
    rc_double = (new BigDecimal("-320")).doubleValue();
    Assert.assertEquals(-320.0, rc_double, 0);
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    rc_String = (new BigDecimal("3.2E+2")).toEngineeringString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("-320"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(-1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0550()
  {
    rc_long = (new BigDecimal("3.2")).longValue();
    Assert.assertEquals(3L, rc_long);
  }
  public void testItem_0551()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate();
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0552()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    rc_String = (new BigDecimal("-320")).toEngineeringString();
    Assert.assertEquals("-320", rc_String);
  }
//  public void testItem_0555()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-320")).hashCode();
//    Assert.assertEquals(-9920, rc_int);
//  }
//  public void testItem_0556()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0557()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    rc_byte = (new BigDecimal("8")).byteValueExact();
    Assert.assertEquals(8, rc_byte);
  }
  public void testItem_0559()
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
  public void testItem_0560()
  {
    rc_int = (new BigDecimal("-320")).intValue();
    Assert.assertEquals(-320, rc_int);
  }
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0562()
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
  public void testItem_0563()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("-320")).multiply(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2560", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\uFFFF', '\234', '\1', '\234', '8', '8', '\uFFFF', '8', '\1', '8', '\0', '8', '8', '\0', '\0', '\234', '8', '\uFFFF', '8', '\0', '\1', '\0', '\234', '\234', '8', '\uFFFF', '\1', '8', '8', '\uFFFF', '8', '\1', '\234', '\1', '\uFFFF', '\1', '\1', '\0', '\1', '\0', '8', '\0', '\0', '\234', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '8', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\0', '8', '8', '\1', '\0', '8', '\1', '8', '\1', '8', '\234', '\uFFFF', '\234', '\0', '8', '\1', '\1', '8', '\0', '\1', '\1', '8', '\234', '\1', '\0', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0567()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0568()
  {
    rc_BigDecimal = (new BigDecimal("-320")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-321", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0570()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-320"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0571()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0572()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).remainder(new BigDecimal("-1.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0573()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).min(new BigDecimal("1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1.0"), -1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0576()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-321")).hashCode();
//    Assert.assertEquals(-9951, rc_int);
//  }
  public void testItem_0577()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0578()
  {
    rc_int = (new BigDecimal("-321")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-321"));
    Assert.assertEquals("322", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0582()
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
  public void testItem_0583()
  {
    rc_float = (new BigDecimal("-1E+1")).floatValue();
    Assert.assertEquals(-10.0F, rc_float, 0);
  }
  public void testItem_0584()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("322"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0585()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=2147483647 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0587()
  {
    rc_int = (new BigDecimal("322")).intValueExact();
    Assert.assertEquals(322, rc_int);
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("10")).remainder(new BigDecimal("-1E+1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).movePointLeft(2147483647);
    Assert.assertEquals("-1E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0590()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("10"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\0', '8', '\0', '\234', '\1', '\uFFFF', '8', '8', '\234', '\234', '\0', '\1', '\1', '\234', '8', '\0', '\1', '8', '\234', '8', '\uFFFF', '\234', '\0', '\0', '\0', '\0', '\0', '\0', '8', '\1', '8', '8', '\1', '\uFFFF', '\0', '\0', '\234', '\0', '\0', '\234', '\uFFFF', '\234', '\234', '\0', '\1', '8', '\1', '\0', '\uFFFF', '\234', '8', '\uFFFF', '8', '\1', '\0', '8', '\uFFFF', '\0', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\0', '\uFFFF', '\1', '\1', '\1', '\1', '\1', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\234', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\0', '8', '8', '\uFFFF'}, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0592()
  {
    rc_BigDecimal = (new BigDecimal("322")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("322", rc_BigDecimal.toString());
  }
  public void testItem_0593()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0594()
  {
    rc_BigDecimal = (new BigDecimal("322")).plus();
    Assert.assertEquals("322", rc_BigDecimal.toString());
  }
  public void testItem_0595()
  {
    rc_BigDecimal = (new BigDecimal("10")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    rc_BigDecimal = (new BigDecimal("322")).plus(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("322", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    rc_String = (new BigDecimal("322")).toString();
    Assert.assertEquals("322", rc_String);
  }
  public void testItem_0598()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_BigDecimal = (new BigDecimal("322")).movePointRight(-1);
    Assert.assertEquals("32.2", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    rc_BigDecimal = (new BigDecimal("10")).negate();
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0601()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\0', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0602()
  {
    rc_BigDecimal = (new BigDecimal("10")).setScale(1);
    Assert.assertEquals("10.0", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-10")).pow(-1, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("-10")).divide(new BigDecimal("10"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0606()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0607()
  {
    rc_BigDecimal = (new BigDecimal("-10")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0608()
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
  public void testItem_0609()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).multiply(new BigDecimal("-1E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0611()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+1")).pow(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0613()
  {
    rc_BigDecimal = (new BigDecimal("-10")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_BigDecimal = (new BigDecimal("-10")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    rc_BigDecimal = (new BigDecimal("10")).stripTrailingZeros();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=1 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0617()
  {
    rc_BigDecimal = (new BigDecimal("-10")).divide(new BigDecimal("10"), 1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    rc_long = (new BigDecimal("1E+1")).longValueExact();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("1E+2")).setScale(-1);
    Assert.assertEquals("1.0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0621()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).movePointLeft(-1);
    Assert.assertEquals("100", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_int = (new BigDecimal("1E+2")).compareTo(new BigDecimal("1E+2"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0623()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\0', '\0', '8', '\234', '\0', '\0', '\0', '8', '\uFFFF', '\uFFFF', '8', '8', '8', '\1', '\1', '\0', '8', '\0', '\1', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '8', '\0', '\1', '\234', '8', '8', '\0', '\234', '\234', '\0', '\uFFFF', '\234', '8', '\0', '\1', '8', '8', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\234', '\234', '\234', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '8', '8', '\uFFFF', '\0', '8', '\1', '\1', '\0'}, -1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0624()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(-2147483648, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0625()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    rc_double = (new BigDecimal("1E+2")).doubleValue();
    Assert.assertEquals(100.0, rc_double, 0);
  }
  public void testItem_0627()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\uFFFF', '\1', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\1', '\0', '\234', '\1', '\234', '\1', '\uFFFF', '\234', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\1', '\234', '\1', '\0', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\0', '\1', '8', '\234', '\1', '\uFFFF', '8', '\234', '8', '\1', '\1', '8', '\234', '\234', '\1', '\234', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '8', '8', '\uFFFF', '\1', '8', '\1', '\1', '\0', '\234', '\1', '\234', '8', '\1', '8'}, 1, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0628()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).setScale(-1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1.13587901589E+12", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0631()
  {
    rc_int = (new BigDecimal("1E+2")).compareTo(new BigDecimal("1E+1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0632()
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
//  public void testItem_0633()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2147483648")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0634()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";<I@COML<R7ET>VAV?;G9>G4F:X>ANNRIA916>FMBOCDT6YL>?2:3UML?R3IL==AQ0LT2GKP?OQ@MHUP3K12>U3<0YJYB9>LF3SX");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0635()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    rc_long = (new BigDecimal("1E+1")).longValueExact();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0637()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0638()
  {
    rc_int = (new BigDecimal("-2147483648")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0639()
  {
    rc_int = (new BigDecimal("-2147483648")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0640()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2")).divide(new BigDecimal("1.13587901589E+12"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0641()
  {
    rc_BigDecimal = (new BigDecimal("1E+2")).add(new BigDecimal("1E+1"));
    Assert.assertEquals("1.1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("1.1E+2")).add(new BigDecimal("1E+2"));
    Assert.assertEquals("2.1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    rc_int = (new BigDecimal("1.1E+2")).compareTo(new BigDecimal("1E+2"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("1.1E+2")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\uFFFF', '8', '\1', '\1', '\0', '\uFFFF', '\0', '\0', '\0', '\0', '\1', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '8', '\1', '\0', '\1', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\1', '8', '\1', '\uFFFF', '\234', '8', '8', '8', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '8', '8', '\uFFFF', '\0', '\0', '\0', '8', '\1', '\0', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '8', '8'}, -1, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0646()
  {
    rc_String = (new BigDecimal("-2147483648")).toEngineeringString();
    Assert.assertEquals("-2147483648", rc_String);
  }
  public void testItem_0647()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0648()
  {
    rc_int = (new BigDecimal("1E+1")).intValue();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0649()
  {
    rc_BigDecimal = (new BigDecimal("1E+2")).plus();
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0650()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("1E+1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_BigDecimal = (new BigDecimal("1.13587901589E+12")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("1.13587901589E+12")).stripTrailingZeros();
    Assert.assertEquals("1.13587901589E+12", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\234', '\1', '\1', '\uFFFF', '\1', '8', '8', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0'}, 0, 1);
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0656()
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
  public void testItem_0657()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\1', '\uFFFF', '8', '\1', '\0', '\0', '\1', '8', '8', '\1', '\234', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '8', '\0', '\234', '\1', '\uFFFF', '\0', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\1', '\234', '\1', '\1', '\1', '8', '\uFFFF', '\1', '8', '\1', '\234', '8', '\234', '\uFFFF', '\234', '\234', '\234', '8', '\1', '\1', '\234', '8', '\234', '\1', '8', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\234', '\1', '\0', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\234', '8', '8', '\1', '8', '8', '\uFFFF', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0658()
  {
    rc_BigDecimal = (new BigDecimal("1.1E+2")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1.1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0659()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0660()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0661()
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
  public void testItem_0662()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0663()
  {
    rc_long = (new BigDecimal("1.1E+2")).longValue();
    Assert.assertEquals(110L, rc_long);
  }
  public void testItem_0664()
  {
    rc_BigDecimal = (new BigDecimal("8")).subtract(new BigDecimal("32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-24", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0666()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0667()
  {
    rc_BigDecimal = (new BigDecimal("-24")).negate();
    Assert.assertEquals("24", rc_BigDecimal.toString());
  }
  public void testItem_0668()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointRight(-1);
    Assert.assertEquals("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-24"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0670()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0672()
  {
    rc_byte = (new BigDecimal("8")).byteValueExact();
    Assert.assertEquals(8, rc_byte);
  }
  public void testItem_0673()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("1"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_BigDecimal = (new BigDecimal("8")).stripTrailingZeros();
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0676()
  {
    rc_byte = (new BigDecimal("8")).byteValueExact();
    Assert.assertEquals(8, rc_byte);
  }
  public void testItem_0677()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0678()
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
  public void testItem_0679()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0680()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_BigDecimal = (new BigDecimal("8")).subtract(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0682()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0684()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=1 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0688()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0689()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0690()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).round(new MathContext("precision=1 roundingMode=DOWN"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0691()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0692()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0697()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0698()
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
  public void testItem_0699()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("3.2E+2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1.024E+4", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0702()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0704()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0705()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0706()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.024E+4")).divide(new BigDecimal("1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("-2")).movePointRight(-1);
    Assert.assertEquals("-0.2", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0709()
  {
    rc_boolean = (new BigDecimal("1.024E+4")).equals("5I69EXR;B:2VT7;EQFP0C1GB=RYJ7NJ3DOD7EOEE3K9CYLH1V@3M;>LH@T7OQJR22:4UFP<@J3IRIQBAE<U5N=:HFSDJBM2;:LGA");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0710()
  {
    rc_double = (new BigDecimal("-0.2")).doubleValue();
    Assert.assertEquals(-0.2, rc_double, 0);
  }
  public void testItem_0711()
  {
    rc_BigDecimal = (new BigDecimal("-0.2")).remainder(new BigDecimal("-2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.2", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = (new BigDecimal("1.024E+4")).divide(new BigDecimal("-0.2"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-5.120E+4", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0714()
  {
    rc_String = (new BigDecimal("-5.120E+4")).toPlainString();
    Assert.assertEquals("-51200", rc_String);
  }
  public void testItem_0715()
  {
    rc_BigInteger = (new BigDecimal("-0.2")).unscaledValue();
    Assert.assertEquals("-2", rc_BigInteger.toString());
  }
  public void testItem_0716()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(-1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0717()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '\1', '\uFFFF', '8', '8', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0718()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0719()
  {
    rc_BigDecimal = (new BigDecimal("-0.2")).divide(new BigDecimal("1"), -1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 0, -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0721()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0722()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '\234', '\1', '\0', '\uFFFF', '\0', '8', '8', '\uFFFF', '\234', '\1', '\0', '\1', '\1', '\234', '\1', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '8', '\1', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\0', '8', '\1', '\1', '\234', '\uFFFF', '8', '\234', '8', '8', '8', '\0', '\0', '\uFFFF', '\1', '\0', '\1', '\0', '\0', '8', '\1', '\0', '8', '\0', '\0', '\uFFFF', '8', '\234', '\1', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\0', '\234', '\1', '\1'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0723()
  {
    rc_boolean = (new BigDecimal("-0.2")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0724()
  {
    rc_int = (new BigDecimal("10")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0725()
  {
    rc_long = (new BigDecimal("-0.2")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0726()
  {
    rc_int = (new BigDecimal("-5.120E+4")).compareTo(new BigDecimal("-0.2"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0727()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("DIC6>QD1Y;GE?2?E=ES2MUI9=XSC?003QR0KD239");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0728()
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
  public void testItem_0729()
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
  public void testItem_0730()
  {
    rc_BigDecimal = (new BigDecimal("-5.120E+4")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-5.120E+4", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    rc_BigDecimal = (new BigDecimal("-5.120E+4")).setScale(0);
    Assert.assertEquals("-51200", rc_BigDecimal.toString());
  }
  public void testItem_0734()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0735()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
//  public void testItem_0736()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-0.2")).setScale(-2147483648, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0737()
  {
    rc_long = (new BigDecimal("-51200")).longValue();
    Assert.assertEquals(-51200L, rc_long);
  }
  public void testItem_0738()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0739()
  {
    rc_BigDecimal = (new BigDecimal("-51200")).abs();
    Assert.assertEquals("51200", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_BigDecimal = (new BigDecimal("-51200")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-51200", rc_BigDecimal.toString());
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-51200"));
    Assert.assertEquals("-51200", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0746()
  {
    rc_BigDecimal = (new BigDecimal("-51200")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0747()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("BU@2TLM?CEIQJP5W;XQXDG@BLXSPAJX5R0");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("-51200")).round(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-51200", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    rc_int = (new BigDecimal("-51200")).intValueExact();
    Assert.assertEquals(-51200, rc_int);
  }
  public void testItem_0750()
  {
    rc_BigDecimal = (new BigDecimal("-51200")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-5E+4", rc_BigDecimal.toString());
  }
  public void testItem_0751()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0752()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0753()
  {
    rc_BigDecimal = (new BigDecimal("-51200")).plus(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-51200", rc_BigDecimal.toString());
  }
  public void testItem_0754()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0755()
  {
    rc_BigInteger = (new BigDecimal("-5E+4")).toBigInteger();
    Assert.assertEquals("-50000", rc_BigInteger.toString());
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("-51200")).abs();
    Assert.assertEquals("51200", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("-51200")).multiply(new BigDecimal("3.2E+2"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-1.638400E+7", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("-5E+4")).divide(new BigDecimal("-5E+4"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    rc_BigDecimal = (new BigDecimal("-1.638400E+7")).remainder(new BigDecimal("-1.638400E+7"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0761()
  {
    rc_BigDecimal = (new BigDecimal("-5E+4")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-5E+4", rc_BigDecimal.toString());
  }
  public void testItem_0762()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("-5E+4")).max(new BigDecimal("-5E+4"));
    Assert.assertEquals("-5E+4", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    rc_BigDecimal_array = (new BigDecimal("-1.638400E+7")).divideAndRemainder(new BigDecimal("-1.638400E+7"));
  }
  public void testItem_0765()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-5E+4")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0766()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-51200"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1.638400E+7"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0768()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("-1.638400E+7")).negate();
    Assert.assertEquals("1.638400E+7", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1.638400E+7")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0771()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0773()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\1', '\uFFFF', '\234', '\0', '\0', '\234', '\234', '\0', '\0', '\0', '\0', '\0', '\0', '\uFFFF', '8', '8', '\0', '\uFFFF', '\0', '\1', '\0', '\234', '\1', '\uFFFF', '\1', '\234', '\1', '\0', '\234', '\234', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0774()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0775()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("-1.638400E+7"));
    Assert.assertEquals("-1.638400E+7", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\234', '\uFFFF', '\234', '\0', '8', '\1', '\234', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\0', '8', '\1', '\234', '\uFFFF', '\0', '\1', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '8', '\1', '\234', '\1', '\uFFFF', '\1', '\1', '\234', '8', '\234', '\uFFFF', '8', '\234', '\0', '\0', '\234', '\234', '\0', '\234', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '8', '8'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0780()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0781()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0782()
  {
    rc_BigDecimal_array = (new BigDecimal("2")).divideAndRemainder(new BigDecimal("-1.638400E+7"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0783()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<UH6QQUL4:RU7GR>=4E24@?SOO<O5PGTX?XGUL2O=QQH:<TAT5RQ61BHS73FDKSJ?4QMEHNESQ8Q0::YBR6WO<EMG>BKR>3LTI4D");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0784()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0785()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0786()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0787()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '8', '8', '\1', '\1', '\1', '\uFFFF', '8', '\234', '8', '\234', '\0', '\0', '\1', '8', '\0', '8', '\uFFFF', '8', '\0', '8', '8', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\234', '8', '\1', '\uFFFF', '8', '\234', '8', '\1', '\1', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\0', '8', '\0', '\0', '\1', '\1', '\0', '\1', '\234', '8', '\0', '\0', '\0', '\1', '\0', '\uFFFF', '\1', '\234', '\0', '\1', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\1', '\234', '\234', '\uFFFF', '\0', '8', '\234'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 0, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0791()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0792()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    rc_String = (new BigDecimal("2")).toString();
    Assert.assertEquals("2", rc_String);
  }
  public void testItem_0794()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=0 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0795()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0796()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("1"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0799()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775807")).toBigIntegerExact();
    Assert.assertEquals("9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0800()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0802()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0805()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("2"), 2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0808()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    rc_BigInteger = (new BigDecimal("2")).unscaledValue();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0812()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0813()
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
  public void testItem_0814()
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
  public void testItem_0815()
  {
    rc_String = (new BigDecimal("2")).toString();
    Assert.assertEquals("2", rc_String);
  }
  public void testItem_0816()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0817()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("2"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    rc_BigDecimal = (new BigDecimal("2")).remainder(new BigDecimal("2"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0821()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0822()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\234', '8', '8', '8', '8', '\0', '8', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\1', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\234', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\1', '8', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\0', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\234', '\234', '\234', '8', '8', '\1', '8', '8', '\0', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\1', '\0', '\0', '\1', '\0', '8', '\234', '8', '\0', '\234', '8', '\1', '\1', '8', '\uFFFF', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0823()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0824()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_int = (new BigDecimal("2147483647")).intValue();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0826()
  {
    rc_BigDecimal = (new BigDecimal("2")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0828()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0830()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0831()
  {
    rc_long = (new BigDecimal("-32")).longValue();
    Assert.assertEquals(-32L, rc_long);
  }
  public void testItem_0832()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_long = (new BigDecimal("-32")).longValueExact();
    Assert.assertEquals(-32L, rc_long);
  }
  public void testItem_0834()
  {
    rc_BigDecimal = (new BigDecimal("-32")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0835()
  {
    rc_BigDecimal = (new BigDecimal("-32")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    rc_int = (new BigDecimal("4E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0837()
  {
    rc_BigDecimal = (new BigDecimal("-32")).remainder(new BigDecimal("4E+1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0838()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-32")).hashCode();
//    Assert.assertEquals(-992, rc_int);
//  }
  public void testItem_0839()
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
  public void testItem_0840()
  {
    rc_BigDecimal = (new BigDecimal("-32")).subtract(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0841()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\234', '8', '\0', '\1', '\1', '\1', '\1', '\1', '\234', '\uFFFF', '8', '\234', '\234', '8', '\uFFFF', '\1', '\234', '8', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\234', '\1', '8', '\0', '\1', '\234', '8', '\234', '\1', '\0', '\0', '8', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\0', '\234', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\0', '\uFFFF', '\0', '\234', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\0'}, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0842()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0843()
  {
    rc_BigDecimal = (new BigDecimal("-31")).remainder(new BigDecimal("4E+1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).setScale(2147483647, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0845()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0846()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0847()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0848()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0849()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("32"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("-31")).add(new BigDecimal("-32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-63", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0852()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-63")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0853()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_BigDecimal = (new BigDecimal("-32")).max(new BigDecimal("-31"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0856()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-32"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("31")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_long = (new BigDecimal("31")).longValue();
    Assert.assertEquals(31L, rc_long);
  }
  public void testItem_0859()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0861()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).hashCode();
//    Assert.assertEquals(2706431, rc_int);
//  }
  public void testItem_0862()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scaleByPowerOfTen(1);
    Assert.assertEquals("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E+309", rc_BigDecimal.toString());
  }
  public void testItem_0863()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0864()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0865()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0866()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("31"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0868()
  {
    rc_int = (new BigDecimal("31")).compareTo(new BigDecimal("31"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0869()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).min(new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0870()
  {
    rc_BigDecimal = (new BigDecimal("31")).stripTrailingZeros();
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0871()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
//  public void testItem_0872()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).hashCode();
//    Assert.assertEquals(-2706431, rc_int);
//  }
  public void testItem_0873()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0874()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).movePointLeft(0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0875()
  {
    rc_BigDecimal = (new BigDecimal("31")).plus(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
//  public void testItem_0876()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("320.0E+2147483647")).toEngineeringString();
//    Assert.assertEquals("3.2E+2147483649", rc_String);
//  }
  public void testItem_0877()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0878()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).multiply(new BigDecimal("-31"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    Assert.assertEquals("-9.92E+2147483650", rc_BigDecimal.toString());
//  }
  public void testItem_0879()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0881()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("-9920.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("-992", rc_BigInteger.toString());
//  }
  public void testItem_0882()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(1);
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).pow(1);
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0885()
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
  public void testItem_0886()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0887()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0888()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0889()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369.0", rc_BigDecimal.toString());
  }
  public void testItem_0890()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369.0")).plus();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369.0", rc_BigDecimal.toString());
  }
  public void testItem_0892()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0893()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_int = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369.0")).plus();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369.0", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369.0")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0897()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).setScale(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0898()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0899()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), java.math.RoundingMode.UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0901()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0902()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369.0"));
    Assert.assertEquals("32317006071311000124898031224579573843090711673822037420515886478292823994993138674481962506230793058252225437079377520911390436322902341314641236089996355364796691954597073853311793036545971292569645384902133615799048012694523410766823033186436078386283980618856409414727255160864941408179785673109070764255585407025730157677002355043412808122778910260318523563200661938269221421782853143442411214081660246736512446905545318501852889897292245167967233418070449811260028654577419085594090002051053099455790265000288623719500622615517812957516110402741221076141627485454775104261393370763827695975206346631220184481792.00", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0906()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0907()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0908()
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
  public void testItem_0909()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 1, 0);
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
      rc_BigDecimal = new BigDecimal("=:?7DSDVSUI=Y@P?<Y0K0TPKD6G4FO?Y:T68802BXHSSUS99PQV<1APKD06BD<V5=1=N7FE0SWJXB>T8L4<GGV2K7RM?BN6>I4<J", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0912()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0915()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).precision();
    Assert.assertEquals(310, rc_int);
  }
  public void testItem_0916()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0917()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0921()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    rc_int = (new BigDecimal("0.0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0923()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).min(new BigDecimal("1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0925()
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
  public void testItem_0926()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0927()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0928()
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
  public void testItem_0929()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\1', '\234', '\0', '\234', '\uFFFF', '\0', '\1', '\0', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\0', '\1', '\234', '\uFFFF', '\234', '\0', '8', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '8', '\0', '\0', '\uFFFF', '\1', '\1', '8', '\234', '8', '\234', '\234', '\234', '8', '8', '8', '\1', '\1', '\0', '\0', '\234', '\1', '8', '\234', '8', '8', '\234', '\234', '\uFFFF', '\234', '\1', '8', '8', '8', '8', '\0'}, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0930()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0931()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).min(new BigDecimal("0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0933()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(-1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0935()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0937()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0938()
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
  public void testItem_0939()
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
  public void testItem_0940()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0941()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0942()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0943()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), 0, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0945()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0950()
  {
    rc_float = (new BigDecimal("0E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0951()
  {
    rc_int = (new BigDecimal("0E-2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("32"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0954()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0955()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0957()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0958()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0960()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("4XKQ=B", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0961()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).max(new BigDecimal("0"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(2147483647, 1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0965()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0966()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0967()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_int = (new BigDecimal("0E-2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0970()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0971()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0972()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("32"), 1, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0973()
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
  public void testItem_0974()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0975()
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
  public void testItem_0976()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("W:MH:1F71CLYI@N<X0HG<6A6AI9M950?X>WQW>66SA8YY>:TCCTMKA>;VHY>HVGE:YAT3DERFE?P0SG1LD3B7AF;I<G6", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0977()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0978()
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
  public void testItem_0979()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0981()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\uFFFF', '\1', '\0', '8', '\0', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\1', '\234', '\1', '8', '\0', '\1', '\0', '\uFFFF', '8', '\234', '8', '8', '\0', '8', '8', '\234', '\234', '\234', '\1', '\0', '\0', '8', '\uFFFF', '8', '\1', '8', '\234', '\1', '\0', '8', '\234', '\1', '\uFFFF', '\0', '\1', '\234', '\234', '\1', '8', '\0', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\1', '\0', '8', '\0', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\1'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0982()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '8', '\1', '\1', '8', '\0', '8', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\1', '\0', '\234', '\0', '\1', '\234', '\1', '8', '\234', '8', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '8', '\0', '\0', '\234', '8', '\234', '\uFFFF', '\1', '8', '\234', '\1', '\234', '\1', '\1', '8', '8', '\uFFFF', '8', '\234', '\234', '\0', '\234', '\1', '\0', '\0', '\0', '8', '\uFFFF', '\234', '\234', '\0', '\0', '\234', '\1', '8', '\0', '\1', '\0', '\0', '\234', '\1', '\0', '8', '\0', '8', '8', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\0', '8', '\234', '\234', '8', '8', '8', '\uFFFF', '8', '\0', '\234', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0983()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\0', '\234', '\234', '\0', '\1', '\uFFFF', '\0', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '8', '8', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0984()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0985()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0986()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("09PXBDWIS@O;5@QS6Y860YO3@6;>C?YLGJBES9D?>QCP3DJFX3S<F;FN9WC2K=>35CV@YJV79O16UTS5>YAIIIM:TICMTRB4;RKW", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0987()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0988()
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
  public void testItem_0989()
  {
    rc_short = (new BigDecimal("0E-2147483647")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).stripTrailingZeros();
	Assert.assertEquals(0E-2147483647, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0991()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E-2147483647"), -1);
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
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0993()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0994()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0995()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0996()
  {
    rc_byte = (new BigDecimal("0E-2147483647")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0997()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0998()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_float = (new BigDecimal("0E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
}
