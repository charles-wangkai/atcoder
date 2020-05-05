import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[M];
        int[] b = new int[M];
        int[] c = new int[M];
        for (int i = 0; i < M; ++i) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
            c[i] = sc.nextInt();
        }

        System.out.println(solve(N, a, b, c));

        sc.close();
    }

    static String solve(int N, int[] a, int[] b, int[] c) {
        long[] distances = new long[N];
        Arrays.fill(distances, Long.MIN_VALUE);
        distances[0] = 0;

        for (int round = 0; round < N - 1; ++round) {
            for (int i = 0; i < a.length; ++i) {
                if (distances[a[i]] != Long.MIN_VALUE) {
                    distances[b[i]] = Math.max(distances[b[i]], distances[a[i]] + c[i]);
                }
            }
        }

        boolean[] infinites = new boolean[N];
        for (int i = 0; i < a.length; ++i) {
            if (distances[a[i]] != Long.MIN_VALUE && distances[a[i]] + c[i] > distances[b[i]]) {
                infinites[b[i]] = true;
            }
        }

        for (int round = 0; round < N - 1; ++round) {
            for (int i = 0; i < a.length; ++i) {
                if (infinites[a[i]]) {
                    infinites[b[i]] = true;
                }
            }
        }

        return infinites[N - 1] ? "inf" : String.valueOf(distances[N - 1]);
    }
}