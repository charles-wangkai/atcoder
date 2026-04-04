import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    int pointIndex = S.indexOf('.');
    int X = Integer.parseInt(S.substring(0, pointIndex));
    int Y = Integer.parseInt(S.substring(pointIndex + 1));

    String symbol;
    if (Y <= 2) {
      symbol = "-";
    } else if (Y <= 6) {
      symbol = "";
    } else {
      symbol = "+";
    }

    return "%d%s".formatted(X, symbol);
  }
}