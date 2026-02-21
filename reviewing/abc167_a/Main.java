import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        String T = sc.next();

        System.out.println(solve(S, T) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(String S, String T) {
        return T.startsWith(S);
    }
}