import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] u = new int[N - 1];
        int[] v = new int[N - 1];
        int[] w = new int[N - 1];
        for (int i = 0; i < N - 1; ++i) {
            u[i] = sc.nextInt() - 1;
            v[i] = sc.nextInt() - 1;
            w[i] = sc.nextInt();
        }

        System.out.println(solve(u, v, w));

        sc.close();
    }

    static String solve(int[] u, int[] v, int[] w) {
        int N = u.length + 1;

        @SuppressWarnings("unchecked")
        List<Integer>[] edgeList = new List[N];
        for (int i = 0; i < edgeList.length; ++i) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; ++i) {
            edgeList[u[i]].add(i);
            edgeList[v[i]].add(i);
        }

        int[] colors = new int[N];
        Arrays.fill(colors, -1);

        search(colors, u, v, w, edgeList, 0, 0);

        return Arrays.stream(colors).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }

    static void search(int[] colors, int[] u, int[] v, int[] w, List<Integer>[] edgeList, int node, long distance) {
        colors[node] = (int) (distance % 2);

        for (int edge : edgeList[node]) {
            int adj = (u[edge] == node) ? v[edge] : u[edge];
            if (colors[adj] == -1) {
                search(colors, u, v, w, edgeList, adj, distance + w[edge]);
            }
        }
    }
}