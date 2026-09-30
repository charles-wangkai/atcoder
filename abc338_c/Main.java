import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] Q = new int[N];
    for (int i = 0; i < Q.length; ++i) {
      Q[i] = sc.nextInt();
    }
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(Q, A, B));

    sc.close();
  }

  static int solve(int[] Q, int[] A, int[] B) {
    int result = 0;
    for (int dishA = 0; ; ++dishA) {
      result =
          Math.max(
              result,
              dishA
                  + IntStream.range(0, B.length)
                      .filter(i -> B[i] != 0)
                      .map(i -> Q[i] / B[i])
                      .min()
                      .getAsInt());

      for (int i = 0; i < Q.length; ++i) {
        Q[i] -= A[i];
      }
      if (Arrays.stream(Q).anyMatch(Qi -> Qi < 0)) {
        break;
      }
    }

    return result;
  }
}