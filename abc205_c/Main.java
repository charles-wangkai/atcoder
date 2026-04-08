import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();

    System.out.println(solve(A, B, C));

    sc.close();
  }

  static char solve(int A, int B, int C) {
    int exponent = (C % 2 == 0) ? 2 : 1;
    long power1 = pow(A, exponent);
    long power2 = pow(B, exponent);

    if (power1 < power2) {
      return '<';
    }
    if (power1 > power2) {
      return '>';
    }

    return '=';
  }

  static long pow(int base, int exponent) {
    long result = 1;
    for (int i = 0; i < exponent; ++i) {
      result *= base;
    }

    return result;
  }
}