import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[7 * N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    int N = A.length / 7;

    return IntStream.range(0, N)
        .map(i -> IntStream.range(i * 7, (i + 1) * 7).map(j -> A[j]).sum())
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}