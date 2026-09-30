import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    char[][] image = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        image[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(image));

    sc.close();
  }

  static String solve(char[][] image) {
    int H = image.length;
    int W = image[0].length;

    int minR = Integer.MAX_VALUE;
    int maxR = Integer.MIN_VALUE;
    int minC = Integer.MAX_VALUE;
    int maxC = Integer.MIN_VALUE;
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if (image[r][c] == '#') {
          minR = Math.min(minR, r);
          maxR = Math.max(maxR, r);
          minC = Math.min(minC, c);
          maxC = Math.max(maxC, c);
        }
      }
    }

    char[][] result = new char[maxR - minR + 1][maxC - minC + 1];
    for (int r = 0; r < result.length; ++r) {
      for (int c = 0; c < result[r].length; ++c) {
        result[r][c] = image[minR + r][minC + c];
      }
    }

    return Arrays.stream(result).map(String::valueOf).collect(Collectors.joining("\n"));
  }
}