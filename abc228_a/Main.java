import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int S = sc.nextInt();
    int T = sc.nextInt();
    int X = sc.nextInt();

    System.out.println(solve(S, T, X) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int S, int T, int X) {
    if (S < T) {
      return X >= S && X < T;
    }

    return X >= S || X < T;
  }
}