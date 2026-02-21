import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int time = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[M];
        int[] b = new int[M];
        for (int i = 0; i < M; ++i) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
        }

        System.out.println(solve(N, a, b));

        sc.close();
    }

    static int solve(int N, int[] a, int[] b) {
        @SuppressWarnings("unchecked")
        List<Integer>[] adjLists = new List[N];
        for (int i = 0; i < adjLists.length; ++i) {
            adjLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < a.length; ++i) {
            adjLists[a[i]].add(b[i]);
            adjLists[b[i]].add(a[i]);
        }

        int[] ins = new int[N];
        int[] minIns = new int[N];

        return search(adjLists, ins, minIns, 0, -1);
    }

    static int search(List<Integer>[] adjLists, int[] ins, int[] minIns, int node, int parent) {
        ins[node] = time;
        minIns[node] = time;
        ++time;

        int result = 0;
        for (int adj : adjLists[node]) {
            if (adj == parent) {
                continue;
            }

            if (ins[adj] == 0) {
                result += search(adjLists, ins, minIns, adj, node);
            }

            if (minIns[adj] > ins[node]) {
                ++result;
            }

            minIns[node] = Math.min(minIns[node], minIns[adj]);
        }

        return result;
    }
}