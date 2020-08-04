import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solve(A, B, C, K));

        sc.close();
    }

    static int solve(int A, int B, int C, int K) {
        int result = 0;

        int posCount = Math.min(A, K);
        result += posCount;
        K -= posCount;

        int zeroCount = Math.min(B, K);
        K -= zeroCount;

        result -= K;

        return result;
    }
}