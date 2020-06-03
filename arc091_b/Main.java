import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solve(N, K));

        sc.close();
    }

    static long solve(int N, int K) {
        long result = 0;
        for (int b = K + 1; b <= N; ++b) {
            result += N / b * (b - K) + Math.max(0, N % b - Math.max(0, K - 1));
        }

        return result;
    }
}