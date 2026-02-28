import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    List<Integer> rows = new ArrayList<>();
    List<Integer> cols = new ArrayList<>();
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if (grid[r][c] == '#') {
          rows.add(r);
          cols.add(c);
        }
      }
    }

    int[] compressedRows = rows.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
    int[] compressedCols = cols.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();

    char[][] result = new char[compressedRows.length][compressedCols.length];
    for (int r = 0; r < compressedRows.length; ++r) {
      for (int c = 0; c < compressedCols.length; ++c) {
        result[r][c] = grid[compressedRows[r]][compressedCols[c]];
      }
    }

    return Arrays.stream(result).map(String::valueOf).collect(Collectors.joining("\n"));
  }
}