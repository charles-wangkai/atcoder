import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solve(N, K));

        sc.close();
    }

    static int solve(int N, int K) {
        int[] cuts = buildCuts(N);

        List<Range> ranges = Collections.singletonList(new Range(1, N, 1, 0));
        for (int i = 0; i < K - 1; ++i) {
            int prefixSum = 0;
            List<Range> nextRanges = new ArrayList<>();
            for (int j = 0; j < cuts.length; ++j) {
                int begin = (j == 0) ? 1 : (cuts[j - 1] + 1);
                int end = cuts[j];
                int value = computePrefixSum(ranges, N / begin);
                Range nextRange = new Range(begin, end, value, prefixSum);

                nextRanges.add(nextRange);
                prefixSum = addMod(prefixSum, computeRangeValueSum(nextRange));
            }

            ranges = nextRanges;
        }

        return ranges.stream().mapToInt(Main::computeRangeValueSum).reduce(Main::addMod).getAsInt();
    }

    static int computePrefixSum(List<Range> ranges, int x) {
        int index = -1;
        int lower = 0;
        int upper = ranges.size() - 1;
        while (true) {
            int middle = (lower + upper) / 2;
            Range range = ranges.get(middle);

            if (range.begin > x) {
                upper = middle - 1;
            } else if (range.end < x) {
                lower = middle + 1;
            } else {
                index = middle;

                break;
            }
        }

        Range range = ranges.get(index);

        return addMod(range.prefixSum, multiplyMod(x - range.begin + 1, range.value));
    }

    static int[] buildCuts(int N) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= N; ++i) {
            divisors.add(i);
            divisors.add(N / i);
        }

        return divisors.stream().distinct().sorted().mapToInt(x -> x).toArray();
    }

    static int computeRangeValueSum(Range range) {
        return multiplyMod(range.end - range.begin + 1, range.value);
    }

    static int addMod(int x, int y) {
        return (x + y) % MODULUS;
    }

    static int multiplyMod(int x, int y) {
        return (int) ((long) x * y % MODULUS);
    }
}

class Range {
    int begin;
    int end;
    int value;
    int prefixSum;

    Range(int begin, int end, int value, int prefixSum) {
        this.begin = begin;
        this.end = end;
        this.value = value;
        this.prefixSum = prefixSum;
    }
}