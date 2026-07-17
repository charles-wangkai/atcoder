import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] F = new int[N];
    for (int i = 0; i < F.length; ++i) {
      F[i] = sc.nextInt();
    }

    System.out.println(solve(F, M));

    sc.close();
  }

  static String solve(int[] F, int M) {
    Map<Integer, Integer> typeToCount = new HashMap<>();
    for (int Fi : F) {
      typeToCount.put(Fi, typeToCount.getOrDefault(Fi, 0) + 1);
    }

    return "%s\n%s"
        .formatted(
            typeToCount.values().stream().allMatch(count -> count == 1) ? "Yes" : "No",
            (typeToCount.size() == M) ? "Yes" : "No");
  }
}