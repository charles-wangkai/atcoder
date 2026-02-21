import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; ++i) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        System.out.println(solve(x, y));

        sc.close();
    }

    static int solve(int[] x, int[] y) {
        List<Edge> edges = new ArrayList<>();

        int[] xSortedIndices = IntStream.range(0, x.length).boxed().sorted((i1, i2) -> Integer.compare(x[i1], x[i2]))
                .mapToInt(a -> a).toArray();
        for (int i = 0; i < xSortedIndices.length - 1; ++i) {
            int v1 = xSortedIndices[i];
            int v2 = xSortedIndices[i + 1];

            edges.add(new Edge(v1, v2, x[v2] - x[v1]));
        }

        int[] ySortedIndices = IntStream.range(0, x.length).boxed().sorted((i1, i2) -> Integer.compare(y[i1], y[i2]))
                .mapToInt(a -> a).toArray();
        for (int i = 0; i < ySortedIndices.length - 1; ++i) {
            int v1 = ySortedIndices[i];
            int v2 = ySortedIndices[i + 1];

            edges.add(new Edge(v1, v2, y[v2] - y[v1]));
        }

        Collections.sort(edges, (e1, e2) -> Integer.compare(e1.distance, e2.distance));

        int[] parents = new int[x.length];
        Arrays.fill(parents, -1);

        int result = 0;
        for (Edge edge : edges) {
            int root1 = findRoot(parents, edge.v1);
            int root2 = findRoot(parents, edge.v2);
            if (root1 != root2) {
                result += edge.distance;
                parents[root2] = root1;
            }
        }

        return result;
    }

    static int findRoot(int[] parents, int v) {
        int root = v;
        while (parents[root] != -1) {
            root = parents[root];
        }

        int p = v;
        while (p != root) {
            int next = parents[p];
            parents[p] = root;

            p = next;
        }

        return root;
    }
}

class Edge {
    int v1;
    int v2;
    int distance;

    Edge(int v1, int v2, int distance) {
        this.v1 = v1;
        this.v2 = v2;
        this.distance = distance;
    }
}