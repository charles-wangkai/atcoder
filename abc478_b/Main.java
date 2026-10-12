import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int V = sc.nextInt();
    int[] W = new int[N];
    for (int i = 0; i < W.length; ++i) {
      W[i] = sc.nextInt();
    }

    System.out.println(solve(W, V));

    sc.close();
  }

  static int solve(int[] W, int V) {
    int result = 0;
    for (int i = 0; i < W.length; ++i) {
      for (int j = i + 1; j < W.length; ++j) {
        for (int k = j + 1; k < W.length; ++k) {
          if (i + j + k + 3 <= V) {
            result = Math.max(result, W[i] + W[j] + W[k]);
          }
        }
      }
    }

    return result;
  }
}