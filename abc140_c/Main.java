import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] B = new int[N - 1];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(B));

    sc.close();
  }

  static int solve(int[] B) {
    return IntStream.range(0, B.length - 1).map(i -> Math.min(B[i], B[i + 1])).sum()
        + B[0]
        + B[B.length - 1];
  }
}