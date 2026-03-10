import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] X = new int[N];
    for (int i = 0; i < X.length; ++i) {
      X[i] = sc.nextInt();
    }

    System.out.println(solve(X));

    sc.close();
  }

  static int solve(int[] X) {
    int min = Arrays.stream(X).min().getAsInt();
    int max = Arrays.stream(X).max().getAsInt();

    return IntStream.rangeClosed(min, max)
        .map(p -> Arrays.stream(X).map(Xi -> (Xi - p) * (Xi - p)).sum())
        .min()
        .getAsInt();
  }
}