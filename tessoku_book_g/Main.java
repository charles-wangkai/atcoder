import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int D = sc.nextInt();
    int N = sc.nextInt();
    int[] L = new int[N];
    int[] R = new int[N];
    for (int i = 0; i < N; ++i) {
      L[i] = sc.nextInt();
      R[i] = sc.nextInt();
    }

    System.out.println(solve(D, L, R));

    sc.close();
  }

  static String solve(int D, int[] L, int[] R) {
    int[] deltas = new int[D + 1];
    for (int i = 0; i < L.length; ++i) {
      ++deltas[L[i] - 1];
      --deltas[R[i]];
    }

    int[] result = new int[D];
    int eventCount = 0;
    for (int i = 0; i < result.length; ++i) {
      eventCount += deltas[i];
      result[i] = eventCount;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}