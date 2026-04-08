import java.util.Scanner;

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
    char[][] B = new char[N][N];
    for (int r = 0; r < N; ++r) {
      String line = sc.next();
      for (int c = 0; c < N; ++c) {
        B[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static String solve(char[][] A, char[][] B) {
    int N = A.length;

    for (int r = 0; ; ++r) {
      for (int c = 0; c < N; ++c) {
        if (A[r][c] != B[r][c]) {
          return "%d %d".formatted(r + 1, c + 1);
        }
      }
    }
  }
}