import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();
    int G = sc.nextInt();
    int M = sc.nextInt();

    System.out.println(solve(K, G, M));

    sc.close();
  }

  static String solve(int K, int G, int M) {
    int glass = 0;
    int mug = 0;
    for (int i = 0; i < K; ++i) {
      if (glass == G) {
        glass = 0;
      } else if (mug == 0) {
        mug = M;
      } else {
        int delta = Math.min(G - glass, mug);

        glass += delta;
        mug -= delta;
      }
    }

    return "%d %d".formatted(glass, mug);
  }
}