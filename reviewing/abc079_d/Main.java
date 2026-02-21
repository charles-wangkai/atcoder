import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int[][] c = new int[10][10];
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                c[i][j] = sc.nextInt();
            }
        }
        int[][] A = new int[H][W];
        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < W; ++j) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(A, c));

        sc.close();
    }

    static int solve(int[][] A, int[][] c) {
        int H = A.length;
        int W = A[0].length;

        for (int k = 0; k < 10; ++k) {
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < 10; ++j) {
                    c[i][j] = Math.min(c[i][j], c[i][k] + c[k][j]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < W; ++j) {
                if (A[i][j] != -1) {
                    result += c[A[i][j]][1];
                }
            }
        }

        return result;
    }
}