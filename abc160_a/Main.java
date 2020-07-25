import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(String S) {
        return S.charAt(2) == S.charAt(3) && S.charAt(4) == S.charAt(5);
    }
}