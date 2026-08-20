import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    Map<Integer, List<Integer>> valueToIndices = new TreeMap<>(Comparator.reverseOrder());
    for (int i = 0; i < A.length; ++i) {
      valueToIndices.putIfAbsent(A[i], new ArrayList<>());
      valueToIndices.get(A[i]).add(i);
    }

    long[] result = new long[A.length];
    long sum = 0;
    for (List<Integer> indices : valueToIndices.values()) {
      for (int index : indices) {
        result[index] = sum;
      }

      for (int index : indices) {
        sum += A[index];
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}