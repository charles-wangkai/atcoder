import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);
  static final char[] ALPHABET = {'A', 'C', 'G', 'T'};
  static final Set<String> EXCLUDED_PATTERNS = Set.of("AGC", "GAC", "ACG", "AGGC", "ATGC", "AGTC");

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    Map<String, Integer> patternToWayNum = new HashMap<>();
    patternToWayNum.put("", 1);

    for (int i = 0; i < N; ++i) {
      Map<String, Integer> nextPatternToWayNum = new HashMap<>();
      for (String pattern : patternToWayNum.keySet()) {
        for (char letter : ALPHABET) {
          String nextPattern = pattern + letter;
          if (nextPattern.length() > 4) {
            nextPattern = nextPattern.substring(nextPattern.length() - 4);
          }
          String nextLastThreePattern =
              (nextPattern.length() == 4) ? nextPattern.substring(1) : nextPattern;

          if (!EXCLUDED_PATTERNS.contains(nextPattern)
              && !EXCLUDED_PATTERNS.contains(nextLastThreePattern)) {
            nextPatternToWayNum.put(
                nextPattern,
                MOD_INT.addMod(
                    nextPatternToWayNum.getOrDefault(nextPattern, 0),
                    patternToWayNum.get(pattern)));
          }
        }
      }

      patternToWayNum = nextPatternToWayNum;
    }

    return patternToWayNum.values().stream()
        .mapToInt(Integer::intValue)
        .reduce(MOD_INT::addMod)
        .getAsInt();
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
