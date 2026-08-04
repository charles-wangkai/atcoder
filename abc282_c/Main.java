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
    char[] result = S.toCharArray();
    boolean enclosed = false;
    for (int i = 0; i < result.length; ++i) {
      if (result[i] == '"') {
        enclosed ^= true;
      } else if (!enclosed && result[i] == ',') {
        result[i] = '.';
      }
    }

    return String.valueOf(result);
  }
}