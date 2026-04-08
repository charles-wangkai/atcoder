import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int T = sc.nextInt();
    int P = sc.nextInt();
    int[] L = new int[N];
    for (int i = 0; i < L.length; ++i) {
      L[i] = sc.nextInt();
    }

    System.out.println(solve(L, T, P));

    sc.close();
  }

  static int solve(int[] L, int T, int P) {
    int result = 0;
    while (Arrays.stream(L).filter(Li -> Li >= T).count() < P) {
      for (int i = 0; i < L.length; ++i) {
        ++L[i];
      }

      ++result;
    }

    return result;
  }
}