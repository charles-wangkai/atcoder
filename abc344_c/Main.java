import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int M = sc.nextInt();
    int[] B = new int[M];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }
    int L = sc.nextInt();
    int[] C = new int[L];
    for (int i = 0; i < C.length; ++i) {
      C[i] = sc.nextInt();
    }
    int Q = sc.nextInt();
    int[] X = new int[Q];
    for (int i = 0; i < X.length; ++i) {
      X[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, C, X));

    sc.close();
  }

  static String solve(int[] A, int[] B, int[] C, int[] X) {
    Set<Integer> sums = new HashSet<>();
    for (int a : A) {
      for (int b : B) {
        for (int c : C) {
          sums.add(a + b + c);
        }
      }
    }

    return Arrays.stream(X)
        .mapToObj(Xi -> sums.contains(Xi) ? "Yes" : "No")
        .collect(Collectors.joining("\n"));
  }
}