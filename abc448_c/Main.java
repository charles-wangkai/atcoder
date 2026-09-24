import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[][] B = new int[Q][];
    for (int i = 0; i < B.length; ++i) {
      int K = sc.nextInt();
      B[i] = new int[K];
      for (int j = 0; j < B[i].length; ++j) {
        B[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static String solve(int[] A, int[][] B) {
    SortedMap<Integer, Integer> valueToCount = new TreeMap<>();
    for (int Ai : A) {
      updateMap(valueToCount, Ai, 1);
    }

    int[] result = new int[B.length];
    for (int i = 0; i < result.length; ++i) {
      for (int Bij : B[i]) {
        updateMap(valueToCount, A[Bij - 1], -1);
      }

      result[i] = valueToCount.firstKey();

      for (int Bij : B[i]) {
        updateMap(valueToCount, A[Bij - 1], 1);
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }

  static void updateMap(SortedMap<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}