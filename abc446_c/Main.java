import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int T = sc.nextInt();
      for (int tc = 0; tc < T; ++tc) {
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; ++i) {
          A[i] = sc.nextInt();
        }
        int[] B = new int[N];
        for (int i = 0; i < B.length; ++i) {
          B[i] = sc.nextInt();
        }

        System.out.println(solve(A, B, D));
      }
    }
  }

  static int solve(int[] A, int[] B, int D) {
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < A.length; ++i) {
      deque.offerLast(A[i]);

      int rest = B[i];
      while (rest != 0) {
        int head = deque.pollFirst();
        if (rest >= head) {
          rest -= head;
        } else {
          deque.offerFirst(head - rest);
          rest = 0;
        }
      }

      if (deque.size() == D + 1) {
        deque.pollFirst();
      }
    }

    return deque.stream().mapToInt(Integer::intValue).sum();
  }
}