import java.util.Scanner;

public class Main {
    static int MODULUS = 2019;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int R = sc.nextInt();

        System.out.println(solve(L, R));

        sc.close();
    }

    static long solve(int L, int R) {
        long result = Long.MAX_VALUE;
        for (int i = L; i < R && i - L < MODULUS; ++i) {
            for (int j = i + 1; j <= R && j - L < MODULUS; ++j) {
                result = Math.min(result, (long) i * j % MODULUS);
            }
        }

        return result;
    }
}