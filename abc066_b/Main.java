import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S));

        sc.close();
    }

    static int solve(String S) {
        for (int length = (S.length() - 1) / 2 * 2;; length -= 2) {
            if (isEven(S.substring(0, length))) {
                return length;
            }
        }
    }

    static boolean isEven(String s) {
        return s.endsWith(s.substring(0, s.length() / 2));
    }
}