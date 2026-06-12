import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    char[] result = S.toCharArray();
    for (int i = 0; i < result.length; ++i) {
      if (result[i] == '.' && (i == 0 || S.charAt(i - 1) != '.')) {
        result[i] = 'o';
      }
    }

    return String.valueOf(result);
  }
}