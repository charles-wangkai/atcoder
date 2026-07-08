import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    String[] sorted =
        IntStream.range(0, S.length())
            .mapToObj(
                beginIndex ->
                    IntStream.range(0, S.length())
                        .mapToObj(i -> S.charAt((beginIndex + i) % S.length()))
                        .map(String::valueOf)
                        .collect(Collectors.joining()))
            .sorted()
            .toArray(String[]::new);

    return "%s\n%s".formatted(sorted[0], sorted[sorted.length - 1]);
  }
}