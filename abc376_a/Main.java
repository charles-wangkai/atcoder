import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int C = sc.nextInt();
    int[] T = new int[N];
    for (int i = 0; i < T.length; ++i) {
      T[i] = sc.nextInt();
    }

    System.out.println(solve(T, C));

    sc.close();
  }

  static int solve(int[] T, int C) {
    int result = 1;
    int prev = T[0];
    for (int i = 1; i < T.length; ++i) {
      if (T[i] - prev >= C) {
        ++result;
        prev = T[i];
      }
    }

    return result;
  }
}