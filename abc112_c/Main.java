import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        int[] h = new int[N];
        for (int i = 0; i < N; ++i) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }

        System.out.println(solve(x, y, h));

        sc.close();
    }

    static String solve(int[] x, int[] y, int[] h) {
        int nonZeroHeightIndex = IntStream.range(0, h.length).filter(i -> h[i] != 0).findAny().orElse(-1);

        for (int cx = 0;; ++cx) {
            for (int cy = 0; cy <= 100; ++cy) {
                int height = (nonZeroHeightIndex == -1) ? 1
                        : Math.abs(x[nonZeroHeightIndex] - cx) + Math.abs(y[nonZeroHeightIndex] - cy)
                                + h[nonZeroHeightIndex];
                if (check(x, y, h, cx, cy, height)) {
                    return String.format("%d %d %d", cx, cy, height);
                }
            }
        }
    }

    static boolean check(int[] x, int[] y, int[] h, int cx, int cy, int height) {
        return IntStream.range(0, x.length)
                .allMatch(i -> Math.max(height - Math.abs(x[i] - cx) - Math.abs(y[i] - cy), 0) == h[i]);
    }
}