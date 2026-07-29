import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int Q = sc.nextInt();
    String S = sc.next();
    int[] l = new int[Q];
    int[] r = new int[Q];
    for (int i = 0; i < Q; ++i) {
      l[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }

    System.out.println(solve(S, l, r));

    sc.close();
  }

  static String solve(String S, int[] l, int[] r) {
    int[] prefixSameCounts = new int[S.length()];
    for (int i = 1; i < prefixSameCounts.length; ++i) {
      prefixSameCounts[i] = prefixSameCounts[i - 1] + ((S.charAt(i - 1) == S.charAt(i)) ? 1 : 0);
    }

    return IntStream.range(0, l.length)
        .map(i -> prefixSameCounts[r[i] - 1] - prefixSameCounts[l[i] - 1])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}