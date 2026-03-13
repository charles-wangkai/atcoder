import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(int A, int B) {
    return Math.max(S(A), S(B));
  }

  static int S(int x) {
    return String.valueOf(x).chars().map(c -> c - '0').sum();
  }
}