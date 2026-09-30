import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int S = sc.nextInt();
    int T = sc.nextInt();

    System.out.println(solve(S, T));

    sc.close();
  }

  static int solve(int S, int T) {
    return T - S + 1;
  }
}