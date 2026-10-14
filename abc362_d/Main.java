import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] U = new int[M];
    int[] V = new int[M];
    int[] B = new int[M];
    for (int i = 0; i < M; ++i) {
      U[i] = sc.nextInt();
      V[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, U, V, B));

    sc.close();
  }

  static String solve(int[] A, int[] U, int[] V, int[] B) {
    int N = A.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[N];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < U.length; ++i) {
      edgeLists[U[i] - 1].add(i);
      edgeLists[V[i] - 1].add(i);
    }

    long[] distances = new long[N];
    Arrays.fill(distances, -1);

    PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparing(Element::distance));
    pq.offer(new Element(0, A[0]));

    while (!pq.isEmpty()) {
      Element head = pq.poll();
      if (distances[head.node()] == -1) {
        distances[head.node()] = head.distance();

        for (int edge : edgeLists[head.node()]) {
          int other = (U[edge] - 1 == head.node()) ? (V[edge] - 1) : (U[edge] - 1);
          if (distances[other] == -1) {
            pq.offer(new Element(other, distances[head.node()] + B[edge] + A[other]));
          }
        }
      }
    }

    return IntStream.range(1, distances.length)
        .mapToLong(i -> distances[i])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}

record Element(int node, long distance) {}
