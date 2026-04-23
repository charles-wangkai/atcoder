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

  static int solve(int[] a) {
    int count = 0;
    int target = 1;
    for (int ai : a) {
      if (ai == target) {
        ++count;
        ++target;
      }
    }

    return (count == 0) ? -1 : (a.length - count);
  }
}