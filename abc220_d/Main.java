import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final ModInt MOD_INT = new ModInt(998_244_353);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    int[] dp = new int[10];
    dp[A[0]] = 1;

    for (int i = 1; i < A.length; ++i) {
      int[] nextDp = new int[10];
      for (int prev = 0; prev < 10; ++prev) {
        for (int curr : new int[] {(prev + A[i]) % 10, prev * A[i] % 10}) {
          nextDp[curr] = MOD_INT.addMod(nextDp[curr], dp[prev]);
        }
      }

      dp = nextDp;
    }

    return Arrays.stream(dp).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
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
