import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S) {
    OptionalInt beginIndex =
        IntStream.range(0, S.length()).filter(i -> S.charAt(i) != 'a').findFirst();
    if (beginIndex.isEmpty()) {
      return true;
    }

    int endIndex = IntStream.range(0, S.length()).filter(i -> S.charAt(i) != 'a').max().getAsInt();
    if (beginIndex.getAsInt() > S.length() - 1 - endIndex) {
      return false;
    }

    for (int i = beginIndex.getAsInt(), j = endIndex; i < j; ++i, --j) {
      if (S.charAt(i) != S.charAt(j)) {
        return false;
      }
    }

    return true;
  }
}