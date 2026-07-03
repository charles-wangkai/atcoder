import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    int[] A = new int[N];
    for (int i = 0; i < N; ++i) {
      S[i] = sc.next();
      A[i] = sc.nextInt();
    }

    System.out.println(solve(S, A));

    sc.close();
  }

  static String solve(String[] S, int[] A) {
    int beginIndex =
        IntStream.range(0, A.length).boxed().min(Comparator.comparing(i -> A[i])).get();

    return IntStream.range(0, S.length)
        .mapToObj(i -> S[(beginIndex + i) % S.length])
        .collect(Collectors.joining("\n"));
  }
}