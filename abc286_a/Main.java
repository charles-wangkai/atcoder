import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int P = sc.nextInt();
    int Q = sc.nextInt();
    int R = sc.nextInt();
    int S = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, P, Q, R, S));

    sc.close();
  }

  static String solve(int[] A, int P, int Q, int R, int S) {
    int[] B = A.clone();
    for (int i = P, j = R; i <= Q; ++i, ++j) {
      swap(B, i - 1, j - 1);
    }

    return Arrays.stream(B).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }
}