import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(H, W, A, B));

    sc.close();
  }

  static int solve(int H, int W, int A, int B) {
    int leftWayNum = 1;

    int rightWayNum = 1;
    for (int i = 0; i < H - 1; ++i) {
      rightWayNum =
          MOD_INT.multiplyMod(
              rightWayNum, MOD_INT.multiplyMod(H + W - B - 2 - i, MOD_INT.modInv(i + 1)));
    }

    int result = 0;
    for (int i = 0; i < H - A; ++i) {
      result = MOD_INT.addMod(result, MOD_INT.multiplyMod(leftWayNum, rightWayNum));

      leftWayNum =
          MOD_INT.multiplyMod(leftWayNum, MOD_INT.multiplyMod(B + i, MOD_INT.modInv(i + 1)));
      rightWayNum =
          MOD_INT.multiplyMod(
              rightWayNum, MOD_INT.multiplyMod(H - i - 1, MOD_INT.modInv(H + W - B - 2 - i)));
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
