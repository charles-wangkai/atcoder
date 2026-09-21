import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] P = new int[N];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }

    System.out.println(solve(P, K));

    sc.close();
  }

  static String solve(int[] P, int K) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < K - 1; ++i) {
      pq.offer(P[i]);
    }

    List<Integer> result = new ArrayList<>();
    for (int i = K - 1; i < P.length; ++i) {
      pq.offer(P[i]);
      if (pq.size() == K + 1) {
        pq.poll();
      }

      result.add(pq.peek());
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}