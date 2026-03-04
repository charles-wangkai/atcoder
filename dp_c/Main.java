import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] a = new int[N];
    int[] b = new int[N];
    int[] c = new int[N];
    for (int i = 0; i < N; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, c));

    sc.close();
  }

  static int solve(int[] a, int[] b, int[] c) {
    int lastA = a[0];
    int lastB = b[0];
    int lastC = c[0];
    for (int i = 1; i < a.length; ++i) {
      int nextLastA = Math.max(lastB, lastC) + a[i];
      int nextLastB = Math.max(lastC, lastA) + b[i];
      int nextLastC = Math.max(lastA, lastB) + c[i];

      lastA = nextLastA;
      lastB = nextLastB;
      lastC = nextLastC;
    }

    return Math.max(Math.max(lastA, lastB), lastC);
  }
}
