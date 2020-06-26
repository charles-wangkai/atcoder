import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solve(H, W, K));

        sc.close();
    }

    static int solve(int H, int W, int K) {
        int[] wayNums = new int[W];
        wayNums[0] = 1;

        for (int i = 0; i < H; ++i) {
            int[] nextWayNums = new int[wayNums.length];
            for (int code = 0; code < 1 << (W - 1); ++code) {
                if (isValid(code)) {
                    for (int pos = 0; pos < W; ++pos) {
                        int nextPos = computeNextPos(pos, code);

                        nextWayNums[nextPos] = addMod(nextWayNums[nextPos], wayNums[pos]);
                    }
                }
            }

            wayNums = nextWayNums;
        }

        return wayNums[K - 1];
    }

    static int addMod(int x, int y) {
        return (x + y) % MODULUS;
    }

    static boolean isValid(int code) {
        return !Integer.toBinaryString(code).contains("11");
    }

    static int computeNextPos(int pos, int code) {
        if ((code & (1 << pos)) != 0) {
            return pos + 1;
        } else if (pos != 0 && (code & (1 << (pos - 1))) != 0) {
            return pos - 1;
        } else {
            return pos;
        }
    }
}