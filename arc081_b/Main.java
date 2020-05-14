import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        String S1 = sc.next();
        String S2 = sc.next();

        System.out.println(solve(S1, S2));

        sc.close();
    }

    static int solve(String S1, String S2) {
        int result = 1;
        int index = 0;
        int prevLength = 0;
        while (index != S1.length()) {
            int factor;
            if (index + 1 != S1.length() && S1.charAt(index) == S1.charAt(index + 1)) {
                if (prevLength == 0) {
                    factor = 6;
                } else if (prevLength == 1) {
                    factor = 2;
                } else {
                    factor = 3;
                }

                prevLength = 2;
            } else {
                if (prevLength == 0) {
                    factor = 3;
                } else if (prevLength == 1) {
                    factor = 2;
                } else {
                    factor = 1;
                }

                prevLength = 1;
            }

            result = multiplyMod(result, factor);
            index += prevLength;
        }

        return result;
    }

    static int multiplyMod(int x, int y) {
        return (int) ((long) x * y % MODULUS);
    }
}