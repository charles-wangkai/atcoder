import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[M];
    int[] B = new int[M];
    int[] C = new int[M];
    for (int i = 0; i < M; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
      C[i] = sc.nextInt();
    }

    System.out.println(solve(N, A, B, C));

    sc.close();
  }

  static int solve(int N, int[] A, int[] B, int[] C) {
    int[][] distances = new int[N][N];
    for (int i = 0; i < distances.length; ++i) {
      Arrays.fill(distances[i], -1);
    }
    for (int i = 0; i < A.length; ++i) {
      distances[A[i] - 1][B[i] - 1] = C[i];
      distances[B[i] - 1][A[i] - 1] = C[i];
    }

    return search(distances, IntStream.range(0, N).toArray(), 0);
  }

  static int search(int[][] distances, int[] nodes, int index) {
    if (index == nodes.length) {
      return computeTotalDistance(distances, nodes);
    }

    int result = 0;
    for (int i = index; i < nodes.length; ++i) {
      swap(nodes, i, index);
      result = Math.max(result, search(distances, nodes, index + 1));
      swap(nodes, i, index);
    }

    return result;
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }

  static int computeTotalDistance(int[][] distances, int[] nodes) {
    int result = 0;
    for (int i = 0; i < nodes.length - 1; ++i) {
      if (distances[nodes[i]][nodes[i + 1]] == -1) {
        break;
      }

      result += distances[nodes[i]][nodes[i + 1]];
    }

    return result;
  }
}