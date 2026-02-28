import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    System.out.println(solve(N, M));

    sc.close();
  }

  static int solve(int N, int M) {
    int result = 1;
    List<Integer> exponents = buildExponents(M);
    for (int exponent : exponents) {
      result = MOD_INT.multiplyMod(result, computeWayNum(N, exponent));
    }

    return result;
  }

  static int computeWayNum(int N, int count) {
    int[] wayNums = new int[count + 1];
    wayNums[0] = 1;

    for (int i = 0; i < N; ++i) {
      int[] nextWayNums = new int[count + 1];
      for (int j = 0; j <= count; ++j) {
        for (int k = j; k <= count; ++k) {
          nextWayNums[k] = MOD_INT.addMod(nextWayNums[k], wayNums[j]);
        }
      }

      wayNums = nextWayNums;
    }

    return wayNums[count];
  }

  static List<Integer> buildExponents(int M) {
    List<Integer> exponents = new ArrayList<>();
    int rest = M;
    for (int i = 2; i * i <= rest; ++i) {
      int exponent = 0;
      while (rest % i == 0) {
        ++exponent;
        rest /= i;
      }

      if (exponent != 0) {
        exponents.add(exponent);
      }
    }
    if (rest != 1) {
      exponents.add(1);
    }

    return exponents;
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
