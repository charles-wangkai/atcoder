import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    char[][] grid = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        grid[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(grid));

    sc.close();
  }

  static String solve(char[][] grid) {
    int H = grid.length;
    int W = grid[0].length;

    return IntStream.range(0, W)
        .map(c -> (int) IntStream.range(0, H).filter(r -> grid[r][c] == '#').count())
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}