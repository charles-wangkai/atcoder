import static java.util.Map.entry;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final Map<Character, Character> DIGIT_TO_ROTATED =
      Map.ofEntries(
          entry('0', '0'), entry('1', '1'), entry('6', '9'), entry('8', '8'), entry('9', '6'));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    return new StringBuilder(S)
        .reverse()
        .chars()
        .mapToObj(c -> (char) c)
        .map(DIGIT_TO_ROTATED::get)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}