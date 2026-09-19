import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    System.out.println(solve(N, K));

    sc.close();
  }

  static int solve(int N, int K) {
    int result = 0;
    for (int card1 = 1; card1 <= N; ++card1) {
      for (int card2 = 1; card2 <= N; ++card2) {
        int card3 = K - card1 - card2;
        if (card3 >= 1 && card3 <= N) {
          ++result;
        }
      }
    }

    return result;
  }
}