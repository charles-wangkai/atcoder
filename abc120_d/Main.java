import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[M];
        int[] B = new int[M];
        for (int i = 0; i < M; ++i) {
            A[i] = sc.nextInt() - 1;
            B[i] = sc.nextInt() - 1;
        }

        System.out.println(solve(N, A, B));

        sc.close();
    }

    static String solve(int N, int[] A, int[] B) {
        int[] parents = new int[N];
        Arrays.fill(parents, -1);

        int[] sizes = new int[N];
        Arrays.fill(sizes, 1);

        long[] result = new long[A.length];
        long pairNum = N * (N - 1L) / 2;
        for (int i = result.length - 1; i >= 0; --i) {
            result[i] = pairNum;

            int rootA = findRoot(parents, A[i]);
            int rootB = findRoot(parents, B[i]);
            if (rootA != rootB) {
                pairNum -= (long) sizes[rootA] * sizes[rootB];

                parents[rootB] = rootA;
                sizes[rootA] += sizes[rootB];
            }
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }

    static int findRoot(int[] parents, int node) {
        int root = node;
        while (parents[root] != -1) {
            root = parents[root];
        }

        int p = node;
        while (p != root) {
            int next = parents[p];
            parents[p] = root;

            p = next;
        }

        return root;
    }
}