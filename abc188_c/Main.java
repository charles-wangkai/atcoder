import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[1 << N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static int solve(int[] A) {
    int[] indices = IntStream.range(0, A.length).toArray();
    while (indices.length != 2) {
      int[] indices_ = indices;
      indices =
          IntStream.range(0, indices.length / 2)
              .map(
                  i ->
                      (A[indices_[i * 2]] > A[indices_[i * 2 + 1]])
                          ? indices_[i * 2]
                          : indices_[i * 2 + 1])
              .toArray();
    }

    return (A[indices[0]] < A[indices[1]]) ? (indices[0] + 1) : (indices[1] + 1);
  }
}