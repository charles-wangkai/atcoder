import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int X = sc.nextInt();

        System.out.println(solve(A, B, X) ? "YES" : "NO");

        sc.close();
    }

    static boolean solve(int A, int B, int X) {
        return X >= A && X <= A + B;
    }
}