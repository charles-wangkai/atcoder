import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String W = sc.next();

    System.out.println(solve(W));

    sc.close();
  }

  static String solve(String W) {
    return W.chars()
        .filter(c -> "aeiou".indexOf(c) == -1)
        .mapToObj(c -> (char) c)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}