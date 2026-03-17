import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
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

  static String solve(int[] A) {
    return IntStream.range(0, A.length)
        .boxed()
        .sorted(Comparator.comparing(i -> A[i]))
        .map(i -> i + 1)
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}