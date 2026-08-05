import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] P = new int[N];
    int[][] F = new int[N][];
    for (int i = 0; i < N; ++i) {
      P[i] = sc.nextInt();
      int C = sc.nextInt();
      F[i] = new int[C];
      for (int j = 0; j < F[i].length; ++j) {
        F[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(P, M, F) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] P, int M, int[][] F) {
    int N = P.length;

    @SuppressWarnings("unchecked")
    Set<Integer>[] fSets =
        Arrays.stream(F)
            .map(f -> Arrays.stream(f).boxed().collect(Collectors.toSet()))
            .toArray(Set[]::new);

    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        if (P[i] >= P[j]
            && fSets[i].stream().allMatch(fSets[j]::contains)
            && (P[i] > P[j] || fSets[j].size() > fSets[i].size())) {
          return true;
        }
      }
    }

    return false;
  }
}