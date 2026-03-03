import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S1 = sc.next();
    String S2 = sc.next();

    System.out.println(solve(S1, S2));

    sc.close();
  }

  static int solve(String S1, String S2) {
    int result = 1;
    int index = 0;
    int prevLength = 0;
    while (index != S1.length()) {
      int factor;
      if (index + 1 != S1.length() && S1.charAt(index) == S1.charAt(index + 1)) {
        if (prevLength == 0) {
          factor = 6;
        } else if (prevLength == 1) {
          factor = 2;
        } else {
          factor = 3;
        }

        prevLength = 2;
      } else {
        if (prevLength == 0) {
          factor = 3;
        } else if (prevLength == 1) {
          factor = 2;
        } else {
          factor = 1;
        }

        prevLength = 1;
      }

      result = MOD_INT.multiplyMod(result, factor);
      index += prevLength;
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
