import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] A = new int[5];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] A) {
    int[] diffIndices = IntStream.range(0, A.length).filter(i -> A[i] != i + 1).toArray();

    return diffIndices.length == 2 && diffIndices[0] + 1 == diffIndices[1];
  }
}