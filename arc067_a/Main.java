import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static int solve(int N) {
        int[] counts = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            int x = i;
            for (int j = 2; j < counts.length; ++j) {
                while (x % j == 0) {
                    x /= j;
                    ++counts[j];
                }
            }
        }

        return Arrays.stream(counts).map(x -> x + 1).reduce((x, y) -> (int) ((long) x * y % MODULUS)).getAsInt();
    }
}