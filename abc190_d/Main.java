import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(long N) {
    int result = 0;
    long product = 2 * N;
    for (int i = 1; (long) i * i < product; ++i) {
      if (product % i == 0 && i % 2 != product / i % 2) {
        result += 2;
      }
    }

    return result;
  }
}