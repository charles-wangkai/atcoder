import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x = readArray(sc, n);
        int[] y = readArray(sc, m);

        System.out.println(solve(x, y));

        sc.close();
    }

    static int[] readArray(Scanner sc, int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = sc.nextInt();
        }

        return result;
    }

    static int solve(int[] x, int[] y) {
        return multiplyMod(computeSideSum(x), computeSideSum(y));
    }

    static int computeSideSum(int[] values) {
        int result = 0;
        int prefixSum = values[0];
        for (int i = 1; i < values.length; ++i) {
            result = addMod(result, subtractMod(multiplyMod(values[i], i), prefixSum));

            prefixSum = addMod(prefixSum, values[i]);
        }

        return result;
    }

    static int addMod(int a, int b) {
        return (a + b) % MODULUS;
    }

    static int subtractMod(int a, int b) {
        return ((a - b) % MODULUS + MODULUS) % MODULUS;
    }

    static int multiplyMod(int a, int b) {
        return (int) ((long) a * b % MODULUS);
    }
}