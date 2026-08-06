import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int M = sc.nextInt();
    String S = sc.next();
    String T = sc.next();
    int[] L = new int[M];
    int[] R = new int[M];
    for (int i = 0; i < M; ++i) {
      L[i] = sc.nextInt();
      R[i] = sc.nextInt();
    }

    System.out.println(solve(S, T, L, R));

    sc.close();
  }

  static String solve(String S, String T, int[] L, int[] R) {
    int N = S.length();

    boolean[] flipped = new boolean[N + 1];
    for (int i = 0; i < L.length; ++i) {
      flipped[L[i] - 1] ^= true;
      flipped[R[i]] ^= true;
    }

    StringBuilder result = new StringBuilder();
    boolean swapped = false;
    for (int i = 0; i < N; ++i) {
      swapped ^= flipped[i];
      result.append((swapped ? T : S).charAt(i));
    }

    return result.toString();
  }
}