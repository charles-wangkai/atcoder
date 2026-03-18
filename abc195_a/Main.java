import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int M = sc.nextInt();
    int H = sc.nextInt();

    System.out.println(solve(M, H) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int M, int H) {
    return H % M == 0;
  }
}