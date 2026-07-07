import java.util.ArrayList;
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

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, A.length).boxed().collect(Collectors.toMap(i -> A[i], i -> i));

    List<String> operations = new ArrayList<>();
    for (int i = 0; i < A.length; ++i) {
      if (A[i] != i + 1) {
        int index = valueToIndex.get(i + 1);

        valueToIndex.put(A[index], i);
        valueToIndex.put(A[i], index);

        int temp = A[i];
        A[i] = A[index];
        A[index] = temp;

        operations.add("%d %d".formatted(i + 1, index + 1));
      }
    }

    return "%d\n%s".formatted(operations.size(), String.join("\n", operations));
  }
}