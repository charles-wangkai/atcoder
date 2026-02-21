import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] u = new int[M];
        int[] v = new int[M];
        for (int i = 0; i < M; ++i) {
            u[i] = sc.nextInt() - 1;
            v[i] = sc.nextInt() - 1;
        }
        int S = sc.nextInt() - 1;
        int T = sc.nextInt() - 1;

        System.out.println(solve(N, u, v, S, T));

        sc.close();
    }

    static int solve(int N, int[] u, int[] v, int S, int T) {
        @SuppressWarnings("unchecked")
        List<Integer>[] adjLists = new List[N];
        for (int i = 0; i < adjLists.length; ++i) {
            adjLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < u.length; ++i) {
            adjLists[u[i]].add(v[i]);
        }

        int[][] distances = new int[N][3];
        for (int i = 0; i < distances.length; ++i) {
            Arrays.fill(distances[i], -1);
        }
        distances[S][0] = 0;

        Queue<Element> queue = new LinkedList<>();
        queue.offer(new Element(S, 0));

        while (!queue.isEmpty()) {
            Element head = queue.poll();
            if (head.node == T && head.seq == 0) {
                return distances[T][0];
            }

            int nextSeq = (head.seq + 1) % 3;
            int nextDistance = distances[head.node][head.seq] + ((nextSeq == 0) ? 1 : 0);
            for (int adj : adjLists[head.node]) {
                if (distances[adj][nextSeq] == -1) {
                    distances[adj][nextSeq] = nextDistance;
                    queue.offer(new Element(adj, nextSeq));
                }
            }
        }

        return -1;
    }
}

class Element {
    int node;
    int seq;

    Element(int node, int seq) {
        this.node = node;
        this.seq = seq;
    }
}