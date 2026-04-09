import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int P = sc.nextInt();

    System.out.println(solve(P));

    sc.close();
  }

  static int solve(int P) {
    List<Integer> coins = new ArrayList<>();
    int coin = 1;
    for (int i = 1; ; ++i) {
      coin *= i;
      if (coin > P) {
        break;
      }

      coins.add(coin);
    }
    Collections.reverse(coins);

    int result = 0;
    for (int c : coins) {
      int coinNum = P / c;
      P -= coinNum * c;
      result += coinNum;
    }

    return result;
  }
}