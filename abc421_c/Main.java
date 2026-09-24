import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static long solve(String S) {
    int[] indices = IntStream.range(0, S.length()).filter(i -> S.charAt(i) == 'A').toArray();

    return Math.min(computeOperationNum(indices, 0), computeOperationNum(indices, 1));
  }

  static long computeOperationNum(int[] indices, int offset) {
    return IntStream.range(0, indices.length)
        .map(i -> Math.abs(indices[i] - (i * 2 + offset)))
        .asLongStream()
        .sum();
  }
}