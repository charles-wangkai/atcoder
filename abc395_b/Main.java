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
    char[][] result = new char[N][N];
    for (int i = 0, j = N - 1 - i; i <= j; ++i, --j) {
      char color = (i % 2 == 0) ? '#' : '.';

      for (int c = i; c <= j; ++c) {
        result[i][c] = color;
        result[j][c] = color;
      }
      for (int r = i; r <= j; ++r) {
        result[r][i] = color;
        result[r][j] = color;
      }
    }

    return Arrays.stream(result).map(String::valueOf).collect(Collectors.joining("\n"));
  }
}