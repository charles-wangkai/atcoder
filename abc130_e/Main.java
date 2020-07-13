import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] S = new int[N];
        for (int i = 0; i < S.length; ++i) {
            S[i] = sc.nextInt();
        }
        int[] T = new int[M];
        for (int i = 0; i < T.length; ++i) {
            T[i] = sc.nextInt();
        }

        System.out.println(solve(S, T));

        sc.close();
    }

    static int solve(int[] S, int[] T) {
        int[][] wayNums = new int[S.length + 1][T.length + 1];
        for (int i = 0; i <= S.length; ++i) {
            int matchedSum = 0;
            for (int j = 0; j <= T.length; ++j) {
                if (i == 0 || j == 0) {
                    wayNums[i][j] = 1;
                } else {
                    if (T[j - 1] == S[i - 1]) {
                        matchedSum = addMod(matchedSum, wayNums[i - 1][j - 1]);
                    }

                    wayNums[i][j] = addMod(wayNums[i - 1][j], matchedSum);
                }
            }
        }

        return wayNums[S.length][T.length];
    }

    static int addMod(int x, int y) {
        return (x + y) % MODULUS;
    }
}