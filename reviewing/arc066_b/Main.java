import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    static Map<Long, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();

        System.out.println(solve(N));

        sc.close();
    }

    // http://oeis.org/A007729
    static int solve(long N) {
        if (N <= 1) {
            return (int) N + 1;
        }

        if (cache.containsKey(N)) {
            return cache.get(N);
        }

        int result;
        if (N % 2 == 0) {
            result = addMod(multiplyMod(solve(N / 2 - 1), 2), solve(N / 2));
        } else {
            result = addMod(multiplyMod(solve(N / 2), 2), solve(N / 2 - 1));
        }
        cache.put(N, result);

        return result;
    }

    static int addMod(int x, int y) {
        return (x + y) % MODULUS;
    }

    static int multiplyMod(int x, int y) {
        return (int) ((long) x * y % MODULUS);
    }
}