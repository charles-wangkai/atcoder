import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, K));

    sc.close();
  }

  static int solve(int[] a, int K) {
    int[] dp = new int[K + 1];
    dp[0] = 1;

    for (int ai : a) {
      int beginIndex = K - ai;
      int sum = IntStream.rangeClosed(beginIndex, K).map(i -> dp[i]).reduce(0, MOD_INT::addMod);

      for (int i = K; i >= 0; --i) {
        int temp = dp[i];
        dp[i] = sum;

        sum = MOD_INT.addMod(sum, -temp);

        if (beginIndex != 0) {
          --beginIndex;
          sum = MOD_INT.addMod(sum, dp[beginIndex]);
        }
      }
    }

    return dp[K];
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
