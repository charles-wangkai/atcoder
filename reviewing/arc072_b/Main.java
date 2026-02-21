import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long X = sc.nextLong();
        long Y = sc.nextLong();

        System.out.println(solve(X, Y));

        sc.close();
    }

    static String solve(long X, long Y) {
        return Math.abs(X - Y) <= 1 ? "Brown" : "Alice";
    }
}