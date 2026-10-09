import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] R = new int[M];
    int[] C = new int[M];
    for (int i = 0; i < M; ++i) {
      R[i] = sc.nextInt();
      C[i] = sc.nextInt();
    }

    System.out.println(solve(N, R, C));

    sc.close();
  }

  static int solve(int N, int[] R, int[] C) {
    Set<Point> placed = new HashSet<>();
    for (int i = 0; i < R.length; ++i) {
      if (!isOverlap(placed, R[i], C[i])) {
        for (int dr = 0; dr < 2; ++dr) {
          for (int dc = 0; dc < 2; ++dc) {
            placed.add(new Point(R[i] + dr, C[i] + dc));
          }
        }
      }
    }

    return placed.size() / 4;
  }

  static boolean isOverlap(Set<Point> placed, int minR, int minC) {
    for (int dr = 0; dr < 2; ++dr) {
      for (int dc = 0; dc < 2; ++dc) {
        if (placed.contains(new Point(minR + dr, minC + dc))) {
          return true;
        }
      }
    }

    return false;
  }
}

record Point(int r, int c) {}
