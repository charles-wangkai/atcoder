import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] A = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(A));

        sc.close();
    }

    static long solve(int[][] A) {
        int N = A.length;

        boolean[][] redundants = new boolean[N][N];

        for (int k = 0; k < N; ++k) {
            for (int i = 0; i < N; ++i) {
                for (int j = i + 1; j < N; ++j) {
                    if (k != i && k != j) {
                        if (A[i][k] + A[k][j] < A[i][j]) {
                            return -1;
                        } else if (A[i][k] + A[k][j] == A[i][j]) {
                            redundants[i][j] = true;
                        }
                    }
                }
            }
        }

        long result = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (!redundants[i][j]) {
                    result += A[i][j];
                }
            }
        }

        return result;
    }
}