import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        String S = sc.next();

        System.out.println(solve(K, S));

        sc.close();
    }

    static String solve(int K, String S) {
        return (S.length() <= K) ? S : String.format("%s...", S.substring(0, K));
    }
}