import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();

    System.out.println(solve(N, X, Y));

    sc.close();
  }

  static long solve(int N, int X, int Y) {
    long[] redNums = new long[N];
    redNums[N - 1] = 1;

    long[] blueNums = new long[N];

    for (int i = N - 1; i >= 1; --i) {
      redNums[i - 1] += redNums[i];
      blueNums[i] += redNums[i] * X;

      redNums[i - 1] += blueNums[i];
      blueNums[i - 1] += blueNums[i] * Y;
    }

    return blueNums[0];
  }
}