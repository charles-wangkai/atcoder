import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] X = new int[M];
        int[] Y = new int[M];
        int[] Z = new int[M];
        for (int i = 0; i < M; ++i) {
            X[i] = sc.nextInt() - 1;
            Y[i] = sc.nextInt() - 1;
            Z[i] = sc.nextInt();
        }

        System.out.println(solve(N, X, Y, Z));

        sc.close();
    }

    static int solve(int N, int[] X, int[] Y, int[] Z) {
        int[] parents = new int[N];
        Arrays.fill(parents, -1);

        for (int i = 0; i < X.length; ++i) {
            int rootX = findRoot(parents, X[i]);
            int rootY = findRoot(parents, Y[i]);
            if (rootX != rootY) {
                parents[rootY] = rootX;
            }
        }

        return (int) IntStream.range(0, N).map(i -> findRoot(parents, i)).distinct().count();
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