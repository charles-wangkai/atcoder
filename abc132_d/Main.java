import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solve(N, K));

        sc.close();
    }

    static String solve(int N, int K) {
        int[][] wayNums = new int[N + 2][N + 1];
        wayNums[0][0] = 1;
        for (int i = 1; i <= N + 1; ++i) {
            wayNums[i][0] = wayNums[i - 1][0];
            for (int j = 1; j <= N; ++j) {
                wayNums[i][j] = addMod(wayNums[i][j - 1], wayNums[i - 1][j]);
            }
        }

        int[] result = new int[K];
        for (int i = 0; i < result.length; ++i) {
            result[i] = multiplyMod(getWayNum(wayNums, i + 1, K - (i + 1)), getWayNum(wayNums, i + 2, N - K - i));
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }

    static int getWayNum(int[][] wayNums, int partNum, int sum) {
        return (sum < 0) ? 0 : wayNums[partNum][sum];
    }

    static int addMod(int x, int y) {
        return (x + y) % MODULUS;
    }

    static int multiplyMod(int x, int y) {
        return (int) ((long) x * y % MODULUS);
    }
}