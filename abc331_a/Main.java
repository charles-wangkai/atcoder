import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int M = sc.nextInt();
    int D = sc.nextInt();
    int y = sc.nextInt();
    int m = sc.nextInt();
    int d = sc.nextInt();

    System.out.println(solve(M, D, y, m, d));

    sc.close();
  }

  static String solve(int M, int D, int y, int m, int d) {
    if (d == D) {
      d = 1;

      if (m == M) {
        m = 1;
        ++y;
      } else {
        ++m;
      }
    } else {
      ++d;
    }

    return "%d %d %d".formatted(y, m, d);
  }
}