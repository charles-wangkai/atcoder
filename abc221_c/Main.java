import java.util.Arrays;
import java.util.Comparator;
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

  static int solve(int N) {
    int[] digits =
        String.valueOf(N)
            .chars()
            .map(c -> c - '0')
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    int result = -1;
    for (int mask = 1; mask < (1 << digits.length) - 1; ++mask) {
      int mask_ = mask;
      int[] indices1 =
          IntStream.range(0, digits.length).filter(i -> ((mask_ >> i) & 1) == 1).toArray();
      int[] indices2 =
          IntStream.range(0, digits.length).filter(i -> ((mask_ >> i) & 1) == 0).toArray();
      if (digits[indices1[0]] != 0 && digits[indices2[0]] != 0) {
        result = Math.max(result, toValue(digits, indices1) * toValue(digits, indices2));
      }
    }

    return result;
  }

  static int toValue(int[] digits, int[] indices) {
    return Integer.parseInt(
        Arrays.stream(indices)
            .map(index -> digits[index])
            .mapToObj(String::valueOf)
            .collect(Collectors.joining()));
  }
}