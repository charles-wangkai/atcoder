import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int[] TARGET = {4, 5, 6};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[][] A = new int[3][6];
    for (int i = 0; i < A.length; ++i) {
      for (int j = 0; j < A[i].length; ++j) {
        A[i][j] = sc.nextInt();
      }
    }

    System.out.println("%.9f".formatted(solve(A)));

    sc.close();
  }

  static double solve(int[][] A) {
    int total = 0;
    int count = 0;
    for (int a0 : A[0]) {
      for (int a1 : A[1]) {
        for (int a2 : A[2]) {
          ++total;
          if (Arrays.equals(IntStream.of(a0, a1, a2).sorted().toArray(), TARGET)) {
            ++count;
          }
        }
      }
    }

    return (double) count / total;
  }
}