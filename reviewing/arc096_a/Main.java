import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        System.out.println(solve(A, B, C, X, Y));

        sc.close();
    }

    static int solve(int A, int B, int C, int X, int Y) {
        return Math.min(A + B, C * 2) * Math.min(X, Y) + Math.min(A, C * 2) * Math.max(0, X - Math.min(X, Y))
                + Math.min(B, C * 2) * Math.max(0, Y - Math.min(X, Y));
    }
}