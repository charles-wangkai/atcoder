import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    if (N <= 125) {
      return 4;
    }
    if (N <= 211) {
      return 6;
    }

    return 8;
  }
}