import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][][] F = new int[N][5][2];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < 5; ++j) {
                for (int k = 0; k < 2; ++k) {
                    F[i][j][k] = sc.nextInt();
                }
            }
        }
        int[][] P = new int[N][11];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < 11; ++j) {
                P[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(F, P));

        sc.close();
    }

    static int solve(int[][][] F, int[][] P) {
        int N = F.length;

        int result = Integer.MIN_VALUE;
        for (int code = 1; code < (1 << 10); ++code) {
            int profit = 0;
            for (int i = 0; i < N; ++i) {
                int c = 0;
                for (int j = 0; j < 10; ++j) {
                    if (F[i][j / 2][j % 2] == 1 && (code & (1 << j)) != 0) {
                        ++c;
                    }
                }

                profit += P[i][c];
            }

            result = Math.max(result, profit);
        }

        return result;
    }
}