import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    int[][] result = new int[N][];
    for (int r = 0; r < result.length; ++r) {
      result[r] = new int[r + 1];
      for (int c = 0; c < result[r].length; ++c) {
        result[r][c] =
            (c == 0 || c == result[r].length - 1) ? 1 : (result[r - 1][c - 1] + result[r - 1][c]);
      }
    }

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}