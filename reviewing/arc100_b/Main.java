import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; ++i) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(A));

        sc.close();
    }

    static long solve(int[] A) {
        long prefixSum = 0;
        long[] prefixSums = new long[A.length];
        for (int i = 0; i < prefixSums.length; ++i) {
            prefixSum += A[i];
            prefixSums[i] = prefixSum;
        }

        long result = Long.MAX_VALUE;
        for (int middleIndex = 1; middleIndex + 2 < A.length; ++middleIndex) {
            List<long[]> leftNearestPairs = findNearestPairs(prefixSums, 0, 0, middleIndex);
            List<long[]> rightNearestPairs = findNearestPairs(prefixSums, prefixSums[middleIndex], middleIndex + 1,
                    A.length - 1);

            for (long[] leftNearestPair : leftNearestPairs) {
                for (long[] rightNearestPair : rightNearestPairs) {
                    long[] sorted = LongStream.concat(Arrays.stream(leftNearestPair), Arrays.stream(rightNearestPair))
                            .sorted().toArray();

                    result = Math.min(result, sorted[sorted.length - 1] - sorted[0]);
                }
            }
        }

        return result;
    }

    static List<long[]> findNearestPairs(long[] prefixSums, long basePrefixSum, int beginIndex, int endIndex) {
        long total = prefixSums[endIndex] - basePrefixSum;

        int leftIndex = beginIndex - 1;
        int lower = beginIndex;
        int upper = endIndex;
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            long leftSum = prefixSums[middle] - basePrefixSum;
            long rightSum = total - leftSum;

            if (leftSum <= rightSum) {
                leftIndex = middle;
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }

        List<long[]> result = new ArrayList<>();
        if (leftIndex >= beginIndex && leftIndex < endIndex) {
            long leftSum = prefixSums[leftIndex] - basePrefixSum;

            result.add(new long[] { leftSum, total - leftSum });
        }
        if (leftIndex + 1 >= beginIndex && leftIndex + 1 < endIndex) {
            long leftSum = prefixSums[leftIndex + 1] - basePrefixSum;

            result.add(new long[] { leftSum, total - leftSum });
        }

        return result;
    }
}