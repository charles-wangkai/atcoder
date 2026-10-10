import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] P = new int[N];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }

    System.out.println(solve(P));

    sc.close();
  }

  static String solve(int[] P) {
    int index = P.length - 1;
    while (P[index] > P[index - 1]) {
      --index;
    }

    int leftIndex = index - 1;
    while (index != P.length - 1 && P[index + 1] < P[leftIndex]) {
      ++index;
    }

    swap(P, leftIndex, index);

    for (int i = leftIndex + 1, j = P.length - 1; i < j; ++i, --j) {
      swap(P, i, j);
    }

    return Arrays.stream(P).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }
}