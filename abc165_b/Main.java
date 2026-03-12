import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long X = sc.nextLong();

    System.out.println(solve(X));

    sc.close();
  }

  static int solve(long X) {
    int result = 0;
    long balance = 100;
    while (balance < X) {
      balance += balance / 100;
      ++result;
    }

    return result;
  }
}