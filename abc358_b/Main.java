import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int A = sc.nextInt();
    int[] T = new int[N];
    for (int i = 0; i < T.length; ++i) {
      T[i] = sc.nextInt();
    }

    System.out.println(solve(T, A));

    sc.close();
  }

  static String solve(int[] T, int A) {
    int[] result = new int[T.length];
    int start = 0;
    for (int i = 0; i < result.length; ++i) {
      start = Math.max(start, T[i]);
      result[i] = start + A;

      start = result[i];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}