import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    String[] T = new String[N];
    for (int i = 0; i < N; ++i) {
      S[i] = sc.next();
      T[i] = sc.next();
    }

    System.out.println(solve(S, T) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String[] S, String[] T) {
    for (int i = 0; i < S.length; ++i) {
      for (int j = i + 1; j < S.length; ++j) {
        if (S[j].equals(S[i]) && T[j].equals(T[i])) {
          return true;
        }
      }
    }

    return false;
  }
}