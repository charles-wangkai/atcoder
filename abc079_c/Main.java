import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] digits = sc.next().chars().map(c -> c - '0').toArray();

    System.out.println(solve(digits));

    sc.close();
  }

  static String solve(int[] digits) {
    for (int mask = 0; ; ++mask) {
      StringBuilder result = new StringBuilder(String.valueOf(digits[0]));
      int n = digits[0];
      for (int i = 1; i < digits.length; ++i) {
        if (((mask >> (i - 1)) & 1) == 1) {
          result.append("+");
          n += digits[i];
        } else {
          result.append("-");
          n -= digits[i];
        }

        result.append(digits[i]);
      }

      if (n == 7) {
        result.append("=7");

        return result.toString();
      }
    }
  }
}