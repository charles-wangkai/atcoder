import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final String TARGET = "chokudai";
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    int[] dp = new int[TARGET.length() + 1];
    dp[0] = 1;

    for (char c : S.toCharArray()) {
      for (int i = dp.length - 1; i >= 1; --i) {
        if (c == TARGET.charAt(i - 1)) {
          dp[i] = MOD_INT.addMod(dp[i], dp[i - 1]);
        }
      }
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
