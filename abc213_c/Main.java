import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int N = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(H, W, A, B));

    sc.close();
  }

  static String solve(int H, int W, int[] A, int[] B) {
    Map<Integer, Integer> rToCompressed = compress(A);
    Map<Integer, Integer> cToCompressed = compress(B);

    return IntStream.range(0, A.length)
        .mapToObj(i -> "%d %d".formatted(rToCompressed.get(A[i]), cToCompressed.get(B[i])))
        .collect(Collectors.joining("\n"));
  }

  static Map<Integer, Integer> compress(int[] values) {
    int[] sorted = Arrays.stream(values).sorted().distinct().toArray();

    return IntStream.range(0, sorted.length)
        .boxed()
        .collect(Collectors.toMap(i -> sorted[i], i -> i + 1));
  }
}