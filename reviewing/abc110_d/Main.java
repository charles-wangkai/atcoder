import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        System.out.println(solve(N, M));

        sc.close();
    }

    static int solve(int N, int M) {
        int result = 1;
        List<Integer> exponents = buildExponents(M);
        for (int exponent : exponents) {
            result = multiplyMod(result, computeWayNum(N, exponent));
        }

        return result;
    }

    static int computeWayNum(int N, int count) {
        int[] wayNums = new int[count + 1];
        wayNums[0] = 1;

        for (int i = 0; i < N; ++i) {
            int[] nextWayNums = new int[count + 1];
            for (int j = 0; j <= count; ++j) {
                for (int k = j; k <= count; ++k) {
                    nextWayNums[k] = addMod(nextWayNums[k], wayNums[j]);
                }
            }

            wayNums = nextWayNums;
        }

        return wayNums[count];
    }

    static int addMod(int x, int y) {
        return (x + y) % MODULUS;
    }

    static int multiplyMod(int x, int y) {
        return (int) ((long) x * y % MODULUS);
    }

    static List<Integer> buildExponents(int M) {
        List<Integer> exponents = new ArrayList<>();
        int current = M;
        for (int i = 2; i * i <= current; ++i) {
            int exponent = 0;
            while (current % i == 0) {
                ++exponent;
                current /= i;
            }

            if (exponent != 0) {
                exponents.add(exponent);
            }
        }
        if (current != 1) {
            exponents.add(1);
        }

        return exponents;
    }
}
