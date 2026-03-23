import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    System.out.println(solve(N, K));

    sc.close();
  }

  static int solve(int N, int K) {
    int result = 0;
    for (int floor = 1; floor <= N; ++floor) {
      for (int room = 1; room <= K; ++room) {
        result += floor * 100 + room;
      }
    }

    return result;
  }
}