import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[M];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(N, A));

    sc.close();
  }

  static String solve(int N, int[] A) {
    Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());
    int[] X = IntStream.rangeClosed(1, N).filter(x -> !set.contains(x)).toArray();

    return "%d\n%s"
        .formatted(
            X.length, Arrays.stream(X).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}