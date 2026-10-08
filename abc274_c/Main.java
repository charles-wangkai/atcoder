import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    int N = A.length;

    int[] result = new int[2 * N + 1];
    for (int i = 0; i < A.length; ++i) {
      result[2 * i + 1] = result[A[i] - 1] + 1;
      result[2 * i + 2] = result[A[i] - 1] + 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}