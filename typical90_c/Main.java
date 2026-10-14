import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N - 1];
    int[] B = new int[N - 1];
    for (int i = 0; i < N - 1; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(int[] A, int[] B) {
    int N = A.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[N];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < A.length; ++i) {
      adjLists[A[i] - 1].add(B[i] - 1);
      adjLists[B[i] - 1].add(A[i] - 1);
    }

    return findDiameter(adjLists) + 1;
  }

  static int findDiameter(List<Integer>[] adjLists) {
    int[] distances = computeDistances(adjLists, 0);
    int nodeWithMaxDistance =
        IntStream.range(0, distances.length)
            .boxed()
            .max(Comparator.comparing(i -> distances[i]))
            .get();

    return Arrays.stream(computeDistances(adjLists, nodeWithMaxDistance)).max().getAsInt();
  }

  static int[] computeDistances(List<Integer>[] adjLists, int fromNode) {
    int N = adjLists.length;

    int[] distances = new int[N];
    Arrays.fill(distances, -1);
    distances[fromNode] = 0;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(fromNode);

    while (!queue.isEmpty()) {
      int head = queue.poll();
      for (int adj : adjLists[head]) {
        if (distances[adj] == -1) {
          distances[adj] = distances[head] + 1;
          queue.offer(adj);
        }
      }
    }

    return distances;
  }
}