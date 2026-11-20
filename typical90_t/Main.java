import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      long a = sc.nextLong();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(a, b, c) ? "Yes" : "No");
    }
  }

  static boolean solve(long a, int b, int c) {
    return a < pow(c, b);
  }

  static long pow(int base, int exponent) {
    long result = 1;
    for (int i = 0; i < exponent; ++i) {
      result *= base;
    }

    return result;
  }
}