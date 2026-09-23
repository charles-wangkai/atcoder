import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] T = new int[Q];
    int[] A = new int[Q];
    int[] B = new int[Q];
    for (int i = 0; i < Q; ++i) {
      T[i] = sc.nextInt();
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(N, T, A, B));

    sc.close();
  }

  static String solve(int N, int[] T, int[] A, int[] B) {
    List<String> result = new ArrayList<>();
    Set<Follow> follows = new HashSet<>();
    for (int i = 0; i < T.length; ++i) {
      if (T[i] == 1) {
        follows.add(new Follow(A[i], B[i]));
      } else if (T[i] == 2) {
        follows.remove(new Follow(A[i], B[i]));
      } else {
        result.add(
            (follows.contains(new Follow(A[i], B[i])) && follows.contains(new Follow(B[i], A[i])))
                ? "Yes"
                : "No");
      }
    }

    return String.join("\n", result);
  }
}

record Follow(int from, int to) {}
