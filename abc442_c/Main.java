import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[M];
    int[] B = new int[M];
    for (int i = 0; i < M; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(N, A, B));

    sc.close();
  }

  static String solve(int N, int[] A, int[] B) {
    int[] reviewerNums = new int[N];
    Arrays.fill(reviewerNums, N - 1);
    for (int i = 0; i < A.length; ++i) {
      --reviewerNums[A[i] - 1];
      --reviewerNums[B[i] - 1];
    }

    return Arrays.stream(reviewerNums)
        .mapToLong(reviewerNum -> reviewerNum * (reviewerNum - 1L) * (reviewerNum - 2) / 6)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}