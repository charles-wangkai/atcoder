import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    List<Character> result = new ArrayList<>();
    for (char c : s.toCharArray()) {
      if (c == 'B') {
        if (!result.isEmpty()) {
          result.removeLast();
        }
      } else {
        result.add(c);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining());
  }
}