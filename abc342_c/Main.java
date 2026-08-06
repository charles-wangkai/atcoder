import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();
    int Q = sc.nextInt();
    char[] c = new char[Q];
    char[] d = new char[Q];
    for (int i = 0; i < Q; ++i) {
      c[i] = sc.next().charAt(0);
      d[i] = sc.next().charAt(0);
    }

    System.out.println(solve(S, c, d));

    sc.close();
  }

  static String solve(String S, char[] c, char[] d) {
    Map<Character, Character> letterToReplaced =
        IntStream.rangeClosed('a', 'z')
            .mapToObj(ch -> (char) ch)
            .collect(Collectors.toMap(ch -> ch, ch -> ch));
    for (int i = 0; i < c.length; ++i) {
      for (char letter : letterToReplaced.keySet()) {
        if (letterToReplaced.get(letter) == c[i]) {
          letterToReplaced.put(letter, d[i]);
        }
      }
    }

    return S.chars()
        .mapToObj(ch -> letterToReplaced.get((char) ch))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}