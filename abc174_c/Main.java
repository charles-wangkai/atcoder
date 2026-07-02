import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();

    System.out.println(solve(K));

    sc.close();
  }

  static int solve(int K) {
    boolean[] seen = new boolean[K];
    int remainder = 0;
    for (int i = 0; ; ++i) {
      remainder = (remainder * 10 + 7) % K;
      if (remainder == 0) {
        return i + 1;
      }

      if (seen[remainder]) {
        return -1;
      }
      seen[remainder] = true;
    }
  }
}