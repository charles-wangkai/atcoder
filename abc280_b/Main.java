import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] S = new int[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.nextInt();
    }

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(int[] S) {
    return IntStream.range(0, S.length)
        .map(i -> S[i] - ((i == 0) ? 0 : S[i - 1]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}