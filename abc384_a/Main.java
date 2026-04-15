import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    char c1 = sc.next().charAt(0);
    char c2 = sc.next().charAt(0);
    String S = sc.next();

    System.out.println(solve(S, c1, c2));

    sc.close();
  }

  static String solve(String S, char c1, char c2) {
    return S.chars()
        .mapToObj(c -> (char) ((c == c1) ? c1 : c2))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}