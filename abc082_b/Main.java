import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    String t = sc.next();

    System.out.println(solve(s, t) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String s, String t) {
    return sort(s, Comparator.naturalOrder()).compareTo(sort(t, Comparator.reverseOrder())) < 0;
  }

  static String sort(String str, Comparator<Character> comparator) {
    return str.chars()
        .mapToObj(c -> (char) c)
        .sorted(comparator)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}