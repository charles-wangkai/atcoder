import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();

    System.out.println(solve(X) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int X) {
    return X >= 30;
  }
}
