import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();

    System.out.println(solve(X));

    sc.close();
  }

  static int solve(int X) {
    int result = 0;
    for (int i = 1; i <= 9; ++i) {
      for (int j = 1; j <= 9; ++j) {
        int product = i * j;
        if (product != X) {
          result += product;
        }
      }
    }

    return result;
  }
}