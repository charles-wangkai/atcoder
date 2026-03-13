import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();
    int X = sc.nextInt();

    System.out.println(solve(K, X) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int K, int X) {
    return K * 500 >= X;
  }
}