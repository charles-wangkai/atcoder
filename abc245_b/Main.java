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

    System.out.println(solve(A));

    sc.close();
  }

  static int solve(int[] A) {
    Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());

    for (int i = 0; ; ++i) {
      if (!set.contains(i)) {
        return i;
      }
    }
  }
}