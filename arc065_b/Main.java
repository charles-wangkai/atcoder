import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int L = sc.nextInt();
        int[] p = new int[K];
        int[] q = new int[K];
        for (int i = 0; i < K; ++i) {
            p[i] = sc.nextInt() - 1;
            q[i] = sc.nextInt() - 1;
        }
        int[] r = new int[L];
        int[] s = new int[L];
        for (int i = 0; i < L; ++i) {
            r[i] = sc.nextInt() - 1;
            s[i] = sc.nextInt() - 1;
        }

        System.out.println(solve(N, p, q, r, s));

        sc.close();
    }

    static String solve(int N, int[] p, int[] q, int[] r, int[] s) {
        int[] roadRoots = buildRoots(N, p, q);
        int[] railwayRoots = buildRoots(N, r, s);

        Map<Element, Integer> elementToCount = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            Element element = new Element(roadRoots[i], railwayRoots[i]);

            elementToCount.put(element, elementToCount.getOrDefault(element, 0) + 1);
        }

        return IntStream.range(0, N)
                .mapToObj(i -> String.valueOf(elementToCount.get(new Element(roadRoots[i], railwayRoots[i]))))
                .collect(Collectors.joining(" "));
    }

    static int[] buildRoots(int N, int[] x, int[] y) {
        int[] parents = new int[N];
        Arrays.fill(parents, -1);

        for (int i = 0; i < x.length; ++i) {
            int root1 = findRoot(parents, x[i]);
            int root2 = findRoot(parents, y[i]);

            if (root1 != root2) {
                parents[root2] = root1;
            }
        }

        return IntStream.range(0, N).map(i -> findRoot(parents, i)).toArray();
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

class Element {
    int roadRoot;
    int railwayRoot;

    Element(int roadRoot, int railwayRoot) {
        this.roadRoot = roadRoot;
        this.railwayRoot = railwayRoot;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roadRoot, railwayRoot);
    }

    @Override
    public boolean equals(Object obj) {
        Element other = (Element) obj;

        return roadRoot == other.roadRoot && railwayRoot == other.railwayRoot;
    }
}