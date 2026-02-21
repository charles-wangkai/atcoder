import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        System.out.println(solve(N, K, X, Y));

        sc.close();
    }

    static int solve(int N, int K, int X, int Y) {
        return Math.min(N, K) * X + Math.max(0, N - K) * Y;
    }
}