import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] p = new int[N];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }

    System.out.println(solve(p, K));

    sc.close();
  }

  static int solve(int[] p, int K) {
    return Arrays.stream(p).sorted().limit(K).sum();
  }
}