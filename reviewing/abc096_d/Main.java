import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static String solve(int N) {
        int[] result = new int[N];
        int x = 6;
        for (int i = 0; i < result.length; ++i) {
            while (!isPrime(x)) {
                x += 5;
            }

            result[i] = x;
            x += 5;
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}