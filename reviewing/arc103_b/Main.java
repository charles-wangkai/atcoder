import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static final char[] DIRECTIONS = { 'L', 'R', 'D', 'U' };
    static final int[] X_OFFSETS = { -1, 1, 0, 0 };
    static final int[] Y_OFFSETS = { 0, 0, -1, 1 };
    static final int REGULATION_MOVE = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] X = new int[N];
        int[] Y = new int[N];
        for (int i = 0; i < N; ++i) {
            X[i] = sc.nextInt();
            Y[i] = sc.nextInt();
        }

        System.out.println(solve(X, Y));

        sc.close();
    }

    static String solve(int[] X, int[] Y) {
        if (IntStream.range(0, X.length).map(i -> Math.abs((X[i] + Y[i]) % 2)).distinct().count() != 1) {
            return "-1";
        }

        boolean regulationNeeded = (X[0] + Y[0]) % 2 == 0;

        if (regulationNeeded) {
            for (int i = 0; i < X.length; ++i) {
                X[i] -= X_OFFSETS[REGULATION_MOVE];
                Y[i] -= Y_OFFSETS[REGULATION_MOVE];
            }
        }

        int[] d = IntStream.range(0, 31).map(i -> 1 << i).toArray();

        String[] w = new String[X.length];
        for (int i = 0; i < w.length; ++i) {
            int x = X[i];
            int y = Y[i];
            char[] path = new char[d.length];
            for (int j = path.length - 1; j >= 0; --j) {
                for (int k = 0;; ++k) {
                    int nextX = x - X_OFFSETS[k] * d[j];
                    int nextY = y - Y_OFFSETS[k] * d[j];

                    if ((long) Math.abs(nextX) + Math.abs(nextY) <= (1 << j) - 1) {
                        x = nextX;
                        y = nextY;
                        path[j] = DIRECTIONS[k];

                        break;
                    }
                }
            }

            w[i] = new String(path);
        }

        if (regulationNeeded) {
            d = Arrays.copyOf(d, d.length + 1);
            d[d.length - 1] = 1;

            for (int i = 0; i < w.length; ++i) {
                w[i] += DIRECTIONS[REGULATION_MOVE];
            }
        }

        return String.format("%d\n%s\n%s", d.length,
                Arrays.stream(d).mapToObj(String::valueOf).collect(Collectors.joining(" ")), String.join("\n", w));
    }
}