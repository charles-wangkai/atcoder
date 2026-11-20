import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      long K = sc.nextLong();
      int[][] a = new int[N][N];
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          a[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(a, K));
    }
  }

  static int solve(int[][] a, long K) {
    int N = a.length;

    return Arrays.stream(multiplyVM(IntStream.range(0, N).map(i -> 1).toArray(), pow(a, K)))
        .reduce(0, MOD_INT::addMod);
  }

  static int[][] pow(int[][] base, long exponent) {
    int N = base.length;

    if (exponent == 0) {
      return buildEntity(N);
    }

    return multiplyMM(
        (exponent % 2 == 0) ? buildEntity(N) : base, pow(multiplyMM(base, base), exponent / 2));
  }

  static int[][] buildEntity(int N) {
    int[][] result = new int[N][N];
    for (int i = 0; i < N; ++i) {
      result[i][i] = 1;
    }

    return result;
  }

  static int[][] multiplyMM(int[][] m1, int[][] m2) {
    int N = m1.length;

    int[][] result = new int[N][N];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        for (int k = 0; k < N; ++k) {
          result[i][j] = MOD_INT.addMod(result[i][j], MOD_INT.multiplyMod(m1[i][k], m2[k][j]));
        }
      }
    }

    return result;
  }

  static int[] multiplyVM(int[] v, int[][] m) {
    int N = v.length;

    int[] result = new int[N];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        result[i] = MOD_INT.addMod(result[i], MOD_INT.multiplyMod(v[j], m[j][i]));
      }
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
