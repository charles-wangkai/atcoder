import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    System.out.println(solve(N, K));

    sc.close();
  }

  static int solve(int N, int K) {
    int[] cuts = buildCuts(N);

    List<Range> ranges = List.of(new Range(1, N, 1, 0));
    for (int i = 0; i < K - 1; ++i) {
      int prefixSum = 0;
      List<Range> nextRanges = new ArrayList<>();
      for (int j = 0; j < cuts.length; ++j) {
        int begin = (j == 0) ? 1 : (cuts[j - 1] + 1);
        int end = cuts[j];
        int value = computePrefixSum(ranges, N / begin);
        Range nextRange = new Range(begin, end, value, prefixSum);

        nextRanges.add(nextRange);
        prefixSum = MOD_INT.addMod(prefixSum, computeRangeValueSum(nextRange));
      }

      ranges = nextRanges;
    }

    return ranges.stream().mapToInt(Main::computeRangeValueSum).reduce(MOD_INT::addMod).getAsInt();
  }

  static int computePrefixSum(List<Range> ranges, int x) {
    int index = -1;
    int lower = 0;
    int upper = ranges.size() - 1;
    while (true) {
      int middle = (lower + upper) / 2;
      Range range = ranges.get(middle);

      if (range.begin() > x) {
        upper = middle - 1;
      } else if (range.end() < x) {
        lower = middle + 1;
      } else {
        index = middle;

        break;
      }
    }

    Range range = ranges.get(index);

    return MOD_INT.addMod(
        range.prefixSum(), MOD_INT.multiplyMod(x - range.begin() + 1, range.value()));
  }

  static int[] buildCuts(int N) {
    List<Integer> divisors = new ArrayList<>();
    for (int i = 1; i * i <= N; ++i) {
      divisors.add(i);
      divisors.add(N / i);
    }

    return divisors.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
  }

  static int computeRangeValueSum(Range range) {
    return MOD_INT.multiplyMod(range.end() - range.begin() + 1, range.value());
  }
}

record Range(int begin, int end, int value, int prefixSum) {}

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
