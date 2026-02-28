import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int K = sc.nextInt();

    System.out.println(solve(N, M, K));

    sc.close();
  }

  static int solve(int N, int M, int K) {
    int result = 0;
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < M; ++c) {
        result =
            MOD_INT.addMod(
                result,
                MOD_INT.addMod(
                    MOD_INT.multiplyMod(
                        N, MOD_INT.addMod(computePrefixSum(c), computePrefixSum(M - 1 - c))),
                    MOD_INT.multiplyMod(
                        M, MOD_INT.addMod(computePrefixSum(r), computePrefixSum(N - 1 - r)))));
      }
    }

    for (int i = 0; i < K - 2; ++i) {
      result = MOD_INT.divideMod(MOD_INT.multiplyMod(result, N * M - 2 - i), i + 1);
    }

    result = MOD_INT.divideMod(result, 2);

    return result;
  }

  static int computePrefixSum(int limit) {
    return MOD_INT.divideMod(MOD_INT.multiplyMod(limit, limit + 1), 2);
  }
}

class ModInt {
  int modulus;

  ModInt(int modulus) {
    this.modulus = modulus;
  }

  int mod(long x) {
    return Math.floorMod(x, modulus);
  }

  int modInv(int x) {
    return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(modulus)).intValue();
  }

  int addMod(int x, int y) {
    return mod(x + y);
  }

  int multiplyMod(int x, int y) {
    return mod((long) x * y);
  }

  int divideMod(int x, int y) {
    return multiplyMod(x, modInv(y));
  }

  int powMod(int base, long exponent) {
    if (exponent == 0) {
      return 1;
    }

    return multiplyMod(
        (exponent % 2 == 0) ? 1 : base, powMod(multiplyMod(base, base), exponent / 2));
  }
}
