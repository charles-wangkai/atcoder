import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();
        String C = sc.next();

        System.out.println(solve(A, B, C) ? "YES" : "NO");

        sc.close();
    }

    static boolean solve(String A, String B, String C) {
        return A.charAt(A.length() - 1) == B.charAt(0) && B.charAt(B.length() - 1) == C.charAt(0);
    }
}