import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    int result = 0;
    for (int d1 = 0; d1 <= 9; ++d1) {
      for (int d2 = 0; d2 <= 9; ++d2) {
        for (int d3 = 0; d3 <= 9; ++d3) {
          if (check(S, "%d%d%d".formatted(d1, d2, d3))) {
            ++result;
          }
        }
      }
    }

    return result;
  }

  static boolean check(String S, String pin) {
    int index = 0;
    for (char c : S.toCharArray()) {
      if (index != pin.length() && pin.charAt(index) == c) {
        ++index;
      }
    }

    return index == pin.length();
  }
}