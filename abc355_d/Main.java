import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] l = new int[N];
      int[] r = new int[N];
      for (int i = 0; i < N; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(l, r));
    }
  }

  static long solve(int[] l, int[] r) {
    int[] sortedIndices =
        IntStream.range(0, l.length)
            .boxed()
            .sorted(Comparator.comparing(i -> l[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    long result = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int index : sortedIndices) {
      while (!pq.isEmpty() && pq.peek() < l[index]) {
        pq.poll();
      }

      result += pq.size();

      pq.offer(r[index]);
    }

    return result;
  }
}