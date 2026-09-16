import java.util.Arrays;
import java.util.HashSet;
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

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    int N = A.length;

    Set<Integer> rests = new HashSet<>();
    for (int i = 1; i <= N; ++i) {
      rests.add(i);
    }

    for (int Ai : A) {
      if (Ai != -1) {
        if (!rests.contains(Ai)) {
          return "No";
        }

        rests.remove(Ai);
      }
    }

    int[] P = A.clone();
    for (int i = 0; i < P.length; ++i) {
      if (P[i] == -1) {
        P[i] = rests.iterator().next();
        rests.remove(P[i]);
      }
    }

    return "Yes\n%s"
        .formatted(Arrays.stream(P).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}