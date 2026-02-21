import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int N) {
        String s = String.valueOf(N);

        return s.charAt(1) == s.charAt(2) && (s.charAt(0) == s.charAt(1) || s.charAt(2) == s.charAt(3));
    }
}