import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    return IntStream.range(0, S.length())
        .filter(i -> S.charAt(i) == '/')
        .map(i -> findMaxLength(S, i))
        .max()
        .getAsInt();
  }

  static int findMaxLength(String S, int middleIndex) {
    int beginIndex = middleIndex;
    int endIndex = middleIndex;
    while (beginIndex != 0
        && S.charAt(beginIndex - 1) == '1'
        && endIndex != S.length() - 1
        && S.charAt(endIndex + 1) == '2') {
      --beginIndex;
      ++endIndex;
    }

    return endIndex - beginIndex + 1;
  }
}