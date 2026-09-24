import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long D = sc.nextLong();

    System.out.println(solve(D));

    sc.close();
  }

  static int solve(long D) {
    long result = Long.MAX_VALUE;
    int y = 2_000_000;
    for (int x = 0; ; ++x) {
      long x2 = (long) x * x;

      while (y != 0 && x2 + (y - 1L) * (y - 1) >= D) {
        --y;
      }

      result =
          Math.min(
              result,
              Math.min(Math.abs(x2 + (long) y * y - D), Math.abs(x2 + (y - 1L) * (y - 1) - D)));

      if (x2 >= D) {
        break;
      }
    }

    return (int) result;
  }
}