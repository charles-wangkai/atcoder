import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    char X = sc.next().charAt(0);
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S, X) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String[] S, char X) {
    return Arrays.stream(S).anyMatch(Si -> Si.charAt(X - 'A') == 'o');
  }
}