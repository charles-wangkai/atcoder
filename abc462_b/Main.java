import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] A = new int[N][];
    for (int i = 0; i < A.length; ++i) {
      int K = sc.nextInt();
      A[i] = new int[K];
      for (int j = 0; j < A[i].length; ++j) {
        A[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[][] A) {
    int N = A.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] fromLists = new List[N];
    for (int i = 0; i < fromLists.length; ++i) {
      fromLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < A.length; ++i) {
      for (int Aij : A[i]) {
        fromLists[Aij - 1].add(i);
      }
    }

    return Arrays.stream(fromLists)
        .map(
            fromList ->
                "%d %s"
                    .formatted(
                        fromList.size(),
                        fromList.stream()
                            .map(x -> x + 1)
                            .map(String::valueOf)
                            .collect(Collectors.joining(" "))))
        .collect(Collectors.joining("\n"));
  }
}