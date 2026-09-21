import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

  static String solve(int[] A, int[] B) {
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
    for (List<Integer> adjList : adjLists) {
      Collections.sort(adjList);
    }

    List<Integer> sequence = new ArrayList<>();
    search(sequence, adjLists, -1, 0);

    return sequence.stream()
        .map(node -> node + 1)
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static void search(List<Integer> sequence, List<Integer>[] adjLists, int parent, int node) {
    sequence.add(node);

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search(sequence, adjLists, node, adj);
        sequence.add(node);
      }
    }
  }
}