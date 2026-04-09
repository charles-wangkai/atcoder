import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    int[] C = new int[N];
    for (int i = 0; i < N; ++i) {
      S[i] = sc.next();
      C[i] = sc.nextInt();
    }

    System.out.println(solve(S, C));

    sc.close();
  }

  static String solve(String[] S, int[] C) {
    int[] sortedIndices =
        IntStream.range(0, S.length)
            .boxed()
            .sorted(Comparator.comparing(i -> S[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    return S[sortedIndices[Arrays.stream(C).sum() % S.length]];
  }
}