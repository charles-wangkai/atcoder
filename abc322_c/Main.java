import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[M];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(N, A));

    sc.close();
  }

  static String solve(int N, int[] A) {
    boolean[] fireworks = new boolean[N];
    for (int Ai : A) {
      fireworks[Ai - 1] = true;
    }

    int[] result = new int[N];
    int lastIndex = -1;
    for (int i = result.length - 1; i >= 0; --i) {
      if (fireworks[i]) {
        lastIndex = i;
      }

      result[i] = lastIndex - i;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}