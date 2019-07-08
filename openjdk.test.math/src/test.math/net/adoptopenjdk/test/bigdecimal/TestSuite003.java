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
public class TestSuite003 extends TestCase
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
  
  public TestSuite003() {  
  }
  public void testItem_0000()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0001()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+323")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0004()
  {
    rc_BigDecimal = (new BigDecimal("0E+324")).stripTrailingZeros();
	Assert.assertEquals(0E+324, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0005()
  {
    rc_BigDecimal = (new BigDecimal("0E+324")).negate();
    Assert.assertEquals("0E+324", rc_BigDecimal.toString());
  }
  public void testItem_0006()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_BigDecimal = (new BigDecimal("0E+324")).movePointLeft(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("0E+324")).negate();
    Assert.assertEquals("0E+324", rc_BigDecimal.toString());
  }
  public void testItem_0009()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\uFFFF', '\234', '\uFFFF', '\234'}, 2147483647, 0, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0013()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0014()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0015()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+324")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0016()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0017()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8', '8', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0018()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("0E+324"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0.04", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0024()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
//  public void testItem_0025()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.59731543624162%", true, caught);
//    }
//  }
  public void testItem_0026()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0027()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0028()
  {
    rc_int = (new BigDecimal("-32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("-32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0031()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("PG:E5?=4UF>YJVAMMOO@PGRX3TB47T5ELPM=6;EXWKS5?37BR4SICURKXUQMD5C>>=;BDA>JIA9?OFCP=<W4X?602MAJOHDA@", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
//  public void testItem_0033()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0034()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0035()
  {
    rc_int = (new BigDecimal("32.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0036()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0037()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("NID13K=L=L85G0Q5BBD;=2RO14LTGAEYU22U0>L5JGESB>YTOWEXQ>KG43WGB3;VR<LDT?J6YOWTF=;0IHOJ;MF9=U5IC7>S4ES1");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("-32"), 0, java.math.RoundingMode.UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    rc_BigDecimal = (new BigDecimal("-32")).plus();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0042()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0043()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0044()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0045()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0047()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=0 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0048()
  {
    rc_int = (new BigDecimal("3.2E+2")).compareTo(new BigDecimal("3.2E+2"));
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0049()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).multiply(new BigDecimal("-32"));
//    Assert.assertEquals("-1.024E+2147483651", rc_BigDecimal.toString());
//  }
  public void testItem_0050()
  {
    rc_BigDecimal = (new BigDecimal("-10240.0E+2147483647")).stripTrailingZeros();
    Assert.assertEquals("-1.024E+2147483651", rc_BigDecimal.toString());
  }
  public void testItem_0051()
  {
    rc_int = (new BigDecimal("-32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0052()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, 1, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0054()
  {
    rc_boolean = (new BigDecimal("-32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0055()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-10240.0E+2147483647")).divideToIntegralValue(new BigDecimal("32"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0056()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-10240.0E+2147483647")).divide(new BigDecimal("-10240.0E+2147483647"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
//  public void testItem_0057()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 2147483647, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.59731543624162%", true, caught);
//  }
//  public void testItem_0058()
//  {
//    boolean caught;
////    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
////    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0061()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("-10240.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("-1024", rc_BigInteger.toString());
//  }
  public void testItem_0062()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<KE3JJ1RM6JK?T78T:HF4DOR?VED=FQSK>O<KU:53BAFBAM9FQBW8UHYW2:UU=H;OFSV65648>75DSSK2SQWHYL<ILH6:VVBEN35", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
//  public void testItem_0063()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("00.0E+2147483647")).toEngineeringString();
//    Assert.assertEquals("0.0E+2147483649", rc_String);
//  }
  public void testItem_0064()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0065()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-10240.0E+2147483647")).setScale(0, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.59731543624162%", true, caught);
//  }
//  public void testItem_0066()
//  {
//    boolean caught;
//    rc_long = (new BigDecimal("00.0E+2147483647")).longValueExact();
//    Assert.assertEquals(0L, rc_long);
//  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-10240.0E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0069()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0070()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-3E+1"));
  }
  public void testItem_0071()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0072()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '8', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '8', '8', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\1', '8', '\234', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '8', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\1', '8', '\234', '\1', '\0', '\0', '\1', '\0', '\1', '\1', '8', '\234', '8', '8', '\0', '8', '\0', '\1', '8', '8', '\0', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\234', '8', '\0', '8', '\uFFFF', '\1', '8'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
//  public void testItem_0074()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-10240.0E+2147483647")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("-1.024E+2147483651", rc_BigDecimal.toString());
//  }
  public void testItem_0075()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("-10240.0E+2147483647"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_double = (new BigDecimal("-10240.0E+2147483647")).doubleValue();
    Assert.assertEquals(java.lang.Double.NEGATIVE_INFINITY, rc_double, 0);
  }
//  public void testItem_0077()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal_array = (new BigDecimal("-10240.0E+2147483647")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//  }
  public void testItem_0078()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0079()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-10240.0E+2147483647")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0080()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).setScale(-2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0081()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0083()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("00.0E+2147483647"), 2147483647, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
//  public void testItem_0084()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.59731543624162%", true, caught);
//    }
//  }
  public void testItem_0085()
  {
    rc_BigInteger = (new BigDecimal("00.0E+2147483647")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0086()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-10240.0E+2147483647")).scaleByPowerOfTen(0);
//    Assert.assertEquals("-1.024E+2147483651", rc_BigDecimal.toString());
//  }
  public void testItem_0087()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0089()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-10240.0E+2147483647")).round(new MathContext("precision=1 roundingMode=UP"));
//    Assert.assertEquals("-2E-2147483645", rc_BigDecimal.toString());
//  }
  public void testItem_0090()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_long = (new BigDecimal("4E+1")).longValue();
    Assert.assertEquals(40L, rc_long);
  }
  public void testItem_0092()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0093()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("4E+1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0096()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0097()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("4E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.59731543624162%", true, caught);
//  }
  public void testItem_0098()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0099()
  {
    rc_long = (new BigDecimal("4E+1")).longValue();
    Assert.assertEquals(40L, rc_long);
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("0.0"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0102()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("4E+1"), -1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("2=K<H2J7;CS4F3XGA>0G?EENAO8A43THBMU?;5RS@GPWJL7V<BNUB;>2NB8;CBJC<@@GR24N");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0104()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\1', '\1', '\uFFFF', '8', '\0', '8', '\0', '\1', '8', '\234', '8', '\0', '\234', '\0', '\234', '\0', '\234', '\0', '\234', '8', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\1', '8', '\234', '\234', '\234', '8', '8', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '8', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\234', '\1', '\0', '\uFFFF', '\234', '\234', '8', '\1', '\1', '\0', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\0', '8', '8', '\234', '8'}, -1, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0105()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0106()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-2147483648, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    rc_byte = (new BigDecimal("0E-2147483647")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
//  public void testItem_0109()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.59731543624162%", true, caught);
//  }
  public void testItem_0110()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).add(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("00.0E+2147483647"), new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).scaleByPowerOfTen(0);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(0);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-2147483648")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0116()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0117()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toEngineeringString();
    Assert.assertEquals("0.0E-2147483646", rc_String);
  }
  public void testItem_0118()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("2147483647"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0120()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).abs();
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0121()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\uFFFF', '8', '\1', '\234', '\0', '\0', '8', '\0', '\234', '8', '\uFFFF', '\0', '\1', '\0', '\234', '\234', '\0', '8', '\1', '8', '\234', '\0', '8', '\234', '\uFFFF', '8', '8', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '8', '\0', '\0', '\0', '\uFFFF', '\0', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\1', '8', '8', '\234', '\234', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\1', '\0', '8', '\uFFFF', '\234', '\0', '\0', '\234', '8', '\0', '\0', '8', '\0', '8', '\uFFFF', '8', '\uFFFF'}, -1, -2147483648, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0122()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0123()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("-2147483648"), 2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.59731543624162%", true, caught);
//  }
//  public void testItem_0124()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("-2147483648")).hashCode();
////    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).add(new BigDecimal("2147483648"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0126()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).abs();
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0128()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0129()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).multiply(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0130()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\234', '8', '\0', '\1', '8', '\uFFFF'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0132()
  {
    rc_String = (new BigDecimal("2147483648")).toEngineeringString();
    Assert.assertEquals("2147483648", rc_String);
  }
  public void testItem_0133()
  {
    rc_long = (new BigDecimal("-2147483648")).longValueExact();
    Assert.assertEquals(-2147483648L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0134()
  {
    rc_boolean = (new BigDecimal("-2147483648")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0135()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0136()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0137()
  {
    rc_boolean = (new BigDecimal("-1")).equals("0NAPR;");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0138()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0140()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0141()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).multiply(new BigDecimal("-2147483648"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-4.294967296E+18", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    rc_int = (new BigDecimal("2147483647")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0143()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0144()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-4.294967296E+18")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0146()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointLeft(-1);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\1', '\234', '\0', '\0', '\234', '\uFFFF', '8', '\234', '8', '\uFFFF', '\234', '\1', '\234', '\0', '\1', '\234', '8', '\0', '\uFFFF', '8', '8', '\234', '\0', '\0', '\0', '\0', '\0', '\234', '\uFFFF', '8', '\234', '\1', '8', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\0', '8', '\0', '\0', '\0', '8', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '8', '8', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\0', '\1', '\1', '\234', '8', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\0'}, 2147483647, 0, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0150()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0151()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483646")).divideAndRemainder(new BigDecimal("-4.294967296E+18"), new MathContext("precision=0 roundingMode=FLOOR"));
  }
  public void testItem_0152()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0153()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0154()
  {
    rc_BigDecimal = (new BigDecimal("-4.294967296E+18")).subtract(new BigDecimal("0"));
    Assert.assertEquals("-4294967296000000000", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Y54QW8X69;PW4W=J?XIV4>=7LH=UC3A@K@3V4W99T6@NO72J;Y1?DO:J;Y>X2?ERHGY?ERJRO0MHLB9KPCA72RWLY6EC@37?6<QQ");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0156()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0157()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0158()
  {
    rc_int = (new BigDecimal("-4294967296000000000")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0160()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0161()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("P095SP>=543>QFS=OKA1J4H31QX4>H6?7@U2ACPB7ERIH9R8238INVL1C4@@81LP=EH5<NCX4?OMYN5SR?:5>>POD?GPSC0ID3E6", new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0163()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0164()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0165()
  {
    rc_float = (new BigDecimal("0E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0167()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0168()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0169()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0170()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0171()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0173()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0174()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0176()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0177()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0178()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0181()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=UP"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.59731543624162%", true, caught);
//  }
  public void testItem_0182()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0183()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0184()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).min(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0185()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0E-2147483647"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.59731543624162%", true, caught);
//  }
  public void testItem_0186()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0187()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0188()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0189()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0190()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\1', '\234', '8', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '8', '8', '\234', '\234', '8', '\234', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0191()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(-1, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0192()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0196()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0197()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0198()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0199()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0200()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2147483647")).hashCode();
//    Assert.assertEquals(2147483617, rc_int);
//  }
  public void testItem_0201()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0202()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).stripTrailingZeros();
	Assert.assertEquals(0E-2147483647, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0206()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), 2147483647, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0207()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), -2147483648, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0208()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("0E-2147483647")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0210()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0211()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).max(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0213()
  {
    rc_boolean = (new BigDecimal("0E-2147483647")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0214()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0215()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0217()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0E-2147483647"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0218()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0219()
  {
    rc_int = (new BigDecimal("2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0220()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("2147483647"), 0, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.59731543624162%", true, caught);
//    }
//  }
  public void testItem_0221()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("0E-2147483647")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0222()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("2147483647"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("2147483647"), java.math.RoundingMode.UP);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0224()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("2147483647"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0225()
  {
    rc_boolean = (new BigDecimal("0E-2147483647")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0226()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
//  public void testItem_0228()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.59731543624162%", true, caught);
//  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).plus();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0232()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toString();
    Assert.assertEquals("0E-2147483647", rc_String);
  }
  public void testItem_0233()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(-1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 1, 0, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("R3@0EWEV:PB??<V;X2T8G2:Q18449I<T3B:4AF0FW=J@D57DG9>QC9URE");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0237()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0238()
  {
    rc_int = (new BigDecimal("2147483647")).intValueExact();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0239()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(0);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0240()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0242()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0E-2147483647"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
//  public void testItem_0243()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=UP"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0244()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).remainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0247()
  {
    rc_int = (new BigDecimal("0E-2147483647")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0248()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).plus();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    rc_double = (new BigDecimal("0E-2147483647")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0250()
  {
    rc_int = (new BigDecimal("-2147483648")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0251()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0252()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("QUTTR0KP66@IGRB:C5?3R<=G0SFN0WG:P@<JHF;F8D>M?P8L3OF>622CY6NP5;2D:>2RXMNKU:JLNXB8C;5JJAN0N1:O<0=D8");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0253()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0254()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0255()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\234', '8', '8', '8', '\234', '8', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\1', '8', '\1', '\1', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\234', '\0', '8', '\0', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\234', '\234', '8', '8', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\1', '\234', '\234', '8', '8', '\234', '8', '8', '\0', '\234', '\0', '\uFFFF', '\234', '\1', '\234', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '8', '\234', '\1', '\234', '\1', '\234', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0257()
  {
    rc_int = (new BigDecimal("0E-2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0258()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0E-2147483647"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0259()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0260()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), -1, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0261()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0E-2147483647"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
//  public void testItem_0262()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.IllegalArgumentException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0263()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0265()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0266()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), 1, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0267()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0270()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("0E-2147483647"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0271()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0272()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0273()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3.2E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0274()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0275()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0276()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("1E-2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0277()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0278()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0279()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0280()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("0E-2147483647")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0281()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0283()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0284()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0285()
  {
    rc_int = (new BigDecimal("1E-2147483647")).compareTo(new BigDecimal("1E-2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0286()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0287()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("1E-2147483647"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0289()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("1E-2147483647"), new MathContext("precision=0 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0290()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0291()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).multiply(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2.147483647E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_String = (new BigDecimal("1E-2147483647")).toString();
    Assert.assertEquals("1E-2147483647", rc_String);
  }
  public void testItem_0297()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_int = (new BigDecimal("1E-2147483647")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0300()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).toBigIntegerExact();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0303()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("62", rc_BigDecimal.toString());
  }
//  public void testItem_0306()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-2147483647")).setScale(0, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0307()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    rc_BigDecimal = (new BigDecimal("62")).plus(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("HY:8HPWLM=EU6ITBEPGHK7UXJLWK<<OFHGW;O81HUVUIUY>8X4C9T=F8W0YCOR=?>GLXQL:P2U?IQB");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0310()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("2.147483647E-2147483638")).abs();
    Assert.assertEquals("2.147483647E-2147483638", rc_BigDecimal.toString());
  }
//  public void testItem_0312()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("4E+1")).divideAndRemainder(new BigDecimal("1E-2147483647"), new MathContext("precision=0 roundingMode=UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0313()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0314()
  {
    rc_String = (new BigDecimal("4E+1")).toPlainString();
    Assert.assertEquals("40", rc_String);
  }
  public void testItem_0315()
  {
    rc_double = (new BigDecimal("4E+1")).doubleValue();
    Assert.assertEquals(40.0, rc_double, 0);
  }
  public void testItem_0316()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0317()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).divide(new BigDecimal("6E+1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("4E+1"));
    Assert.assertEquals("0.8", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("-3E+9"), new MathContext("precision=0 roundingMode=FLOOR"));
  }
  public void testItem_0322()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0323()
  {
    rc_int = (new BigDecimal("6E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0324()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("6E+1"), 2147483647, 1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0325()
  {
    rc_int = (new BigDecimal("-3E+9")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0326()
  {
    rc_float = (new BigDecimal("6E+1")).floatValue();
    Assert.assertEquals(60.0F, rc_float, 0);
  }
  public void testItem_0327()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\234', '\234', '\uFFFF', '\1', '\0', '\234', '\0', '\0', '\uFFFF', '8', '8', '\uFFFF', '\1', '\1', '\1', '8', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\0', '8', '\234', '\uFFFF', '\1', '\234', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\234', '\1', '\234', '8', '\0', '\1', '\234', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\1', '\234', '8', '\234', '\234', '\1', '\1', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\0'}, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).subtract(new BigDecimal("4E+1"));
    Assert.assertEquals("2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    rc_BigDecimal = (new BigDecimal("2E+1")).negate();
    Assert.assertEquals("-2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_long = (new BigDecimal("6E+1")).longValue();
    Assert.assertEquals(60L, rc_long);
  }
  public void testItem_0331()
  {
    rc_BigDecimal = (new BigDecimal("-3E+9")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0333()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0334()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E+9")).hashCode();
//    Assert.assertEquals(84, rc_int);
//  }
  public void testItem_0335()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0337()
  {
    rc_byte = (new BigDecimal("4E+1")).byteValueExact();
    Assert.assertEquals(40, rc_byte);
  }
//  public void testItem_0338()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("6E+1")).hashCode();
//    Assert.assertEquals(185, rc_int);
//  }
  public void testItem_0339()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_BigDecimal = (new BigDecimal("-32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).pow(0, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0346()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0347()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\0', '8', '\0', '\1', '8', '\1', '\0', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\234', '8', '8', '\234', '\234', '\1', '8', '\234', '\uFFFF', '8', '\1', '8', '\0', '\234', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0351()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).movePointLeft(1);
    Assert.assertEquals("300000000", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0353()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '8', '\1', '\0', '\234', '8', '8', '8', '\234', '\1', '\uFFFF', '\1', '\1', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\234', '\0', '\234', '\0', '8', '\234', '\0', '\1', '\0', '\0', '8', '\0', '\0', '\1', '\0', '\1', '\0', '\uFFFF', '\0', '8', '8', '\0', '\0', '\234', '\0', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '8', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '8', '8', '8', '\234', '\1', '8', '\uFFFF', '\1', '\0', '\234', '\234', '\0', '8', '\1', '\1', '\234', '\0', '\234', '\1'}, 1, -2147483648, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0354()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0355()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0356()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3E+9"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E-9", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0359()
  {
    rc_BigDecimal = (new BigDecimal("0E-9")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-9", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0362()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0363()
  {
    rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("1"));
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0364()
  {
    rc_boolean = (new BigDecimal("0E-9")).equals("ERTP87;>82CMI><AEIUEDR9GV5V3;5A8858E2V9D=G0X7WMAYKCBCPT=4E5E:OXK38F?GAV35XFK:EN>GB45K06S1Q9=VKP:HCUB");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0365()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0366()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-9")).remainder(new BigDecimal("0E-9"), new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).plus(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0370()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0371()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0372()
  {
    rc_int = (new BigDecimal("4E+1")).intValue();
    Assert.assertEquals(40, rc_int);
  }
  public void testItem_0373()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0374()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("32"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\0', '8', '\uFFFF', '\234', '8', '\1', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\1', '\0', '\234', '\uFFFF', '\0', '\1', '8', '8', '\1', '\234', '\0', '\1', '\0', '\1', '\1', '\0', '8', '8', '\234', '8', '8', '\234', '\234', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '8', '\1', '\1', '8', '\1', '8', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\1', '8', '\0', '\0', '8', '\0', '\1', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '8', '8', '\0', '8', '\0', '\234', '\1', '8', '\1'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0380()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("4E+1"));
  }
  public void testItem_0381()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("4E+1"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0383()
  {
    rc_boolean = (new BigDecimal("0")).equals("DI0R<TJVKG0?K66@@8<IPXPQ");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0384()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).abs();
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(">S0L4<5<N1VH@Y=HYD9R6DU;;=6YDL9K3AUKV94RC3PTF=F<1=D@P;2MVQ>E@5QB1W=MX<@V2?IM@IN@=T23VB8=KTJOGPP=;XK@");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0386()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '8', '\0', '8', '\0', '\1', '\1', '\234', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\1', '8', '\234', '\234', '\234', '8', '\0', '\1', '\234', '8', '\uFFFF', '\234', '\1', '\0', '\234', '\1', '\0', '\0', '\0', '8', '\0', '\234', '\0', '\0', '\234', '\234', '\1', '8', '\1'}, 0, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0387()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0388()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-8"));
    Assert.assertEquals("9", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0392()
  {
    rc_boolean = (new BigDecimal("32")).equals("?HFUKLEC>K>U8>6F>:6L?@B70Q6L8WR2T2PW@P=9JEM1QTE7CB1O5K537;P>90:GP9VDX?LH8E21MULDM=3RULA1RCW3QJ6X@265");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0393()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).add(new BigDecimal("-2147483648"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-4294967296", rc_BigDecimal.toString());
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    rc_BigDecimal = (new BigDecimal("-8")).divide(new BigDecimal("-8"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0397()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0398()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0401()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0402()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-8"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0403()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("-8")).subtract(new BigDecimal("-8"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0405()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), 2147483647, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
//  public void testItem_0406()
//  {
//    boolean caught;
////    rc_int = (new BigDecimal("-8")).hashCode();
////    Assert.assertEquals(-248, rc_int);
//  }
  public void testItem_0407()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-8"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("MWE<D?<BM4;1K266GTLJ2VIK4:51FVKW4F;DR8U2IUDOL?PGGHL;XEXOW;XPYY=NB<S");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0409()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0411()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0412()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-8"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0413()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("2TK>62PP:YW530VE2@DISDB=K8:3F78;<TDC9YU1?VQ46GBX68WDF;46FGU=@W7E:DUCWWTFASL7");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0414()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(-2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0415()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0417()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0418()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0419()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0421()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0422()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0423()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0424()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0427()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0429()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0432()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0433()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("32"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0434()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("0E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0435()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0437()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).pow(-2147483648, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0438()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("0E-2147483646"), java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0439()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).subtract(new BigDecimal("0E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0442()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0443()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).stripTrailingZeros();
	Assert.assertEquals(0E-2147483646, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0444()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0446()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0448()
  {
    rc_boolean = (new BigDecimal("0E-2147483646")).equals("P4EK06KDQ:=S2RM70AADBC?LU>YKPYBINS=EQBJ=W;=FFSTHKJWQE@1GFL32GE5<D4TCPFO1KRS??5LJI4MGFD2;3V3R7QO8WSGK");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0449()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0450()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0E-2147483646"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=1 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0452()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0453()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0454()
  {
    rc_String = (new BigDecimal("0E-2147483646")).toEngineeringString();
    Assert.assertEquals("0E-2147483646", rc_String);
  }
  public void testItem_0455()
  {
    rc_String = (new BigDecimal("0E-2147483646")).toString();
    Assert.assertEquals("0E-2147483646", rc_String);
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    rc_int = (new BigDecimal("0E-2147483646")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).stripTrailingZeros();
	Assert.assertEquals(0E-2147483646, rc_BigDecimal.doubleValue(), 0);
  }
//  public void testItem_0459()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("2E+9"), 1, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0460()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483646")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0461()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483646")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0464()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0465()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '8', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\234', '\234', '\234', '8', '\1', '8', '8', '\1', '\234', '\0', '8', '\uFFFF', '\234', '8', '\1', '\0', '\uFFFF', '8', '8', '\uFFFF', '\1', '\234', '\234', '\234', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\1', '\uFFFF', '\0', '\1', '8', '\234', '8', '8', '8', '\0', '\uFFFF', '8', '8', '\234', '\234', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\234', '\234', '\0', '8', '8', '\1', '\1', '\234'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0467()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).plus();
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).subtract(new BigDecimal("0E-2147483646"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0470()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).negate();
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0471()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0472()
  {
    rc_boolean = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).equals(">QF<1JMGL=7R?DW:OT;0L7PE8HCOA41XY9");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0473()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0474()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483646")).add(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=FLOOR"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0475()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0476()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483646")).hashCode();
//    Assert.assertEquals(2147483646, rc_int);
//  }
  public void testItem_0477()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).subtract(new BigDecimal("0E-2147483646"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0478()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toPlainString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).negate();
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0482()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("DR9NWQQ;1F1G1FNE7RSTV5;C9;5=A:@NI1DSPD@<VNY<:R0NH1JF2677;7LV2LS?CNRI@>3F3C>8TTQI?TY2OPDR0HX<O;;@Y43>");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0483()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483646")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0484()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0485()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).pow(2147483647, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0487()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("QF63OKGOS6E;H@7SL>O51;YXFTTS=S40K133>Q@59U0T<C69OYR1=WK9GC5GK7D7FRRIYU>8XY6SUUWVA20N4B<PU939TLKP4@S:", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0488()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0489()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("4XX?@TH9N0S070:N7NS5G6:E<E;>IC:3XQG?FBON1<4DLU?N1:BKGJ:YO?W68N7W7WGU?SMR6HV8A9FQ697M6KX2E<YCNE918F2F");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0490()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("0E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0491()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=1 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0492()
  {
    rc_short = (new BigDecimal("0E-2147483646")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0493()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0494()
  {
    rc_BigInteger = (new BigDecimal("3.2E+2")).toBigIntegerExact();
    Assert.assertEquals("320", rc_BigInteger.toString());
  }
  public void testItem_0495()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1.00000000000E+12", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1E+12"), 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0499()
  {
    rc_BigInteger = (new BigDecimal("1E+12")).toBigInteger();
    Assert.assertEquals("1000000000000", rc_BigInteger.toString());
  }
  public void testItem_0500()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("1E+12"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0503()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0505()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divideToIntegralValue(new BigDecimal("0E-2147483646"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0506()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0507()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_short = (new BigDecimal("0E+1")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0511()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("3E+1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    rc_int = (new BigDecimal("2")).intValueExact();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0513()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0514()
  {
    rc_String = (new BigDecimal("0E+1")).toString();
    Assert.assertEquals("0E+1", rc_String);
  }
  public void testItem_0515()
  {
    rc_BigDecimal = (new BigDecimal("2")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0516()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_int = (new BigDecimal("-2")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0518()
  {
    rc_int = (new BigDecimal("3E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0519()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Y;>?GUL509TX7GB>RY:BNE>10:H3?8QF57==4PPGNQMP03@<DSXX0<>343LB8UT:0NJ3QGD9CEI<IDD@AA", new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0520()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("2")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("-2"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0523()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0524()
  {
    rc_BigDecimal = (new BigDecimal("-2")).add(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("28", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_int = (new BigDecimal("28")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0526()
  {
    rc_int = (new BigDecimal("28")).intValueExact();
    Assert.assertEquals(28, rc_int);
  }
  public void testItem_0527()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0528()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0529()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0531()
  {
    rc_BigDecimal = (new BigDecimal("2")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("2E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0532()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2E+2147483647"), -2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0533()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    rc_String = (new BigDecimal("2E+2147483647")).toString();
    Assert.assertEquals("2E+2147483647", rc_String);
  }
//  public void testItem_0535()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("33")).setScale(-2147483648, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0536()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";LWB0?P", new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("-1"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '\0', '8', '\uFFFF', '\234', '8', '8', '\1', '\1', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '8', '\uFFFF', '\0', '\234', '\1', '8', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0540()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("2E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0541()
//  {
//    boolean caught;
//    rc_BigDecimal_array = (new BigDecimal("2E+21474836467")).divideAndRemainder(new BigDecimal("33"), new MathContext("precision=1 roundingMode=DOWN"));
//  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("33")).add(new BigDecimal("0"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0544()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    rc_byte = (new BigDecimal("33")).byteValueExact();
    Assert.assertEquals(33, rc_byte);
  }
  public void testItem_0546()
  {
    rc_BigDecimal = (new BigDecimal("33")).subtract(new BigDecimal("33"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("33")).divide(new BigDecimal("32"));
    Assert.assertEquals("1.03125", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_BigInteger = (new BigDecimal("1.03125")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0550()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '8', '\0', '8', '\uFFFF', '\1', '8', '\uFFFF', '8', '8', '\1', '\uFFFF', '\234', '8', '8', '\1', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '\1', '\0', '\uFFFF', '8', '\1', '\234', '8', '\0', '8', '\uFFFF', '\uFFFF', '\234', '8', '8', '\uFFFF', '\uFFFF'}, 2147483647, -1, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0551()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0552()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"));
  }
//  public void testItem_0555()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0556()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0560()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0561()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0562()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0565()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), -1, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0566()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0567()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0571()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0572()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("32"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0575()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0576()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0577()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0578()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0582()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).pow(2147483647, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-9223372036854775808"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0584()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0585()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-2E+19", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0586()
  {
    rc_boolean = (new BigDecimal("-9223372036854775808")).equals("H11PRUJ>BYF56FQJ=S>H?3U7QE=8OC3T?@?3IR45WCNN@UUWIWHDBU6M7WD<X42O440CGWY;;N6B3FEFU0");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0587()
  {
    rc_BigDecimal = (new BigDecimal("-2E+19")).divide(new BigDecimal("-1"));
    Assert.assertEquals("2E+19", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    rc_float = (new BigDecimal("2E+19")).floatValue();
    Assert.assertEquals(1.9999999961012896E19F, rc_float, 0);
  }
  public void testItem_0589()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0590()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_float = (new BigDecimal("2E+19")).floatValue();
    Assert.assertEquals(1.9999999961012896E19F, rc_float, 0);
  }
  public void testItem_0592()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("8Y3;<B61CK<IA;@S:6:208OBASKE<@L:;T:P9Q181J65PA9;WF:E;NO1A0S1U<X?SY0WCV<;F0L7A:>??MAXC=<ESH30?4@M2>UM");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0593()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0594()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0595()
  {
    rc_BigInteger = (new BigDecimal("2E+19")).unscaledValue();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0596()
  {
    rc_boolean = (new BigDecimal("32")).equals("5<5H<FR?I>7Y8SITQ>9>V;3Q@ORW:?X@JJW=O2TXOE0>?CS>7OV>5H?241S;LID08>J522440TRGG=NHG;4VA8LQU");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0597()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0598()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0600()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\234', '\1', '\234', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\uFFFF', '8', '\0', '\234', '\0', '8', '8', '8', '\0', '\234', '8', '8', '\1', '\0', '8', '\1', '\uFFFF', '\0', '\1', '\234', '8', '8', '\1', '\234', '\1', '\0', '\0', '8', '\0', '\234', '8', '\234', '8', '\uFFFF', '\1', '\0', '\234', '8', '\1', '\uFFFF', '\234', '\0', '\0', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\1', '\1', '\1', '\1', '\0', '\1', '\1', '8', '8', '8', '\uFFFF', '8', '\1', '\0', '\234', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '8', '\234'}, 1, 0, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0601()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0603()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0605()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("2E+19")).multiply(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-2E+19", rc_BigDecimal.toString());
  }
//  public void testItem_0607()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2E+19")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
//  public void testItem_0608()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-2E+19"), 2147483647, java.math.RoundingMode.HALF_UP);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0609()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+19")).divide(new BigDecimal("1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0611()
  {
    rc_int = (new BigDecimal("2E+19")).compareTo(new BigDecimal("2E+19"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0612()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-2E+19")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0613()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0615()
  {
    rc_BigDecimal = (new BigDecimal("2E+19")).scaleByPowerOfTen(1);
    Assert.assertEquals("2E+20", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0617()
  {
    rc_int = (new BigDecimal("2E+20")).intValue();
    Assert.assertEquals(-970981376, rc_int);
  }
  public void testItem_0618()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("-2E+19")).setScale(-1);
    Assert.assertEquals("-2.000000000000000000E+19", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0621()
  {
    rc_BigDecimal = (new BigDecimal("2E+20")).pow(-1, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("5E-21", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("5E-21")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0E-21", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_BigDecimal = (new BigDecimal("0E-21")).negate();
    Assert.assertEquals("0E-21", rc_BigDecimal.toString());
  }
  public void testItem_0624()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0E-21"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    rc_BigDecimal = (new BigDecimal("5E-21")).divide(new BigDecimal("32"));
    Assert.assertEquals("1.5625E-22", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0'}, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0631()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0632()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1.5625E-22")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0633()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0634()
  {
    rc_BigDecimal = (new BigDecimal("5E-21")).max(new BigDecimal("-1"));
    Assert.assertEquals("5E-21", rc_BigDecimal.toString());
  }
  public void testItem_0635()
  {
    rc_BigDecimal = (new BigDecimal("1.5625E-22")).divideToIntegralValue(new BigDecimal("1.5625E-22"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("1.5625E-22"));
    Assert.assertEquals("-0.99999999999999999999984375", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1.5625E-22"), 0);
    Assert.assertEquals("-6400000000000000000000", rc_BigDecimal.toString());
  }
//  public void testItem_0638()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-6400000000000000000000")).divide(new BigDecimal("-32"), 2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0639()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0640()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    rc_int = (new BigDecimal("-6400000000000000000000")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0644()
  {
    rc_int = (new BigDecimal("-6400000000000000000000")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0645()
  {
    rc_BigDecimal = (new BigDecimal("-32")).round(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0646()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0647()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\uFFFF', '\1', '\0', '\234', '\234', '\0', '\1', '\1', '\234', '8', '8', '\uFFFF', '8', '\234', '8', '\1', '\234', '\0', '\uFFFF', '\1', '\1', '\0', '8', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\0', '8', '8', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\1', '8', '\0', '\uFFFF', '\uFFFF', '8', '8', '8', '\0', '\234', '\0', '8', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0648()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0649()
  {
    rc_BigInteger = (new BigDecimal("-32")).unscaledValue();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0650()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).plus();
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0654()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("I:XSBNFCTM87A5QGDRVD:1WF:A:S0VGTN41T>U?9D;@6Y::<DH=7AG:GEMO1YW");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0655()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).multiply(new BigDecimal("-3E+1"));
    Assert.assertEquals("9E+2", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0658()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0659()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0660()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\1', '\uFFFF', '8', '\1', '\0', '\1', '\0', '8', '8', '8', '\1', '\234', '\uFFFF', '\1', '\0', '\1', '\1', '\1', '\234', '8', '8', '\234', '\uFFFF', '8', '8', '\234', '\234', '\0', '\uFFFF', '\234', '\234', '\234', '\234', '\uFFFF', '\0', '\0', '8', '\0', '\0', '8', '8', '\0', '\0', '\1', '\0', '\0', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\0', '8', '8', '\1', '\0', '\0', '\0', '\234', '\234', '8', '\uFFFF', '8', '\0', '\234', '\0', '\1', '8', '\0', '\0', '8', '\uFFFF', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0661()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0662()
  {
    rc_BigInteger = (new BigDecimal("-3E+1")).unscaledValue();
    Assert.assertEquals("-3", rc_BigInteger.toString());
  }
  public void testItem_0663()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-3E+1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0664()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0665()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0667()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("02EB=8;GO:93?P6ONTY4GG0@CDYF;6WLS5X:T@?BRY==:4N4>E20UMVD;BB0V1:9OY?9UE2P:FF78E?@H863M9CRY4;5E2YFMFI;");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0668()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("3E+1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0669()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E+1")).hashCode();
//    Assert.assertEquals(92, rc_int);
//  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("3E+1"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0672()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("XHGNX93A5UC74ESFXH?PE1ADU65SVTPFA>=GBHT;IU@;V4>5=:J2GM:2?K;0R8IG2=?M:7J6I:J2AN");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0673()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0675()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0676()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -2147483648, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0678()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0681()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0682()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0683()
  {
    rc_boolean = (new BigDecimal("0")).equals("L030SI9IW6GIRGV@=?6L9S8U9V7");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0684()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0685()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).setScale(-1);
    Assert.assertEquals("-9.00000000000000000E+18", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-9.00000000000000000E+18"));
    Assert.assertEquals("8999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=0 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0690()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("-9E+18"));
  }
  public void testItem_0691()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).min(new BigDecimal("-1"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0692()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\1', '\0', '\1', '8', '\0', '\0', '\uFFFF', '\1', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).negate();
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("-9E+18"));
    Assert.assertEquals("0E+17", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0702()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0704()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0705()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0706()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0707()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0709()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-2147483648")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0711()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483647")).pow(-1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0712()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
//  public void testItem_0713()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1E+2147483647"), 1, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
//  public void testItem_0714()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1E+2147483647"));
//    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
//    }
//  }
//  public void testItem_0715()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), 2147483647, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
//  public void testItem_0716()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0717()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0719()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0721()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0722()
  {
    rc_String = (new BigDecimal("-2147483648")).toEngineeringString();
    Assert.assertEquals("-2147483648", rc_String);
  }
  public void testItem_0723()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).negate();
    Assert.assertEquals("-1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    rc_String = (new BigDecimal("0E+2147483647")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0730()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, java.math.RoundingMode.UP);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0734()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).abs(new MathContext("precision=1 roundingMode=UNNECESSARY"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0735()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\uFFFF'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0736()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).abs();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0737()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0738()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-1E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0739()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, 1, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-2147483648, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0741()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("I?>WGLC?<KT@TQLJ<:WC2X05@F=A?23FN0LMHFNS3B:?30V48H9Q98V2O@T84@Q8DP4795=O6B>R3;X=SUD@=>NAPYJ6ROTH03KD");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0743()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1E+2147483647")).hashCode();
//    Assert.assertEquals(2147483618, rc_int);
//  }
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("8")).abs();
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("8")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    rc_BigInteger = (new BigDecimal("8")).unscaledValue();
    Assert.assertEquals("8", rc_BigInteger.toString());
  }
  public void testItem_0747()
  {
    rc_BigDecimal = (new BigDecimal("8")).pow(1);
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0749()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0751()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0753()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).stripTrailingZeros();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0754()
  {
    rc_int = (new BigDecimal("8")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0755()
  {
    rc_double = (new BigDecimal("0.1")).doubleValue();
    Assert.assertEquals(0.1, rc_double, 0);
  }
  public void testItem_0756()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("ALVSLVQ=KB><<X@J", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0757()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).plus(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2E-2147483646")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0760()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9E+18")).remainder(new BigDecimal("9E+18"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0761()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\1', '\234', '\0', '8', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\0', '8', '\0', '\uFFFF', '8', '\uFFFF', '\0', '8', '\0', '\1', '\0', '8', '\234', '\0', '\234', '\234', '8', '\1', '8', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\0', '8', '\1', '\1', '\0'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0762()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("9E+18")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("0.1"), 1);
    Assert.assertEquals("80", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0765()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).round(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0766()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).movePointRight(0);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).add(new BigDecimal("9E+18"));
    Assert.assertEquals("9000000000000000000.1", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_int = (new BigDecimal("0.1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000.1")).negate();
    Assert.assertEquals("-9000000000000000000.1", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '\0', '\234', '8', '\234', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\1', '8', '\234', '\1', '\uFFFF', '8', '\0', '8', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\1', '8', '8', '\0', '\0', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\0', '\0', '\0', '8', '\1', '8', '\1', '\234', '\uFFFF', '\234', '8', '8', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\0'}, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).abs(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_BigInteger = (new BigDecimal("9000000000000000000.1")).unscaledValue();
    Assert.assertEquals("90000000000000000001", rc_BigInteger.toString());
  }
  public void testItem_0773()
  {
    rc_String = (new BigDecimal("0.1")).toString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0774()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0775()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("3.2E-2147483646"), java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0776()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0777()
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
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0778()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000.1")).stripTrailingZeros();
    Assert.assertEquals("9000000000000000000.1", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0780()
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
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0781()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0782()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000.1")).divide(new BigDecimal("9000000000000000000.1"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0783()
  {
    rc_int = (new BigDecimal("9000000000000000000.1")).precision();
    Assert.assertEquals(20, rc_int);
  }
  public void testItem_0784()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9000000000000000000.1")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0785()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0786()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0787()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0788()
  {
    rc_BigInteger = (new BigDecimal("9000000000000000000.1")).toBigInteger();
    Assert.assertEquals("9000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0789()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0790()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2E-2147483646")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0791()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(-1, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0792()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3.2E-2147483646"), java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0793()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0794()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0796()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0798()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0799()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0800()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824", rc_BigDecimal.toString());
  }
//  public void testItem_0802()
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
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), 0, 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("32"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0807()
  {
    rc_boolean = (new BigDecimal("33")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0808()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\234', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\1', '\234', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '8', '\234', '8', '\234', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\1', '\uFFFF', '8', '\1', '\1', '\0', '\uFFFF', '\1', '8', '\0', '\234', '8', '8', '\1', '\234', '\0', '8', '8', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\0', '\0', '8', '\0', '8', '\0', '\0', '\234', '\1', '\1', '\0', '\uFFFF', '\1', '\234', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8'}, 2147483647, -1, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0812()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
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
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0814()
  {
    rc_BigDecimal_array = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0815()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0816()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("33")).setScale(1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("33.0", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    rc_BigDecimal = (new BigDecimal("33")).abs();
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("33.0")).divide(new BigDecimal("1"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0821()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("33.0")).divide(new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0822()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0823()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0824()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    rc_BigDecimal = (new BigDecimal("33")).stripTrailingZeros();
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_BigDecimal = (new BigDecimal("33")).stripTrailingZeros();
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0828()
  {
    rc_String = (new BigDecimal("33.0")).toEngineeringString();
    Assert.assertEquals("33.0", rc_String);
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("33")).abs(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_int = (new BigDecimal("33")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0831()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("33")).divide(new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0832()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0833()
  {
    rc_BigDecimal = (new BigDecimal("33")).plus();
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0834()
  {
    rc_String = (new BigDecimal("33.0")).toString();
    Assert.assertEquals("33.0", rc_String);
  }
  public void testItem_0835()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824")).add(new BigDecimal("33"));
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_BigDecimal = (new BigDecimal("33")).movePointRight(1);
    Assert.assertEquals("330", rc_BigDecimal.toString());
  }
//  public void testItem_0838()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857")).hashCode();
//    Assert.assertEquals(2115522622, rc_int);
//  }
  public void testItem_0839()
  {
    rc_BigDecimal = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-6E+306", rc_BigDecimal.toString());
  }
  public void testItem_0840()
  {
    rc_int = (new BigDecimal("3E+1")).compareTo(new BigDecimal("330"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0841()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\0', '\0', '8', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\234', '8', '\234', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\1', '\0', '\0', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\234', '\0', '8', '\0', '\0', '\1', '\uFFFF', '\1', '\0', '\234', '8', '\0', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\1', '\1', '\1', '\234', '\1', '\1', '\1', '\234', '\0', '\0', '8', '\234', '\0', '\234', '\0', '\234', '\0', '8', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0842()
  {
    rc_BigInteger = (new BigDecimal("33")).toBigInteger();
    Assert.assertEquals("33", rc_BigInteger.toString());
  }
  public void testItem_0843()
  {
    rc_int = (new BigDecimal("3E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0844()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0845()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    rc_BigDecimal = (new BigDecimal("330")).divideToIntegralValue(new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0848()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("33")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0849()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("6;?T36C3G5U4GW5Y03I20<Q9B@WM0HB@ODGDNHQNQ238FYKS<5JTXGIG4S?EML3NV8@>=F59;RB;9GAQ@GW:06M6W96DO0M?UMHP");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0852()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0853()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0855()
  {
    rc_BigInteger = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857")).toBigInteger();
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857", rc_BigInteger.toString());
  }
  public void testItem_0856()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("32317006071311000124898031224579573843090711673822037420515886478292823994993138674481962506230793058252225437079377520911390436322902341314641236089996355364796691954597073853311793036545971292569645384902133615799048012694523410766823033186436078386283980618856409414727255160864941408179785673109070764255405637712243926106187827619681103765980839692792678566601744461466064161002824604681821655448893368564971987952030936037618568570402780985198765871366912294273978744000867803517844511960663770511714396491833489777196039378614590009350301843409097727866829659250630381092655193582908396093955942605036059623424", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_BigDecimal = (new BigDecimal("330")).setScale(-1);
    Assert.assertEquals("3.3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0859()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0861()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0862()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0863()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0864()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0865()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0866()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).pow(-2147483648, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0867()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0868()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("J>P@0IGPC4JSMXWYC63JAC7;9CNPW>X>EIS>Q;J>6VX1VN:BK>5F1@<7JAUNJB9AK7404:CTHY9CRAM:X1S3KYESVSHQXH1L>2YH", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0870()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).max(new BigDecimal("-1"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0871()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=UP"));
  }
  public void testItem_0872()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1E+308", rc_BigDecimal.toString());
  }
  public void testItem_0873()
  {
    rc_float = (new BigDecimal("1E+308")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0874()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0875()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+308")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0876()
  {
    rc_int = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857")).compareTo(new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857"));
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0877()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0878()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    rc_BigDecimal = (new BigDecimal("1E+308")).movePointLeft(0);
    if (JavaSpecVersionChecker.isJDK13OrNewer()) {
    	Assert.assertEquals("1E+308", rc_BigDecimal.toString());
    } else {
    	Assert.assertEquals("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
    	 	
    }
  }
  public void testItem_0881()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("1E+308"));
    Assert.assertEquals("1E+308", rc_BigDecimal.toString());
  }
  public void testItem_0882()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).multiply(new BigDecimal("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0885()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0886()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0887()
  {
    rc_BigDecimal = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).plus();
    Assert.assertEquals("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).multiply(new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("5E+922", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0890()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).hashCode();
//    Assert.assertEquals(910403421, rc_int);
//  }
  public void testItem_0891()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0892()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0893()
  {
    rc_BigDecimal = (new BigDecimal("5E+922")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("8.98846567431157854072637118658521783990352837629224982994587384015786303900142693802947793163834390857702294767571912321171606634447320913842337733517687584930249552882756410381227450451946644720379342542275669711522916184516114740829042796660616741373989131020723615843690885904596499406252020130920624291840E+1230", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_BigDecimal = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).scaleByPowerOfTen(0);
    Assert.assertEquals("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0896()
  {
    rc_double = (new BigDecimal("8.98846567431157854072637118658521783990352837629224982994587384015786303900142693802947793163834390857702294767571912321171606634447320913842337733517687584930249552882756410381227450451946644720379342542275669711522916184516114740829042796660616741373989131020723615843690885904596499406252020130920624291840E+1230")).doubleValue();
    Assert.assertEquals(java.lang.Double.POSITIVE_INFINITY, rc_double, 0);
  }
  public void testItem_0897()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0898()
  {
    rc_BigInteger = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).toBigIntegerExact();
    Assert.assertEquals("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0899()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0900()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigInteger();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0901()
  {
    rc_BigDecimal = (new BigDecimal("8.98846567431157854072637118658521783990352837629224982994587384015786303900142693802947793163834390857702294767571912321171606634447320913842337733517687584930249552882756410381227450451946644720379342542275669711522916184516114740829042796660616741373989131020723615843690885904596499406252020130920624291840E+1230")).add(new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("9E+1230", rc_BigDecimal.toString());
  }
  public void testItem_0902()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0903()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0904()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0905()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0906()
  {
    rc_BigDecimal = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).remainder(new BigDecimal("9E+1230"));
    Assert.assertEquals("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0907()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0908()
  {
    rc_BigDecimal = (new BigDecimal("8.98846567431157854072637118658521783990352837629224982994587384015786303900142693802947793163834390857702294767571912321171606634447320913842337733517687584930249552882756410381227450451946644720379342542275669711522916184516114740829042796660616741373989131020723615843690885904596499406252020130920624291840E+1230")).subtract(new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    Assert.assertEquals("8988465674311578540726371186585217839903528376292249829945873840157863039001426938029477931638343908577022947675719123211716066344473209138423377335176875849302495528827564103812274504519466447203793425422756697115229161845161147408290427966606167413739891310207236158436908859045964994062520201309206242918399999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    rc_BigDecimal = (new BigDecimal("9E+1230")).max(new BigDecimal("8.98846567431157854072637118658521783990352837629224982994587384015786303900142693802947793163834390857702294767571912321171606634447320913842337733517687584930249552882756410381227450451946644720379342542275669711522916184516114740829042796660616741373989131020723615843690885904596499406252020130920624291840E+1230"));
    Assert.assertEquals("9E+1230", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    rc_BigDecimal = (new BigDecimal("8.98846567431157854072637118658521783990352837629224982994587384015786303900142693802947793163834390857702294767571912321171606634447320913842337733517687584930249552882756410381227450451946644720379342542275669711522916184516114740829042796660616741373989131020723615843690885904596499406252020130920624291840E+1230")).divideToIntegralValue(new BigDecimal("9E+1230"));
    Assert.assertEquals("0E-308", rc_BigDecimal.toString());
  }
  public void testItem_0911()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_BigDecimal = (new BigDecimal("9E+1230")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_int = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).signum();
    Assert.assertEquals(1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0914()
  {
    rc_boolean = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).equals("WF<D7N;5RS1G4L9");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0915()
  {
    rc_BigDecimal = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857")).movePointRight(0);
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857", rc_BigDecimal.toString());
  }
  public void testItem_0916()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0917()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\uFFFF', '\234', '\0', '\234', '\1', '\0', '8', '\uFFFF', '\0', '\234', '\234', '8', '\uFFFF', '\1', '8', '\1', '\1', '\0', '\1', '\1', '\0', '\0', '\1', '\0', '8', '\234', '8', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '8', '\1', '\0', '\1', '\0', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\0', '\234', '\234', '\1', '\1', '8', '\0', '\234', '\234', '\1', '8', '\1', '\uFFFF', '\0', '8', '\0', '8', '\1', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\1', '\234', '\234', '\234', '\1', '8', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0918()
  {
    rc_BigInteger = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).unscaledValue();
    Assert.assertEquals("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857")).min(new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857"));
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    rc_int = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).compareTo(new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0923()
  {
    rc_double = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).doubleValue();
    Assert.assertEquals(java.lang.Double.POSITIVE_INFINITY, rc_double, 0);
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
//  public void testItem_0925()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901857")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0926()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).divide(new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), -2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0927()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0928()
  {
    rc_BigDecimal = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).add(new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    Assert.assertEquals("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0929()
  {
    rc_BigDecimal_array = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).divideAndRemainder(new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
  }
  public void testItem_0930()
  {
    rc_BigDecimal = (new BigDecimal("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).divide(new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0932()
  {
    rc_BigInteger = (new BigDecimal("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).toBigIntegerExact();
    Assert.assertEquals("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
//  public void testItem_0933()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0934()
  {
    rc_BigDecimal = (new BigDecimal("2")).divideToIntegralValue(new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0935()
  {
    rc_int = (new BigDecimal("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0936()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).divide(new BigDecimal("32"));
    Assert.assertEquals("312500000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    rc_long = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0939()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("UEWXR@9L<V1=@V2V9?:DOT6J=N@P1;W?LB3BT3TSXKJ3YHE1SX=2BDL>?=UUNVEYGQ<IR78:");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0940()
  {
    rc_BigDecimal_array = (new BigDecimal("312500000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).divideAndRemainder(new BigDecimal("312500000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
  }
  public void testItem_0941()
  {
    rc_BigDecimal = (new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).max(new BigDecimal("0"));
    Assert.assertEquals("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
//  public void testItem_0942()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("32"), 2147483647, java.math.RoundingMode.CEILING);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0943()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\1', '8', '8', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\0', '\234', '\234', '\0', '\234', '8', '8', '\1', '\234', '\1', '\1', '8', '8', '\0', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\1', '8', '\1', '8', '\0', '\0', '\0', '\234', '\0', '\uFFFF', '\1', '\234', '\1', '\1', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '8', '8', '\0', '8', '\0', '\1', '8', '\1', '\1', '\0', '\uFFFF', '\234', '8', '8', '\uFFFF', '\1', '\234', '8', '\0', '\234', '8', '8', '\1', '\1', '\234', '\234', '\234', '8', '\234', '\1', '8', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\234', '8', '\0', '\1', '\uFFFF', '\0', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0944()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).pow(-1, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0.03", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0950()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0951()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).add(new BigDecimal("0"));
    Assert.assertEquals("40", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("0.03"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0953()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0954()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).plus(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0955()
  {
    rc_byte = (new BigDecimal("40")).byteValueExact();
    Assert.assertEquals(40, rc_byte);
  }
  public void testItem_0956()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0957()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0958()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.03")).divide(new BigDecimal("00.0E+2147483647"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0959()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=0 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0960()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).compareTo(new BigDecimal("4E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0961()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("0.03"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("2147483646.97", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_double = (new BigDecimal("4E+1")).doubleValue();
    Assert.assertEquals(40.0, rc_double, 0);
  }
  public void testItem_0965()
  {
    rc_int = (new BigDecimal("2147483646.97")).intValue();
    Assert.assertEquals(2147483646, rc_int);
  }
  public void testItem_0966()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483646.97")).remainder(new BigDecimal("00.0E+2147483647"), new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0967()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0968()
  {
    rc_int = (new BigDecimal("2147483646.97")).intValue();
    Assert.assertEquals(2147483646, rc_int);
  }
  public void testItem_0969()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0970()
  {
    rc_BigDecimal = (new BigDecimal("2147483646.97")).add(new BigDecimal("00.0E+2147483647"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("2147483646.97", rc_BigDecimal.toString());
  }
  public void testItem_0971()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0972()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).movePointRight(0);
    if (JavaSpecVersionChecker.isJDK13OrNewer()) {
   	 Assert.assertEquals("4E+1", rc_BigDecimal.toString());
   } else { 
   	Assert.assertEquals("40", rc_BigDecimal.toString());
   }
  }
  public void testItem_0974()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0975()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).max(new BigDecimal("2147483646.97"));
    Assert.assertEquals("2147483646.97", rc_BigDecimal.toString());
  }
  public void testItem_0976()
  {
    rc_BigDecimal = (new BigDecimal("2147483646.97")).min(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("2147483646.97", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0978()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0979()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2147483646.97")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0980()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0981()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0982()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("PI4@2S2=>OPOFS9TW8V?D4VX6LQDQIKGU;X5U=I5YRW8YH1F74YFW2I@9KKPSLAW30I5NM7B661<7E3EL@31FYV=VJ<<J;:4J;53", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0983()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0984()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0985()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0986()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(2147483647);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0988()
  {
    rc_double = (new BigDecimal("3.2")).doubleValue();
    Assert.assertEquals(3.2, rc_double, 0);
  }
  public void testItem_0989()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0992()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointLeft(-1);
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0994()
  {
    rc_int = (new BigDecimal("3.2E+2")).intValue();
    Assert.assertEquals(320, rc_int);
  }
  public void testItem_0995()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0998()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).max(new BigDecimal("0"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
}
