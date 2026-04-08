import java.util.Scanner;

public class Main {
  static final int LIMIT = 1_000_000_000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    System.out.println(solve(N, M));

    sc.close();
  }

  static String solve(int N, int M) {
    long result = 0;
    long power = 1;
    for (int i = 0; i <= M; ++i) {
      result += power;
      if (result > LIMIT) {
        return "inf";
      }

      power *= N;
    }

    return String.valueOf(result);
  }
}