import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    char[][] a = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        a[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(char[][] a) {
    int H = a.length;
    int W = a[0].length;

    int[][] dp = new int[H][W];
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if (a[r][c] == '.') {
          if (r == 0 && c == 0) {
            dp[r][c] = 1;
          }
          if (r != 0 && a[r - 1][c] == '.') {
            dp[r][c] = MOD_INT.addMod(dp[r][c], dp[r - 1][c]);
          }
          if (c != 0 && a[r][c - 1] == '.') {
            dp[r][c] = MOD_INT.addMod(dp[r][c], dp[r][c - 1]);
          }
        }
      }
    }

    return dp[H - 1][W - 1];
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
