import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();
        int[] L = new int[M];
        int[] R = new int[M];
        for (int i = 0; i < M; ++i) {
            L[i] = sc.nextInt();
            R[i] = sc.nextInt();
        }
        int[] p = new int[Q];
        int[] q = new int[Q];
        for (int i = 0; i < Q; ++i) {
            p[i] = sc.nextInt();
            q[i] = sc.nextInt();
        }

        System.out.println(solve(N, L, R, p, q));

        sc.close();
    }

    static String solve(int N, int[] L, int[] R, int[] p, int[] q) {
        @SuppressWarnings("unchecked")
        List<Integer>[] rightLists = new List[N + 1];
        for (int i = 0; i < rightLists.length; ++i) {
            rightLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < L.length; ++i) {
            rightLists[L[i]].add(R[i]);
        }

        for (int i = 0; i < rightLists.length; ++i) {
            Collections.sort(rightLists[i]);
        }

        int[] result = new int[p.length];
        for (int i = 0; i < result.length; ++i) {
            for (int j = p[i]; j <= q[i]; ++j) {
                result[i] += findTrainNum(rightLists[j], q[i]);
            }
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }

    static int findTrainNum(List<Integer> rightList, int rightLimit) {
        int result = 0;
        int lower = 0;
        int upper = rightList.size() - 1;
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (rightList.get(middle) <= rightLimit) {
                result = middle + 1;
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }

        return result;
    }
}