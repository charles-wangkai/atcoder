import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String L = sc.next();

        System.out.println(solve(L));

        sc.close();
    }

    static int solve(String L) {
        int[] threePowers = new int[L.length()];
        threePowers[0] = 1;
        for (int i = 1; i < threePowers.length; ++i) {
            threePowers[i] = multiplyMod(threePowers[i - 1], 3);
        }

        int result = 0;
        int factor = 1;
        for (int i = 0; i < L.length(); ++i) {
            if (L.charAt(i) == '1') {
                result = addMod(result, multiplyMod(factor, threePowers[L.length() - i - 1]));
                factor = multiplyMod(factor, 2);
            }
        }
        result = addMod(result, factor);

        return result;
    }

    static int addMod(int x, int y) {
        return (x + y) % MODULUS;
    }

    static int multiplyMod(int x, int y) {
        return (int) ((long) x * y % MODULUS);
    }
}