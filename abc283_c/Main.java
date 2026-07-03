import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    int result = 0;
    int index = 0;
    while (index != S.length()) {
      if (index != S.length() - 1 && S.charAt(index) == '0' && S.charAt(index + 1) == '0') {
        index += 2;
      } else {
        ++index;
      }

      ++result;
    }

    return result;
  }
}