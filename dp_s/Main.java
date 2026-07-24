import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String K = sc.next();
    int D = sc.nextInt();

    System.out.println(solve(K, D));

    sc.close();
  }

  static int solve(String K, int D) {
    int[] digits = K.chars().map(c -> c - '0').toArray();

    Map<State, Integer> dp = Map.of(new State(true, 0), 1);
    for (int digit : digits) {
      Map<State, Integer> nextDp = new HashMap<>();
      for (State state : dp.keySet()) {
        for (int d = 0; d <= (state.strict() ? digit : 9); ++d) {
          State nextState = new State(state.strict() && d == digit, (state.digitSum() + d) % D);

          nextDp.put(nextState, MOD_INT.addMod(nextDp.getOrDefault(nextState, 0), dp.get(state)));
        }
      }

      dp = nextDp;
    }

    return MOD_INT.addMod(
        dp.keySet().stream()
            .filter(state -> state.digitSum() == 0)
            .mapToInt(dp::get)
            .reduce(0, MOD_INT::addMod),
        -1);
  }
}

record State(boolean strict, int digitSum) {}

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
