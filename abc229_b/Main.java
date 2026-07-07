import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long A = sc.nextLong();
    long B = sc.nextLong();

    System.out.println(solve(A, B));

    sc.close();
  }

  static String solve(long A, long B) {
    while (A != 0 || B != 0) {
      if (A % 10 + B % 10 > 9) {
        return "Hard";
      }

      A /= 10;
      B /= 10;
    }

    return "Easy";
  }
}