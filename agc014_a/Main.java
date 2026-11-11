import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();

    System.out.println(solve(A, B, C));

    sc.close();
  }

  static int solve(int A, int B, int C) {
    int result = 0;
    int[] values = IntStream.of(A, B, C).sorted().toArray();
    while (Arrays.stream(values).allMatch(x -> x % 2 == 0)) {
      int[] nextValues =
          IntStream.of(
                  values[1] / 2 + values[2] / 2,
                  values[2] / 2 + values[0] / 2,
                  values[0] / 2 + values[1] / 2)
              .sorted()
              .toArray();
      if (Arrays.equals(nextValues, values)) {
        return -1;
      }

      ++result;
      values = nextValues;
    }

    return result;
  }
}