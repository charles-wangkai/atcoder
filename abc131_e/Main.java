import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    System.out.println(solve(N, K));

    sc.close();
  }

  static String solve(int N, int K) {
    if (K > (N - 1) * (N - 2) / 2) {
      return "-1";
    }

    List<String> edges = new ArrayList<>();
    for (int i = 2; i <= N; ++i) {
      edges.add("%d 1".formatted(i));

      for (int j = 2; j < i; ++j) {
        if (K == 0) {
          edges.add("%d %d".formatted(i, j));
        } else {
          --K;
        }
      }
    }

    return "%d\n%s".formatted(edges.size(), String.join("\n", edges));
  }
}