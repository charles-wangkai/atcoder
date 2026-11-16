import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] A = new int[N];
      for (int i = 0; i < A.length; ++i) {
        A[i] = sc.nextInt();
      }

      System.out.println(solve(A));
    }
  }

  static String solve(int[] A) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.offer(A[0]);
    pq.offer(A[1]);

    int[] result = new int[A.length - 2];
    for (int i = 0; i < result.length; ++i) {
      if (pq.size() == 2 || A[i + 2] > pq.peek()) {
        pq.offer(A[i + 2]);
      }
      if (pq.size() == 4) {
        pq.poll();
      }

      result[i] = pq.peek();
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}