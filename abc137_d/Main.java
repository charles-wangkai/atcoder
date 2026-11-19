import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      int[] A = new int[N];
      int[] B = new int[N];
      for (int i = 0; i < N; ++i) {
        A[i] = sc.nextInt();
        B[i] = sc.nextInt();
      }

      System.out.println(solve(A, B, M));
    }
  }

  static int solve(int[] A, int[] B, int M) {
    @SuppressWarnings("unchecked")
    List<Integer>[] rewardLists = new List[M];
    for (int i = 0; i < rewardLists.length; ++i) {
      rewardLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < A.length; ++i) {
      if (A[i] <= M) {
        rewardLists[M - A[i]].add(B[i]);
      }
    }

    int result = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = rewardLists.length - 1; i >= 0; --i) {
      pq.addAll(rewardLists[i]);
      if (!pq.isEmpty()) {
        result += pq.poll();
      }
    }

    return result;
  }
}