import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();

        System.out.println(solve(H, W));

        sc.close();
    }

    static int solve(int H, int W) {
        if (H % 3 == 0 || W % 3 == 0) {
            return 0;
        }

        return Math.min(cut1(H, W), cut1(W, H));
    }

    static int cut1(int side1, int side2) {
        long result = Long.MAX_VALUE;
        for (int s1 : new int[] { side1 / 3, side1 / 3 + 1 }) {
            for (long[] restAreas : new long[][] { cut2(side1 - s1, side2), cut2(side2, side1 - s1) }) {
                long[] areas = LongStream.concat(LongStream.of((long) s1 * side2), Arrays.stream(restAreas)).sorted()
                        .toArray();

                result = Math.min(result, areas[2] - areas[0]);
            }
        }

        return (int) result;
    }

    static long[] cut2(int side1, int side2) {
        return new long[] { side1 / 2L * side2, (long) side1 * side2 - side1 / 2L * side2 };
    }
}