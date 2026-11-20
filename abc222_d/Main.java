import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final int LIMIT = 3000;
  static final ModInt MOD_INT = new ModInt(998_244_353);

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] a = new int[N];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[N];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }
  }

  static int solve(int[] a, int[] b) {
    int[] dp = new int[LIMIT + 1];
    Arrays.fill(dp, 1);

    for (int i = 0; i < a.length; ++i) {
      int[] nextDp = new int[dp.length];
      for (int j = a[i]; j <= b[i]; ++j) {
        nextDp[j] = dp[j];
      }

      for (int j = 1; j < nextDp.length; ++j) {
        nextDp[j] = MOD_INT.addMod(nextDp[j], nextDp[j - 1]);
      }

      dp = nextDp;
    }

    return dp[dp.length - 1];
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
