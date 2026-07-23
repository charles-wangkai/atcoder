import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

  static int solve(int[] A, int X) {
    Set<Integer> seen = new HashSet<>();
    int current = X - 1;
    while (!seen.contains(current)) {
      seen.add(current);
      current = A[current] - 1;
    }

    return seen.size();
  }
}