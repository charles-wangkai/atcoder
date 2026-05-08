import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    int beginIndex = 0;
    while (beginIndex != S.length() && S.charAt(beginIndex) == 'o') {
      ++beginIndex;
    }

    return S.substring(beginIndex);
  }
}