import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[][] X = new int[N][];
    for (int i = 0; i < X.length; ++i) {
      int L = sc.nextInt();
      X[i] = new int[L];
      for (int j = 0; j < X[i].length; ++j) {
        X[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(X, M));

    sc.close();
  }

  static String solve(int[][] X, int M) {
    int N = X.length;

    int[] result = new int[N];
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < result.length; ++i) {
      OptionalInt chosen = Arrays.stream(X[i]).filter(xi -> !seen.contains(xi)).findFirst();
      if (chosen.isPresent()) {
        result[i] = chosen.getAsInt();
        seen.add(result[i]);
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}