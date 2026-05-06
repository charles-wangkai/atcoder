import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, X));

    sc.close();
  }

  static String solve(int[] A, int X) {
    int[] result = new int[A.length];
    for (int i = 0; i < A.length; ++i) {
      if (A[i] < X) {
        X = A[i];
        result[i] = 1;
      } else {
        result[i] = 0;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}