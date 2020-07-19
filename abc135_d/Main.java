import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;
    static final int M = 13;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S));

        sc.close();
    }

    static int solve(String S) {
        int[] wayNums = new int[M];
        wayNums[0] = 1;

        for (char ch : S.toCharArray()) {
            int[] nextWayNums = new int[M];

            int lower;
            int upper;
            if (ch == '?') {
                lower = 0;
                upper = 9;
            } else {
                lower = ch - '0';
                upper = ch - '0';
            }

            for (int i = 0; i < M; ++i) {
                for (int digit = lower; digit <= upper; ++digit) {
                    int remainder = (i * 10 + digit) % M;
                    nextWayNums[remainder] = addMod(nextWayNums[remainder], wayNums[i]);
                }
            }

            wayNums = nextWayNums;
        }

        return wayNums[5];
    }

    static int addMod(int x, int y) {
        return (x + y) % MODULUS;
    }
}