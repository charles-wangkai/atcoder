import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, M));

    sc.close();
  }

  static String solve(int[] A, int[] B, int M) {
    @SuppressWarnings("unchecked")
    List<Integer>[] sizeLists = new List[M];
    for (int i = 0; i < sizeLists.length; ++i) {
      sizeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < A.length; ++i) {
      sizeLists[A[i] - 1].add(B[i]);
    }

    return Arrays.stream(sizeLists)
        .mapToDouble(
            sizeList ->
                sizeList.stream()
                    .mapToInt(Integer::intValue)
                    .asDoubleStream()
                    .average()
                    .getAsDouble())
        .mapToObj(x -> "%.9f".formatted(x))
        .collect(Collectors.joining("\n"));
  }
}