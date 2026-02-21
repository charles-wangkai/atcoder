import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] T = new long[N];
        for (int i = 0; i < T.length; ++i) {
            T[i] = sc.nextLong();
        }

        System.out.println(solve(T));

        sc.close();
    }

    static long solve(long[] T) {
        return Arrays.stream(T).reduce(Main::lcm).getAsLong();
    }

    static long lcm(long x, long y) {
        return x / gcd(x, y) * y;
    }

    static long gcd(long x, long y) {
        return (y == 0) ? x : gcd(y, x % y);
    }
}