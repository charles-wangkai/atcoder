import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt();
        int Q = sc.nextInt();
        int R = sc.nextInt();

        System.out.println(solve(P, Q, R));

        sc.close();
    }

    static int solve(int P, int Q, int R) {
        return P + Q + R - Math.max(Math.max(P, Q), R);
    }
}