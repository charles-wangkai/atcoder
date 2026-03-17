import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] v = new int[N];
    for (int i = 0; i < v.length; ++i) {
      v[i] = sc.nextInt();
    }

    System.out.println("%.9f".formatted(solve(v)));

    sc.close();
  }

  static double solve(int[] v) {
    Arrays.sort(v);

    double result = (v[0] + v[1]) / 2.0;
    for (int i = 2; i < v.length; ++i) {
      result = (result + v[i]) / 2;
    }

    return result;
  }
}