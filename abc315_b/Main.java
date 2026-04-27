import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int M = sc.nextInt();
    int[] D = new int[M];
    for (int i = 0; i < D.length; ++i) {
      D[i] = sc.nextInt();
    }

    System.out.println(solve(D));

    sc.close();
  }

  static String solve(int[] D) {
    List<String> dates = new ArrayList<>();
    for (int i = 0; i < D.length; ++i) {
      for (int j = 0; j < D[i]; ++j) {
        dates.add("%d %d".formatted(i + 1, j + 1));
      }
    }

    return dates.get(dates.size() / 2);
  }
}