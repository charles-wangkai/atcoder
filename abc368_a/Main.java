import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, K));

    sc.close();
  }

  static String solve(int[] A, int K) {
    return IntStream.concat(
            IntStream.range(0, K).map(i -> A[A.length - K + i]),
            IntStream.range(0, A.length - K).map(i -> A[i]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}