import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int X = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, K, X));

    sc.close();
  }

  static String solve(int[] A, int K, int X) {
    return IntStream.concat(
            IntStream.concat(IntStream.range(0, K).map(i -> A[i]), IntStream.of(X)),
            IntStream.range(K, A.length).map(i -> A[i]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}