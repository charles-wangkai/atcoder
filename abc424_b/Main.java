import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int K = sc.nextInt();
    int[] A = new int[K];
    int[] B = new int[K];
    for (int i = 0; i < K; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(N, M, A, B));

    sc.close();
  }

  static String solve(int N, int M, int[] A, int[] B) {
    List<Integer> result = new ArrayList<>();
    int[] solvedCounts = new int[N];
    for (int i = 0; i < A.length; ++i) {
      ++solvedCounts[A[i] - 1];
      if (solvedCounts[A[i] - 1] == M) {
        result.add(A[i]);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}