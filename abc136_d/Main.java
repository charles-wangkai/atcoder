import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    int[] result = new int[S.length()];

    int beginIndex = 0;
    while (beginIndex != S.length()) {
      int rIndex = beginIndex;
      while (S.charAt(rIndex + 1) == 'R') {
        ++rIndex;
      }

      int lIndex = rIndex + 1;

      int endIndex = lIndex;
      while (endIndex != S.length() - 1 && S.charAt(endIndex + 1) == 'L') {
        ++endIndex;
      }

      int rIndex_ = rIndex;
      result[rIndex] =
          (int)
              IntStream.rangeClosed(beginIndex, endIndex).filter(i -> i % 2 == rIndex_ % 2).count();

      result[lIndex] =
          (int)
              IntStream.rangeClosed(beginIndex, endIndex).filter(i -> i % 2 == lIndex % 2).count();

      beginIndex = endIndex + 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}