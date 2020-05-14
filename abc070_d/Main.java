import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] a = new int[N - 1];
        int[] b = new int[N - 1];
        int[] c = new int[N - 1];
        for (int i = 0; i < N - 1; ++i) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
            c[i] = sc.nextInt();
        }
        int Q = sc.nextInt();
        int K = sc.nextInt() - 1;
        int[] x = new int[Q];
        int[] y = new int[Q];
        for (int i = 0; i < Q; ++i) {
            x[i] = sc.nextInt() - 1;
            y[i] = sc.nextInt() - 1;
        }

        System.out.println(solve(a, b, c, x, y, K));

        sc.close();
    }

    static String solve(int[] a, int[] b, int[] c, int[] x, int[] y, int K) {
        int N = a.length + 1;

        @SuppressWarnings("unchecked")
        List<Integer>[] edgeLists = new List[N];
        for (int i = 0; i < edgeLists.length; ++i) {
            edgeLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < a.length; ++i) {
            edgeLists[a[i]].add(i);
            edgeLists[b[i]].add(i);
        }

        long[] distances = new long[N];
        Arrays.fill(distances, -1);
        search(distances, edgeLists, a, b, c, K, 0);

        return IntStream.range(0, x.length).mapToObj(i -> String.valueOf(distances[x[i]] + distances[y[i]]))
                .collect(Collectors.joining("\n"));
    }

    static void search(long[] distances, List<Integer>[] edgeLists, int[] a, int[] b, int[] c, int v, long distance) {
        distances[v] = distance;

        for (int edge : edgeLists[v]) {
            int adj = (a[edge] == v) ? b[edge] : a[edge];
            if (distances[adj] == -1) {
                search(distances, edgeLists, a, b, c, adj, distance + c[edge]);
            }
        }
    }
}