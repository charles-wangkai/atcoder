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
    int[][] grid = new int[N][N];
    int r = 0;
    int c = (N - 1) / 2;
    for (int i = 1; i <= N * N; ++i) {
      grid[r][c] = i;

      int nextR = Math.floorMod(r - 1, N);
      int nextC = (c + 1) % N;
      if (grid[nextR][nextC] == 0) {
        r = nextR;
        c = nextC;
      } else {
        r = (r + 1) % N;
      }
    }

    return Arrays.stream(grid)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}