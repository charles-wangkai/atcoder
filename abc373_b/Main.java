import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    int[] sortedIndices =
        IntStream.range(0, S.length())
            .boxed()
            .sorted(Comparator.comparing(S::charAt))
            .mapToInt(Integer::intValue)
            .toArray();

    return IntStream.range(0, sortedIndices.length - 1)
        .map(i -> Math.abs(sortedIndices[i] - sortedIndices[i + 1]))
        .sum();
  }
}