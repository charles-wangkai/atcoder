import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    int[] P = new int[N];
    for (int i = 0; i < N; ++i) {
      S[i] = sc.next();
      P[i] = sc.nextInt();
    }

    System.out.println(solve(S, P));

    sc.close();
  }

  static String solve(String[] S, int[] P) {
    return IntStream.range(0, S.length)
        .boxed()
        .sorted(
            Comparator.<Integer, String>comparing(i -> S[i])
                .thenComparing(Comparator.<Integer, Integer>comparing(i -> P[i]).reversed()))
        .mapToInt(i -> i + 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}