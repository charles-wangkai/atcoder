import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String[] S) {
    return !IntStream.range(0, S.length - 2)
        .anyMatch(i -> S[i].equals("sweet") && S[i + 1].equals("sweet"));
  }
}