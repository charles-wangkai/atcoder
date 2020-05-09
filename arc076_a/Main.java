import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        System.out.println(solve(N, M));

        sc.close();
    }

    static int solve(int N, int M) {
        if (Math.abs(N - M) >= 2) {
            return 0;
        }

        return multiplyMod(multiplyMod(factorial(N), factorial(M)), (N == M) ? 2 : 1);
    }

    static int multiplyMod(int x, int y) {
        return (int) ((long) x * y % MODULUS);
    }

    static int factorial(int x) {
        return IntStream.rangeClosed(1, x).reduce(Main::multiplyMod).getAsInt();
    }
}