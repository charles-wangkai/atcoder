import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    int size = pow3(N);
    char[][] grid = new char[size][size];
    paint(grid, N, 0, 0);

    return Arrays.stream(grid).map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static int pow3(int e) {
    return IntStream.range(0, e).reduce(1, (acc, x) -> acc * 3);
  }

  static void paint(char[][] grid, int level, int minR, int minC) {
    if (level == 0) {
      grid[minR][minC] = '#';
    } else {
      int size = pow3(level - 1);

      paint(grid, level - 1, minR, minC);
      paint(grid, level - 1, minR, minC + size);
      paint(grid, level - 1, minR, minC + size * 2);
      paint(grid, level - 1, minR + size, minC);
      paint(grid, level - 1, minR + size, minC + size * 2);
      paint(grid, level - 1, minR + size * 2, minC);
      paint(grid, level - 1, minR + size * 2, minC + size);
      paint(grid, level - 1, minR + size * 2, minC + size * 2);

      for (int r = minR + size; r < minR + size * 2; ++r) {
        for (int c = minC + size; c < minC + size * 2; ++c) {
          grid[r][c] = '.';
        }
      }
    }
  }
}