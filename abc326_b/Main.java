import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    for (int i = N; ; ++i) {
      if (is326Like(i)) {
        return i;
      }
    }
  }

  static boolean is326Like(int x) {
    int[] digits = String.valueOf(x).chars().map(c -> c - '0').toArray();

    return digits[0] * digits[1] == digits[2];
  }
}