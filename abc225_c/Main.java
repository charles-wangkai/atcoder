import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[][] B = new int[N][M];
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < M; ++c) {
        B[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(B) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[][] B) {
    int N = B.length;
    int M = B[0].length;

    return IntStream.range(0, M)
            .allMatch(c -> IntStream.range(0, N - 1).allMatch(r -> B[r][c] + 7 == B[r + 1][c]))
        && IntStream.range(0, M - 1)
            .allMatch(
                c -> B[0][c] + 1 == B[0][c + 1] && (B[0][c] - 1) % 7 + 1 == (B[0][c + 1] - 1) % 7);
  }
}