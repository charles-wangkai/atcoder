import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int[][] A = new int[H][W];
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        A[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[][] A) {
    return Arrays.stream(A)
        .map(
            line ->
                Arrays.stream(line)
                    .mapToObj(x -> (x == 0) ? '.' : ((char) ('A' + x - 1)))
                    .map(String::valueOf)
                    .collect(Collectors.joining()))
        .collect(Collectors.joining("\n"));
  }
}