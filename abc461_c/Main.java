import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int M = sc.nextInt();
    int[] C = new int[N];
    int[] V = new int[N];
    for (int i = 0; i < N; ++i) {
      C[i] = sc.nextInt();
      V[i] = sc.nextInt();
    }

    System.out.println(solve(C, V, K, M));

    sc.close();
  }

  static long solve(int[] C, int[] V, int K, int M) {
    Map<Integer, List<Integer>> colorToValues = new HashMap<>();
    for (int i = 0; i < C.length; ++i) {
      colorToValues.putIfAbsent(C[i], new ArrayList<>());
      colorToValues.get(C[i]).add(V[i]);
    }

    PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
    for (List<Integer> values : colorToValues.values()) {
      Collections.sort(values, Comparator.reverseOrder());

      for (int i = 0; i < values.size(); ++i) {
        ((i == 0) ? pq1 : pq2).offer(values.get(i));
      }
    }

    long result = 0;
    for (int i = 0; i < M; ++i) {
      result += pq1.poll();
    }
    pq2.addAll(pq1);
    for (int i = 0; i < K - M; ++i) {
      result += pq2.poll();
    }

    return result;
  }
}