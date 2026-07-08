import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    for (int limit = 1000, factor = 1; ; limit *= 10, factor *= 10) {
      if (N < limit) {
        return N / factor * factor;
      }
    }
  }
}