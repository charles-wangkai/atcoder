import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }
    int[] y = new int[m];
    for (int i = 0; i < y.length; ++i) {
      y[i] = sc.nextInt();
    }

    System.out.println(solve(x, y));

    sc.close();
  }

  static int solve(int[] x, int[] y) {
    return MOD_INT.multiplyMod(computeSideSum(x), computeSideSum(y));
  }

  static int computeSideSum(int[] values) {
    int result = 0;
    int prefixSum = values[0];
    for (int i = 1; i < values.length; ++i) {
      result =
          MOD_INT.addMod(result, MOD_INT.addMod(MOD_INT.multiplyMod(values[i], i), -prefixSum));

      prefixSum = MOD_INT.addMod(prefixSum, values[i]);
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
