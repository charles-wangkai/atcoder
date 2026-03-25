import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] S = new String[4];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String[] S) {
    return Arrays.stream(S).distinct().count() == S.length;
  }
}