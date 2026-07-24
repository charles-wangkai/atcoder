import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[][] T = new int[N][N];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        T[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(T, K));

    sc.close();
  }

  static int solve(int[][] T, int K) {
    int N = T.length;

    return search(T, K, IntStream.range(1, N).toArray(), 0);
  }

  static int search(int[][] T, int K, int[] indices, int depth) {
    if (depth == indices.length) {
      return (IntStream.rangeClosed(0, indices.length)
                  .map(
                      i -> T[(i == indices.length) ? 0 : indices[i]][(i == 0) ? 0 : indices[i - 1]])
                  .sum()
              == K)
          ? 1
          : 0;
    }

    int result = 0;
    for (int i = depth; i < indices.length; ++i) {
      swap(indices, i, depth);
      result += search(T, K, indices, depth + 1);
      swap(indices, i, depth);
    }

    return result;
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }
}