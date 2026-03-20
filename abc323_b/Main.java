import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    char[][] S = new char[N][N];
    for (int i = 0; i < N; ++i) {
      String line = sc.next();
      for (int j = 0; j < N; ++j) {
        S[i][j] = line.charAt(j);
      }
    }

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(char[][] S) {
    int[] winNums =
        Arrays.stream(S)
            .mapToInt(
                line -> (int) IntStream.range(0, line.length).filter(i -> line[i] == 'o').count())
            .toArray();

    return IntStream.range(0, winNums.length)
        .boxed()
        .sorted(
            Comparator.<Integer, Integer>comparing(i -> winNums[i])
                .reversed()
                .thenComparing(Comparator.comparing(i -> i)))
        .map(i -> i + 1)
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}