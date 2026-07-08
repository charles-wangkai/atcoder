import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    char[][] A = new char[N][N];
    for (int r = 0; r < N; ++r) {
      String line = sc.next();
      for (int c = 0; c < N; ++c) {
        A[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(char[][] A) {
    int N = A.length;

    char[][] result = new char[N][N];
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        if (r == 0 && c != 0) {
          result[r][c] = A[r][c - 1];
        } else if (c == N - 1 && r != 0) {
          result[r][c] = A[r - 1][c];
        } else if (r == N - 1 && c != N - 1) {
          result[r][c] = A[r][c + 1];
        } else if (c == 0 && c != N - 1) {
          result[r][c] = A[r + 1][c];
        } else {
          result[r][c] = A[r][c];
        }
      }
    }

    return Arrays.stream(result).map(String::valueOf).collect(Collectors.joining("\n"));
  }
}