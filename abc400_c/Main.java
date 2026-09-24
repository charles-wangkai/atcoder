import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static long solve(long N) {
    long result = 0;
    for (long twoPower = 2; twoPower <= N; twoPower *= 2) {
      result += computeOddSquareNum(N / twoPower);
    }

    return result;
  }

  static int computeOddSquareNum(long limit) {
    int root = (int) Math.ceil(Math.sqrt(limit));
    if ((long) root * root > limit) {
      --root;
    }

    return (root + 1) / 2;
  }
}