import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    static int[] inverses;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solve(N, M, K));

        sc.close();
    }

    static int solve(int N, int M, int K) {
        inverses = new int[N * M + 1];
        for (int i = 1; i < inverses.length; ++i) {
            inverses[i] = BigInteger.valueOf(i).modInverse(BigInteger.valueOf(MODULUS)).intValue();
        }

        int result = 0;
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < M; ++c) {
                result = addMod(result, addMod(multiplyMod(N, addMod(computePrefixSum(c), computePrefixSum(M - 1 - c))),
                        multiplyMod(M, addMod(computePrefixSum(r), computePrefixSum(N - 1 - r)))));
            }
        }

        for (int i = 0; i < K - 2; ++i) {
            result = divideMod(multiplyMod(result, N * M - 2 - i), i + 1);
        }

        result = divideMod(result, 2);

        return result;
    }

    static int computePrefixSum(int limit) {
        return divideMod(multiplyMod(limit, limit + 1), 2);
    }

    static int addMod(int x, int y) {
        return (x + y) % MODULUS;
    }

    static int multiplyMod(int x, int y) {
        return (int) ((long) x * y % MODULUS);
    }

    static int divideMod(int x, int y) {
        return multiplyMod(x, inverses[y]);
    }
}