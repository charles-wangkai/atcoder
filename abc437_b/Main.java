import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int N = sc.nextInt();
    int[][] A = new int[H][W];
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        A[r][c] = sc.nextInt();
      }
    }
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(int[][] A, int[] B) {
    int H = A.length;
    int W = A[0].length;

    Map<Integer, Integer> valueToRow = new HashMap<>();
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        valueToRow.put(A[r][c], r);
      }
    }

    int[] counts = new int[H];
    for (int Bi : B) {
      if (valueToRow.containsKey(Bi)) {
        ++counts[valueToRow.get(Bi)];
      }
    }

    return Arrays.stream(counts).max().getAsInt();
  }
}