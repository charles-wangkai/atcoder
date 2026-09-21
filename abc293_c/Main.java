import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

  static int solve(int[][] A) {
    return search(A, new HashSet<>(), 0, 0);
  }

  static int search(int[][] A, Set<Integer> seen, int r, int c) {
    int H = A.length;
    int W = A[0].length;

    if (r == H || c == W || seen.contains(A[r][c])) {
      return 0;
    }
    if (r == H - 1 && c == W - 1) {
      return 1;
    }

    seen.add(A[r][c]);

    int result = search(A, seen, r, c + 1) + search(A, seen, r + 1, c);

    seen.remove(A[r][c]);

    return result;
  }
}