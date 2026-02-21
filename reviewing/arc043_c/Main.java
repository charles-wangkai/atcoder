// https://en.wikipedia.org/wiki/Fenwick_tree

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = readArray(sc, N);
        int[] B = readArray(sc, N);

        System.out.println(solve(A, B));

        sc.close();
    }

    static int[] readArray(Scanner sc, int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = sc.nextInt();
        }

        return result;
    }

    static String solve(int[] A, int[] B) {
        Map<Integer, Integer> valueToIndexA = buildValueToIndex(A);

        int[] leftReversedCounts = new int[B.length];
        int[] BIT = new int[B.length + 1];
        for (int i = 0; i < B.length; ++i) {
            int target = valueToIndexA.get(B[i]) + 1;

            leftReversedCounts[i] = i - computePrefixSum(BIT, target);
            modify(BIT, target, 1);
        }

        long reversedCount = Arrays.stream(leftReversedCounts).asLongStream().sum();
        if (reversedCount % 2 != 0) {
            return "-1";
        }

        long needed = reversedCount / 2;
        Map<Integer, Integer> valueToIndexB = buildValueToIndex(B);
        int[] C = new int[B.length];
        int index = 0;
        Set<Integer> used = new HashSet<>();
        while (true) {
            int bIndex = valueToIndexB.get(A[index]);
            if (leftReversedCounts[bIndex] >= needed) {
                break;
            }

            C[index] = A[index];
            used.add(C[index]);
            needed -= leftReversedCounts[bIndex];
            ++index;
        }

        int currentValue = A[index];

        for (int i = 0; i < B.length; ++i) {
            if (!used.contains(B[i])) {
                C[index] = B[i];
                ++index;
            }
        }

        int currentIndex = 0;
        while (C[currentIndex] != currentValue) {
            ++currentIndex;
        }

        while (needed != 0) {
            int temp = C[currentIndex];
            C[currentIndex] = C[currentIndex - 1];
            C[currentIndex - 1] = temp;

            --currentIndex;
            --needed;
        }

        return Arrays.stream(C).mapToObj(String::valueOf).collect(Collectors.joining(" "));

    }

    static Map<Integer, Integer> buildValueToIndex(int[] values) {
        return IntStream.range(0, values.length).boxed().collect(Collectors.toMap(i -> values[i], Function.identity()));
    }

    static int computePrefixSum(int[] BIT, int i) {
        int result = 0;
        while (i != 0) {
            result += BIT[i];
            i -= Integer.lowestOneBit(i);
        }

        return result;
    }

    static void modify(int[] BIT, int i, int delta) {
        while (i < BIT.length) {
            BIT[i] += delta;
            i += Integer.lowestOneBit(i);
        }
    }
}