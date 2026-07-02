import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int S = sc.nextInt();
    int M = sc.nextInt();
    int L = sc.nextInt();

    System.out.println(solve(N, S, M, L));

    sc.close();
  }

  static int solve(int N, int S, int M, int L) {
    int result = Integer.MAX_VALUE;

    int sLimit = Math.ceilDiv(N, 6);
    int mLimit = Math.ceilDiv(N, 8);
    int lLimit = Math.ceilDiv(N, 12);

    for (int i = 0; i <= sLimit; ++i) {
      for (int j = 0; j <= mLimit; ++j) {
        for (int k = 0; k <= lLimit; ++k) {
          if (i * 6 + j * 8 + k * 12 >= N) {
            result = Math.min(result, i * S + j * M + k * L);
          }
        }
      }
    }

    return result;
  }
}