import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int Q = sc.nextInt();
    int[] L = new int[Q];
    int[] R = new int[Q];
    int[] X = new int[Q];
    for (int i = 0; i < Q; ++i) {
      L[i] = sc.nextInt();
      R[i] = sc.nextInt();
      X[i] = sc.nextInt();
    }

    System.out.println(solve(A, L, R, X));

    sc.close();
  }

  static String solve(int[] A, int[] L, int[] R, int[] X) {
    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < A.length; ++i) {
      valueToIndices.putIfAbsent(A[i], new ArrayList<>());
      valueToIndices.get(A[i]).add(i);
    }

    return IntStream.range(0, L.length)
        .map(
            i ->
                findMaxIndex(valueToIndices.getOrDefault(X[i], List.of()), R[i] - 1)
                    - findMinIndex(valueToIndices.getOrDefault(X[i], List.of()), L[i] - 1)
                    + 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static int findMaxIndex(List<Integer> indices, int rightIndex) {
    int result = -1;
    int lower = 0;
    int upper = indices.size() - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (indices.get(middle) <= rightIndex) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static int findMinIndex(List<Integer> indices, int leftIndex) {
    int result = indices.size();
    int lower = 0;
    int upper = indices.size() - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (indices.get(middle) >= leftIndex) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }
}