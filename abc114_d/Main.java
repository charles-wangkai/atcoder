import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static int solve(int N) {
        int[] primes = IntStream.rangeClosed(2, N).filter(Main::isPrime).toArray();
        int[] counts = new int[primes.length];

        for (int i = 1; i <= N; ++i) {
            int rest = i;
            for (int j = 0; j < primes.length; ++j) {
                while (rest % primes[j] == 0) {
                    rest /= primes[j];
                    ++counts[j];
                }
            }
        }

        return search(counts, 0, 75);
    }

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    static int search(int[] counts, int index, int rest) {
        if (index == counts.length) {
            return (rest == 1) ? 1 : 0;
        }

        int result = 0;
        for (int i = 0; i <= counts[index]; ++i) {
            if (rest % (i + 1) == 0) {
                result += search(counts, index + 1, rest / (i + 1));
            }
        }

        return result;
    }
}