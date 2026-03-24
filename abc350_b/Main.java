import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] T = new int[Q];
    for (int i = 0; i < T.length; ++i) {
      T[i] = sc.nextInt();
    }

    System.out.println(solve(N, T));

    sc.close();
  }

  static int solve(int N, int[] T) {
    Set<Integer> removed = new HashSet<>();
    for (int Ti : T) {
      if (removed.contains(Ti)) {
        removed.remove(Ti);
      } else {
        removed.add(Ti);
      }
    }

    return N - removed.size();
  }
}