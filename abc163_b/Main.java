import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[M];
        for (int i = 0; i < A.length; ++i) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(N, A));

        sc.close();
    }

    static int solve(int N, int[] A) {
        int total = Arrays.stream(A).sum();

        return (total <= N) ? (N - total) : -1;
    }
}