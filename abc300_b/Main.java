import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    char[][] A = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        A[r][c] = line.charAt(c);
      }
    }
    char[][] B = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        B[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(A, B) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(char[][] A, char[][] B) {
    int H = A.length;
    int W = A[0].length;

    for (int rOffset = 0; rOffset < H; ++rOffset) {
      for (int cOffset = 0; cOffset < W; ++cOffset) {
        if (isMatch(A, B, rOffset, cOffset)) {
          return true;
        }
      }
    }

    return false;
  }

  static boolean isMatch(char[][] A, char[][] B, int rOffset, int cOffset) {
    int H = A.length;
    int W = A[0].length;

    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if (A[r][c] != B[(r + rOffset) % H][(c + cOffset) % W]) {
          return false;
        }
      }
    }

    return true;
  }
}