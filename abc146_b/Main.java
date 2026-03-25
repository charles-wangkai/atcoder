import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(N, S));

    sc.close();
  }

  static String solve(int N, String S) {
    return S.chars()
        .mapToObj(c -> (char) (((c - 'A') + N) % 26 + 'A'))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}