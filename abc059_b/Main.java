import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger A = sc.nextBigInteger();
        BigInteger B = sc.nextBigInteger();

        System.out.println(solve(A, B));

        sc.close();
    }

    static String solve(BigInteger A, BigInteger B) {
        int cmp = A.compareTo(B);
        if (cmp < 0) {
            return "LESS";
        } else if (cmp > 0) {
            return "GREATER";
        } else {
            return "EQUAL";
        }
    }
}