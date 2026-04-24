import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] X = new int[N];
    int[] Y = new int[N];
    for (int i = 0; i < N; ++i) {
      X[i] = sc.nextInt();
      Y[i] = sc.nextInt();
    }

    System.out.println(solve(X, Y));

    sc.close();
  }

  static String solve(int[] X, int[] Y) {
    return IntStream.range(0, X.length)
        .map(
            i ->
                IntStream.range(0, X.length)
                        .boxed()
                        .max(
                            Comparator.<Integer, Integer>comparing(
                                    j ->
                                        (X[j] - X[i]) * (X[j] - X[i])
                                            + (Y[j] - Y[i]) * (Y[j] - Y[i]))
                                .thenComparing(
                                    Comparator.<Integer, Integer>comparing(j -> j).reversed()))
                        .get()
                    + 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}