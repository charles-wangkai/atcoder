import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int B = sc.nextInt();
      int R = sc.nextInt();

      System.out.println(solve(B, R));
    }
  }

  static int solve(int B, int R) {
    return (30 - B) * (30 - R);
  }
}