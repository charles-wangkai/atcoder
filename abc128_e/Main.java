import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] S = new int[N];
        int[] T = new int[N];
        int[] X = new int[N];
        for (int i = 0; i < N; ++i) {
            S[i] = sc.nextInt();
            T[i] = sc.nextInt();
            X[i] = sc.nextInt();
        }
        int[] D = new int[Q];
        for (int i = 0; i < D.length; ++i) {
            D[i] = sc.nextInt();
        }

        System.out.println(solve(S, T, X, D));

        sc.close();
    }

    static String solve(int[] S, int[] T, int[] X, int[] D) {
        @SuppressWarnings("unchecked")
        List<Integer>[] beginLists = new List[D.length];
        for (int i = 0; i < beginLists.length; ++i) {
            beginLists[i] = new ArrayList<>();
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] endLists = new List[D.length];
        for (int i = 0; i < endLists.length; ++i) {
            endLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < S.length; ++i) {
            int leftIndex = findLeftIndex(D, S[i] - X[i]);
            int rightIndex = findRightIndex(D, T[i] - X[i]);

            if (leftIndex <= rightIndex) {
                beginLists[leftIndex].add(X[i]);
                endLists[rightIndex].add(X[i]);
            }
        }

        int[] result = new int[D.length];
        SortedSet<Integer> blocked = new TreeSet<>();
        for (int i = 0; i < result.length; ++i) {
            blocked.addAll(beginLists[i]);

            result[i] = blocked.isEmpty() ? -1 : blocked.first();

            blocked.removeAll(endLists[i]);
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }

    static int findLeftIndex(int[] D, int start) {
        int result = D.length;
        int lower = 0;
        int upper = D.length - 1;
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (D[middle] >= start) {
                result = middle;
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }

        return result;
    }

    static int findRightIndex(int[] D, int end) {
        int result = -1;
        int lower = 0;
        int upper = D.length - 1;
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (D[middle] < end) {
                result = middle;
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }

        return result;
    }
}