import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] a = new int[N - 1];
        int[] b = new int[N - 1];
        for (int i = 0; i < N - 1; ++i) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
        }

        System.out.println(solve(a, b, K));

        sc.close();
    }

    static int solve(int[] a, int[] b, int K) {
        int N = a.length + 1;

        @SuppressWarnings("unchecked")
        List<Integer>[] adjLists = new List[N];
        for (int i = 0; i < adjLists.length; ++i) {
            adjLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < a.length; ++i) {
            adjLists[a[i]].add(b[i]);
            adjLists[b[i]].add(a[i]);
        }

        return search(K, adjLists, new boolean[N], 0, false, 0);
    }

    static int search(int K, List<Integer>[] adjLists, boolean[] visited, int excludeNum, boolean hasGrandParent,
            int node) {
        visited[node] = true;

        int result = Math.max(0, K - excludeNum);
        int nextExcludeNum = 1 + (hasGrandParent ? 1 : 0);
        for (int adj : adjLists[node]) {
            if (!visited[adj]) {
                result = multiplyMod(result, search(K, adjLists, visited, nextExcludeNum, true, adj));

                ++nextExcludeNum;
            }
        }

        return result;
    }

    static int multiplyMod(int x, int y) {
        return (int) ((long) x * y % MODULUS);
    }
}