import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();

    System.out.println(solve(K));

    sc.close();
  }

  static long solve(int K) {
    long result = 0;
    for (int i = 0; i < K; ++i) {
      result = findNext(result);
    }

    return result;
  }

  static long findNext(long x) {
    int[] digits = String.valueOf(x).chars().map(c -> c - '0').toArray();

    int index = digits.length - 1;
    while (index != -1
        && (digits[index] == 9 || (index >= 1 && digits[index] == digits[index - 1] + 1))) {
      --index;
    }

    if (index == -1) {
      return Long.parseLong("1" + "0".repeat(digits.length));
    }

    ++digits[index];
    for (int i = index + 1; i < digits.length; ++i) {
      digits[i] = Math.max(0, digits[i - 1] - 1);
    }

    return Long.parseLong(
        Arrays.stream(digits).mapToObj(String::valueOf).collect(Collectors.joining()));
  }
}