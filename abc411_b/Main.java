import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] D = new int[N - 1];
    for (int i = 0; i < N - 1; ++i) {
      D[i] = sc.nextInt();
    }

    System.out.println(solve(D));

    sc.close();
  }

  static String solve(int[] D) {
    int N = D.length;

    int[][] result = new int[N][];
    for (int i = 0; i < result.length; ++i) {
      result[i] = new int[N - i];
      for (int j = 0; j < result[i].length; ++j) {
        result[i][j] = ((j == 0) ? 0 : result[i][j - 1]) + D[i + j];
      }
    }

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}