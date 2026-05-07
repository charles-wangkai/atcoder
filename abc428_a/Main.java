import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int S = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();
    int X = sc.nextInt();

    System.out.println(solve(S, A, B, X));

    sc.close();
  }

  static int solve(int S, int A, int B, int X) {
    return (X / (A + B) * A + Math.min(A, X % (A + B))) * S;
  }
}