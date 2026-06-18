import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S, String T) {
    return isSubsequence(S, T) || (isSubsequence(S, T.substring(0, 2)) && T.charAt(2) == 'X');
  }

  static boolean isSubsequence(String S, String target) {
    int index = 0;
    for (char c : S.toCharArray()) {
      if (index != target.length() && Character.toUpperCase(c) == target.charAt(index)) {
        ++index;
      }
    }

    return index == target.length();
  }
}