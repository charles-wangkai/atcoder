import java.util.Arrays;
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
    return (int) Arrays.stream(S).map(Main::buildKey).distinct().count();
  }

  static String buildKey(String s) {
    String reversed = new StringBuilder(s).reverse().toString();

    return (s.compareTo(reversed) <= 0) ? s : reversed;
  }
}