import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    int coinNum1 = 0;
    int coinNum10 = 0;
    int coinNum100 = 0;
    for (int Ai : A) {
      int change = Math.floorMod(-Ai, 1000);

      coinNum1 += change % 10;
      coinNum10 += change / 10 % 10;
      coinNum100 += change / 100;
    }

    return "%d %d %d".formatted(coinNum1, coinNum10, coinNum100);
  }
}