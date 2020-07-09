import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solve(N, K));

        sc.close();
    }

    static double solve(int N, int K) {
        double result = 0;
        for (int i = 1; i <= N; ++i) {
            double p = 1.0 / N;
            int score = i;
            while (score < K) {
                p /= 2;
                score *= 2;
            }

            result += p;
        }

        return result;
    }
}