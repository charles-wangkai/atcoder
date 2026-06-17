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
    return IntStream.range(0, A.length)
        .flatMap(
            i -> {
              if (i == 0) {
                return IntStream.of(A[0]);
              }

              return (A[i] > A[i - 1])
                  ? IntStream.rangeClosed(A[i - 1] + 1, A[i])
                  : IntStream.iterate(A[i - 1] - 1, x -> x >= A[i], x -> x - 1);
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}