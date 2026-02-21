import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int C = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < B.length; ++i) {
            B[i] = sc.nextInt();
        }
        int[][] A = new int[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(A, B, C));

        sc.close();
    }

    static int solve(int[][] A, int[] B, int C) {
        return (int) Arrays.stream(A).filter(Ai -> IntStream.range(0, B.length).map(j -> Ai[j] * B[j]).sum() + C > 0)
                .count();
    }
}