import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(long N) {
    --N;

    String result = "";
    do {
      int remainder = (int) (N % 5);
      result = remainder * 2 + result;

      N /= 5;
    } while (N != 0);

    return result;
  }
}