import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S, M));

    sc.close();
  }

  static int solve(String[] S, int M) {
    int result = 0;
    for (int i = 0; i < S.length; ++i) {
      for (int j = i + 1; j < S.length; ++j) {
        int i_ = i;
        int j_ = j;
        if (IntStream.range(0, M).allMatch(k -> S[i_].charAt(k) == 'o' || S[j_].charAt(k) == 'o')) {
          ++result;
        }
      }
    }

    return result;
  }
}