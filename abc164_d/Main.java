import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(2019);
  static final int TEN_INV = MOD_INT.modInv(10);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static long solve(String S) {
    int period = findPeriod();

    int[][] counts = new int[period][MOD_INT.modulus];
    ++counts[0][0];

    long result = 0;
    int remainder = 0;
    for (int i = 0; i < S.length(); ++i) {
      int posInPeriod = (i + 1) % period;
      remainder = MOD_INT.addMod(MOD_INT.multiplyMod(remainder, 10), S.charAt(i) - '0');

      int targetPosInPeriod = posInPeriod;
      int targetRemainder = remainder;
      for (int j = 0; j < period; ++j) {
        result += counts[targetPosInPeriod][targetRemainder];

        targetPosInPeriod = Math.floorMod(targetPosInPeriod - 1, period);
        targetRemainder = MOD_INT.multiplyMod(targetRemainder, TEN_INV);
      }

      ++counts[posInPeriod][remainder];
    }

    return result;
  }

  static int findPeriod() {
    int result = 0;
    int power = 1;
    do {
      ++result;
      power = MOD_INT.multiplyMod(power, 10);
    } while (power != 1);

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
