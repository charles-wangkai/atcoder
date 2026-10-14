import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int Y = sc.nextInt();

    System.out.println(solve(X, Y));

    sc.close();
  }

  static int solve(int X, int Y) {
    if ((X + Y) % 3 != 0) {
      return 0;
    }

    int moveNum = (X + Y) / 3;
    int xExtra = X - moveNum;
    int yExtra = Y - moveNum;
    if (xExtra < 0 || yExtra < 0) {
      return 0;
    }

    return CMod(xExtra + yExtra, xExtra);
  }

  static int CMod(int n, int r) {
    int result = 1;
    for (int i = 0; i < r; ++i) {
      result = MOD_INT.multiplyMod(result, MOD_INT.divideMod(n - i, i + 1));
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
