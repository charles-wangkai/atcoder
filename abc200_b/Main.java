import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    System.out.println(solve(N, K));

    sc.close();
  }

  static long solve(int N, int K) {
    long result = N;
    for (int i = 0; i < K; ++i) {
      if (result % 200 == 0) {
        result /= 200;
      } else {
        result = result * 1000 + 200;
      }
    }

    return result;
  }
}