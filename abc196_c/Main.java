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
    int half = 1;
    while (true) {
      double value = Long.parseLong("%d%d".formatted(half, half));
      if (value > N) {
        break;
      }

      ++result;
      ++half;
    }

    return result;
  }
}