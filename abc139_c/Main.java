import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] H = new int[N];
    for (int i = 0; i < H.length; ++i) {
      H[i] = sc.nextInt();
    }

    System.out.println(solve(H));

    sc.close();
  }

  static int solve(int[] H) {
    int result = 0;
    int moveCount = 0;
    int prev = Integer.MIN_VALUE;
    for (int Hi : H) {
      if (Hi <= prev) {
        ++moveCount;
        result = Math.max(result, moveCount);
      } else {
        moveCount = 0;
      }

      prev = Hi;
    }

    return result;
  }
}