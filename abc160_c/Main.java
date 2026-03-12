import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(K, A));

    sc.close();
  }

  static int solve(int K, int[] A) {
    return K
        - IntStream.range(0, A.length)
            .map(i -> computeDistance(K, A[i], A[(i + 1) % A.length]))
            .max()
            .getAsInt();
  }

  static int computeDistance(int K, int pos1, int pos2) {
    int diff = Math.abs(pos1 - pos2);

    return Math.min(diff, K - diff);
  }
}