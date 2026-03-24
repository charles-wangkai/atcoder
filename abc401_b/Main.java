import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String[] S) {
    int result = 0;
    boolean logged = false;
    for (String Si : S) {
      if (Si.equals("login")) {
        logged = true;
      } else if (Si.equals("logout")) {
        logged = false;
      } else if (Si.equals("private") && !logged) {
        ++result;
      }
    }

    return result;
  }
}