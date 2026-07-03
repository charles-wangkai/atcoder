import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S) {
    int leftBIndex = S.indexOf('B');
    int rightBIndex = S.lastIndexOf('B');
    int leftRIndex = S.indexOf('R');
    int rightRIndex = S.lastIndexOf('R');
    int kIndex = S.indexOf('K');

    return leftBIndex % 2 != rightBIndex % 2 && kIndex > leftRIndex && kIndex < rightRIndex;
  }
}