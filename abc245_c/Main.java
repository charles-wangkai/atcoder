import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, K) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] A, int[] B, int K) {
    Set<Integer> dp = Stream.of(A[0], B[0]).collect(Collectors.toSet());
    for (int i = 1; i < A.length; ++i) {
      Set<Integer> nextDp = new HashSet<>();
      for (int last : dp) {
        for (int value : new int[] {A[i], B[i]}) {
          if (Math.abs(value - last) <= K) {
            nextDp.add(value);
          }
        }
      }

      dp = nextDp;
    }

    return !dp.isEmpty();
  }
}