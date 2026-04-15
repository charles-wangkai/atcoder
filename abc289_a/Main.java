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
    return s.chars()
        .mapToObj(c -> (char) ('0' + '1' - c))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}