import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] A = new int[N][];
    for (int i = 0; i < A.length; ++i) {
      int C = sc.nextInt();
      A[i] = new int[C];
      for (int j = 0; j < A[i].length; ++j) {
        A[i][j] = sc.nextInt();
      }
    }
    int X = sc.nextInt();

    System.out.println(solve(A, X));

    sc.close();
  }

  static String solve(int[][] A, int X) {
    int[] indices =
        IntStream.range(0, A.length)
            .filter(i -> Arrays.stream(A[i]).anyMatch(Aij -> Aij == X))
            .toArray();

    int[] B;
    if (indices.length == 0) {
      B = new int[0];
    } else {
      int minC = Arrays.stream(indices).map(index -> A[index].length).min().getAsInt();
      B =
          Arrays.stream(indices)
              .filter(index -> A[index].length == minC)
              .map(index -> index + 1)
              .toArray();
    }

    return "%d\n%s"
        .formatted(
            B.length, Arrays.stream(B).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}