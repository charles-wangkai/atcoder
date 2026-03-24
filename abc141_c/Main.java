import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int Q = sc.nextInt();
    int[] A = new int[Q];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(N, K, A));

    sc.close();
  }

  static String solve(int N, int K, int[] A) {
    int[] points = new int[N];
    Arrays.fill(points, K);
    for (int Ai : A) {
      ++points[Ai - 1];
    }

    return IntStream.range(0, points.length)
        .mapToObj(i -> (points[i] > A.length) ? "Yes" : "No")
        .collect(Collectors.joining("\n"));
  }
}