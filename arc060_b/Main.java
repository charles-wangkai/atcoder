import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long s = sc.nextLong();

        System.out.println(solve(n, s));

        sc.close();
    }

    static long solve(long n, long s) {
        long result = (s == n) ? (n + 1) : Long.MAX_VALUE;

        if (n > s) {
            long product = n - s;
            for (int f1 = 1; (long) f1 * f1 <= product; ++f1) {
                if (check(n, s, f1 + 1)) {
                    result = Math.min(result, f1 + 1);
                }

                long f2 = product / f1;
                if (check(n, s, f2 + 1)) {
                    result = Math.min(result, f2 + 1);
                }
            }
        }

        for (int i = 2; (long) i * i <= n; ++i) {
            if (check(n, s, i)) {
                result = Math.min(result, i);
            }
        }

        return (result == Long.MAX_VALUE) ? -1 : result;
    }

    static boolean check(long n, long s, long base) {
        long digitSum = 0;
        while (n != 0) {
            digitSum += n % base;
            n /= base;
        }

        return digitSum == s;
    }
}