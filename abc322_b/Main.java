import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    sc.nextInt();
    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T));

    sc.close();
  }

  static int solve(String S, String T) {
    boolean isPrefix = T.startsWith(S);
    boolean isSuffix = T.endsWith(S);

    if (isPrefix) {
      return isSuffix ? 0 : 1;
    }

    return isSuffix ? 2 : 3;
  }
}