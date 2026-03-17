import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static long solve(int[] A) {
    long result = 0;
    int max = -1;
    for (int Ai : A) {
      if (max > Ai) {
        result += max - Ai;
      } else {
        max = Ai;
      }
    }

    return result;
  }
}