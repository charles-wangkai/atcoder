import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(solve(s));

        sc.close();
    }

    static String solve(String s) {
        return String.format("%c%d%c", s.charAt(0), s.length() - 2, s.charAt(s.length() - 1));
    }
}