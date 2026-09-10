import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] S = new int[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.nextInt();
    }

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(int[] S) {
    return (int) Arrays.stream(S).filter(Si -> !isPossible(Si)).count();
  }

  static boolean isPossible(int area) {
    for (int a = 1; a <= area; ++a) {
      for (int b = 1; b <= area; ++b) {
        if (4 * a * b + 3 * a + 3 * b == area) {
          return true;
        }
      }
    }

    return false;
  }
}