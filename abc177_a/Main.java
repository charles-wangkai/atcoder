import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int D = sc.nextInt();
    int T = sc.nextInt();
    int S = sc.nextInt();

    System.out.println(solve(D, T, S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int D, int T, int S) {
    return S * T >= D;
  }
}