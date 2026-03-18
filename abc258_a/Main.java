import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();

    System.out.println(solve(K));

    sc.close();
  }

  static String solve(int K) {
    int totalMinutes = 21 * 60 + K;

    return "%02d:%02d".formatted(totalMinutes / 60, totalMinutes % 60);
  }
}