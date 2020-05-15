import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int P = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(solve(X, P, A, B));

        sc.close();
    }

    static int solve(int X, int P, int A, int B) {
        int power = BigInteger.valueOf(X).modPow(BigInteger.valueOf(A), BigInteger.valueOf(P)).intValue();
        int result = power;
        for (int i = A + 1; i <= B; ++i) {
            if (result == 1) {
                break;
            }

            power = (int) ((long) power * X % P);
            result = Math.min(result, power);
        }

        return result;
    }
}