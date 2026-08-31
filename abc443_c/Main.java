import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int T = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, T));

    sc.close();
  }

  static int solve(int[] A, int T) {
    int result = 0;
    int openTime = 0;
    int index = 0;
    while (true) {
      while (index != A.length && A[index] < openTime) {
        ++index;
      }

      if (index == A.length) {
        result += T - openTime;

        break;
      }

      result += A[index] - openTime;

      openTime = A[index] + 100;
      if (openTime >= T) {
        break;
      }
    }

    return result;
  }
}