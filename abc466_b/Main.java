import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] C = new int[N];
    int[] S = new int[N];
    for (int i = 0; i < N; ++i) {
      C[i] = sc.nextInt();
      S[i] = sc.nextInt();
    }

    System.out.println(solve(C, S, M));

    sc.close();
  }

  static String solve(int[] C, int[] S, int M) {
    Map<Integer, Integer> colorToMaxSize = new HashMap<>();
    for (int i = 0; i < C.length; ++i) {
      colorToMaxSize.put(C[i], Math.max(colorToMaxSize.getOrDefault(C[i], -1), S[i]));
    }

    return IntStream.rangeClosed(1, M)
        .map(color -> colorToMaxSize.getOrDefault(color, -1))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}