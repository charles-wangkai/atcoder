import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int P = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(X, P, A, B));

    sc.close();
  }

  static int solve(int X, int P, int A, int B) {
    ModInt modInt = new ModInt(P);

    int power = modInt.powMod(X, A);
    int result = power;
    for (int i = A + 1; i <= B; ++i) {
      if (result == 1) {
        break;
      }

      power = modInt.multiplyMod(power, X);
      result = Math.min(result, power);
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
