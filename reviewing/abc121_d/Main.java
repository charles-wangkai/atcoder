import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        System.out.println(solve(A, B));

        sc.close();
    }

    static long solve(long A, long B) {
        return computeXORTo(B) ^ ((A == 0) ? 0 : computeXORTo(A - 1));
    }

    static long computeXORTo(long limit) {
        long result = 0;
        for (int i = 0;; ++i) {
            long placeValue = 1L << i;
            if (placeValue > limit) {
                break;
            }

            long count1 = 0;
            if (i == 0) {
                count1 += limit / 2;
            }
            count1 += Math.max(0, limit % (placeValue * 2) - (placeValue - 1));

            if (count1 % 2 != 0) {
                result += placeValue;
            }
        }

        return result;
    }
}