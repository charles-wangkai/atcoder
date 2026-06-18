import java.util.Arrays;
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
    boolean[] called = new boolean[A.length];
    for (int i = 0; i < A.length; ++i) {
      if (!called[i]) {
        called[A[i] - 1] = true;
      }
    }

    int[] X = IntStream.range(0, called.length).filter(i -> !called[i]).map(i -> i + 1).toArray();

    return "%d\n%s"
        .formatted(
            X.length, Arrays.stream(X).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}