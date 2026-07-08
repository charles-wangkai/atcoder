import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

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

  static int solve(int[] A) {
    int result = -1;
    for (int remainder = 0; remainder < 2; ++remainder) {
      int remainder_ = remainder;
      int[] values = Arrays.stream(A).filter(x -> x % 2 == remainder_).toArray();
      if (values.length >= 2) {
        result =
            Math.max(
                result,
                Arrays.stream(values)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .limit(2)
                    .mapToInt(Integer::intValue)
                    .sum());
      }
    }

    return result;
  }
}