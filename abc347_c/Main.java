import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int A = sc.nextInt();
      int B = sc.nextInt();
      int[] D = new int[N];
      for (int i = 0; i < D.length; ++i) {
        D[i] = sc.nextInt();
      }

      System.out.println(solve(D, A, B) ? "Yes" : "No");
    }
  }

  static boolean solve(int[] D, int A, int B) {
    int singleLeft = Integer.MIN_VALUE;
    int singleRight = Integer.MAX_VALUE;
    int doubleLeft = Integer.MAX_VALUE;
    int doubleRight = Integer.MIN_VALUE;
    for (int Di : D) {
      int from = Math.floorMod(-Di, A + B);
      int to = Math.floorMod(A - 1 - Di, A + B);
      if (from <= to) {
        singleLeft = Math.max(singleLeft, from);
        singleRight = Math.min(singleRight, to);
      } else {
        doubleLeft = Math.min(doubleLeft, to);
        doubleRight = Math.max(doubleRight, from);
      }
    }

    return singleLeft <= singleRight && (doubleLeft >= singleLeft || doubleRight <= singleRight);
  }
}