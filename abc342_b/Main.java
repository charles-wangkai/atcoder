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
    int Q = sc.nextInt();
    int[] A = new int[Q];
    int[] B = new int[Q];
    for (int i = 0; i < Q; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(P, A, B));

    sc.close();
  }

  static String solve(int[] P, int[] A, int[] B) {
    Map<Integer, Integer> personToIndex =
        IntStream.range(0, P.length).boxed().collect(Collectors.toMap(i -> P[i], i -> i));

    return IntStream.range(0, A.length)
        .map(i -> (personToIndex.get(A[i]) < personToIndex.get(B[i])) ? A[i] : B[i])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}