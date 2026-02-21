import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] p = new int[N];
        for (int i = 0; i < p.length; ++i) {
            p[i] = sc.nextInt() - 1;
        }
        int[] x = new int[M];
        int[] y = new int[M];
        for (int i = 0; i < M; ++i) {
            x[i] = sc.nextInt() - 1;
            y[i] = sc.nextInt() - 1;
        }

        System.out.println(solve(p, x, y));

        sc.close();
    }

    static int solve(int[] p, int[] x, int[] y) {
        int N = p.length;

        int[] parents = new int[N];
        Arrays.fill(parents, -1);

        for (int i = 0; i < x.length; ++i) {
            int rootX = findRoot(parents, x[i]);
            int rootY = findRoot(parents, y[i]);

            if (rootX != rootY) {
                parents[rootY] = rootX;
            }
        }

        Map<Integer, Set<Integer>> rootToIndices = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            int root = findRoot(parents, i);
            if (!rootToIndices.containsKey(root)) {
                rootToIndices.put(root, new HashSet<>());
            }

            rootToIndices.get(root).add(i);
        }

        return rootToIndices.values().stream()
                .mapToInt(indices -> (int) indices.stream().filter(index -> indices.contains(p[index])).count()).sum();
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