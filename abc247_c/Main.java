import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    int[] result = {};
    for (int i = 1; i <= N; ++i) {
      result =
          IntStream.concat(
                  IntStream.concat(Arrays.stream(result), IntStream.of(i)), Arrays.stream(result))
              .toArray();
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}