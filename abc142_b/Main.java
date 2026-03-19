import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] h = new int[N];
    for (int i = 0; i < h.length; ++i) {
      h[i] = sc.nextInt();
    }

    System.out.println(solve(h, K));

    sc.close();
  }

  static int solve(int[] h, int K) {
    return (int) Arrays.stream(h).filter(hi -> hi >= K).count();
  }
}