import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] A = new int[N][];
        for (int i = 0; i < A.length; ++i) {
            int K = sc.nextInt();
            A[i] = new int[K];
            for (int j = 0; j < A[i].length; ++j) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(A, M));

        sc.close();
    }

    static int solve(int[][] A, int M) {
        int[] counts = new int[M];
        for (int[] Ai : A) {
            for (int Aij : Ai) {
                ++counts[Aij - 1];
            }
        }

        return (int) Arrays.stream(counts).filter(count -> count == A.length).count();
    }
}