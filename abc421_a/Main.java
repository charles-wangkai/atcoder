import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }
    int X = sc.nextInt();
    String Y = sc.next();

    System.out.println(solve(S, X, Y) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String[] S, int X, String Y) {
    return Y.equals(S[X - 1]);
  }
}