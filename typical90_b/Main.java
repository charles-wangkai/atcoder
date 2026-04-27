import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    return IntStream.range(0, 1 << N)
        .mapToObj(
            mask ->
                IntStream.range(0, N)
                    .mapToObj(i -> (((mask >> i) & 1) == 0) ? '(' : ')')
                    .map(String::valueOf)
                    .collect(Collectors.joining()))
        .filter(Main::isValid)
        .sorted()
        .collect(Collectors.joining("\n"));
  }

  static boolean isValid(String parentheses) {
    int depth = 0;
    for (char p : parentheses.toCharArray()) {
      depth += (p == '(') ? 1 : -1;
      if (depth == -1) {
        return false;
      }
    }

    return depth == 0;
  }
}