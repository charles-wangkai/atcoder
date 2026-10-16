import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    int K = sc.nextInt();

    System.out.println(solve(A, B, C, K) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int A, int B, int C, int K) {
    int operationCount = 0;
    while (B <= A) {
      B *= 2;
      ++operationCount;
    }
    while (C <= B) {
      C *= 2;
      ++operationCount;
    }

    return operationCount <= K;
  }
}