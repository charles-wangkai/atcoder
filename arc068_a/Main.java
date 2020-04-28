import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long x = sc.nextLong();

        System.out.println(solve(x));

        sc.close();
    }

    static long solve(long x) {
        return x / 11 * 2 + (x % 11 == 0 ? 0 : (x % 11 <= 6 ? 1 : 2));
    }
}