import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static long solve(int[] A) {
    int avg = (int) (Arrays.stream(A).asLongStream().sum() / A.length);

    return Math.max(
        Arrays.stream(A).map(Ai -> Math.max(0, avg - Ai)).asLongStream().sum(),
        Arrays.stream(A).map(Ai -> Math.max(0, Ai - (avg + 1))).asLongStream().sum());
  }
}