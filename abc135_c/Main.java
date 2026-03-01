import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N + 1];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static long solve(int[] A, int[] B) {
    long result = 0;
    int extraB = 0;
    for (int i = 0; i < A.length; ++i) {
      int Bi = (i == A.length - 1) ? 0 : B[i];

      int defeatNum = Math.min(A[i], Bi + extraB);

      result += defeatNum;
      extraB = Math.min(Bi, Bi + extraB - defeatNum);
    }

    return result;
  }
}