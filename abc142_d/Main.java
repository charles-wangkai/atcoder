import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long A = sc.nextLong();
    long B = sc.nextLong();

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(long A, long B) {
    long g = gcd(A, B);

    int result = 1;
    for (int i = 2; (long) i * i <= g; ++i) {
      if (g % i == 0) {
        ++result;

        while (g % i == 0) {
          g /= i;
        }
      }
    }
    if (g != 1) {
      ++result;
    }

    return result;
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}