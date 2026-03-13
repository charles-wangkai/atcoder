import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();

    System.out.println(solve(K));

    sc.close();
  }

  static int solve(int K) {
    int result = 0;
    for (int a = 1; a <= K; ++a) {
      for (int b = 1; b <= K; ++b) {
        for (int c = 1; c <= K; ++c) {
          result += gcd(gcd(a, b), c);
        }
      }
    }

    return result;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}