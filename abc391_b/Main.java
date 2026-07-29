import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    char[][] S = new char[N][N];
    for (int r = 0; r < N; ++r) {
      String line = sc.next();
      for (int c = 0; c < N; ++c) {
        S[r][c] = line.charAt(c);
      }
    }
    char[][] T = new char[M][M];
    for (int r = 0; r < M; ++r) {
      String line = sc.next();
      for (int c = 0; c < M; ++c) {
        T[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(S, T));

    sc.close();
  }

  static String solve(char[][] S, char[][] T) {
    int N = S.length;
    int M = T.length;

    for (int beginR = 0; ; ++beginR) {
      for (int beginC = 0; beginC <= N - M; ++beginC) {
        if (isMatch(S, T, beginR, beginC)) {
          return "%d %d".formatted(beginR + 1, beginC + 1);
        }
      }
    }
  }

  static boolean isMatch(char[][] S, char[][] T, int beginR, int beginC) {
    int M = T.length;

    for (int r = 0; r < M; ++r) {
      for (int c = 0; c < M; ++c) {
        if (S[beginR + r][beginC + c] != T[r][c]) {
          return false;
        }
      }
    }

    return true;
  }
}