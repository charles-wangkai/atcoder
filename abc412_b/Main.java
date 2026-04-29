import java.util.Scanner;
import java.util.Set;
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
    Set<Character> tSet = T.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

    return IntStream.range(1, S.length())
        .filter(i -> Character.isUpperCase(S.charAt(i)))
        .allMatch(i -> tSet.contains(S.charAt(i - 1)));
  }
}