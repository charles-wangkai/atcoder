import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    List<Character> result = new ArrayList<>();
    for (char c : S.toCharArray()) {
      if (c == 'C'
          && result.size() >= 2
          && result.get(result.size() - 2) == 'A'
          && result.get(result.size() - 1) == 'B') {
        result.removeLast();
        result.removeLast();
      } else {
        result.add(c);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining());
  }
}