import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int P = sc.nextInt();
    int Q = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();

    System.out.println(solve(P, Q, X, Y) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int P, int Q, int X, int Y) {
    return X >= P && X < P + 100 && Y >= Q && Y < Q + 100;
  }
}