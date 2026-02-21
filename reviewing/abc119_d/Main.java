import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int Q = sc.nextInt();
        long[] s = readArray(sc, A);
        long[] t = readArray(sc, B);
        long[] x = readArray(sc, Q);

        System.out.println(solve(s, t, x));

        sc.close();
    }

    static long[] readArray(Scanner sc, int size) {
        long[] result = new long[size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = sc.nextLong();
        }

        return result;
    }

    static String solve(long[] s, long[] t, long[] x) {
        return IntStream.range(0, x.length)
                .mapToObj(i -> String.valueOf(Math.min(computeMinDistance(s, t, x[i]), computeMinDistance(t, s, x[i]))))
                .collect(Collectors.joining("\n"));
    }

    static long computeMinDistance(long[] values1, long[] values2, long start) {
        long result = Long.MAX_VALUE;
        for (Direction direction1 : Direction.values()) {
            long end1 = find(values1, start, direction1);
            if (end1 != -1) {
                for (Direction direction2 : Direction.values()) {
                    long end2 = find(values2, end1, direction2);
                    if (end2 != -1) {
                        result = Math.min(result, Math.abs(end1 - start) + Math.abs(end2 - end1));
                    }
                }
            }
        }

        return result;
    }

    static long find(long[] values, long current, Direction direction) {
        long result = -1;
        int lower = 0;
        int upper = values.length - 1;
        while (lower <= upper) {
            int middle = (lower + upper) / 2;

            if (direction == Direction.LEFT) {
                if (values[middle] < current) {
                    result = values[middle];
                    lower = middle + 1;
                } else {
                    upper = middle - 1;
                }
            } else {
                if (values[middle] > current) {
                    result = values[middle];
                    upper = middle - 1;
                } else {
                    lower = middle + 1;
                }
            }
        }

        return result;
    }
}

enum Direction {
    LEFT, RIGHT;
}