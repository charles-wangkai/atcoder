import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] parts = sc.next().split("/");
        long X = Long.parseLong(parts[0]);
        int Y = Integer.parseInt(parts[1]);

        System.out.println(solve(X, Y));

        sc.close();
    }

    static String solve(long X, int Y) {
        List<String> solutions = new ArrayList<>();
        for (int n = (int) (X / Y) * 2 - 1; n <= (int) (X / Y) * 2 + 4; ++n) {
            if (BigInteger.valueOf(2L * n).multiply(BigInteger.valueOf(X)).mod(BigInteger.valueOf(Y))
                    .equals(BigInteger.ZERO)) {
                BigInteger part = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n + 1)).subtract(
                        BigInteger.valueOf(2L * n).multiply(BigInteger.valueOf(X)).divide(BigInteger.valueOf(Y)));
                if (part.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                    BigInteger m = part.divide(BigInteger.valueOf(2));
                    if (m.compareTo(BigInteger.ONE) >= 0 && m.compareTo(BigInteger.valueOf(n)) <= 0) {
                        solutions.add(String.format("%d %d", n, m));
                    }
                }
            }
        }

        return solutions.isEmpty() ? "Impossible" : String.join("\n", solutions);
    }
}
