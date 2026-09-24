import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] t = new int[N];
    int[] l = new int[N];
    int[] r = new int[N];
    for (int i = 0; i < N; ++i) {
      t[i] = sc.nextInt();
      l[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }

    System.out.println(solve(t, l, r));

    sc.close();
  }

  static int solve(int[] t, int[] l, int[] r) {
    int N = t.length;

    int result = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = i + 1; j < N; ++j) {
        if (isIntersect(t[i], l[i], r[i], t[j], l[j], r[j])) {
          ++result;
        }
      }
    }

    return result;
  }

  static boolean isIntersect(int t1, int l1, int r1, int t2, int l2, int r2) {
    if (l1 > l2) {
      return isIntersect(t2, l2, r2, t1, l1, r1);
    }

    return !(r1 < l2 || (r1 == l2 && (t1 == 2 || t1 == 4 || t2 == 3 || t2 == 4)));
  }
}