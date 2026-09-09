import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(998_244_353);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    int[] dp = new int[10];
    for (int d = 1; d <= 9; ++d) {
      dp[d] = 1;
    }

    for (int i = 0; i < N - 1; ++i) {
      int[] nextDp = new int[10];
      for (int d = 1; d <= 9; ++d) {
        for (int delta = -1; delta <= 1; ++delta) {
          int prevD = d - delta;
          if (prevD >= 1 && prevD <= 9) {
            nextDp[d] = MOD_INT.addMod(nextDp[d], dp[prevD]);
          }
        }
      }

      dp = nextDp;
    }

    return Arrays.stream(dp).reduce(0, MOD_INT::addMod);
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
