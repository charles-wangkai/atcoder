import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();

    System.out.println(solve(H, W));

    sc.close();
  }

  static String solve(int H, int W) {
    int[][] x = new int[H][W];
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        int r_ = r;
        int c_ = c;
        x[r][c] =
            (int)
                IntStream.range(0, R_OFFSETS.length)
                    .filter(
                        i -> {
                          int adjR = r_ + R_OFFSETS[i];
                          int adjC = c_ + C_OFFSETS[i];

                          return adjR >= 0 && adjR < H && adjC >= 0 && adjC < W;
                        })
                    .count();
      }
    }

    return Arrays.stream(x)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}