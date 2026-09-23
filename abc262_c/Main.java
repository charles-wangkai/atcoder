import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static long solve(int[] a) {
    long result = 0;
    int matchedCount = 0;
    for (int i = 0; i < a.length; ++i) {
      if (a[i] == i + 1) {
        ++matchedCount;
      } else if (a[i] > i + 1 && a[a[i] - 1] == i + 1) {
        ++result;
      }
    }
    result += matchedCount * (matchedCount - 1L) / 2;

    return result;
  }
}