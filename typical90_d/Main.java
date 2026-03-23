import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    int H = A.length;
    int W = A[0].length;

    int[] rowSums =
        IntStream.range(0, H).map(r -> IntStream.range(0, W).map(c -> A[r][c]).sum()).toArray();
    int[] colSums =
        IntStream.range(0, W).map(c -> IntStream.range(0, H).map(r -> A[r][c]).sum()).toArray();

    return IntStream.range(0, H)
        .mapToObj(
            r ->
                IntStream.range(0, W)
                    .map(c -> rowSums[r] + colSums[c] - A[r][c])
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}