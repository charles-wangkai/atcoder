import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] x = new int[N];
    int[] y = new int[N];
    for (int i = 0; i < N; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println("%.9f".formatted(solve(x, y)));

    sc.close();
  }

  static double solve(int[] x, int[] y) {
    List<Double> pathLengths = new ArrayList<>();
    search(pathLengths, x, y, IntStream.range(0, x.length).toArray(), 0);

    return pathLengths.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
  }

  static void search(List<Double> pathLengths, int[] x, int[] y, int[] indices, int depth) {
    if (depth == indices.length) {
      pathLengths.add(
          IntStream.range(0, indices.length - 1)
              .mapToDouble(
                  i ->
                      Math.sqrt(
                          (x[indices[i]] - x[indices[i + 1]]) * (x[indices[i]] - x[indices[i + 1]])
                              + (y[indices[i]] - y[indices[i + 1]])
                                  * (y[indices[i]] - y[indices[i + 1]])))
              .sum());

      return;
    }

    for (int i = depth; i < indices.length; ++i) {
      swap(indices, i, depth);
      search(pathLengths, x, y, indices, depth + 1);
      swap(indices, i, depth);
    }
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }
}