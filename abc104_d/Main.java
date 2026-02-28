import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);
  static String TARGET = "ABC";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    int wildCount = (int) S.chars().filter(c -> c == '?').count();
    int[] threePowers = new int[wildCount + 1];
    threePowers[0] = 1;
    for (int i = 1; i < threePowers.length; ++i) {
      threePowers[i] = MOD_INT.multiplyMod(threePowers[i - 1], 3);
    }

    int result = 0;
    Map<String, Integer> subToCount = new HashMap<>();
    subToCount.put("", 1);
    for (char c : S.toCharArray()) {
      Map<String, Integer> nextSubToCount = new HashMap<>();

      for (String sub : subToCount.keySet()) {
        if (sub.length() <= 2) {
          nextSubToCount.put(
              sub, MOD_INT.addMod(nextSubToCount.getOrDefault(sub, 0), subToCount.get(sub)));

          String nextSub = String.format("%s%c", sub, c);
          if (check(nextSub)) {
            nextSubToCount.put(
                nextSub,
                MOD_INT.addMod(nextSubToCount.getOrDefault(nextSub, 0), subToCount.get(sub)));
          }
        }
      }

      for (String nextSub : nextSubToCount.keySet()) {
        if (nextSub.length() == 3) {
          result =
              MOD_INT.addMod(
                  result,
                  MOD_INT.multiplyMod(
                      nextSubToCount.get(nextSub),
                      threePowers[
                          wildCount - (int) nextSub.chars().filter(x -> x == '?').count()]));
        }
      }

      subToCount = nextSubToCount;
    }

    return result;
  }

  static boolean check(String sub) {
    return IntStream.range(0, sub.length())
        .allMatch(i -> sub.charAt(i) == '?' || sub.charAt(i) == TARGET.charAt(i));
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
