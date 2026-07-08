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
        .map(
            i ->
                IntStream.range(0, i).filter(j -> A[j] > A[i]).max().stream()
                    .map(j -> j + 1)
                    .findAny()
                    .orElse(-1))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}