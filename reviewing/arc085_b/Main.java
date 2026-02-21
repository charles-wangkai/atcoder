import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Z = sc.nextInt();
        int W = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a, Z, W));

        sc.close();
    }

    static int solve(int[] a, int Z, int W) {
        int N = a.length;

        int[] xScores = new int[N];
        int[] yScores = new int[N];
        for (int i = N - 1; i >= 0; --i) {
            xScores[i] = Integer.MIN_VALUE;
            for (int j = i; j < N; ++j) {
                int score;
                if (j == N - 1) {
                    score = Math.abs(a[N - 1] - ((i == 0) ? W : a[i - 1]));
                } else {
                    score = yScores[j + 1];
                }

                xScores[i] = Math.max(xScores[i], score);
            }

            yScores[i] = Integer.MAX_VALUE;
            for (int j = i; j < N; ++j) {
                int score;
                if (j == N - 1) {
                    score = Math.abs(a[N - 1] - ((i == 0) ? Z : a[i - 1]));
                } else {
                    score = xScores[j + 1];
                }

                yScores[i] = Math.min(yScores[i], score);
            }
        }

        return xScores[0];
    }
}