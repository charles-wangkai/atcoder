import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(998_244_353);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(long N) {
    int result = 0;
    BigInteger lower = BigInteger.ONE;
    while (lower.compareTo(BigInteger.valueOf(N)) <= 0) {
      BigInteger upper =
          lower.multiply(BigInteger.TEN).subtract(BigInteger.ONE).min(BigInteger.valueOf(N));

      result =
          MOD_INT.addMod(
              result, computeArithmeticSequenceSum(upper.subtract(lower).longValue() + 1));

      lower = lower.multiply(BigInteger.TEN);
    }

    return result;
  }

  static int computeArithmeticSequenceSum(long length) {
    return BigInteger.valueOf(length)
        .multiply(BigInteger.valueOf(length + 1))
        .divide(BigInteger.TWO)
        .mod(BigInteger.valueOf(MOD_INT.modulus))
        .intValue();
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
