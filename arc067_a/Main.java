import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    int[] counts = new int[N + 1];
    for (int i = 1; i <= N; ++i) {
      int x = i;
      for (int j = 2; j < counts.length; ++j) {
        while (x % j == 0) {
          x /= j;
          ++counts[j];
        }
      }
    }

    return Arrays.stream(counts).map(x -> x + 1).reduce(MOD_INT::multiplyMod).getAsInt();
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
