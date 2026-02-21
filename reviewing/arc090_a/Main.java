import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] A = new int[2][N];
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < N; ++j) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(A));

        sc.close();
    }

    static int solve(int[][] A) {
        return IntStream.range(0, A[0].length).map(i -> IntStream.rangeClosed(0, i).map(j -> A[0][j]).sum()
                + IntStream.range(i, A[0].length).map(j -> A[1][j]).sum()).max().getAsInt();
    }
}