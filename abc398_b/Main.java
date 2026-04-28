import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] A = new int[7];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] A) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int Ai : A) {
      valueToCount.put(Ai, valueToCount.getOrDefault(Ai, 0) + 1);
    }

    for (int value1 : valueToCount.keySet()) {
      for (int value2 : valueToCount.keySet()) {
        if (value1 != value2 && valueToCount.get(value1) >= 3 && valueToCount.get(value2) >= 2) {
          return true;
        }
      }
    }

    return false;
  }
}