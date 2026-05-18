import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long K = sc.nextLong();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, K));

    sc.close();
  }

  static int solve(int[] A, long K) {
    int[] times = new int[A.length];
    Arrays.fill(times, -1);
    times[0] = 0;

    int index = 0;
    int time = 1;
    while (K != 0) {
      index = A[index] - 1;
      --K;

      if (time != -1) {
        if (times[index] == -1) {
          times[index] = time;
          ++time;
        } else {
          K %= time - times[index];
          time = -1;
        }
      }
    }

    return index + 1;
  }
}