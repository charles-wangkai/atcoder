import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int V = sc.nextInt();
    int T = sc.nextInt();
    int S = sc.nextInt();
    int D = sc.nextInt();

    System.out.println(solve(V, T, S, D) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int V, int T, int S, int D) {
    return !(D >= V * T && D <= V * S);
  }
}