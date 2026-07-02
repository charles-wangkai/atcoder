import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S, K));

    sc.close();
  }

  static String solve(String[] S, int K) {
    return IntStream.range(0, K).mapToObj(i -> S[i]).sorted().collect(Collectors.joining("\n"));
  }
}