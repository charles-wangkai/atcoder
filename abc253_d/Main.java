import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(N, A, B));

    sc.close();
  }

  static long solve(int N, int A, int B) {
    return computeSum(N, 1) - computeSum(N, A) - computeSum(N, B) + computeSum(N, lcm(A, B));
  }

  static long lcm(int x, int y) {
    return (long) x / gcd(x, y) * y;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }

  static long computeSum(int N, long factor) {
    int multipleNum = (int) (N / factor);

    return multipleNum * (multipleNum + 1L) / 2 * factor;
  }
}