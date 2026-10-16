import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] T = new int[N];
    int[][] A = new int[N][];
    for (int i = 0; i < N; ++i) {
      T[i] = sc.nextInt();
      int K = sc.nextInt();
      A[i] = new int[K];
      for (int j = 0; j < A[i].length; ++j) {
        A[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(T, A));

    sc.close();
  }

  static long solve(int[] T, int[][] A) {
    int N = T.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[N];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < A.length; ++i) {
      for (int Aij : A[i]) {
        adjLists[i].add(Aij - 1);
      }
    }

    boolean[] learned = new boolean[N];
    search(learned, adjLists, N - 1);

    return IntStream.range(0, learned.length)
        .filter(i -> learned[i])
        .map(i -> T[i])
        .asLongStream()
        .sum();
  }

  static void search(boolean[] learned, List<Integer>[] adjLists, int node) {
    learned[node] = true;

    for (int adj : adjLists[node]) {
      if (!learned[adj]) {
        search(learned, adjLists, adj);
      }
    }
  }
}