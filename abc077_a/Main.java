import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String c1 = sc.next();
        String c2 = sc.next();

        System.out.println(solve(c1, c2) ? "YES" : "NO");

        sc.close();
    }

    static boolean solve(String c1, String c2) {
        return c1.equals(new StringBuilder(c2).reverse().toString());
    }
}