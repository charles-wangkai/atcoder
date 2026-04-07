import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] d = new int[N];
    for (int i = 0; i < d.length; ++i) {
      d[i] = sc.nextInt();
    }

    System.out.println(solve(d));

    sc.close();
  }

  static int solve(int[] d) {
    int result = 0;
    for (int i = 0; i < d.length; ++i) {
      for (int j = i + 1; j < d.length; ++j) {
        result += d[i] * d[j];
      }
    }

    return result;
  }
}