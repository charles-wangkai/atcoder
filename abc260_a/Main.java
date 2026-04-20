import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    Character[] sorted = S.chars().mapToObj(c -> (char) c).sorted().toArray(Character[]::new);

    return IntStream.range(0, sorted.length)
        .filter(
            i ->
                (i == 0 || !sorted[i].equals(sorted[i - 1]))
                    && (i == sorted.length - 1 || !sorted[i].equals(sorted[i + 1])))
        .mapToObj(i -> sorted[i])
        .map(String::valueOf)
        .findAny()
        .orElse("-1");
  }
}