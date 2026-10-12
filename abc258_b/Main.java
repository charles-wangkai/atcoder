import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] A = new int[N][N];
    for (int r = 0; r < N; ++r) {
      String line = sc.next();
      for (int c = 0; c < N; ++c) {
        A[r][c] = line.charAt(c) - '0';
      }
    }

    System.out.println(solve(A));

    sc.close();
  }

  static long solve(int[][] A) {
    int N = A.length;

    long result = -1;
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        for (int dr = -1; dr <= 1; ++dr) {
          for (int dc = -1; dc <= 1; ++dc) {
            if (dr != 0 || dc != 0) {
              result = Math.max(result, buildValue(A, r, c, dr, dc));
            }
          }
        }
      }
    }

    return result;
  }

  static long buildValue(int[][] A, int r, int c, int dr, int dc) {
    int N = A.length;

    return Long.parseLong(
        IntStream.range(0, N)
            .map(i -> A[Math.floorMod(r + i * dr, N)][Math.floorMod(c + i * dc, N)])
            .mapToObj(String::valueOf)
            .collect(Collectors.joining()));
  }
}