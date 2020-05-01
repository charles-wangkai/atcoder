import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();

        System.out.println(solve(N));

        sc.close();
    }

    static int solve(long N) {
        int result = Integer.MAX_VALUE;
        for (int i = 1; (long) i * i <= N; ++i) {
            if (N % i == 0) {
                result = Math.min(result, Math.max(computeDigitNum(i), computeDigitNum(N / i)));
            }
        }

        return result;
    }

    static int computeDigitNum(long x) {
        return String.valueOf(x).length();
    }
}