import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    long K = sc.nextLong();

    System.out.println(solve(S, K));

    sc.close();
  }

  static char solve(String S, long K) {
    for (int i = 0; i < K - 1; ++i) {
      char c = S.charAt(i);
      if (c != '1') {
        return c;
      }
    }

    return S.charAt((int) K - 1);
  }
}