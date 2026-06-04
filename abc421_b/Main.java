import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int Y = sc.nextInt();

    System.out.println(solve(X, Y));

    sc.close();
  }

  static long solve(int X, int Y) {
    long prev = X;
    long curr = Y;
    for (int i = 0; i < 8; ++i) {
      long next =
          Long.parseLong(new StringBuilder(String.valueOf(prev + curr)).reverse().toString());

      prev = curr;
      curr = next;
    }

    return curr;
  }
}