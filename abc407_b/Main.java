import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int Y = sc.nextInt();

    System.out.println("%.9f".formatted(solve(X, Y)));

    sc.close();
  }

  static double solve(int X, int Y) {
    int count = 0;
    for (int d1 = 1; d1 <= 6; ++d1) {
      for (int d2 = 1; d2 <= 6; ++d2) {
        if (d1 + d2 >= X || Math.abs(d1 - d2) >= Y) {
          ++count;
        }
      }
    }

    return count / 36.0;
  }
}