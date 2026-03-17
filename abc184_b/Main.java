import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int X = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, X));

    sc.close();
  }

  static int solve(String S, int X) {
    int result = X;
    for (char c : S.toCharArray()) {
      result = Math.max(0, result + ((c == 'o') ? 1 : -1));
    }

    return result;
  }
}