import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] X = new int[5 * N];
    for (int i = 0; i < X.length; ++i) {
      X[i] = sc.nextInt();
    }

    System.out.println("%.9f".formatted(solve(X)));

    sc.close();
  }

  static double solve(int[] X) {
    int N = X.length / 5;

    return Arrays.stream(X).sorted().skip(N).limit(3 * N).average().getAsDouble();
  }
}