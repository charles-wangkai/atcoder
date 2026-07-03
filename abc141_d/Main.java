import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, M));

    sc.close();
  }

  static long solve(int[] A, int M) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int Ai : A) {
      pq.offer(Ai);
    }

    for (int i = 0; i < M; ++i) {
      pq.offer(pq.poll() / 2);
    }

    return pq.stream().mapToInt(Integer::intValue).asLongStream().sum();
  }
}