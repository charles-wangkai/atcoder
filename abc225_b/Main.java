import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] a = new int[N - 1];
    int[] b = new int[N - 1];
    for (int i = 0; i < N - 1; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    int N = a.length + 1;

    int[] degrees = new int[N];
    for (int i = 0; i < a.length; ++i) {
      ++degrees[a[i] - 1];
      ++degrees[b[i] - 1];
    }

    return Arrays.stream(degrees).anyMatch(degree -> degree == N - 1);
  }
}