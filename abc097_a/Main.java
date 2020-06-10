import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(solve(a, b, c, d) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int a, int b, int c, int d) {
        return Math.abs(a - c) <= d || (Math.abs(a - b) <= d && Math.abs(c - b) <= d);
    }
}