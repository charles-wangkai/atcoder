import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
    long result = 0;
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int i = 0; i < A.length; ++i) {
      result += valueToCount.getOrDefault(i - A[i], 0);
      valueToCount.put(i + A[i], valueToCount.getOrDefault(i + A[i], 0) + 1);
    }

    return result;
  }
}