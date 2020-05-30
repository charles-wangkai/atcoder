import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        char[] c = new char[N];
        for (int i = 0; i < N; ++i) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            c[i] = sc.next().charAt(0);
        }

        System.out.println(solve(x, y, c, K));

        sc.close();
    }

    static int solve(int[] x, int[] y, char[] c, int K) {
        int[][] blackNums = new int[2 * K][2 * K];
        for (int i = 0; i < x.length; ++i) {
            if (c[i] == 'W') {
                y[i] += K;
            }

            ++blackNums[x[i] % (2 * K)][y[i] % (2 * K)];
        }

        int[][] prefixSums = new int[2 * K + 1][2 * K + 1];
        for (int i = 1; i <= 2 * K; ++i) {
            for (int j = 1; j <= 2 * K; ++j) {
                prefixSums[i][j] = prefixSums[i - 1][j] + prefixSums[i][j - 1] - prefixSums[i - 1][j - 1]
                        + blackNums[i - 1][j - 1];
            }
        }

        int result = 0;
        for (int minX = 0; minX <= K; ++minX) {
            for (int minY = 0; minY <= K; ++minY) {
                result = Math.max(result,
                        Math.max(
                                computeRectangleSum(prefixSums, minX, minY, minX + K - 1, minY + K - 1)
                                        + computeRectangleSum(prefixSums, 0, 0, minX - 1, minY - 1)
                                        + computeRectangleSum(prefixSums, minX + K, 0, 2 * K - 1, minY - 1)
                                        + computeRectangleSum(prefixSums, 0, minY + K, minX - 1, 2 * K - 1)
                                        + computeRectangleSum(prefixSums, minX + K, minY + K, 2 * K - 1, 2 * K - 1),
                                computeRectangleSum(prefixSums, 0, minY, minX - 1, minY + K - 1)
                                        + computeRectangleSum(prefixSums, minX + K, minY, 2 * K - 1, minY + K - 1)
                                        + computeRectangleSum(prefixSums, minX, 0, minX + K - 1, minY - 1)
                                        + computeRectangleSum(prefixSums, minX, minY + K, minX + K - 1, 2 * K - 1)));
            }
        }

        return result;
    }

    static int computeRectangleSum(int[][] prefixSums, int lowerX, int lowerY, int upperX, int upperY) {
        if (lowerX > upperX || lowerY > upperY) {
            return 0;
        }

        return prefixSums[upperX + 1][upperY + 1] - prefixSums[lowerX][upperY + 1] - prefixSums[upperX + 1][lowerY]
                + prefixSums[lowerX][lowerY];
    }
}