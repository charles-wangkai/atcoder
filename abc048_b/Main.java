import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        long x = sc.nextLong();

        System.out.println(solve(a, b, x));

        sc.close();
    }

    static long solve(long a, long b, long x) {
        return b / x - (a + x - 1) / x + 1;
    }
}