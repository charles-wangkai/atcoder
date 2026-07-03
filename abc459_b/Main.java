import static java.util.Map.entry;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final Map<Character, Integer> LETTER_TO_VALUE =
      Map.ofEntries(
          entry('a', 2),
          entry('b', 2),
          entry('c', 2),
          entry('d', 3),
          entry('e', 3),
          entry('f', 3),
          entry('g', 4),
          entry('h', 4),
          entry('i', 4),
          entry('j', 5),
          entry('k', 5),
          entry('l', 5),
          entry('m', 6),
          entry('n', 6),
          entry('o', 6),
          entry('p', 7),
          entry('q', 7),
          entry('r', 7),
          entry('s', 7),
          entry('t', 8),
          entry('u', 8),
          entry('v', 8),
          entry('w', 9),
          entry('x', 9),
          entry('y', 9),
          entry('z', 9));

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
    return Arrays.stream(S)
        .mapToInt(Si -> LETTER_TO_VALUE.get(Si.charAt(0)))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining());
  }
}