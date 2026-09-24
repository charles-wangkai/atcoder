import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long A = sc.nextLong();
    long B = sc.nextLong();
    long C = sc.nextLong();

    System.out.println(solve(A, B, C));

    sc.close();
  }

  static long solve(long A, long B, long C) {
    long g = gcd(gcd(A, B), C);

    return A / g + B / g + C / g - 3;
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}