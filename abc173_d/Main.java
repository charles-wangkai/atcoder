import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static long solve(int[] A) {
    Arrays.sort(A);

    PriorityQueue<Segment> pq =
        new PriorityQueue<>(Comparator.comparing(Segment::getComfort).reversed());
    pq.offer(new Segment(A[A.length - 1], A[A.length - 1]));

    long result = 0;
    for (int i = A.length - 2; i >= 0; --i) {
      Segment segment = pq.poll();
      result += segment.getComfort();

      pq.offer(new Segment(A[i], segment.friendliness1()));
      pq.offer(new Segment(A[i], segment.friendliness2()));
    }

    return result;
  }
}

record Segment(int friendliness1, int friendliness2) {
  int getComfort() {
    return Math.min(friendliness1, friendliness2);
  }
}
