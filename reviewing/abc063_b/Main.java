import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S) ? "yes" : "no");

        sc.close();
    }

    static boolean solve(String S) {
        return S.chars().distinct().count() == S.length();
    }
}