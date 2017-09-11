/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/
package net.adoptopenjdk.test.autosimd;

import java.util.Arrays;

public strictfp class AutoSIMDTestInteger {
    private boolean allPass;

    public static void main(String[] args) {
        new AutoSIMDTestInteger().runTests();
    }

    public AutoSIMDTestInteger() {
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
        System.out.print("TEST Integer " + name + "...");
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

    private static void simdFill(int[] a, int x, int start, int length) {
        int end = start + length;
        for (int i = start; i < end; i++) {
            a[i] = x;
        }
    }

    private static void fill(int[] a, int x) {
        simdFill(a, x, 0, a.length);
    }

    private static void simdCopy(int[] dst, int[] src, int start_dst, int start_src, int length) {
        int i_end = start_dst + length;
        for (int i = start_dst, j = start_src; i < i_end; i++, j++) {
            dst[i] = src[j];
        }
    }

    private static void simdAdd(int[] dst, int[] a, int[] b, int n) {
        for (int i = 0; i < n; i++) {
            dst[i] = a[i] + b[i];
        }
    }

    private static void simdSub(int[] dst, int[] a, int[] b, int n) {
        for (int i = 0; i < n; i++) {
            dst[i] = a[i] - b[i];
        }
    }

    private static void simdMul(int[] dst, int[] a, int[] b, int n) {
        for (int i = 0; i < n; i++) {
            dst[i] = a[i] * b[i];
        }
    }

    private static void simdDiv(int[] dst, int[] a, int[] b, int n) {
        for (int i = 0; i < n; i++) {
            dst[i] = b[i] == 0 ? 0: a[i] / b[i];
        }
    }

    // ignore second source argument, but still give out of bounds exceptions under the same conditions
    private static void simdNeg(int[] dst, int[] a, int[] b, int n) {
        for (int i = 0; i < n; i++) {
        	@SuppressWarnings("unused") // this is used but the compiler fails to detect this
			double ignore = b[i];
            dst[i] = -a[i];
        }
    }

    // x*a + b*y
    private static void simdLincombWithTemp(int[] dst, int[] x, int[] y, int a, int b, int n) {
        int tmp1, tmp2;
        for (int i = 0; i < n; i++) {
            tmp1 = a;
            tmp1 *= x[i];
            tmp2 = y[i];
            tmp2 *= b;
            tmp1 += tmp2;
            dst[i] = tmp1;
        }
    }

    private static void simdMatrixMult(int[] dst, int[] a, int[] b, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = (int)0.0;
                for (int k = 0; k < n; k++) {
                    sum += a[i * n + k] * b[k * n + j];
                }
                dst[i * n + j] = sum;
            }
        }
    }

    private static int simdSum(int[] a, int n) {
        int sum = (int)0.0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        return sum;
    }

    private static void simdPartialSums(int[] dst, int[] a, int n) {
        int sum = (int)0.0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            dst[i] = sum;
        }
    }

    public static void testFill() {
        final int max = 8;

        // check that full fill works
        for (int n = 0; n < max; n++) {
            int[] a = new int[n];
            int x = sourceData1(n);
            simdFill(a, x, 0, a.length);
            for (int i = 0; i < n; i++) {
                checkThat(Integer.compare(a[i], x) == 0,
                    "Failed simdFill(a [len=%d], %s, 0, a.length): a[%d] = %s, expected %s",
                    a.length, x, i, a[i], x);
            }
        }

        // partial fill works
        for (int n = 0; n < max; n++) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n - i; j++) { 
                    int x = (int)i + sourceData1(j);
                    fill(a, (int)0.0);
                    simdFill(a, x, i, j);
                    for (int k = 0; k < i; k++) {
                        checkThat(Integer.compare(a[k], (int)0.0) == 0,
                            "Failed simdFill(a [len=%d], %s, %d, %d): a[%d] = %s, expected %s",
                            a.length, x, i, j, k, a[k], (int)0.0);
                    }
                    for (int k = i; k < i + j; k++) {
                        checkThat(Integer.compare(a[k], x) == 0,
                            "Failed simdFill(a [len=%d], %s, %d, %d): a[%d] = %s, expected %s",
                            a.length, x, i, j, k, a[k], x);
                    }
                    for (int k = i + j; k < n; k++) {
                        checkThat(Integer.compare(a[k], (int)0.0) == 0,
                            "Failed simdFill(a [len=%d], %s, %d, %d): a[%d] = %s, expected %s",
                            a.length, x, i, j, k, a[k], (int)0.0);
                    }
                }
                // try one past the end
                fill(a, (int)0.0);
                boolean hadBoundsError = false;
                try {
                    simdFill(a, (int)Math.PI, i, n - i + 1);
                } catch (IndexOutOfBoundsException exc) {
                    hadBoundsError = true;
                }
                checkThat(hadBoundsError,
                    "Failed simdFill(a [len=%d], Math.PI, %d, %d): no IndexOutOfBoundsException",
                    a.length, i, n - i + 1);
                for (int k = 0; k < i; k++) {
                    checkThat(Integer.compare(a[k], (int)0.0) == 0,
                        "Failed simdFill(a [len=%d], Math.PI, %d, %d): a[%d] = %s, expected %s",
                        a.length, i, n - i + 1, k, a[k], (int)0.0);
                }
                for (int k = i; k < n; k++) {
                    checkThat(Integer.compare(a[k], (int)Math.PI) == 0,
                        "Failed simdFill(a [len=%d], Math.PI, %d, %d): a[%d] = %s, expected %s",
                        a.length, i, n - i + 1, k, a[k], Math.PI);
                }
            }
        }
    }

     public static void testCopy() {
        for (int n = 0; n < 8; n++) {
            int[] dst = new int[n];
            int[] src = new int[n];
            populate(src, (i) -> sourceData1(i));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int maxLen = Math.min(n - i, n - j);
                    for (int len = 0; len <= maxLen; len++) {
                        fill(dst, (int)0.0);
                        simdCopy(dst, src, i, j, len);
                        for (int k = 0; k < i; k++) {
                            checkThat(Integer.compare(dst[k], (int)0.0) == 0);
                        }
                        for (int k = i; k < i + len; k++) {
                            checkThat(Integer.compare(dst[k], sourceData1(k - i + j)) == 0);
                        }
                        for (int k = i + len; k < n; k++) {
                            checkThat(Integer.compare(dst[k], (int)0.0) == 0,
                                "Failed [n=%d] simdCopy(dst [len=%d], src [len=%d], i=%d, j=%d, len=%d): dst[%d] = %s, expected %s",
                                n, dst.length, src.length,
                                i, j, len,
                                k, dst[k], (int)0.0);
                        }
                        for (int k = 0; k < n; k++) {
                            int expected = sourceData1(k);
                            checkThat(Integer.compare(src[k], expected) == 0,
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
        testSimpleBinary(new BinaryOpSIMDInteger() {
            @Override public int scalarCombine(int x, int y) { return x + y; }
            @Override public void vectorCombine(int[] dest, int[] x, int[] y, int n) { simdAdd(dest, x, y, n); }
        });
    }

    public static void testSub() {
        testSimpleBinary(new BinaryOpSIMDInteger() {
            @Override public int scalarCombine(int x, int y) { return x - y; }
            @Override public void vectorCombine(int[] dest, int[] x, int[] y, int n) { simdSub(dest, x, y, n); }
        });
    }

    public static void testMul() {
        testSimpleBinary(new BinaryOpSIMDInteger() {
            @Override public int scalarCombine(int x, int y) { return x * y; }
            @Override public void vectorCombine(int[] dest, int[] x, int[] y, int n) { simdMul(dest, x, y, n); }
        });
    }

    public static void testDiv() {
        testSimpleBinary(new BinaryOpSIMDInteger() {
            @Override public int scalarCombine(int x, int y) { return y == 0 ? 0 : x / y; }
            @Override public void vectorCombine(int[] dest, int[] x, int[] y, int n) { simdDiv(dest, x, y, n); }
        });
    }

    public static void testNeg() {
        // pretend to be a binary op by ignoring RHS
        testSimpleBinary(new BinaryOpSIMDInteger() {
            @Override public int scalarCombine(int x, int y) { return -x; }
            @Override public void vectorCombine(int[] dest, int[] x, int[] y, int n) { simdNeg(dest, x, y, n); }
        });
    }

    public static void testLincombWithTemp() {
        testSimpleBinary(new BinaryOpSIMDInteger() {
            @Override public int scalarCombine(int x, int y) { return (int)-1.0 * x + (int)2.5 * y; }
            @Override public void vectorCombine(int[] dest, int[] x, int[] y, int n) { simdLincombWithTemp(dest, x, y, (int)-1.0, (int)2.5, n); }
        });
        testSimpleBinary(new BinaryOpSIMDInteger() {
            @Override public int scalarCombine(int x, int y) { return (int)1.1 * x + (int)1.2 * y; }
            @Override public void vectorCombine(int[] dest, int[] x, int[] y, int n) { simdLincombWithTemp(dest, x, y, (int)1.1, (int)1.2, n); }
        });
    }

    public static void testSimpleBinary(BinaryOpSIMDInteger op) {
        final int length = 8;

        // all accesses within bounds
        int[] dst = new int[length];
        int[] x   = new int[length];
        int[] y   = new int[length];
        populate(x, (i) -> sourceData1(i));
        populate(y, (i) -> sourceData2(i));
        for (int n = 2; n <= length; n++) {
            fill(dst, (int)0.0);
            op.vectorCombine(dst, x, y, n);
            for (int i = 0; i < n; i++) {
                checkThat(Integer.compare(dst[i], destData(op, i)) == 0);
            }
            for (int i = n; i < length; i++) {
                checkThat(Integer.compare(dst[i], (int)0.0) == 0);
            }
        }

        // out of bounds on just the destination
        dst = new int[length - 1];
        x   = new int[length];
        y   = new int[length];
        populate(x, (i) -> sourceData1(i));
        populate(y, (i) -> sourceData2(i));
        try {
            op.vectorCombine(dst, x, y, length);
            checkThat(false);
        } catch (IndexOutOfBoundsException exc) { /* expected */ }
        for (int i = 0; i < length - 1; i++) {
            checkThat(Integer.compare(dst[i], destData(op, i)) == 0);
        }

        // out of bounds on just the first source
        dst = new int[length];
        x   = new int[length - 1];
        y   = new int[length];
        populate(x, (i) -> sourceData1(i));
        populate(y, (i) -> sourceData2(i));
        try {
            op.vectorCombine(dst, x, y, length);
            checkThat(false);
        } catch (IndexOutOfBoundsException exc) { /* expected */ }
        for (int i = 0; i < length - 1; i++) {
            checkThat(Integer.compare(dst[i], destData(op, i)) == 0);
        }
        checkThat(Integer.compare(dst[length - 1], (int)0.0) == 0);

        // out of bounds on just the second source
        dst = new int[length];
        x   = new int[length];
        y   = new int[length - 1];
        populate(x, (i) -> sourceData1(i));
        populate(y, (i) -> sourceData2(i));
        try {
            op.vectorCombine(dst, x, y, length);
            checkThat(false);
        } catch (IndexOutOfBoundsException exc) { /* expected */ }
        for (int i = 0; i < length - 1; i++) {
            checkThat(Integer.compare(dst[i], destData(op, i)) == 0);
        }
        checkThat(Integer.compare(dst[length - 1], (int)0.0) == 0);

        // all three aliased
        dst = new int[length];
        populate(dst, (i) -> sourceData1(i));
        op.vectorCombine(dst, dst, dst, length);
        for (int i = 0; i < length; i++) {
            int si = sourceData1(i);
            checkThat(Integer.compare(dst[i], op.scalarCombine(si, si)) == 0);
        }

        // dst == x
        dst = new int[length];
        y   = new int[length];
        populate(dst, (i) -> sourceData1(i));
        populate(y,   (i) -> sourceData2(i));
        op.vectorCombine(dst, dst, y, length);
        for (int i = 0; i < length; i++) {
            checkThat(Integer.compare(dst[i], destData(op, i)) == 0);
        }

        // dst == y
        dst = new int[length];
        x   = new int[length];
        populate(x,   (i) -> sourceData1(i));
        populate(dst, (i) -> sourceData2(i));
        op.vectorCombine(dst, x, dst, length);
        for (int i = 0; i < length; i++) {
            checkThat(Integer.compare(dst[i], destData(op, i)) == 0);
        }

        // x == y
        dst = new int[length];
        x   = new int[length];
        populate(x, (i) -> sourceData2(i));
        op.vectorCombine(dst, x, x, length);
        for (int i = 0; i < length; i++) {
            int si = sourceData2(i);
            checkThat(Integer.compare(dst[i], op.scalarCombine(si, si)) == 0,
                "Failed x==y aliased vectorCombine: dst[%d] = %s, expected %s",
                i, dst[i], op.scalarCombine(si, si));
        }
    }

    public static void testMatrixMult() {
        int[] yRot90 = new int[] {
             (int)0.0, (int)0.0, (int)1.0,
             (int)0.0, (int)1.0, (int)0.0,
            (int)-1.0, (int)0.0, (int)0.0
        };
        int[] xScale2 = new int[] {
            (int)2.0, (int)0.0, (int)0.0,
            (int)0.0, (int)1.0, (int)0.0,
            (int)0.0, (int)0.0, (int)1.0
        };
        int[] yRot90_xScale2 = new int[] {
             (int)0.0, (int)0.0, (int)1.0,
             (int)0.0, (int)1.0, (int)0.0,
            (int)-2.0, (int)0.0, (int)0.0
        };
        int[] xScale2_yRot90 = new int[] {
             (int)0.0, (int)0.0, (int)2.0,
             (int)0.0, (int)1.0, (int)0.0,
            (int)-1.0, (int)0.0, (int)0.0
        };
        int[] yRot90_sqr = new int[] {
            (int)-1.0, (int)0.0, (int)0.0,
             (int)0.0, (int)1.0, (int)0.0,
             (int)0.0, (int)0.0, (int)-1.0
        };
        int[] xScale2_sqr = new int[] {
            (int)4.0, (int)0.0, (int)0.0,
            (int)0.0, (int)1.0, (int)0.0,
            (int)0.0, (int)0.0, (int)1.0
        };
        int[] result = new int[9];
        simdMatrixMult(result, yRot90, xScale2, 3);
        checkThat(Arrays.equals(result, yRot90_xScale2));
        simdMatrixMult(result, xScale2, yRot90, 3);
        checkThat(Arrays.equals(result, xScale2_yRot90));
        simdMatrixMult(result, yRot90, yRot90, 3);
        checkThat(Arrays.equals(result, yRot90_sqr));
        simdMatrixMult(result, xScale2, xScale2, 3);
        checkThat(Arrays.equals(result, xScale2_sqr));

        int[] yRot90_trunc = new int[] {
             (int)0.0, (int)0.0, (int)1.0,
             (int)0.0, (int)1.0, (int)0.0,
            (int)-1.0, (int)0.0 //, 0.0 missing
        };

        // out of bounds on second source
        fill(result, (int)Math.PI);
        try {
            simdMatrixMult(result, xScale2, yRot90_trunc, 3);
            checkThat(false);
        } catch(IndexOutOfBoundsException exc) { /* expected */ }
        // first two entries will be computed before out-of-bounds
        for (int i = 0; i < 2; i++) {
            checkThat(Integer.compare(result[i], xScale2_yRot90[i]) == 0);
        }
        for (int i = 2; i < result.length; i++) {
            checkThat(Integer.compare(result[i], (int)Math.PI) == 0);
        }

        // out of bounds on first source
        fill(result, (int)Math.PI);
        try {
            simdMatrixMult(result, yRot90_trunc, xScale2, 3);
            checkThat(false);
        } catch (IndexOutOfBoundsException exc) { /* expected */ }
        // first two rows will be computed before out-of-bounds
        for (int i = 0; i < 6; i++) {
            checkThat(Integer.compare(result[i], yRot90_xScale2[i]) == 0);
        }
        for (int i = 6; i < result.length; i++) {
            checkThat(Integer.compare(result[i], (int)Math.PI) == 0);
        }

        // out of bounds on dest
        int[] result_trunc = new int[8];
        try {
            simdMatrixMult(result_trunc, xScale2, yRot90, 3);
            checkThat(false);
        } catch (IndexOutOfBoundsException exc) { /* expected */ }
        for (int i = 0; i < result_trunc.length; i++) {
            checkThat(Integer.compare(result_trunc[i], xScale2_yRot90[i]) == 0);
        }

        // simdMatrixMult shouldn't get the right answer when dest is aliased.
        // It should get the following badResult instead
        // dest == src1 == src2
        System.arraycopy(yRot90, 0, result, 0, 9);
        int[] badResult = new int[] {
            (int)-1.0, (int)0.0, (int)-1.0,
             (int)0.0, (int)1.0,  (int)0.0,
             (int)1.0, (int)0.0, (int)-1.0
        };
        simdMatrixMult(result, result, result, 3);
        checkThat(Arrays.equals(result, badResult));

        // dest == src1
        System.arraycopy(yRot90, 0, result, 0, 9);
        badResult = new int[] {
            (int)-1.0, (int)0.0, (int)-1.0,
             (int)0.0, (int)1.0,  (int)0.0,
             (int)0.0, (int)0.0,  (int)0.0
        };
        simdMatrixMult(result, result, yRot90, 3);
        checkThat(Arrays.equals(result, badResult));

        // dest == src2
        System.arraycopy(yRot90, 0, result, 0, 9);
        badResult = new int[] {
            (int)-1.0, (int)0.0, (int)0.0,
             (int)0.0, (int)1.0, (int)0.0,
             (int)1.0, (int)0.0, (int)0.0
        };
        simdMatrixMult(result, yRot90, result, 3);
        checkThat(Arrays.equals(result, badResult));

        // NB. src1 == src2 != dest is tested above, with
        // simdMatrixMult(result, yRot90, yRot90, 3) and
        // simdMatrixMult(result, xScale2, xScale2, 3)
    }

    public static void testSums() {
        int[] naturals = new int[] {
            (int)0.0, (int)1.0, (int)2.0, (int)3.0,
            (int)4.0, (int)5.0, (int)6.0, (int)7.0,
            (int)8.0, (int)9.0, (int)10.0
        };
        int[] triangles = new int[] {
            (int)0.0, (int)1.0, (int)3.0, (int)6.0, (int)10.0,
            (int)15.0, (int)21.0, (int)28.0, (int)36.0, (int)45.0, (int)55.0
        };
        checkThat(Integer.compare(simdSum(naturals, naturals.length), (int)55.0) == 0);
        int[] result = new int[triangles.length];
        simdPartialSums(result, naturals, triangles.length);
        for (int i = 0; i < triangles.length; i++) {
            checkThat(Integer.compare(result[i], triangles[i]) == 0,
                "Failed simdPartialSums(): result[%d] = %s, expected %s",
                i, result[i], triangles[i]);
        }
    }

    private static int sourceData1(int i) {
        return (int)1.0 / ((int)1.0 + Math.abs((int)i));
    }

    private static int sourceData2(int i) {
        int x = (int)1.0 + Math.abs((int)i);
        int y = (int)Math.sin(x * x);
        y = (y == (int)0.0 ? (int)1.0 : y);

        return i % 2 == 0 ? -y : y;
    }

    private static int destData(BinaryOpSIMDInteger op, int i) {
        return op.scalarCombine(sourceData1(i), sourceData2(i));
    }

    private static void populate(int[] dest, IntToInteger f) {
        populate(dest, f, 0, dest.length);
    }

    private static void populate(int[] dest, IntToInteger f, int start, int len) {
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

interface BinaryOpSIMDInteger {
    int scalarCombine(int x, int y);
    void vectorCombine(int[] dest, int[] x, int[] y, int n);
}

interface IntToInteger {
    int at(int i);
}

