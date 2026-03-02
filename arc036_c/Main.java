import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int K = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, K));

    sc.close();
  }

  static int solve(String S, int K) {
    int[][] dp = new int[K + 1][K + 1];
    dp[0][0] = 1;

    for (char c : S.toCharArray()) {
      int[][] nextDp = new int[K + 1][K + 1];

      for (int i = 0; i <= K; ++i) {
        for (int j = 0; j <= K; ++j) {
          if ((c == '0' || c == '?') && i + 1 <= K) {
            int nextI = i + 1;
            int nextJ = Math.max(0, j - 1);

            nextDp[nextI][nextJ] = MOD_INT.addMod(nextDp[nextI][nextJ], dp[i][j]);
          }

          if ((c == '1' || c == '?') && j + 1 <= K) {
            int nextI = Math.max(0, i - 1);
            int nextJ = j + 1;

            nextDp[nextI][nextJ] = MOD_INT.addMod(nextDp[nextI][nextJ], dp[i][j]);
          }
        }
      }

      dp = nextDp;
    }

    int result = 0;
    for (int i = 0; i <= K; ++i) {
      for (int j = 0; j <= K; ++j) {
        result = MOD_INT.addMod(result, dp[i][j]);
      }
    }

    return result;
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
