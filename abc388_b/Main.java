import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int D = sc.nextInt();
    int[] T = new int[N];
    int[] L = new int[N];
    for (int i = 0; i < N; ++i) {
      T[i] = sc.nextInt();
      L[i] = sc.nextInt();
    }

    System.out.println(solve(T, L, D));

    sc.close();
  }

  static String solve(int[] T, int[] L, int D) {
    return IntStream.rangeClosed(1, D)
        .map(k -> IntStream.range(0, T.length).map(i -> T[i] * (L[i] + k)).max().getAsInt())
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}