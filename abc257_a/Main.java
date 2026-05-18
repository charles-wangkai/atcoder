import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();

    System.out.println(solve(N, X));

    sc.close();
  }

  static char solve(int N, int X) {
    return (char) ((X - 1) / N + 'A');
  }
}