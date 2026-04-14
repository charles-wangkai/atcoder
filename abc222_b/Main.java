import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int P = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, P));

    sc.close();
  }

  static int solve(int[] a, int P) {
    return (int) Arrays.stream(a).filter(ai -> ai < P).count();
  }
}