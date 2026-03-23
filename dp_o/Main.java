import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] a = new int[N][N];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        a[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[][] a) {
    int N = a.length;

    Map<Integer, Integer> dp = Map.of(0, 1);
    for (int i = 0; i < N; ++i) {
      Map<Integer, Integer> nextDp = new HashMap<>();
      for (int mask : dp.keySet()) {
        for (int j = 0; j < N; ++j) {
          if (a[i][j] == 1 && ((mask >> j) & 1) == 0) {
            int nextMask = mask + (1 << j);
            nextDp.put(nextMask, MOD_INT.addMod(nextDp.getOrDefault(nextMask, 0), dp.get(mask)));
          }
        }
      }

      dp = nextDp;
    }

    return dp.values().stream().mapToInt(Integer::intValue).reduce(0, MOD_INT::addMod);
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
