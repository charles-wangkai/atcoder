import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    int result = 0;
    int sum = 0;
    for (int i = 1; ; ++i) {
      ++result;
      sum += i;
      if (sum >= N) {
        return result;
      }
    }
  }
}