import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int M = sc.nextInt();
      int D = sc.nextInt();

      System.out.println(solve(M, D) ? "YES" : "NO");
    }
  }

  static boolean solve(int M, int D) {
    return M % D == 0;
  }
}