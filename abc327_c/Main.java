import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[][] A = new int[9][9];
    for (int r = 0; r < 9; ++r) {
      for (int c = 0; c < 9; ++c) {
        A[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(A) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[][] A) {
    for (int r = 0; r < 9; ++r) {
      if (!check(A[r])) {
        return false;
      }
    }

    for (int c = 0; c < 9; ++c) {
      int c_ = c;
      if (!check(IntStream.range(0, 9).map(r -> A[r][c_]).toArray())) {
        return false;
      }
    }

    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        int i_ = i;
        int j_ = j;
        if (!check(IntStream.range(0, 9).map(k -> A[i_ * 3 + k / 3][j_ * 3 + k % 3]).toArray())) {
          return false;
        }
      }
    }

    return true;
  }

  static boolean check(int[] values) {
    return Arrays.stream(values).distinct().count() == 9;
  }
}