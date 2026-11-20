import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();

      System.out.println(solve(N));
    }
  }

  static String solve(int N) {
    int[] result = new int[N];
    for (int x = 1; x * x <= N; ++x) {
      for (int y = 1; y * y <= N; ++y) {
        for (int z = 1; z * z <= N; ++z) {
          int sum = x * x + y * y + z * z + x * y + y * z + z * x;
          if (sum <= N) {
            ++result[sum - 1];
          }
        }
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}