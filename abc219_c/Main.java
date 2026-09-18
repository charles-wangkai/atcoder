import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String X = sc.next();
    int N = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(X, S));

    sc.close();
  }

  static String solve(String X, String[] S) {
    Map<Character, Character> newToOld =
        IntStream.range(0, X.length())
            .boxed()
            .collect(Collectors.toMap(X::charAt, i -> (char) ('a' + i)));

    String[] mapped =
        Arrays.stream(S)
            .map(
                s ->
                    s.chars()
                        .mapToObj(c -> (char) c)
                        .map(newToOld::get)
                        .map(String::valueOf)
                        .collect(Collectors.joining()))
            .toArray(String[]::new);

    return IntStream.range(0, S.length)
        .boxed()
        .sorted(Comparator.comparing(i -> mapped[i]))
        .map(i -> S[i])
        .collect(Collectors.joining("\n"));
  }
}