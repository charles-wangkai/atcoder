import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    return IntStream.rangeClosed(1, S.length() - 1)
        .map(offset -> computeMaxLength(S, offset))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static int computeMaxLength(String S, int offset) {
    int result = 0;
    for (int i = 0; i + offset < S.length() && S.charAt(i) != S.charAt(i + offset); ++i) {
      ++result;
    }

    return result;
  }
}