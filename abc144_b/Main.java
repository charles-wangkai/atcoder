import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int N) {
    for (int x = 1; x <= 9; ++x) {
      for (int y = x; y <= 9; ++y) {
        if (x * y == N) {
          return true;
        }
      }
    }

    return false;
  }
}