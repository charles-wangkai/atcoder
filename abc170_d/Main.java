import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int Ai : A) {
      valueToCount.put(Ai, valueToCount.getOrDefault(Ai, 0) + 1);
    }

    int maxValue = Arrays.stream(A).max().getAsInt();

    Set<Integer> multiples = new HashSet<>();
    for (int value : valueToCount.keySet()) {
      if (valueToCount.get(value) != 1) {
        multiples.add(value);
      }

      for (int multiple = value * 2; multiple <= maxValue; multiple += value) {
        if (valueToCount.containsKey(multiple)) {
          multiples.add(multiple);
        }
      }
    }

    return (int) Arrays.stream(A).filter(x -> !multiples.contains(x)).count();
  }
}