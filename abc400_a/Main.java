import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();

    System.out.println(solve(A));

    sc.close();
  }

  static int solve(int A) {
    return (400 % A == 0) ? (400 / A) : -1;
  }
}