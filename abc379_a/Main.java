import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    int a = N / 100;
    int b = N / 10 % 10;
    int c = N % 10;

    return "%d%d%d %d%d%d".formatted(b, c, a, c, a, b);
  }
}