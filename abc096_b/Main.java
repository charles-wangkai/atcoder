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
        return A + B + C + Math.max(Math.max(A, B), C) * ((1 << K) - 1);
    }
}