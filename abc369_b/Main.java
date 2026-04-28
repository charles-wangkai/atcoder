import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    char[] S = new char[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      S[i] = sc.next().charAt(0);
    }

    System.out.println(solve(A, S));

    sc.close();
  }

  static int solve(int[] A, char[] S) {
    int result = 0;
    int leftPrev = -1;
    int rightPrev = -1;
    for (int i = 0; i < A.length; ++i) {
      if (S[i] == 'L') {
        if (leftPrev != -1) {
          result += Math.abs(A[i] - leftPrev);
        }
        leftPrev = A[i];
      } else {
        if (rightPrev != -1) {
          result += Math.abs(A[i] - rightPrev);
        }
        rightPrev = A[i];
      }
    }

    return result;
  }
}