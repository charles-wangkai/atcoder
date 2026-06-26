import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] P = new int[N];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }
    int[] Q = new int[N];
    for (int i = 0; i < Q.length; ++i) {
      Q[i] = sc.nextInt();
    }

    System.out.println(solve(P, Q));

    sc.close();
  }

  static String solve(int[] P, int[] Q) {
    int N = P.length;

    Map<Integer, Integer> bibToIndex =
        IntStream.range(0, N).boxed().collect(Collectors.toMap(i -> Q[i], i -> i));

    return IntStream.rangeClosed(1, N)
        .map(bib -> Q[P[bibToIndex.get(bib)] - 1])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}