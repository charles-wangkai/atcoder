import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();

    System.out.println(solve(X) ? 1 : 0);

    sc.close();
  }

  static boolean solve(int X) {
    int lower = 0;
    int upper = 0;
    while (lower <= X) {
      if (upper >= X) {
        return true;
      }

      lower += 100;
      upper += 105;
    }

    return false;
  }
}