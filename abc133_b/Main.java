import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int D = sc.nextInt();
        int[][] X = new int[N][D];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < D; ++j) {
                X[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(X));

        sc.close();
    }

    static int solve(int[][] X) {
        int result = 0;
        for (int i = 0; i < X.length; ++i) {
            for (int j = i + 1; j < X.length; ++j) {
                int distanceSquare = computeDistanceSquare(X[i], X[j]);
                int distance = (int) Math.round(Math.sqrt(distanceSquare));
                if (distance * distance == distanceSquare) {
                    ++result;
                }
            }
        }

        return result;
    }

    static int computeDistanceSquare(int[] v1, int[] v2) {
        return IntStream.range(0, v1.length).map(i -> (v1[i] - v2[i]) * (v1[i] - v2[i])).sum();
    }
}