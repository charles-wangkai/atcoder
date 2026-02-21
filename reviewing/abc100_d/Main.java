import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static final int[] FACTORS = { -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] x = new long[N];
        long[] y = new long[N];
        long[] z = new long[N];
        for (int i = 0; i < N; ++i) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
            z[i] = sc.nextLong();
        }

        System.out.println(solve(x, y, z, M));

        sc.close();
    }

    static long solve(long[] x, long[] y, long[] z, int M) {
        long result = Long.MIN_VALUE;
        for (int factorX : FACTORS) {
            for (int factorY : FACTORS) {
                for (int factorZ : FACTORS) {
                    result = Math.max(result,
                            IntStream.range(0, x.length)
                                    .mapToLong(i -> x[i] * factorX + y[i] * factorY + z[i] * factorZ).sorted()
                                    .skip(x.length - M).sum());
                }
            }
        }

        return result;
    }
}