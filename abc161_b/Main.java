import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, M) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] A, int M) {
    int[] sorted =
        Arrays.stream(A)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    return sorted[M - 1] * (4 * M) >= Arrays.stream(A).sum();
  }
}