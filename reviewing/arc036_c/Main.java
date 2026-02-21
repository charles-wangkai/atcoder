import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        int K = sc.nextInt();
        String S = sc.next();

        System.out.println(solve(S, K));

        sc.close();
    }

    static int solve(String S, int K) {
        int[][] wayNums = new int[K + 1][K + 1];
        wayNums[0][0] = 1;

        for (char ch : S.toCharArray()) {
            int[][] nextWayNums = new int[K + 1][K + 1];

            for (int i = 0; i <= K; ++i) {
                for (int j = 0; j <= K; ++j) {
                    if ((ch == '0' || ch == '?') && i + 1 <= K) {
                        int nextI = i + 1;
                        int nextJ = Math.max(0, j - 1);

                        nextWayNums[nextI][nextJ] = addMod(nextWayNums[nextI][nextJ], wayNums[i][j]);
                    }

                    if ((ch == '1' || ch == '?') && j + 1 <= K) {
                        int nextI = Math.max(0, i - 1);
                        int nextJ = j + 1;

                        nextWayNums[nextI][nextJ] = addMod(nextWayNums[nextI][nextJ], wayNums[i][j]);
                    }
                }
            }

            wayNums = nextWayNums;
        }

        int result = 0;
        for (int i = 0; i <= K; ++i) {
            for (int j = 0; j <= K; ++j) {
                result = addMod(result, wayNums[i][j]);
            }
        }

        return result;
    }

    static int addMod(int x, int y) {
        return (x + y) % MODULUS;
    }
}