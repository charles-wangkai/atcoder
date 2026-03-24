import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

  static String solve(String[] S) {
    return IntStream.range(0, S.length)
        .mapToObj(i -> S[S.length - 1 - i])
        .collect(Collectors.joining("\n"));
  }
}