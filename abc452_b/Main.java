import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();

    System.out.println(solve(H, W));

    sc.close();
  }

  static String solve(int H, int W) {
    char[][] result = new char[H][W];
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        result[r][c] = (r == 0 || r == H - 1 || c == 0 || c == W - 1) ? '#' : '.';
      }
    }

    return Arrays.stream(result).map(String::valueOf).collect(Collectors.joining("\n"));
  }
}