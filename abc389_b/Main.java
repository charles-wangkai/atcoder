import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long X = sc.nextLong();

    System.out.println(solve(X));

    sc.close();
  }

  static int solve(long X) {
    long factorial = 1;
    for (int i = 2; ; ++i) {
      factorial *= i;
      if (factorial == X) {
        return i;
      }
    }
  }
}