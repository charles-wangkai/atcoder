import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    int[] C = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      C[i] = sc.nextInt();
    }

    System.out.println(solve(A, C));

    sc.close();
  }

  static int solve(int[] A, int[] C) {
    Map<Integer, Integer> colorToMinDeliciousness = new HashMap<>();
    for (int i = 0; i < A.length; ++i) {
      colorToMinDeliciousness.put(
          C[i], Math.min(colorToMinDeliciousness.getOrDefault(C[i], Integer.MAX_VALUE), A[i]));
    }

    return colorToMinDeliciousness.values().stream().mapToInt(Integer::intValue).max().getAsInt();
  }
}