import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(998_244_353);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int K = sc.nextInt();

    System.out.println(solve(N, M, K));

    sc.close();
  }

  static int solve(int N, int M, int K) {
    Map<Integer, Integer> dp = Map.of(0, 1);
    for (int i = 0; i < N; ++i) {
      Map<Integer, Integer> nextDp = new HashMap<>();
      for (int sum : dp.keySet()) {
        for (int value = 1; value <= M && sum + value <= K; ++value) {
          int nextSum = sum + value;
          nextDp.put(nextSum, MOD_INT.addMod(nextDp.getOrDefault(nextSum, 0), dp.get(sum)));
        }
      }

      dp = nextDp;
    }

    return dp.values().stream().reduce(0, MOD_INT::addMod);
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
