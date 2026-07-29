import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[M];
    int[] B = new int[M];
    for (int i = 0; i < M; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(N, A, B));

    sc.close();
  }

  static String solve(int N, int[] A, int[] B) {
    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[N];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < A.length; ++i) {
      adjLists[A[i] - 1].add(B[i] - 1);
      adjLists[B[i] - 1].add(A[i] - 1);
    }

    int[] froms = new int[N];
    Arrays.fill(froms, Integer.MAX_VALUE);
    froms[0] = -1;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(0);

    while (!queue.isEmpty()) {
      int head = queue.poll();
      for (int adj : adjLists[head]) {
        if (froms[adj] == Integer.MAX_VALUE) {
          froms[adj] = head;
          queue.offer(adj);
        }
      }
    }

    return IntStream.range(1, froms.length).anyMatch(i -> froms[i] == Integer.MAX_VALUE)
        ? "No"
        : "Yes\n%s"
            .formatted(
                IntStream.range(1, froms.length)
                    .map(i -> froms[i] + 1)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("\n")));
  }
}