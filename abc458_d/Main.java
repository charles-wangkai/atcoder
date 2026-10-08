import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int Q = sc.nextInt();
    int[] A = new int[Q];
    int[] B = new int[Q];
    for (int i = 0; i < Q; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(X, A, B));

    sc.close();
  }

  static String solve(int X, int[] A, int[] B) {
    PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());

    PriorityQueue<Integer> upper = new PriorityQueue<>();
    upper.offer(X);

    int[] result = new int[A.length];
    for (int i = 0; i < result.length; ++i) {
      for (int value : new int[] {A[i], B[i]}) {
        ((value >= upper.peek()) ? upper : lower).offer(value);

        if (lower.size() + 2 == upper.size()) {
          lower.offer(upper.poll());
        } else if (lower.size() == upper.size() + 1) {
          upper.offer(lower.poll());
        }
      }

      result[i] = upper.peek();
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}