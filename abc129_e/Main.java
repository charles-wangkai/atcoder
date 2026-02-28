import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String L = sc.next();

    System.out.println(solve(L));

    sc.close();
  }

  static int solve(String L) {
    int[] threePowers = new int[L.length()];
    threePowers[0] = 1;
    for (int i = 1; i < threePowers.length; ++i) {
      threePowers[i] = MOD_INT.multiplyMod(threePowers[i - 1], 3);
    }

    int result = 0;
    int factor = 1;
    for (int i = 0; i < L.length(); ++i) {
      if (L.charAt(i) == '1') {
        result =
            MOD_INT.addMod(result, MOD_INT.multiplyMod(factor, threePowers[L.length() - i - 1]));
        factor = MOD_INT.multiplyMod(factor, 2);
      }
    }
    result = MOD_INT.addMod(result, factor);

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
