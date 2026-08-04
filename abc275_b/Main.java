import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(998_244_353);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long A = sc.nextLong();
    long B = sc.nextLong();
    long C = sc.nextLong();
    long D = sc.nextLong();
    long E = sc.nextLong();
    long F = sc.nextLong();

    System.out.println(solve(A, B, C, D, E, F));

    sc.close();
  }

  static int solve(long A, long B, long C, long D, long E, long F) {
    return MOD_INT.addMod(
        MOD_INT.multiplyMod(MOD_INT.multiplyMod(MOD_INT.mod(A), MOD_INT.mod(B)), MOD_INT.mod(C)),
        -MOD_INT.multiplyMod(MOD_INT.multiplyMod(MOD_INT.mod(D), MOD_INT.mod(E)), MOD_INT.mod(F)));
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
