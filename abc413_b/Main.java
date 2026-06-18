import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
    Set<String> concatenated = new HashSet<>();
    for (int i = 0; i < S.length; ++i) {
      for (int j = 0; j < S.length; ++j) {
        if (j != i) {
          concatenated.add(S[i] + S[j]);
        }
      }
    }

    return concatenated.size();
  }
}