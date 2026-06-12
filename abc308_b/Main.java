import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    String[] C = new String[N];
    for (int i = 0; i < C.length; ++i) {
      C[i] = sc.next();
    }
    String[] D = new String[M];
    for (int i = 0; i < D.length; ++i) {
      D[i] = sc.next();
    }
    int[] P = new int[M + 1];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }

    System.out.println(solve(C, D, P));

    sc.close();
  }

  static int solve(String[] C, String[] D, int[] P) {
    Map<String, Integer> colorToPrice =
        IntStream.range(0, D.length).boxed().collect(Collectors.toMap(i -> D[i], i -> P[i + 1]));

    return Arrays.stream(C).mapToInt(color -> colorToPrice.getOrDefault(color, P[0])).sum();
  }
}