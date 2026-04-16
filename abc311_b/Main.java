import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String[] S) {
    int D = S[0].length();

    int result = 0;
    int length = 0;
    for (int i = 0; i < D; ++i) {
      int i_ = i;
      if (Arrays.stream(S).allMatch(s -> s.charAt(i_) == 'o')) {
        ++length;
        result = Math.max(result, length);
      } else {
        length = 0;
      }
    }

    return result;
  }
}