import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(solve(H, W, A, B));

        sc.close();
    }

    static int solve(int H, int W, int A, int B) {
        int leftWayNum = 1;

        int rightWayNum = 1;
        for (int i = 0; i < H - 1; ++i) {
            rightWayNum = multiplyMod(rightWayNum, multiplyMod(H + W - B - 2 - i, invMod(i + 1)));
        }

        int result = 0;
        for (int i = 0; i < H - A; ++i) {
            result = addMod(result, multiplyMod(leftWayNum, rightWayNum));

            leftWayNum = multiplyMod(leftWayNum, multiplyMod(B + i, invMod(i + 1)));
            rightWayNum = multiplyMod(rightWayNum, multiplyMod(H - i - 1, invMod(H + W - B - 2 - i)));
        }

        return result;
    }

    static int invMod(int x) {
        return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(MODULUS)).intValue();
    }

    static int addMod(int x, int y) {
        return (x + y) % MODULUS;
    }

    static int multiplyMod(int x, int y) {
        return (int) ((long) x * y % MODULUS);
    }
}