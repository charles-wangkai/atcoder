import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  static Map<Long, Integer> cache = new HashMap<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  // http://oeis.org/A007729
  static int solve(long N) {
    if (N <= 1) {
      return (int) N + 1;
    }

    if (!cache.containsKey(N)) {
      int result;
      if (N % 2 == 0) {
        result = MOD_INT.addMod(MOD_INT.multiplyMod(solve(N / 2 - 1), 2), solve(N / 2));
      } else {
        result = MOD_INT.addMod(MOD_INT.multiplyMod(solve(N / 2), 2), solve(N / 2 - 1));
      }

      cache.put(N, result);
    }

    return cache.get(N);
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
