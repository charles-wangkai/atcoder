import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int N) {
    return N % 3 == 0;
  }
}