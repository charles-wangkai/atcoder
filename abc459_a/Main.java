import java.util.Scanner;

public class Main {
  static final String S = "HelloWorld";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();

    System.out.println(solve(X));

    sc.close();
  }

  static String solve(int X) {
    return "%s%s".formatted(S.substring(0, X - 1), S.substring(X));
  }
}