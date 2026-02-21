import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        System.out.println(solve(N, M));

        sc.close();
    }

    static long solve(int N, int M) {
        if (N > M) {
            return solve(M, N);
        }

        if (N == 1) {
            if (M == 1) {
                return 1;
            } else {
                return M - 2;
            }
        }

        return (N - 2L) * (M - 2);
    }
}