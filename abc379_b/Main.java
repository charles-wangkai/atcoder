import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int K = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, K));

    sc.close();
  }

  static int solve(String S, int K) {
    int result = 0;
    int count = 0;
    for (int i = 0; i <= S.length(); ++i) {
      if (i != S.length() && S.charAt(i) == 'O') {
        ++count;
      } else {
        result += count / K;
        count = 0;
      }
    }

    return result;
  }
}