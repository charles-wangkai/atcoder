import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] C = new int[N];
    for (int i = 0; i < C.length; ++i) {
      C[i] = sc.nextInt();
    }

    System.out.println(solve(C));

    sc.close();
  }

  static int solve(int[] C) {
    Map<Integer, Integer> colorToCount = new HashMap<>();
    for (int Ci : C) {
      colorToCount.put(Ci, colorToCount.getOrDefault(Ci, 0) + 1);
    }

    return C.length - colorToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt();
  }
}