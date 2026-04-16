import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static char solve(String S) {
    Set<Character> letters = S.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

    for (char c = 'a'; ; ++c) {
      if (!letters.contains(c)) {
        return c;
      }
    }
  }
}