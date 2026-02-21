import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[M];
        int[] b = new int[M];
        for (int i = 0; i < M; ++i) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        System.out.println(solve(N, a, b) ? "POSSIBLE" : "IMPOSSIBLE");

        sc.close();
    }

    static boolean solve(int N, int[] a, int[] b) {
        boolean[] firsts = new boolean[N + 1];
        boolean[] seconds = new boolean[N + 1];
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == 1) {
                firsts[b[i]] = true;
            } else if (b[i] == N) {
                seconds[a[i]] = true;
            }
        }

        return IntStream.rangeClosed(1, N).anyMatch(i -> firsts[i] && seconds[i]);
    }
}