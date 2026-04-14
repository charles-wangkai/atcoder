import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static String solve(int[] A, int[] B) {
    return IntStream.range(0, A.length)
        .map(i -> A[i] + B[i])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}