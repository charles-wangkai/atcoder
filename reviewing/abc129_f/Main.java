import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static final int DIGIT_NUM_LIMIT = 18;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long L = sc.nextLong();
        long A = sc.nextLong();
        long B = sc.nextLong();
        int M = sc.nextInt();

        System.out.println(solve(L, A, B, M));

        sc.close();
    }

    static int solve(long L, long A, long B, int M) {
        long[] beginIndices = new long[DIGIT_NUM_LIMIT + 1];
        long[] endIndices = new long[DIGIT_NUM_LIMIT + 1];
        for (int digitNum = 1; digitNum <= DIGIT_NUM_LIMIT; ++digitNum) {
            beginIndices[digitNum] = findBeginIndex(L, A, B, digitNum);
            endIndices[digitNum] = findEndIndex(L, A, B, digitNum);
        }

        int result = 0;
        BigInteger tenExponent = BigInteger.ZERO;
        for (int digitNum = DIGIT_NUM_LIMIT; digitNum >= 1; --digitNum) {
            if (beginIndices[digitNum] != -1) {
                long count = endIndices[digitNum] - beginIndices[digitNum] + 1;

                result = addMod(result, multiplyMod(computePart(A, B, M, digitNum, beginIndices[digitNum], count),
                        BigInteger.TEN.modPow(tenExponent, BigInteger.valueOf(M)).intValue(), M), M);

                tenExponent = tenExponent.add(BigInteger.valueOf(digitNum).multiply(BigInteger.valueOf(count)));
            }
        }

        return result;
    }

    static int computePart(long A, long B, int M, int digitNum, long beginIndex, long count) {
        int[][] transition = {
                { BigInteger.TEN.modPow(BigInteger.valueOf(digitNum), BigInteger.valueOf(M)).intValue(), 0, 0 },
                { 1, 1, 0 }, { 0, mod(B, M), 1 } };

        int[] initial = { 0, mod(A + B * beginIndex, M), 1 };

        return multiply(initial, pow(transition, count, M), M)[0];
    }

    static int[] multiply(int[] v, int[][] m, int M) {
        int size = m.length;

        int[] result = new int[size];
        for (int i = 0; i < result.length; ++i) {
            for (int j = 0; j < size; ++j) {
                result[i] = addMod(result[i], multiplyMod(v[j], m[j][i], M), M);
            }
        }

        return result;
    }

    static int[][] multiply(int[][] m1, int[][] m2, int M) {
        int size = m1.length;

        int[][] result = new int[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                for (int k = 0; k < size; ++k) {
                    result[i][j] = addMod(result[i][j], multiplyMod(m1[i][k], m2[k][j], M), M);
                }
            }
        }

        return result;
    }

    static int[][] pow(int[][] m, long exponent, int M) {
        int size = m.length;

        int[][] result = new int[size][size];
        for (int i = 0; i < size; ++i) {
            result[i][i] = 1;
        }

        while (exponent != 0) {
            if ((exponent & 1) != 0) {
                result = multiply(result, m, M);
            }

            m = multiply(m, m, M);
            exponent >>= 1;
        }

        return result;
    }

    static int mod(long x, int M) {
        return (int) (x % M);
    }

    static int addMod(int x, int y, int M) {
        return (x + y) % M;
    }

    static int multiplyMod(int x, int y, int M) {
        return (int) ((long) x * y % M);
    }

    static long findBeginIndex(long L, long A, long B, int digitNum) {
        long result = -1;
        long lower = 0;
        long upper = L - 1;
        while (lower <= upper) {
            long middle = (lower + upper) / 2;
            String s = String.valueOf(A + B * middle);

            if (s.length() >= digitNum) {
                if (s.length() == digitNum) {
                    result = middle;
                }

                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }

        return result;
    }

    static long findEndIndex(long L, long A, long B, int digitNum) {
        long result = -1;
        long lower = 0;
        long upper = L - 1;
        while (lower <= upper) {
            long middle = (lower + upper) / 2;
            String s = String.valueOf(A + B * middle);

            if (s.length() <= digitNum) {
                if (s.length() == digitNum) {
                    result = middle;
                }

                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }

        return result;
    }
}