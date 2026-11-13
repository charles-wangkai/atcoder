import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int M = sc.nextInt();
    int[] B = new int[M];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }
    int X = sc.nextInt();

    System.out.println(solve(A, B, X) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] A, int[] B, int X) {
    Set<Integer> traps = Arrays.stream(B).boxed().collect(Collectors.toSet());

    boolean[] dp = new boolean[X + 1];
    dp[0] = true;
    for (int i = 0; i < dp.length; ++i) {
      if (dp[i]) {
        for (int Ai : A) {
          int next = i + Ai;
          if (next < dp.length && !traps.contains(next)) {
            dp[next] = true;
          }
        }
      }
    }

    return dp[X];
  }
}