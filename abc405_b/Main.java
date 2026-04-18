import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, M));

    sc.close();
  }

  static int solve(int[] A, int M) {
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; ; ++i) {
      if (i == A.length) {
        return 0;
      }

      seen.add(A[i]);
      if (seen.size() == M) {
        return A.length - i;
      }
    }
  }
}