import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] D = new int[N];
    for (int i = 0; i < D.length; ++i) {
      D[i] = sc.nextInt();
    }

    System.out.println(solve(D));

    sc.close();
  }

  static int solve(int[] D) {
    int result = 0;
    for (int i = 0; i < D.length; ++i) {
      for (int j = 0; j < D[i]; ++j) {
        if (check(i + 1, j + 1)) {
          ++result;
        }
      }
    }

    return result;
  }

  static boolean check(int month, int day) {
    return "%d%d".formatted(month, day).chars().distinct().count() == 1;
  }
}