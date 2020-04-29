import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
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

        return search(adjLists, new boolean[N], N, 0);
    }

    static int search(List<Integer>[] adjLists, boolean[] visited, int rest, int node) {
        if (rest == 1) {
            return 1;
        }

        int result = 0;
        visited[node] = true;
        for (int adj : adjLists[node]) {
            if (!visited[adj]) {
                result += search(adjLists, visited, rest - 1, adj);
            }
        }
        visited[node] = false;

        return result;
    }
}