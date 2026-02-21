import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solve(N, K));

        sc.close();
    }

    static int solve(int N, int K) {
        return (N % K == 0) ? 0 : 1;
    }
}