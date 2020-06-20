import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a));

        sc.close();
    }

    static int solve(int[] a) {
        long mLength = a.length * (a.length + 1L) / 2;

        int result = -1;
        int lower = Arrays.stream(a).min().getAsInt();
        int upper = Arrays.stream(a).max().getAsInt();
        while (lower <= upper) {
            int middle = (lower + upper) / 2;

            if (computeNonLessNum(a, middle) >= (mLength + 1) / 2) {
                result = middle;
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }

        return result;
    }

    static long computeNonLessNum(int[] a, int pivot) {
        int prefixSum = 0;
        int[] prefixSums = new int[a.length + 1];
        for (int i = 1; i < prefixSums.length; ++i) {
            prefixSum += (a[i - 1] >= pivot) ? 1 : -1;
            prefixSums[i] = prefixSum;
        }

        return computeNonInversionNum(prefixSums, 0, prefixSums.length - 1);
    }

    static long computeNonInversionNum(int[] values, int beginIndex, int endIndex) {
        if (beginIndex == endIndex) {
            return 0;
        }

        int middleIndex = (beginIndex + endIndex) / 2;
        long result = computeNonInversionNum(values, beginIndex, middleIndex)
                + computeNonInversionNum(values, middleIndex + 1, endIndex);
        List<Integer> sorted = new ArrayList<>();
        int leftIndex = beginIndex;
        int rightIndex = middleIndex + 1;
        while (leftIndex != middleIndex + 1 || rightIndex != endIndex + 1) {
            if (rightIndex == endIndex + 1
                    || (leftIndex != middleIndex + 1 && values[leftIndex] <= values[rightIndex])) {
                result += endIndex - rightIndex + 1;

                sorted.add(values[leftIndex]);
                ++leftIndex;
            } else {
                sorted.add(values[rightIndex]);
                ++rightIndex;
            }
        }

        for (int i = beginIndex; i <= endIndex; ++i) {
            values[i] = sorted.get(i - beginIndex);
        }

        return result;
    }
}