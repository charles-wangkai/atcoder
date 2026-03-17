import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int L = sc.nextInt();
    int R = sc.nextInt();

    System.out.println(solve(N, L, R));

    sc.close();
  }

  static String solve(int N, int L, int R) {
    int[] result = IntStream.rangeClosed(1, N).toArray();
    for (int i = L - 1, j = R - 1; i < j; ++i, --j) {
      int temp = result[i];
      result[i] = result[j];
      result[j] = temp;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}