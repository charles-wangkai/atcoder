import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] P = new int[N];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }
    int[] Q = new int[N];
    for (int i = 0; i < Q.length; ++i) {
      Q[i] = sc.nextInt();
    }

    System.out.println(solve(P, Q));

    sc.close();
  }

  static int solve(int[] P, int[] Q) {
    int N = P.length;

    return search(P, Q, IntStream.rangeClosed(1, N).toArray(), 0);
  }

  static int search(int[] P, int[] Q, int[] permutation, int index) {
    if (index == permutation.length) {
      return (compare(permutation, P) > 0 && compare(permutation, Q) < 0) ? 1 : 0;
    }

    int result = 0;
    for (int i = index; i < permutation.length; ++i) {
      swap(permutation, i, index);
      result += search(P, Q, permutation, index + 1);
      swap(permutation, i, index);
    }

    return result;
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }

  static int compare(int[] a, int[] b) {
    return IntStream.range(0, a.length)
        .map(i -> Integer.compare(a[i], b[i]))
        .filter(cmp -> cmp != 0)
        .findFirst()
        .orElse(0);
  }
}