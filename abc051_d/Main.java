import java.util.Scanner;
import java.util.stream.IntStream;

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

    static int solve(int N, int[] a, int[] b, int[] c) {
        int[][] distances = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                distances[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < a.length; ++i) {
            distances[a[i]][b[i]] = c[i];
            distances[b[i]][a[i]] = c[i];
        }

        for (int k = 0; k < N; ++k) {
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE) {
                        distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                    }
                }
            }
        }

        return (int) IntStream.range(0, a.length).filter(i -> c[i] > distances[a[i]][b[i]]).count();
    }
}