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
    return S.chars()
        .filter(c -> c == '2')
        .mapToObj(c -> (char) c)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}