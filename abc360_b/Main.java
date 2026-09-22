import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S, String T) {
    return IntStream.range(1, S.length())
        .anyMatch(
            w ->
                IntStream.rangeClosed(1, w)
                    .anyMatch(
                        c ->
                            IntStream.range(0, S.length())
                                .filter(i -> i % w == c - 1)
                                .mapToObj(S::charAt)
                                .map(String::valueOf)
                                .collect(Collectors.joining())
                                .equals(T)));
  }
}