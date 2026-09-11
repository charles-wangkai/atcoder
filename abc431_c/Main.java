import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int K = sc.nextInt();
    int[] H = new int[N];
    for (int i = 0; i < H.length; ++i) {
      H[i] = sc.nextInt();
    }
    int[] B = new int[M];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(H, B, K) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] H, int[] B, int K) {
    Arrays.sort(H);
    Arrays.sort(B);

    int count = 0;
    int index = 0;
    for (int Hi : H) {
      while (index != B.length && B[index] < Hi) {
        ++index;
      }

      if (index != B.length) {
        ++count;
        ++index;
      }
    }

    return count >= K;
  }
}