import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String X = sc.next();

    System.out.println(solve(X));

    sc.close();
  }

  static String solve(String X) {
    int pointIndex = X.indexOf('.');
    String fraction = X.substring(pointIndex + 1);
    if (fraction.chars().allMatch(c -> c == '0')) {
      return X.substring(0, pointIndex);
    }

    while (fraction.endsWith("0")) {
      fraction = fraction.substring(0, fraction.length() - 1);
    }

    return "%s.%s".formatted(X.substring(0, pointIndex), fraction);
  }
}