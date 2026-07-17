import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] X = new int[N];
    for (int i = 0; i < X.length; ++i) {
      X[i] = sc.nextInt();
    }

    System.out.println(solve(X) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] X) {
    return Arrays.stream(X).allMatch(Xi -> Xi < 0);
  }
}