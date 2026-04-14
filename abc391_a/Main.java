import static java.util.Map.entry;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final Map<Character, Character> DIRECTION_TO_OPPOSITE =
      Map.ofEntries(entry('N', 'S'), entry('S', 'N'), entry('E', 'W'), entry('W', 'E'));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String D = sc.next();

    System.out.println(solve(D));

    sc.close();
  }

  static String solve(String D) {
    return D.chars()
        .mapToObj(c -> DIRECTION_TO_OPPOSITE.get((char) c))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}