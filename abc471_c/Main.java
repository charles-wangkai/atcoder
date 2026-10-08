import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

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

  static long solve(int[] A) {
    NavigableSet<Integer> rest = new TreeSet<>();
    for (int Ai : A) {
      rest.add(Ai);
    }

    long result = 0;
    int curr = 0;
    while (!rest.isEmpty()) {
      Integer floor = rest.floor(curr);
      Integer ceiling = rest.ceiling(curr);

      int next =
          (ceiling == null || (floor != null && curr - floor <= ceiling - curr)) ? floor : ceiling;
      result += Math.abs(next - curr);
      rest.remove(next);
      curr = next;
    }

    return result;
  }
}