import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    Character[] letters = S.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

    return (int)
        Stream.of(
                "%c%c%c".formatted(letters[0], letters[1], letters[2]),
                "%c%c%c".formatted(letters[0], letters[2], letters[1]),
                "%c%c%c".formatted(letters[1], letters[0], letters[2]),
                "%c%c%c".formatted(letters[1], letters[2], letters[0]),
                "%c%c%c".formatted(letters[2], letters[0], letters[1]),
                "%c%c%c".formatted(letters[2], letters[1], letters[0]))
            .distinct()
            .count();
  }
}