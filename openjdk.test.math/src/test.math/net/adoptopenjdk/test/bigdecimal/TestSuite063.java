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
public class TestSuite063 extends TestCase
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
        rc_BigDecimal = new BigDecimal(0L);
        Assert.assertEquals("0", rc_BigDecimal.toString());
    }
    public void testItem_0001()
    {
        boolean caught;
        caught = false;
        try
        {
            rc_BigDecimal = new BigDecimal("U?VCTHBICVBSQ95MPX9CIIPBDXQ8GN18H4E9649SIOWKTF7CF69UA<J6JACS80SHJ;=;=DO40NO6E>1TG=LFS0SMP3??CNVX=<>I");
        } catch (java.lang.NumberFormatException e)
        {
            caught = true;
        }
        Assert.assertEquals("91.94630872483222%", true, caught);
    }
    public void testItem_0002()
    {
        boolean caught;
        caught = false;
        try
        {
            rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\234', '\234', '\uFFFF'});
        } catch (java.lang.NumberFormatException e)
        {
            caught = true;
        }
        Assert.assertEquals("91.94630872483222%", true, caught);
    }
    public void testItem_0003()
    {
        rc_BigDecimal = (new BigDecimal("0E+2147483646")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
        Assert.assertEquals("0E+2147483646", rc_BigDecimal.toString());
    }
    public void testItem_0004()
    {
        boolean caught;
        caught = false;
        try
        {
            rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), -2147483648, java.math.RoundingMode.FLOOR);
        } catch (java.lang.ArithmeticException e)
        {
            caught = true;
        }
        Assert.assertEquals("91.94630872483222%", true, caught);
    }
    public void testItem_0005()
    {
        rc_BigDecimal = new BigDecimal(1L);
        Assert.assertEquals("1", rc_BigDecimal.toString());
    }
    public void testItem_0006()
    {
        rc_float = (new BigDecimal("0")).floatValue();
        Assert.assertEquals(0.0F, rc_float, 0);
    }
    public void testItem_0007()
    {
        boolean caught;
        caught = false;
        try
        {
            rc_BigDecimal = (new BigDecimal("-3E-2147483646")).divideToIntegralValue(new BigDecimal("0"));
        } catch (java.lang.ArithmeticException e)
        {
            caught = true;
        }
        Assert.assertEquals("91.94630872483222%", true, caught);
    }
    public void testItem_0008()
    {
        rc_BigDecimal = (new BigDecimal("0E+2147483646")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
        Assert.assertEquals("0", rc_BigDecimal.toString());
    }
    public void testItem_0009()
    {
        boolean caught;
        caught = false;
        try
        {
            rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 1, -1);
        } catch (java.lang.IllegalArgumentException e)
        {
            caught = true;
        }
        Assert.assertEquals("91.94630872483222%", true, caught);
    }
    //  public void testItem_0010()
    //  {
    //    boolean caught;
    //    caught = false;
    //    try {
    //      rc_BigInteger = (new BigDecimal("-3E-2147483646")).toBigInteger();
    //    }
    //    catch (java.lang.OutOfMemoryError e) {
    //      caught = true;
    //    }
    //    Assert.assertEquals("91.94630872483222%", true, caught);
    //  }
    public void testItem_0011()
    {
        rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
        Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
    }
    public void testItem_0012()
    {
        rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
        Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
    }
    public void testItem_0014()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(2);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0015()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(2);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0016()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(2);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0017()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(2);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0018()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(2);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0019()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(1);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0020()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(1);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0021()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(2);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0022()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(2);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0023()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(2);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0024()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(2);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0025()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(2);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0026()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(1);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0027()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(1);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0028()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(2);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0029()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(2);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0030()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(2);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0031()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(2);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0032()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(2);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0033()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(1);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0034()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(1);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0035()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(2);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0036()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(2);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0037()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(2);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0038()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(2);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0039()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(2);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0040()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(1);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0041()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(1);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0042()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0043()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0044()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0045()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0046()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0047()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(1);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0048()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.add(beta);
        gamma.setScale(1);
        Assert.assertEquals("1000.70", gamma.toString());
    }
    public void testItem_0049()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0050()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0051()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0052()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0053()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0054()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(1);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0055()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.subtract(beta);
        gamma.setScale(1);
        Assert.assertEquals("999.30", gamma.toString());
    }
    public void testItem_0056()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0057()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0058()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0059()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0060()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0061()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(1, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0062()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.divide(beta, BigDecimal.ROUND_DOWN);
        gamma.setScale(1, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("1428", gamma.toString());
    }
    public void testItem_0063()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0064()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70");
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0065()
    {
        BigDecimal alpha = new BigDecimal("1000");
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0066()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0067()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(2, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0068()
    {
        BigDecimal alpha = new BigDecimal("1000").setScale(0);
        BigDecimal beta = new BigDecimal("0.70").setScale(2);
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(1, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0069()
    {
        BigDecimal alpha = new BigDecimal(new BigInteger("1000"), 0);
        BigDecimal beta = new BigDecimal(new BigInteger("70"), 2);
        BigDecimal gamma = alpha.multiply(beta);
        gamma.setScale(1, BigDecimal.ROUND_DOWN);
        Assert.assertEquals("700.00", gamma.toString());
    }
    public void testItem_0070()
    {
        for (int i = 0; i < 10000; i++)
        {
            BigDecimal alpha = new BigDecimal("12500").setScale(3);
            BigDecimal beta = new BigDecimal("1000");
            beta = beta.add(alpha).setScale(0, BigDecimal.ROUND_DOWN);
            String betaString = beta.toString();
            Assert.assertEquals("13500", betaString);
        }
    }
}
