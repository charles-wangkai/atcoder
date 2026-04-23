import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] s = new int[M];
    int[] c = new int[M];
    for (int i = 0; i < M; ++i) {
      s[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(N, s, c));

    sc.close();
  }

  static int solve(int N, int[] s, int[] c) {
    int result = 0;
    while (true) {
      int[] digits = String.valueOf(result).chars().map(x -> x - '0').toArray();
      if (digits.length > N) {
        return -1;
      }
      if (digits.length == N
          && IntStream.range(0, s.length).allMatch(i -> digits[s[i] - 1] == c[i])) {
        return result;
      }

      ++result;
    }
  }
}