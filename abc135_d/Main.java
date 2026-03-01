import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);
  static final int M = 13;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    int[] wayNums = new int[M];
    wayNums[0] = 1;

    for (char c : S.toCharArray()) {
      int[] nextWayNums = new int[M];

      int lower;
      int upper;
      if (c == '?') {
        lower = 0;
        upper = 9;
      } else {
        lower = c - '0';
        upper = c - '0';
      }

      for (int i = 0; i < M; ++i) {
        for (int digit = lower; digit <= upper; ++digit) {
          int remainder = (i * 10 + digit) % M;
          nextWayNums[remainder] = MOD_INT.addMod(nextWayNums[remainder], wayNums[i]);
        }
      }

      wayNums = nextWayNums;
    }

    return wayNums[5];
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
