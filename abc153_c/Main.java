import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] H = new int[N];
    for (int i = 0; i < H.length; ++i) {
      H[i] = sc.nextInt();
    }

    System.out.println(solve(H, K));

    sc.close();
  }

  static long solve(int[] H, int K) {
    return Arrays.stream(H)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .skip(K)
        .mapToInt(Integer::intValue)
        .asLongStream()
        .sum();
  }
}