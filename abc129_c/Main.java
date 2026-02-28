import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] a = new int[M];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(N, a));

    sc.close();
  }

  static int solve(int N, int[] a) {
    int[] dp = new int[N + 1];
    dp[0] = 1;

    boolean[] brokens = new boolean[N + 1];
    for (int ai : a) {
      brokens[ai] = true;
    }

    for (int i = 0; i < dp.length; ++i) {
      for (int j = 1; j <= 2; ++j) {
        if (i + j < dp.length && !brokens[i + j]) {
          dp[i + j] = MOD_INT.addMod(dp[i + j], dp[i]);
        }
      }
    }

    return dp[N];
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
