import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();

    System.out.println(solve(K));

    sc.close();
  }

  static long solve(int K) {
    int[] digits = IntStream.range(0, 10).map(i -> 9 - i).toArray();
    long[] values =
        IntStream.range(1, 1 << digits.length)
            .mapToLong(
                mask ->
                    Long.parseLong(
                        IntStream.range(0, digits.length)
                            .filter(i -> ((mask >> i) & 1) == 1)
                            .map(i -> digits[i])
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining())))
            .filter(x -> x != 0)
            .sorted()
            .toArray();

    return values[K - 1];
  }
}