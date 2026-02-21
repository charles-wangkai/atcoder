import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] t = readArray(sc, N);
        int[] v = readArray(sc, N);

        System.out.println(solve(t, v));

        sc.close();
    }

    static int[] readArray(Scanner sc, int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = sc.nextInt();
        }

        return result;
    }

    static double solve(int[] t, int[] v) {
        int N = t.length;

        int leftMax = 0;
        int[] leftMaxs = new int[N - 1];
        for (int i = 0; i < leftMaxs.length; ++i) {
            leftMax = Math.min(Math.min(leftMax + t[i], v[i]), v[i + 1]);
            leftMaxs[i] = leftMax;
        }

        int rightMax = 0;
        int[] rightMaxs = new int[N - 1];
        for (int i = rightMaxs.length - 1; i >= 0; --i) {
            rightMax = Math.min(Math.min(rightMax + t[i + 1], v[i + 1]), v[i]);
            rightMaxs[i] = rightMax;
        }

        int[] maxs = IntStream.range(0, N - 1).map(i -> Math.min(leftMaxs[i], rightMaxs[i])).toArray();

        return IntStream.range(0, N)
                .mapToDouble(
                        i -> computeMaxDistance(t[i], v[i], (i == 0) ? 0 : maxs[i - 1], (i == N - 1) ? 0 : maxs[i]))
                .sum();
    }

    static double computeMaxDistance(int time, int limitV, int v1, int v2) {
        double maxV;
        if ((limitV - v1) + (limitV - v2) <= time) {
            maxV = limitV;
        } else {
            maxV = (time + v1 + v2) / 2.0;
        }

        return (v1 + maxV) * (maxV - v1) / 2 + maxV * (time - (maxV - v1) - (maxV - v2))
                + (maxV + v2) * (maxV - v2) / 2;
    }
}