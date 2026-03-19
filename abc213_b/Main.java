import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

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

  static int solve(int[] A) {
    return IntStream.range(0, A.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> A[i]).reversed())
            .skip(1)
            .findFirst()
            .get()
        + 1;
  }
}