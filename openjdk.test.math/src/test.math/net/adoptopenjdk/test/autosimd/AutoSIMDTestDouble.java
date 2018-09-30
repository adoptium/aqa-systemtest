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
package net.adoptopenjdk.test.autosimd;

import java.util.Arrays;

public strictfp class AutoSIMDTestDouble {
    private boolean allPass;

    public static void main(String[] args) {
        new AutoSIMDTestDouble().runTests();
    }

    public AutoSIMDTestDouble() {
        allPass = true;
    }

    public void runTests() {
        runTest("fill", () -> testFill());
        runTest("copy", () -> testCopy());
        runTest("add", () -> testAdd());
        runTest("sub", () -> testSub());
        runTest("mul", () -> testMul());
        runTest("div", () -> testDiv());
        runTest("neg", () -> testNeg());
        runTest("lincombWithTemp", () -> testLincombWithTemp());
        runTest("matrixMult", () -> testMatrixMult());
        runTest("sums", () -> testSums());
        if (allPass) {
            System.out.println("SUCCESSFUL");
        } else {
            System.out.println("ONE OR MORE TESTS FAILED");
            System.exit(1);
        }
    }

    private void runTest(String name, Runnable test) {
        System.out.print("TEST Double " + name + "...");
        System.out.flush();
        try {
            test.run();
        } catch (Exception exc) {
            allPass = false;
            System.out.println(" FAIL");
            exc.printStackTrace(System.out);
            return;
        }
        System.out.println(" ok");
    }

    private static void simdFill(double[] a, double x, int start, int length) {
        int end = start + length;
        for (int i = start; i < end; i++) {
            a[i] = x;
        }
    }

    private static void fill(double[] a, double x) {
        simdFill(a, x, 0, a.length);
    }

    private static void simdCopy(double[] dst, double[] src, int start_dst, int start_src, int length) {
        int i_end = start_dst + length;
        for (int i = start_dst, j = start_src; i < i_end; i++, j++) {
            dst[i] = src[j];
        }
    }

    private static void simdAdd(double[] dst, double[] a, double[] b, int n) {
        for (int i = 0; i < n; i++) {
            dst[i] = a[i] + b[i];
        }
    }

    private static void simdSub(double[] dst, double[] a, double[] b, int n) {
        for (int i = 0; i < n; i++) {
            dst[i] = a[i] - b[i];
        }
    }

    private static void simdMul(double[] dst, double[] a, double[] b, int n) {
        for (int i = 0; i < n; i++) {
            dst[i] = a[i] * b[i];
        }
    }

    private static void simdDiv(double[] dst, double[] a, double[] b, int n) {
        for (int i = 0; i < n; i++) {
            dst[i] = b[i] == 0 ? 0: a[i] / b[i];
        }
    }

    // ignore second source argument, but still give out of bounds exceptions under the same conditions
	private static void simdNeg(double[] dst, double[] a, double[] b, int n) {
        for (int i = 0; i < n; i++) {
        	@SuppressWarnings("unused")
			double ignore = b[i];
            dst[i] = -a[i];
        }
    }

    // x*a + b*y
    private static void simdLincombWithTemp(double[] dst, double[] x, double[] y, double a, double b, int n) {
        double tmp1, tmp2;
        for (int i = 0; i < n; i++) {
            tmp1 = a;
            tmp1 *= x[i];
            tmp2 = y[i];
            tmp2 *= b;
            tmp1 += tmp2;
            dst[i] = tmp1;
        }
    }

    private static void simdMatrixMult(double[] dst, double[] a, double[] b, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double sum = (double)0.0;
                for (int k = 0; k < n; k++) {
                    sum += a[i * n + k] * b[k * n + j];
                }
                dst[i * n + j] = sum;
            }
        }
    }

    private static double simdSum(double[] a, int n) {
        double sum = (double)0.0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        return sum;
    }

    private static void simdPartialSums(double[] dst, double[] a, int n) {
        double sum = (double)0.0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            dst[i] = sum;
        }
    }

    public static void testFill() {
        final int max = 8;

        // check that full fill works
        for (int n = 0; n < max; n++) {
            double[] a = new double[n];
            double x = sourceData1(n);
            simdFill(a, x, 0, a.length);
            for (int i = 0; i < n; i++) {
                checkThat(Double.compare(a[i], x) == 0,
                    "Failed simdFill(a [len=%d], %s, 0, a.length): a[%d] = %s, expected %s",
                    a.length, x, i, a[i], x);
            }
        }

        // partial fill works
        for (int n = 0; n < max; n++) {
            double[] a = new double[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n - i; j++) { 
                    double x = (double)i + sourceData1(j);
                    fill(a, (double)0.0);
                    simdFill(a, x, i, j);
                    for (int k = 0; k < i; k++) {
                        checkThat(Double.compare(a[k], (double)0.0) == 0,
                            "Failed simdFill(a [len=%d], %s, %d, %d): a[%d] = %s, expected %s",
                            a.length, x, i, j, k, a[k], (double)0.0);
                    }
                    for (int k = i; k < i + j; k++) {
                        checkThat(Double.compare(a[k], x) == 0,
                            "Failed simdFill(a [len=%d], %s, %d, %d): a[%d] = %s, expected %s",
                            a.length, x, i, j, k, a[k], x);
                    }
                    for (int k = i + j; k < n; k++) {
                        checkThat(Double.compare(a[k], (double)0.0) == 0,
                            "Failed simdFill(a [len=%d], %s, %d, %d): a[%d] = %s, expected %s",
                            a.length, x, i, j, k, a[k], (double)0.0);
                    }
                }
                // try one past the end
                fill(a, (double)0.0);
                boolean hadBoundsError = false;
                try {
                    simdFill(a, (double)Math.PI, i, n - i + 1);
                } catch (IndexOutOfBoundsException exc) {
                    hadBoundsError = true;
                }
                checkThat(hadBoundsError,
                    "Failed simdFill(a [len=%d], Math.PI, %d, %d): no IndexOutOfBoundsException",
                    a.length, i, n - i + 1);
                for (int k = 0; k < i; k++) {
                    checkThat(Double.compare(a[k], (double)0.0) == 0,
                        "Failed simdFill(a [len=%d], Math.PI, %d, %d): a[%d] = %s, expected %s",
                        a.length, i, n - i + 1, k, a[k], (double)0.0);
                }
                for (int k = i; k < n; k++) {
                    checkThat(Double.compare(a[k], (double)Math.PI) == 0,
                        "Failed simdFill(a [len=%d], Math.PI, %d, %d): a[%d] = %s, expected %s",
                        a.length, i, n - i + 1, k, a[k], Math.PI);
                }
            }
        }
    }

    public static void testCopy() {
        for (int n = 0; n < 8; n++) {
            double[] dst = new double[n];
            double[] src = new double[n];
            populate(src, (i) -> sourceData1(i));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int maxLen = Math.min(n - i, n - j);
                    for (int len = 0; len <= maxLen; len++) {
                        fill(dst, (double)0.0);
                        simdCopy(dst, src, i, j, len);
                        for (int k = 0; k < i; k++) {
                            checkThat(Double.compare(dst[k], (double)0.0) == 0);
                        }
                        for (int k = i; k < i + len; k++) {
                            checkThat(Double.compare(dst[k], sourceData1(k - i + j)) == 0);
                        }
                        for (int k = i + len; k < n; k++) {
                            checkThat(Double.compare(dst[k], (double)0.0) == 0,
                                "Failed [n=%d] simdCopy(dst [len=%d], src [len=%d], i=%d, j=%d, len=%d): dst[%d] = %s, expected %s",
                                n, dst.length, src.length,
                                i, j, len,
                                k, dst[k], (double)0.0);
                        }
                        for (int k = 0; k < n; k++) {
                            double expected = sourceData1(k);
                            checkThat(Double.compare(src[k], expected) == 0,
                                "Failed [n=%d] simdCopy(dst [len=%d], src [len=%d], i=%d, j=%d, len=%d): src[%d] = %s, expected %s",
                                n, dst.length, src.length,
                                i, j, len,
                                k, src[k], expected);
                        }
                    }
                }
            }
        }
    }

    public static void testAdd() {
        testSimpleBinary(new BinaryOpSIMDDouble() {
            @Override public double scalarCombine(double x, double y) { return x + y; }
            @Override public void vectorCombine(double[] dest, double[] x, double[] y, int n) { simdAdd(dest, x, y, n); }
        });
    }

    public static void testSub() {
        testSimpleBinary(new BinaryOpSIMDDouble() {
            @Override public double scalarCombine(double x, double y) { return x - y; }
            @Override public void vectorCombine(double[] dest, double[] x, double[] y, int n) { simdSub(dest, x, y, n); }
        });
    }

    public static void testMul() {
        testSimpleBinary(new BinaryOpSIMDDouble() {
            @Override public double scalarCombine(double x, double y) { return x * y; }
            @Override public void vectorCombine(double[] dest, double[] x, double[] y, int n) { simdMul(dest, x, y, n); }
        });
    }

    public static void testDiv() {
        testSimpleBinary(new BinaryOpSIMDDouble() {
            @Override public double scalarCombine(double x, double y) { return y == 0 ? 0 : x / y; }
            @Override public void vectorCombine(double[] dest, double[] x, double[] y, int n) { simdDiv(dest, x, y, n); }
        });
    }

    public static void testNeg() {
        // pretend to be a binary op by ignoring RHS
        testSimpleBinary(new BinaryOpSIMDDouble() {
            @Override public double scalarCombine(double x, double y) { return -x; }
            @Override public void vectorCombine(double[] dest, double[] x, double[] y, int n) { simdNeg(dest, x, y, n); }
        });
    }

    public static void testLincombWithTemp() {
        testSimpleBinary(new BinaryOpSIMDDouble() {
            @Override public double scalarCombine(double x, double y) { return (double)-1.0 * x + (double)2.5 * y; }
            @Override public void vectorCombine(double[] dest, double[] x, double[] y, int n) { simdLincombWithTemp(dest, x, y, (double)-1.0, (double)2.5, n); }
        });
        testSimpleBinary(new BinaryOpSIMDDouble() {
            @Override public double scalarCombine(double x, double y) { return (double)1.1 * x + (double)1.2 * y; }
            @Override public void vectorCombine(double[] dest, double[] x, double[] y, int n) { simdLincombWithTemp(dest, x, y, (double)1.1, (double)1.2, n); }
        });
    }

    public static void testSimpleBinary(BinaryOpSIMDDouble op) {
        final int length = 8;

        // all accesses within bounds
        double[] dst = new double[length];
        double[] x   = new double[length];
        double[] y   = new double[length];
        populate(x, (i) -> sourceData1(i));
        populate(y, (i) -> sourceData2(i));
        for (int n = 2; n <= length; n++) {
            fill(dst, (double)0.0);
            op.vectorCombine(dst, x, y, n);
            for (int i = 0; i < n; i++) {
                checkThat(Double.compare(dst[i], destData(op, i)) == 0);
            }
            for (int i = n; i < length; i++) {
                checkThat(Double.compare(dst[i], (double)0.0) == 0);
            }
        }

        // out of bounds on just the destination
        dst = new double[length - 1];
        x   = new double[length];
        y   = new double[length];
        populate(x, (i) -> sourceData1(i));
        populate(y, (i) -> sourceData2(i));
        try {
            op.vectorCombine(dst, x, y, length);
            checkThat(false);
        } catch (IndexOutOfBoundsException exc) { /* expected */ }
        for (int i = 0; i < length - 1; i++) {
            checkThat(Double.compare(dst[i], destData(op, i)) == 0);
        }

        // out of bounds on just the first source
        dst = new double[length];
        x   = new double[length - 1];
        y   = new double[length];
        populate(x, (i) -> sourceData1(i));
        populate(y, (i) -> sourceData2(i));
        try {
            op.vectorCombine(dst, x, y, length);
            checkThat(false);
        } catch (IndexOutOfBoundsException exc) { /* expected */ }
        for (int i = 0; i < length - 1; i++) {
            checkThat(Double.compare(dst[i], destData(op, i)) == 0);
        }
        checkThat(Double.compare(dst[length - 1], (double)0.0) == 0);

        // out of bounds on just the second source
        dst = new double[length];
        x   = new double[length];
        y   = new double[length - 1];
        populate(x, (i) -> sourceData1(i));
        populate(y, (i) -> sourceData2(i));
        try {
            op.vectorCombine(dst, x, y, length);
            checkThat(false);
        } catch (IndexOutOfBoundsException exc) { /* expected */ }
        for (int i = 0; i < length - 1; i++) {
            checkThat(Double.compare(dst[i], destData(op, i)) == 0);
        }
        checkThat(Double.compare(dst[length - 1], (double)0.0) == 0);

        // all three aliased
        dst = new double[length];
        populate(dst, (i) -> sourceData1(i));
        op.vectorCombine(dst, dst, dst, length);
        for (int i = 0; i < length; i++) {
            double si = sourceData1(i);
            checkThat(Double.compare(dst[i], op.scalarCombine(si, si)) == 0);
        }

        // dst == x
        dst = new double[length];
        y   = new double[length];
        populate(dst, (i) -> sourceData1(i));
        populate(y,   (i) -> sourceData2(i));
        op.vectorCombine(dst, dst, y, length);
        for (int i = 0; i < length; i++) {
            checkThat(Double.compare(dst[i], destData(op, i)) == 0);
        }

        // dst == y
        dst = new double[length];
        x   = new double[length];
        populate(x,   (i) -> sourceData1(i));
        populate(dst, (i) -> sourceData2(i));
        op.vectorCombine(dst, x, dst, length);
        for (int i = 0; i < length; i++) {
            checkThat(Double.compare(dst[i], destData(op, i)) == 0);
        }

        // x == y
        dst = new double[length];
        x   = new double[length];
        populate(x, (i) -> sourceData2(i));
        op.vectorCombine(dst, x, x, length);
        for (int i = 0; i < length; i++) {
            double si = sourceData2(i);
            checkThat(Double.compare(dst[i], op.scalarCombine(si, si)) == 0,
                "Failed x==y aliased vectorCombine: dst[%d] = %s, expected %s",
                i, dst[i], op.scalarCombine(si, si));
        }
    }

    public static void testMatrixMult() {
        double[] yRot90 = new double[] {
             (double)0.0, (double)0.0, (double)1.0,
             (double)0.0, (double)1.0, (double)0.0,
            (double)-1.0, (double)0.0, (double)0.0
        };
        double[] xScale2 = new double[] {
            (double)2.0, (double)0.0, (double)0.0,
            (double)0.0, (double)1.0, (double)0.0,
            (double)0.0, (double)0.0, (double)1.0
        };
        double[] yRot90_xScale2 = new double[] {
             (double)0.0, (double)0.0, (double)1.0,
             (double)0.0, (double)1.0, (double)0.0,
            (double)-2.0, (double)0.0, (double)0.0
        };
        double[] xScale2_yRot90 = new double[] {
             (double)0.0, (double)0.0, (double)2.0,
             (double)0.0, (double)1.0, (double)0.0,
            (double)-1.0, (double)0.0, (double)0.0
        };
        double[] yRot90_sqr = new double[] {
            (double)-1.0, (double)0.0, (double)0.0,
             (double)0.0, (double)1.0, (double)0.0,
             (double)0.0, (double)0.0, (double)-1.0
        };
        double[] xScale2_sqr = new double[] {
            (double)4.0, (double)0.0, (double)0.0,
            (double)0.0, (double)1.0, (double)0.0,
            (double)0.0, (double)0.0, (double)1.0
        };
        double[] result = new double[9];
        simdMatrixMult(result, yRot90, xScale2, 3);
        checkThat(Arrays.equals(result, yRot90_xScale2));
        simdMatrixMult(result, xScale2, yRot90, 3);
        checkThat(Arrays.equals(result, xScale2_yRot90));
        simdMatrixMult(result, yRot90, yRot90, 3);
        checkThat(Arrays.equals(result, yRot90_sqr));
        simdMatrixMult(result, xScale2, xScale2, 3);
        checkThat(Arrays.equals(result, xScale2_sqr));

        double[] yRot90_trunc = new double[] {
             (double)0.0, (double)0.0, (double)1.0,
             (double)0.0, (double)1.0, (double)0.0,
            (double)-1.0, (double)0.0 //, 0.0 missing
        };

        // out of bounds on second source
        fill(result, (double)Math.PI);
        try {
            simdMatrixMult(result, xScale2, yRot90_trunc, 3);
            checkThat(false);
        } catch(IndexOutOfBoundsException exc) { /* expected */ }
        // first two entries will be computed before out-of-bounds
        for (int i = 0; i < 2; i++) {
            checkThat(Double.compare(result[i], xScale2_yRot90[i]) == 0);
        }
        for (int i = 2; i < result.length; i++) {
            checkThat(Double.compare(result[i], (double)Math.PI) == 0);
        }

        // out of bounds on first source
        fill(result, (double)Math.PI);
        try {
            simdMatrixMult(result, yRot90_trunc, xScale2, 3);
            checkThat(false);
        } catch (IndexOutOfBoundsException exc) { /* expected */ }
        // first two rows will be computed before out-of-bounds
        for (int i = 0; i < 6; i++) {
            checkThat(Double.compare(result[i], yRot90_xScale2[i]) == 0);
        }
        for (int i = 6; i < result.length; i++) {
            checkThat(Double.compare(result[i], (double)Math.PI) == 0);
        }

        // out of bounds on dest
        double[] result_trunc = new double[8];
        try {
            simdMatrixMult(result_trunc, xScale2, yRot90, 3);
            checkThat(false);
        } catch (IndexOutOfBoundsException exc) { /* expected */ }
        for (int i = 0; i < result_trunc.length; i++) {
            checkThat(Double.compare(result_trunc[i], xScale2_yRot90[i]) == 0);
        }

        // simdMatrixMult shouldn't get the right answer when dest is aliased.
        // It should get the following badResult instead
        // dest == src1 == src2
        System.arraycopy(yRot90, 0, result, 0, 9);
        double[] badResult = new double[] {
            (double)-1.0, (double)0.0, (double)-1.0,
             (double)0.0, (double)1.0,  (double)0.0,
             (double)1.0, (double)0.0, (double)-1.0
        };
        simdMatrixMult(result, result, result, 3);
        checkThat(Arrays.equals(result, badResult));

        // dest == src1
        System.arraycopy(yRot90, 0, result, 0, 9);
        badResult = new double[] {
            (double)-1.0, (double)0.0, (double)-1.0,
             (double)0.0, (double)1.0,  (double)0.0,
             (double)0.0, (double)0.0,  (double)0.0
        };
        simdMatrixMult(result, result, yRot90, 3);
        checkThat(Arrays.equals(result, badResult));

        // dest == src2
        System.arraycopy(yRot90, 0, result, 0, 9);
        badResult = new double[] {
            (double)-1.0, (double)0.0, (double)0.0,
             (double)0.0, (double)1.0, (double)0.0,
             (double)1.0, (double)0.0, (double)0.0
        };
        simdMatrixMult(result, yRot90, result, 3);
        checkThat(Arrays.equals(result, badResult));

        // NB. src1 == src2 != dest is tested above, with
        // simdMatrixMult(result, yRot90, yRot90, 3) and
        // simdMatrixMult(result, xScale2, xScale2, 3)
    }

    public static void testSums() {
        double[] naturals = new double[] {
            (double)0.0, (double)1.0, (double)2.0, (double)3.0,
            (double)4.0, (double)5.0, (double)6.0, (double)7.0,
            (double)8.0, (double)9.0, (double)10.0
        };
        double[] triangles = new double[] {
            (double)0.0, (double)1.0, (double)3.0, (double)6.0, (double)10.0,
            (double)15.0, (double)21.0, (double)28.0, (double)36.0, (double)45.0, (double)55.0
        };
        checkThat(Double.compare(simdSum(naturals, naturals.length), (double)55.0) == 0);
        double[] result = new double[triangles.length];
        simdPartialSums(result, naturals, triangles.length);
        for (int i = 0; i < triangles.length; i++) {
            checkThat(Double.compare(result[i], triangles[i]) == 0,
                "Failed simdPartialSums(): result[%d] = %s, expected %s",
                i, result[i], triangles[i]);
        }
    }

    private static double sourceData1(int i) {
        return (double)1.0 / ((double)1.0 + Math.abs((double)i));
    }

    private static double sourceData2(int i) {
        double x = (double)1.0 + Math.abs((double)i);
        double y = (double)Math.sin(x * x);
        y = (y == (double)0.0 ? (double)1.0 : y);

        return i % 2 == 0 ? -y : y;
    }

    private static double destData(BinaryOpSIMDDouble op, int i) {
        return op.scalarCombine(sourceData1(i), sourceData2(i));
    }

    private static void populate(double[] dest, IntToDouble f) {
        populate(dest, f, 0, dest.length);
    }

    private static void populate(double[] dest, IntToDouble f, int start, int len) {
        for (int i = 0; i < len; i++) {
            dest[start + i] = f.at(i);
        }
    }

    private static void checkThat(boolean conditionHolds) {
        checkThat(conditionHolds, "test failure");
    }

    private static void checkThat(boolean conditionHolds, String msgFmt, Object... args) {
        if (!conditionHolds) {
            throw new RuntimeException(String.format(msgFmt, args));
        }
    }
}

interface BinaryOpSIMDDouble {
    double scalarCombine(double x, double y);
    void vectorCombine(double[] dest, double[] x, double[] y, int n);
}

interface IntToDouble {
    double at(int i);
}

