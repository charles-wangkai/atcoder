import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int x = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, x));

    sc.close();
  }

  static int solve(int[] a, int x) {
    Arrays.sort(a);

    int result = 0;
    for (int ai : a) {
      if (ai <= x) {
        x -= ai;
        ++result;
      }
    }
    if (result == a.length && x != 0) {
      --result;
    }

    return result;
  }
}