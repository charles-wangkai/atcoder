import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] s = new String[N];
    String[] t = new String[N];
    for (int i = 0; i < N; ++i) {
      s[i] = sc.next();
      t[i] = sc.next();
    }

    System.out.println(solve(s, t) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String[] s, String[] t) {
    int N = s.length;

    return IntStream.range(0, N)
        .allMatch(
            i ->
                Stream.of(s[i], t[i])
                    .anyMatch(
                        nickname ->
                            IntStream.range(0, N)
                                .allMatch(
                                    j ->
                                        j == i
                                            || (!s[j].equals(nickname)
                                                && !t[j].equals(nickname)))));
  }
}