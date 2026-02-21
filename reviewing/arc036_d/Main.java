import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] w = new int[Q];
        int[] x = new int[Q];
        int[] y = new int[Q];
        int[] z = new int[Q];
        for (int i = 0; i < Q; ++i) {
            w[i] = sc.nextInt();
            x[i] = sc.nextInt() - 1;
            y[i] = sc.nextInt() - 1;
            z[i] = sc.nextInt();
        }

        System.out.println(solve(N, w, x, y, z));

        sc.close();
    }

    static String solve(int N, int[] w, int[] x, int[] y, int[] z) {
        List<String> result = new ArrayList<>();

        int[] parents = new int[N];
        Arrays.fill(parents, -1);

        int[] opposites = new int[N];
        Arrays.fill(opposites, -1);

        for (int i = 0; i < w.length; ++i) {
            int rootX = findRoot(parents, x[i]);
            int rootY = findRoot(parents, y[i]);

            if (w[i] == 1) {
                if (z[i] % 2 == 0) {
                    union(parents, opposites, x[i], y[i]);
                } else {
                    union(parents, opposites, opposites[rootX], y[i]);
                    opposites[rootX] = y[i];

                    union(parents, opposites, x[i], opposites[rootY]);
                    opposites[rootY] = x[i];
                }
            } else {
                result.add((rootX == rootY) ? "YES" : "NO");
            }
        }

        return String.join("\n", result);
    }

    static void union(int[] parents, int[] opposites, int node1, int node2) {
        if (node1 == -1 || node2 == -1) {
            return;
        }

        int root1 = findRoot(parents, node1);
        int root2 = findRoot(parents, node2);
        if (root1 == root2) {
            return;
        }

        parents[root2] = root1;

        union(parents, opposites, opposites[root1], opposites[root2]);
        if (opposites[root1] != -1) {
            opposites[root2] = opposites[root1];
        }
        if (opposites[root2] != -1) {
            opposites[root1] = opposites[root2];
        }
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