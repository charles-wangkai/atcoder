import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] S = new int[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.nextInt();
    }
    int[] T = new int[M];
    for (int i = 0; i < T.length; ++i) {
      T[i] = sc.nextInt();
    }

    System.out.println(solve(S, T));

    sc.close();
  }

  static int solve(int[] S, int[] T) {
    int[][] dp = new int[S.length + 1][T.length + 1];
    for (int i = 0; i <= S.length; ++i) {
      int matchedSum = 0;
      for (int j = 0; j <= T.length; ++j) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          if (T[j - 1] == S[i - 1]) {
            matchedSum = MOD_INT.addMod(matchedSum, dp[i - 1][j - 1]);
          }

          dp[i][j] = MOD_INT.addMod(dp[i - 1][j], matchedSum);
        }
      }
    }

    return dp[S.length][T.length];
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
