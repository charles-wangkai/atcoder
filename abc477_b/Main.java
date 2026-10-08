import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int D = sc.nextInt();
    int[] X = new int[N];
    for (int i = 0; i < X.length; ++i) {
      X[i] = sc.nextInt();
    }

    System.out.println(solve(X, D));

    sc.close();
  }

  static String solve(int[] X, int D) {
    int[] indices =
        IntStream.range(0, X.length)
            .filter(
                i ->
                    IntStream.range(0, X.length)
                        .allMatch(j -> j == i || Math.abs(X[j] - X[i]) >= D))
            .toArray();

    return "%d\n%s"
        .formatted(
            indices.length,
            Arrays.stream(indices)
                .map(index -> index + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}