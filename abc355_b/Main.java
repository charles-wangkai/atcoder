import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] B = new int[M];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] A, int[] B) {
    int[] C = IntStream.concat(Arrays.stream(A), Arrays.stream(B)).sorted().toArray();
    Set<Integer> aSet = Arrays.stream(A).boxed().collect(Collectors.toSet());

    return IntStream.range(0, C.length - 1)
        .anyMatch(i -> aSet.contains(C[i]) && aSet.contains(C[i + 1]));
  }
}