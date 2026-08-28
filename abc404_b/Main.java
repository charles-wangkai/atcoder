import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    char[][] S = new char[N][N];
    for (int r = 0; r < N; ++r) {
      String line = sc.next();
      for (int c = 0; c < N; ++c) {
        S[r][c] = line.charAt(c);
      }
    }
    char[][] T = new char[N][N];
    for (int r = 0; r < N; ++r) {
      String line = sc.next();
      for (int c = 0; c < N; ++c) {
        T[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(S, T));

    sc.close();
  }

  static int solve(char[][] S, char[][] T) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < 4; ++i) {
      result = Math.min(result, i + computeDiffNum(S, T));
      S = rotate(S);
    }

    return result;
  }

  static int computeDiffNum(char[][] S, char[][] T) {
    int N = S.length;

    int result = 0;
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        if (S[r][c] != T[r][c]) {
          ++result;
        }
      }
    }

    return result;
  }

  static char[][] rotate(char[][] S) {
    int N = S.length;

    char[][] result = new char[N][N];
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        result[r][c] = S[N - 1 - c][r];
      }
    }

    return result;
  }
}