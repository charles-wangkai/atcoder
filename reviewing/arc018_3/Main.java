import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int x0 = sc.nextInt();
        int a = sc.nextInt();
        int p = sc.nextInt();

        System.out.println(solve(N, M, x0, a, p));

        sc.close();
    }

    static int solve(int N, int M, int x0, int a, int p) {
        if (a % p == 0) {
            return (x0 < p) ? 0 : (2 * (N - 1));
        }

        Map<Integer, Point> valueToPoint = new HashMap<>();
        List<Integer> values = new ArrayList<>();
        int x = x0;
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < M; ++c) {
                values.add(x);
                valueToPoint.put(x, new Point(r, c));

                x = (x + a) % p;
            }
        }

        Collections.sort(values);

        int result = 0;
        for (int r = 0; r < N; ++r) {
            List<Integer> cols = new ArrayList<>();
            for (int i = r * M; i < (r + 1) * M; ++i) {
                Point point = valueToPoint.get(values.get(i));

                result += Math.abs(point.r - r);
                cols.add(point.c);
            }

            Collections.sort(cols);
            result += IntStream.range(0, cols.size()).map(i -> Math.abs(cols.get(i) - i)).sum();
        }

        return result;
    }
}

class Point {
    int r;
    int c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}