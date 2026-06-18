import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int L = sc.nextInt();
    int R = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, L, R));

    sc.close();
  }

  static String solve(int[] A, int L, int R) {
    return Arrays.stream(A)
        .map(
            Ai -> {
              if (Ai < L) {
                return L;
              }
              if (Ai > R) {
                return R;
              }

              return Ai;
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}