import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int Y = sc.nextInt();
    int Z = sc.nextInt();
    int K = sc.nextInt();
    long[] A = new long[X];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextLong();
    }
    long[] B = new long[Y];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextLong();
    }
    long[] C = new long[Z];
    for (int i = 0; i < C.length; ++i) {
      C[i] = sc.nextLong();
    }

    System.out.println(solve(A, B, C, K));

    sc.close();
  }

  static String solve(long[] A, long[] B, long[] C, int K) {
    long[] sortedA = reversedSort(A);
    long[] sortedB = reversedSort(B);
    long[] sortedC = reversedSort(C);

    List<Long> result = new ArrayList<>();
    Element initial = new Element(0, 0, 0);
    Set<Element> seen = new HashSet<>();
    seen.add(initial);
    PriorityQueue<Element> pq =
        new PriorityQueue<>(
            Comparator.<Element, Long>comparing(
                    element ->
                        sortedA[element.indexA()]
                            + sortedB[element.indexB()]
                            + sortedC[element.indexC()])
                .reversed());
    pq.offer(initial);

    while (result.size() != K) {
      Element head = pq.poll();
      result.add(sortedA[head.indexA()] + sortedB[head.indexB()] + sortedC[head.indexC()]);

      for (Element candidate :
          new Element[] {
            new Element(head.indexA() + 1, head.indexB(), head.indexC()),
            new Element(head.indexA(), head.indexB() + 1, head.indexC()),
            new Element(head.indexA(), head.indexB(), head.indexC() + 1)
          }) {
        if (candidate.indexA() != A.length
            && candidate.indexB() != B.length
            && candidate.indexC() != C.length
            && !seen.contains(candidate)) {
          seen.add(candidate);
          pq.offer(candidate);
        }
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static long[] reversedSort(long[] values) {
    return Arrays.stream(values)
        .boxed()
        .sorted(Collections.reverseOrder())
        .mapToLong(Long::longValue)
        .toArray();
  }
}

record Element(int indexA, int indexB, int indexC) {}
