import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final int DIGIT_NUM_LIMIT = 18;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long L = sc.nextLong();
    long A = sc.nextLong();
    long B = sc.nextLong();
    int M = sc.nextInt();

    System.out.println(solve(L, A, B, M));

    sc.close();
  }

  static int solve(long L, long A, long B, int M) {
    ModInt modInt = new ModInt(M);

    long[] beginIndices = new long[DIGIT_NUM_LIMIT + 1];
    long[] endIndices = new long[DIGIT_NUM_LIMIT + 1];
    for (int digitNum = 1; digitNum <= DIGIT_NUM_LIMIT; ++digitNum) {
      beginIndices[digitNum] = findBeginIndex(L, A, B, digitNum);
      endIndices[digitNum] = findEndIndex(L, A, B, digitNum);
    }

    int result = 0;
    BigInteger tenExponent = BigInteger.ZERO;
    for (int digitNum = DIGIT_NUM_LIMIT; digitNum >= 1; --digitNum) {
      if (beginIndices[digitNum] != -1) {
        long count = endIndices[digitNum] - beginIndices[digitNum] + 1;

        result =
            modInt.addMod(
                result,
                modInt.multiplyMod(
                    computePart(A, B, modInt, digitNum, beginIndices[digitNum], count),
                    BigInteger.TEN.modPow(tenExponent, BigInteger.valueOf(M)).intValue()));

        tenExponent =
            tenExponent.add(BigInteger.valueOf(digitNum).multiply(BigInteger.valueOf(count)));
      }
    }

    return result;
  }

  static int computePart(long A, long B, ModInt modInt, int digitNum, long beginIndex, long count) {
    int[][] transition = {
      {modInt.powMod(10, digitNum), 0, 0},
      {1, 1, 0},
      {0, modInt.mod(B), 1}
    };

    int[] initial = {0, modInt.mod(A + B * beginIndex), 1};

    return multiply(initial, pow(transition, count, modInt), modInt)[0];
  }

  static int[] multiply(int[] v, int[][] m, ModInt modInt) {
    int size = m.length;

    int[] result = new int[size];
    for (int i = 0; i < result.length; ++i) {
      for (int j = 0; j < size; ++j) {
        result[i] = modInt.addMod(result[i], modInt.multiplyMod(v[j], m[j][i]));
      }
    }

    return result;
  }

  static int[][] multiply(int[][] m1, int[][] m2, ModInt modInt) {
    int size = m1.length;

    int[][] result = new int[size][size];
    for (int i = 0; i < size; ++i) {
      for (int j = 0; j < size; ++j) {
        for (int k = 0; k < size; ++k) {
          result[i][j] = modInt.addMod(result[i][j], modInt.multiplyMod(m1[i][k], m2[k][j]));
        }
      }
    }

    return result;
  }

  static int[][] pow(int[][] m, long exponent, ModInt modInt) {
    int size = m.length;

    int[][] entity = new int[size][size];
    for (int i = 0; i < size; ++i) {
      entity[i][i] = 1;
    }

    if (exponent == 0) {
      return entity;
    }

    return multiply(
        (exponent % 2 == 0) ? entity : m,
        pow(multiply(m, m, modInt), exponent / 2, modInt),
        modInt);
  }

  static long findBeginIndex(long L, long A, long B, int digitNum) {
    long result = -1;
    long lower = 0;
    long upper = L - 1;
    while (lower <= upper) {
      long middle = (lower + upper) / 2;
      String s = String.valueOf(A + B * middle);

      if (s.length() >= digitNum) {
        if (s.length() == digitNum) {
          result = middle;
        }

        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static long findEndIndex(long L, long A, long B, int digitNum) {
    long result = -1;
    long lower = 0;
    long upper = L - 1;
    while (lower <= upper) {
      long middle = (lower + upper) / 2;
      String s = String.valueOf(A + B * middle);

      if (s.length() <= digitNum) {
        if (s.length() == digitNum) {
          result = middle;
        }

        lower = middle + 1;
      } else {
        upper = middle - 1;
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
