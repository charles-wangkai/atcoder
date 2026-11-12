import java.util.Scanner;

public class Main {
  static final int LIMIT = 10000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();

    System.out.println(solve(N, A, B, C));

    sc.close();
  }

  static int solve(int N, int A, int B, int C) {
    int result = LIMIT;
    for (int i = 0; i < result; ++i) {
      for (int j = 0; i + j < result; ++j) {
        long rest = N - (long) i * A - (long) j * B;
        if (rest >= 0 && rest % C == 0) {
          result = Math.min(result, i + j + (int) (rest / C));
        }
      }
    }

    return result;
  }
}