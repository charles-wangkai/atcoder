import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long A = sc.nextLong();
    long B = sc.nextLong();

    System.out.println(solve(A, B));

    sc.close();
  }

  static long solve(long A, long B) {
    if (A < B) {
      return solve(B, A);
    }
    if (A == B) {
      return 0;
    }

    long operationNum = (A - 1) / B;

    return operationNum + solve(A - B * operationNum, B);
  }
}