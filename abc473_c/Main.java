import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, K));

    sc.close();
  }

  static int solve(int[] A, int K) {
    Map<Integer, Integer> classToCount = new HashMap<>();
    for (int Ai : A) {
      classToCount.put(Ai, classToCount.getOrDefault(Ai, 0) + 1);
    }

    int maxCount = classToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt();

    return (int) classToCount.values().stream().filter(count -> count >= maxCount - 1).count();
  }
}