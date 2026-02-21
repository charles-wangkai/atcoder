import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] a = new int[N - 1];
        int[] b = new int[N - 1];
        int[] c = new int[N - 1];
        int[] d = new int[N - 1];
        for (int i = 0; i < N - 1; ++i) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        int[] x = new int[Q];
        int[] y = new int[Q];
        int[] u = new int[Q];
        int[] v = new int[Q];
        for (int i = 0; i < Q; ++i) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            u[i] = sc.nextInt() - 1;
            v[i] = sc.nextInt() - 1;
        }

        System.out.println(solve(a, b, c, d, x, y, u, v));

        sc.close();
    }

    static String solve(int[] a, int[] b, int[] c, int[] d, int[] x, int[] y, int[] u, int[] v) {
        int N = a.length + 1;
        int Q = x.length;

        int[][] ancestors = new int[N][Integer.toBinaryString(N).length()];
        for (int i = 0; i < ancestors.length; ++i) {
            Arrays.fill(ancestors[i], -1);
        }

        int[] depths = new int[N];
        Arrays.fill(depths, -1);

        @SuppressWarnings("unchecked")
        List<Integer>[] edgeLists = new List[N];
        for (int i = 0; i < edgeLists.length; ++i) {
            edgeLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < a.length; ++i) {
            edgeLists[a[i]].add(i);
            edgeLists[b[i]].add(i);
        }

        buildTree(a, b, edgeLists, ancestors, depths, 0, -1, 0);

        int[] LCAs = new int[Q];
        for (int i = 0; i < LCAs.length; ++i) {
            LCAs[i] = findLCA(ancestors, depths, u[i], v[i]);
        }

        Map<Integer, Set<Integer>> nodeToQueryIndices = new HashMap<>();
        for (int i = 0; i < Q; ++i) {
            for (int node : new int[] { u[i], v[i], LCAs[i] }) {
                if (!nodeToQueryIndices.containsKey(node)) {
                    nodeToQueryIndices.put(node, new HashSet<>());
                }

                nodeToQueryIndices.get(node).add(i);
            }
        }

        int[] queryResults = new int[Q];
        search(queryResults, a, b, c, d, x, y, u, v, edgeLists, depths, LCAs, nodeToQueryIndices, 0, new HashMap<>(),
                new HashMap<>(), 0);

        return Arrays.stream(queryResults).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }

    static void search(int[] queryResults, int[] a, int[] b, int[] c, int[] d, int[] x, int[] y, int[] u, int[] v,
            List<Integer>[] edgeLists, int[] depths, int[] LCAs, Map<Integer, Set<Integer>> nodeToQueryIndices,
            int distance, Map<Integer, Integer> colorToCount, Map<Integer, Integer> colorToDistance, int node) {
        for (int queryIndex : nodeToQueryIndices.getOrDefault(node, Collections.emptySet())) {
            int delta = distance - colorToDistance.getOrDefault(x[queryIndex], 0)
                    + colorToCount.getOrDefault(x[queryIndex], 0) * y[queryIndex];

            if (u[queryIndex] == node) {
                queryResults[queryIndex] += delta;
            }
            if (v[queryIndex] == node) {
                queryResults[queryIndex] += delta;
            }
            if (LCAs[queryIndex] == node) {
                queryResults[queryIndex] -= delta * 2;
            }
        }

        for (int edge : edgeLists[node]) {
            int adj = (node == a[edge]) ? b[edge] : a[edge];
            if (depths[adj] == depths[node] + 1) {
                colorToCount.put(c[edge], colorToCount.getOrDefault(c[edge], 0) + 1);
                colorToDistance.put(c[edge], colorToDistance.getOrDefault(c[edge], 0) + d[edge]);

                search(queryResults, a, b, c, d, x, y, u, v, edgeLists, depths, LCAs, nodeToQueryIndices,
                        distance + d[edge], colorToCount, colorToDistance, adj);

                colorToCount.put(c[edge], colorToCount.get(c[edge]) - 1);
                colorToDistance.put(c[edge], colorToDistance.get(c[edge]) - d[edge]);
            }
        }
    }

    static int findLCA(int[][] ancestors, int[] depths, int u, int v) {
        if (depths[u] < depths[v]) {
            return findLCA(ancestors, depths, v, u);
        }

        for (int i = ancestors[u].length - 1; i >= 0; --i) {
            if (ancestors[u][i] != -1 && depths[ancestors[u][i]] >= depths[v]) {
                u = ancestors[u][i];
            }
        }

        if (u == v) {
            return v;
        }

        for (int i = ancestors[u].length - 1; i >= 0; --i) {
            if (ancestors[u][i] != ancestors[v][i]) {
                u = ancestors[u][i];
                v = ancestors[v][i];
            }
        }

        return ancestors[u][0];
    }

    static void buildTree(int[] a, int[] b, List<Integer>[] edgeLists, int[][] ancestors, int[] depths, int depth,
            int parent, int node) {
        depths[node] = depth;

        ancestors[node][0] = parent;
        for (int i = 1; i < ancestors[node].length; ++i) {
            if (ancestors[node][i - 1] != -1) {
                ancestors[node][i] = ancestors[ancestors[node][i - 1]][i - 1];
            }
        }

        for (int edge : edgeLists[node]) {
            int adj = (node == a[edge]) ? b[edge] : a[edge];
            if (depths[adj] == -1) {
                buildTree(a, b, edgeLists, ancestors, depths, depth + 1, node, adj);
            }
        }
    }
}