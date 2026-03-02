import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    String[] fields = s.split("/");
    long X = Long.parseLong(fields[0]);
    int Y = Integer.parseInt(fields[1]);

    List<String> solutions = new ArrayList<>();
    for (int n = (int) (X / Y) * 2 - 1; n <= (int) (X / Y) * 2 + 4; ++n) {
      if (BigInteger.valueOf(2L * n)
          .multiply(BigInteger.valueOf(X))
          .mod(BigInteger.valueOf(Y))
          .equals(BigInteger.ZERO)) {
        BigInteger part =
            BigInteger.valueOf(n)
                .multiply(BigInteger.valueOf(n + 1))
                .subtract(
                    BigInteger.valueOf(2L * n)
                        .multiply(BigInteger.valueOf(X))
                        .divide(BigInteger.valueOf(Y)));
        if (part.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
          BigInteger m = part.divide(BigInteger.TWO);
          if (m.compareTo(BigInteger.ONE) >= 0 && m.compareTo(BigInteger.valueOf(n)) <= 0) {
            solutions.add("%d %d".formatted(n, m));
          }
        }
      }
    }

    return solutions.isEmpty() ? "Impossible" : String.join("\n", solutions);
  }
}
