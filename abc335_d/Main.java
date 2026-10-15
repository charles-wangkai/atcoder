import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int[] R_OFFSETS = {0, 1, 0, -1};
  static final int[] C_OFFSETS = {1, 0, -1, 0};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    String[][] grid = new String[N][N];
    grid[N / 2][N / 2] = "T";

    int r = 0;
    int c = -1;
    int direction = 0;
    for (int value = 1; value <= N * N - 1; ++value) {
      int nextR = r + R_OFFSETS[direction];
      int nextC = c + C_OFFSETS[direction];
      if (!(nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && grid[nextR][nextC] == null)) {
        direction = (direction + 1) % R_OFFSETS.length;

        nextR = r + R_OFFSETS[direction];
        nextC = c + C_OFFSETS[direction];
      }

      grid[nextR][nextC] = String.valueOf(value);

      r = nextR;
      c = nextC;
    }

    return Arrays.stream(grid)
        .map(line -> String.join(" ", line))
        .collect(Collectors.joining("\n"));
  }
}