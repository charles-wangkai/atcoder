import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int betweenNum = 0;
    static int onlyWhiteNum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] a = new int[N - 1];
        int[] b = new int[N - 1];
        for (int i = 0; i < N - 1; ++i) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
        }

        System.out.println(solve(a, b));

        sc.close();
    }

    static String solve(int[] a, int[] b) {
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

        Boolean[] colors = new Boolean[N];
        colors[0] = true;
        colors[N - 1] = false;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(N - 1);

        int blackCount = 0;
        int whiteCount = 0;
        while (!queue.isEmpty()) {
            int head = queue.poll();

            if (colors[head]) {
                ++blackCount;
            } else {
                ++whiteCount;
            }

            for (int adj : adjLists[head]) {
                if (colors[adj] == null) {
                    colors[adj] = colors[head];
                    queue.offer(adj);
                }
            }
        }

        return (blackCount > whiteCount) ? "Fennec" : "Snuke";
    }
}