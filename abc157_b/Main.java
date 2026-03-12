import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[][] A = new int[3][3];
    for (int r = 0; r < 3; ++r) {
      for (int c = 0; c < 3; ++c) {
        A[r][c] = sc.nextInt();
      }
    }
    int N = sc.nextInt();
    int[] b = new int[N];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(A, b) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[][] A, int[] b) {
    Set<Integer> chosen = Arrays.stream(b).boxed().collect(Collectors.toSet());

    return allContains(chosen, A[0][0], A[0][1], A[0][2])
        || allContains(chosen, A[1][0], A[1][1], A[1][2])
        || allContains(chosen, A[2][0], A[2][1], A[2][2])
        || allContains(chosen, A[0][0], A[1][0], A[2][0])
        || allContains(chosen, A[0][1], A[1][1], A[2][1])
        || allContains(chosen, A[0][2], A[1][2], A[2][2])
        || allContains(chosen, A[0][0], A[1][1], A[2][2])
        || allContains(chosen, A[0][2], A[1][1], A[2][0]);
  }

  static boolean allContains(Set<Integer> chosen, int value1, int value2, int value3) {
    return IntStream.of(value1, value2, value3).allMatch(chosen::contains);
  }
}