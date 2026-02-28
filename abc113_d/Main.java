import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int K = sc.nextInt();

    System.out.println(solve(H, W, K));

    sc.close();
  }

  static int solve(int H, int W, int K) {
    int[] wayNums = new int[W];
    wayNums[0] = 1;

    for (int i = 0; i < H; ++i) {
      int[] nextWayNums = new int[wayNums.length];
      for (int mask = 0; mask < 1 << (W - 1); ++mask) {
        if (!Integer.toBinaryString(mask).contains("11")) {
          for (int pos = 0; pos < W; ++pos) {
            int nextPos = computeNextPos(pos, mask);

            nextWayNums[nextPos] = MOD_INT.addMod(nextWayNums[nextPos], wayNums[pos]);
          }
        }
      }

      wayNums = nextWayNums;
    }

    return wayNums[K - 1];
  }

  static int computeNextPos(int pos, int mask) {
    if (((mask >> pos) & 1) == 1) {
      return pos + 1;
    }
    if (pos != 0 && ((mask >> (pos - 1)) & 1) == 1) {
      return pos - 1;
    }

    return pos;
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
