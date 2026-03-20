import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String X = sc.next();

    System.out.println(solve(X));

    sc.close();
  }

  static String solve(String X) {
    int index = X.indexOf('.');

    return X.substring(0, (index == -1) ? X.length() : index);
  }
}