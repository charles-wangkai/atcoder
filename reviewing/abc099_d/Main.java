import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();
        int[][] D = new int[C][C];
        for (int i = 0; i < C; ++i) {
            for (int j = 0; j < C; ++j) {
                D[i][j] = sc.nextInt();
            }
        }
        int[][] c = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                c[i][j] = sc.nextInt() - 1;
            }
        }

        System.out.println(solve(c, D));

        sc.close();
    }

    static int solve(int[][] c, int[][] D) {
        int N = c.length;
        int C = D.length;

        int[][] colorCounts = new int[3][C];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                ++colorCounts[(i + j) % 3][c[i][j]];
            }
        }

        int result = Integer.MAX_VALUE;
        int[] targetColors = new int[3];
        for (targetColors[0] = 0; targetColors[0] < C; ++targetColors[0]) {
            for (targetColors[1] = 0; targetColors[1] < C; ++targetColors[1]) {
                if (targetColors[1] != targetColors[0]) {
                    for (targetColors[2] = 0; targetColors[2] < C; ++targetColors[2]) {
                        if (targetColors[2] != targetColors[0] && targetColors[2] != targetColors[1]) {
                            int cost = 0;
                            for (int i = 0; i < 3; ++i) {
                                for (int j = 0; j < C; ++j) {
                                    cost += D[j][targetColors[i]] * colorCounts[i][j];
                                }
                            }

                            result = Math.min(result, cost);
                        }
                    }
                }
            }
        }

        return result;
    }
}